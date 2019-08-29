package com.codeshaper.ms3.apiBuilder.module;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.apiBuilder.BuildUtils;
import com.codeshaper.ms3.util.Util;

/**
 * Represents a function within a Python module, either in global or class
 * scope.
 * 
 * @author CodeShaper.
 */
public class ModuleFunction extends BaseAttribute {

	private FunctionParam[] paramArray;
	/**
	 * Holds the class of the return type. If this method returns nothing, this is
	 * equal to {@link Void.type}
	 */
	private Class<?> returnType;

	/**
	 * Creates a Python function based on a method
	 */
	public ModuleFunction(Executable exec) {
		this(func01(exec), Util.getPydValue(exec), ModuleFunction.func(exec.getParameters()));
		Object o = ObjectUtils.NULL;

		if (exec instanceof Method) {
			Class<?> c = ((Method) exec).getReturnType();
			if (c.equals(Void.TYPE)) {
				this.returnType = Void.TYPE;
			} else {
				this.returnType = c;
			}
		} else {
			// This is a constructor, it returns nothing.
			this.returnType = Void.TYPE;
		}
	}

	public ModuleFunction(String name, FunctionParam... params) {
		this(name, StringUtils.EMPTY, null, params);
	}

	public ModuleFunction(String name, String docString, FunctionParam... params) {
		super(name, docString);
		this.func(params);
		this.returnType = Void.TYPE;
	}

	public ModuleFunction(String name, String docString, Class<?> returnType, FunctionParam... params) {
		super(name, docString);
		this.func(params);
		this.returnType = returnType;
	}
	
	private void func(FunctionParam[] params) {
		if(this instanceof ClassFunction) {
			FunctionParam[] tempArr = new FunctionParam[params.length + 1];
			tempArr[0] = new FunctionParam("self");
			System.arraycopy(params, 0, tempArr, 1, params.length);
			this.paramArray = tempArr;
		} else {
			this.paramArray = params;
		}
	}
	
	/**
	 * Returns the number of arguments that the function has.
	 */
	public int getArgsLength() {
		return this.paramArray.length;
	}

	/**
	 * Returns the argument at the passed index as a string ready to write to a
	 * file. See {@link FunctionParam#getParamAsString()}
	 */
	public String getArg(int index) {
		return this.paramArray[index].getParamAsString();
	}

	@Override
	public void write(String indent, BufferedWriter br) throws IOException {
		StringBuilder args = new StringBuilder();
		int length = this.getArgsLength();
		for (int i = 0; i < length; i++) {
			args.append(this.getArg(i));
			if (i != length - 1) { // Not last element.
				args.append(", ");
			}
		}

		br.write(indent + "def " + this.getName() + "(" + args + "):\n");
		if (this.hasDocString()) {
			br.write(indent + "    " + this.getFormatedDocString() + "\n");
		}

		// Add the body of the function.
		if (this.returnType == void.class) {
			br.write(indent + "    pass");
		} else {
			br.write(indent + "    return " + BuildUtils.getDefaultValueFromType(this.returnType));
		}
		br.write("\n\n");
	}

	/**
	 * Returns the name of the passed executable, or __init__ if the executable is a
	 * constructor.
	 */
	private static String func01(Executable exec) {
		if (exec instanceof Constructor<?>) {
			return "__init__";
		} else {
			return exec.getName();
		}
	}

	/**
	 * Converts an array of {@link Parameter} to an array of {@link FunctionParam}
	 * and returns it.
	 */
	private static FunctionParam[] func(Parameter... params) {
		int i = params.length;
		FunctionParam[] ps = new FunctionParam[params.length];
		for (int j = 0; j < i; j++) {
			ps[j] = new FunctionParam(params[j]);
		}
		return ps;
	}
}