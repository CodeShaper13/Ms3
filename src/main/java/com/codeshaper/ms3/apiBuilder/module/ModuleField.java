package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

public class ModuleField extends ModuleMember {

	private String value;
	
	public ModuleField(Field field) {
		super(field, field);
		
		PythonField pf = field.getAnnotation(PythonField.class);
		String v = pf.value();
		this.value = " = " + (v.equals("") ? "None" : StringUtils.isNumeric(v) ? v : ("\"" + v + "\""));
	}

	public ModuleField(String name) {
		super(name);
		
		this.value = " = None";
	}
	
	public String getFieldValue() {
		return this.value;
	}
}
