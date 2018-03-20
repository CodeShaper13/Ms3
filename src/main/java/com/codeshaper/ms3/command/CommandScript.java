package com.codeshaper.ms3.command;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.io.FileUtils;

import com.codeshaper.ms3.MS3;
import com.codeshaper.ms3.exception.InvalidReturnedArgumentException;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.util.NewScriptHelper;
import com.codeshaper.ms3.util.Util;

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
			if (args[0].equals("run")) {
				throw new WrongUsageException(this.ranByHostPlayer(sender) ? "commands.script.usageRun"
						: "commands.script.usageRunRemoteClient");
			} else {
				throw new WrongUsageException(this.getUsage(sender));
			}
		} else {
			String scriptName = args[1];

			File scriptFile = new File(MS3.dirManager.scriptFolder, scriptName);

			if (args[0].equals("run")) {
				RunnableScript rs = new RunnableScript(scriptName,
						args.length > 2 ? Arrays.copyOfRange(args, 2, args.length) : null);
				if (!rs.exists()) {
					throw new CommandException("commands.scriptNotFound", scriptName);
				}
				if(!MS3.getInterpreter().runExecute(rs, sender)) {
					throw new CommandException("commands.script.noExecuteFunction");
				}
			} else if (args[0].equals("new")) {
				if (!scriptName.endsWith(".py")) {
					scriptName += ".py";
				}
				File newScriptFile = new File(MS3.dirManager.scriptFolder, scriptName);
				if (newScriptFile.exists()) {
					throw new CommandException("commands.script.alreadyExists", newScriptFile.getName());
				} else {
					try {
						newScriptFile.createNewFile();

						NewScriptHelper.writeImports(newScriptFile, true);
						NewScriptHelper.writeExecute(newScriptFile);
						NewScriptHelper.writeGetArgs(newScriptFile);
						NewScriptHelper.writeGetHelpText(newScriptFile);

						this.notifyCommandListener(sender, this, "commands.script.createFileSuccess");
					} catch (IOException | SecurityException e) {
						throw new CommandException("commands.script.createFileError", e.getMessage());
					}
				}
			} else if (args[0].equals("edit")) {
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
				try {
					BasicFileAttributes a = Files.readAttributes(scriptFile.toPath(), BasicFileAttributes.class);
					this.notifyCommandListener(sender, this, "commands.script.about0", scriptName);
					this.notifyCommandListener(sender, this, "commands.script.about1", scriptFile.getAbsolutePath());
					this.notifyCommandListener(sender, this, "commands.script.about2", a.size());
					this.notifyCommandListener(sender, this, "commands.script.about3", a.creationTime().toString());
					this.notifyCommandListener(sender, this, "commands.script.about4", a.lastModifiedTime().toString());
				} catch (IOException e) {
					throw new CommandException("commands.script.aboutError", scriptName);
				}
			} else if (args[0].equals("openLocation")) {
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
				PyInterpreter interpreter = MS3.getInterpreter();
				RunnableScript rs = new RunnableScript(scriptName,
						args.length > 2 ? Arrays.copyOfRange(args, 2, args.length) : null);
				if (!rs.exists()) {
					throw new CommandException("commands.scriptNotFound", scriptName);
				}
				interpreter.runHelp(rs, sender);
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
					? new String[] { "run", "edit", "new", "about", "openLocation", "help" }
					: new String[] { "run", "about", "help" };
			return this.getListOfStringsMatchingLastWord(args, array);
		} else if (args.length == 2 && !args[0].equals("new")) {
			return this.getListOfStringsMatchingLastWord(args, this.getAllScripts());
		} else if (args.length >= 3 && args[0].equals("run")) {
			String scriptName = args[1];
			File scriptFile = new File(MS3.dirManager.scriptFolder, scriptName);

			if (!scriptFile.exists()) {
				this.notifyCommandListener(sender, this, "commands.scriptNotFound", scriptName);
			}

			PyInterpreter interpreter = MS3.getInterpreter();

			try {
				RunnableScript rs = new RunnableScript(scriptName,
						args.length > 2 ? Arrays.copyOfRange(args, 2, args.length) : null);
				if (rs.exists()) {
					String[] results = interpreter.runGetArgs(rs, sender);
					if (results != null) {
						return getListOfStringsMatchingLastWord(args, results);
					}
				}
			} catch (InvalidReturnedArgumentException e) {
				sender.sendMessage(Util.withColor("Error calling getArgs()", TextFormatting.RED));
				e.printStackTrace();
			}
		}

		return Collections.emptyList();
	}

	/**
	 * Checks if the command sender is a player, and that player is hosting the
	 * world.
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

	/**
	 * @return A String[] of all the script file names in the scripts folder, with
	 *         extension.
	 */
	protected String[] getAllScripts() {
		ArrayList<File> scripts = new ArrayList<File>(
				FileUtils.listFiles(MS3.dirManager.scriptFolder, new String[] { "py" }, true));
		String[] s = new String[scripts.size()];
		int j = MS3.dirManager.scriptFolder.getAbsolutePath().length() + 1;
		for (int i = 0; i < scripts.size(); i++) {
			s[i] = scripts.get(i).getAbsolutePath().substring(j);
		}
		return s;
	}
}