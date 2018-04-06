package com.codeshaper.ms3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.codeshaper.ms3.util.Logger;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Manages the various folders and files that Ms3 uses, creating
 * config files and startup scripts, among other things.
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
		this.dotMinecraftDir = event.getModConfigurationDirectory().getParentFile();
		
		// Folders:
    	this.ms3Folder = this.createFolder(this.dotMinecraftDir, Ms3.MOD_ID);
    	this.scriptFolder = this.createFolder(this.ms3Folder, "scripts");
    	this.compiledScriptFolder = this.createFolder(this.ms3Folder, ".compiledScripts");
    	this.apiFolder = new File(this.ms3Folder, "api-" + Ms3.VERSION);
    	this.internalFolder = this.createFolder(this.ms3Folder, ".internal");
    	this.scriptDataFolder = this.createFolder(this.ms3Folder, "scriptData");
    	    	
    	this.createObfuscatedWarningFile();
    }
	
	private void createObfuscatedWarningFile() {
		File f = new File(this.compiledScriptFolder, "WARNING.txt");
		if(!f.exists()) {
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
	 * Helper method to make a folder
	 */
	private File createFolder(File rootFolder, String folderName) {
		File f = new File(rootFolder, "/" + folderName);
		f.mkdirs();
		return f;
	}

	public File getDotMinecraftDir() {
		return dotMinecraftDir;
	}

	public File getMs3Folder() {
		return ms3Folder;
	}

	public File getScriptFolder() {
		return scriptFolder;
	}

	public File getCompiledScriptFolder() {
		return compiledScriptFolder;
	}

	public File getApiFolder() {
		return apiFolder;
	}

	public File getInternalFolder() {
		return internalFolder;
	}

	public File getScriptDataFolder() {
		return scriptDataFolder;
	}
}
