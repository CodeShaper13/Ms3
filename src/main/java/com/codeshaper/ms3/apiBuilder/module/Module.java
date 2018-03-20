package com.codeshaper.ms3.apiBuilder.module;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.MS3;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.util.Logger;
import com.codeshaper.ms3.util.Util;

/**
 * Represents a python module and its contents.
 */
public class Module implements IMemberHolder {
	
	public String moduleName;
	/** Null if the module should be in the root folder */
	public String modulePath;
	/** Null if there is no doc */
	public String docString;
	private ArrayList<ModuleField> fieldList;
	private ArrayList<ModuleFunction> functionList;
	public ArrayList<ModuleClass> classList;
	
	private Module() {
		this.fieldList = new ArrayList<ModuleField>();
		this.functionList = new ArrayList<ModuleFunction>();
		this.classList = new ArrayList<ModuleClass>();
	}
	
	public Module(Class clazz) {
		this();
		
		this.moduleName = clazz.getSimpleName();
		
		String s = clazz.getCanonicalName().replace('.', '/');
		this.modulePath = s.substring(0, s.lastIndexOf('/'));
		
		this.docString = Util.getPydValue(clazz);
	}
	
	/**
	 * Called by DynamicModule
	 */
	public Module(String name, String docString) {
		this();
		
		this.moduleName = name;
		this.modulePath = "com/" + MS3.AUTHOR + "/" + MS3.MOD_ID;
		this.docString = docString;
	}
	
	@Override
	public void addField(ModuleField field) {
		this.fieldList.add(field);
	}

	@Override
	public ArrayList<ModuleField> getFields() {
		return this.fieldList;
	}

	@Override
	public void addFunction(ModuleFunction function) {
		this.functionList.add(function);
	}

	@Override
	public ArrayList<ModuleFunction> getFunctions() {
		return this.functionList;
	}
	
	@Override
	public void addClass(ModuleClass clazz) {
		this.classList.add(clazz);		
	}

	@Override
	public ArrayList<ModuleClass> getClasses() {
		return this.classList;
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
		File moduleFile = new File(dest, this.moduleName + ".py");

		try {				
			BufferedWriter br = new BufferedWriter(new FileWriter(moduleFile));

			br.write("# Auto generated python file to be used by an IDE.  Don't modify this, it won't do anything.\n\n");
			if(this.docString != null) {
				br.write("\"\"\" " + this.docString + " \"\"\"\n");
			}

			this.writeFields(br, this.fieldList, "");
			this.writeFunctions(br, this.functionList, "");

			for (ModuleClass clazz : this.classList) {
				this.writeModuleClass(br, clazz, "    ");
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			Logger.err("Unable to create auto generated module " + this.moduleName);
		}
	}
	
	private void writeModuleClass(BufferedWriter br, ModuleClass clazz, String indent) throws IOException {
		br.write("class " + clazz.name);
		if(clazz.superClassName != null) {
			br.write("(" + clazz.superClassName + "):\n");
		} else {
			br.write(":\n");
		}
		if(clazz.docString != null) {
			br.write("    \"\"\" " + clazz.docString + " \"\"\"\n");
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
	
	private void writeFunctions(BufferedWriter br, ArrayList<ModuleFunction> functions, String indent) throws IOException {
		br.write("\n");
		for (ModuleFunction func : functions) {
			StringBuilder args = new StringBuilder();
			int length = func.argNames.length;
			for(int i = 0; i < length; i++) {
				args.append(func.argNames[i]);
				if(i != length - 1) { // Not last element.
					args.append(", ");
				}
			}
			
			br.write(indent + "def " + func.name + "(" + args + "):\n");
			if(func.docString != null) {
				br.write(indent + "    " + func.getFormatedDocString() + "\n");
			}
			br.write(indent + "    pass\n\n");
		}
	}
	
	private void writeFields(BufferedWriter br, ArrayList<ModuleField> fields, String indent) throws IOException {
		br.write("\n");
		for (ModuleField field : fields) {
			if(field.docString != null) {
				br.write(indent + field.getFormatedDocString() + "\n");
			}			
			br.write(indent + field.name + field.getFieldValue() + "\n");
		}
	}


}
