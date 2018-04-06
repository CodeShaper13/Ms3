package com.codeshaper.ms3.apiBuilder.module;

import java.util.ArrayList;

/**
 * Interface for anything that holds members.  Used by Module and ModuleClass
 */
public interface IMemberHolder {

	/**
	 * Adds a field to the member.
	 */
	void addField(ModuleField field);
	
	ArrayList<ModuleField> getFields();
	
	void addFunction(ModuleFunction function);
	
	ArrayList<ModuleFunction> getFunctions();
	
	/**
	 * Adds a inner class to the {@link IMemberHolder}.
	 * @param clazz The class to add.
	 */
	void addClass(ModuleClass clazz);
	
	ArrayList<ModuleClass> getClasses();
}
