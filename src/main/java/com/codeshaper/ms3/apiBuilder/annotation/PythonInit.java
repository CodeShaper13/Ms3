package com.codeshaper.ms3.apiBuilder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the annotated element to be included in the __init__ file of the ms3
 * api module.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
		// ElementType.METHOD,
		ElementType.TYPE,
		// ElementType.FIELD
})
public @interface PythonInit {

}
