package com.codeshaper.ms3.api;

import org.python.core.PyString;
import org.python.core.PyList;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonClass
@PythonDocString("String constants for all of the vanilla Block names.")
public class blocks {

    private static PyList names = new PyList();

    private blocks() { }

    @PythonFieldGenerated
    public static final String AIR = func("minecraft:air");
    @PythonFieldGenerated
    public static final String STONE = func("minecraft:stone");
    @PythonFieldGenerated
    public static final String GRASS = func("minecraft:grass");
    @PythonFieldGenerated
    public static final String DIRT = func("minecraft:dirt");
    @PythonFieldGenerated
    public static final String COBBLESTONE = func("minecraft:cobblestone");
    @PythonFieldGenerated
    public static final String PLANKS = func("minecraft:planks");
    @PythonFieldGenerated
    public static final String SAPLING = func("minecraft:sapling");
    @PythonFieldGenerated
    public static final String BEDROCK = func("minecraft:bedrock");
    @PythonFieldGenerated
    public static final String FLOWING_WATER = func("minecraft:flowing_water");
    @PythonFieldGenerated
    public static final String WATER = func("minecraft:water");
    @PythonFieldGenerated
    public static final String FLOWING_LAVA = func("minecraft:flowing_lava");
    @PythonFieldGenerated
    public static final String LAVA = func("minecraft:lava");
    @PythonFieldGenerated
    public static final String SAND = func("minecraft:sand");
    @PythonFieldGenerated
    public static final String GRAVEL = func("minecraft:gravel");
    @PythonFieldGenerated
    public static final String GOLD_ORE = func("minecraft:gold_ore");
    @PythonFieldGenerated
    public static final String IRON_ORE = func("minecraft:iron_ore");
    @PythonFieldGenerated
    public static final String COAL_ORE = func("minecraft:coal_ore");
    @PythonFieldGenerated
    public static final String LOG = func("minecraft:log");
    @PythonFieldGenerated
    public static final String LEAVES = func("minecraft:leaves");
    @PythonFieldGenerated
    public static final String SPONGE = func("minecraft:sponge");
    @PythonFieldGenerated
    public static final String GLASS = func("minecraft:glass");
    @PythonFieldGenerated
    public static final String LAPIS_ORE = func("minecraft:lapis_ore");
    @PythonFieldGenerated
    public static final String LAPIS_BLOCK = func("minecraft:lapis_block");
    @PythonFieldGenerated
    public static final String DISPENSER = func("minecraft:dispenser");
    @PythonFieldGenerated
    public static final String SANDSTONE = func("minecraft:sandstone");
    @PythonFieldGenerated
    public static final String NOTEBLOCK = func("minecraft:noteblock");
    @PythonFieldGenerated
    public static final String BED = func("minecraft:bed");
    @PythonFieldGenerated
    public static final String GOLDEN_RAIL = func("minecraft:golden_rail");
    @PythonFieldGenerated
    public static final String DETECTOR_RAIL = func("minecraft:detector_rail");
    @PythonFieldGenerated
    public static final String STICKY_PISTON = func("minecraft:sticky_piston");
    @PythonFieldGenerated
    public static final String WEB = func("minecraft:web");
    @PythonFieldGenerated
    public static final String TALLGRASS = func("minecraft:tallgrass");
    @PythonFieldGenerated
    public static final String DEADBUSH = func("minecraft:deadbush");
    @PythonFieldGenerated
    public static final String PISTON = func("minecraft:piston");
    @PythonFieldGenerated
    public static final String PISTON_HEAD = func("minecraft:piston_head");
    @PythonFieldGenerated
    public static final String WOOL = func("minecraft:wool");
    @PythonFieldGenerated
    public static final String PISTON_EXTENSION = func("minecraft:piston_extension");
    @PythonFieldGenerated
    public static final String YELLOW_FLOWER = func("minecraft:yellow_flower");
    @PythonFieldGenerated
    public static final String RED_FLOWER = func("minecraft:red_flower");
    @PythonFieldGenerated
    public static final String BROWN_MUSHROOM = func("minecraft:brown_mushroom");
    @PythonFieldGenerated
    public static final String RED_MUSHROOM = func("minecraft:red_mushroom");
    @PythonFieldGenerated
    public static final String GOLD_BLOCK = func("minecraft:gold_block");
    @PythonFieldGenerated
    public static final String IRON_BLOCK = func("minecraft:iron_block");
    @PythonFieldGenerated
    public static final String DOUBLE_STONE_SLAB = func("minecraft:double_stone_slab");
    @PythonFieldGenerated
    public static final String STONE_SLAB = func("minecraft:stone_slab");
    @PythonFieldGenerated
    public static final String BRICK_BLOCK = func("minecraft:brick_block");
    @PythonFieldGenerated
    public static final String TNT = func("minecraft:tnt");
    @PythonFieldGenerated
    public static final String BOOKSHELF = func("minecraft:bookshelf");
    @PythonFieldGenerated
    public static final String MOSSY_COBBLESTONE = func("minecraft:mossy_cobblestone");
    @PythonFieldGenerated
    public static final String OBSIDIAN = func("minecraft:obsidian");
    @PythonFieldGenerated
    public static final String TORCH = func("minecraft:torch");
    @PythonFieldGenerated
    public static final String FIRE = func("minecraft:fire");
    @PythonFieldGenerated
    public static final String MOB_SPAWNER = func("minecraft:mob_spawner");
    @PythonFieldGenerated
    public static final String OAK_STAIRS = func("minecraft:oak_stairs");
    @PythonFieldGenerated
    public static final String CHEST = func("minecraft:chest");
    @PythonFieldGenerated
    public static final String REDSTONE_WIRE = func("minecraft:redstone_wire");
    @PythonFieldGenerated
    public static final String DIAMOND_ORE = func("minecraft:diamond_ore");
    @PythonFieldGenerated
    public static final String DIAMOND_BLOCK = func("minecraft:diamond_block");
    @PythonFieldGenerated
    public static final String CRAFTING_TABLE = func("minecraft:crafting_table");
    @PythonFieldGenerated
    public static final String WHEAT = func("minecraft:wheat");
    @PythonFieldGenerated
    public static final String FARMLAND = func("minecraft:farmland");
    @PythonFieldGenerated
    public static final String FURNACE = func("minecraft:furnace");
    @PythonFieldGenerated
    public static final String LIT_FURNACE = func("minecraft:lit_furnace");
    @PythonFieldGenerated
    public static final String STANDING_SIGN = func("minecraft:standing_sign");
    @PythonFieldGenerated
    public static final String WOODEN_DOOR = func("minecraft:wooden_door");
    @PythonFieldGenerated
    public static final String LADDER = func("minecraft:ladder");
    @PythonFieldGenerated
    public static final String RAIL = func("minecraft:rail");
    @PythonFieldGenerated
    public static final String STONE_STAIRS = func("minecraft:stone_stairs");
    @PythonFieldGenerated
    public static final String WALL_SIGN = func("minecraft:wall_sign");
    @PythonFieldGenerated
    public static final String LEVER = func("minecraft:lever");
    @PythonFieldGenerated
    public static final String STONE_PRESSURE_PLATE = func("minecraft:stone_pressure_plate");
    @PythonFieldGenerated
    public static final String IRON_DOOR = func("minecraft:iron_door");
    @PythonFieldGenerated
    public static final String WOODEN_PRESSURE_PLATE = func("minecraft:wooden_pressure_plate");
    @PythonFieldGenerated
    public static final String REDSTONE_ORE = func("minecraft:redstone_ore");
    @PythonFieldGenerated
    public static final String LIT_REDSTONE_ORE = func("minecraft:lit_redstone_ore");
    @PythonFieldGenerated
    public static final String UNLIT_REDSTONE_TORCH = func("minecraft:unlit_redstone_torch");
    @PythonFieldGenerated
    public static final String REDSTONE_TORCH = func("minecraft:redstone_torch");
    @PythonFieldGenerated
    public static final String STONE_BUTTON = func("minecraft:stone_button");
    @PythonFieldGenerated
    public static final String SNOW_LAYER = func("minecraft:snow_layer");
    @PythonFieldGenerated
    public static final String ICE = func("minecraft:ice");
    @PythonFieldGenerated
    public static final String SNOW = func("minecraft:snow");
    @PythonFieldGenerated
    public static final String CACTUS = func("minecraft:cactus");
    @PythonFieldGenerated
    public static final String CLAY = func("minecraft:clay");
    @PythonFieldGenerated
    public static final String REEDS = func("minecraft:reeds");
    @PythonFieldGenerated
    public static final String JUKEBOX = func("minecraft:jukebox");
    @PythonFieldGenerated
    public static final String FENCE = func("minecraft:fence");
    @PythonFieldGenerated
    public static final String PUMPKIN = func("minecraft:pumpkin");
    @PythonFieldGenerated
    public static final String NETHERRACK = func("minecraft:netherrack");
    @PythonFieldGenerated
    public static final String SOUL_SAND = func("minecraft:soul_sand");
    @PythonFieldGenerated
    public static final String GLOWSTONE = func("minecraft:glowstone");
    @PythonFieldGenerated
    public static final String PORTAL = func("minecraft:portal");
    @PythonFieldGenerated
    public static final String LIT_PUMPKIN = func("minecraft:lit_pumpkin");
    @PythonFieldGenerated
    public static final String CAKE = func("minecraft:cake");
    @PythonFieldGenerated
    public static final String UNPOWERED_REPEATER = func("minecraft:unpowered_repeater");
    @PythonFieldGenerated
    public static final String POWERED_REPEATER = func("minecraft:powered_repeater");
    @PythonFieldGenerated
    public static final String STAINED_GLASS = func("minecraft:stained_glass");
    @PythonFieldGenerated
    public static final String TRAPDOOR = func("minecraft:trapdoor");
    @PythonFieldGenerated
    public static final String MONSTER_EGG = func("minecraft:monster_egg");
    @PythonFieldGenerated
    public static final String STONEBRICK = func("minecraft:stonebrick");
    @PythonFieldGenerated
    public static final String BROWN_MUSHROOM_BLOCK = func("minecraft:brown_mushroom_block");
    @PythonFieldGenerated
    public static final String RED_MUSHROOM_BLOCK = func("minecraft:red_mushroom_block");
    @PythonFieldGenerated
    public static final String IRON_BARS = func("minecraft:iron_bars");
    @PythonFieldGenerated
    public static final String GLASS_PANE = func("minecraft:glass_pane");
    @PythonFieldGenerated
    public static final String MELON_BLOCK = func("minecraft:melon_block");
    @PythonFieldGenerated
    public static final String PUMPKIN_STEM = func("minecraft:pumpkin_stem");
    @PythonFieldGenerated
    public static final String MELON_STEM = func("minecraft:melon_stem");
    @PythonFieldGenerated
    public static final String VINE = func("minecraft:vine");
    @PythonFieldGenerated
    public static final String FENCE_GATE = func("minecraft:fence_gate");
    @PythonFieldGenerated
    public static final String BRICK_STAIRS = func("minecraft:brick_stairs");
    @PythonFieldGenerated
    public static final String STONE_BRICK_STAIRS = func("minecraft:stone_brick_stairs");
    @PythonFieldGenerated
    public static final String MYCELIUM = func("minecraft:mycelium");
    @PythonFieldGenerated
    public static final String WATERLILY = func("minecraft:waterlily");
    @PythonFieldGenerated
    public static final String NETHER_BRICK = func("minecraft:nether_brick");
    @PythonFieldGenerated
    public static final String NETHER_BRICK_FENCE = func("minecraft:nether_brick_fence");
    @PythonFieldGenerated
    public static final String NETHER_BRICK_STAIRS = func("minecraft:nether_brick_stairs");
    @PythonFieldGenerated
    public static final String NETHER_WART = func("minecraft:nether_wart");
    @PythonFieldGenerated
    public static final String ENCHANTING_TABLE = func("minecraft:enchanting_table");
    @PythonFieldGenerated
    public static final String BREWING_STAND = func("minecraft:brewing_stand");
    @PythonFieldGenerated
    public static final String CAULDRON = func("minecraft:cauldron");
    @PythonFieldGenerated
    public static final String END_PORTAL = func("minecraft:end_portal");
    @PythonFieldGenerated
    public static final String END_PORTAL_FRAME = func("minecraft:end_portal_frame");
    @PythonFieldGenerated
    public static final String END_STONE = func("minecraft:end_stone");
    @PythonFieldGenerated
    public static final String DRAGON_EGG = func("minecraft:dragon_egg");
    @PythonFieldGenerated
    public static final String REDSTONE_LAMP = func("minecraft:redstone_lamp");
    @PythonFieldGenerated
    public static final String LIT_REDSTONE_LAMP = func("minecraft:lit_redstone_lamp");
    @PythonFieldGenerated
    public static final String DOUBLE_WOODEN_SLAB = func("minecraft:double_wooden_slab");
    @PythonFieldGenerated
    public static final String WOODEN_SLAB = func("minecraft:wooden_slab");
    @PythonFieldGenerated
    public static final String COCOA = func("minecraft:cocoa");
    @PythonFieldGenerated
    public static final String SANDSTONE_STAIRS = func("minecraft:sandstone_stairs");
    @PythonFieldGenerated
    public static final String EMERALD_ORE = func("minecraft:emerald_ore");
    @PythonFieldGenerated
    public static final String ENDER_CHEST = func("minecraft:ender_chest");
    @PythonFieldGenerated
    public static final String TRIPWIRE_HOOK = func("minecraft:tripwire_hook");
    @PythonFieldGenerated
    public static final String TRIPWIRE = func("minecraft:tripwire");
    @PythonFieldGenerated
    public static final String EMERALD_BLOCK = func("minecraft:emerald_block");
    @PythonFieldGenerated
    public static final String SPRUCE_STAIRS = func("minecraft:spruce_stairs");
    @PythonFieldGenerated
    public static final String BIRCH_STAIRS = func("minecraft:birch_stairs");
    @PythonFieldGenerated
    public static final String JUNGLE_STAIRS = func("minecraft:jungle_stairs");
    @PythonFieldGenerated
    public static final String COMMAND_BLOCK = func("minecraft:command_block");
    @PythonFieldGenerated
    public static final String BEACON = func("minecraft:beacon");
    @PythonFieldGenerated
    public static final String COBBLESTONE_WALL = func("minecraft:cobblestone_wall");
    @PythonFieldGenerated
    public static final String FLOWER_POT = func("minecraft:flower_pot");
    @PythonFieldGenerated
    public static final String CARROTS = func("minecraft:carrots");
    @PythonFieldGenerated
    public static final String POTATOES = func("minecraft:potatoes");
    @PythonFieldGenerated
    public static final String WOODEN_BUTTON = func("minecraft:wooden_button");
    @PythonFieldGenerated
    public static final String SKULL = func("minecraft:skull");
    @PythonFieldGenerated
    public static final String ANVIL = func("minecraft:anvil");
    @PythonFieldGenerated
    public static final String TRAPPED_CHEST = func("minecraft:trapped_chest");
    @PythonFieldGenerated
    public static final String LIGHT_WEIGHTED_PRESSURE_PLATE = func("minecraft:light_weighted_pressure_plate");
    @PythonFieldGenerated
    public static final String HEAVY_WEIGHTED_PRESSURE_PLATE = func("minecraft:heavy_weighted_pressure_plate");
    @PythonFieldGenerated
    public static final String UNPOWERED_COMPARATOR = func("minecraft:unpowered_comparator");
    @PythonFieldGenerated
    public static final String POWERED_COMPARATOR = func("minecraft:powered_comparator");
    @PythonFieldGenerated
    public static final String DAYLIGHT_DETECTOR = func("minecraft:daylight_detector");
    @PythonFieldGenerated
    public static final String REDSTONE_BLOCK = func("minecraft:redstone_block");
    @PythonFieldGenerated
    public static final String QUARTZ_ORE = func("minecraft:quartz_ore");
    @PythonFieldGenerated
    public static final String HOPPER = func("minecraft:hopper");
    @PythonFieldGenerated
    public static final String QUARTZ_BLOCK = func("minecraft:quartz_block");
    @PythonFieldGenerated
    public static final String QUARTZ_STAIRS = func("minecraft:quartz_stairs");
    @PythonFieldGenerated
    public static final String ACTIVATOR_RAIL = func("minecraft:activator_rail");
    @PythonFieldGenerated
    public static final String DROPPER = func("minecraft:dropper");
    @PythonFieldGenerated
    public static final String STAINED_HARDENED_CLAY = func("minecraft:stained_hardened_clay");
    @PythonFieldGenerated
    public static final String STAINED_GLASS_PANE = func("minecraft:stained_glass_pane");
    @PythonFieldGenerated
    public static final String LEAVES2 = func("minecraft:leaves2");
    @PythonFieldGenerated
    public static final String LOG2 = func("minecraft:log2");
    @PythonFieldGenerated
    public static final String ACACIA_STAIRS = func("minecraft:acacia_stairs");
    @PythonFieldGenerated
    public static final String DARK_OAK_STAIRS = func("minecraft:dark_oak_stairs");
    @PythonFieldGenerated
    public static final String SLIME = func("minecraft:slime");
    @PythonFieldGenerated
    public static final String BARRIER = func("minecraft:barrier");
    @PythonFieldGenerated
    public static final String IRON_TRAPDOOR = func("minecraft:iron_trapdoor");
    @PythonFieldGenerated
    public static final String PRISMARINE = func("minecraft:prismarine");
    @PythonFieldGenerated
    public static final String SEA_LANTERN = func("minecraft:sea_lantern");
    @PythonFieldGenerated
    public static final String HAY_BLOCK = func("minecraft:hay_block");
    @PythonFieldGenerated
    public static final String CARPET = func("minecraft:carpet");
    @PythonFieldGenerated
    public static final String HARDENED_CLAY = func("minecraft:hardened_clay");
    @PythonFieldGenerated
    public static final String COAL_BLOCK = func("minecraft:coal_block");
    @PythonFieldGenerated
    public static final String PACKED_ICE = func("minecraft:packed_ice");
    @PythonFieldGenerated
    public static final String DOUBLE_PLANT = func("minecraft:double_plant");
    @PythonFieldGenerated
    public static final String STANDING_BANNER = func("minecraft:standing_banner");
    @PythonFieldGenerated
    public static final String WALL_BANNER = func("minecraft:wall_banner");
    @PythonFieldGenerated
    public static final String DAYLIGHT_DETECTOR_INVERTED = func("minecraft:daylight_detector_inverted");
    @PythonFieldGenerated
    public static final String RED_SANDSTONE = func("minecraft:red_sandstone");
    @PythonFieldGenerated
    public static final String RED_SANDSTONE_STAIRS = func("minecraft:red_sandstone_stairs");
    @PythonFieldGenerated
    public static final String DOUBLE_STONE_SLAB2 = func("minecraft:double_stone_slab2");
    @PythonFieldGenerated
    public static final String STONE_SLAB2 = func("minecraft:stone_slab2");
    @PythonFieldGenerated
    public static final String SPRUCE_FENCE_GATE = func("minecraft:spruce_fence_gate");
    @PythonFieldGenerated
    public static final String BIRCH_FENCE_GATE = func("minecraft:birch_fence_gate");
    @PythonFieldGenerated
    public static final String JUNGLE_FENCE_GATE = func("minecraft:jungle_fence_gate");
    @PythonFieldGenerated
    public static final String DARK_OAK_FENCE_GATE = func("minecraft:dark_oak_fence_gate");
    @PythonFieldGenerated
    public static final String ACACIA_FENCE_GATE = func("minecraft:acacia_fence_gate");
    @PythonFieldGenerated
    public static final String SPRUCE_FENCE = func("minecraft:spruce_fence");
    @PythonFieldGenerated
    public static final String BIRCH_FENCE = func("minecraft:birch_fence");
    @PythonFieldGenerated
    public static final String JUNGLE_FENCE = func("minecraft:jungle_fence");
    @PythonFieldGenerated
    public static final String DARK_OAK_FENCE = func("minecraft:dark_oak_fence");
    @PythonFieldGenerated
    public static final String ACACIA_FENCE = func("minecraft:acacia_fence");
    @PythonFieldGenerated
    public static final String SPRUCE_DOOR = func("minecraft:spruce_door");
    @PythonFieldGenerated
    public static final String BIRCH_DOOR = func("minecraft:birch_door");
    @PythonFieldGenerated
    public static final String JUNGLE_DOOR = func("minecraft:jungle_door");
    @PythonFieldGenerated
    public static final String ACACIA_DOOR = func("minecraft:acacia_door");
    @PythonFieldGenerated
    public static final String DARK_OAK_DOOR = func("minecraft:dark_oak_door");
    @PythonFieldGenerated
    public static final String END_ROD = func("minecraft:end_rod");
    @PythonFieldGenerated
    public static final String CHORUS_PLANT = func("minecraft:chorus_plant");
    @PythonFieldGenerated
    public static final String CHORUS_FLOWER = func("minecraft:chorus_flower");
    @PythonFieldGenerated
    public static final String PURPUR_BLOCK = func("minecraft:purpur_block");
    @PythonFieldGenerated
    public static final String PURPUR_PILLAR = func("minecraft:purpur_pillar");
    @PythonFieldGenerated
    public static final String PURPUR_STAIRS = func("minecraft:purpur_stairs");
    @PythonFieldGenerated
    public static final String PURPUR_DOUBLE_SLAB = func("minecraft:purpur_double_slab");
    @PythonFieldGenerated
    public static final String PURPUR_SLAB = func("minecraft:purpur_slab");
    @PythonFieldGenerated
    public static final String END_BRICKS = func("minecraft:end_bricks");
    @PythonFieldGenerated
    public static final String BEETROOTS = func("minecraft:beetroots");
    @PythonFieldGenerated
    public static final String GRASS_PATH = func("minecraft:grass_path");
    @PythonFieldGenerated
    public static final String END_GATEWAY = func("minecraft:end_gateway");
    @PythonFieldGenerated
    public static final String REPEATING_COMMAND_BLOCK = func("minecraft:repeating_command_block");
    @PythonFieldGenerated
    public static final String CHAIN_COMMAND_BLOCK = func("minecraft:chain_command_block");
    @PythonFieldGenerated
    public static final String FROSTED_ICE = func("minecraft:frosted_ice");
    @PythonFieldGenerated
    public static final String MAGMA = func("minecraft:magma");
    @PythonFieldGenerated
    public static final String NETHER_WART_BLOCK = func("minecraft:nether_wart_block");
    @PythonFieldGenerated
    public static final String RED_NETHER_BRICK = func("minecraft:red_nether_brick");
    @PythonFieldGenerated
    public static final String BONE_BLOCK = func("minecraft:bone_block");
    @PythonFieldGenerated
    public static final String STRUCTURE_VOID = func("minecraft:structure_void");
    @PythonFieldGenerated
    public static final String OBSERVER = func("minecraft:observer");
    @PythonFieldGenerated
    public static final String WHITE_SHULKER_BOX = func("minecraft:white_shulker_box");
    @PythonFieldGenerated
    public static final String ORANGE_SHULKER_BOX = func("minecraft:orange_shulker_box");
    @PythonFieldGenerated
    public static final String MAGENTA_SHULKER_BOX = func("minecraft:magenta_shulker_box");
    @PythonFieldGenerated
    public static final String LIGHT_BLUE_SHULKER_BOX = func("minecraft:light_blue_shulker_box");
    @PythonFieldGenerated
    public static final String YELLOW_SHULKER_BOX = func("minecraft:yellow_shulker_box");
    @PythonFieldGenerated
    public static final String LIME_SHULKER_BOX = func("minecraft:lime_shulker_box");
    @PythonFieldGenerated
    public static final String PINK_SHULKER_BOX = func("minecraft:pink_shulker_box");
    @PythonFieldGenerated
    public static final String GRAY_SHULKER_BOX = func("minecraft:gray_shulker_box");
    @PythonFieldGenerated
    public static final String SILVER_SHULKER_BOX = func("minecraft:silver_shulker_box");
    @PythonFieldGenerated
    public static final String CYAN_SHULKER_BOX = func("minecraft:cyan_shulker_box");
    @PythonFieldGenerated
    public static final String PURPLE_SHULKER_BOX = func("minecraft:purple_shulker_box");
    @PythonFieldGenerated
    public static final String BLUE_SHULKER_BOX = func("minecraft:blue_shulker_box");
    @PythonFieldGenerated
    public static final String BROWN_SHULKER_BOX = func("minecraft:brown_shulker_box");
    @PythonFieldGenerated
    public static final String GREEN_SHULKER_BOX = func("minecraft:green_shulker_box");
    @PythonFieldGenerated
    public static final String RED_SHULKER_BOX = func("minecraft:red_shulker_box");
    @PythonFieldGenerated
    public static final String BLACK_SHULKER_BOX = func("minecraft:black_shulker_box");
    @PythonFieldGenerated
    public static final String WHITE_GLAZED_TERRACOTTA = func("minecraft:white_glazed_terracotta");
    @PythonFieldGenerated
    public static final String ORANGE_GLAZED_TERRACOTTA = func("minecraft:orange_glazed_terracotta");
    @PythonFieldGenerated
    public static final String MAGENTA_GLAZED_TERRACOTTA = func("minecraft:magenta_glazed_terracotta");
    @PythonFieldGenerated
    public static final String LIGHT_BLUE_GLAZED_TERRACOTTA = func("minecraft:light_blue_glazed_terracotta");
    @PythonFieldGenerated
    public static final String YELLOW_GLAZED_TERRACOTTA = func("minecraft:yellow_glazed_terracotta");
    @PythonFieldGenerated
    public static final String LIME_GLAZED_TERRACOTTA = func("minecraft:lime_glazed_terracotta");
    @PythonFieldGenerated
    public static final String PINK_GLAZED_TERRACOTTA = func("minecraft:pink_glazed_terracotta");
    @PythonFieldGenerated
    public static final String GRAY_GLAZED_TERRACOTTA = func("minecraft:gray_glazed_terracotta");
    @PythonFieldGenerated
    public static final String SILVER_GLAZED_TERRACOTTA = func("minecraft:silver_glazed_terracotta");
    @PythonFieldGenerated
    public static final String CYAN_GLAZED_TERRACOTTA = func("minecraft:cyan_glazed_terracotta");
    @PythonFieldGenerated
    public static final String PURPLE_GLAZED_TERRACOTTA = func("minecraft:purple_glazed_terracotta");
    @PythonFieldGenerated
    public static final String BLUE_GLAZED_TERRACOTTA = func("minecraft:blue_glazed_terracotta");
    @PythonFieldGenerated
    public static final String BROWN_GLAZED_TERRACOTTA = func("minecraft:brown_glazed_terracotta");
    @PythonFieldGenerated
    public static final String GREEN_GLAZED_TERRACOTTA = func("minecraft:green_glazed_terracotta");
    @PythonFieldGenerated
    public static final String RED_GLAZED_TERRACOTTA = func("minecraft:red_glazed_terracotta");
    @PythonFieldGenerated
    public static final String BLACK_GLAZED_TERRACOTTA = func("minecraft:black_glazed_terracotta");
    @PythonFieldGenerated
    public static final String CONCRETE = func("minecraft:concrete");
    @PythonFieldGenerated
    public static final String CONCRETE_POWDER = func("minecraft:concrete_powder");
    @PythonFieldGenerated
    public static final String STRUCTURE_BLOCK = func("minecraft:structure_block");

    @PythonFunction
    @PythonDocString("Returns a list of all the vanilla Blocks.")
    public static PyList getAllBlocks() {
        return names;
    }

    private static String func(String s) {
        names.add(new PyString(s));
        return s;
    }
}