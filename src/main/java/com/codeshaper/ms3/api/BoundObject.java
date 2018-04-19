package com.codeshaper.ms3.api;

import org.python.core.PyClass;
import org.python.core.PyObject;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.entity.Entity;

public class BoundObject extends PyObject {
	
	private entity.Base<Entity> entity;
	
	public BoundObject(entity.Base<Entity> e) {
		super();
		this.entity = e;
	}

	@PythonFunction
	public void onBind() {
		
	}
	
	@PythonFunction
	public void onTick() {
		
	}
	
	@PythonFunction
	public void onLoad() {
		
	}
	
	@PythonFunction
	public void onSave() {
		
	}
	
	@PythonFunction
	@PythonDocString("Calls self.entity.setProperty and prefixs propertyName with the type name of this object.")
	protected final void setProperty(String propertyName, @PythonTypeExclude Object value) {
		this.entity.setProperty(this.getPrefix() + "." + propertyName, value);
	}
	
	@PythonFunction
	@PythonDocString("")
	protected final Object readProperty(String propertyName) {
		return this.entity.getProperty(this.getPrefix() + "." + propertyName);
	}
	
	public final String getPrefix() {
		return this.getType().getName();
	}
}
