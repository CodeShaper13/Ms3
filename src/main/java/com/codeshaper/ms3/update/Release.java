package com.codeshaper.ms3.update;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nullable;

import net.minecraftforge.common.ForgeVersion;

/**
 * @author CodeShaper
 */
public class Release {

	public final Version modVersion;
	public final Version minecraftVersion;
	@Nullable
	public final String changelog;
	@Nullable
	public final URL downloadUrl;

	/**
	 * @param modVersion
	 * @param mcVersion
	 *            If null, the version is looked up from
	 *            {@link ForgeVersions.mcVersion}.
	 * @param changelog
	 *            Can be null.
	 * @param downloadUrl
	 *            Can be null.
	 */
	public Release(String modVersion, @Nullable String mcVersion, @Nullable String changelog,
			@Nullable String downloadUrl) {
		this.modVersion = new Version(modVersion);
		this.minecraftVersion = new Version(mcVersion != null ? mcVersion : ForgeVersion.mcVersion);
		this.changelog = changelog;

		if (downloadUrl != null) {
			URL url = null;
			try {
				url = new URL(downloadUrl);
			} catch (MalformedURLException e) {
			}
			this.downloadUrl = url;
		} else {
			this.downloadUrl = null;
		}
	}

	@Override
	public String toString() {
		return "Release [modVersion=" + this.modVersion + ", minecraftVersion=" + this.minecraftVersion + ", changelog="
				+ this.changelog + ", downloadUrl=" + this.downloadUrl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((minecraftVersion == null) ? 0 : minecraftVersion.hashCode());
		result = prime * result + ((modVersion == null) ? 0 : modVersion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Release other = (Release) obj;
		if (minecraftVersion == null) {
			if (other.minecraftVersion != null) {
				return false;
			}
		} else if (!minecraftVersion.equals(other.minecraftVersion)) {
			return false;
		}
		if (modVersion == null) {
			if (other.modVersion != null) {
				return false;
			}
		} else if (!modVersion.equals(other.modVersion)) {
			return false;
		}
		return true;
	}
}
