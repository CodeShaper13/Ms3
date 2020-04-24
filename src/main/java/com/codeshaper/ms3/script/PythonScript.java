package com.codeshaper.ms3.script;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.python.core.Py;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.exception;
import com.codeshaper.ms3.api.exception.MissingScriptException;

import net.minecraft.nbt.NBTTagCompound;

/**
 * @author CodeShaper
 */
public class PythonScript {

	/** Reference the the script's file. This file may not exist. */
	protected final File scriptFile;

	/**
	 * @param pathToScript The path relative to the /scripts folder that is returned
	 *                     from {@link DirectoryManager#getScriptFolder()}
	 */
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
	 * Returns the file. Note, the file may not exist, so use
	 * {@link PythonScript#exists()} to verify.
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
	 * Checks if the script refers to a real file on the hard drive.
	 */
	public boolean exists() {
		return this.scriptFile.exists();
	}
}
