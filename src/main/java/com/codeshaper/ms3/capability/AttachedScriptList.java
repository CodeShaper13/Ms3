package com.codeshaper.ms3.capability;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.entity.Base;
import com.codeshaper.ms3.script.RunnableScript;

import net.minecraft.entity.Entity;

public class AttachedScriptList implements Iterable<AttachedScript> {

	private List<AttachedScript> attachedScripts;
	
	public AttachedScriptList() {
		this.attachedScripts = new ArrayList<AttachedScript>();
	}
	
	/**
	 * Adds the passed script to the list.
	 * 
	 * @param entity
	 * @param script
	 * @return True if the script was added, false if it wasn't because the list already contained that script.
	 */
	public boolean add(Base<? extends Entity> entity, RunnableScript script) {
		if(this.containsScript(script)) {
			return false;
		} else {
			this.attachedScripts.add(new AttachedScript(entity, script));
			return true;
		}
	}

	public boolean remove(RunnableScript script) {
		for(AttachedScript as : this.attachedScripts) {
			if(as.script.equals(script)) {
				this.attachedScripts.remove(as);
				return true;
			}
		}
		return false;
	}
	
	@Nullable
	public AttachedScript getScript(RunnableScript script) {
		for(AttachedScript as : this.attachedScripts) {
			if(as.script.equals(script)) {
				return as;
			}
		}
		return null;
	}
	
	public AttachedScript get(int index) {
		return this.attachedScripts.get(index);
	}
	
	public void removeAll() {
		this.attachedScripts.clear();
	}
	
	public int size() {
		return this.attachedScripts.size();
	}
	
	/**
	 * Checks if an instance of the passed {@link RunnableScript} is in the list.
	 * 
	 * @param script
	 * @return True if the list contains the script.
	 */
	public boolean containsScript(RunnableScript script) {
		return this.getScript(script) != null;
	}

	@Override
	public Iterator<AttachedScript> iterator() {
		return this.attachedScripts.iterator();
	}
}
