package com.codeshaper.ms3.interpreter;

import java.util.HashMap;

import javax.annotation.Nullable;

import org.python.util.PythonInterpreter;

import com.codeshaper.ms3.exception.InvalidReturnedArgumentException;
import com.codeshaper.ms3.script.RunnableScript;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PythonRunner {

	public PythonInterpreter interpreter;
	private HashMap<String, InterpreterState> states;
	
	public PythonRunner() {
		this.interpreter = new PythonInterpreter();
		this.states = new HashMap<>();		
	}
	
	/**
	 * Tries to run the execute function in a script.
	 * 
	 * @param runnableScript
	 * @param sender
	 * @return False if no function can be found, thus it was not run.
	 * @throws CommandException
	 *             If no execute function is found.
	 */
	public boolean runExecute(RunnableScript runnableScript, ICommandSender sender) throws CommandException {
		return true;
	}
	
	@Nullable
	/**
	 * @throws InvalidReturnedArgumentException
	 *             If one of the values is not a string or sequence containing
	 *             strings, or None.
	 */
	public String[] runGetArgs(RunnableScript rs, ICommandSender sender) throws InvalidReturnedArgumentException {
		return null;
	}
	
	/**
	 * Calls the onBind function, if there is one.
	 * 
	 * @param runnableScript
	 * @param sender
	 * @param e
	 * @return true if there was no error, otherwise false.
	 */
	public boolean runOnBind(RunnableScript runnableScript, ICommandSender sender, Entity e) {
		return true;
	}
	
	public void runHelp(RunnableScript runnableScript, ICommandSender sender) {
		
	}

	public void runOnClick(RunnableScript runnableScript, Entity e, EntityPlayer player) {
	
	}
}
