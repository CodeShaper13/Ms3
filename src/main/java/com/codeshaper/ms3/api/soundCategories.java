package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

@PythonClass
@PythonDocString("Constants of all the Sound Categories for use with world.playsound()")
public class soundCategories {

	private soundCategories() {
	}

	@PythonField("master")
	public static final String MASTER = "master";
	@PythonField("music")
	public static final String MUSIC = "music";
	@PythonField("record")
	public static final String RECORDS = "record";
	@PythonField("weather")
	public static final String WEATHER = "weather";
	@PythonField("block")
	public static final String BLOCKS = "block";
	@PythonField("hostile")
	public static final String HOSTILE = "hostile";
	@PythonField("neutral")
	public static final String NEUTRAL = "neutral";
	@PythonField("players")
	public static final String PLAYERS = "player";
	@PythonField("ambient")
	public static final String AMBIENT = "ambient";
	@PythonField("voice")
	public static final String VOICE = "voice";
}
