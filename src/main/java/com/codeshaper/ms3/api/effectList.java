package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

@PythonClass
@PythonDocString("Constants for all the effect IDs.")
public class effectList {

	private effectList() {
	}

	@PythonField
	public static final int SPEED = 1;
	@PythonField
	public static final int SLOWNESS = 2;
	@PythonField
	public static final int HASTE = 3;
	@PythonField
	public static final int MINING_FATIGUE = 4;
	@PythonField
	public static final int STRENGTH = 5;
	@PythonField
	public static final int INST_HEALTH = 6;
	@PythonField
	public static final int INST_DAMAGE = 7;
	@PythonField
	public static final int JUMP_BOOST = 8;
	@PythonField
	public static final int NAUSEA = 9;
	@PythonField
	public static final int REGENERATION = 10;
	@PythonField
	public static final int RESISTANCE = 11;
	@PythonField
	public static final int FIRE_RESISTANCE = 12;
	@PythonField
	public static final int WATER_BREATHING = 13;
	@PythonField
	public static final int INVISIBILITY = 14;
	@PythonField
	public static final int BLINDNESS = 15;
	@PythonField
	public static final int NIGHT_VISION = 16;
	@PythonField
	public static final int HUNGER = 17;
	@PythonField
	public static final int WEAKNESS = 18;
	@PythonField
	public static final int POISON = 19;
	@PythonField
	public static final int WITHER = 20;
	@PythonField
	public static final int HEALTH_BOOST = 21;
	@PythonField
	public static final int ABSORPTION = 22;
	@PythonField
	public static final int SATURATION = 23;
	@PythonField
	public static final int GLOWING = 24;
	@PythonField
	public static final int LEVITATION = 25;
	@PythonField
	public static final int LUCK = 26;
	@PythonField
	public static final int BAD_LUCK = 27;
}
