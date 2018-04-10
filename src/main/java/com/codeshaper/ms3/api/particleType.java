package com.codeshaper.ms3.api;

import org.python.core.PyObject;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonClass
@PythonDocString("Constants of all the patricle type names.")
public class particleType extends PyObject {

	private particleType() {
	}

	@PythonField
	public static final String EXPLOSION_NORMAL = "explode";
	@PythonField
	public static final String EXPLOSION_LARGE = "largeexplode";
	@PythonField
	public static final String EXPLOSION_HUGE = "hugeexplosion";
	@PythonField
	public static final String FIREWORKS_SPARK = "fireworksSpark";
	@PythonField
	public static final String WATER_BUBBLE = "bubble";
	@PythonField
	public static final String WATER_SPLASH = "splash";
	@PythonField
	public static final String WATER_WAKE = "wake";
	@PythonField
	@PythonDocString("Underwater.")
	public static final String SUSPENDED = "suspended";
	@PythonField
	public static final String SUSPENDED_DEPTH = "depthsuspend";
	@PythonField
	public static final String CRIT = "crit";
	@PythonField
	public static final String CRIT_MAGIC = "magicCrit";
	@PythonField
	public static final String SMOKE_NORMAL = "smoke";
	@PythonField
	public static final String SMOKE_LARGE = "largesmoke";
	@PythonField
	public static final String SPELL = "spell";
	@PythonField
	public static final String SPELL_INSTANT = "instantSpell";
	@PythonField
	public static final String SPELL_MOB = "mobSpell";
	@PythonField
	public static final String SPELL_MOB_AMBIENT = "mobSpellAmbient";
	@PythonField
	public static final String SPELL_WITCH = "witchMagic";
	@PythonField
	public static final String DRIP_WATER = "dripWater";
	@PythonField
	public static final String DRIP_LAVA = "dripLava";
	@PythonField
	public static final String VILLAGER_ANGRY = "angryVillager";
	@PythonField
	public static final String VILLAGER_HAPPY = "happyVillager";
	@PythonField
	@PythonDocString("Caused by Mycelium.")
	public static final String TOWN_AURA = "townaura";
	@PythonField
	public static final String NOTE = "note";
	@PythonField
	public static final String PORTAL = "portal";
	@PythonField
	public static final String ENCHANTMENT_TABLE = "enchantmenttable";
	@PythonField
	public static final String FLAME = "flame";
	@PythonField
	public static final String LAVA = "lava";
	@PythonField
	public static final String FOOTSTEP = "footstep";
	@PythonField
	@PythonDocString("Spawned by Illusion Illagers.")
	public static final String CLOUD = "cloud";
	@PythonField
	public static final String REDSTONE = "reddust";
	@PythonField
	public static final String SNOWBALL = "snowballpoof";
	@PythonField
	public static final String SNOW_SHOVEL = "snowshovel";
	@PythonField
	public static final String SLIME = "slime";
	@PythonField
	public static final String HEART = "heart";
	@PythonField
	public static final String BARRIER = "barrier";
	@PythonField
	@PythonDocString("Takes two args, 1st for the block/item id, 2nd for data value.")
	public static final String ITEM_CRACK = "iconcrack";
	@PythonField
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String BLOCK_CRACK = "blockcrack";
	@PythonField
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String BLOCK_DUST = "blockdust";
	@PythonField
	@PythonDocString("Rain.")
	public static final String WATER_DROP = "droplet";
	@PythonField
	public static final String ITEM_TAKE = "take";
	@PythonField
	@PythonDocString("Caused by Elder Guardians when they give effects.")
	public static final String MOB_APPEARANCE = "mobappearance";
	@PythonField
	public static final String DRAGON_BREATH = "dragonbreath";
	@PythonField
	public static final String END_ROD = "endRod";
	@PythonField
	public static final String DAMAGE_INDICATOR = "damageIndicator";
	@PythonField
	public static final String SWEEP_ATTACK = "sweepAttack";
	@PythonField
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String FALLING_DUST = "fallingdust";
	@PythonField
	public static final String TOTEM = "totem";
	@PythonField
	public static final String SPIT = "spit";

	@PythonFunction
	@PythonDocString("Takes in a block id and meta value and returns the code for a particle param.")
	public static int getParamCode(int blockId, int meta) {
		return blockId + (meta * 4096);
	}
}
