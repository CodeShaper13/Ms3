package com.codeshaper.ms3.command;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import org.python.core.PyException;

import com.codeshaper.ms3.MS3;
import com.codeshaper.ms3.api.exception.missingScriptException;
import com.codeshaper.ms3.bindScriptAction.Action;
import com.codeshaper.ms3.bindScriptAction.BindScriptAction;
import com.codeshaper.ms3.script.RunnableScript;

import java.util.Arrays;
import java.util.Collections;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class CommandBindScript extends CommandScript {

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
		Entity e = sender.getCommandSenderEntity();
		if (!(e instanceof EntityPlayer)) {
			throw new CommandException("commands.bindScript.onlyByPlayer");
		}
		
		if(args.length >= 1 && args[0].equals("check")) {
			this.func(e, new BindScriptAction(Action.CHECK));
			this.notifyCommandListener(sender, this, "commands.bindScript.useStickCheck");
		}
		else if (args.length < 2 || !(args[0].equals("add") || args[0].equals("remove"))) {
			throw new WrongUsageException("commands.bindScript.usage");
		}
		else {
			EntityPlayer player = (EntityPlayer) e;

			RunnableScript rs = new RunnableScript(args[1],
					args.length > 1 ? Arrays.copyOfRange(args, 2, args.length) : null);

			boolean flag = args[0].equals("add");
			this.func(e, new BindScriptAction(rs, flag ? Action.ADD : Action.REMOVE));
			this.notifyCommandListener(sender, this, flag ? "commands.bindScript.useStickAdd" : "commands.bindScript.useStickRemove");
		}
	}
	
	private void func(Entity e, BindScriptAction action) {
		EntityPlayer player = (EntityPlayer) e;
		MS3.players.put(player.getUniqueID(), action);

	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			@Nullable BlockPos pos) {
		if (args.length == 1) {
			return this.getListOfStringsMatchingLastWord(args, "add", "remove", "check");
		} else if (args.length == 2 && (args[0].equals("add") || args[0].equals("remove"))) {
			return this.getListOfStringsMatchingLastWord(args, this.getAllScripts());
		} else {
			return Collections.emptyList();
		}
	}
}
