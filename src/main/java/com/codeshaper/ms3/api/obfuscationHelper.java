package com.codeshaper.ms3.api;

import java.io.File;

import org.python.core.Py;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonDocString("Class for looking up deobfuscated names within Minecraft's source.  Be sure to call the initialize() method before using.")
public class obfuscationHelper {

	private static boolean isInitialized;

	@PythonFunction
	@PythonDocString("Initializes the obfuscationHelper module.  This must be called before suing any of the lookup methods.")
	public void initialize(String pathToFieldNameLookup, String pathToMethodNameLookup) {
		File fieldsFile = new File(pathToFieldNameLookup);
		File methodsFile = new File(pathToMethodNameLookup);

		// TODO
	}

	@PythonFunction
	public static String getDeObfuscatedField(String name) {
		obfuscationHelper.func();

		return null;
	}

	@PythonFunction
	public static String getDeObfuscatedMethod(String name) {
		obfuscationHelper.func();

		return null;
	}

	@PythonFunction
	public static String getObfuscatedField(String name) {
		obfuscationHelper.func();

		return null;
	}

	@PythonFunction
	public static String getObfuscatedMethod(String name) {
		obfuscationHelper.func();

		return null;
	}

	private static void func() {
		if (!obfuscationHelper.isInitialized) {
			throw Py.RuntimeError("The initialize method must be called first!");
		}
	}
}
