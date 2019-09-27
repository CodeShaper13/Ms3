package com.codeshaper.ms3.util;

import java.lang.reflect.AnnotatedElement;

import javax.annotation.Nullable;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Conversion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
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
import com.codeshaper.ms3.capability.IEntityMs3Data;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import scala.reflect.internal.Types.ClassUnwrapper;

/**
 * General utility methods that don't fall into any category.
 * 
 * @author CodeShaper
 */
public class Util {

	/** Constant for the section sign character */
	public static final char SECTION_SIGN = '§';

	private Util() {
	}

	/**
	 * Checks if the passed entity should have a {@link IEntityMs3Data} capability.
	 * 
	 * @param entity
	 * @return True if it should get the capability attached, false if it should
	 *         not.
	 */
	public static boolean validEntityForMs3Data(Entity entity) {
		return true; // !(entity instanceof EntityPlayer);
	}

	/**
	 * Takes in a String with an ampersands {&) for color codes and replaces each
	 * occurrence with a {@link SECTION_SIGN}.
	 */
	public static String correctColorCode(String string) {
		return string.replace('&', SECTION_SIGN);
	}

	/**
	 * Takes in a {@link PyObject} that should be an instance of PyBoolean, and
	 * returns the not value of the passed boolean. True will become false, false
	 * will become true.
	 * 
	 * @param obj If {@link obj} is not an instance of PyBoolean, it is assumed to
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
		return flag ? Py.True : Py.False;
	}

	/**
	 * Creates a {@link PyTuple} from the passed objects. Objects passed will be
	 * converted to a Python time by {@link Util#primitiveToPyObject(Object)}.
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
		float r = toFloat(color.get(0));
		float g = toFloat(color.get(1));
		float b = toFloat(color.get(2));
		float a = color.__len__() == 4 ? toFloat(color.get(3)) : 1f;
		return new Vector4f(r, g, b, a);
	}
	
	public static Vector3f tupleToVertex(PyTuple vertex) {
		float x = toFloat(vertex.get(0));
		float y = toFloat(vertex.get(1));
		float z = toFloat(vertex.get(2));
		return new Vector3f(x, y, z);
	}
	
	public static float toFloat(Object obj) {
		if(obj instanceof Number) {
			return ((Number)obj).floatValue();
		} else {
			return 0;
		}
	}
	
	/**
	 * Returns the type name from objectType.
	 * 
	 * @param objectType The type of a Python class, accepts new or old style class.
	 * @return The type name of the class.
	 */
	// This doesn't work
	public static String getTypeName(PyObject objectType) {
		PyType type;
		if (objectType instanceof PyClass) {
			type = ((PyClass) objectType).getType();
		} else {
			type = (PyType) objectType;
		}
		return type.getName();
	}
}
