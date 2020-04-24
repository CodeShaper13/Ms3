package com.codeshaper.ms3.api;

import org.apache.commons.lang3.StringUtils;
import org.python.core.Py;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.util.ResourceLocation;

@PythonClass
@PythonDocString("String constants of all the enchantments names.  Several helper methods also exist for dealing with enchantments.")
public class enchantments {

	private enchantments() {
	}

	@PythonFieldGenerated
	public static final String PROTECTION = getRegName(Enchantments.PROTECTION);
	@PythonFieldGenerated
	public static final String FIRE_PROTECTION = getRegName(Enchantments.FIRE_PROTECTION);
	@PythonFieldGenerated
	public static final String FEATHER_FALLING = getRegName(Enchantments.FEATHER_FALLING);
	@PythonFieldGenerated
	public static final String BLAST_PROTECTION = getRegName(Enchantments.BLAST_PROTECTION);
	@PythonFieldGenerated
	public static final String PROJECTILE_PROTECTION = getRegName(Enchantments.PROJECTILE_PROTECTION);
	@PythonFieldGenerated
	public static final String RESPIRATION = getRegName(Enchantments.RESPIRATION);
	@PythonFieldGenerated
	public static final String AQUA_INFINITY = getRegName(Enchantments.AQUA_AFFINITY);
	@PythonFieldGenerated
	public static final String THORNS = getRegName(Enchantments.THORNS);
	@PythonFieldGenerated
	public static final String DEPTH_STRIDER = getRegName(Enchantments.DEPTH_STRIDER);
	@PythonFieldGenerated
	public static final String FROST_WALKER = getRegName(Enchantments.FROST_WALKER);
	@PythonFieldGenerated
	public static final String BINDING_CURSE = getRegName(Enchantments.BINDING_CURSE);
	@PythonFieldGenerated
	public static final String SHARPNESS = getRegName(Enchantments.SHARPNESS);
	@PythonFieldGenerated
	public static final String SMITE = getRegName(Enchantments.SMITE);
	@PythonFieldGenerated
	public static final String BANE_OF_ARTHROPODS = getRegName(Enchantments.BANE_OF_ARTHROPODS);
	@PythonFieldGenerated
	public static final String KNOCKBACK = getRegName(Enchantments.KNOCKBACK);
	@PythonFieldGenerated
	public static final String FIRE_ASPECT = getRegName(Enchantments.FIRE_ASPECT);
	@PythonFieldGenerated
	public static final String LOOTING = getRegName(Enchantments.LOOTING);
	@PythonFieldGenerated
	public static final String SWEEPING = getRegName(Enchantments.SWEEPING);
	@PythonFieldGenerated
	public static final String EFFICIENCY = getRegName(Enchantments.EFFICIENCY);
	@PythonFieldGenerated
	public static final String SILK_TOUCH = getRegName(Enchantments.SILK_TOUCH);
	@PythonFieldGenerated
	public static final String UNBREAKING = getRegName(Enchantments.UNBREAKING);
	@PythonFieldGenerated
	public static final String FORTUNE = getRegName(Enchantments.FORTUNE);
	@PythonFieldGenerated
	public static final String POWER = getRegName(Enchantments.POWER);
	@PythonFieldGenerated
	public static final String PUNCH = getRegName(Enchantments.PUNCH);
	@PythonFieldGenerated
	public static final String FLAME = getRegName(Enchantments.FLAME);
	@PythonFieldGenerated
	public static final String INFINITY = getRegName(Enchantments.INFINITY);
	@PythonFieldGenerated
	public static final String LUCK_OF_THE_SEA = getRegName(Enchantments.LUCK_OF_THE_SEA);
	@PythonFieldGenerated
	public static final String LURE = getRegName(Enchantments.LURE);
	@PythonFieldGenerated
	public static final String MENDING = getRegName(Enchantments.MENDING);
	@PythonFieldGenerated
	public static final String VANISHING_CURSE = getRegName(Enchantments.VANISHING_CURSE);

	@PythonFunction
	@PythonDocString("Returns the max level the enchantment can go to.")
	public static int getMaxLevel(String enchantment) {
		return func(enchantment, "enchantment").getMaxLevel();
	}

	@PythonFunction
	@PythonDocString("Returns True if the enchantment is a curse, False if it is not.")
	public static boolean isCurseEnchantment(String enchantment) {
		return func(enchantment, "enchantment").isCurse();
	}

	@PythonFunction
	@PythonDocString("Returns True if the enchantment is a treasure, False if it is not.")
	public static boolean isTreasureEnchantment(String enchantment) {
		return func(enchantment, "enchantment").isTreasureEnchantment();
	}

	@PythonFunction
	@PythonDocString("Returns True if enchantments are compatible with each other, False if they are not.")
	public static boolean isCompatibleWith(String enchantment1, String enchantment2) {
		Enchantment e1 = func(enchantment1, "enchantment1");
		Enchantment e2 = func(enchantment2, "enchantment2");
		return e1.isCompatibleWith(e2);
	}

	private static Enchantment func(String enchantment, String paramName) {
		if (StringUtils.isEmpty(enchantment)) {
			throw Py.ValueError(paramName + " can not be None or an empty string");
		}
		Enchantment e = Enchantment.REGISTRY.getObject(new ResourceLocation(enchantment));
		if (e == null) {
			throw Py.ValueError("Enchantment with identifier " + enchantment + " couldn't be found");
		}
		return e;
	}

	public static String getRegName(Enchantment e) {
		return e.getRegistryName().toString();
	}
}