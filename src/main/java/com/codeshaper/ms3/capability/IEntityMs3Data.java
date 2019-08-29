package com.codeshaper.ms3.capability;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import org.python.core.PyException;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyType;

import com.codeshaper.ms3.EnumCallbackType;
import com.codeshaper.ms3.annotation.NotYetImplemented;
import com.codeshaper.ms3.api.BoundObject;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.exception.MissingScriptException;
import com.codeshaper.ms3.script.PythonScript;
import com.codeshaper.ms3.script.RunnableScript;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface IEntityMs3Data {

	/**
	 * Adds a script to the list of scripts.
	 * 
	 * @param scriptPath
	 * @param args
	 * @throws PyException
	 *             If the arguments are not of a valid type.
	 * @throws MissingScriptException
	 *             If the script file can not be found.
	 */
	public boolean addBoundScript(entity.Base<? extends Entity> entity, String scriptPath, @Nullable PyList args) throws PyException, MissingScriptException;

	/**
	 * Adds a script to the list of scripts.
	 */
	public boolean addBoundScript(entity.Base<? extends Entity> entity, RunnableScript runnableScript);

	public void removeBoundScript(String scriptPath);
	
	public void removeAllBoundScripts();
	
	public AttachedScript getBoundScript(String scriptPath);
	
	/**
	 * Gets a list of all the {@link RunnableScript}s on the entity.
	 * 
	 * @return The list.
	 */
	public AttachedScriptList getScriptList();

	/**
	 * Sets a custom property on the Entity.
	 * 
	 * @param identifier
	 *            A {@link String} that acts as the unique key for the data.
	 * @param value
	 *            A {@link Object} that is the data. See
	 *            {@link com.codeshaper.ms3.api.entity#setProperty} for the
	 *            validator of what types work.
	 */
	public void setCustomProperty(String identifier, Object value);

	/**
	 * Gets a custom property from the Entity. Returns Null if there was no value
	 * assigned to the key.
	 * 
	 * @param identifier
	 *            A {@link String} that acts as the unique key for the data.
	 * @return The value, or null if there is no value associated with the key.
	 */
	@Nullable
	public Object getCustomProperty(String identifier);

	/**
	 * Removes a custom property from the Entity.
	 * 
	 * @param identifer
	 *            A {@link String} that acts as the unique key for the data.
	 */
	public void removeCustomProperty(String identifer);

	/**
	 * Gets a HashMap containing all of the Entity's properties.
	 */
	public HashMap<String, Object> getPropertyMap();

	/**
	 * Calls one of the defined callbacks in {@link EnumCallbackType} and calls that
	 * method on every {@link BoundObject} that is bound to this Entity.
	 * 
	 * @param type
	 *            The callback to call.
	 * @param args
	 *            Optional arguments to pass into the called method.
	 */
	public void runCallback(EnumCallbackType type, Object... args);
}