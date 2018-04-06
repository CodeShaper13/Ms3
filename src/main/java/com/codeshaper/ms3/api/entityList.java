package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

@PythonDocString("A list of all the vanilla entities names as strings.")
public class entityList {
	
	private entityList() { }

	@PythonField(entityList.PLAYER)
	public static final String PLAYER = "player";

	@PythonField(entityList.ITEM)
	public static final String ITEM = "item";
	@PythonField(entityList.XP_ORB)
	public static final String XP_ORB = "xp_orb";
	@PythonField(entityList.AREA_EFFECT_CLOUD)
	public static final String AREA_EFFECT_CLOUD = "area_effect_cloud";
	@PythonField(entityList.ELDER_GUARDIAN)
	public static final String ELDER_GUARDIAN = "elder_guardian";
	@PythonField(entityList.WITHER_SKELETON)
	public static final String WITHER_SKELETON = "wither_skeleton";
	@PythonField(entityList.STRAY)
	public static final String STRAY = "stray";
	@PythonField(entityList.EGG)
	public static final String EGG = "egg";
	@PythonField(entityList.LEASH_KNOT)
	public static final String LEASH_KNOT = "leash_knot";
	@PythonField(entityList.LEASH_KNOT)
	public static final String PAINTING = "painting";
	@PythonField(entityList.ARROW)
	public static final String ARROW = "arrow";
	@PythonField(entityList.SNOWBALL)
	public static final String SNOWBALL = "snowball";
	@PythonField(entityList.FIRE_BALL)
	public static final String FIRE_BALL = "fireball";
	@PythonField(entityList.SMALL_FIREBALL)
	public static final String SMALL_FIREBALL = "small_fireball";
	@PythonField(entityList.ENDER_PEARL)
	public static final String ENDER_PEARL = "ender_pearl";
	@PythonField(entityList.EYE_OF_ENDER_SIGNAL)
	public static final String EYE_OF_ENDER_SIGNAL = "eye_of_ender_signal";
	@PythonField(entityList.POTION)
	public static final String POTION = "potion";
	@PythonField(entityList.XP_BOTTLE)
	public static final String XP_BOTTLE = "xp_bottle";
	@PythonField(entityList.ITEM_FRAME)
	public static final String ITEM_FRAME = "item_frame";
	@PythonField(entityList.WITHER_SKULL)
	public static final String WITHER_SKULL = "wither_skull";
	@PythonField(entityList.TNT)
	public static final String TNT = "tnt";
	@PythonField(entityList.FALLING_BLOCK)
	public static final String FALLING_BLOCK = "falling_block";
	@PythonField(entityList.FIREWORKS_ROCKET)
	public static final String FIREWORKS_ROCKET = "fireworks_rocket";
	@PythonField(entityList.HUSK)
	public static final String HUSK = "husk";
	@PythonField(entityList.SPECTRAL_ARROW)
	public static final String SPECTRAL_ARROW = "spectral_arrow";
	@PythonField(entityList.SHULKER_BULLET)
	public static final String SHULKER_BULLET = "shulker_bullet";
	@PythonField(entityList.DRAGON_FIREBALL)
	public static final String DRAGON_FIREBALL = "dragon_fireball";
	@PythonField(entityList.ZOMBIE_VILLAGER)
	public static final String ZOMBIE_VILLAGER = "zombie_villager";
	@PythonField(entityList.SKELETON_HORSE)
	public static final String SKELETON_HORSE = "skeleton_horse";
	@PythonField(entityList.ZOMBIE_HORSE)
	public static final String ZOMBIE_HORSE = "zombie_horse";
	@PythonField(entityList.ARMOR_STAND)
	public static final String ARMOR_STAND = "armor_stand";
	@PythonField(entityList.DONKEY)
	public static final String DONKEY = "donkey";
	@PythonField(entityList.MULE)
	public static final String MULE = "mule";
	@PythonField(entityList.EVOCATION_FANGS)
	public static final String EVOCATION_FANGS = "evocation_fangs";
	@PythonField(entityList.EVOCATION_ILLAGER)
	public static final String EVOCATION_ILLAGER = "evocation_illager";
	@PythonField(entityList.VEX)
	public static final String VEX = "vex";
	@PythonField(entityList.VINDICATION_ILLAGER)
	public static final String VINDICATION_ILLAGER = "vindication_illager";
	@PythonField(entityList.ILLUSION_ILLAGER)
	public static final String ILLUSION_ILLAGER = "illusion_illager";
	@PythonField(entityList.COMMANDBLOCK_MINECART)
	public static final String COMMANDBLOCK_MINECART = "commandblock_minecart";
	@PythonField(entityList.BOAT)
	public static final String BOAT = "boat";
	@PythonField(entityList.MINECART)
	public static final String MINECART = "minecart";
	@PythonField(entityList.CHEST_MINECART)
	public static final String CHEST_MINECART = "chest_minecart";
	@PythonField(entityList.FURNACE_MINECART)
	public static final String FURNACE_MINECART = "furnace_minecart";
	@PythonField(entityList.TNT_MINECART)
	public static final String TNT_MINECART = "tnt_minecart";
	@PythonField(entityList.HOPPER_MINECART)
	public static final String HOPPER_MINECART = "hopper_minecart";
	@PythonField(entityList.SPAWNER_MINECART)
	public static final String SPAWNER_MINECART = "spawner_minecart";
	@PythonField(entityList.CREEPER)
	public static final String CREEPER = "creeper";
	@PythonField(entityList.SKELETON)
	public static final String SKELETON = "skeleton";
	@PythonField(entityList.SPIDER)
	public static final String SPIDER = "spider";
	@PythonField(entityList.GIANT)
	public static final String GIANT = "giant";
	@PythonField(entityList.ZOMBIE)
	public static final String ZOMBIE = "zombie";
	@PythonField(entityList.SLIME)
	public static final String SLIME = "slime";
	@PythonField(entityList.GHAST)
	public static final String GHAST = "ghast";
	@PythonField(entityList.ZOMBIE_PIGMAN)
	public static final String ZOMBIE_PIGMAN = "zombie_pigman";
	@PythonField(entityList.ZOMBIE_PIGMAN)
	public static final String ENDERMAN = "enderman";
	@PythonField(entityList.CAVE_SPDER)
	public static final String CAVE_SPDER = "cave_spider";
	@PythonField(entityList.SILVERFISH)
	public static final String SILVERFISH = "silverfish";
	@PythonField(entityList.BLAZE)
	public static final String BLAZE = "blaze";
	@PythonField(entityList.MAGMA_CUBE)
	public static final String MAGMA_CUBE = "magma_cube";
	@PythonField(entityList.ENDER_DRAGON)
	public static final String ENDER_DRAGON = "ender_dragon";
	@PythonField(entityList.WITHER)
	public static final String WITHER = "wither";
	@PythonField(entityList.BAT)
	public static final String BAT = "bat";
	@PythonField(entityList.WITCH)
	public static final String WITCH = "witch";
	@PythonField(entityList.ENDERMITE)
	public static final String ENDERMITE = "endermite";
	@PythonField(entityList.GUARDIAN)
	public static final String GUARDIAN = "guardian";
	@PythonField(entityList.SHULKER)
	public static final String SHULKER = "shulker";
	@PythonField(entityList.PIG)
	public static final String PIG = "pig";
	@PythonField(entityList.SHEEP)
	public static final String SHEEP = "sheep";
	@PythonField(entityList.COW)
	public static final String COW = "cow";
	@PythonField(entityList.CHICKEN)
	public static final String CHICKEN = "chicken";
	@PythonField(entityList.SQUID)
	public static final String SQUID = "squid";
	@PythonField(entityList.WOLF)
	public static final String WOLF = "wolf";
	@PythonField(entityList.MOOSHROOM)
	public static final String MOOSHROOM = "mooshroom";
	@PythonField(entityList.SNOW_GOLEM)
	public static final String SNOW_GOLEM = "snowman";
	@PythonField(entityList.OCELOT)
	public static final String OCELOT = "ocelot";
	@PythonField(entityList.IRON_GOLEM)
	public static final String IRON_GOLEM = "villager_golem";
	@PythonField(entityList.HORSE)
	public static final String HORSE = "horse";
	@PythonField(entityList.RABBIT)
	public static final String RABBIT = "rabbit";
	@PythonField(entityList.POLAR_BEAR)
	public static final String POLAR_BEAR = "polar_bear";
	@PythonField(entityList.LLAMA)
	public static final String LLAMA = "llama";
	@PythonField(entityList.LLAMA_SPIT)
	public static final String LLAMA_SPIT = "llama_spit";
	@PythonField(entityList.PARROT)
	public static final String PARROT = "parrot";
	@PythonField(entityList.VILLAGER)
	public static final String VILLAGER = "villager";
	@PythonField(entityList.ENDER_CRYSTAL)
	public static final String ENDER_CRYSTAL = "ender_crystal";
}
