package com.codeshaper.ms3;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * Loads and reads from the config file.
 */
public class Config {
	public static final String NULL_PY_PATH = "NONE";
	
	private boolean useMcForIn;
	private boolean useMcForOut;
	private boolean useMcForErr;
	/**
	 * The path to the installed python, null if it couldn't be found.  If this was
	 * set in the config, this may not point to a valid or even existing directory
	 */
	private String pythonPath;
	private boolean alwaysRebuild;
	
	public Config(File configFile) {
		Configuration config = new Configuration(configFile);
		config.load();
				
		this.useMcForErr = config.getBoolean("Use Custom stderr", Configuration.CATEGORY_GENERAL, true, "When TRUE, print goes to the MC chat, when FALSE, text is printed to the launcher console.");
		this.useMcForOut = config.getBoolean("Use Custom stdout", Configuration.CATEGORY_GENERAL, true, "When TRUE, you can use the MC chat, when FALSE, input must be typed in the launcher console.");
		this.useMcForIn = config.getBoolean("Use Custom stdin", Configuration.CATEGORY_GENERAL, true, "When TRUE, print goes to the MC chat, when FALSE, text is printed to the launcher console.");

		this.pythonPath = config.getString("Python path", Configuration.CATEGORY_GENERAL, "", "Path to the installed Python location, for adding the site-packages directory.  Example: \"C:\\Python27\"");
		
		// Not needed, as the API is not dynamically created with third party mods.
		//this.alwaysRebuild = config.getBoolean("Always Rebuild", Configuration.CATEGORY_GENERAL, false, "When TRUE, the api is always rebuilt on startup.");
		
		config.save();
	}
	
	public boolean getUseMcForIn() {
		return useMcForIn;
	}

	public boolean getUseMcForOut() {
		return useMcForOut;
	}

	public boolean getUseMcForErr() {
		return useMcForErr;
	}

	public String getPythonPath() {
		return pythonPath;
	}

	public boolean getAlwaysRebuild() {
		return alwaysRebuild;
	}
}
