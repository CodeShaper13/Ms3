package com.codeshaper.ms3.capability;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import org.python.core.PyException;
import org.python.core.PyList;

import com.codeshaper.ms3.api.exception.missingScriptException;
import com.codeshaper.ms3.script.RunnableScript;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface IBoundScript {

	public void addScript(String scriptPath, @Nullable PyList args) throws PyException, missingScriptException;

	public void addScript(RunnableScript rs);
	
	/**
	 * Executes every execute function that is within a bound script.
	 * @param entity
	 */
	public void runAllExecute(Entity entity);

	public List<RunnableScript> getScriptList();
	
	public void setCustomProperty(String identifier, Object value);
	
	public Object getCustomProperty(String identifier);
	
	public void removeCustomProperty(String identifer);
	
	public HashMap<String, Object> getPropertyMap();

	/**
	 * Executes every onClick function that is within a bound script.
	 * @param entity The entity that was clicked.
	 * @param player The player who clicked the entity.
	 */
	public void runAllOnClick(Entity entity, EntityPlayer player);

	public void setClearMethodCall();
}