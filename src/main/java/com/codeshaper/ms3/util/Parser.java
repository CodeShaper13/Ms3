package com.codeshaper.ms3.util;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import org.python.core.Py;
import org.python.core.PyFloat;
import org.python.core.PyInteger;
import org.python.core.PyLong;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyTuple;

public class Parser {

	private Parser() { }
	
	/**
	 * Converts a primitive type to a Python type. If null is passed {@link Py.None}
	 * is returned.
	 * 
	 * @param obj Primitive type or null.
	 * @return The object as a Python type.
	 * @throws IllegalArgumentException If the passed object is not a primitive type.
	 */
	public static PyObject primitiveToPyObject(@Nullable Object obj) throws IllegalArgumentException {
		if (obj == null) {
			return Py.None;
		} else if (obj instanceof String) {
			return new PyString(((String) obj));
		} else if (obj instanceof Character) {
			return new PyString(((Character) obj));
		} else if (obj instanceof Integer || obj instanceof Short || obj instanceof Byte) {
			return new PyInteger(((Integer) obj));
		} else if (obj instanceof Long) {
			return new PyLong(((Long) obj));
		} else if (obj instanceof Float) {
			return new PyFloat(((float) obj));
		} else if (obj instanceof Double) {
			return new PyFloat(((Double) obj).floatValue());
		} else if (obj instanceof Boolean) {
			return ((Boolean) obj) ? Py.True : Py.False;
		} else {
			throw new IllegalArgumentException(
					"Parameter was of type " + obj.getClass().toString() + "!  It must be a primitive type or null");
		}
	}

	/**
	 * Takes in a {@link String} and returns it as a {@link PyObject}.
	 * 
	 * <li>"true" and "True" becomes {@link Py.True}.</li>
	 * <li>"false" and "False" becomes {@link Py.False}.</li>
	 * <li>Whole and floating point numbers become {@link PyInteger} and
	 * {@link PyFloat} respectively.</li>
	 * <li>Strings become {@link PyString}.</li>
	 * 
	 * @param string
	 * @return
	 */
	public static PyObject stringToPyObject(String string) {
		if (NumberUtils.isCreatable(string)) {
			float f = NumberUtils.createFloat(string);
			if (f == ((int) f)) {
				return new PyInteger((int) f);
			} else {
				return new PyFloat(f);
			}
		} else if (StringUtils.capitalize(string).equals("True")) {
			return Py.True;
		} else if (StringUtils.capitalize(string).equals("False")) {
			return Py.False;
		} else {
			return new PyString(string);
		}
	}

	public static Vector4f tupleToColor(PyTuple color) {
		float r = Parser.objToFloat(color.get(0));
		float g = Parser.objToFloat(color.get(1));
		float b = Parser.objToFloat(color.get(2));
		float a = color.__len__() == 4 ? Parser.objToFloat(color.get(3)) : 1f;
		return new Vector4f(r, g, b, a);
	}
	
	public static Vector3f tupleToVertex(PyTuple vertex) {
		float x = Parser.objToFloat(vertex.get(0));
		float y = Parser.objToFloat(vertex.get(1));
		float z = Parser.objToFloat(vertex.get(2));
		return new Vector3f(x, y, z);
	}
	
	public static int objToInt(Object obj) {
		if(obj instanceof Number) {
			return ((Number)obj).intValue();
		} else {
			return 0;
		}
	}
	
	public static float objToFloat(Object obj) {
		if(obj instanceof Number) {
			return ((Number)obj).floatValue();
		} else {
			return 0;
		}
	}
}
