package com.codeshaper.ms3.util;

import org.python.core.Py;
import org.python.core.PyClass;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyType;

/**
 * A collection of static methods that validate data, throwing a ValueError
 * exception if the data is invalid.
 * 
 * @author CodeShaper
 */
public class Assert {

	private Assert() {
	}

	public static void isClassType(PyObject type) throws PyException {
		// Depending on if the class is old style or new style, the type will be
		// different.
		if (!(type instanceof PyType || type instanceof PyClass)) {
			throw Py.ValueError("objectType must be a type of a class!");
		}
	}

	/**
	 * Used to check that slot indices are in bounds.
	 * 
	 * @param index
	 * @param upperSize
	 */
	public static void isIndexInBounds(int index, int upperSize) throws PyException {
		if (index < 0 || index > upperSize) {
			throw Py.ValueError(
					"Index is invalid, it must be between 0 and " + upperSize + " inclusive and was " + index);
		}
	}
}
