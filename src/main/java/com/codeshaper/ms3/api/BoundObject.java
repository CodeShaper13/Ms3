package com.codeshaper.ms3.api;

import org.python.core.PyType;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.apiBuilder.annotation.PythonMoveToInit;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;

import net.minecraft.entity.Entity;
import net.minecraft.world.WorldServer;

@PythonClass
@PythonMoveToInit
@PythonDocString("")
public class BoundObject {

	private final entity.Base<Entity> entity;
	private final world.World world;
	private final PyType type;
	
	public BoundObject(entity.Base<Entity> e) {
		this.entity = e;
		this.world = new world.World((WorldServer) e.mcEntity.getEntityWorld());
		this.type = PyType.fromClass(this.getClass());

		this.onConstruct();
	}

	@PythonFunction
	@PythonDocString("")
	public void onConstruct() {

	}

	@PythonFunction
	@PythonDocString("Called every tick that the Entity is alive.")
	public void onTick() {

	}

	@PythonFunction
	@PythonDocString("Called when the Entity is first loaded into the world.  This is where you would read properties.")
	public void onLoad() {

	}

	@PythonFunction
	@PythonDocString("Called when the Entity is saved to disk.  This is where you would write properties.")
	public void onSave() {

	}
	
	@PythonFunction
	@PythonDocString("")
	public void onClick(entity.Base<?> entity, entity.Player player) {
		
	}

	@PythonFunction
	public entity.Base<Entity> getEntity() {
		return this.entity;
	}
	
	@PythonFunction
	@PythonDocString("Returns the world that this Entity is in.")
	public world.World getWorld() {
		return this.world;
	}

	@PythonFunction
	@PythonDocString("Calls self.entity.setProperty and prefixs propertyName with the type name of this object.")
	protected final void setProperty(String propertyName, @PythonTypeExclude Object value) {
		this.entity.setProperty(this.getPrefix() + "." + propertyName, value);
	}

	@PythonFunction
	@PythonDocString("")
	protected final Object readProperty(String propertyName) {
		return this.entity.getProperty(this.getPrefix() + "." + propertyName);
	}

	/**
	 * Returns a prefix to use when reading and settings properties. This should be
	 * the classes name.
	 */
	public final String getPrefix() {
		return this.type.getName();
	}
}
