package com.codeshaper.ms3.util;

import java.lang.reflect.AnnotatedElement;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.python.core.Py;
import org.python.core.PyBoolean;
import org.python.core.PyClass;
import org.python.core.PyFloat;
import org.python.core.PyInteger;
import org.python.core.PyLong;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyTuple;
import org.python.core.PyType;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;

public class Util {

	public static final char SECTION_SIGN = '§';

	private Util() {
	}

	/**
	 * Returns the {@link PythonDocString} doc string from an
	 * {@link AnnotatedElement} if it has one, or null if the annotation isn't
	 * found.
	 */
	public static @Nullable String getPydValue(AnnotatedElement element) {
		PythonDocString pythonDocString = element.getAnnotation(PythonDocString.class);
		return pythonDocString != null && !StringUtils.isBlank(pythonDocString.value()) ? pythonDocString.value()
				: null;
	}

	/**
	 * Takes in a String with ampersands for color codes and replaces them with
	 * {@link SECTION_SIGN}.
	 */
	public static String correctColorCode(String string) {
		return string.replace('&', SECTION_SIGN);
	}

	/**
	 * Takes in a {@link PyObject} that should be an instance of PyBoolean, and
	 * returns the not value of the passed boolean.
	 * 
	 * @param obj
	 *            If {@link obj} is not an instance of PyBoolean, it is assumed to
	 *            be false.
	 * @return The inverse of
	 */
	public static PyBoolean pyNotHelper(PyObject obj) {
		boolean flag;
		if (obj instanceof PyBoolean) {
			flag = !((PyBoolean) obj).getBooleanValue();
		} else {
			flag = false; // It is not a valid value, set flag to true so it is inversed to be false.
		}
		return !flag ? Py.True : Py.False;
	}

	/**
	 * Creates a {@link PyTuple} from the passed objects.
	 * 
	 * @param obj
	 * @return
	 */
	public static PyTuple makeTuple(Object... obj) {
		int j = obj.length;
		PyObject[] array = new PyObject[j];
		for (int i = 0; i < j; i++) {
			array[i] = Util.primitiveToPyObject(obj[i]);
		}
		return new PyTuple(array);
	}

	/**
	 * Converts a primitive type to a Python type.
	 * 
	 * @param obj
	 *            Primitive type or null.
	 * @return The object as a python type.
	 * @throws IllegalArgumentException
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
		} else if (obj instanceof Float || obj instanceof Double) {
			return new PyFloat(((Float) obj));
		} else if (obj instanceof Boolean) {
			return ((Boolean) obj) ? Py.True : Py.False;
		} else {
			throw new IllegalArgumentException(
					"Parameter was of type " + obj.getClass().toString() + "!  It must be a primitive type or null");
		}
	}
	
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
	
	/**
	 * Returns the type name from objectType.
	 * @param objectType The type of a Python class, accepts new or old style class.
	 * @return The type name of the class.
	 */
	public static String getTypeName(PyObject objectType) {
		PyType type;
		if(objectType instanceof PyClass) {
			type = ((PyClass)objectType).getType();
		} else {
			type = (PyType)objectType;
		}
		return type.getName();
	}
}
