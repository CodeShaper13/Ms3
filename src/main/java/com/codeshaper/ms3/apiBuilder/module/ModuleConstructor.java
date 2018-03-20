package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.Constructor;

import com.codeshaper.ms3.apiBuilder.annotation.PythonConstructor;

public class ModuleConstructor extends ModuleFunction {

	public ModuleConstructor(Constructor ctor) {
		super(ctor);
		this.name = "__init__";
	}
}
