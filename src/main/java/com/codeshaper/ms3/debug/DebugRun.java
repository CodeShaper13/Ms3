package com.codeshaper.ms3.debug;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.apiBuilder.ApiBuilder;
import com.codeshaper.ms3.util.Logger;

/**
 * Builds the API files. Used for debugging the build process.
 * 
 * @author CodeShaper
 */
public class DebugRun {

	public static void main(String[] args) {
		Logger.msg("Starting debug build...");

		try {
			build(System.getProperty("user.home") + "/Desktop/Forge Workspace/Ms3/run/ms3");
		} catch (FileNotFoundException e) {
			// Don't handle, it shouldn't happen
		}

		Logger.msg("Debug build finished!");
	}

	public static void build(String path) throws FileNotFoundException {
		path = StringUtils.removeEnd(StringUtils.removeEnd(path, "\\"), "/");
		File f = new File(path + "/api-" + Ms3.API_VERSION);
		if (!f.exists()) {
			throw new FileNotFoundException();
		}
		ApiBuilder builder = new ApiBuilder(f);

		builder.buildApi();
	}
}
