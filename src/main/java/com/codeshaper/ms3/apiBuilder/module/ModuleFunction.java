package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.Executable;
import java.lang.reflect.Parameter;

import org.python.core.PyDictionary;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PySequenceList;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonExcludeType;

/**
 * Represents a function within a python module, either in global or class scope
 */
public class ModuleFunction extends ModuleMember {

	public String[] argNames;

	/**
	 * Creates a python function based on a method
	 */
	public ModuleFunction(Executable exec) {
		super(exec, exec);

		// Parameters
		int pCount = exec.getParameterCount();
		this.argNames = new String[pCount];
		Parameter[] parameters = exec.getParameters();
		Parameter param;
		String s;
		for (int i = 0; i < pCount; i++) {
			param = parameters[i];
			if (!param.isAnnotationPresent(PythonExcludeType.class)) {
				String className = this.getTypeName(param.getType());
				s = className.substring(className.lastIndexOf('.') + 1) + "_" + param.getName();
			} else {
				s = param.getName();
			}

			this.argNames[i] = s;
		}
	}

	/**
	 * Takes in a class and returns a name to use to represent it in parameter
	 * names.
	 */
	private String getTypeName(Class<?> clazz) {
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
		} else if(clazz == PyDictionary.class) {
			return "dict";
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
}