package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.python.core.PyObject;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.exception.IllegalModuleFormatException;
import com.codeshaper.ms3.util.Util;

/**
 * Represents a class within a python module
 */
public class ModuleClass implements IMemberHolder {
	
	public String name;
	/** Null if the object inherits from Object. */
	public String superClassName;
	public String docString;
	private ArrayList<ModuleFunction> methodList;
	private ArrayList<ModuleField> fieldList;
	private ArrayList<ModuleClass> innerClassList;
	private ModuleConstructor contsructor;
	
	private ModuleClass() {
		this.fieldList = new ArrayList<ModuleField>();
		this.methodList = new ArrayList<ModuleFunction>();
		this.innerClassList = new ArrayList<ModuleClass>();
	}
	
	public ModuleClass(Class clazz) {
		this();
		this.name = clazz.getSimpleName();
		Class superClass = clazz.getSuperclass();
		if(superClass != null && superClass != Object.class && superClass != PyObject.class) {
			this.superClassName = superClass.getSimpleName();			
		}
		
		this.docString = Util.getPydValue(clazz);
	}
	
	public ModuleClass(String name) {
		this();
		this.name = name;
	}

	public void setConstructor(ModuleConstructor ctor) {
		if(contsructor != null) {
			throw new IllegalModuleFormatException("A class can not have more than one constructor!");
		}
		this.contsructor = ctor;
	}
	
	public ModuleConstructor getConstructor() {
		return this.contsructor;
	}

	@Override
	public void addField(ModuleField field) {
		this.fieldList.add(field);
	}

	@Override
	public ArrayList<ModuleField> getFields() {
		return this.fieldList;
	}

	@Override
	public void addFunction(ModuleFunction function) {
		this.methodList.add(function);
	}

	@Override
	public ArrayList<ModuleFunction> getFunctions() {
		return this.methodList;
	}

	@Override
	public void addClass(ModuleClass clazz) {
		this.innerClassList.add(clazz);
	}

	@Override
	public ArrayList<ModuleClass> getClasses() {
		return this.innerClassList;
	}
}