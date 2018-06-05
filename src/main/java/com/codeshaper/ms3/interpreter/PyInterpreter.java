package com.codeshaper.ms3.interpreter;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.python.core.Py;
import org.python.core.PyBoolean;
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

	/**
	 * The name of the default interpreter. Only exist for unused version with
	 * multiple interpreters.
	 */
	public static final String DEFAULT_NAME = "default";

	// Save the original streams in case we want to go back to using them.
	@SuppressWarnings("unused")
	private PyObject consoleStdIn;
	private PyObject consoleStdOut;
	private PyObject consoleStdErr;

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

		// Add to the sys.path so we can find stuff.
		PySystemState pss = Py.getSystemState();
		pss.path.add(Ms3.dirManager.getScriptFolder().getAbsolutePath());

		// Add the path to site-packages, if the path to Python is set in the config.
		String pythonPath = Ms3.configManager.getPythonPath();
		if (StringUtils.isBlank(pythonPath)) {
			pss.path.add(pythonPath + "\\Lib\\site-packages");
		}
	}

	/**
	 * Gets the name of the interpreter.
	 * 
	 * @return The name.
	 */
	public String getName() {
		return this.interpreterName;
	}

	/**
	 * Tries to run the execute function in a script.
	 * 
	 * @param runnableScript
	 * @param sender
	 * @return False if no function can be found, thus it was not run.
	 * @throws CommandException
	 */
	public boolean runExecute(RunnableScript runnableScript, ICommandSender sender) throws CommandException {
		try {
			this.primeScript(runnableScript);

			executor.Executor e = new executor.Executor(sender);
			if (!this.callFunction("execute", e.getSenderWorld(), e)) {
				return false;
			}
		} catch (PyException e) {
			MessageUtil.sendErrorMessage(sender, "Error calling execute()", e);
		}
		return true;
	}

	/**
	 * Runs the getArgs function in a script if it exists and returns the next arg
	 * to auto complete.
	 * 
	 * @param runnableScript
	 * @param sender
	 * @return An object representing the returned value, either a single string or
	 *         an array of strings.
	 * @throws InvalidReturnedArgumentException
	 *             If one of the values is not a string or sequence containing
	 *             strings, or None.
	 */
	@Nullable
	public String[] runGetArgs(RunnableScript runnableScript, ICommandSender sender)
			throws InvalidReturnedArgumentException {
		try {
			this.primeScript(runnableScript);
			// pysystemstate.add_classdir

			PyObject function = this.pythonInterpreter.get("getArgs");
			if (function != null) {
				executor.Executor e = new executor.Executor(sender);
				PyObject result = function.__call__(e.getSenderWorld(), e);

				// Make sure the returned type is valid, throw an exception if it is not.
				if (result instanceof PyString || result instanceof PyInteger || result instanceof PyLong
						|| result instanceof PyFloat || result instanceof PyBoolean) {
					return new String[] { result.toString() };
				} else if (result instanceof PyNone) {
					return null;
				} else if (result instanceof PySequenceList) {
					PySequenceList list = (PySequenceList) result;
					String[] returnValue = new String[list.size()];

					// Validate all elements are strings, and add them to the return list.
					for (int i = 0; i < list.size(); i++) {
						if (!(list.get(i) instanceof String)) {
							throw new InvalidReturnedArgumentException(result,
									"Returned sequence contains a non-string element.");
						}
						returnValue[i] = (String) list.get(i);
					}
					return returnValue;
				} else {
					throw new InvalidReturnedArgumentException(result,
							"Object is not of a valid type (bool, string, int, long, float, tuple, list or None).");
				}
			}
		} catch (PyException e) {
			MessageUtil.sendErrorMessage(sender, "Error calling getArgs()", e);
		}
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
		try {
			this.primeScript(runnableScript);
			this.callFunction("onBind", new world.World((WorldServer) sender.getEntityWorld()),
					entity.getWrapperClassForEntity(e));
			return true;
		} catch (PyException exception) {
			MessageUtil.sendErrorMessage(sender, "Error calling onBind()", exception);
			return false;
		}
	}

	/**
	 * Gets the doc string from a script and returns it to provide the help text for
	 * a script.
	 * 
	 * @param runnableScript
	 * @param sender
	 */
	public void runHelp(RunnableScript runnableScript, ICommandSender sender) {
		final String NAME = "__doc__";
		try {
			this.primeScript(runnableScript);
			PyObject docString = this.pythonInterpreter.get(NAME);
			if (docString != Py.None) {
				if (docString instanceof PyString) {
					sender.sendMessage(new TextBuilderTrans("commands.script.helpTextHeader").bold()
							.color(TextFormatting.GREEN).get());
					sender.sendMessage(new TextBuilder(docString.toString()).color(TextFormatting.GREEN).get());
					this.pythonInterpreter.set(NAME, Py.None);
				} else {
					MessageUtil.sendErrorMessage(sender, "__doc__ attribute is not of type string!");
				}
			} else {
				sender.sendMessage(
						new TextBuilderTrans("commands.script.noHelpText").bold().color(TextFormatting.GREEN).get());
			}
		} catch (PyException exception) {
			MessageUtil.sendErrorMessage(sender, "Error getting __doc__ attribute()", exception);
		}
	}

	public void runOnClick(RunnableScript runnableScript, Entity entity, EntityPlayer player) {
		try {
			this.primeScript(runnableScript);
			this.callFunction("onClick", new world.World((WorldServer) player.getEntityWorld()),
					com.codeshaper.ms3.api.entity.getWrapperClassForEntity(entity),
					com.codeshaper.ms3.api.entity.getWrapperClassForEntity(player));
		} catch (PyException e) {
			MessageUtil.sendErrorMessage(player, "Error calling onClick()", e);
		}
	}
	
	public void runObjectCallback(Collection<BoundObject> collection, EnumCallbackType type, Object... args) {
		try {
			for (BoundObject obj : collection) {
				switch (type) {
				case ON_CONSTRUCT:
					obj.onConstruct();
					break;
				case ON_TICK:
					obj.onTick();
					break;
				case ON_LOAD:
					obj.onLoad();
					break;
				case ON_SAVE:
					obj.onSave();
					break;
				case ON_CLICK:
					obj.onClick(entity.getWrapperClassForEntity((Entity) args[0]), (entity.Player) entity.getWrapperClassForEntity((Entity) (args[1])));
					break;
				}
			}
		} catch (PyException e) {
			MessageUtil.sendErrorMessageToAll("Error calling " + type.getName() + "()", e);
		}
	}

	/**
	 * Calls a function within the global namespace if it can be found.
	 * 
	 * @param functionName
	 *            The name of the function.
	 * @param args
	 * @return True if the function was found and called, false otherwise.
	 */
	private boolean callFunction(String functionName, PyObject... args) {
		PyObject function = this.pythonInterpreter.get(functionName);
		if (function != null) {
			@SuppressWarnings("unused")
			PyObject returnValue = function.__call__(args);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if a variable is defined in the global scope.
	 * 
	 * @return true if the variable is defined.
	 */
	public boolean exists(String name) {
		return this.pythonInterpreter.get(name) != null;
	}

	/**
	 * Deletes a variable from the global scope.
	 * 
	 * @param name
	 *            Name of the variable.
	 * @return True if the variable was found and deleted, false otherwise.
	 */
	public boolean delIfExists(String name) {
		if (this.exists(name)) {
			this.pythonInterpreter.exec("del " + name); // TODO make faster.
			return true;
		} else {
			return false;
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
	 * Runs a script to load the functions into the namespace.
	 * 
	 * @param runnableScript
	 * @throws PyException
	 *             if there was an error running the script, including a syntax
	 *             error.
	 */
	private void primeScript(RunnableScript runnableScript) throws PyException {
		// Cleanup the old functions.
		this.delIfExists("onBind");
		this.delIfExists("execute");
		this.delIfExists("onClick");
		this.delIfExists("getArgs");

		// Sets sys.argv to the arguments to pass in.
		PyList args = runnableScript.getArgs();
		// Empty strings are added to the end of args sometimes by the Minecraft command
		// parser, remove these.
		args.removeAll(Collections.singleton(""));
		this.pythonInterpreter.getSystemState().argv = args;

		this.pythonInterpreter.execfile(runnableScript.getFile().getAbsolutePath());
	}
}
