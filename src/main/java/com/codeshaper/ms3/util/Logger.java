package com.codeshaper.ms3.util;

import com.codeshaper.ms3.Ms3;

/**
 * Helper methods for messages, errors and warning, with a prefix.
 * 
 * @author CodeShaper
 */
public class Logger {
	
	private static final String PREFIX = Ms3.MOD_ID.toUpperCase();
	
	public static void msg(String msg) {
		System.out.println(PREFIX + " (MESSAGE): " + msg);
	}
	
	public static void err(String msg) {
		System.err.println(PREFIX + " (ERROR!): " + msg);
	}

	public static void warn(String msg) {
		System.out.println(PREFIX + " (WARNING!): " + msg);
	}
}
