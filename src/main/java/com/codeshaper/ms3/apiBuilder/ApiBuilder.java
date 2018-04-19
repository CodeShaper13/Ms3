package com.codeshaper.ms3.apiBuilder;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.annotation.Nullable;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonConstructor;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldSpecified;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.apiBuilder.annotation.PythonInit;
import com.codeshaper.ms3.apiBuilder.classGenerator.CGRegisteredNamespace;
import com.codeshaper.ms3.apiBuilder.module.AttributeHolder;
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
	private File apiFolder;

	private ApiPackage apiPackage;

	@SuppressWarnings("unused")
	public ApiBuilder(File apiFolder) {
		this.buildList = new BuildList();
		this.apiFolder = apiFolder;

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
		return this.apiFolder.exists() && this.apiFolder.isDirectory();
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

		this.apiPackage = new ApiPackage();

		for (Class<?> classToBuild : this.buildList.classList) {
			// Create the module to representing the base class.
			boolean flag = classToBuild.isAnnotationPresent(PythonInit.class);

			if (flag) {
				this.generateClass(this.apiPackage.getModule(), new ModuleClass(classToBuild), classToBuild);
			} else {
				Module module = new Module(classToBuild);
				this.generateClass(null, module, classToBuild);
				moduleList.add(module);
			}
		}

		moduleList.add(this.apiPackage.getModule());

		// For every module, generate the file on the system.
		for (Module module : moduleList) {
			module.generateModuleFile(this.apiFolder);
		}

		this.generateInitFiles();
	}

	/**
	 * Creates the __init__.py files so PyDev and other plugins will find our
	 * modules.
	 */
	private void generateInitFiles() {
		File folder = this.apiFolder;
		File initFile;
		for (String s : new String[] { "", "com", "codeshaper", "ms3" }) {
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
	 * Navigates a class, generating the content and recursively calling this on all
	 * inner classes. parentHolder is null on root classes.
	 * 
	 * @param parentHolder
	 *            Pass null for outer/top level classes.
	 * @param holder
	 * @param classOfHolder
	 * @throws IllegalModuleFormatException
	 */
	private void generateClass(@Nullable AttributeHolder parentHolder, AttributeHolder holder, Class<?> classOfHolder)
			throws IllegalModuleFormatException {

		// Add constructors.
		for (Constructor<?> ctor : classOfHolder.getConstructors()) {
			if (ctor.isAnnotationPresent(PythonConstructor.class)) {
				if (parentHolder == null) {
					throw new IllegalModuleFormatException(
							"Found a constructor on root class " + classOfHolder.getName() + "!");
				} else if (holder instanceof ModuleClass) {
					((ModuleClass) holder).setConstructor(new ModuleConstructor(ctor));
				} else {
					throw new IllegalModuleFormatException("Found a constructor on a class (" + classOfHolder.getName()
							+ ") that isn't marked as a ModuleClass!");
				}
			}
		}

		// Add fields.
		for (Field field : classOfHolder.getDeclaredFields()) {
			if (field.isAnnotationPresent(PythonFieldSpecified.class) || field.isAnnotationPresent(PythonField.class)) {
				ModuleField mf = new ModuleField(field);
				if (field.isAnnotationPresent(PythonInit.class)) {
					this.apiPackage.addField(mf);
				} else {
					holder.addField(mf);
				}
			}
		}

		// Add methods.
		for (Method method : classOfHolder.getDeclaredMethods()) {
			if (method.isAnnotationPresent(PythonFunction.class)) {
				ModuleFunction mfunc = new ModuleFunction(method);
				if (method.isAnnotationPresent(PythonInit.class)) {
					this.apiPackage.addFunction(mfunc);
				} else {
					holder.addFunction(mfunc);
				}
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