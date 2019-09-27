package com.codeshaper.ms3.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

/**
 * Used to mark an annotation, method, constructor, field or class as not yet
 * implemented completely. The marked element may be partially implemented or
 * just an empty class.
 * 
 * @author CodeShaper
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD,
		ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotYetImplemented {
	String notes() default StringUtils.EMPTY;
}
