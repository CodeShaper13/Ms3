package com.codeshaper.ms3.api;

import org.python.core.Py;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.block.Block;

@PythonDocString("Utility features for blocks.")
public class blockUtils {

	private blockUtils() { }
	
	@PythonFunction
	@PythonDocString("Returns an instance of net.minecraft.block.Block corresponding with the passed name.")
	public static Block getMcBlockFromName(String name) {
		Block b = Block.getBlockFromName(name);
		if(b == null) {
			throw Py.ValueError("Block with name " + name + " could not be found");
		}
		return b;
	}

	@PythonFunction
	@PythonDocString("Returns a Block's id from it's name.")
	public static int getIdFromName(String name) {
		return Block.getIdFromBlock(Block.getBlockFromName(name));
	}
}
