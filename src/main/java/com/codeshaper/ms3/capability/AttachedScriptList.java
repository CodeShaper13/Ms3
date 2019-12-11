package com.codeshaper.ms3.capability;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import com.codeshaper.ms3.api.BoundObject;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.entity.Base;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.util.textBuilder.TextBuilder;
import com.codeshaper.ms3.util.textBuilder.TextBuilderTrans;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.TextFormatting;

/**
 * A collection of {@link AttachedScript}s that can be accessed by the location
 * that they were defined, in the form of {@link RunnableScript}s, or a numeric
 * index.
 * 
 * @author CodeShaper
 */
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
	 * @return True if the script was added, false if it wasn't because the list
	 *         already contained that script.
	 */
	public boolean add(Base<? extends Entity> entity, RunnableScript script) {
		if (this.containsScript(script)) {
			return false;
		} else {
			this.attachedScripts.add(new AttachedScript(entity, script));
			return true;
		}
	}

	/**
	 * Removes a specific script from the list.
	 * 
	 * @param script
	 * @return True if the {@link RunnableScript} was removed, false if the list
	 *         didn't contain the passed {@link RunnableScript}
	 */
	public boolean remove(RunnableScript script) {
		for (AttachedScript as : this.attachedScripts) {
			if (as.getLocation().equals(script)) {
				this.attachedScripts.remove(as);
				return true;
			}
		}
		return false;
	}

	@Nullable
	public AttachedScript getScript(RunnableScript script) {
		for (AttachedScript as : this.attachedScripts) {
			if (as.getLocation().equals(script)) {
				return as;
			}
		}
		return null;
	}

	/**
	 * Get's an {@link AttachedScript} from a specific index.
	 * 
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	public AttachedScript get(int index) throws IndexOutOfBoundsException {
		return this.attachedScripts.get(index);
	}

	/**
	 * Clears the list of {@link RunnableScript}s.
	 */
	public void removeAll() {
		this.attachedScripts.clear();
	}

	/**
	 * Gets the total number of {@link RunnableScript}s in the list.
	 */
	public int size() {
		return this.attachedScripts.size();
	}

	/**
	 * Checks if an instance of the passed {@link RunnableScript} is in the list.
	 * 
	 * @param script
	 * @return True if the list contains the script, false if it does not.
	 */
	public boolean containsScript(RunnableScript script) {
		return this.getScript(script) != null;
	}

	@Override
	public Iterator<AttachedScript> iterator() {
		return this.attachedScripts.iterator();
	}

	/**
	 * Prints out all of the scripts to the passed sender.
	 * 
	 * @param sender
	 */
	public void func(ICommandSender sender) {
		sender.sendMessage(new TextBuilderTrans("ms3.stick.totalScriptCount", this.size(), this.size() > 1 ? "" : "s")
				.color(TextFormatting.YELLOW).get());
		for (AttachedScript as : this) {
			sender.sendMessage(
					new TextBuilder("> " + as.getLocation().getFile().getPath()).color(TextFormatting.YELLOW).get());
		}
	}
}
