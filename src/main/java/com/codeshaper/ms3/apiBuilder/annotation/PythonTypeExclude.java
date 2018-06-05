package com.codeshaper.ms3.apiBuilder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Stops the Python module generator from including the parameter's type in its
 * name. Recommended to use when the parameter is of type object because multiple types are
 * accepted.
 * 
 * @author CodeShaper
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface PythonTypeExclude {
}