package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.Parameter;

import javax.annotation.Nullable;

import org.python.core.PyDictionary;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PySequenceList;
import org.python.core.PyTuple;
import org.python.expose.ExposedType;

import com.codeshaper.ms3.apiBuilder.BuildUtils;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeName;

/**
 * Represents a single parameter from a method or constructor.
 * 
 * @author CodeShaper
 */
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
			String className = BuildUtils.getTypeName(type);
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
}
