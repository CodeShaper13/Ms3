package com.codeshaper.ms3.api;

import org.python.core.PyFloat;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.world.border.WorldBorder;
import net.minecraftforge.fml.common.FMLCommonHandler;

@PythonClass
@PythonDocString("Module for working with the World Border.")
public class worldBorder {
	
	@PythonFieldGenerated
	public static final int DEFAULT_SIZE = 29999984;
	@PythonFieldGenerated
	public static final int GROWING = 0;
	@PythonFieldGenerated
	public static final int SHRINKING = 1;
	@PythonFieldGenerated
	public static final int STATIONARY = 2;

	@PythonFunction
	@PythonDocString("Returns the center of the world border as a tuple of (x, z).")
	public PyTuple getCenter() {
		WorldBorder wb = this.getWorldBorder();
		return new PyTuple(new PyFloat(wb.getCenterX()), new PyFloat(wb.getCenterZ()));
	}
	
	@PythonFunction
	public void setCenter(double x, double z) {
		this.getWorldBorder().setCenter(x, z);
	}
	
	@PythonFunction
	@PythonDocString("Checks if the passed position is within the world border.")
	public boolean withinBorder(float x, float y, float z) {
		return false;
	}
	
	@PythonFunction
	@PythonDocString("Pass 0 for time for instant change.")
	public void setSize(double size, long time) {
		WorldBorder wb = this.getWorldBorder();
		wb.setTransition(wb.getSize(), size, time);		
	}
	
	/**
	 * @return An instance of the world border.
	 */
	private WorldBorder getWorldBorder() {
		return FMLCommonHandler.instance().getMinecraftServerInstance().worlds[0].getWorldBorder();
	}
}
