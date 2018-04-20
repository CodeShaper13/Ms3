package com.codeshaper.ms3.apiBuilder.module;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.util.Logger;
import com.codeshaper.ms3.util.Util;

/**
 * Represents a Python module and its contents.
 */
public class Module extends AttributeHolder {

	@Nullable
	/** Null if the module should be in the root folder */
	private final String modulePath;

	public Module(Class<?> clazz) {
		this(clazz.getSimpleName(), Util.getPydValue(clazz));
	}

	public Module(String moduleName) {
		this(moduleName, StringUtils.EMPTY);
	}

	public Module(String moduleName, String docString) {
		super(moduleName, docString);

		this.modulePath = "com/" + Ms3.AUTHOR + "/" + Ms3.MOD_ID + "/api";
	}
	
	public String getModulePath() {
		return this.modulePath;
	}

	@Override
	public void write(String indent, BufferedWriter br) throws IOException {
		br.write("# Auto generated Python file to be used by an IDE.  Don't modify this, it won't do anything.\n\n");
		if (this.hasDocString()) {
			br.write(this.getFormatedDocString() + "\n");
		}

		this.writeFields(br, "");
		this.writeFunctions(br, "");

		for (ModuleClass clazz : this.getClasses()) {
			clazz.write("    ", br);
		}
	}
}
