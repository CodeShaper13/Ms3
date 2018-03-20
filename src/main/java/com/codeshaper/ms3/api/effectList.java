package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

@PythonClass
@PythonDocString("Constants for all the effect IDs.")
public class effectList {
	
	private effectList() { }

	@PythonField("1")
	public static final int SPEED = 1;
	@PythonField("2")
	public static final int SLOWNESS = 2;
	@PythonField("3")
	public static final int HASTE = 3;
	@PythonField("4")
	public static final int MINING_FATIGUE = 4;
	@PythonField("5")
	public static final int STRENGTH = 5;
	@PythonField("6")
	public static final int INST_HEALTH = 6;
	@PythonField("7")
	public static final int INST_DAMAGE = 7;
	@PythonField("8")
	public static final int JUMP_BOOST = 8;
	@PythonField("9")
	public static final int NAUSEA = 9;
	@PythonField("10")
	public static final int REGENERATION = 10;
	@PythonField("11")
	public static final int RESISTANCE = 11;
	@PythonField("12")
	public static final int FIRE_RESISTANCE = 12;
	@PythonField("13")
	public static final int WATER_BREATHING = 13;
	@PythonField("14")
	public static final int INVISIBILITY = 14;
	@PythonField("15")
	public static final int BLINDNESS = 15;
	@PythonField("16")
	public static final int NIGHT_VISION = 16;
	@PythonField("17")
	public static final int HUNGER = 17;
	@PythonField("18")
	public static final int WEAKNESS = 18;
	@PythonField("19")
	public static final int POISON = 19;
	@PythonField("20")
	public static final int WITHER = 20;
	@PythonField("21")
	public static final int HEALTH_BOOST = 21;
	@PythonField("22")
	public static final int ABSORPTION = 22;
	@PythonField("23")
	public static final int SATURATION = 23;
	@PythonField("24")
	public static final int GLOWING = 24;
	@PythonField("25")
	public static final int LEVITATION = 25;
	@PythonField("26")
	public static final int LUCK = 26;
	@PythonField("27")
	public static final int BAD_LUCK = 27;	
}
