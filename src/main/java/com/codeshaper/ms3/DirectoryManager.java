package com.codeshaper.ms3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.codeshaper.ms3.util.Logger;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Manages the various folders and files that Ms3 uses, creating config files
 * and startup scripts, among other things.
 */
public class DirectoryManager {

	private File dotMinecraftDir;
	private File ms3Folder;
	private File scriptFolder;
	private File compiledScriptFolder;
	private File apiFolder;
	private File internalFolder;
	private File scriptDataFolder;

	public DirectoryManager(FMLPreInitializationEvent event) {
		// Reference to the folder.
		this.dotMinecraftDir = event.getModConfigurationDirectory().getParentFile();

		// Folders:
		this.ms3Folder = this.createFolder(this.dotMinecraftDir, Ms3.MOD_ID);
		this.scriptFolder = this.createFolder(this.ms3Folder, "scripts");
		this.compiledScriptFolder = this.createFolder(this.ms3Folder, ".compiledScripts");
		this.apiFolder = new File(this.ms3Folder, "api-" + Ms3.API_VERSION);
		this.internalFolder = this.createFolder(this.ms3Folder, ".internal");
		this.scriptDataFolder = this.createFolder(this.ms3Folder, "scriptData");

		this.createObfuscatedWarningFile();
	}

	private void createObfuscatedWarningFile() {
		File f = new File(this.compiledScriptFolder, "WARNING.txt");
		if (!f.exists()) {
			try {
				BufferedWriter br = new BufferedWriter(new FileWriter(f));
				br.write("NOTICE!");
				br.write("This folder is used by Ms3 when compiling scripts, don't edit the contents!");
				br.close();
				f.createNewFile();
			} catch (IOException e) {
				Logger.err("Unable to create compiled warning document!");
			}
		}
	}

	/**
	 * Helper method to make a folder if it doesn't already exist.
	 * 
	 * @param rootFolder The folder to place the new folder in.
	 * @param folderName The folder name.
	 * @return The (possibly new) folder.
	 */
	private File createFolder(File rootFolder, String folderName) {
		File f = new File(rootFolder, "/" + folderName);
		f.mkdirs();
		return f;
	}

	/**
	 * @return The .miencraft directory.
	 */
	public File getDotMinecraftDir() {
		return this.dotMinecraftDir;
	}

	/**
	 * @return The Ms3 folder within the .minecraft directory.
	 */
	public File getMs3Folder() {
		return this.ms3Folder;
	}

	/**
	 * @return The scripts folder that all of the scripts should be placed in.
	 */
	public File getScriptFolder() {
		return this.scriptFolder;
	}

	public File getCompiledScriptFolder() {
		return this.compiledScriptFolder;
	}

	/**
	 * @return The folder to place the generated Python API files in. The name of
	 *         this folder contains the API version as specified in
	 *         {@link Ms3#API_VERSION}.
	 */
	public File getApiFolder() {
		return this.apiFolder;
	}

	/**
	 * @return The internal folder that is intended for internal data only and not
	 *         to be used by players.
	 */
	public File getInternalFolder() {
		return this.internalFolder;
	}

	public File getScriptDataFolder() {
		return this.scriptDataFolder;
	}
}
