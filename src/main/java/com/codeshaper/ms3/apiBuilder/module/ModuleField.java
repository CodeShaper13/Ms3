package com.codeshaper.ms3.apiBuilder.module;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.exception.IllegalModuleFormatException;

public class ModuleField extends BaseAttribute {

	private static final String NONE = "None";

	private final String value;

	public ModuleField(Field field) {
		super(field.getName(), field);

		if (field.isAnnotationPresent(PythonFieldGenerated.class)) {
			// Tries to find the value of the field, throwing an exception if the field is not both public and static.
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) && Modifier.isPublic(mod)) {
				Object obj = null;
				try {
					obj = field.get(null);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (obj == null) {
					this.value = NONE;
				} else if (obj instanceof String || obj instanceof Character) {
					this.value = "\"" + obj.toString() + "\"";
				} else {
					this.value = obj.toString();
				}
			} else {
				throw new IllegalModuleFormatException(field.toString()
						+ " was found with a PythonFieldGenerated annotation, but it was not marked as public and static!");
			}
		} else {
			PythonField pf = field.getAnnotation(PythonField.class);
			String v = pf.value();
			this.value = (v.equals(StringUtils.EMPTY) ? NONE : StringUtils.isNumeric(v) ? v : ("\"" + v + "\""));

		}
	}

	public ModuleField(String name, @Nullable String value) {
		super(name);

		this.value = (value != null ? value : NONE);
	}

	/**
	 * Returns the value of the field as a String to be written to a file.
	 */
	public String getFieldValue() {
		return this.value;
	}

	@Override
	public void write(String indent, BufferedWriter br) throws IOException {
		if(this.hasDocString()) {
			br.write(indent + this.getFormatedDocString() + "\n");
		}			
		br.write(indent + this.getName() + " = " + this.getFieldValue() + "\n");

	}
}
