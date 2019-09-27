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
	/** The Minecraft Version that this release is for. */
	public final Version minecraftVersion;
	@Nullable
	public final String changelog;
	/** The URL to download the this version. */
	@Nullable
	public final URL downloadUrl;

	/**
	 * @param modVersion  The current
	 * @param mcVersion   If null, the version is looked up from
	 *                    {@link ForgeVersions.mcVersion}.
	 * @param changelog   Can be null.
	 * @param downloadUrl Can be null.
	 */
	public Release(Version modVersion, @Nullable Version mcVersion, @Nullable String changelog,
			@Nullable String downloadUrl) throws MalformedURLException {
		this.modVersion = modVersion;
		this.minecraftVersion = mcVersion != null ? mcVersion : new Version(ForgeVersion.mcVersion);
		this.changelog = changelog;

		if (downloadUrl != null) {
			this.downloadUrl = new URL(downloadUrl);
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
