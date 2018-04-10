package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

@PythonClass
@PythonDocString("Constants of all the Sound Categories for use with world.playsound()")
public class soundCategories {

	private soundCategories() {
	}

	@PythonField
	public static final String MASTER = "master";
	@PythonField
	public static final String MUSIC = "music";
	@PythonField
	public static final String RECORDS = "record";
	@PythonField
	public static final String WEATHER = "weather";
	@PythonField
	public static final String BLOCKS = "block";
	@PythonField
	public static final String HOSTILE = "hostile";
	@PythonField
	public static final String NEUTRAL = "neutral";
	@PythonField
	public static final String PLAYERS = "player";
	@PythonField
	public static final String AMBIENT = "ambient";
	@PythonField
	public static final String VOICE = "voice";
}
