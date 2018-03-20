package com.codeshaper.ms3.util;

/**
 * Helper methods for messages, errors and warning, with a prefix thrown on.
 */
public class Logger {
	
	private static final String PREFIX = "MS3";
	
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
