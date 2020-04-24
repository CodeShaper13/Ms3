package com.codeshaper.ms3.command;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.interpreter.PyInterpreterManager;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

@Deprecated
public class CommandInterpreter extends CommandBase {

	/**
     * Get the name of the command
     */
    @Override
	public String getName() {
        return "interpreter";
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
        return "commands.interpreter.usage";
    }

    /**
     * Called when a CommandSender executes this command
     */
    @Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
    	if(args.length > 1) {
    		PyInterpreterManager interpreterManager = Ms3.instance.interpreterManager;
    		
    		if(args[2].equals("create")) {
    			if(args.length >= 2) {
    				boolean created = interpreterManager.newInterpreter(args[0]);
    				if(created) {
    					CommandBase.notifyCommandListener(sender, this, "commands.interpreter.createdOk", new Object[] {args[0]});
            		} else {
            			throw new CommandException("commands.interpreter.createdError", args[0]);
            		}
    			}
    		} else if(args[2].equals("delete")) {
    			if(args.length >= 2) {
    				if(args[0].equals("default")) {
    					throw new CommandException("commands.interpreter.deleteDefaultError", PyInterpreter.DEFAULT_NAME);
    				}
    				boolean flag = interpreterManager.deleteInterpreter(args[0]);
    				if(flag) {
    					CommandBase.notifyCommandListener(sender, this, "commands.interpreter.deletedOk", new Object[] {args[0]});
    				} else {
    					throw new CommandException("commands.interpreter.deletedError", args[0]);
    				}
    			}
    		} else if(args[2].equals("config")) {
    			// Validate args.
    			if((args.length == 4) && (args[2].equals("stdin") || args[2].equals("stdout") || args[2].equals("stderr")) && (args[3].equals("console") || args[3].equals("mcChat"))) {
					PyInterpreter i = interpreterManager.getInterpreter(args[1]);
					if(i != null) {
						boolean useMcChat = args[3].equals("mcChat");
						//if(args[2].equals("stdin")) {
						//	i.setStdIn(useMcChat);
						//} else
						if(args[2].equals("stdout")) {
							i.setStdOut(useMcChat);
						} else if(args[2].equals("stderr")) {
							i.setStdErr(useMcChat);
						}
						CommandBase.notifyCommandListener(sender, this, "commands.interpreter.configSuccess", new Object[] {args[0], args[2], args[3]}); //interpreter name, stream set, newValue
					} else {
						throw new CommandException("commands.interpreter.interpreterNotFound", args[0]); // name we tried to use.
					}
    			} else {
    				throw new CommandException("commands.interpreter.usageConfig", args[0]);
    			}
    		} else {
    			throw new WrongUsageException("commands.interpreter.usage", new Object[0]);
    		}
    	} else {
            throw new WrongUsageException("commands.interpreter.usage", new Object[0]);
    	}
    }

    @Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
    	if(args.length == 1) {
    		return CommandBase.getListOfStringsMatchingLastWord(args, Ms3.instance.interpreterManager.getAllInterpreterNames());
    	}
    	else if(args.length == 2) {
    		return CommandBase.getListOfStringsMatchingLastWord(args, new String[] {"create", "delete", "config"});
    	}
    	else if(args[1].equals("config")) {
    		if(args.length == 3) {
        		return CommandBase.getListOfStringsMatchingLastWord(args, new String[] {"stdin", "stdout", "stderr"});
    		} else if(args.length == 4) {
        		return CommandBase.getListOfStringsMatchingLastWord(args, new String[] {"default", "mcChat"});
    		}
    	}
        return Collections.emptyList();
    }
}
