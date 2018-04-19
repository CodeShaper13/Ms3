package com.codeshaper.ms3.script;

import java.io.File;
import java.util.Collections;

import javax.annotation.Nullable;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyList;
import org.python.core.PyString;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.exception;
import com.codeshaper.ms3.util.NbtHelper;
import com.codeshaper.ms3.util.Util;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Represents a script and it's arguments that can be run at a later time.
 */
public class RunnableScript {

	private File scriptFile;
	private PyList scriptArgs;

	public RunnableScript(String pathToScript, @Nullable String[] args) throws PyException {
		this(pathToScript, args != null ? RunnableScript.stringArgsToPyType(args) : null);
	}
	
	/**
	 * @param pathToScript
	 *            Path from the scripts folder to the file. If there is no
	 *            extension, .py is assumed.
	 * @param args
	 * @throws PyException If {@code args} contains an invalid data type.
	 */
	public RunnableScript(String pathToScript, @Nullable PyList args) throws PyException {
		// Assume the extension if it is not there.
		if (!pathToScript.endsWith(".py")) {
			pathToScript += ".py";
		}

		this.scriptFile = new File(Ms3.dirManager.getScriptFolder(), pathToScript);

		// Validate that the args and throw an exception if they are not of the correct
		// type.
		if (args != null) {
			Object obj;
			for (int i = 0; i < args.size(); i++) {
				obj = args.get(i);
				System.out.println(obj + " " + obj.getClass());
				if (!(obj instanceof String || obj instanceof Boolean || obj instanceof Integer
						|| obj instanceof Double)) {
					throw Py.ValueError("args must all be of type string, boolean, int or float!");
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
		this.scriptFile = new File(Ms3.dirManager.getScriptFolder(), tag.getString("path"));
		this.scriptArgs = new PyList();
		
		Integer i = 0;
		NBTTagCompound compound  = tag.getCompoundTag("args");
		while (true) {
			String key = i.toString();
			if(compound.hasKey(key)) {
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
	 * Returns the script file.  Note, the file may not exist, so use {@link RunnableScript#exists()} to verify.
	 */
	public File getFile() {
		return this.scriptFile;
	}
	
	public String getScriptName() {
		return FilenameUtils.removeExtension(this.scriptFile.getName());
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
	 * @throws exception.MissingScriptException
	 *             If the script can't be found in the event of the file being
	 *             moved/deleted or if the file is not in a valid format.
	 */
	public void tryThrowMissingScript() throws exception.MissingScriptException {
		if (!this.exists()) {
			throw Py.ValueError("Script with name " + this.scriptFile.toString()
					+ " could not be found!  Was it moved, renamed or deleted?");
		}
		String fileName = this.scriptFile.getName();

		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (!(extension.equalsIgnoreCase("py"))) {
			throw exception.instance.new MissingScriptException("Script file is not of type .py", this.scriptFile.getPath());
		}
	}

	public NBTTagCompound writeToNbt() {
		NBTTagCompound tag = new NBTTagCompound();

		tag.setString("path", this.scriptFile.getPath());

		// Write args to NBT.
		NBTTagCompound compound = new NBTTagCompound();
		Integer i = 0;
		for(Object obj : this.scriptArgs) {
			compound.setTag(i.toString(), NbtHelper.objToNbt(obj));
			i++;
		}
		tag.setTag("args", compound);

		return tag;
	}

	private static PyList stringArgsToPyType(String[] args) {
		PyList list = new PyList();
		for (String s : args) {
			list.add(Util.stringToPyObject(s));
		}

		// Empty strings are added to the end of args sometimes from commands, remove
		// these.
		list.removeAll(Collections.singleton(""));

		return list;
	}
}
