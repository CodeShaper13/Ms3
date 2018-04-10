package com.codeshaper.ms3.apiBuilder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

/**
 * Marks the passed field to be added to the module generate from the field's
 * class.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PythonFieldSpecified {
	String value() default StringUtils.EMPTY;
}
