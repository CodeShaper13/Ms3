package com.codeshaper.ms3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.Nullable;

/**
 * Class to manage the application properties that are saved in the
 * settings.properties file.
 * 
 * @author CodeShaper
 */
public class Ms3Properties {

	private File propertyFile;
	private Properties props;

	private boolean showWarning = true;
	private boolean promptDownload = true;

	public Ms3Properties() {
		this.propertyFile = new File(Ms3.dirManager.getInternalFolder(), "settings.properties");
		this.props = new Properties();

		this.load();
	}

	private void load() {
		try {
			this.propertyFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}

		if (this.propertyFile.exists()) {
			try (FileInputStream fs = new FileInputStream(this.propertyFile)) {
				this.props.load(fs);

				this.showWarning = func((String) this.props.get("showWarning"), true);
				this.promptDownload = func((String) this.props.get("promptDownload"), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean func(@Nullable String s, boolean defaultValue) {
		if (s == null) {
			return defaultValue;
		} else {
			return s.equals("true");
		}
	}

	/**
	 * Saves all of the properties, writing them to a file.
	 */
	private void save() {
		try (FileOutputStream fs = new FileOutputStream(this.propertyFile)) {
			this.props.setProperty("showWarning", String.valueOf(this.showWarning));
			this.props.setProperty("promptDownload", String.valueOf(this.promptDownload));
			this.props.store(new FileOutputStream(this.propertyFile), "COMMENTS");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return The showWarning property.
	 */
	public boolean showWarning() {
		return this.showWarning;
	}

	/**
	 * @return The promptDownload property.
	 */
	public boolean promptDownload() {
		return true; // this.promptDownload; // Debug until gui works
	}

	/**
	 * Sets the showWarning property and saves the config file.
	 */
	public void setShowWarning(boolean showWarning) {
		boolean save = (this.showWarning != showWarning);
		this.showWarning = showWarning;
		if (save) {
			this.save();
		}
	}

	/**
	 * Sets the promptDownload property and save the config file.
	 */
	public void setPromptDownload(boolean promptDownload) {
		boolean save = (this.promptDownload != promptDownload);
		this.promptDownload = promptDownload;
		if (save) {
			this.save();
		}
	}
}
