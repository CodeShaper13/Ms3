package com.codeshaper.ms3.api;

import javax.annotation.Nullable;

import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.util.Util;

import net.minecraft.enchantment.Enchantment;

@PythonClass
@PythonDocString("Constants of all the enchantments as tuples.  1st index is id, 2nd is the string identifier.")
public class enchantments {

	private enchantments() {
	}

	@PythonFieldGenerated
	public static final PyTuple PROTECTION = Util.makeTuple(0, "protection");
	@PythonFieldGenerated
	public static final PyTuple FIRE_PROTECTION = Util.makeTuple(1, "fire_protection");
	@PythonFieldGenerated
	public static final PyTuple FEATHER_FALLING = Util.makeTuple(2, "feather_falling");
	@PythonFieldGenerated
	public static final PyTuple BLAST_PROTECTION = Util.makeTuple(3, "blast_protection");
	@PythonFieldGenerated
	public static final PyTuple PROJECTILE_PROTECTION = Util.makeTuple(4, "projectile_protection");
	@PythonFieldGenerated
	public static final PyTuple RESPIRATION = Util.makeTuple(5, "respiration");
	@PythonFieldGenerated
	public static final PyTuple AQUA_INFINITY = Util.makeTuple(6, "aqua_affinity");
	@PythonFieldGenerated
	public static final PyTuple THORNS = Util.makeTuple(7, "thorns");
	@PythonFieldGenerated
	public static final PyTuple DEPTH_STRIDER = Util.makeTuple(8, "depth_strider");
	@PythonFieldGenerated
	public static final PyTuple FROST_WALKER = Util.makeTuple(9, "frost_walker");
	@PythonFieldGenerated
	public static final PyTuple BINDING_CURSE = Util.makeTuple(10, "binding_curse");
	@PythonFieldGenerated
	public static final PyTuple SHARPNESS = Util.makeTuple(16, "sharpness");
	@PythonFieldGenerated
	public static final PyTuple SMITE = Util.makeTuple(17, "smite");
	@PythonFieldGenerated
	public static final PyTuple BANE_OF_ARTHROPODS = Util.makeTuple(18, "bane_of_arthropods");
	@PythonFieldGenerated
	public static final PyTuple KNOCKBACK = Util.makeTuple(19, "knockback");
	@PythonFieldGenerated
	public static final PyTuple FIRE_ASPECT = Util.makeTuple(20, "fire_aspect");
	@PythonFieldGenerated
	public static final PyTuple LOOTING = Util.makeTuple(21, "looting");
	@PythonFieldGenerated
	public static final PyTuple SWEEPING = Util.makeTuple(22, "sweeping");
	@PythonFieldGenerated
	public static final PyTuple EFFICIENCY = Util.makeTuple(32, "efficiency");
	@PythonFieldGenerated
	public static final PyTuple SILK_TOUCH = Util.makeTuple(33, "silk_touch");
	@PythonFieldGenerated
	public static final PyTuple UNBREAKING = Util.makeTuple(34, "unbreaking");
	@PythonFieldGenerated
	public static final PyTuple FORTUNE = Util.makeTuple(35, "fortune");
	@PythonFieldGenerated
	public static final PyTuple POWER = Util.makeTuple(48, "power");
	@PythonFieldGenerated
	public static final PyTuple PUNCH = Util.makeTuple(49, "punch");
	@PythonFieldGenerated
	public static final PyTuple FLAME = Util.makeTuple(50, "flame");
	@PythonFieldGenerated
	public static final PyTuple INFINITY = Util.makeTuple(51, "infinity");
	@PythonFieldGenerated
	public static final PyTuple LUCK_OF_THE_SEA = Util.makeTuple(61, "luck_of_the_sea");
	@PythonFieldGenerated
	public static final PyTuple LURE = Util.makeTuple(62, "lure");
	@PythonFieldGenerated
	public static final PyTuple MENDING = Util.makeTuple(70, "mending");
	@PythonFieldGenerated
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