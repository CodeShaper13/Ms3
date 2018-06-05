package com.codeshaper.ms3.apiBuilder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

/**
 * Changes the name of a type when the Python module is generated from the auto
 * generated name to a specific string.
 * 
 * @author CodeShaper
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface PythonTypeName {
	String value() default StringUtils.EMPTY;
}
