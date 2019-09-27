package com.codeshaper.ms3.update;

import org.apache.commons.lang3.StringUtils;

/**
 * A version identifier with a major, minor and patch number.
 * 
 * @author CodeShaper
 */
public class Version implements Comparable<Version> {

	private final int majorVersion;
	private final int minorVersion;
	private final int patchVersion;

	/**
	 * Constructs a Version from a string that uses "." to seperate the major, minor
	 * and patch numbers. The minor and patch numbers are optional and are assumed
	 * to be 0 if not specified.
	 * 
	 * @param version A string containing the version.
	 */
	public Version(String version) throws NumberFormatException {
		String[] s = StringUtils.split(version, '.');
		this.majorVersion = Integer.parseInt(s[0]);

		if (s.length > 1) {
			this.minorVersion = Integer.parseInt(s[1]);
		} else {
			this.minorVersion = 0;
		}

		if (s.length > 2) {
			this.patchVersion = Integer.parseInt(s[2]);
		} else {
			this.patchVersion = 0;
		}
	}

	public Version(int majorVersion, int minorVersion, int patchVersion) {
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
		this.patchVersion = patchVersion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + majorVersion;
		result = prime * result + minorVersion;
		result = prime * result + patchVersion;
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
		Version other = (Version) obj;
		if (majorVersion != other.majorVersion) {
			return false;
		}
		if (minorVersion != other.minorVersion) {
			return false;
		}
		if (patchVersion != other.patchVersion) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.majorVersion + "." + this.minorVersion + "." + this.patchVersion;
	}

	@Override
	public int compareTo(Version v) {
		if (this.equals(v)) {
			return 0;
		}

		if (this.majorVersion > v.majorVersion) {
			return 1;
		}
		if (this.minorVersion > v.minorVersion) {
			return 1;
		}
		if (this.patchVersion > v.patchVersion) {
			return 1;
		}
		return -1;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public int getPatchVersion() {
		return patchVersion;
	}
}
