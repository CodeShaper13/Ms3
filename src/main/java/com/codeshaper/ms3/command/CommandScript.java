package com.codeshaper.ms3.command;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.io.FileUtils;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.entity.Base;
import com.codeshaper.ms3.capability.AttachedScript;
import com.codeshaper.ms3.capability.AttachedScriptList;
import com.codeshaper.ms3.capability.EntityMs3DataProvider;
import com.codeshaper.ms3.capability.IEntityMs3Data;
import com.codeshaper.ms3.exception.InvalidReturnedArgumentException;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.util.NewScriptHelper;
import com.codeshaper.ms3.util.Util;
import com.codeshaper.ms3.util.textBuilder.TextBuilder;
import com.codeshaper.ms3.util.textBuilder.TextBuilderTrans;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class CommandScript extends CommandBase {

	/**
	 * Get the name of the command
	 */
	@Override
	public String getName() {
		return "script";
	}

	/**
	 * Return the required permission level for this command.
	 */
	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return this.ranByHostPlayer(sender) ? "commands.script.usage" : "commands.script.usageRemoteClient";
	}

	/**
	 * Called when a CommandSender executes this command
	 */
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 2) {
			if (args.length >= 1 && args[0].equals("run")) {
				throw new WrongUsageException(this.ranByHostPlayer(sender) ? "commands.script.usageRun"
						: "commands.script.usageRunRemoteClient");
			} else {
				throw new WrongUsageException(this.getUsage(sender));
			}
		} else {
			String scriptName = args[1];

			File scriptFile = new File(Ms3.dirManager.getScriptFolder(), scriptName);

			if (args[0].equals("run")) {
				/*
				 * Runs the script.
				 */
				String[] scriptArgs = args.length > 2 ? Arrays.copyOfRange(args, 2, args.length) : null;
				RunnableScript rs = new RunnableScript(scriptName, scriptArgs);
				if (!rs.exists()) {
					throw new CommandException("commands.scriptNotFound", scriptName);
				}
				if (!rs.runExecuteFunction(Ms3.getDefaultInterpreter(), sender)) {
					throw new CommandException("commands.script.noExecuteFunction");
				}
			} else if (args[0].equals("new")) {
				/*
				 * Creates a new script file and fills it with the default contents.
				 */
				if (!scriptName.endsWith(".py")) {
					scriptName += ".py";
				}
				File newScriptFile = new File(Ms3.dirManager.getScriptFolder(), scriptName);
				if (newScriptFile.exists()) {
					throw new CommandException("commands.script.alreadyExists", newScriptFile.getName());
				} else {
					try {
						newScriptFile.createNewFile();

						NewScriptHelper.writeToFile(newScriptFile);

						CommandBase.notifyCommandListener(sender, this, "commands.script.createFileSuccess");
					} catch (IOException | SecurityException e) {
						throw new CommandException("commands.script.createFileError", e.getMessage());
					}
				}
			} else if (args[0].equals("edit")) {
				/*
				 * Open the script in the file editor defined by the operating system.
				 */
				if (this.ranByHostPlayer(sender)) {
					try {
						Desktop.getDesktop().edit(scriptFile);
					} catch (IOException e) {
						throw new CommandException("commands.script.errorEdit", scriptName);
					}
				} else {
					throw new CommandException("commands.script.ranByInvalidError", "edit");
				}
			} else if (args[0].equals("about")) {
				/*
				 * Print info about the script.
				 */
				try {
					BasicFileAttributes attributes = Files.readAttributes(scriptFile.toPath(),
							BasicFileAttributes.class);
					final TextFormatting color = TextFormatting.YELLOW;
					sender.sendMessage(new TextBuilderTrans("commands.script.about0", scriptName).color(color).get());
					sender.sendMessage(new TextBuilderTrans("commands.script.about1", scriptFile.getAbsolutePath())
							.color(color).get());
					sender.sendMessage(
							new TextBuilderTrans("commands.script.about2", attributes.size()).color(color).get());
					sender.sendMessage(
							new TextBuilderTrans("commands.script.about3", attributes.creationTime().toString())
									.color(color).get());
					sender.sendMessage(
							new TextBuilderTrans("commands.script.about4", attributes.lastModifiedTime().toString())
									.color(color).get());
				} catch (IOException e) {
					throw new CommandException("commands.script.aboutError", scriptName);
				}
			} else if (args[0].equals("openLocation")) {
				/*
				 * Open the location for the script file in the File Explorer.
				 */
				if (this.ranByHostPlayer(sender)) {
					try {
						Desktop.getDesktop().open(scriptFile.getParentFile());
					} catch (IOException e) {
						throw new CommandException("commands.script.openLocationError", scriptName);
					}
				} else {
					throw new CommandException("commands.script.ranByInvalidError", "openLocation");
				}
			} else if (args[0].equals("help")) {
				/*
				 * Show the help text that the script provides.
				 */
				PyInterpreter interpreter = Ms3.getDefaultInterpreter();
				RunnableScript rs = new RunnableScript(scriptName,
						args.length > 2 ? Arrays.copyOfRange(args, 2, args.length) : null);
				if (!rs.exists()) {
					throw new CommandException("commands.scriptNotFound", scriptName);
				}
				rs.printDocString(interpreter, sender);
			} else if (args[0].equals("reload")) {
				/*
				 * Reload script(s).
				 */
				sender.sendMessage(new TextBuilder("Started Reloading Scripts...").get());

				IEntityMs3Data capData;
				for (Entity e : sender.getEntityWorld().loadedEntityList) {
					if (Util.validEntityForMs3Data(e)) {
						capData = this.getCapability(e);

						for (AttachedScript as : capData.getScriptList()) {
							RunnableScript rs = as.getLocation();

							// Have the script write it's data to the properties list.
							as.getInstance().onSave();

							// Remove the old script instance.
							capData.removeBoundScript(rs);

							// Add a new instance of the script to the entity.
							capData.addBoundScript(entity.getWrapperClassForEntity(e), rs);

							// Have the script read it's properties
							capData.getBoundScript(rs).getInstance().onLoad();
						}
					}
				}

				sender.sendMessage(new TextBuilder("Finished Reloading Scripts").get());
			} else {
				throw new WrongUsageException(this.getUsage(sender));
			}
		}
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			@Nullable BlockPos pos) {
		if (args.length == 1) {
			String[] array = this.ranByHostPlayer(sender)
					? new String[] { "run", "edit", "new", "about", "openLocation", "help", "reload" }
					: new String[] { "run", "about", "help" };
			return CommandBase.getListOfStringsMatchingLastWord(args, array);
		} else if (args.length == 2 && !args[0].equals("new")) {
			return CommandBase.getListOfStringsMatchingLastWord(args, this.getAllScripts());
		} else if (args.length >= 3 && args[0].equals("run")) {
			String scriptName = args[1];
			File scriptFile = new File(Ms3.dirManager.getScriptFolder(), scriptName);

			if (!scriptFile.exists()) {
				CommandBase.notifyCommandListener(sender, this, "commands.scriptNotFound", scriptName);
			}

			PyInterpreter interpreter = Ms3.getDefaultInterpreter();

			try {
				RunnableScript rs = new RunnableScript(scriptName,
						args.length > 2 ? Arrays.copyOfRange(args, 2, args.length) : null);
				if (rs.exists()) {
					String[] result = rs.runGetArgsFunction(interpreter, sender);
					if (result != null) {
						return CommandBase.getListOfStringsMatchingLastWord(args, result);
					}
					// Null means don't hint anything.
				}
			} catch (InvalidReturnedArgumentException e) {
				sender.sendMessage(new TextBuilder("Error calling getArgs()").color(TextFormatting.RED).get());
				e.printStackTrace();
			}
		}

		return Collections.emptyList();
	}

	/**
	 * Checks if the command sender is a player, and that the player is the one
	 * hosting the world.
	 */
	private boolean ranByHostPlayer(ICommandSender sender) {
		Entity e = sender.getCommandSenderEntity();
		if (e != null && e instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) e;
			player.getName().equals(FMLCommonHandler.instance().getMinecraftServerInstance().getServerOwner());
			return true;
		}
		return false;
	}

	public IEntityMs3Data getCapability(Entity entity) {
		return entity.getCapability(EntityMs3DataProvider.ENTITY_MS3_DATA_CAP, null);
	}
	
	/**
	 * @return A String[] of all the script file names in the scripts folder, with
	 *         extension.
	 */
	protected String[] getAllScripts() {
		ArrayList<File> scripts = new ArrayList<File>(
				FileUtils.listFiles(Ms3.dirManager.getScriptFolder(), new String[] { "py" }, true));

		// Remove init files if the config says so.
		if (Ms3.configManager.hideInitFiles()) {
			Iterator<File> iter = scripts.iterator();
			while (iter.hasNext()) {
				if (iter.next().getName().startsWith("__init__")) {
					iter.remove();
				}
			}
		}

		String[] s = new String[scripts.size()];
		int j = Ms3.dirManager.getScriptFolder().getAbsolutePath().length() + 1;
		for (int i = 0; i < scripts.size(); i++) {
			s[i] = scripts.get(i).getAbsolutePath().substring(j);
		}
		return s;
	}

}