package com.codeshaper.ms3.apiBuilder.module;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.util.Util;

/**
 * Abstract base class for any attribute that holds fields, methods and classes.
 * 
 * @author CodeShaper
 */
public abstract class AttributeHolder extends BaseAttribute {

	private final List<ModuleFunction> methodList;
	private final List<ModuleField> fieldList;
	private final List<ModuleClass> innerClassList;

	public AttributeHolder(String name, String docString) {
		super(name, docString);

		this.fieldList = new ArrayList<ModuleField>();
		this.methodList = new ArrayList<ModuleFunction>();
		this.innerClassList = new ArrayList<ModuleClass>();
	}

	public AttributeHolder(String name, AnnotatedElement ao) {
		this(name, Util.getPydValue(ao));
	}

	public AttributeHolder(String name) {
		this(name, StringUtils.EMPTY);
	}

	public void addField(ModuleField field) {
		this.fieldList.add(field);
	}

	public List<ModuleField> getFields() {
		return this.fieldList;
	}

	public void addFunction(ModuleFunction function) {
		this.methodList.add(function);
	}

	public List<ModuleFunction> getFunctions() {
		return this.methodList;
	}

	public void addClass(ModuleClass clazz) {
		this.innerClassList.add(clazz);
	}

	public List<ModuleClass> getClasses() {
		return this.innerClassList;
	}

	/**
	 * Writes all the fields to a file by calling {@link write} on them.
	 * 
	 * @param br
	 * @param indent
	 * @return True if at least one field was written to the file.
	 * @throws IOException
	 */
	public boolean writeFields(BufferedWriter br, String indent) throws IOException {
		if (!this.getFields().isEmpty()) {
			br.write("\n");
			for (ModuleField field : this.getFields()) {
				field.write(indent, br);
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Writes all the functions to a file by calling {@link write} on them.
	 * 
	 * @param br
	 * @param indent
	 * @return True if at least one function was written to the file.
	 * @throws IOException
	 */
	public boolean writeFunctions(BufferedWriter br, String indent) throws IOException {
		if (!this.getFunctions().isEmpty()) {
			br.write("\n");
			for (ModuleFunction func : this.getFunctions()) {
				func.write(indent, br);

			}
			return true;
		} else {
			return false;
		}
	}
}
