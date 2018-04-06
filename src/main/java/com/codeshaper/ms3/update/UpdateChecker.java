package com.codeshaper.ms3.update;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UpdateChecker {
	
	private static URL VERSIONS_JSON_URL;

	public static String updates = "";
	public static boolean outdated = false;
	
	static {
		try {
			VERSIONS_JSON_URL = new URL("https://www.google.com");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static boolean isOutdated(Release currentRelease) {
		if("s".equals("s")) {
			return true;
		}
		
		JsonParser parser = new JsonParser();

		List<Release> allReleases = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(VERSIONS_JSON_URL.openStream(), Charset.forName("UTF-8")))) {
			JsonElement jsontree = parser.parse(br); //new FileReader("www.x.com"));
			JsonElement je = jsontree.getAsJsonObject();
			JsonArray jsonArray = je.getAsJsonArray();
						
			for (Object obj : jsonArray) {
				JsonObject version = (JsonObject) obj;

				String ms3Version = version.get("modVersion").getAsString();
				String minecraftVersion = version.get("mcVersion").getAsString();
				String changelog = version.get("changelog").getAsString();
				String download = version.get("download").getAsString();
				
				allReleases.add(new Release(ms3Version, minecraftVersion, changelog, download));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Release current = findNewest(allReleases);
		if(currentRelease.modVersion.compareTo(current.modVersion) == -1) {
			return true; // Outdated.
		} else {
			return false;
		}
	}
	
	/**
	 * If the list is empty, null is returned.
	 */
	@Nullable
	private static Release findNewest(List<Release> releases) {
		Release newest = null;
		
		for(Release r : releases) {
			if(newest == null) {
				newest = r;
			} else {
				if(r.modVersion.compareTo(newest.modVersion) == 1) {
					newest = r;
				}
			}
		}
		
		return newest;		
	}
}
