package com.codeshaper.ms3.interpreter;

import java.util.Collections;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyList;
import org.python.core.PyNone;
import org.python.core.PyObject;
import org.python.core.PySequenceList;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.core.__builtin__;
import org.python.util.PythonInterpreter;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.executor;
import com.codeshaper.ms3.api.world;
import com.codeshaper.ms3.exception.InvalidReturnedArgumentException;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.stream.ChatErrorStream;
import com.codeshaper.ms3.stream.ChatOutputStream;
import com.codeshaper.ms3.util.textBuilder.TextBuilder;
import com.codeshaper.ms3.util.textBuilder.TextBuilderTrans;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;

public class Interpreter {

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

	public Interpreter(String interpreterName) {
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

		// Add to the sys.path so we can find stuff.
		PySystemState pss = Py.getSystemState();
		pss.path.add(Ms3.dirManager.getScriptFolder().getAbsolutePath());

		// Add the path to site-packages, if the path to Python is set in the config.
		String pythonPath = Ms3.configManager.getPythonPath();
		if (StringUtils.isBlank(pythonPath)) {
			pss.path.add(pythonPath + "\\Lib\\site-packages");
		}
	}

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
	 *             If no execute function is found.
	 */
	public boolean runExecute(RunnableScript runnableScript, ICommandSender sender) throws CommandException {
		executor.Executor e = new executor.Executor(sender);
		return this.prefromBasicFunctionCall(runnableScript, "execute", sender, e.getSenderWorld(), e);
	}

	private boolean prefromBasicFunctionCall(RunnableScript runnableScript, String funcName, ICommandSender sender,
			PyObject... args) {
		PySystemState state = this.getNewState(runnableScript);

		try {
			PyObject function = this.getAttribute(state, null/*runnableScript.getModuleName()*/, funcName);
			function.__call__(args);
			return true;
		} catch (PyException exception) {
			this.senderErrorMessage(sender, "Error calling " + funcName + "()", exception);
			return false;
		} finally {
			state.close();
		}
	}

	@Nullable
	/**
	 * @throws InvalidReturnedArgumentException
	 *             If one of the values is not a string or sequence containing
	 *             strings, or None.
	 */
	public String[] runGetArgs(RunnableScript rs, ICommandSender sender) throws InvalidReturnedArgumentException {
		try {
			this.primeScript(rs);
			// pysystemstate.add_classdir

			PyObject function = this.pythonInterpreter.get("getArgs");
			if (function != null) {
				executor.Executor e = new executor.Executor(sender);
				PyObject result = function.__call__(e.getSenderWorld(), e);
				// Make sure the returned type is valid, throw an exception if it is not.
				if (result instanceof PySequenceList) {
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
				} else if (result instanceof PyString) {
					return new String[] { result.asString() };
				} else if (result instanceof PyNone) {
					return null;
				} else {
					throw new InvalidReturnedArgumentException(result,
							"Object is not of a valid type (string, tuple, list or None).");
				}
			}
		} catch (PyException e) {
			this.senderErrorMessage(sender, "Error calling getArgs()", e);
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
		return this.prefromBasicFunctionCall(runnableScript, "onBind", sender,
				new world.World((WorldServer) sender.getEntityWorld()), entity.getWrapperClassForEntity(e));
	}

	public void runHelp(RunnableScript runnableScript, ICommandSender sender) {
		PySystemState state = this.getNewState(runnableScript);

		final String NAME = "__doc__";
		try {
			PyObject docString = this.getAttribute(state, null/*runnableScript.getModuleName()*/, NAME);
			if (docString != Py.None) {
				if (docString instanceof PyString) {
					sender.sendMessage(new TextBuilderTrans("commands.script.helpTextHeader").bold()
							.color(TextFormatting.GREEN).get());
					sender.sendMessage(new TextBuilder(docString.toString()).color(TextFormatting.GREEN).get());
					this.pythonInterpreter.set(NAME, Py.None);
				} else {
					this.senderErrorMessage(sender, "__doc__ attribute is not of type string!");
				}
			} else {
				sender.sendMessage(
						new TextBuilderTrans("commands.script.noHelpText").bold().color(TextFormatting.GREEN).get());
			}
		} catch (PyException exception) {
			this.senderErrorMessage(sender, "Error calling execute()", exception);
		} finally {
			state.close();
		}
	}

	public void runOnClick(RunnableScript runnableScript, Entity e, EntityPlayer player) {
		try {
			this.primeScript(runnableScript);
			this.callFunction("onClick", new world.World((WorldServer) player.getEntityWorld()),
					entity.getWrapperClassForEntity(e), entity.getWrapperClassForEntity(player));
		} catch (PyException exception) {
			this.senderErrorMessage(player, "Error calling onClick()", exception);
		}
	}

	/**
	 * Calls a function within the global namespace if it can be found.
	 * 
	 * @param functionName
	 * @param args
	 * @return True if the function was found and called, false otherwise.
	 */
	@Deprecated
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
	 * Checks if a variable is defined.
	 * 
	 * @return true if the variable is defined.
	 */
	public boolean exists(String name) {
		return this.pythonInterpreter.get(name) != null;
	}

	public boolean delIfExists(String name) {
		if (this.exists(name)) {
			this.pythonInterpreter.exec("del " + name); // TODO make faster.
			return true;
		} else {
			return false;
		}
	}

	@Deprecated
	// WARNING This hasn't been tested in a while and most likely won't work
	public boolean runSingleLine(String command) {
		try {
			this.pythonInterpreter.exec(command);
			return true;
		} catch (PyException e) {
			e.printStackTrace();
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
	 * @return True if there were no errors.
	 */
	@Deprecated
	private void primeScript(RunnableScript rs) throws PyException {
		// Cleanup the old functions.
		this.delIfExists("onBind");
		this.delIfExists("execute");
		this.delIfExists("onClick");
		this.delIfExists("getArgs");

		PyList args = rs.getArgs();
		// Empty strings are added to the end of args sometimes, remove these.
		args.removeAll(Collections.singleton(""));
		this.pythonInterpreter.getSystemState().argv = args;

		this.pythonInterpreter.execfile(rs.getFile().getAbsolutePath());
	}

	private PySystemState getNewState(RunnableScript runnableScript) {
		PySystemState state = new PySystemState();
		// ((PyDictionary)state.path_importer_cache).clear();
		// ((PyStringMap)state.modules).clear();

		// state.path.add(Ms3.dirManager.getScriptFolder().getAbsolutePath());

		PyList args = runnableScript.getArgs();
		// Empty strings are added to the end of args sometimes, remove these.
		args.removeAll(Collections.singleton(""));
		state.argv = args;
		// this.pythonInterpreter.getSystemState().argv = args;

		return state;
	}

	private PyObject getAttribute(PySystemState state, String moduleName, String functionName) {
		PyObject importer = state.getBuiltins().__getitem__(new PyString("__import__"));
		PyObject module = importer.__call__(new PyString(moduleName));
		__builtin__.reload(module);
		return module.__getattr__(functionName);
	}

	private void senderErrorMessage(ICommandSender sender, String text) {
		sender.sendMessage(new TextBuilder(text).color(TextFormatting.RED).bold().get());
	}

	private void senderErrorMessage(ICommandSender sender, String text, Exception e) {
		this.senderErrorMessage(sender, text);
		e.printStackTrace();
	}
}