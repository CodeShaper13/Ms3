package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.util.EnumParticleTypes;

@PythonClass
@PythonDocString("Constants of all the patricle type names.")
public class particleType {

	private particleType() {
	}

	@PythonFieldGenerated
	public static final String EXPLOSION_NORMAL = EnumParticleTypes.EXPLOSION_NORMAL.getParticleName();
	@PythonFieldGenerated
	public static final String EXPLOSION_LARGE = EnumParticleTypes.EXPLOSION_LARGE.getParticleName();
	@PythonFieldGenerated
	public static final String EXPLOSION_HUGE = EnumParticleTypes.EXPLOSION_HUGE.getParticleName();
	@PythonFieldGenerated
	public static final String FIREWORKS_SPARK = EnumParticleTypes.FIREWORKS_SPARK.getParticleName();
	@PythonFieldGenerated
	public static final String WATER_BUBBLE = EnumParticleTypes.WATER_BUBBLE.getParticleName(); 
	@PythonFieldGenerated
	public static final String WATER_SPLASH = EnumParticleTypes.WATER_SPLASH.getParticleName();
	@PythonFieldGenerated
	public static final String WATER_WAKE = EnumParticleTypes.WATER_WAKE.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Underwater.")
	public static final String SUSPENDED = EnumParticleTypes.SUSPENDED.getParticleName();
	@PythonFieldGenerated
	public static final String SUSPENDED_DEPTH = EnumParticleTypes.SUSPENDED_DEPTH.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Critical hits, bows and evocation fangs.")
	public static final String CRIT = EnumParticleTypes.CRIT.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Caused by Swords or Axes enchanted with Sharpness, Smite, or Bane of Arthropods.")
	public static final String CRIT_MAGIC = EnumParticleTypes.CRIT_MAGIC.getParticleName();
	@PythonFieldGenerated
	public static final String SMOKE_NORMAL = EnumParticleTypes.SMOKE_NORMAL.getParticleName();
	@PythonFieldGenerated
	public static final String SMOKE_LARGE = EnumParticleTypes.SMOKE_LARGE.getParticleName();
	@PythonFieldGenerated
	public static final String SPELL = EnumParticleTypes.SPELL.getParticleName();
	@PythonFieldGenerated
	public static final String SPELL_INSTANT = EnumParticleTypes.SPELL_INSTANT.getParticleName();
	@PythonFieldGenerated
	public static final String SPELL_MOB = EnumParticleTypes.SPELL_MOB.getParticleName();
	@PythonFieldGenerated
	public static final String SPELL_MOB_AMBIENT = EnumParticleTypes.SPELL_MOB_AMBIENT.getParticleName();
	@PythonFieldGenerated
	public static final String SPELL_WITCH = EnumParticleTypes.SPELL_WITCH.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Rain.")
	public static final String DRIP_WATER = EnumParticleTypes.DRIP_WATER.getParticleName();
	@PythonFieldGenerated
	public static final String DRIP_LAVA = EnumParticleTypes.DRIP_LAVA.getParticleName();
	@PythonFieldGenerated
	public static final String VILLAGER_ANGRY = EnumParticleTypes.VILLAGER_ANGRY.getParticleName();
	@PythonFieldGenerated
	public static final String VILLAGER_HAPPY = EnumParticleTypes.VILLAGER_HAPPY.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Caused by Mycelium.")
	public static final String TOWN_AURA = EnumParticleTypes.TOWN_AURA.getParticleName();
	@PythonFieldGenerated
	public static final String NOTE = EnumParticleTypes.NOTE.getParticleName();
	@PythonFieldGenerated
	public static final String PORTAL = EnumParticleTypes.PORTAL.getParticleName();
	@PythonFieldGenerated
	public static final String ENCHANTMENT_TABLE = EnumParticleTypes.ENCHANTMENT_TABLE.getParticleName();
	@PythonFieldGenerated
	public static final String FLAME = EnumParticleTypes.FLAME.getParticleName();
	@PythonFieldGenerated
	public static final String LAVA = EnumParticleTypes.LAVA.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Planned to be removed in Minecraft 1.13")
	public static final String FOOTSTEP = EnumParticleTypes.FOOTSTEP.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Spawned by Illusion Illagers.")
	public static final String CLOUD = EnumParticleTypes.CLOUD.getParticleName();
	@PythonFieldGenerated
	public static final String REDSTONE = EnumParticleTypes.REDSTONE.getParticleName();
	@PythonFieldGenerated
	public static final String SNOWBALL = EnumParticleTypes.SNOWBALL.getParticleName();
	@PythonFieldGenerated
	public static final String SNOW_SHOVEL = EnumParticleTypes.SNOW_SHOVEL.getParticleName();
	@PythonFieldGenerated
	public static final String SLIME = EnumParticleTypes.SLIME.getParticleName();
	@PythonFieldGenerated
	public static final String HEART = EnumParticleTypes.HEART.getParticleName();
	@PythonFieldGenerated
	public static final String BARRIER = EnumParticleTypes.BARRIER.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Takes two args, 1st for the block/item id, 2nd for data value.")
	public static final String ITEM_CRACK = EnumParticleTypes.ITEM_CRACK.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String BLOCK_CRACK = EnumParticleTypes.BLOCK_CRACK.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String BLOCK_DUST = EnumParticleTypes.BLOCK_DUST.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Rain.")
	public static final String WATER_DROP = EnumParticleTypes.WATER_DROP.getParticleName();
	@PythonFieldGenerated
	public static final String ITEM_TAKE = EnumParticleTypes.ITEM_TAKE.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Caused by Elder Guardians when they give effects.")
	public static final String MOB_APPEARANCE = EnumParticleTypes.MOB_APPEARANCE.getParticleName();
	@PythonFieldGenerated
	public static final String DRAGON_BREATH = EnumParticleTypes.DRAGON_BREATH.getParticleName();
	@PythonFieldGenerated
	public static final String END_ROD = EnumParticleTypes.END_ROD.getParticleName();
	@PythonFieldGenerated
	public static final String DAMAGE_INDICATOR = EnumParticleTypes.DAMAGE_INDICATOR.getParticleName();
	@PythonFieldGenerated
	public static final String SWEEP_ATTACK = EnumParticleTypes.SWEEP_ATTACK.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Takes a single arg, the number for a combined block and meta.  Use particleType.getParam() for the number.")
	public static final String FALLING_DUST = EnumParticleTypes.FALLING_DUST.getParticleName();
	@PythonFieldGenerated
	@PythonDocString("Totem of Undying effect.")
	public static final String TOTEM = EnumParticleTypes.TOTEM.getParticleName();
	@PythonFieldGenerated
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
