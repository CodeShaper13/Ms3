package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraftforge.common.MinecraftForge;

@PythonClass
@PythonDocString("")
public class events {
	
	@PythonFunction
	public void subscribe() {
		Object obj = new Object();
		
		MinecraftForge.EVENT_BUS.register(obj);
	}
	
	@PythonFunction
	public void unsubscribe() {
		
	}

	@PythonClass
	public class type {
		
		@PythonField
		public String joinWorld = "joinWorld";
	}
}
