package com.codeshaper.ms3.apiBuilder;

import org.python.core.Py;
import org.python.core.PyDictionary;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PySequenceList;
import org.python.core.PyTuple;
import org.python.expose.ExposedType;

/**
 * Utility functions that are used when generating both the api and the python
 * source files.
 * 
 * @author CodeShaper
 */
public class BuildUtils {

	private BuildUtils() {
	}

	/**
	 * Takes in a class and returns a name to use to represent it in parameter
	 * names.
	 */
	public static String getTypeName(Class<?> clazz) {
		if (clazz == boolean.class) {
			return "bool";
			// In there are no floats, only doubles but they are called floats.
		} else if (clazz == double.class || clazz == float.class) {
			return "float";
		} else if (clazz == String.class) {
			return "str";
		} else if (clazz == PyList.class) {
			return "list";
		} else if (clazz == Object.class || clazz == PyObject.class) {
			return "object";
		} else if (clazz == PyTuple.class) {
			return "tuple";
		} else if (clazz == PySequenceList.class) {
			return "list";
		} else if (clazz == PyDictionary.class) {
			return "dict";
		} else if (clazz.isAnnotationPresent(ExposedType.class)) {
			return clazz.getAnnotation(ExposedType.class).name(); // Tries to find the right name.
		} else {
			String className = clazz.getName();
			if (className.contains(";")) {
				className = className.replace(";", "") + "_ARRAY";
			} else if (className.contains("$")) {
				className = className.substring(className.lastIndexOf('$') + 1);
			}

			return className;
		}
	}
	
	public static String getDefaultValueFromType(Class<?> type) {
		if (type == boolean.class) {
			return Py.False.toString();
			// In there are no floats, only doubles but they are called floats.
		} else if (type == byte.class || type == int.class || type == double.class || type == float.class) {
			return "0";
		} else if (type == String.class) {
			return "\"\"";
		} else if (type == PyList.class) {
			return "[]";
		} else if (type == Object.class || type == PyObject.class) {
			return Py.None.toString();
		} else if (type == PyTuple.class) {
			return "()";
//		} else if (clazz == PySequenceList.class) {
//			return "list";
		} else if (type == PyDictionary.class) {
			return "{}";
		} else {
			// It is an unexpected type, return null.
			return Py.None.toString();
		}
	}
}
