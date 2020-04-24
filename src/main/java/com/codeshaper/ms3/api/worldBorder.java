package com.codeshaper.ms3.api;

import org.python.core.PyFloat;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.util.Util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.border.WorldBorder;
import net.minecraftforge.fml.common.FMLCommonHandler;

@PythonClass
@PythonDocString("Module for working with the World Border.")
public class worldBorder {

	@PythonField
	@PythonDocString("The default size of the World Border.")
	public static final int DEFAULT_SIZE = 29999984;

	@PythonFunction
	@PythonDocString("Returns the center of the World Border as a tuple of (x, z).")
	public PyTuple getCenter() {
		WorldBorder wb = this.getWorldBorder();
		return Util.makeTuple(wb.getCenterX(), wb.getCenterZ());
	}

	@PythonFunction
	@PythonDocString("Sets the center of the World Boarder.")
	public void setCenter(double x, double z) {
		this.getWorldBorder().setCenter(x, z);
	}

	@PythonFunction
	@PythonDocString("Checks if the passed position is within the World Border.  Returns True if it is, False if it is outside.")
	public boolean withinBorder(float x, float y, float z) {
		this.getWorldBorder().contains(new BlockPos(x, y, z));
		return false;
	}

	@PythonFunction
	@PythonDocString("Sets the size of the World Border.  size is the target diameter of the World Border, and time is the number of ticks that the transition will happen over.  Pass 0 for time to instantly change the World Border size.")
	public void setSize(double size, long time) {
		WorldBorder wb = this.getWorldBorder();
		wb.setTransition(wb.getSize(), size, time);
	}

	@PythonFunction
	@PythonDocString("Returns the target size of the World Border.")
	public double getTargetSize() {
		return this.getWorldBorder().getTargetSize();
	}

	/**
	 * Gets an instance of the World Board from the Overworld.
	 * 
	 * @return An instance of the World Border.
	 */
	private WorldBorder getWorldBorder() {
		return FMLCommonHandler.instance().getMinecraftServerInstance().worlds[0].getWorldBorder();
	}
}
