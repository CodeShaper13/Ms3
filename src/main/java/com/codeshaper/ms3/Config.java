package com.codeshaper.ms3;

import java.io.File;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

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
		//this.seeGlobalErrors = config.getBoolean("See global errors", Configuration.CATEGORY_GENERAL, true,
		//		"When TRUE, you will see error messages that are sent to all players.  When FALSE they are hidden.");

		config.save();
	}

	/**
	 * Returns {@code true} if the interpreters input stream should be mapped to the
	 * Minecraft chat.
	 */
	public boolean getUseMcForIn() {
		return this.useMcForIn;
	}

	/**
	 * Returns {@code true} if the interpreters output stream should be mapped to
	 * the Minecraft chat.
	 */
	public boolean getUseMcForOut() {
		return this.useMcForOut;
	}

	/**
	 * Returns {@code true} if the interpreters error stream should be mapped to the
	 * Minecraft chat.
	 */
	public boolean getUseMcForErr() {
		return this.useMcForErr;
	}

	/**
	 * Returns the path to the Python install directory. This might look like
	 * {@code C:\\Python27}. If the path is not set in the config, the default, null
	 * is returned. Note that the returned path may not point to a real directory.
	 */
	@Nullable
	public String getPythonPath() {
		if (StringUtils.isBlank(this.pythonPath)) {
			return null;
		} else {
			return this.pythonPath;
		}
	}

	/**
	 * Returns {@code true} if the Python API files should always be built on
	 * startup.
	 */
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