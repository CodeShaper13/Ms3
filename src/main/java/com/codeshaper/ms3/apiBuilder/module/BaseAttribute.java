package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.AnnotatedElement;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.util.Util;

/**
 * Abstract base class for any attribute that would contain both a name and doc string.
 * 
 * @author CodeShaper
 */
public abstract class BaseAttribute implements IWritable {

	private final String name;
	private final String docString;

	public BaseAttribute(String name, AnnotatedElement ao) {
		this(name, Util.getPydValue(ao));
	}

	public BaseAttribute(String name, String docString) {
		this.name = name;
		this.docString = docString;
	}

	public BaseAttribute(String name) {
		this(name, StringUtils.EMPTY);
	}

	/**
	 * Checks if the doc string is not null or empty.
	 * 
	 * @return True True if the doc string has content, false otherwise.
	 */
	public boolean hasDocString() {
		return StringUtils.isNotEmpty(this.docString);
	}

	/**
	 * Gets to doc string formatted to be put right into a python script file. The
	 * doc string is surrounded with triple quotes already.
	 */
	public String getFormatedDocString() {
		return "\"\"\" " + this.docString + " \"\"\"";
	}

	/**
	 * Gets the name of the member.
	 */
	public String getName() {
		return this.name;
	}
}
