package com.codeshaper.ms3.interpreter;

import java.util.HashMap;
import java.util.Set;

import com.codeshaper.ms3.MS3;

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
	
	public boolean exists(String interpreterName) {
		return this.interpreterMap.containsKey(interpreterName);		
	}
	
	/**
	 * @param interpreterName
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
	 * @param interpreterName
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
