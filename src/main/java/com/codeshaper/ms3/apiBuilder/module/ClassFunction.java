package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.Executable;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

public class ClassFunction extends ModuleFunction {

	public ClassFunction(Executable exec) {
		super(exec);
	}

	public ClassFunction(String name, FunctionParam... params) {
		super(name, (params));
	}

	public ClassFunction(String name, String docString, Class<?> returnType, FunctionParam... params) {
		super(name, docString, returnType, (params));
	}

	public ClassFunction(String name, String docString, FunctionParam... params) {
		super(name, docString, (params));
	}
}
