package com.codeshaper.ms3.apiBuilder.module;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.python.core.PyObject;

/**
 * Represents a class within a Python module
 */
public class ModuleClass extends AttributeHolder {

	@Nullable
	/** Null if the object inherits from Object. */
	private final String superClassName;
	@Nullable
	private ModuleConstructor contstructor;
	private int ctorsFound = 0;

	public ModuleClass(Class<?> clazz) {
		super(clazz.getSimpleName(), clazz);

		Class<?> superClass = clazz.getSuperclass();
		if (superClass != null && superClass != Object.class && superClass != PyObject.class) {
			this.superClassName = superClass.getSimpleName();
		} else {
			this.superClassName = null;
		}
	}

	/**
	 * Returns true if the class has a super class that is not object.
	 */
	public boolean hasSuperClass() {
		return StringUtils.isNotEmpty(this.superClassName);
	}

	/**
	 * Returns the class's super class, or null if this class inherits from Object.
	 */
	@Nullable
	public String getSuperClass() {
		return this.superClassName;
	}

	public void addConstructor(ModuleConstructor ctor) {
		if (this.ctorsFound == 0) {
			this.contstructor = ctor;
		} else if (this.ctorsFound == 1) {
			this.contstructor = new ModuleConstructor(); // TODO make nicer.
		}

		this.ctorsFound++;
	}

	/**
	 * Returns the constructor belonging to this class, or null if it has no
	 * constructor.
	 */
	@Nullable
	public ModuleConstructor getConstructor() {
		return this.contstructor;
	}

	@Override
	public void write(String indent, BufferedWriter br) throws IOException {
		br.write("class " + this.getName());
		if (this.hasSuperClass()) {
			br.write("(" + this.getSuperClass() + "):\n");
		} else {
			br.write(":\n");
		}
		if (this.hasDocString()) {
			br.write("    " + this.getFormatedDocString() + "\n");
		}
		
		if(this.contstructor != null) {
			br.write("\n");
			this.contstructor.write(indent, br);
		}

		// Write fields and methods.
		boolean hasBody;
		hasBody = this.writeFields(br, indent);
		hasBody |= this.writeFunctions(br, indent);

		if (!hasBody) {
			br.write("    pass\n\n");
		}

		// Write inner classes.
		for (ModuleClass moduleClass : this.getClasses()) {
			moduleClass.write(indent + "    ", br);
		}
	}
}