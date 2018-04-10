package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldSpecified;
import com.codeshaper.ms3.exception.IllegalModuleFormatException;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

public class ModuleField extends ModuleMember {

	private String value;

	public ModuleField(Field field) {
		super(field, field);

		if (field.isAnnotationPresent(PythonField.class)) {
			int mod = field.getModifiers();
			if(Modifier.isStatic(mod) && Modifier.isPublic(mod)) {
				Object obj = null;
				try {
					obj = field.get(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(obj == null) {
					this.value = "None";
				} else if(obj instanceof String || obj instanceof Character) {
					this.value = "\"" + obj.toString() + "\"";
				} else {
					this.value = obj.toString();
				}	
			} else {
				throw new IllegalModuleFormatException(field.toString() + " was found with a PythonField annotation, but it was not marked as public and static!");
			}
		} else {
			PythonFieldSpecified pf = field.getAnnotation(PythonFieldSpecified.class);
			String v = pf.value();
			this.value = (v.equals("") ? "None" : StringUtils.isNumeric(v) ? v : ("\"" + v + "\""));

		}
	}

	public ModuleField(String name) {
		super(name);

		this.value = "None";
	}

	public String getFieldValue() {
		return this.value;
	}
}
