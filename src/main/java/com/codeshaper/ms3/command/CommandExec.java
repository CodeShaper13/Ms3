package com.codeshaper.ms3.command;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import org.python.core.PyException;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.util.MessageUtil;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class CommandExec extends CommandBase {

	/**
	 * Get the name of the command
	 */
	@Override
	public String getName() {
		return "exec";
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
		return "commands.exec.usage";
	}

	/**
	 * Called when a CommandSender executes this command
	 */
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1) {
			throw new WrongUsageException("commands.exec.usage");
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				sb.append(args[i]);
				sb.append(" ");
			}
			PyInterpreter interpreter = Ms3.getDefaultInterpreter();
			
			try {
				boolean noError = interpreter.executeLine(sb.toString());				
				if(noError) {
					CommandBase.notifyCommandListener(sender, this, "commands.exec.codeOk");
				}
			} catch(PyException exception) {
				MessageUtil.sendErrorMessage(sender, "Error calling execute()", exception);
			}
		}
	}

	/**
	 * Get a list of options for when the user presses the TAB key
	 */
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			@Nullable BlockPos pos) {
		if (args.length == 1) {
			return getListOfStringsMatchingLastWord(args, new String[] { "print 'Enter code'" });
		}
		return Collections.emptyList();
	}
}