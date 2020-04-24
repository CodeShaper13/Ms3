package com.codeshaper.ms3.interpreter;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.Nullable;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.python.core.Py;
import org.python.core.PyBoolean;
import org.python.core.PyClass;
import org.python.core.PyException;
import org.python.core.PyFloat;
import org.python.core.PyInteger;
import org.python.core.PyList;
import org.python.core.PyLong;
import org.python.core.PyNone;
import org.python.core.PyObject;
import org.python.core.PySequenceList;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.core.PyType;
import org.python.util.PythonInterpreter;

import com.codeshaper.ms3.EnumCallbackType;
import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.BoundObject;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.executor;
import com.codeshaper.ms3.api.world;
import com.codeshaper.ms3.exception.InvalidReturnedArgumentException;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.stream.ChatErrorStream;
import com.codeshaper.ms3.stream.ChatOutputStream;
import com.codeshaper.ms3.util.Assert;
import com.codeshaper.ms3.util.Logger;
import com.codeshaper.ms3.util.MessageUtil;
import com.codeshaper.ms3.util.textBuilder.TextBuilder;
import com.codeshaper.ms3.util.textBuilder.TextBuilderTrans;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;

public class PyInterpreter {

	/** The name of the default interpreter. */
	public static final String DEFAULT_NAME = "default";

	// Save the original streams in case we want to go back to using them.
	private PyObject consoleStdIn;
	private PyObject consoleStdOut;
	private PyObject consoleStdErr;

	/** The name of the interpreter. */
	private String interpreterName;
	private PythonInterpreter pythonInterpreter;

	/**
	 * Creates a new interpreter.
	 *
	 * @param interpreterName The name of the interpreter.
	 */
	public PyInterpreter(String interpreterName) {
		this.interpreterName = interpreterName;
		this.pythonInterpreter = new PythonInterpreter();
		this.consoleStdIn = this.pythonInterpreter.getSystemState().stdin;
		this.consoleStdOut = this.pythonInterpreter.getSystemState().stdout;
		this.consoleStdErr = this.pythonInterpreter.getSystemState().stderr;

		if (Ms3.configManager.getUseMcForOut()) {
			this.setStdOut(true);
		}
		if (Ms3.configManager.getUseMcForErr()) {
			this.setStdErr(true);
		}
		if (Ms3.configManager.getUseMcForIn()) {
			// TODO
		}

		// Add to the sys.path so scripts can find other scripts in the /scripts folder.
		PySystemState systemState = Py.getSystemState();
		systemState.path.add(Ms3.dirManager.getScriptFolder().getAbsolutePath());

		// Add the path to the site-packages folder in the Python install directory.
		// If no Python path is specified, then nothing is added and no big deal.
		// This is only if you want to reference libraries such a pygame.
		String pythonPath = Ms3.configManager.getPythonPath();
		if (pythonPath != null) {
			systemState.path.add(pythonPath + "\\Lib\\site-packages");
		}
	}

	/**
	 * Gets the name of the interpreter.
	 */
	public String getName() {
		return this.interpreterName;
	}

	/**
	 * Calls a function within the global namespace. No checks are in place if this
	 * function actually exists.
	 *
	 * @param functionName The name of the function.
	 * @param args         The arguments to pass into the functions.
	 * @return The object the function returns, or None if it returns nothing.
	 */
	public PyObject callFunction(String functionName, @Nullable PyObject... args) {
		PyObject function = this.getVariable(functionName);
		if (function != null) { // Prevent null pointer exception.
			PyObject returnedValue = function.__call__(args != null ? args : new PyObject[0]);
			return returnedValue;
		}
		return Py.None;
	}

	/**
	 * Checks if a variable is defined in the global scope.
	 *
	 * @return true if the variable is defined.
	 */
	public boolean exists(String name) {
		return this.getVariable(name) != null;
	}

	/**
	 * Check if a function is defined in the global scope. This will return false if
	 * a variable with the passed name exists, but is not callable.
	 * 
	 * @param name The name of the functions.
	 * @return True if the function exists, false if it doesn't.
	 */
	public boolean functionExists(String name) {
		return this.getVariable(name).isCallable();
	}

	/**
	 * Gets a variable from the global namespace and returns it.
	 * 
	 * @param name The variables name.
	 */
	@Nullable
	public PyObject getVariable(String name) {
		return this.pythonInterpreter.get(name);
	}

	/**
	 * Sets the value of a variable in the global scope.
	 * 
	 * @param name The name of the variable.
	 * @param value The value of the variable.
	 */
	public void setVariable(String name, PyObject value) {
		this.pythonInterpreter.set(name, value);
	}

	/**
	 * Deletes a variable from the global scope.
	 *
	 * @param name Name of the variable.
	 * @return True if the variable was found and deleted, false if it couldn't be
	 *         found.
	 */
	public boolean delIfExists(String name) {
		if (this.exists(name)) {
			this.pythonInterpreter.exec("del " + name); // TODO make faster.
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Executes a single string of code.
	 * 
	 * @param code
	 * @return True if the code ran without error, false otherwise.
	 * @throws PyException If there was an error running the code.
	 */
	public boolean executeLine(String code) throws PyException {
		try {
			this.pythonInterpreter.exec(code);
			return true;
		} catch (PyException exception) {
			throw exception;
		}
	}

	public void setStdOut(boolean useMcChat) {
		if (useMcChat) {
			this.pythonInterpreter.setOut(new ChatOutputStream());
		} else {
			this.pythonInterpreter.setOut(this.consoleStdOut);
		}
	}

	public void setStdErr(boolean useMcChat) {
		if (useMcChat) {
			this.pythonInterpreter.setErr(new ChatErrorStream());
		} else {
			this.pythonInterpreter.setErr(this.consoleStdErr);
		}
	}

	/**
	 * Runs a script on the interpreter to load it's functions into the namespace.
	 * This is called before running the event functions like execute()
	 *
	 * @param runnableScript
	 * @throws PyException if there was an error running the script, including a
	 *                     syntax error.
	 */
	public void primeScript(RunnableScript runnableScript) throws PyException {
		// Cleanup the old functions.
		this.delIfExists("execute");
		this.delIfExists("getArgs");

		// Sets sys.argv to the arguments to pass in.
		PyList args = runnableScript.getArgs();
		// Empty strings are added to the end of args sometimes by the Minecraft command
		// parser, remove these.
		args.removeAll(Collections.singleton(""));
		this.pythonInterpreter.getSystemState().argv = args;

		//TODO should i follow this https://stackoverflow.com/questions/51715687/passing-parameters-from-java-to-python-using-jython
		this.pythonInterpreter.execfile(runnableScript.getFile().getAbsolutePath());
	}
}
