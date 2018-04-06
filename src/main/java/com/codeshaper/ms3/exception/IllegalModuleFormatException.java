package com.codeshaper.ms3.exception;

/**
 * Thrown when there is an error in the format of a class when it is being built
 * into a python module.
 */
public class IllegalModuleFormatException extends Error {

	public IllegalModuleFormatException(String errorMessage) {
		super(errorMessage);
	}
}
