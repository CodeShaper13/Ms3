package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;

@PythonClass
@PythonDocString("Constants of all the Sound Categories for use with world.playsound()")
public class soundCategories {

	private soundCategories() {
	}

	@PythonFieldGenerated
	public static final String MASTER = "master";
	@PythonFieldGenerated
	public static final String MUSIC = "music";
	@PythonFieldGenerated
	public static final String RECORDS = "record";
	@PythonFieldGenerated
	public static final String WEATHER = "weather";
	@PythonFieldGenerated
	public static final String BLOCKS = "block";
	@PythonFieldGenerated
	public static final String HOSTILE = "hostile";
	@PythonFieldGenerated
	public static final String NEUTRAL = "neutral";
	@PythonFieldGenerated
	public static final String PLAYERS = "player";
	@PythonFieldGenerated
	public static final String AMBIENT = "ambient";
	@PythonFieldGenerated
	public static final String VOICE = "voice";
}
