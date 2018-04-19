package com.codeshaper.ms3;

import java.io.File;

import com.codeshaper.ms3.apiBuilder.ApiBuilder;
import com.codeshaper.ms3.util.Logger;

public class DebugRun {

	public static void main(String[] args) {
		Logger.msg("Starting debug build...");
		
		File f = new File(System.getProperty("user.home")
				+ "\\Desktop\\Forge Workspace\\Ms3\\run\\ms3\\api-" + Ms3.VERSION);
		ApiBuilder builder = new ApiBuilder(f);
		
		builder.buildApi();
		
		Logger.msg("Debug build finished!");
	}
}
