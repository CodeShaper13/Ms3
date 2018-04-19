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

	@PythonField
	public static final String EXPLOSION_NORMAL = EnumParticleTypes.EXPLOSION_NORMAL.getParticleName();
	@PythonField
	public static final String EXPLOSION_LARGE = EnumParticleTypes.EXPLOSION_LARGE.getParticleName();
	@PythonField
	public static final String EXPLOSION_HUGE = EnumParticleTypes.EXPLOSION_HUGE.getParticleName();
	@PythonField
	public static final String FIREWORKS_SPARK = EnumParticleTypes.FIREWORKS_SPARK.getParticleName();
	@PythonField
	public static final String WATER_BUBBLE = EnumParticleTypes.WATER_BUBBLE.getParticleName(); 
	@PythonField
	public static final String WATER_SPLASH = EnumParticleTypes.WATER_SPLASH.getParticleName();
	@PythonField
	public static final String WATER_WAKE = EnumParticleTypes.WATER_WAKE.getParticleName();
	@PythonField
	@PythonDocString("Underwater.")
	public static final String SUSPENDED = EnumParticleTypes.SUSPENDED.getParticleName();
	@PythonField
	public static final String SUSPENDED_DEPTH = EnumParticleTypes.SUSPENDED_DEPTH.getParticleName();
	@PythonField
	@PythonDocString("Critical hits, bows and evocation fangs.")
	public static final String CRIT = EnumParticleTypes.CRIT.getParticleName();
	@PythonField
	@PythonDocString("Caused by Swords or Axes enchanted with Sharpness, Smite, or Bane of Arthropods.")
	public static final String CRIT_MAGIC = EnumParticleTypes.CRIT_MAGIC.getParticleName();
	@PythonField
	public static final String SMOKE_NORMAL = EnumParticleTypes.SMOKE_NORMAL.getParticleName();
	@PythonField
	public static final String SMOKE_LARGE = EnumParticleTypes.SMOKE_LARGE.getParticleName();
	@PythonField
	public static final String SPELL = EnumParticleTypes.SPELL.getParticleName();
	@PythonField
	public static final String SPELL_INSTANT = EnumParticleTypes.SPELL_INSTANT.getParticleName();
	@PythonField
	public static final String SPELL_MOB = EnumParticleTypes.SPELL_MOB.getParticleName();
	@PythonField
	public static final String SPELL_MOB_AMBIENT = EnumParticleTypes.SPELL_MOB_AMBIENT.getParticleName();
	@PythonField
	public static final String SPELL_WITCH = EnumParticleTypes.SPELL_WITCH.getParticleName();
	@PythonField
	@PythonDocString("Rain.")
	public static final String DRIP_WATER = EnumParticleTypes.DRIP_WATER.getParticleName();
	@PythonField
	public static final String DRIP_LAVA = EnumParticleTypes.DRIP_LAVA.getParticleName();
	@PythonField
	public static final String VILLAGER_ANGRY = EnumParticleTypes.VILLAGER_ANGRY.getParticleName();
	@PythonField
	public static final String VILLAGER_HAPPY = EnumParticleTypes.VILLAGER_HAPPY.getParticleName();
	@PythonField
	@PythonDocString("Caused by Mycelium.")
	public static final String TOWN_AURA = EnumParticleTypes.TOWN_AURA.getParticleName();
	@PythonField
	public static final String NOTE = EnumParticleTypes.NOTE.getParticleName();
	@PythonField
	public static final String PORTAL = EnumParticleTypes.PORTAL.getParticleName();
	@PythonField
	public static final String ENCHANTMENT_TABLE = EnumParticleTypes.ENCHANTMENT_TABLE.getParticleName();
	@PythonField
	public static final String FLAME = EnumParticleTypes.FLAME.getParticleName();
	@PythonField
	public static final String LAVA = EnumParticleTypes.LAVA.getParticleName();
	@PythonField
	@PythonDocString("Planned to be removed in Minecraft 1.13")
	public static final String FOOTSTEP = EnumParticleTypes.FOOTSTEP.getParticleName();
	@PythonField
	@PythonDocString("Spawned by Illusion Illagers.")
	public static final String CLOUD = EnumParticleTypes.CLOUD.getParticleName();
	@PythonField
	public static final String REDSTONE = EnumParticleTypes.REDSTONE.getParticleName();
	@PythonField
	public static final String SNOWBALL = EnumParticleTypes.SNOWBALL.getParticleName();
	@PythonField
	public static final String SNOW_SHOVEL = EnumParticleTypes.SNOW_SHOVEL.getParticleName();
	@PythonField
	public static final String SLIME = EnumParticleTypes.SLIME.getParticleName();
	@PythonField
	public static final String HEART = EnumParticleTypes.HEART.getParticleName();
	@PythonField
	public static final String BARRIER = EnumParticleTypes.BARRIER.getParticleName();
	@PythonField
	@PythonDocString("Takes two args, 1st for the block/item id, 2nd for data value.")
	public static final String ITEM_CRACK = EnumParticleTypes.ITEM_CRACK.getParticleName();
	@PythonField
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String BLOCK_CRACK = EnumParticleTypes.BLOCK_CRACK.getParticleName();
	@PythonField
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String BLOCK_DUST = EnumParticleTypes.BLOCK_DUST.getParticleName();
	@PythonField
	@PythonDocString("Rain.")
	public static final String WATER_DROP = EnumParticleTypes.WATER_DROP.getParticleName();
	@PythonField
	public static final String ITEM_TAKE = EnumParticleTypes.ITEM_TAKE.getParticleName();
	@PythonField
	@PythonDocString("Caused by Elder Guardians when they give effects.")
	public static final String MOB_APPEARANCE = EnumParticleTypes.MOB_APPEARANCE.getParticleName();
	@PythonField
	public static final String DRAGON_BREATH = EnumParticleTypes.DRAGON_BREATH.getParticleName();
	@PythonField
	public static final String END_ROD = EnumParticleTypes.END_ROD.getParticleName();
	@PythonField
	public static final String DAMAGE_INDICATOR = EnumParticleTypes.DAMAGE_INDICATOR.getParticleName();
	@PythonField
	public static final String SWEEP_ATTACK = EnumParticleTypes.SWEEP_ATTACK.getParticleName();
	@PythonField
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String FALLING_DUST = EnumParticleTypes.FALLING_DUST.getParticleName();
	@PythonField
	@PythonDocString("Totem of Undying effect.")
	public static final String TOTEM = EnumParticleTypes.TOTEM.getParticleName();
	@PythonField
	public static final String SPIT = EnumParticleTypes.SPIT.getParticleName();

	@PythonFunction
	@PythonDocString("Takes in a Block ID and meta value and returns the code for a particle param.")
	public static int getParamCode(int blockId, int meta) {
		return blockId + (meta * 4096);
	}
	
	@PythonFunction
	@PythonDocString("Returns a particle name from it's ID.")
	public static String particleFromId(int id) {
		return EnumParticleTypes.getParticleFromId(id).getParticleName();
	}
}
