package com.codeshaper.ms3.api;

import org.python.core.PyException;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonConstructor;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

public class exception {

	public static exception instance = new exception();
	
	@PythonClass
	@PythonDocString("Thrown from util.scheduleScript when the script can't be found.")
	public class MissingScriptException extends PyException {

		@PythonField
		@PythonDocString("The path to the missing script from the scripts folder.")
		public String path;
		
		@PythonConstructor
		public MissingScriptException(String message, String pathToScript) {
			super();
			
			this.path = pathToScript;
		}
	}
}
