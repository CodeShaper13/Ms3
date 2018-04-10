package com.codeshaper.ms3.api;

import org.python.core.PyString;
import org.python.core.PyList;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonClass
@PythonDocString("A list of all the vanilla Item names.")
public class items {

    private static PyList names = new PyList();

    private items() { }

    @PythonField
    public static final String AIR = func("minecraft:air");
    @PythonField
    public static final String STONE = func("minecraft:stone");
    @PythonField
    public static final String GRASS = func("minecraft:grass");
    @PythonField
    public static final String DIRT = func("minecraft:dirt");
    @PythonField
    public static final String COBBLESTONE = func("minecraft:cobblestone");
    @PythonField
    public static final String PLANKS = func("minecraft:planks");
    @PythonField
    public static final String SAPLING = func("minecraft:sapling");
    @PythonField
    public static final String BEDROCK = func("minecraft:bedrock");
    @PythonField
    public static final String SAND = func("minecraft:sand");
    @PythonField
    public static final String GRAVEL = func("minecraft:gravel");
    @PythonField
    public static final String GOLD_ORE = func("minecraft:gold_ore");
    @PythonField
    public static final String IRON_ORE = func("minecraft:iron_ore");
    @PythonField
    public static final String COAL_ORE = func("minecraft:coal_ore");
    @PythonField
    public static final String LOG = func("minecraft:log");
    @PythonField
    public static final String LOG2 = func("minecraft:log2");
    @PythonField
    public static final String LEAVES = func("minecraft:leaves");
    @PythonField
    public static final String LEAVES2 = func("minecraft:leaves2");
    @PythonField
    public static final String SPONGE = func("minecraft:sponge");
    @PythonField
    public static final String GLASS = func("minecraft:glass");
    @PythonField
    public static final String LAPIS_ORE = func("minecraft:lapis_ore");
    @PythonField
    public static final String LAPIS_BLOCK = func("minecraft:lapis_block");
    @PythonField
    public static final String DISPENSER = func("minecraft:dispenser");
    @PythonField
    public static final String SANDSTONE = func("minecraft:sandstone");
    @PythonField
    public static final String NOTEBLOCK = func("minecraft:noteblock");
    @PythonField
    public static final String GOLDEN_RAIL = func("minecraft:golden_rail");
    @PythonField
    public static final String DETECTOR_RAIL = func("minecraft:detector_rail");
    @PythonField
    public static final String STICKY_PISTON = func("minecraft:sticky_piston");
    @PythonField
    public static final String WEB = func("minecraft:web");
    @PythonField
    public static final String TALLGRASS = func("minecraft:tallgrass");
    @PythonField
    public static final String DEADBUSH = func("minecraft:deadbush");
    @PythonField
    public static final String PISTON = func("minecraft:piston");
    @PythonField
    public static final String WOOL = func("minecraft:wool");
    @PythonField
    public static final String YELLOW_FLOWER = func("minecraft:yellow_flower");
    @PythonField
    public static final String RED_FLOWER = func("minecraft:red_flower");
    @PythonField
    public static final String BROWN_MUSHROOM = func("minecraft:brown_mushroom");
    @PythonField
    public static final String RED_MUSHROOM = func("minecraft:red_mushroom");
    @PythonField
    public static final String GOLD_BLOCK = func("minecraft:gold_block");
    @PythonField
    public static final String IRON_BLOCK = func("minecraft:iron_block");
    @PythonField
    public static final String STONE_SLAB = func("minecraft:stone_slab");
    @PythonField
    public static final String BRICK_BLOCK = func("minecraft:brick_block");
    @PythonField
    public static final String TNT = func("minecraft:tnt");
    @PythonField
    public static final String BOOKSHELF = func("minecraft:bookshelf");
    @PythonField
    public static final String MOSSY_COBBLESTONE = func("minecraft:mossy_cobblestone");
    @PythonField
    public static final String OBSIDIAN = func("minecraft:obsidian");
    @PythonField
    public static final String TORCH = func("minecraft:torch");
    @PythonField
    public static final String END_ROD = func("minecraft:end_rod");
    @PythonField
    public static final String CHORUS_PLANT = func("minecraft:chorus_plant");
    @PythonField
    public static final String CHORUS_FLOWER = func("minecraft:chorus_flower");
    @PythonField
    public static final String PURPUR_BLOCK = func("minecraft:purpur_block");
    @PythonField
    public static final String PURPUR_PILLAR = func("minecraft:purpur_pillar");
    @PythonField
    public static final String PURPUR_STAIRS = func("minecraft:purpur_stairs");
    @PythonField
    public static final String PURPUR_SLAB = func("minecraft:purpur_slab");
    @PythonField
    public static final String MOB_SPAWNER = func("minecraft:mob_spawner");
    @PythonField
    public static final String OAK_STAIRS = func("minecraft:oak_stairs");
    @PythonField
    public static final String CHEST = func("minecraft:chest");
    @PythonField
    public static final String DIAMOND_ORE = func("minecraft:diamond_ore");
    @PythonField
    public static final String DIAMOND_BLOCK = func("minecraft:diamond_block");
    @PythonField
    public static final String CRAFTING_TABLE = func("minecraft:crafting_table");
    @PythonField
    public static final String FARMLAND = func("minecraft:farmland");
    @PythonField
    public static final String FURNACE = func("minecraft:furnace");
    @PythonField
    public static final String LADDER = func("minecraft:ladder");
    @PythonField
    public static final String RAIL = func("minecraft:rail");
    @PythonField
    public static final String STONE_STAIRS = func("minecraft:stone_stairs");
    @PythonField
    public static final String LEVER = func("minecraft:lever");
    @PythonField
    public static final String STONE_PRESSURE_PLATE = func("minecraft:stone_pressure_plate");
    @PythonField
    public static final String WOODEN_PRESSURE_PLATE = func("minecraft:wooden_pressure_plate");
    @PythonField
    public static final String REDSTONE_ORE = func("minecraft:redstone_ore");
    @PythonField
    public static final String REDSTONE_TORCH = func("minecraft:redstone_torch");
    @PythonField
    public static final String STONE_BUTTON = func("minecraft:stone_button");
    @PythonField
    public static final String SNOW_LAYER = func("minecraft:snow_layer");
    @PythonField
    public static final String ICE = func("minecraft:ice");
    @PythonField
    public static final String SNOW = func("minecraft:snow");
    @PythonField
    public static final String CACTUS = func("minecraft:cactus");
    @PythonField
    public static final String CLAY = func("minecraft:clay");
    @PythonField
    public static final String JUKEBOX = func("minecraft:jukebox");
    @PythonField
    public static final String FENCE = func("minecraft:fence");
    @PythonField
    public static final String SPRUCE_FENCE = func("minecraft:spruce_fence");
    @PythonField
    public static final String BIRCH_FENCE = func("minecraft:birch_fence");
    @PythonField
    public static final String JUNGLE_FENCE = func("minecraft:jungle_fence");
    @PythonField
    public static final String DARK_OAK_FENCE = func("minecraft:dark_oak_fence");
    @PythonField
    public static final String ACACIA_FENCE = func("minecraft:acacia_fence");
    @PythonField
    public static final String PUMPKIN = func("minecraft:pumpkin");
    @PythonField
    public static final String NETHERRACK = func("minecraft:netherrack");
    @PythonField
    public static final String SOUL_SAND = func("minecraft:soul_sand");
    @PythonField
    public static final String GLOWSTONE = func("minecraft:glowstone");
    @PythonField
    public static final String LIT_PUMPKIN = func("minecraft:lit_pumpkin");
    @PythonField
    public static final String TRAPDOOR = func("minecraft:trapdoor");
    @PythonField
    public static final String MONSTER_EGG = func("minecraft:monster_egg");
    @PythonField
    public static final String STONEBRICK = func("minecraft:stonebrick");
    @PythonField
    public static final String BROWN_MUSHROOM_BLOCK = func("minecraft:brown_mushroom_block");
    @PythonField
    public static final String RED_MUSHROOM_BLOCK = func("minecraft:red_mushroom_block");
    @PythonField
    public static final String IRON_BARS = func("minecraft:iron_bars");
    @PythonField
    public static final String GLASS_PANE = func("minecraft:glass_pane");
    @PythonField
    public static final String MELON_BLOCK = func("minecraft:melon_block");
    @PythonField
    public static final String VINE = func("minecraft:vine");
    @PythonField
    public static final String FENCE_GATE = func("minecraft:fence_gate");
    @PythonField
    public static final String SPRUCE_FENCE_GATE = func("minecraft:spruce_fence_gate");
    @PythonField
    public static final String BIRCH_FENCE_GATE = func("minecraft:birch_fence_gate");
    @PythonField
    public static final String JUNGLE_FENCE_GATE = func("minecraft:jungle_fence_gate");
    @PythonField
    public static final String DARK_OAK_FENCE_GATE = func("minecraft:dark_oak_fence_gate");
    @PythonField
    public static final String ACACIA_FENCE_GATE = func("minecraft:acacia_fence_gate");
    @PythonField
    public static final String BRICK_STAIRS = func("minecraft:brick_stairs");
    @PythonField
    public static final String STONE_BRICK_STAIRS = func("minecraft:stone_brick_stairs");
    @PythonField
    public static final String MYCELIUM = func("minecraft:mycelium");
    @PythonField
    public static final String WATERLILY = func("minecraft:waterlily");
    @PythonField
    public static final String NETHER_BRICK = func("minecraft:nether_brick");
    @PythonField
    public static final String NETHER_BRICK_FENCE = func("minecraft:nether_brick_fence");
    @PythonField
    public static final String NETHER_BRICK_STAIRS = func("minecraft:nether_brick_stairs");
    @PythonField
    public static final String ENCHANTING_TABLE = func("minecraft:enchanting_table");
    @PythonField
    public static final String END_PORTAL_FRAME = func("minecraft:end_portal_frame");
    @PythonField
    public static final String END_STONE = func("minecraft:end_stone");
    @PythonField
    public static final String END_BRICKS = func("minecraft:end_bricks");
    @PythonField
    public static final String DRAGON_EGG = func("minecraft:dragon_egg");
    @PythonField
    public static final String REDSTONE_LAMP = func("minecraft:redstone_lamp");
    @PythonField
    public static final String WOODEN_SLAB = func("minecraft:wooden_slab");
    @PythonField
    public static final String SANDSTONE_STAIRS = func("minecraft:sandstone_stairs");
    @PythonField
    public static final String EMERALD_ORE = func("minecraft:emerald_ore");
    @PythonField
    public static final String ENDER_CHEST = func("minecraft:ender_chest");
    @PythonField
    public static final String TRIPWIRE_HOOK = func("minecraft:tripwire_hook");
    @PythonField
    public static final String EMERALD_BLOCK = func("minecraft:emerald_block");
    @PythonField
    public static final String SPRUCE_STAIRS = func("minecraft:spruce_stairs");
    @PythonField
    public static final String BIRCH_STAIRS = func("minecraft:birch_stairs");
    @PythonField
    public static final String JUNGLE_STAIRS = func("minecraft:jungle_stairs");
    @PythonField
    public static final String COMMAND_BLOCK = func("minecraft:command_block");
    @PythonField
    public static final String BEACON = func("minecraft:beacon");
    @PythonField
    public static final String COBBLESTONE_WALL = func("minecraft:cobblestone_wall");
    @PythonField
    public static final String WOODEN_BUTTON = func("minecraft:wooden_button");
    @PythonField
    public static final String ANVIL = func("minecraft:anvil");
    @PythonField
    public static final String TRAPPED_CHEST = func("minecraft:trapped_chest");
    @PythonField
    public static final String LIGHT_WEIGHTED_PRESSURE_PLATE = func("minecraft:light_weighted_pressure_plate");
    @PythonField
    public static final String HEAVY_WEIGHTED_PRESSURE_PLATE = func("minecraft:heavy_weighted_pressure_plate");
    @PythonField
    public static final String DAYLIGHT_DETECTOR = func("minecraft:daylight_detector");
    @PythonField
    public static final String REDSTONE_BLOCK = func("minecraft:redstone_block");
    @PythonField
    public static final String QUARTZ_ORE = func("minecraft:quartz_ore");
    @PythonField
    public static final String HOPPER = func("minecraft:hopper");
    @PythonField
    public static final String QUARTZ_BLOCK = func("minecraft:quartz_block");
    @PythonField
    public static final String QUARTZ_STAIRS = func("minecraft:quartz_stairs");
    @PythonField
    public static final String ACTIVATOR_RAIL = func("minecraft:activator_rail");
    @PythonField
    public static final String DROPPER = func("minecraft:dropper");
    @PythonField
    public static final String STAINED_HARDENED_CLAY = func("minecraft:stained_hardened_clay");
    @PythonField
    public static final String BARRIER = func("minecraft:barrier");
    @PythonField
    public static final String IRON_TRAPDOOR = func("minecraft:iron_trapdoor");
    @PythonField
    public static final String HAY_BLOCK = func("minecraft:hay_block");
    @PythonField
    public static final String CARPET = func("minecraft:carpet");
    @PythonField
    public static final String HARDENED_CLAY = func("minecraft:hardened_clay");
    @PythonField
    public static final String COAL_BLOCK = func("minecraft:coal_block");
    @PythonField
    public static final String PACKED_ICE = func("minecraft:packed_ice");
    @PythonField
    public static final String ACACIA_STAIRS = func("minecraft:acacia_stairs");
    @PythonField
    public static final String DARK_OAK_STAIRS = func("minecraft:dark_oak_stairs");
    @PythonField
    public static final String SLIME = func("minecraft:slime");
    @PythonField
    public static final String GRASS_PATH = func("minecraft:grass_path");
    @PythonField
    public static final String DOUBLE_PLANT = func("minecraft:double_plant");
    @PythonField
    public static final String STAINED_GLASS = func("minecraft:stained_glass");
    @PythonField
    public static final String STAINED_GLASS_PANE = func("minecraft:stained_glass_pane");
    @PythonField
    public static final String PRISMARINE = func("minecraft:prismarine");
    @PythonField
    public static final String SEA_LANTERN = func("minecraft:sea_lantern");
    @PythonField
    public static final String RED_SANDSTONE = func("minecraft:red_sandstone");
    @PythonField
    public static final String RED_SANDSTONE_STAIRS = func("minecraft:red_sandstone_stairs");
    @PythonField
    public static final String STONE_SLAB2 = func("minecraft:stone_slab2");
    @PythonField
    public static final String REPEATING_COMMAND_BLOCK = func("minecraft:repeating_command_block");
    @PythonField
    public static final String CHAIN_COMMAND_BLOCK = func("minecraft:chain_command_block");
    @PythonField
    public static final String MAGMA = func("minecraft:magma");
    @PythonField
    public static final String NETHER_WART_BLOCK = func("minecraft:nether_wart_block");
    @PythonField
    public static final String RED_NETHER_BRICK = func("minecraft:red_nether_brick");
    @PythonField
    public static final String BONE_BLOCK = func("minecraft:bone_block");
    @PythonField
    public static final String STRUCTURE_VOID = func("minecraft:structure_void");
    @PythonField
    public static final String OBSERVER = func("minecraft:observer");
    @PythonField
    public static final String WHITE_SHULKER_BOX = func("minecraft:white_shulker_box");
    @PythonField
    public static final String ORANGE_SHULKER_BOX = func("minecraft:orange_shulker_box");
    @PythonField
    public static final String MAGENTA_SHULKER_BOX = func("minecraft:magenta_shulker_box");
    @PythonField
    public static final String LIGHT_BLUE_SHULKER_BOX = func("minecraft:light_blue_shulker_box");
    @PythonField
    public static final String YELLOW_SHULKER_BOX = func("minecraft:yellow_shulker_box");
    @PythonField
    public static final String LIME_SHULKER_BOX = func("minecraft:lime_shulker_box");
    @PythonField
    public static final String PINK_SHULKER_BOX = func("minecraft:pink_shulker_box");
    @PythonField
    public static final String GRAY_SHULKER_BOX = func("minecraft:gray_shulker_box");
    @PythonField
    public static final String SILVER_SHULKER_BOX = func("minecraft:silver_shulker_box");
    @PythonField
    public static final String CYAN_SHULKER_BOX = func("minecraft:cyan_shulker_box");
    @PythonField
    public static final String PURPLE_SHULKER_BOX = func("minecraft:purple_shulker_box");
    @PythonField
    public static final String BLUE_SHULKER_BOX = func("minecraft:blue_shulker_box");
    @PythonField
    public static final String BROWN_SHULKER_BOX = func("minecraft:brown_shulker_box");
    @PythonField
    public static final String GREEN_SHULKER_BOX = func("minecraft:green_shulker_box");
    @PythonField
    public static final String RED_SHULKER_BOX = func("minecraft:red_shulker_box");
    @PythonField
    public static final String BLACK_SHULKER_BOX = func("minecraft:black_shulker_box");
    @PythonField
    public static final String WHITE_GLAZED_TERRACOTTA = func("minecraft:white_glazed_terracotta");
    @PythonField
    public static final String ORANGE_GLAZED_TERRACOTTA = func("minecraft:orange_glazed_terracotta");
    @PythonField
    public static final String MAGENTA_GLAZED_TERRACOTTA = func("minecraft:magenta_glazed_terracotta");
    @PythonField
    public static final String LIGHT_BLUE_GLAZED_TERRACOTTA = func("minecraft:light_blue_glazed_terracotta");
    @PythonField
    public static final String YELLOW_GLAZED_TERRACOTTA = func("minecraft:yellow_glazed_terracotta");
    @PythonField
    public static final String LIME_GLAZED_TERRACOTTA = func("minecraft:lime_glazed_terracotta");
    @PythonField
    public static final String PINK_GLAZED_TERRACOTTA = func("minecraft:pink_glazed_terracotta");
    @PythonField
    public static final String GRAY_GLAZED_TERRACOTTA = func("minecraft:gray_glazed_terracotta");
    @PythonField
    public static final String SILVER_GLAZED_TERRACOTTA = func("minecraft:silver_glazed_terracotta");
    @PythonField
    public static final String CYAN_GLAZED_TERRACOTTA = func("minecraft:cyan_glazed_terracotta");
    @PythonField
    public static final String PURPLE_GLAZED_TERRACOTTA = func("minecraft:purple_glazed_terracotta");
    @PythonField
    public static final String BLUE_GLAZED_TERRACOTTA = func("minecraft:blue_glazed_terracotta");
    @PythonField
    public static final String BROWN_GLAZED_TERRACOTTA = func("minecraft:brown_glazed_terracotta");
    @PythonField
    public static final String GREEN_GLAZED_TERRACOTTA = func("minecraft:green_glazed_terracotta");
    @PythonField
    public static final String RED_GLAZED_TERRACOTTA = func("minecraft:red_glazed_terracotta");
    @PythonField
    public static final String BLACK_GLAZED_TERRACOTTA = func("minecraft:black_glazed_terracotta");
    @PythonField
    public static final String CONCRETE = func("minecraft:concrete");
    @PythonField
    public static final String CONCRETE_POWDER = func("minecraft:concrete_powder");
    @PythonField
    public static final String STRUCTURE_BLOCK = func("minecraft:structure_block");
    @PythonField
    public static final String IRON_SHOVEL = func("minecraft:iron_shovel");
    @PythonField
    public static final String IRON_PICKAXE = func("minecraft:iron_pickaxe");
    @PythonField
    public static final String IRON_AXE = func("minecraft:iron_axe");
    @PythonField
    public static final String FLINT_AND_STEEL = func("minecraft:flint_and_steel");
    @PythonField
    public static final String APPLE = func("minecraft:apple");
    @PythonField
    public static final String BOW = func("minecraft:bow");
    @PythonField
    public static final String ARROW = func("minecraft:arrow");
    @PythonField
    public static final String COAL = func("minecraft:coal");
    @PythonField
    public static final String DIAMOND = func("minecraft:diamond");
    @PythonField
    public static final String IRON_INGOT = func("minecraft:iron_ingot");
    @PythonField
    public static final String GOLD_INGOT = func("minecraft:gold_ingot");
    @PythonField
    public static final String IRON_SWORD = func("minecraft:iron_sword");
    @PythonField
    public static final String WOODEN_SWORD = func("minecraft:wooden_sword");
    @PythonField
    public static final String WOODEN_SHOVEL = func("minecraft:wooden_shovel");
    @PythonField
    public static final String WOODEN_PICKAXE = func("minecraft:wooden_pickaxe");
    @PythonField
    public static final String WOODEN_AXE = func("minecraft:wooden_axe");
    @PythonField
    public static final String STONE_SWORD = func("minecraft:stone_sword");
    @PythonField
    public static final String STONE_SHOVEL = func("minecraft:stone_shovel");
    @PythonField
    public static final String STONE_PICKAXE = func("minecraft:stone_pickaxe");
    @PythonField
    public static final String STONE_AXE = func("minecraft:stone_axe");
    @PythonField
    public static final String DIAMOND_SWORD = func("minecraft:diamond_sword");
    @PythonField
    public static final String DIAMOND_SHOVEL = func("minecraft:diamond_shovel");
    @PythonField
    public static final String DIAMOND_PICKAXE = func("minecraft:diamond_pickaxe");
    @PythonField
    public static final String DIAMOND_AXE = func("minecraft:diamond_axe");
    @PythonField
    public static final String STICK = func("minecraft:stick");
    @PythonField
    public static final String BOWL = func("minecraft:bowl");
    @PythonField
    public static final String MUSHROOM_STEW = func("minecraft:mushroom_stew");
    @PythonField
    public static final String GOLDEN_SWORD = func("minecraft:golden_sword");
    @PythonField
    public static final String GOLDEN_SHOVEL = func("minecraft:golden_shovel");
    @PythonField
    public static final String GOLDEN_PICKAXE = func("minecraft:golden_pickaxe");
    @PythonField
    public static final String GOLDEN_AXE = func("minecraft:golden_axe");
    @PythonField
    public static final String STRING = func("minecraft:string");
    @PythonField
    public static final String FEATHER = func("minecraft:feather");
    @PythonField
    public static final String GUNPOWDER = func("minecraft:gunpowder");
    @PythonField
    public static final String WOODEN_HOE = func("minecraft:wooden_hoe");
    @PythonField
    public static final String STONE_HOE = func("minecraft:stone_hoe");
    @PythonField
    public static final String IRON_HOE = func("minecraft:iron_hoe");
    @PythonField
    public static final String DIAMOND_HOE = func("minecraft:diamond_hoe");
    @PythonField
    public static final String GOLDEN_HOE = func("minecraft:golden_hoe");
    @PythonField
    public static final String WHEAT_SEEDS = func("minecraft:wheat_seeds");
    @PythonField
    public static final String WHEAT = func("minecraft:wheat");
    @PythonField
    public static final String BREAD = func("minecraft:bread");
    @PythonField
    public static final String LEATHER_HELMET = func("minecraft:leather_helmet");
    @PythonField
    public static final String LEATHER_CHESTPLATE = func("minecraft:leather_chestplate");
    @PythonField
    public static final String LEATHER_LEGGINGS = func("minecraft:leather_leggings");
    @PythonField
    public static final String LEATHER_BOOTS = func("minecraft:leather_boots");
    @PythonField
    public static final String CHAINMAIL_HELMET = func("minecraft:chainmail_helmet");
    @PythonField
    public static final String CHAINMAIL_CHESTPLATE = func("minecraft:chainmail_chestplate");
    @PythonField
    public static final String CHAINMAIL_LEGGINGS = func("minecraft:chainmail_leggings");
    @PythonField
    public static final String CHAINMAIL_BOOTS = func("minecraft:chainmail_boots");
    @PythonField
    public static final String IRON_HELMET = func("minecraft:iron_helmet");
    @PythonField
    public static final String IRON_CHESTPLATE = func("minecraft:iron_chestplate");
    @PythonField
    public static final String IRON_LEGGINGS = func("minecraft:iron_leggings");
    @PythonField
    public static final String IRON_BOOTS = func("minecraft:iron_boots");
    @PythonField
    public static final String DIAMOND_HELMET = func("minecraft:diamond_helmet");
    @PythonField
    public static final String DIAMOND_CHESTPLATE = func("minecraft:diamond_chestplate");
    @PythonField
    public static final String DIAMOND_LEGGINGS = func("minecraft:diamond_leggings");
    @PythonField
    public static final String DIAMOND_BOOTS = func("minecraft:diamond_boots");
    @PythonField
    public static final String GOLDEN_HELMET = func("minecraft:golden_helmet");
    @PythonField
    public static final String GOLDEN_CHESTPLATE = func("minecraft:golden_chestplate");
    @PythonField
    public static final String GOLDEN_LEGGINGS = func("minecraft:golden_leggings");
    @PythonField
    public static final String GOLDEN_BOOTS = func("minecraft:golden_boots");
    @PythonField
    public static final String FLINT = func("minecraft:flint");
    @PythonField
    public static final String PORKCHOP = func("minecraft:porkchop");
    @PythonField
    public static final String COOKED_PORKCHOP = func("minecraft:cooked_porkchop");
    @PythonField
    public static final String PAINTING = func("minecraft:painting");
    @PythonField
    public static final String GOLDEN_APPLE = func("minecraft:golden_apple");
    @PythonField
    public static final String SIGN = func("minecraft:sign");
    @PythonField
    public static final String WOODEN_DOOR = func("minecraft:wooden_door");
    @PythonField
    public static final String BUCKET = func("minecraft:bucket");
    @PythonField
    public static final String WATER_BUCKET = func("minecraft:water_bucket");
    @PythonField
    public static final String LAVA_BUCKET = func("minecraft:lava_bucket");
    @PythonField
    public static final String MINECART = func("minecraft:minecart");
    @PythonField
    public static final String SADDLE = func("minecraft:saddle");
    @PythonField
    public static final String IRON_DOOR = func("minecraft:iron_door");
    @PythonField
    public static final String REDSTONE = func("minecraft:redstone");
    @PythonField
    public static final String SNOWBALL = func("minecraft:snowball");
    @PythonField
    public static final String BOAT = func("minecraft:boat");
    @PythonField
    public static final String LEATHER = func("minecraft:leather");
    @PythonField
    public static final String MILK_BUCKET = func("minecraft:milk_bucket");
    @PythonField
    public static final String BRICK = func("minecraft:brick");
    @PythonField
    public static final String CLAY_BALL = func("minecraft:clay_ball");
    @PythonField
    public static final String REEDS = func("minecraft:reeds");
    @PythonField
    public static final String PAPER = func("minecraft:paper");
    @PythonField
    public static final String BOOK = func("minecraft:book");
    @PythonField
    public static final String SLIME_BALL = func("minecraft:slime_ball");
    @PythonField
    public static final String CHEST_MINECART = func("minecraft:chest_minecart");
    @PythonField
    public static final String FURNACE_MINECART = func("minecraft:furnace_minecart");
    @PythonField
    public static final String EGG = func("minecraft:egg");
    @PythonField
    public static final String COMPASS = func("minecraft:compass");
    @PythonField
    public static final String FISHING_ROD = func("minecraft:fishing_rod");
    @PythonField
    public static final String CLOCK = func("minecraft:clock");
    @PythonField
    public static final String GLOWSTONE_DUST = func("minecraft:glowstone_dust");
    @PythonField
    public static final String FISH = func("minecraft:fish");
    @PythonField
    public static final String COOKED_FISH = func("minecraft:cooked_fish");
    @PythonField
    public static final String DYE = func("minecraft:dye");
    @PythonField
    public static final String BONE = func("minecraft:bone");
    @PythonField
    public static final String SUGAR = func("minecraft:sugar");
    @PythonField
    public static final String CAKE = func("minecraft:cake");
    @PythonField
    public static final String BED = func("minecraft:bed");
    @PythonField
    public static final String REPEATER = func("minecraft:repeater");
    @PythonField
    public static final String COOKIE = func("minecraft:cookie");
    @PythonField
    public static final String FILLED_MAP = func("minecraft:filled_map");
    @PythonField
    public static final String SHEARS = func("minecraft:shears");
    @PythonField
    public static final String MELON = func("minecraft:melon");
    @PythonField
    public static final String PUMPKIN_SEEDS = func("minecraft:pumpkin_seeds");
    @PythonField
    public static final String MELON_SEEDS = func("minecraft:melon_seeds");
    @PythonField
    public static final String BEEF = func("minecraft:beef");
    @PythonField
    public static final String COOKED_BEEF = func("minecraft:cooked_beef");
    @PythonField
    public static final String CHICKEN = func("minecraft:chicken");
    @PythonField
    public static final String COOKED_CHICKEN = func("minecraft:cooked_chicken");
    @PythonField
    public static final String ROTTEN_FLESH = func("minecraft:rotten_flesh");
    @PythonField
    public static final String ENDER_PEARL = func("minecraft:ender_pearl");
    @PythonField
    public static final String BLAZE_ROD = func("minecraft:blaze_rod");
    @PythonField
    public static final String GHAST_TEAR = func("minecraft:ghast_tear");
    @PythonField
    public static final String GOLD_NUGGET = func("minecraft:gold_nugget");
    @PythonField
    public static final String NETHER_WART = func("minecraft:nether_wart");
    @PythonField
    public static final String POTION = func("minecraft:potion");
    @PythonField
    public static final String GLASS_BOTTLE = func("minecraft:glass_bottle");
    @PythonField
    public static final String SPIDER_EYE = func("minecraft:spider_eye");
    @PythonField
    public static final String FERMENTED_SPIDER_EYE = func("minecraft:fermented_spider_eye");
    @PythonField
    public static final String BLAZE_POWDER = func("minecraft:blaze_powder");
    @PythonField
    public static final String MAGMA_CREAM = func("minecraft:magma_cream");
    @PythonField
    public static final String BREWING_STAND = func("minecraft:brewing_stand");
    @PythonField
    public static final String CAULDRON = func("minecraft:cauldron");
    @PythonField
    public static final String ENDER_EYE = func("minecraft:ender_eye");
    @PythonField
    public static final String SPECKLED_MELON = func("minecraft:speckled_melon");
    @PythonField
    public static final String SPAWN_EGG = func("minecraft:spawn_egg");
    @PythonField
    public static final String EXPERIENCE_BOTTLE = func("minecraft:experience_bottle");
    @PythonField
    public static final String FIRE_CHARGE = func("minecraft:fire_charge");
    @PythonField
    public static final String WRITABLE_BOOK = func("minecraft:writable_book");
    @PythonField
    public static final String WRITTEN_BOOK = func("minecraft:written_book");
    @PythonField
    public static final String EMERALD = func("minecraft:emerald");
    @PythonField
    public static final String ITEM_FRAME = func("minecraft:item_frame");
    @PythonField
    public static final String FLOWER_POT = func("minecraft:flower_pot");
    @PythonField
    public static final String CARROT = func("minecraft:carrot");
    @PythonField
    public static final String POTATO = func("minecraft:potato");
    @PythonField
    public static final String BAKED_POTATO = func("minecraft:baked_potato");
    @PythonField
    public static final String POISONOUS_POTATO = func("minecraft:poisonous_potato");
    @PythonField
    public static final String MAP = func("minecraft:map");
    @PythonField
    public static final String GOLDEN_CARROT = func("minecraft:golden_carrot");
    @PythonField
    public static final String SKULL = func("minecraft:skull");
    @PythonField
    public static final String CARROT_ON_A_STICK = func("minecraft:carrot_on_a_stick");
    @PythonField
    public static final String NETHER_STAR = func("minecraft:nether_star");
    @PythonField
    public static final String PUMPKIN_PIE = func("minecraft:pumpkin_pie");
    @PythonField
    public static final String FIREWORKS = func("minecraft:fireworks");
    @PythonField
    public static final String FIREWORK_CHARGE = func("minecraft:firework_charge");
    @PythonField
    public static final String ENCHANTED_BOOK = func("minecraft:enchanted_book");
    @PythonField
    public static final String COMPARATOR = func("minecraft:comparator");
    @PythonField
    public static final String NETHERBRICK = func("minecraft:netherbrick");
    @PythonField
    public static final String QUARTZ = func("minecraft:quartz");
    @PythonField
    public static final String TNT_MINECART = func("minecraft:tnt_minecart");
    @PythonField
    public static final String HOPPER_MINECART = func("minecraft:hopper_minecart");
    @PythonField
    public static final String PRISMARINE_SHARD = func("minecraft:prismarine_shard");
    @PythonField
    public static final String PRISMARINE_CRYSTALS = func("minecraft:prismarine_crystals");
    @PythonField
    public static final String RABBIT = func("minecraft:rabbit");
    @PythonField
    public static final String COOKED_RABBIT = func("minecraft:cooked_rabbit");
    @PythonField
    public static final String RABBIT_STEW = func("minecraft:rabbit_stew");
    @PythonField
    public static final String RABBIT_FOOT = func("minecraft:rabbit_foot");
    @PythonField
    public static final String RABBIT_HIDE = func("minecraft:rabbit_hide");
    @PythonField
    public static final String ARMOR_STAND = func("minecraft:armor_stand");
    @PythonField
    public static final String IRON_HORSE_ARMOR = func("minecraft:iron_horse_armor");
    @PythonField
    public static final String GOLDEN_HORSE_ARMOR = func("minecraft:golden_horse_armor");
    @PythonField
    public static final String DIAMOND_HORSE_ARMOR = func("minecraft:diamond_horse_armor");
    @PythonField
    public static final String LEAD = func("minecraft:lead");
    @PythonField
    public static final String NAME_TAG = func("minecraft:name_tag");
    @PythonField
    public static final String COMMAND_BLOCK_MINECART = func("minecraft:command_block_minecart");
    @PythonField
    public static final String MUTTON = func("minecraft:mutton");
    @PythonField
    public static final String COOKED_MUTTON = func("minecraft:cooked_mutton");
    @PythonField
    public static final String BANNER = func("minecraft:banner");
    @PythonField
    public static final String END_CRYSTAL = func("minecraft:end_crystal");
    @PythonField
    public static final String SPRUCE_DOOR = func("minecraft:spruce_door");
    @PythonField
    public static final String BIRCH_DOOR = func("minecraft:birch_door");
    @PythonField
    public static final String JUNGLE_DOOR = func("minecraft:jungle_door");
    @PythonField
    public static final String ACACIA_DOOR = func("minecraft:acacia_door");
    @PythonField
    public static final String DARK_OAK_DOOR = func("minecraft:dark_oak_door");
    @PythonField
    public static final String CHORUS_FRUIT = func("minecraft:chorus_fruit");
    @PythonField
    public static final String CHORUS_FRUIT_POPPED = func("minecraft:chorus_fruit_popped");
    @PythonField
    public static final String BEETROOT = func("minecraft:beetroot");
    @PythonField
    public static final String BEETROOT_SEEDS = func("minecraft:beetroot_seeds");
    @PythonField
    public static final String BEETROOT_SOUP = func("minecraft:beetroot_soup");
    @PythonField
    public static final String DRAGON_BREATH = func("minecraft:dragon_breath");
    @PythonField
    public static final String SPLASH_POTION = func("minecraft:splash_potion");
    @PythonField
    public static final String SPECTRAL_ARROW = func("minecraft:spectral_arrow");
    @PythonField
    public static final String TIPPED_ARROW = func("minecraft:tipped_arrow");
    @PythonField
    public static final String LINGERING_POTION = func("minecraft:lingering_potion");
    @PythonField
    public static final String SHIELD = func("minecraft:shield");
    @PythonField
    public static final String ELYTRA = func("minecraft:elytra");
    @PythonField
    public static final String SPRUCE_BOAT = func("minecraft:spruce_boat");
    @PythonField
    public static final String BIRCH_BOAT = func("minecraft:birch_boat");
    @PythonField
    public static final String JUNGLE_BOAT = func("minecraft:jungle_boat");
    @PythonField
    public static final String ACACIA_BOAT = func("minecraft:acacia_boat");
    @PythonField
    public static final String DARK_OAK_BOAT = func("minecraft:dark_oak_boat");
    @PythonField
    public static final String TOTEM_OF_UNDYING = func("minecraft:totem_of_undying");
    @PythonField
    public static final String SHULKER_SHELL = func("minecraft:shulker_shell");
    @PythonField
    public static final String IRON_NUGGET = func("minecraft:iron_nugget");
    @PythonField
    public static final String KNOWLEDGE_BOOK = func("minecraft:knowledge_book");
    @PythonField
    public static final String RECORD_13 = func("minecraft:record_13");
    @PythonField
    public static final String RECORD_CAT = func("minecraft:record_cat");
    @PythonField
    public static final String RECORD_BLOCKS = func("minecraft:record_blocks");
    @PythonField
    public static final String RECORD_CHIRP = func("minecraft:record_chirp");
    @PythonField
    public static final String RECORD_FAR = func("minecraft:record_far");
    @PythonField
    public static final String RECORD_MALL = func("minecraft:record_mall");
    @PythonField
    public static final String RECORD_MELLOHI = func("minecraft:record_mellohi");
    @PythonField
    public static final String RECORD_STAL = func("minecraft:record_stal");
    @PythonField
    public static final String RECORD_STRAD = func("minecraft:record_strad");
    @PythonField
    public static final String RECORD_WARD = func("minecraft:record_ward");
    @PythonField
    public static final String RECORD_11 = func("minecraft:record_11");
    @PythonField
    public static final String RECORD_WAIT = func("minecraft:record_wait");

    @PythonFunction
    @PythonDocString("Returns a list of all the vanilla Itemss.")
    public static PyList getAllItems() {
        return names;
    }

    private static String func(String s) {
        names.add(new PyString(s));
        return s;
    }
}