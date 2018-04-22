package com.codeshaper.ms3.capability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import org.python.core.PyException;
import org.python.core.PyList;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.BoundObject;
import com.codeshaper.ms3.api.exception.MissingScriptException;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.script.RunnableScript;

import net.minecraft.command.CommandException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class EntityMs3Data implements IEntityMs3Data {

	private List<RunnableScript> scripts = new ArrayList<RunnableScript>();
	private HashMap<String, Object> properties = new HashMap<>();
	
	private boolean clearMethodCall;

	@Override
	public void addScript(String pathToScript, @Nullable PyList args) throws PyException, MissingScriptException {
		RunnableScript runnableScript = new RunnableScript(pathToScript, args);
		runnableScript.tryThrowMissingScript();
		this.addScript(runnableScript);
	}

	@Override
	public void addScript(RunnableScript runnableScript) {
		this.scripts.add(runnableScript);
	}

	@Override
	public void runAllOnClick(Entity entity, EntityPlayer player) {
		PyInterpreter interpreter = Ms3.getInterpreter();
		for (RunnableScript runnableScript : this.scripts) {
			// TODO print error message if the script can't be found.
			if (!runnableScript.exists()) {
				System.out.println("script not found!");
			} else {
				interpreter.runOnClick(runnableScript, entity, player);
			}
		}
	}

	@Override
	public void runAllExecute(Entity entity) {
		PyInterpreter interpreter = Ms3.getInterpreter();
		for (RunnableScript runnableScript : this.scripts) {
			// TODO print error message if the script can't be found.
			if (!runnableScript.exists()) {
				System.out.println(runnableScript.getFile().toString());
				System.out.println("script not found!");
			} else {
				try {
					interpreter.runExecute(runnableScript, entity);
				} catch (CommandException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(this.clearMethodCall) {
			this.scripts.clear();
			this.clearMethodCall = false;
		}
	}

	@Override
	public List<RunnableScript> getScriptList() {
		return this.scripts;
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
	public void setClearMethodCall() {
		this.clearMethodCall = true;
	}
}