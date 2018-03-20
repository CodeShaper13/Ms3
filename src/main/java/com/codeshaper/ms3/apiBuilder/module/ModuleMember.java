package com.codeshaper.ms3.apiBuilder.module;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.util.Util;

/**
 * Base class for anything that is a member of a modules, functions, fields and constructors.
 */
public class ModuleMember {
	
	public String name;
	@Nullable
	public String docString;
	public boolean isStatic;
	
	public ModuleMember(AccessibleObject ao, Member member) {
		this.name = member.getName();		
		this.docString = Util.getPydValue(ao);
		this.isStatic = Modifier.isStatic(member.getModifiers());
	}
	
	public ModuleMember(String name) {
		this.name = name;
	}
	
	public ModuleMember setStatic(boolean flag) {
		this.isStatic = flag;
		return this;
	}
	
	public ModuleMember setDocString(String docString) {
		this.docString = docString;
		return this;		
	}
	
	public String getFormatedDocString() {
		return "\"\"\" " + this.docString + " \"\"\"";
	}
}
