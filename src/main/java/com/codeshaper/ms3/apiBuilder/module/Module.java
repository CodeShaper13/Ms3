package com.codeshaper.ms3.apiBuilder.module;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.util.Logger;
import com.codeshaper.ms3.util.Util;

/**
 * Represents a python module and its contents.
 */
public class Module extends AttributeHolder {
	
	@Nullable
	/** Null if the module should be in the root folder */
	private final String modulePath;
	
	public Module(Class<?> clazz) {
		this(clazz.getSimpleName(), Util.getPydValue(clazz));
	}
	
	/**
	 * Used by DynamicModule
	 */
	public Module(String moduleName, String docString) {
		super(moduleName, docString);
		
		this.modulePath = "com/" + Ms3.AUTHOR + "/" + Ms3.MOD_ID + "/api";
	}
	
	public Module(String moduleName) {
		this(moduleName, StringUtils.EMPTY);
	}

	/**
	 * Generates a file for this module, writing the module contents too it
	 * @param rootFolder The folder that this module is to be in
	 */
	public void generateModuleFile(File rootFolder) {
		File dest = rootFolder;
		if(this.modulePath != null) {
			dest = new File(rootFolder, "/" + this.modulePath + "/");
			dest.mkdirs();
		}		
		File moduleFile = new File(dest, this.getName() + ".py");

		try {				
			BufferedWriter br = new BufferedWriter(new FileWriter(moduleFile));

			br.write("# Auto generated python file to be used by an IDE.  Don't modify this, it won't do anything.\n\n");
			if(this.hasDocString()) {
				br.write(this.getFormatedDocString() + "\n");
			}

			this.writeFields(br, this.getFields(), "");
			this.writeFunctions(br, this.getFunctions(), "");

			for (ModuleClass clazz : this.getClasses()) {
				this.writeModuleClass(br, clazz, "    ");
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			Logger.err("Unable to create auto generated module " + this.getName());
		}
	}
	
	private void writeModuleClass(BufferedWriter br, ModuleClass clazz, String indent) throws IOException {
		br.write("class " + clazz.getName());
		if(clazz.hasSuperClass()) {
			br.write("(" + clazz.getSuperClass() + "):\n");
		} else {
			br.write(":\n");
		}
		if(clazz.hasDocString()) {
			br.write("    " + clazz.getFormatedDocString() + "\n");
		}
		
		// Write fields and methods.
		boolean noBody = true;
		if(!clazz.getFields().isEmpty()) {
			this.writeFields(br, clazz.getFields(), indent);
			noBody = false;
		}
		if(!clazz.getFunctions().isEmpty()) {
			this.writeFunctions(br, clazz.getFunctions(), indent);
			noBody = false;
		}					
		if(noBody) {
			br.write("    pass\n\n");
		}
		
		// Write inner classes.
		for(ModuleClass moduleClass : clazz.getClasses()) {
			this.writeModuleClass(br, moduleClass, indent + "    ");
		}
	}
	
	private void writeFunctions(BufferedWriter br, List<ModuleFunction> functions, String indent) throws IOException {
		br.write("\n");
		for (ModuleFunction func : functions) {
			StringBuilder args = new StringBuilder();
			int length = func.getArgsLength();
			for(int i = 0; i < length; i++) {
				args.append(func.getArg(i));
				if(i != length - 1) { // Not last element.
					args.append(", ");
				}
			}
			
			br.write(indent + "def " + func.getName() + "(" + args + "):\n");
			if(func.hasDocString()) {
				br.write(indent + "    " + func.getFormatedDocString() + "\n");
			}
			br.write(indent + "    pass\n\n");
		}
	}
	
	private void writeFields(BufferedWriter br, List<ModuleField> fields, String indent) throws IOException {
		br.write("\n");
		for (ModuleField field : fields) {
			if(field.hasDocString()) {
				br.write(indent + field.getFormatedDocString() + "\n");
			}			
			br.write(indent + field.getName() + " = " + field.getFieldValue() + "\n");
		}
	}


}
