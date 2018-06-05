package com.codeshaper.ms3.apiBuilder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a field where the value should be computed based on the fields value as
 * defined in the class. This should only be on fields that are both public and
 * static.  Used in module generation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PythonFieldGenerated {
}
