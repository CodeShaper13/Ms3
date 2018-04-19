package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.Constructor;

public class ModuleConstructor extends ModuleFunction {

	public ModuleConstructor(Constructor<?> ctor) {
		super(ctor);
		this.setName("__init__");
	}
}
