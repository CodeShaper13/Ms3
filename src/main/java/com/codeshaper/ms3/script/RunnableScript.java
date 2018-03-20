package com.codeshaper.ms3.script;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Nullable;

import org.apache.commons.lang3.math.NumberUtils;
import org.python.core.Py;
import org.python.core.PyBoolean;
import org.python.core.PyException;
import org.python.core.PyFloat;
import org.python.core.PyInteger;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PySequenceList;
import org.python.core.PyString;
import org.python.modules._csv.PyDialect.doublequote_descriptor;

import com.codeshaper.ms3.MS3;
import com.codeshaper.ms3.api.exception;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

/**
 * Represents a script and it's arguments that can be run at a later time.
 */
public class RunnableScript {

	protected File scriptFile;
	protected PyList scriptArgs;

	public RunnableScript(String pathToScript, @Nullable String[] args) throws PyException {		
		this(pathToScript, args != null ? stringArgsToPyType(args) : null);
	}

	/**
	 * @param pathToScript is the path from the scripts folder.
	 */
	public RunnableScript(String pathToScript, @Nullable PyList args) throws PyException {

		// Assume the extension.
		if (!pathToScript.endsWith(".py")) {
			pathToScript += ".py";
		}

		this.scriptFile = new File(MS3.dirManager.scriptFolder, pathToScript);
		
		// Validate that the args and throw an exception if they are not of the correct type.
		if (args != null) {
			Object obj;
			for (int i = 0; i < args.size(); i++) {
				obj = args.get(i);
				System.out.println(obj + " " + obj.getClass());
				if (!(obj instanceof String || obj instanceof Boolean || obj instanceof Integer || obj instanceof Double)) {
					throw Py.ValueError("args must all be of type string, boolean, int or float!");
				}
			}
			this.scriptArgs = args;

		} else {
			this.scriptArgs = new PyList();
		}
	}

	public RunnableScript(NBTTagCompound tag) {
		this.scriptFile = new File(tag.getString("path"));

		NBTTagList list = tag.getTagList("args", 8);
		this.scriptArgs = new PyList();
		for (int i = 0; i < list.tagCount(); i++) {
			NBTBase tagBase = list.get(i);
			if(tagBase instanceof NBTTagString) {
				this.scriptArgs.add(i, ((NBTTagString) tagBase).getString());
			} else if(tagBase instanceof NBTTagByte) {
				this.scriptArgs.add(i, ((NBTTagByte) tagBase).getByte() == 1);
			} else if(tagBase instanceof NBTTagInt) {
				this.scriptArgs.add(i, ((NBTTagInt) tagBase).getInt());
			} else if(tagBase instanceof NBTTagDouble) {
				this.scriptArgs.add(i, ((NBTTagDouble) tagBase).getDouble());
			} else {
				throw new Error();
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
	 * Returns the script file. Note, the file may not exist.
	 */
	public File getFile() {
		return this.scriptFile;
	}

	public PyList getArgs() {
		return this.scriptArgs;
	}
	
	/**
	 * Checks if the RunnableScript refers to a real file on the hard drive.
	 */
	public boolean exists() {
		return this.scriptFile.exists();
	}

	/**
	 * Checks if the RunnableScript refers to an actual file and is of type .py.
	 * 
	 * @throws exception.missingScriptException
	 *             If the script can't be found in the event of the file being
	 *             moved/deleted or if the file is not in a valid format.
	 */
	public void tryThrowMissingScript() throws exception.missingScriptException {
		String scriptPath = this.scriptFile.getPath();
		if (!this.exists()) {
			throw exception.instance.new missingScriptException("Script with name " + this.scriptFile.toString()
					+ " could not be found!  Was it moved, renamed or deleted?", scriptPath);
		}
		String fileName = this.scriptFile.getName();

		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (!(extension.equalsIgnoreCase("py"))) {
			throw exception.instance.new missingScriptException("Script file is not of type .py", scriptPath);
		}
	}

	public NBTTagCompound writeToNbt() {
		NBTTagCompound tag = new NBTTagCompound();

		tag.setString("path", scriptFile.getPath());

		// Write args to NBT.
		NBTTagList argList = new NBTTagList();
		Object obj;
		for(int i = 0; i < this.scriptArgs.size(); i++) {
			obj = this.scriptArgs.get(i);
			if(obj instanceof String) {
				argList.appendTag(new NBTTagString((String)obj));
			} else if(obj instanceof Boolean) {
				argList.appendTag(new NBTTagByte(((Boolean)obj) == true ? (byte)1 : 0));
			} else if(obj instanceof Integer) {
				argList.appendTag(new NBTTagInt((Integer)obj));
			} else if(obj instanceof Float) {
				argList.appendTag(new NBTTagDouble((Float)obj));
			} else {
				throw new Error("Invalid type for args, " + obj.getClass());
			}
		}
		tag.setTag("args", argList);

		return tag;
	}

	private static PyList stringArgsToPyType(String[] args) {
		PyList list = new PyList();

		for (int i = 0; i < args.length; i++) {
			if (NumberUtils.isCreatable(args[i])) {
				float f = NumberUtils.createFloat(args[i]);
				if (f == ((int) f)) {
					list.add((int) f);
				} else {
					list.add(f);
				}
			} else if (args[i].toLowerCase().equals("true")) {
				list.add(true);
			} else if (args[i].toLowerCase().equals("false")) {
				list.add(false);
			} else {
				list.add(args[i]);
			}
		}

		// Empty strings are added to the end of args sometimes from cammonds, remove
		// these.
		list.removeAll(Collections.singleton(""));

		return list;
	}
}
