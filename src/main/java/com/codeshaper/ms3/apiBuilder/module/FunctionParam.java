package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.Parameter;

import javax.annotation.Nullable;

import org.python.core.PyDictionary;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PySequenceList;
import org.python.core.PyTuple;
import org.python.expose.ExposedType;

import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeName;

public class FunctionParam {

	private final String name;
	@Nullable
	private final String typeName;

	public FunctionParam(Parameter param) {
		this(param.isAnnotationPresent(PythonTypeName.class) ? param.getAnnotation(PythonTypeName.class).value()
				: param.getName(), param.isAnnotationPresent(PythonTypeExclude.class) ? null : param.getType());
	}

	public FunctionParam(String name) {
		this(name, (String) null);
	}

	public FunctionParam(String name, String typeName) {
		this.name = name;
		this.typeName = typeName;
	}

	public FunctionParam(String name, @Nullable Class<?> type) {
		this.name = name;
		if (type == null) {
			this.typeName = null;
		} else {
			String className = this.getTypeName(type);
			// Remove the package prefix on the type name.
			this.typeName = className.substring(className.lastIndexOf('.') + 1);

		}
	}

	/**
	 * Returns the parameter as a string by concatenating the type name and argument
	 * name, separated by an underscore.
	 */
	public String getParamAsString() {
		if (this.typeName == null) {
			return this.name;
		} else {
			return this.typeName + "_" + this.name;
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
}
