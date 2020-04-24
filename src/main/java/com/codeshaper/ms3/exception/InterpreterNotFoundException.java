package com.codeshaper.ms3.exception;

/**
 * Thrown when an interpreter can't be found via any reason.
 * 
 * @author CodeShaper
 */
public class InterpreterNotFoundException extends Exception {

	public InterpreterNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}