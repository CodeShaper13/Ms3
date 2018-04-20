package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.Constructor;

public class ModuleConstructor extends ModuleFunction {

	/**
	 * Creates a constructor with the "*args" parameter.
	 */
	public ModuleConstructor() {
		super("__init__", new FunctionParam("*args"));
	}
	
	public ModuleConstructor(Constructor<?> ctor) {
		super(ctor); // Sets name to be __init__ in ModuleFunction constructor.
	}
}
