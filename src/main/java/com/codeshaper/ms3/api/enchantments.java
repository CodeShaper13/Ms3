package com.codeshaper.ms3.api;

import javax.annotation.Nullable;

import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.util.Util;

import net.minecraft.enchantment.Enchantment;

@PythonClass
@PythonDocString("Constants of all the enchantments as tuples.  1st index is id, 2nd is the string identifier.")
public class enchantments {

	private enchantments() {
	}

	@PythonField
	public static final PyTuple PROTECTION = Util.makeTuple(0, "protection");
	@PythonField
	public static final PyTuple FIRE_PROTECTION = Util.makeTuple(1, "fire_protection");
	@PythonField
	public static final PyTuple FEATHER_FALLING = Util.makeTuple(2, "feather_falling");
	@PythonField
	public static final PyTuple BLAST_PROTECTION = Util.makeTuple(3, "blast_protection");
	@PythonField
	public static final PyTuple PROJECTILE_PROTECTION = Util.makeTuple(4, "projectile_protection");
	@PythonField
	public static final PyTuple RESPIRATION = Util.makeTuple(5, "respiration");
	@PythonField
	public static final PyTuple AQUA_INFINITY = Util.makeTuple(6, "aqua_affinity");
	@PythonField
	public static final PyTuple THORNS = Util.makeTuple(7, "thorns");
	@PythonField
	public static final PyTuple DEPTH_STRIDER = Util.makeTuple(8, "depth_strider");
	@PythonField
	public static final PyTuple FROST_WALKER = Util.makeTuple(9, "frost_walker");
	@PythonField
	public static final PyTuple BINDING_CURSE = Util.makeTuple(10, "binding_curse");
	@PythonField
	public static final PyTuple SHARPNESS = Util.makeTuple(16, "sharpness");
	@PythonField
	public static final PyTuple SMITE = Util.makeTuple(17, "smite");
	@PythonField
	public static final PyTuple BANE_OF_ARTHROPODS = Util.makeTuple(18, "bane_of_arthropods");
	@PythonField
	public static final PyTuple KNOCKBACK = Util.makeTuple(19, "knockback");
	@PythonField
	public static final PyTuple FIRE_ASPECT = Util.makeTuple(20, "fire_aspect");
	@PythonField
	public static final PyTuple LOOTING = Util.makeTuple(21, "looting");
	@PythonField
	public static final PyTuple SWEEPING = Util.makeTuple(22, "sweeping");
	@PythonField
	public static final PyTuple EFFICIENCY = Util.makeTuple(32, "efficiency");
	@PythonField
	public static final PyTuple SILK_TOUCH = Util.makeTuple(33, "silk_touch");
	@PythonField
	public static final PyTuple UNBREAKING = Util.makeTuple(34, "unbreaking");
	@PythonField
	public static final PyTuple FORTUNE = Util.makeTuple(35, "fortune");
	@PythonField
	public static final PyTuple POWER = Util.makeTuple(48, "power");
	@PythonField
	public static final PyTuple PUNCH = Util.makeTuple(49, "punch");
	@PythonField
	public static final PyTuple FLAME = Util.makeTuple(50, "flame");
	@PythonField
	public static final PyTuple INFINITY = Util.makeTuple(51, "infinity");
	@PythonField
	public static final PyTuple LUCK_OF_THE_SEA = Util.makeTuple(61, "luck_of_the_sea");
	@PythonField
	public static final PyTuple LURE = Util.makeTuple(62, "lure");
	@PythonField
	public static final PyTuple MENDING = Util.makeTuple(70, "mending");
	@PythonField
	public static final PyTuple VANISHING_CURSE = Util.makeTuple(71, "vanishing_curse");

	@PythonFunction
	@PythonDocString("Checks if the passed identifier points to a valid enchantment.")
	public static boolean isValidIdentifer(@PythonTypeExclude Object enchantmentIdentifier) {	
		return getMcEnchantmentObj(enchantmentIdentifier) != null;
	}

	@PythonFunction
	@PythonDocString("Returns a tuple representing an enchantment, or None if the enchantmentIdentifier doen't point to any enchantment.")
	public static PyObject getEnchantment(@PythonTypeExclude Object enchantmentIdentifier) throws PyException {
		Enchantment e = getMcEnchantmentObj(enchantmentIdentifier);
		
		if(e != null) {
			return Util.makeTuple(Enchantment.getEnchantmentID(e), e.getName());	
		} else {
			return Py.None;
		}
	}
	
	@Nullable
	public static Enchantment getMcEnchantmentObj(@PythonTypeExclude Object enchantmentIdentifier) {
		if (enchantmentIdentifier instanceof String) {
			return Enchantment.getEnchantmentByLocation((String) enchantmentIdentifier);
		} else if (enchantmentIdentifier instanceof Number) {
			return Enchantment.getEnchantmentByID(((Number) enchantmentIdentifier).intValue());
		} else {
			throw Py.ValueError("Wrong type for enchantmentIdentifier, " + enchantmentIdentifier.getClass() + ".  It must be a string or number");
		}
	}
	
	/*
	 * @PythonClass public class Enchantment {
	 * 
	 * private final int id; private final String name;
	 * 
	 * public Enchantment(int id, String name) { this.id = id; this.name = name; }
	 * 
	 * @PythonFunction
	 * 
	 * @PythonDocString("Returns the ID of the enchantment.") public int getId() {
	 * return id; }
	 * 
	 * @PythonFunction
	 * 
	 * @PythonDocString("Returns the name of the enchantment.") public String
	 * getName() { return name; } }
	 */
}