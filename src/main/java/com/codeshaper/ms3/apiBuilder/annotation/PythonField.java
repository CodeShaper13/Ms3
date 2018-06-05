package com.codeshaper.ms3.apiBuilder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

/**
 * Marks a field to be included in a generated Python module. The value of the
 * field can be specified and defaults to None. Used in module generation.
 * 
 * @see PythonField
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PythonField {
	String value() default StringUtils.EMPTY;
}
