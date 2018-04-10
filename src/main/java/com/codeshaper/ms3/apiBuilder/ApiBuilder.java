package com.codeshaper.ms3.apiBuilder;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonConstructor;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldSpecified;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.apiBuilder.classGenerator.CGRegisteredNamespace;
import com.codeshaper.ms3.apiBuilder.module.IMemberHolder;
import com.codeshaper.ms3.apiBuilder.module.Module;
import com.codeshaper.ms3.apiBuilder.module.ModuleClass;
import com.codeshaper.ms3.apiBuilder.module.ModuleConstructor;
import com.codeshaper.ms3.apiBuilder.module.ModuleField;
import com.codeshaper.ms3.apiBuilder.module.ModuleFunction;
import com.codeshaper.ms3.exception.IllegalModuleFormatException;
import com.codeshaper.ms3.util.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;

/**
 * Responsible for creating the auto generated python modules
 */
public class ApiBuilder {

	private BuildList buildList;

	@SuppressWarnings("unused")
	public ApiBuilder() {
		this.buildList = new BuildList();

		// Generate java class files to copy into project. For developing only!
		if (false) {
			File outputFolder = new File(System.getProperty("user.home")
					+ "\\Desktop\\Forge Workspace\\Ms3\\src\\main\\java\\com\\codeshaper\\ms3\\api");
			new CGRegisteredNamespace(Block.REGISTRY).generateClass("block", outputFolder);
			new CGRegisteredNamespace(Item.REGISTRY).generateClass("item", outputFolder);
			new CGRegisteredNamespace(Biome.REGISTRY).generateClass("biome", outputFolder);
			new CGRegisteredNamespace(SoundEvent.REGISTRY).generateClass("sound", outputFolder);
		}
	}

	/**
	 * Checks if the api is missing and returns the result.
	 */
	private boolean doesApiExist() {
		File f = Ms3.dirManager.getApiFolder();
		return f.exists() && f.isDirectory();
	}

	public void buildApiIfNeeded() {
		if (Ms3.configManager.getAlwaysRebuild() || !this.doesApiExist() || Ms3.DEBUG_MODE) {
			Logger.msg("Starting Api Building!");
			this.buildApi();
			Logger.msg("Finished Api Building!");
		}
	}

	/**
	 * Builds the api, generating all of the python files.
	 */
	public void buildApi() {
		ArrayList<Module> moduleList = new ArrayList<Module>();

		for (Class<?> classToBuild : this.buildList.classList) {
			// Create the module to representing the base class.
			Module module = new Module(classToBuild);
			this.generateClass(null, module, classToBuild);
			moduleList.add(module);
		}

		// For every module, generate the file on the system.
		for (Module module : moduleList) {
			module.generateModuleFile(Ms3.dirManager.getApiFolder());
		}

		this.generateInitFiles();
	}

	/**
	 * Creates the __init__.py files so PyDev and other plugins will find our
	 * modules.
	 */
	private void generateInitFiles() {
		File folder = Ms3.dirManager.getApiFolder();
		File initFile;
		for (String s : new String[] { "", "com", "codeshaper", "ms3", "api" }) {
			folder = new File(folder, s);
			initFile = new File(folder, "__init__.py");
			try {
				initFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				Logger.msg("Error creating __init__.py file, ide support may not work!");
			}
		}
	}

	/**
	 * Navigates a class, generating the content and recursively calling this on all inner
	 * classes. parentHolder is null on root classes.
	 * 
	 * @param parentHolder Pass null for outer/top level classes.
	 * @param holder
	 * @param classOfHolder
	 * @throws IllegalModuleFormatException
	 */
	private void generateClass(IMemberHolder parentHolder, IMemberHolder holder, Class<?> classOfHolder)
			throws IllegalModuleFormatException {
		// Add constructors.
		for (Constructor<?> ctor : classOfHolder.getConstructors()) {
			if (ctor.isAnnotationPresent(PythonConstructor.class)) {
				if (parentHolder == null) {
					throw new IllegalModuleFormatException("Found a constructor on a root class!");
				} else if (holder instanceof ModuleClass) {
					((ModuleClass) holder).setConstructor(new ModuleConstructor(ctor));
				} else {
					throw new IllegalModuleFormatException(
							"Found a constructor on a class that isn't marked as a ModuleClass!");
				}
			}
		}

		// Add fields.
		for (Field field : classOfHolder.getDeclaredFields()) {
			if (field.isAnnotationPresent(PythonFieldSpecified.class) || field.isAnnotationPresent(PythonField.class)) {
				holder.addField(new ModuleField(field));
			}
		}

		// Add methods.
		for (Method method : classOfHolder.getDeclaredMethods()) {
			if (method.isAnnotationPresent(PythonFunction.class)) {
				holder.addFunction(new ModuleFunction(method));
			}
		}

		// Add this class as an inner class of the parent class.
		if (parentHolder != null) {
			parentHolder.addClass((ModuleClass) holder);
		}

		// Call this method recursively on all the inner classes.
		for (Class<?> innerClass : classOfHolder.getClasses()) {
			if (innerClass.isAnnotationPresent(PythonClass.class)) {
				this.generateClass(holder, new ModuleClass(innerClass), innerClass);
			}
		}
	}
}