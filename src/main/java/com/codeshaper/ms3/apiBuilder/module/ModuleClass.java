package com.codeshaper.ms3.apiBuilder.module;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.python.core.PyObject;

import com.codeshaper.ms3.exception.IllegalModuleFormatException;

/**
 * Represents a class within a python module
 */
public class ModuleClass extends AttributeHolder {

	@Nullable
	/** Null if the object inherits from Object. */
	private final String superClassName;
	@Nullable
	private ModuleConstructor contsructor;

	public ModuleClass(Class<?> clazz) {
		super(clazz.getSimpleName(), clazz);

		Class<?> superClass = clazz.getSuperclass();
		if (superClass != null && superClass != Object.class && superClass != PyObject.class) {
			this.superClassName = superClass.getSimpleName();
		} else {
			this.superClassName = null;
		}
	}

	public boolean hasSuperClass() {
		return StringUtils.isNotEmpty(this.superClassName);
	}

	@Nullable
	public String getSuperClass() {
		return this.superClassName;
	}

	public void setConstructor(ModuleConstructor ctor) {
		if (contsructor != null) {
			throw new IllegalModuleFormatException("A class can not have more than one constructor!");
		}
		this.contsructor = ctor;
	}

	public ModuleConstructor getConstructor() {
		return this.contsructor;
	}
}