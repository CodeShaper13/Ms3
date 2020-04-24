package com.codeshaper.ms3.interpreter;

import java.util.HashMap;
import java.util.Set;

/**
 * @author CodeShaper
 */
public class PyInterpreterManager {

	public static final String DEFAULT_NAME = "default";

	private HashMap<String, PyInterpreter> interpreterMap;

	/**
	 * Creates a new InterpreterManager and a default interpreter, named "default".
	 */
	public PyInterpreterManager() {
		this.interpreterMap = new HashMap<String, PyInterpreter>();

		// Create the default interpreter.
		this.newInterpreter(DEFAULT_NAME);
	}

	/**
	 * Creates a new interpreter.
	 * 
	 * @param name
	 * @return <code>True</code> if the interpreter was created, <code>false</code>
	 *         if it wasn't (an interpreter already exists with the same name).
	 */
	public boolean newInterpreter(String interpreterName, boolean... flags) {
		if (this.interpreterExists(interpreterName)) {
			return false;
		} else {
			PyInterpreter interpreter = new PyInterpreter(interpreterName);
			this.interpreterMap.put(interpreterName, interpreter);
			return true;
		}
	}

	/**
	 * Checks if an interpreter with the passed name exists.
	 * 
	 * @param interpreterName The name of the interpreter.
	 * @return <code>True</code> if the interpreter exists, <code>false</code> if it
	 *         does not.
	 */
	public boolean interpreterExists(String interpreterName) {
		return this.interpreterMap.containsKey(interpreterName);
	}

	/**
	 * Removes an Interpreter.
	 * 
	 * @return True if the interpreter was deleted, false if it couldn't be found.
	 */
	public boolean deleteInterpreter(String interpreterName) {
		if (interpreterName.equals(DEFAULT_NAME)) {
			return false;
		} else {
			if (this.interpreterMap.containsKey(interpreterName)) {
				this.interpreterMap.remove(interpreterName);
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Get an Interpreter from the list.
	 * 
	 * @return The interpreter, or null if it couldn't be found.
	 */
	public PyInterpreter getInterpreter(String interpreterName) {
		if (this.interpreterMap.containsKey(interpreterName)) {
			return this.interpreterMap.get(interpreterName);
		} else {
			return null;
		}
	}

	/**
	 * Gets an array with all the interpreter names.
	 */
	public String[] getAllInterpreterNames() {
		Set<String> keys = this.interpreterMap.keySet();
		return keys.toArray(new String[keys.size()]);
	}
}
