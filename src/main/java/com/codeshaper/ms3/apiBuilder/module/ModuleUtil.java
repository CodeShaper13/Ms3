package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.AnnotatedElement;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;

public class ModuleUtil {

	private ModuleUtil() {
	}

	/**
	 * Checks the passed {@link AnnotatedElement} for a doc string by looking for a
	 * {@link PythonDocString} annotation. If it has one, the doc string is
	 * returned. If not or if the annotation contains null, null is returned.
	 */
	public static @Nullable String getPydValue(AnnotatedElement element) {
		PythonDocString pythonDocString = element.getAnnotation(PythonDocString.class);
		return pythonDocString != null && !StringUtils.isBlank(pythonDocString.value()) ? pythonDocString.value()
				: null;
	}
}
