package com.codeshaper.ms3.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.bindScriptAction.BSAction;
import com.codeshaper.ms3.bindScriptAction.BindScriptAction;
import com.codeshaper.ms3.capability.EntityMs3DataProvider;
import com.codeshaper.ms3.script.RunnableScript;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

/**
 * Command used to set the current script to bind with the Script Binder item.
 *
 * @author CodeShaper
 */
public class CommandBindScript extends CommandScript { // Only extends to get the getAllScripts() method.

	/**
	 * Get the name of the command
	 */
	@Override
	public String getName() {
		return "bindscript";
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
		return "commands.bindScript.usage";
	}

	/**
	 * Called when a CommandSender executes this command
	 */
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		Entity cmdSender = sender.getCommandSenderEntity();

		// Players can only run this command!
		if (!(cmdSender instanceof EntityPlayer)) {
			throw new CommandException("commands.bindScript.onlyByPlayer");
		}

		boolean checkArg = args[0].equals("check");
		boolean clearArg = args[0].equals("clear");

		if (args.length >= 1 && (checkArg || clearArg)) {
			if (checkArg) {
				if (args.length == 1) {
					this.storeAction(cmdSender, new BindScriptAction(BSAction.CHECK));
					CommandBase.notifyCommandListener(sender, this, "commands.bindScript.useStickCheck");
				} else if (args.length == 2) {
					this.getCapability(getPlayer(server, sender, args[1])).getScriptList().func(sender);
				} else {
					throw new WrongUsageException("commands.bindScript.usageCheck");
				}
			}
			if (clearArg) {
				if (args.length == 1) {
					this.storeAction(cmdSender, new BindScriptAction(BSAction.CLEAR));
					CommandBase.notifyCommandListener(sender, this, "commands.bindScript.useStickClear");
				} else if (args.length == 2) {
					this.getCapability(getPlayer(server, sender, args[1])).getScriptList().removeAll();
				} else {
					throw new WrongUsageException("commands.bindScript.usageCheck");
				}
			}
		} else if (args.length < 2 || !(args[0].equals("add") || args[0].equals("remove"))) {
			throw new WrongUsageException("commands.bindScript.usage");
		} else {
			RunnableScript rs = new RunnableScript(args[1],
					args.length > 1 ? Arrays.copyOfRange(args, 2, args.length) : null);

			boolean flag = args[0].equals("add");
			this.storeAction(cmdSender, new BindScriptAction(rs, flag ? BSAction.ADD : BSAction.REMOVE));
			CommandBase.notifyCommandListener(sender, this,
					flag ? "commands.bindScript.useStickAdd" : "commands.bindScript.useStickRemove");
		}
	}

	/**
	 * Stores the passed action with the passed Player. This will replace the
	 * previous stored one.
	 * 
	 * @param cmdSender
	 * @param action
	 */
	private void storeAction(Entity cmdSender, BindScriptAction action) {
		EntityPlayer player = (EntityPlayer) cmdSender;
		Ms3.players.put(player.getUniqueID(), action);
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			@Nullable BlockPos pos) {
		if (args.length == 1) {
			return CommandBase.getListOfStringsMatchingLastWord(args, "add", "remove", "check", "clear");
		} else if (args.length == 2) {
			if (args[0].equals("add") || args[0].equals("remove")) {
				return CommandBase.getListOfStringsMatchingLastWord(args, this.getAllScripts());
			}
			if (args[0].equals("check") || args[0].equals("clear")) {
				return CommandBase.getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
			}
		}

		return Collections.emptyList();
	}
}
