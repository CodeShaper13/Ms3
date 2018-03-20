package com.codeshaper.ms3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.codeshaper.ms3.util.Logger;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Manages the various folders and files that MS3 uses, creating
 * config files and startup scripts, among other things.
 */
public class DirectoryManager {
	
	public File dotMinecraftDir;
	
	public File ms3Folder;
	public File scriptFolder;
	public File compiledScriptFolder;
	public File apiFolder;
	public File internalFolder;
		
	public DirectoryManager(FMLPreInitializationEvent event) {
		this.dotMinecraftDir = event.getModConfigurationDirectory().getParentFile();
		
		// Folders:
    	this.ms3Folder = this.createFolder(this.dotMinecraftDir, "/" + MS3.MOD_ID);
    	this.scriptFolder = this.createFolder(this.ms3Folder, "/scripts");
    	this.compiledScriptFolder = this.createFolder(this.ms3Folder, "/.compiledScripts");
    	this.apiFolder = new File(this.ms3Folder, "/api-" + MS3.VERSION);
    	this.internalFolder = this.createFolder(this.ms3Folder, "/.internal");
    	    	
    	this.createObfuscatedWarningFile();
    }
	
	private void createObfuscatedWarningFile() {
		File f = new File(this.compiledScriptFolder, "WARNING.txt");
		if(!f.exists()) {
			try {
				BufferedWriter br = new BufferedWriter(new FileWriter(f));
				br.write("NOTICE!");
				br.write("This folder is used by MS3 when compiling scripts, don't edit the contents!");
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
		File f = new File(rootFolder, folderName);
		f.mkdirs();
		return f;
	}
}
