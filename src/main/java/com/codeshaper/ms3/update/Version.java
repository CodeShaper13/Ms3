package com.codeshaper.ms3.update;

import org.apache.commons.lang3.StringUtils;

/**
 * An abstract version identifier, with a major, minor and patch number.
 */
public class Version implements Comparable<Version> {

	private final int majorVersion;
	private final int minorVersion;
	private final int patchVersion;
	
	public Version(String version) {
		String[] s = StringUtils.split(version, '.');
		this.majorVersion = Integer.parseInt(s[0]);
		this.minorVersion = Integer.parseInt(s[1]);
		this.patchVersion = Integer.parseInt(s[2]);
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
		if(this.equals(v)) {
			return 0;
		}
		
		if(this.majorVersion > v.majorVersion) {
			return 1;
		}
		if(this.minorVersion > v.minorVersion) {
			return 1;
		}
		if(this.patchVersion > v.patchVersion) {
			return 1;
		}
		return -1;
	}
}
