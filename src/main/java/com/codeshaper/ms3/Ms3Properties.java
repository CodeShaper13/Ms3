package com.codeshaper.ms3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Ms3Properties {

	private File file;
	private Properties props;

	private boolean showWarning = true;
	private boolean promptDownload = true;

	public Ms3Properties() {
		this.file = new File(Ms3.dirManager.getInternalFolder(), "settings.properties");
		this.props = new Properties();

		this.load();
	}

	private void load() {
		try {
			this.file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}

		if (this.file.exists()) {
			try (FileInputStream fs = new FileInputStream(this.file)) {
				this.props.load(fs);

				this.showWarning = func((String)this.props.get("showWarning"), true);
				this.promptDownload = func((String)this.props.get("promptDownload"), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean func(String s, boolean defaultValue) {
		if(s == null) {
			return defaultValue;
		} else {
			return s.equals("true");
		}
	}

	private void save() {
		try (FileOutputStream fs = new FileOutputStream(this.file)) {
			this.props.setProperty("showWarning", String.valueOf(this.showWarning));
			this.props.setProperty("promptDownload", String.valueOf(this.promptDownload));
			this.props.store(new FileOutputStream(this.file), "COMMENTS");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean showWarning() {
		return this.showWarning;
	}

	public boolean promptDownload() {
		return false; // this.promptDownload;  Debug until gui works
	}

	//TODO only save if value changes
	
	public void setShowWarning(boolean showWarning) {
		this.showWarning = showWarning;
		this.save();
	}

	public void setPromptDownload(boolean promptDownload) {
		this.promptDownload = promptDownload;
		this.save();
	}
}
