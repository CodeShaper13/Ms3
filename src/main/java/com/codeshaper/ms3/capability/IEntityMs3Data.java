package com.codeshaper.ms3.capability;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import org.python.core.PyException;
import org.python.core.PyList;
import org.python.core.PyType;

import com.codeshaper.ms3.EnumCallbackType;
import com.codeshaper.ms3.annotation.NotYetImplemented;
import com.codeshaper.ms3.api.BoundObject;
import com.codeshaper.ms3.api.exception.MissingScriptException;
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
	public void addScript(String scriptPath, @Nullable PyList args) throws PyException, MissingScriptException;

	/**
	 * Adds a script to the list of scripts.
	 */
	public void addScript(RunnableScript runnableScript);

	/**
	 * Executes every execute function that is within a script bounded to this
	 * entity.
	 */
	public void runAllExecute(Entity entity);

	/**
	 * Returns all {@link RunnableScript}s on the entity in a {@link List}
	 */
	public List<RunnableScript> getScriptList();

	public void setCustomProperty(String identifier, Object value);

	public Object getCustomProperty(String identifier);

	public void removeCustomProperty(String identifer);

	public HashMap<String, Object> getPropertyMap();

	/**
	 * Executes every onClick function that is within a bound script.
	 * 
	 * @param entity
	 *            The entity that was clicked.
	 * @param player
	 *            The player who clicked the entity.
	 */
	public void runAllOnClick(Entity entity, EntityPlayer player);

	public void setClearMethodCall();

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

	/**
	 * Adds a {@link BoundObject} to the Entity.
	 * 
	 * @param obj
	 * @return True if the object was added, False if the Entity already has an
	 *         object bound with the same type.
	 */
	@NotYetImplemented
	public boolean addObject(BoundObject obj);

	/**
	 * Returns the {@link BoundObject} that is bound to the entity with the passed
	 * key.
	 * 
	 * @param type
	 * @return
	 */
	@NotYetImplemented
	public BoundObject getObject(PyType type);
}