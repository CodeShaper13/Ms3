package com.codeshaper.ms3.api;

import java.io.File;

import org.python.core.Py;
import org.python.core.PyException;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonDocString("Class for looking up deobfuscated names within Minecraft's source.  Be sure to call the initialize() function before using any of the modules other functions.")
public class obfuscationHelper {

	private static boolean isInitialized;

	@PythonFunction
	@PythonDocString("Initializes the obfuscationHelper module.  This must be called before using any of the lookup methods.")
	public void initialize(String pathToFieldNameLookup, String pathToMethodNameLookup) {
		File fieldsFile = new File(pathToFieldNameLookup);
		File methodsFile = new File(pathToMethodNameLookup);

		// TODO
	}

	@PythonFunction
	@PythonDocString("Returns a deobfuscated field name from the obfuscated name.")
	public static String getDeObfuscatedFieldName(String obfuscatedName) {
		obfuscationHelper.assertCheckIfInitialized();

		// TODO

		return null;
	}

	@PythonFunction
	@PythonDocString("Returns a deobfuscated method name from the obfuscated name.")
	public static String getDeObfuscatedMethodName(String obfuscatedName) {
		obfuscationHelper.assertCheckIfInitialized();

		// TODO

		return null;
	}

	@PythonFunction
	@PythonDocString("Returns the obfuscated field name from a deobfuscated name.")
	public static String getObfuscatedFieldName(String deObfuscatedName) {
		obfuscationHelper.assertCheckIfInitialized();

		// TODO

		return null;
	}

	@PythonFunction
	@PythonDocString("Returns the obfuscated method name from a deobfuscated name.")
	public static String getObfuscatedMethodName(String deObfuscatedName) {
		obfuscationHelper.assertCheckIfInitialized();

		// TODO

		return null;
	}

	/**
	 * Checks if the obfuscationHelper module has been initialized. An exception is
	 * thrown if it is not.
	 * 
	 * @throws PyException If the obfuscationHelper has not been initialized.
	 */
	private static void assertCheckIfInitialized() throws PyException {
		if (!obfuscationHelper.isInitialized) {
			throw Py.RuntimeError("The initialize() method must be called before calling any other methods.");
		}
	}
}
