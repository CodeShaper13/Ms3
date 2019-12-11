package com.codeshaper.ms3.api;

import org.python.core.Py;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.block.Block;

@PythonDocString("Utility features for blocks.")
public class blockUtils {

	private blockUtils() { }
	
	@PythonFunction
	@PythonDocString("Returns an instance of net.minecraft.block.Block corresponding from the passed registered name.  Advanced users only!")
	public static Block getMcBlockFromName(String registryName) {
		Block b = Block.getBlockFromName(registryName);
		if(b == null) {
			throw Py.ValueError("Block with name " + registryName + " could not be found");
		}
		return b;
	}

	@PythonFunction
	@PythonDocString("Returns a Block's id from it's registered name.")
	public static int getIdFromName(String registryName) {
		return Block.getIdFromBlock(Block.getBlockFromName(registryName));
	}
}
