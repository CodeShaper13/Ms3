package com.codeshaper.ms3.script;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.python.core.Py;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.exception;
import com.codeshaper.ms3.api.exception.MissingScriptException;

import net.minecraft.nbt.NBTTagCompound;

public class PythonScript {
	
	protected final File scriptFile;
	
	public PythonScript(String pathToScript) {
		// Assume the extension if it is not there.
		if (!pathToScript.endsWith(".py")) {
			pathToScript += ".py";
		}
		
		this.scriptFile = new File(Ms3.dirManager.getScriptFolder(), pathToScript);
	}
	
	public PythonScript(NBTTagCompound tag) {
		this.scriptFile = new File(tag.getString("path"));
	}

	/**
	 * Returns the script file. Note, the file may not exist, so use
	 * {@link RunnableScript#exists()} to verify.
	 */
	public File getFile() {
		return this.scriptFile;
	}

	/**
	 * Returns the name of the script file, without an extension.
	 */
	public String getScriptName() {
		return FilenameUtils.removeExtension(this.scriptFile.getName());
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
			throw exception.instance.new MissingScriptException("Script file is not of type .py",
					this.scriptFile.getPath());
		}
	}
}
