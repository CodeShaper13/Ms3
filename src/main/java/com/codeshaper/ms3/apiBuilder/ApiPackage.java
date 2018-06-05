package com.codeshaper.ms3.apiBuilder;

import org.python.core.PyJavaPackage;
import org.python.core.PyJavaType;
import org.python.core.PyObject;
import org.python.core.PySystemState;

import com.codeshaper.ms3.apiBuilder.module.Module;
import com.codeshaper.ms3.apiBuilder.module.ModuleClass;
import com.codeshaper.ms3.apiBuilder.module.ModuleField;
import com.codeshaper.ms3.apiBuilder.module.ModuleFunction;

public class ApiPackage {

	private PyJavaPackage pack;
	private Module initModule;

	public ApiPackage() {
		PySystemState.initialize();

		// this.pack = (PyJavaPackage)
		// PySystemState.packageManager.lookupName("com.codeshaper.appms3.api");
		this.pack = (PyJavaPackage) PySystemState.packageManager.lookupName("com.codeshaper.appms3.api");
		this.initModule = new Module("__init__");
	}

	public void addClass(ModuleClass clazz) {
		this.set(clazz.getClass().getName(), PyJavaType.fromClass(clazz.getClass()));
		this.initModule.addClass(clazz);
	}

	public void addFunction(ModuleFunction function) {
		this.set(function.getName(), null);
		this.initModule.addFunction(function);
	}

	public void addField(ModuleField mf) {
		this.set(mf.getName(), null);
		// this.set(fieldName, new JavaFunc(method));
		this.initModule.addField(null);
	}

	public Module getModule() {
		return this.initModule;
	}

	private void set(String key, PyObject value) {
		this.pack.__dict__.__setitem__(key.intern(), value);
	}

	public void addField(Class<?> classOfHolder, String name) {
		// TODO Auto-generated method stub

	}
}
