package com.codeshaper.ms3;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * Manages the config file and provides getters to check the config values.
 * 
 * @author CodeShaper
 */
public class Config {
	public static final String NULL_PY_PATH = "NONE";

	private boolean useMcForIn;
	private boolean useMcForOut;
	private boolean useMcForErr;
	/**
	 * The path to the installed python, null if it couldn't be found. If this was
	 * set in the config, this may not point to a valid or even existing directory
	 */
	private String pythonPath;
	private boolean alwaysRebuild;
	private boolean hideInitFiles;
	// TODO packet system to send errors and exceptions to players?
	private boolean seeGlobalErrors;

	public Config(File configFile) {
		Configuration config = new Configuration(configFile);
		config.load();

		this.alwaysRebuild = config.getBoolean("Always rebuild api", Configuration.CATEGORY_GENERAL, false,
				"When TRUE, the python api files are generated on every startup.");
		this.useMcForErr = config.getBoolean("Use custom stderr", Configuration.CATEGORY_GENERAL, true,
				"When TRUE, print goes to the MC chat, when FALSE, text is printed to the launcher console.");
		this.useMcForOut = config.getBoolean("Use custom stdout", Configuration.CATEGORY_GENERAL, true,
				"When TRUE, you can use the MC chat, when FALSE, input must be typed in the launcher console.");
		this.useMcForIn = config.getBoolean("Use custom stdin", Configuration.CATEGORY_GENERAL, true,
				"When TRUE, print goes to the MC chat, when FALSE, text is printed to the launcher console.");

		this.pythonPath = config.getString("Python path", Configuration.CATEGORY_GENERAL, "",
				"Path to the installed Python location, for adding the site-packages directory.  Example: \"C:\\Python27\"");
		this.hideInitFiles = config.getBoolean("Hide __init__ files", Configuration.CATEGORY_GENERAL, true,
				"When TRUE, __init__.py files will not show up in any auto complete.  When FALSE, they show up.");
		this.seeGlobalErrors = config.getBoolean("See global errors", Configuration.CATEGORY_GENERAL, true,
				"When TRUE, you will see error messages that are sent to all players.  When FALSE they are hidden.");

		// Not needed, as the API is not dynamically created with third party mods.
		// this.alwaysRebuild = config.getBoolean("Always Rebuild",
		// Configuration.CATEGORY_GENERAL, false, "When TRUE, the api is always rebuilt
		// on startup.");

		config.save();
	}

	public boolean getUseMcForIn() {
		return this.useMcForIn;
	}

	public boolean getUseMcForOut() {
		return this.useMcForOut;
	}

	public boolean getUseMcForErr() {
		return this.useMcForErr;
	}

	public String getPythonPath() {
		return this.pythonPath;
	}

	public boolean getAlwaysRebuild() {
		return this.alwaysRebuild;
	}

	/**
	 * Returns {@code true} if __init__.py files should be hidden when commands
	 * bring up lists of files.
	 */
	public boolean hideInitFiles() {
		return hideInitFiles;
	}
}