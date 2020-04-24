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
		return true;
	}
	
	/**
	 * Takes in a String with an ampersands {&) for color codes and replaces each
	 * occurrence with a {@link SECTION_SIGN}.
	 * 
	 * @param string The string to correct.
	 * @return The corrected string.
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
	 * converted to a Python type using {@link Util#primitiveToPyObject(Object)}.
	 * 
	 * @param obj
	 * @return
	 */
	public static PyTuple makeTuple(Object... obj) {
		int j = obj.length;
		PyObject[] array = new PyObject[j];
		for (int i = 0; i < j; i++) {
			array[i] = Parser.primitiveToPyObject(obj[i]);
		}
		return new PyTuple(array);
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
