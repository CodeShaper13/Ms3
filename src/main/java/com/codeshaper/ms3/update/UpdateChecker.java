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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.MalformedJsonException;

/**
 * @author CodeShaper
 */
public class UpdateChecker {

	private URL versionJsonUrl;

	public String updates = "";
	public boolean outdated = false;

	/**
	 * @param releaseFileUrl A URL that points to a json file containing a list of
	 *                       all the releases.
	 * @throws MalformedURLException If the url was malformed when constructed.
	 */
	public UpdateChecker(String releaseFileUrl) throws MalformedURLException {
		this.versionJsonUrl = new URL(releaseFileUrl);
	}

	/**
	 * Checks if the passed release is outdated.
	 * 
	 * @param currentRelease
	 * @return True if the release is outdates, false if it is up to date.
	 */
	public boolean isOutdated(Version currentVersion) throws MalformedJsonException {
		JsonParser parser = new JsonParser();

		List<Release> allReleases = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(this.versionJsonUrl.openStream(), Charset.forName("UTF-8")))) {
			JsonObject jsontree = (JsonObject) parser.parse(br);
			JsonArray versionsArray = jsontree.get("versions").getAsJsonArray();

			for (int i = 0; i < versionsArray.size(); i++) {
				JsonObject version = (JsonObject) versionsArray.get(i);

				String ms3Version = version.get("ms3Version").getAsString();
				String minecraftVersion = version.get("mcVersion").getAsString();
				String changelog = version.get("changelog").getAsString();
				String download = version.get("download").getAsString();

				// TODO fix
				allReleases.add(new Release(new Version(ms3Version), new Version(minecraftVersion), changelog,
						"http://www.google.com"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Release current = this.findNewest(allReleases);
		if (currentVersion.compareTo(current.modVersion) == -1) {
			return true; // Outdated.
		} else {
			return false;
		}
	}

	/**
	 * Returns the newest release in the list. Null if the list is empty.
	 */
	@Nullable
	private static Release findNewest(List<Release> releases) {
		Release newest = null;

		for (Release r : releases) {
			if (newest == null) {
				newest = r;
			} else {
				if (r.modVersion.compareTo(newest.modVersion) == 1) {
					newest = r;
				}
			}
		}

		return newest;
	}
}
