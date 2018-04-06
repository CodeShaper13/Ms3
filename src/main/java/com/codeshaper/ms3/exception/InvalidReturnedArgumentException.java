package com.codeshaper.ms3.exception;

/**
 * Thrown when getArgs in a script fails to return a valid type.
 */
public class InvalidReturnedArgumentException extends Exception {

	private Class<?> objClass;
	private String message;
	
	public InvalidReturnedArgumentException(Object obj, String message) {
		super(message);
		
		this.objClass = obj.getClass();
		this.message = message;
	}

	public Class<?> getObjClass() {
		return objClass;
	}
	
	public String getMessage() {
		return this.message;
	}
}
