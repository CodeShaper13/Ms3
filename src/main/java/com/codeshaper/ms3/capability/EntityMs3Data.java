package com.codeshaper.ms3.capability;

import java.util.HashMap;

import javax.annotation.Nullable;

import org.python.core.PyException;
import org.python.core.PyList;

import com.codeshaper.ms3.EnumCallbackType;
import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.BoundObject;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.exception.MissingScriptException;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.util.MessageUtil;

import net.minecraft.entity.Entity;

public class EntityMs3Data implements IEntityMs3Data {

	/** A HashMap of all of the properties saved to this Entity. */
	private HashMap<String, Object> properties = new HashMap<>();
	private AttachedScriptList attachedScripts = new AttachedScriptList();

	private boolean clearMethodCall;
	
	public Entity e;
	
	public EntityMs3Data() {
		throw new UnsupportedOperationException();
	}
	
	public EntityMs3Data(Entity entity) {
		this.e = entity;
	}

	@Override
	public boolean addBoundScript(entity.Base<? extends Entity> entity, String pathToScript, @Nullable PyList args)
			throws PyException, MissingScriptException {
		RunnableScript runnableScript = new RunnableScript(pathToScript, args);
		// runnableScript.tryThrowMissingScript();
		return this.addBoundScript(entity, runnableScript);
	}

	@Override
	public boolean addBoundScript(entity.Base<? extends Entity> entity, RunnableScript runnableScript) {
		return this.attachedScripts.add(entity, runnableScript); // TODO handle error
	}

	@Override
	public void removeBoundScript(RunnableScript script) {
		this.attachedScripts.remove(script);
	}

	@Override
	public void removeAllBoundScripts() {
		this.attachedScripts.removeAll();
	}

	@Override
	@Nullable
	public AttachedScript getBoundScript(RunnableScript script) {
		return this.attachedScripts.getScript(script);
	}

	@Override
	public AttachedScriptList getScriptList() {
		return this.attachedScripts;
	}

	@Override
	public void setCustomProperty(String identifier, Object value) {
		this.properties.put(identifier, value);
	}

	@Override
	public Object getCustomProperty(String identifier) {
		return this.properties.get(identifier);
	}

	@Override
	public void removeCustomProperty(String identifer) {
		this.properties.remove(identifer);
	}

	@Override
	public HashMap<String, Object> getPropertyMap() {
		return this.properties;
	}

	@Override
	public void runCallback(EnumCallbackType type, Object... args) {
		PyInterpreter interpreter = Ms3.getDefaultInterpreter();

		try {
			for (int i = this.attachedScripts.size() - 1; i >= 0; i--) {
				BoundObject instance = this.attachedScripts.get(i).getInstance();
				switch (type) {
				case ON_CONSTRUCT:
					instance.onConstruct();
					break;
				case ON_TICK:
					instance.onTick();
					break;
				case ON_LOAD:
					instance.onLoad();
					break;
				case ON_SAVE:
					instance.onSave();
					break;
				case ON_CLICK:
					instance.onClick((entity.Player) entity.getWrapperClassForEntity((Entity) args[0]));
					break;
				}
			}
		} catch (PyException e) {
			MessageUtil.sendErrorMessageToAll("Error calling " + type.getName() + "()", e);
		}
	}
}