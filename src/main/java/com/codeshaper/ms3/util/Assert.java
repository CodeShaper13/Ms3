package com.codeshaper.ms3.util;

import org.python.core.Py;
import org.python.core.PyClass;
import org.python.core.PyException;
import org.python.core.PyFloat;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyTuple;
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

	/**
	 * Checks if the passed object is the type of a class. This works for both new
	 * style Python 3 classes and old style.
	 * 
	 * @param type
	 * @throws PyException in the form of a Value Error if the type is not a class.
	 */
	public static void isClassType(PyObject type) throws PyException {
		// Depending on if the class is old style or new style, the type will be
		// different.
		if (!(type instanceof PyType || type instanceof PyClass)) {
			throw Py.ValueError("objectType must be a type of a class!");
		}
	}

	/**
	 * Used to check that an index is within the bounds of 0 and the passed
	 * upperBounds.
	 * 
	 * @param index
	 * @param upperBounds
	 * @throws PyException in the form of a Value Error is the index is out of
	 *                     bounds.
	 */
	public static void isIndexInBounds(int index, int upperBounds) throws PyException {
		if (index < 0 || index > upperBounds) {
			throw Py.ValueError(
					"Index is invalid, it must be between 0 and " + upperBounds + " inclusive.  It was " + index);
		}
	}

	/**
	 * Checks if the passed tuple can be turned into a color. For it to be valid,
	 * all elements of the tuple must be numbers and the length must be 3 or 4.
	 * 
	 * @param color
	 * @throws PyException If the tuple does not have exactly 3 or 4 elements or it
	 *                     contains an object not of type {@link Number}
	 */
	public static void isColor(PyTuple color) throws PyException {
		int length = color.__len__();
		if (!(length == 3 || length == 4)) {
			throw Py.ValueError("tuple must contain exactly 3 or 4 elements");
		}
		for (int i = 0; i < length; i++) {
			Object obj = color.get(i);
			if (!(obj instanceof Number)) {
				throw Py.ValueError("all elements must be number");
			}
		}
	}

	/**
	 * Checks if the passed tuple can be turned into coordinates. For it to be
	 * valid, all elements must be numbers and the length of the tuple must be 3
	 * elements.
	 * 
	 * @param coordinates
	 * @throws PyException If the tuple does not have exactly 3 elements or it
	 *                     contains an object not of type {@link Number}
	 */
	public static void isCoords(PyTuple coordinates) throws PyException {
		if (coordinates.__len__() != 3) {
			throw Py.ValueError("tuple must contain exactly 3 elements");
		}
		for (int i = 0; i < 3; i++) {
			if (!(coordinates.get(i) instanceof Number)) {
				throw Py.ValueError("all elements must be number");
			}
		}
	}

	public static void isInt(Object obj, String s) {
		if(!(obj instanceof Integer)) {
			throw Py.ValueError(s + " must be an integer!");
		}
	}
}
