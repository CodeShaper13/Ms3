package com.codeshaper.ms3.script;

import java.io.File;
import java.util.Collections;

import javax.annotation.Nullable;

import org.apache.commons.io.FilenameUtils;
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

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.exception;
import com.codeshaper.ms3.api.executor;
import com.codeshaper.ms3.exception.InvalidReturnedArgumentException;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.util.MessageUtil;
import com.codeshaper.ms3.util.NbtHelper;
import com.codeshaper.ms3.util.Util;
import com.codeshaper.ms3.util.textBuilder.TextBuilder;
import com.codeshaper.ms3.util.textBuilder.TextBuilderTrans;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;

/**
 * Represents a script and it's arguments that can be run at a later time.
 * 
 * @author CodeShaper
 */
public class RunnableScript extends PythonScript {

	private PyList scriptArgs;

	public RunnableScript(String pathToScript) {
		this(pathToScript, new PyList());
	}

	public RunnableScript(String pathToScript, @Nullable String[] args) throws PyException {
		this(pathToScript, args != null ? RunnableScript.stringArgsToPyType(args) : null);
	}

	/**
	 * @param pathToScript Path from the scripts folder to the file. If there is no
	 *                     extension, .py is assumed.
	 * @param args
	 * @throws PyException If {@code args} contains an invalid data type.
	 */
	public RunnableScript(String pathToScript, @Nullable PyList args) throws PyException {
		super(pathToScript);

		// Validate that the args are of the correct type.
		// If not, throw a Py.ValueError exception.
		if (args != null) {
			Object obj;
			for (int i = 0; i < args.size(); i++) {
				obj = args.get(i);
				if (!(obj instanceof String || obj instanceof Boolean || obj instanceof Integer
						|| obj instanceof Double)) {
					throw Py.ValueError("args must all be of type str, bool, int or float");
				}
			}
			this.scriptArgs = args;
		} else {
			this.scriptArgs = new PyList();
		}

		// Make the first arg the path to this script.
		this.scriptArgs.insert(0, new PyString(this.getFile().getAbsolutePath()));
	}

	public RunnableScript(NBTTagCompound tag) {
		super(tag);

		this.scriptArgs = new PyList();

		Integer i = 0;
		NBTTagCompound compound = tag.getCompoundTag("args");
		while (true) {
			String key = i.toString();
			if (compound.hasKey(key)) {
				this.scriptArgs.add(NbtHelper.nbtToObject(compound.getTag(key)));
				i++;
			} else {
				break;
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scriptArgs == null) ? 0 : scriptArgs.hashCode());
		result = prime * result + ((scriptFile == null) ? 0 : scriptFile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RunnableScript)) {
			return false;
		}
		RunnableScript other = (RunnableScript) obj;
		if (scriptArgs == null) {
			if (other.scriptArgs != null) {
				return false;
			}
		} else if (!scriptArgs.equals(other.scriptArgs)) {
			return false;
		}
		if (scriptFile == null) {
			if (other.scriptFile != null) {
				return false;
			}
		} else if (!scriptFile.equals(other.scriptFile)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the instance of the list containing the arguments of this
	 * RunnableScript.
	 */
	public PyList getArgs() {
		return this.scriptArgs;
	}

	public NBTTagCompound writeToNbt() {
		NBTTagCompound tag = new NBTTagCompound();

		tag.setString("path", this.scriptFile.getPath());

		// Write args to NBT.
		NBTTagCompound compound = new NBTTagCompound();
		Integer i = 0;
		for (Object obj : this.scriptArgs) {
			compound.setTag(i.toString(), NbtHelper.objToNbt(obj));
			i++;
		}
		tag.setTag("args", compound);

		return tag;
	}

	/**
	 * Run the execute function in a script if it exists.
	 *
	 * @param runnableScript
	 * @param sender
	 * @return False if no function can be found, thus it was not run.
	 * @throws CommandException
	 */
	public boolean runExecuteFunction(PyInterpreter interpreter, ICommandSender sender) throws CommandException {
		try {
			interpreter.primeScript(this);

			executor.Executor e = new executor.Executor(sender);
			if (!interpreter.callFunction("execute", e.getSenderWorld(), e)) {
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
	 * @return An array of options to suggest for tab auto complete, either a single
	 *         string or an array of strings. Null is returned if not options should
	 *         be presented.
	 * @throws InvalidReturnedArgumentException If one of the values is not one of
	 *                                          the following: a string, a sequence
	 *                                          containing strings, None.
	 */
	@Nullable
	public String[] runGetArgsFunction(PyInterpreter interpreter, ICommandSender sender)
			throws InvalidReturnedArgumentException {
		try {
			interpreter.primeScript(this);
			// pysystemstate.add_classdir

			PyObject function = interpreter.getVariable("getArgs");
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
	 * Gets the doc string from the script and prints it out to the passed sender.
	 *
	 * @param runnableScript
	 * @param sender
	 */
	public void printDocString(PyInterpreter interpreter, ICommandSender sender) {
		final String NAME = "__doc__";
		try {
			interpreter.primeScript(this);
			PyObject docString = interpreter.getVariable(NAME);
			if (docString != Py.None) {
				if (docString instanceof PyString) {
					sender.sendMessage(new TextBuilderTrans("commands.script.helpTextHeader").bold()
							.color(TextFormatting.GREEN).get());
					sender.sendMessage(new TextBuilder(docString.toString()).color(TextFormatting.GREEN).get());
					interpreter.setVariable(NAME, Py.None); // Reset the value of __doc__ so the next script won't
															// think it has this field.
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

	/**
	 * Converts an array of strings to an instance of {@link PyList} contanining
	 * {@link PyStrings}s. Empty strings will be removed from the list.
	 * 
	 * @param args
	 * @return
	 */
	private static PyList stringArgsToPyType(String[] args) {
		PyList list = new PyList();
		for (String s : args) {
			list.add(s);
		}

		// Empty strings are added to the end of args sometimes from commands, remove
		// these.
		list.removeAll(Collections.singleton(""));

		return list;
	}
}
