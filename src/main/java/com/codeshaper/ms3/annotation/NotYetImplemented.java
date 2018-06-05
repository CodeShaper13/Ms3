package com.codeshaper.ms3.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

/**
 * Used to mark an annotation, method, constructor, field or class as not yet
 * fully implemented.
 * 
 * @author CodeShaper
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotYetImplemented {
	String notes() default StringUtils.EMPTY;
}
