package com.codeshaper.ms3.interpreter;

import java.util.HashMap;
import java.util.Set;

public class PyInterpreterManager {
	
	public static final String DEFAULT_NAME = "default";	
	public static PyInterpreterManager instance;
	
	private HashMap<String, PyInterpreter> interpreterMap;

	public PyInterpreterManager() {
		PyInterpreterManager.instance = this;
		
		this.interpreterMap = new HashMap<String, PyInterpreter>();
		
		// Create the default interpreter.
		this.newInterpreter(DEFAULT_NAME);
	}
	
	/**
	 * @param name
	 * @return True if we created the interpreter, false if we didn't (it is already made).
	 */
	public boolean newInterpreter(String interpreterName, boolean... flags) {
		if(this.exists(interpreterName) ) {
			return false;
		} else {
			PyInterpreter interpreter = new PyInterpreter(interpreterName);
			this.interpreterMap.put(interpreterName, interpreter);
			return true;
		}
	}
	
	/**
	 * Checks if an interpreter with the passed name exists.
	 */
	public boolean exists(String interpreterName) {
		return this.interpreterMap.containsKey(interpreterName);		
	}
	
	/**
	 * Removes an Interpreter.
	 * @return True if the interpreter was deleted, false if it couldn't be found.
	 */
	public boolean deleteInterpreter(String interpreterName) {
		if(interpreterName.equals(DEFAULT_NAME)) {
			return false;
		} else {
			if(this.interpreterMap.containsKey(interpreterName)) {
				this.interpreterMap.remove(interpreterName);
				return true;
			} else {
				return false;
			}	
		}
	}
	
	/**
	 * Get an Interpreter from the list.
	 * @return The interpreter, or null if it couldn't be found.
	 */
	public PyInterpreter getInterpreter(String interpreterName) {
		if(this.interpreterMap.containsKey(interpreterName)) {
			return this.interpreterMap.get(interpreterName);
		} else {
			return null;
		}
	}
	
	/**
	 * @return An array with all the interpreterNames
	 */
	public String[] getAllInterpreterNames() {
		Set<String> keys = this.interpreterMap.keySet();
		return keys.toArray(new String[keys.size()]);
	}
}
