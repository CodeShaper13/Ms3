package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.util.EnumParticleTypes;

@PythonClass
@PythonDocString("Constants of all the patricle type names.")
public class particleType {

	private particleType() {
	}

	@PythonField("explode")
	public static final String EXPLOSION_NORMAL = "explode";
	@PythonField("largeexplode")
	public static final String EXPLOSION_LARGE = "largeexplode";
	@PythonField("hugeexplosion")
	public static final String EXPLOSION_HUGE = "hugeexplosion";
	@PythonField("fireworkSpark")
	public static final String FIREWORKS_SPARK = "fireworksSpark";
	@PythonField("bubble")
	public static final String WATER_BUBBLE = "bubble";
	@PythonField("splash")
	public static final String WATER_SPLASH = "splash";
	@PythonField("wake")
	public static final String WATER_WAKE = "wake";
	@PythonField("suspended")
	@PythonDocString("Underwater.")
	public static final String SUSPENDED = "suspended";
	@PythonField("depthsuspend")
	public static final String SUSPENDED_DEPTH = "depthsuspend";
	@PythonField("crit")
	public static final String CRIT = "crit";
	@PythonField("magicCrit")
	public static final String CRIT_MAGIC = "magicCrit";
	@PythonField("smoke")
	public static final String SMOKE_NORMAL = "smoke";
	@PythonField("largesmoke")
	public static final String SMOKE_LARGE = "largesmoke";
	@PythonField("spell")
	public static final String SPELL = "spell";
	@PythonField("instantSpell")
	public static final String SPELL_INSTANT = "instantSpell";
	@PythonField("mobSpell")
	public static final String SPELL_MOB = "mobSpell";
	@PythonField("mobSpellAmbient")
	public static final String SPELL_MOB_AMBIENT = "mobSpellAmbient";
	@PythonField("witchMagic")
	public static final String SPELL_WITCH = "witchMagic";
	@PythonField("dripWater")
	public static final String DRIP_WATER = "dripWater";
	@PythonField("dripLava")
	public static final String DRIP_LAVA = "dripLava";
	@PythonField("angryVillager")
	public static final String VILLAGER_ANGRY = "angryVillager";
	@PythonField("happyVillager")
	public static final String VILLAGER_HAPPY = "happyVillager";
	@PythonField("townaura")
	@PythonDocString("Caused by Mycelium.")
	public static final String TOWN_AURA = "townaura";
	@PythonField("note")
	public static final String NOTE = "note";
	@PythonField("portal")
	public static final String PORTAL = "portal";
	@PythonField("enchantmenttable")
	public static final String ENCHANTMENT_TABLE = "enchantmenttable";
	@PythonField("flame")
	public static final String FLAME = "flame";
	@PythonField("lava")
	public static final String LAVA = "lava";
	@PythonField("footstep")
	public static final String FOOTSTEP = "footstep";
	@PythonField("cloud")
	@PythonDocString("Spawned by Illusion Illagers.")
	public static final String CLOUD = "cloud";
	@PythonField("reddust")
	public static final String REDSTONE = "reddust";
	@PythonField("snowballpoof")
	public static final String SNOWBALL = "snowballpoof";
	@PythonField("snowshovel")
	public static final String SNOW_SHOVEL = "snowshovel";
	@PythonField("slime")
	public static final String SLIME = "slime";
	@PythonField("heart")
	public static final String HEART = "heart";
	@PythonField("barrier")
	public static final String BARRIER = "barrier";
	@PythonField("iconcrack")
	@PythonDocString("Takes two args, 1st for the block/item id, 2nd for data value.")
	public static final String ITEM_CRACK = "iconcrack";
	@PythonField("blockcrack")
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String BLOCK_CRACK = "blockcrack";
	@PythonField("blockdust")
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String BLOCK_DUST = "blockdust";
	@PythonField("droplet")
	@PythonDocString("Rain.")
	public static final String WATER_DROP = "droplet";
	@PythonField("take")
	public static final String ITEM_TAKE = "take";
	@PythonField("mobappearance")
	@PythonDocString("Caused by Elder Guardians when they give effects.")
	public static final String MOB_APPEARANCE = "mobappearance";
	@PythonField("dragonbreath")
	public static final String DRAGON_BREATH = "dragonbreath";
	@PythonField("endRod")
	public static final String END_ROD = "endRod";
	@PythonField("damageIndicator")
	public static final String DAMAGE_INDICATOR = "damageIndicator";
	@PythonField("sweepAttack")
	public static final String SWEEP_ATTACK = "sweepAttack";
	@PythonField("fallingdust")
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String FALLING_DUST = "fallingdust";
	@PythonField("totem")
	public static final String TOTEM = "totem";
	@PythonField("spit")
	public static final String SPIT = "spit";

	@PythonFunction
	@PythonDocString("Takes in a block id and meta value and returns the code for a particle param.")
	public static int getParamCode(int blockId, int meta) {
		EnumParticleTypes t;
		return blockId + (meta * 4096);
	}
}
