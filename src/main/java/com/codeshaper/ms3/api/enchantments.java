package com.codeshaper.ms3.api;

import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.util.Util;

@PythonClass
@PythonDocString("A lsit of all the enchantments.  Tuple store the id at index 0 and the string identifier at index 1.")
public class enchantments {

	private enchantments() {
	}
	
	@PythonField
	public static final PyTuple protection = Util.makeTuple(0, "protection");
	@PythonField
	public static final PyTuple fireProtection = Util.makeTuple(1, "fire_protection");
	@PythonField
	public static final PyTuple featherFalling = Util.makeTuple(2, "feather_falling");
	@PythonField
	public static final PyTuple blastProtection = Util.makeTuple(3, "blast_protection");
	@PythonField
	public static final PyTuple projectileProtection = Util.makeTuple(4, "projectile_protection");
	@PythonField
	public static final PyTuple respiration = Util.makeTuple(5, "respiration");
	@PythonField
	public static final PyTuple aquaInfinity = Util.makeTuple(6, "aqua_affinity");
	@PythonField
	public static final PyTuple thorns = Util.makeTuple(7, "thorns");
	@PythonField
	public static final PyTuple depthStrider = Util.makeTuple(8,"depth_strider");
	@PythonField
	public static final PyTuple frostWalker = Util.makeTuple(9,"frost_walker");
	@PythonField
	public static final PyTuple bindingCurse = Util.makeTuple(10, "binding_curse");
	@PythonField
	public static final PyTuple sharpness = Util.makeTuple(16,"sharpness");
	@PythonField
	public static final PyTuple smite = Util.makeTuple(17, "smite");
	@PythonField
	public static final PyTuple baneOfArthropods = Util.makeTuple(18, "bane_of_arthropods");
	@PythonField
	public static final PyTuple knockback = Util.makeTuple(19, "knockback");
    @PythonField
	public static final PyTuple fireAspect = Util.makeTuple(20, "fire_aspect");
    @PythonField
	public static final PyTuple looting = Util.makeTuple(21, "looting");
    @PythonField
	public static final PyTuple sweeping = Util.makeTuple(22, "sweeping");
    @PythonField
	public static final PyTuple efficiency = Util.makeTuple(32, "efficiency");
    @PythonField
	public static final PyTuple silkTouch = Util.makeTuple(33, "silk_touch");
    @PythonField
	public static final PyTuple unbreaking = Util.makeTuple(34, "unbreaking");
    @PythonField
	public static final PyTuple fortune = Util.makeTuple(35, "fortune");
    @PythonField
	public static final PyTuple power = Util.makeTuple(48, "power");
    @PythonField
	public static final PyTuple punch = Util.makeTuple(49, "punch");
    @PythonField
	public static final PyTuple flame = Util.makeTuple(50,"flame");
    @PythonField
	public static final PyTuple infinity = Util.makeTuple(51, "infinity");
    @PythonField
	public static final PyTuple luckOfTheSea = Util.makeTuple(61, "luck_of_the_sea");
    @PythonField
	public static final PyTuple lure = Util.makeTuple(62, "lure");
    @PythonField
	public static final PyTuple mending = Util.makeTuple(70, "mending");
    @PythonField
	public static final PyTuple vanishingCurse = Util.makeTuple(71, "vanishing_curse");
}