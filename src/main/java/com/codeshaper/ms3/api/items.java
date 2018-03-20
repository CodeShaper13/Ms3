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

    @PythonField("minecraft:air")
    public static final String AIR = func("minecraft:air");
    @PythonField("minecraft:stone")
    public static final String STONE = func("minecraft:stone");
    @PythonField("minecraft:grass")
    public static final String GRASS = func("minecraft:grass");
    @PythonField("minecraft:dirt")
    public static final String DIRT = func("minecraft:dirt");
    @PythonField("minecraft:cobblestone")
    public static final String COBBLESTONE = func("minecraft:cobblestone");
    @PythonField("minecraft:planks")
    public static final String PLANKS = func("minecraft:planks");
    @PythonField("minecraft:sapling")
    public static final String SAPLING = func("minecraft:sapling");
    @PythonField("minecraft:bedrock")
    public static final String BEDROCK = func("minecraft:bedrock");
    @PythonField("minecraft:sand")
    public static final String SAND = func("minecraft:sand");
    @PythonField("minecraft:gravel")
    public static final String GRAVEL = func("minecraft:gravel");
    @PythonField("minecraft:gold_ore")
    public static final String GOLD_ORE = func("minecraft:gold_ore");
    @PythonField("minecraft:iron_ore")
    public static final String IRON_ORE = func("minecraft:iron_ore");
    @PythonField("minecraft:coal_ore")
    public static final String COAL_ORE = func("minecraft:coal_ore");
    @PythonField("minecraft:log")
    public static final String LOG = func("minecraft:log");
    @PythonField("minecraft:log2")
    public static final String LOG2 = func("minecraft:log2");
    @PythonField("minecraft:leaves")
    public static final String LEAVES = func("minecraft:leaves");
    @PythonField("minecraft:leaves2")
    public static final String LEAVES2 = func("minecraft:leaves2");
    @PythonField("minecraft:sponge")
    public static final String SPONGE = func("minecraft:sponge");
    @PythonField("minecraft:glass")
    public static final String GLASS = func("minecraft:glass");
    @PythonField("minecraft:lapis_ore")
    public static final String LAPIS_ORE = func("minecraft:lapis_ore");
    @PythonField("minecraft:lapis_block")
    public static final String LAPIS_BLOCK = func("minecraft:lapis_block");
    @PythonField("minecraft:dispenser")
    public static final String DISPENSER = func("minecraft:dispenser");
    @PythonField("minecraft:sandstone")
    public static final String SANDSTONE = func("minecraft:sandstone");
    @PythonField("minecraft:noteblock")
    public static final String NOTEBLOCK = func("minecraft:noteblock");
    @PythonField("minecraft:golden_rail")
    public static final String GOLDEN_RAIL = func("minecraft:golden_rail");
    @PythonField("minecraft:detector_rail")
    public static final String DETECTOR_RAIL = func("minecraft:detector_rail");
    @PythonField("minecraft:sticky_piston")
    public static final String STICKY_PISTON = func("minecraft:sticky_piston");
    @PythonField("minecraft:web")
    public static final String WEB = func("minecraft:web");
    @PythonField("minecraft:tallgrass")
    public static final String TALLGRASS = func("minecraft:tallgrass");
    @PythonField("minecraft:deadbush")
    public static final String DEADBUSH = func("minecraft:deadbush");
    @PythonField("minecraft:piston")
    public static final String PISTON = func("minecraft:piston");
    @PythonField("minecraft:wool")
    public static final String WOOL = func("minecraft:wool");
    @PythonField("minecraft:yellow_flower")
    public static final String YELLOW_FLOWER = func("minecraft:yellow_flower");
    @PythonField("minecraft:red_flower")
    public static final String RED_FLOWER = func("minecraft:red_flower");
    @PythonField("minecraft:brown_mushroom")
    public static final String BROWN_MUSHROOM = func("minecraft:brown_mushroom");
    @PythonField("minecraft:red_mushroom")
    public static final String RED_MUSHROOM = func("minecraft:red_mushroom");
    @PythonField("minecraft:gold_block")
    public static final String GOLD_BLOCK = func("minecraft:gold_block");
    @PythonField("minecraft:iron_block")
    public static final String IRON_BLOCK = func("minecraft:iron_block");
    @PythonField("minecraft:stone_slab")
    public static final String STONE_SLAB = func("minecraft:stone_slab");
    @PythonField("minecraft:brick_block")
    public static final String BRICK_BLOCK = func("minecraft:brick_block");
    @PythonField("minecraft:tnt")
    public static final String TNT = func("minecraft:tnt");
    @PythonField("minecraft:bookshelf")
    public static final String BOOKSHELF = func("minecraft:bookshelf");
    @PythonField("minecraft:mossy_cobblestone")
    public static final String MOSSY_COBBLESTONE = func("minecraft:mossy_cobblestone");
    @PythonField("minecraft:obsidian")
    public static final String OBSIDIAN = func("minecraft:obsidian");
    @PythonField("minecraft:torch")
    public static final String TORCH = func("minecraft:torch");
    @PythonField("minecraft:end_rod")
    public static final String END_ROD = func("minecraft:end_rod");
    @PythonField("minecraft:chorus_plant")
    public static final String CHORUS_PLANT = func("minecraft:chorus_plant");
    @PythonField("minecraft:chorus_flower")
    public static final String CHORUS_FLOWER = func("minecraft:chorus_flower");
    @PythonField("minecraft:purpur_block")
    public static final String PURPUR_BLOCK = func("minecraft:purpur_block");
    @PythonField("minecraft:purpur_pillar")
    public static final String PURPUR_PILLAR = func("minecraft:purpur_pillar");
    @PythonField("minecraft:purpur_stairs")
    public static final String PURPUR_STAIRS = func("minecraft:purpur_stairs");
    @PythonField("minecraft:purpur_slab")
    public static final String PURPUR_SLAB = func("minecraft:purpur_slab");
    @PythonField("minecraft:mob_spawner")
    public static final String MOB_SPAWNER = func("minecraft:mob_spawner");
    @PythonField("minecraft:oak_stairs")
    public static final String OAK_STAIRS = func("minecraft:oak_stairs");
    @PythonField("minecraft:chest")
    public static final String CHEST = func("minecraft:chest");
    @PythonField("minecraft:diamond_ore")
    public static final String DIAMOND_ORE = func("minecraft:diamond_ore");
    @PythonField("minecraft:diamond_block")
    public static final String DIAMOND_BLOCK = func("minecraft:diamond_block");
    @PythonField("minecraft:crafting_table")
    public static final String CRAFTING_TABLE = func("minecraft:crafting_table");
    @PythonField("minecraft:farmland")
    public static final String FARMLAND = func("minecraft:farmland");
    @PythonField("minecraft:furnace")
    public static final String FURNACE = func("minecraft:furnace");
    @PythonField("minecraft:ladder")
    public static final String LADDER = func("minecraft:ladder");
    @PythonField("minecraft:rail")
    public static final String RAIL = func("minecraft:rail");
    @PythonField("minecraft:stone_stairs")
    public static final String STONE_STAIRS = func("minecraft:stone_stairs");
    @PythonField("minecraft:lever")
    public static final String LEVER = func("minecraft:lever");
    @PythonField("minecraft:stone_pressure_plate")
    public static final String STONE_PRESSURE_PLATE = func("minecraft:stone_pressure_plate");
    @PythonField("minecraft:wooden_pressure_plate")
    public static final String WOODEN_PRESSURE_PLATE = func("minecraft:wooden_pressure_plate");
    @PythonField("minecraft:redstone_ore")
    public static final String REDSTONE_ORE = func("minecraft:redstone_ore");
    @PythonField("minecraft:redstone_torch")
    public static final String REDSTONE_TORCH = func("minecraft:redstone_torch");
    @PythonField("minecraft:stone_button")
    public static final String STONE_BUTTON = func("minecraft:stone_button");
    @PythonField("minecraft:snow_layer")
    public static final String SNOW_LAYER = func("minecraft:snow_layer");
    @PythonField("minecraft:ice")
    public static final String ICE = func("minecraft:ice");
    @PythonField("minecraft:snow")
    public static final String SNOW = func("minecraft:snow");
    @PythonField("minecraft:cactus")
    public static final String CACTUS = func("minecraft:cactus");
    @PythonField("minecraft:clay")
    public static final String CLAY = func("minecraft:clay");
    @PythonField("minecraft:jukebox")
    public static final String JUKEBOX = func("minecraft:jukebox");
    @PythonField("minecraft:fence")
    public static final String FENCE = func("minecraft:fence");
    @PythonField("minecraft:spruce_fence")
    public static final String SPRUCE_FENCE = func("minecraft:spruce_fence");
    @PythonField("minecraft:birch_fence")
    public static final String BIRCH_FENCE = func("minecraft:birch_fence");
    @PythonField("minecraft:jungle_fence")
    public static final String JUNGLE_FENCE = func("minecraft:jungle_fence");
    @PythonField("minecraft:dark_oak_fence")
    public static final String DARK_OAK_FENCE = func("minecraft:dark_oak_fence");
    @PythonField("minecraft:acacia_fence")
    public static final String ACACIA_FENCE = func("minecraft:acacia_fence");
    @PythonField("minecraft:pumpkin")
    public static final String PUMPKIN = func("minecraft:pumpkin");
    @PythonField("minecraft:netherrack")
    public static final String NETHERRACK = func("minecraft:netherrack");
    @PythonField("minecraft:soul_sand")
    public static final String SOUL_SAND = func("minecraft:soul_sand");
    @PythonField("minecraft:glowstone")
    public static final String GLOWSTONE = func("minecraft:glowstone");
    @PythonField("minecraft:lit_pumpkin")
    public static final String LIT_PUMPKIN = func("minecraft:lit_pumpkin");
    @PythonField("minecraft:trapdoor")
    public static final String TRAPDOOR = func("minecraft:trapdoor");
    @PythonField("minecraft:monster_egg")
    public static final String MONSTER_EGG = func("minecraft:monster_egg");
    @PythonField("minecraft:stonebrick")
    public static final String STONEBRICK = func("minecraft:stonebrick");
    @PythonField("minecraft:brown_mushroom_block")
    public static final String BROWN_MUSHROOM_BLOCK = func("minecraft:brown_mushroom_block");
    @PythonField("minecraft:red_mushroom_block")
    public static final String RED_MUSHROOM_BLOCK = func("minecraft:red_mushroom_block");
    @PythonField("minecraft:iron_bars")
    public static final String IRON_BARS = func("minecraft:iron_bars");
    @PythonField("minecraft:glass_pane")
    public static final String GLASS_PANE = func("minecraft:glass_pane");
    @PythonField("minecraft:melon_block")
    public static final String MELON_BLOCK = func("minecraft:melon_block");
    @PythonField("minecraft:vine")
    public static final String VINE = func("minecraft:vine");
    @PythonField("minecraft:fence_gate")
    public static final String FENCE_GATE = func("minecraft:fence_gate");
    @PythonField("minecraft:spruce_fence_gate")
    public static final String SPRUCE_FENCE_GATE = func("minecraft:spruce_fence_gate");
    @PythonField("minecraft:birch_fence_gate")
    public static final String BIRCH_FENCE_GATE = func("minecraft:birch_fence_gate");
    @PythonField("minecraft:jungle_fence_gate")
    public static final String JUNGLE_FENCE_GATE = func("minecraft:jungle_fence_gate");
    @PythonField("minecraft:dark_oak_fence_gate")
    public static final String DARK_OAK_FENCE_GATE = func("minecraft:dark_oak_fence_gate");
    @PythonField("minecraft:acacia_fence_gate")
    public static final String ACACIA_FENCE_GATE = func("minecraft:acacia_fence_gate");
    @PythonField("minecraft:brick_stairs")
    public static final String BRICK_STAIRS = func("minecraft:brick_stairs");
    @PythonField("minecraft:stone_brick_stairs")
    public static final String STONE_BRICK_STAIRS = func("minecraft:stone_brick_stairs");
    @PythonField("minecraft:mycelium")
    public static final String MYCELIUM = func("minecraft:mycelium");
    @PythonField("minecraft:waterlily")
    public static final String WATERLILY = func("minecraft:waterlily");
    @PythonField("minecraft:nether_brick")
    public static final String NETHER_BRICK = func("minecraft:nether_brick");
    @PythonField("minecraft:nether_brick_fence")
    public static final String NETHER_BRICK_FENCE = func("minecraft:nether_brick_fence");
    @PythonField("minecraft:nether_brick_stairs")
    public static final String NETHER_BRICK_STAIRS = func("minecraft:nether_brick_stairs");
    @PythonField("minecraft:enchanting_table")
    public static final String ENCHANTING_TABLE = func("minecraft:enchanting_table");
    @PythonField("minecraft:end_portal_frame")
    public static final String END_PORTAL_FRAME = func("minecraft:end_portal_frame");
    @PythonField("minecraft:end_stone")
    public static final String END_STONE = func("minecraft:end_stone");
    @PythonField("minecraft:end_bricks")
    public static final String END_BRICKS = func("minecraft:end_bricks");
    @PythonField("minecraft:dragon_egg")
    public static final String DRAGON_EGG = func("minecraft:dragon_egg");
    @PythonField("minecraft:redstone_lamp")
    public static final String REDSTONE_LAMP = func("minecraft:redstone_lamp");
    @PythonField("minecraft:wooden_slab")
    public static final String WOODEN_SLAB = func("minecraft:wooden_slab");
    @PythonField("minecraft:sandstone_stairs")
    public static final String SANDSTONE_STAIRS = func("minecraft:sandstone_stairs");
    @PythonField("minecraft:emerald_ore")
    public static final String EMERALD_ORE = func("minecraft:emerald_ore");
    @PythonField("minecraft:ender_chest")
    public static final String ENDER_CHEST = func("minecraft:ender_chest");
    @PythonField("minecraft:tripwire_hook")
    public static final String TRIPWIRE_HOOK = func("minecraft:tripwire_hook");
    @PythonField("minecraft:emerald_block")
    public static final String EMERALD_BLOCK = func("minecraft:emerald_block");
    @PythonField("minecraft:spruce_stairs")
    public static final String SPRUCE_STAIRS = func("minecraft:spruce_stairs");
    @PythonField("minecraft:birch_stairs")
    public static final String BIRCH_STAIRS = func("minecraft:birch_stairs");
    @PythonField("minecraft:jungle_stairs")
    public static final String JUNGLE_STAIRS = func("minecraft:jungle_stairs");
    @PythonField("minecraft:command_block")
    public static final String COMMAND_BLOCK = func("minecraft:command_block");
    @PythonField("minecraft:beacon")
    public static final String BEACON = func("minecraft:beacon");
    @PythonField("minecraft:cobblestone_wall")
    public static final String COBBLESTONE_WALL = func("minecraft:cobblestone_wall");
    @PythonField("minecraft:wooden_button")
    public static final String WOODEN_BUTTON = func("minecraft:wooden_button");
    @PythonField("minecraft:anvil")
    public static final String ANVIL = func("minecraft:anvil");
    @PythonField("minecraft:trapped_chest")
    public static final String TRAPPED_CHEST = func("minecraft:trapped_chest");
    @PythonField("minecraft:light_weighted_pressure_plate")
    public static final String LIGHT_WEIGHTED_PRESSURE_PLATE = func("minecraft:light_weighted_pressure_plate");
    @PythonField("minecraft:heavy_weighted_pressure_plate")
    public static final String HEAVY_WEIGHTED_PRESSURE_PLATE = func("minecraft:heavy_weighted_pressure_plate");
    @PythonField("minecraft:daylight_detector")
    public static final String DAYLIGHT_DETECTOR = func("minecraft:daylight_detector");
    @PythonField("minecraft:redstone_block")
    public static final String REDSTONE_BLOCK = func("minecraft:redstone_block");
    @PythonField("minecraft:quartz_ore")
    public static final String QUARTZ_ORE = func("minecraft:quartz_ore");
    @PythonField("minecraft:hopper")
    public static final String HOPPER = func("minecraft:hopper");
    @PythonField("minecraft:quartz_block")
    public static final String QUARTZ_BLOCK = func("minecraft:quartz_block");
    @PythonField("minecraft:quartz_stairs")
    public static final String QUARTZ_STAIRS = func("minecraft:quartz_stairs");
    @PythonField("minecraft:activator_rail")
    public static final String ACTIVATOR_RAIL = func("minecraft:activator_rail");
    @PythonField("minecraft:dropper")
    public static final String DROPPER = func("minecraft:dropper");
    @PythonField("minecraft:stained_hardened_clay")
    public static final String STAINED_HARDENED_CLAY = func("minecraft:stained_hardened_clay");
    @PythonField("minecraft:barrier")
    public static final String BARRIER = func("minecraft:barrier");
    @PythonField("minecraft:iron_trapdoor")
    public static final String IRON_TRAPDOOR = func("minecraft:iron_trapdoor");
    @PythonField("minecraft:hay_block")
    public static final String HAY_BLOCK = func("minecraft:hay_block");
    @PythonField("minecraft:carpet")
    public static final String CARPET = func("minecraft:carpet");
    @PythonField("minecraft:hardened_clay")
    public static final String HARDENED_CLAY = func("minecraft:hardened_clay");
    @PythonField("minecraft:coal_block")
    public static final String COAL_BLOCK = func("minecraft:coal_block");
    @PythonField("minecraft:packed_ice")
    public static final String PACKED_ICE = func("minecraft:packed_ice");
    @PythonField("minecraft:acacia_stairs")
    public static final String ACACIA_STAIRS = func("minecraft:acacia_stairs");
    @PythonField("minecraft:dark_oak_stairs")
    public static final String DARK_OAK_STAIRS = func("minecraft:dark_oak_stairs");
    @PythonField("minecraft:slime")
    public static final String SLIME = func("minecraft:slime");
    @PythonField("minecraft:grass_path")
    public static final String GRASS_PATH = func("minecraft:grass_path");
    @PythonField("minecraft:double_plant")
    public static final String DOUBLE_PLANT = func("minecraft:double_plant");
    @PythonField("minecraft:stained_glass")
    public static final String STAINED_GLASS = func("minecraft:stained_glass");
    @PythonField("minecraft:stained_glass_pane")
    public static final String STAINED_GLASS_PANE = func("minecraft:stained_glass_pane");
    @PythonField("minecraft:prismarine")
    public static final String PRISMARINE = func("minecraft:prismarine");
    @PythonField("minecraft:sea_lantern")
    public static final String SEA_LANTERN = func("minecraft:sea_lantern");
    @PythonField("minecraft:red_sandstone")
    public static final String RED_SANDSTONE = func("minecraft:red_sandstone");
    @PythonField("minecraft:red_sandstone_stairs")
    public static final String RED_SANDSTONE_STAIRS = func("minecraft:red_sandstone_stairs");
    @PythonField("minecraft:stone_slab2")
    public static final String STONE_SLAB2 = func("minecraft:stone_slab2");
    @PythonField("minecraft:repeating_command_block")
    public static final String REPEATING_COMMAND_BLOCK = func("minecraft:repeating_command_block");
    @PythonField("minecraft:chain_command_block")
    public static final String CHAIN_COMMAND_BLOCK = func("minecraft:chain_command_block");
    @PythonField("minecraft:magma")
    public static final String MAGMA = func("minecraft:magma");
    @PythonField("minecraft:nether_wart_block")
    public static final String NETHER_WART_BLOCK = func("minecraft:nether_wart_block");
    @PythonField("minecraft:red_nether_brick")
    public static final String RED_NETHER_BRICK = func("minecraft:red_nether_brick");
    @PythonField("minecraft:bone_block")
    public static final String BONE_BLOCK = func("minecraft:bone_block");
    @PythonField("minecraft:structure_void")
    public static final String STRUCTURE_VOID = func("minecraft:structure_void");
    @PythonField("minecraft:observer")
    public static final String OBSERVER = func("minecraft:observer");
    @PythonField("minecraft:white_shulker_box")
    public static final String WHITE_SHULKER_BOX = func("minecraft:white_shulker_box");
    @PythonField("minecraft:orange_shulker_box")
    public static final String ORANGE_SHULKER_BOX = func("minecraft:orange_shulker_box");
    @PythonField("minecraft:magenta_shulker_box")
    public static final String MAGENTA_SHULKER_BOX = func("minecraft:magenta_shulker_box");
    @PythonField("minecraft:light_blue_shulker_box")
    public static final String LIGHT_BLUE_SHULKER_BOX = func("minecraft:light_blue_shulker_box");
    @PythonField("minecraft:yellow_shulker_box")
    public static final String YELLOW_SHULKER_BOX = func("minecraft:yellow_shulker_box");
    @PythonField("minecraft:lime_shulker_box")
    public static final String LIME_SHULKER_BOX = func("minecraft:lime_shulker_box");
    @PythonField("minecraft:pink_shulker_box")
    public static final String PINK_SHULKER_BOX = func("minecraft:pink_shulker_box");
    @PythonField("minecraft:gray_shulker_box")
    public static final String GRAY_SHULKER_BOX = func("minecraft:gray_shulker_box");
    @PythonField("minecraft:silver_shulker_box")
    public static final String SILVER_SHULKER_BOX = func("minecraft:silver_shulker_box");
    @PythonField("minecraft:cyan_shulker_box")
    public static final String CYAN_SHULKER_BOX = func("minecraft:cyan_shulker_box");
    @PythonField("minecraft:purple_shulker_box")
    public static final String PURPLE_SHULKER_BOX = func("minecraft:purple_shulker_box");
    @PythonField("minecraft:blue_shulker_box")
    public static final String BLUE_SHULKER_BOX = func("minecraft:blue_shulker_box");
    @PythonField("minecraft:brown_shulker_box")
    public static final String BROWN_SHULKER_BOX = func("minecraft:brown_shulker_box");
    @PythonField("minecraft:green_shulker_box")
    public static final String GREEN_SHULKER_BOX = func("minecraft:green_shulker_box");
    @PythonField("minecraft:red_shulker_box")
    public static final String RED_SHULKER_BOX = func("minecraft:red_shulker_box");
    @PythonField("minecraft:black_shulker_box")
    public static final String BLACK_SHULKER_BOX = func("minecraft:black_shulker_box");
    @PythonField("minecraft:white_glazed_terracotta")
    public static final String WHITE_GLAZED_TERRACOTTA = func("minecraft:white_glazed_terracotta");
    @PythonField("minecraft:orange_glazed_terracotta")
    public static final String ORANGE_GLAZED_TERRACOTTA = func("minecraft:orange_glazed_terracotta");
    @PythonField("minecraft:magenta_glazed_terracotta")
    public static final String MAGENTA_GLAZED_TERRACOTTA = func("minecraft:magenta_glazed_terracotta");
    @PythonField("minecraft:light_blue_glazed_terracotta")
    public static final String LIGHT_BLUE_GLAZED_TERRACOTTA = func("minecraft:light_blue_glazed_terracotta");
    @PythonField("minecraft:yellow_glazed_terracotta")
    public static final String YELLOW_GLAZED_TERRACOTTA = func("minecraft:yellow_glazed_terracotta");
    @PythonField("minecraft:lime_glazed_terracotta")
    public static final String LIME_GLAZED_TERRACOTTA = func("minecraft:lime_glazed_terracotta");
    @PythonField("minecraft:pink_glazed_terracotta")
    public static final String PINK_GLAZED_TERRACOTTA = func("minecraft:pink_glazed_terracotta");
    @PythonField("minecraft:gray_glazed_terracotta")
    public static final String GRAY_GLAZED_TERRACOTTA = func("minecraft:gray_glazed_terracotta");
    @PythonField("minecraft:silver_glazed_terracotta")
    public static final String SILVER_GLAZED_TERRACOTTA = func("minecraft:silver_glazed_terracotta");
    @PythonField("minecraft:cyan_glazed_terracotta")
    public static final String CYAN_GLAZED_TERRACOTTA = func("minecraft:cyan_glazed_terracotta");
    @PythonField("minecraft:purple_glazed_terracotta")
    public static final String PURPLE_GLAZED_TERRACOTTA = func("minecraft:purple_glazed_terracotta");
    @PythonField("minecraft:blue_glazed_terracotta")
    public static final String BLUE_GLAZED_TERRACOTTA = func("minecraft:blue_glazed_terracotta");
    @PythonField("minecraft:brown_glazed_terracotta")
    public static final String BROWN_GLAZED_TERRACOTTA = func("minecraft:brown_glazed_terracotta");
    @PythonField("minecraft:green_glazed_terracotta")
    public static final String GREEN_GLAZED_TERRACOTTA = func("minecraft:green_glazed_terracotta");
    @PythonField("minecraft:red_glazed_terracotta")
    public static final String RED_GLAZED_TERRACOTTA = func("minecraft:red_glazed_terracotta");
    @PythonField("minecraft:black_glazed_terracotta")
    public static final String BLACK_GLAZED_TERRACOTTA = func("minecraft:black_glazed_terracotta");
    @PythonField("minecraft:concrete")
    public static final String CONCRETE = func("minecraft:concrete");
    @PythonField("minecraft:concrete_powder")
    public static final String CONCRETE_POWDER = func("minecraft:concrete_powder");
    @PythonField("minecraft:structure_block")
    public static final String STRUCTURE_BLOCK = func("minecraft:structure_block");
    @PythonField("minecraft:iron_shovel")
    public static final String IRON_SHOVEL = func("minecraft:iron_shovel");
    @PythonField("minecraft:iron_pickaxe")
    public static final String IRON_PICKAXE = func("minecraft:iron_pickaxe");
    @PythonField("minecraft:iron_axe")
    public static final String IRON_AXE = func("minecraft:iron_axe");
    @PythonField("minecraft:flint_and_steel")
    public static final String FLINT_AND_STEEL = func("minecraft:flint_and_steel");
    @PythonField("minecraft:apple")
    public static final String APPLE = func("minecraft:apple");
    @PythonField("minecraft:bow")
    public static final String BOW = func("minecraft:bow");
    @PythonField("minecraft:arrow")
    public static final String ARROW = func("minecraft:arrow");
    @PythonField("minecraft:coal")
    public static final String COAL = func("minecraft:coal");
    @PythonField("minecraft:diamond")
    public static final String DIAMOND = func("minecraft:diamond");
    @PythonField("minecraft:iron_ingot")
    public static final String IRON_INGOT = func("minecraft:iron_ingot");
    @PythonField("minecraft:gold_ingot")
    public static final String GOLD_INGOT = func("minecraft:gold_ingot");
    @PythonField("minecraft:iron_sword")
    public static final String IRON_SWORD = func("minecraft:iron_sword");
    @PythonField("minecraft:wooden_sword")
    public static final String WOODEN_SWORD = func("minecraft:wooden_sword");
    @PythonField("minecraft:wooden_shovel")
    public static final String WOODEN_SHOVEL = func("minecraft:wooden_shovel");
    @PythonField("minecraft:wooden_pickaxe")
    public static final String WOODEN_PICKAXE = func("minecraft:wooden_pickaxe");
    @PythonField("minecraft:wooden_axe")
    public static final String WOODEN_AXE = func("minecraft:wooden_axe");
    @PythonField("minecraft:stone_sword")
    public static final String STONE_SWORD = func("minecraft:stone_sword");
    @PythonField("minecraft:stone_shovel")
    public static final String STONE_SHOVEL = func("minecraft:stone_shovel");
    @PythonField("minecraft:stone_pickaxe")
    public static final String STONE_PICKAXE = func("minecraft:stone_pickaxe");
    @PythonField("minecraft:stone_axe")
    public static final String STONE_AXE = func("minecraft:stone_axe");
    @PythonField("minecraft:diamond_sword")
    public static final String DIAMOND_SWORD = func("minecraft:diamond_sword");
    @PythonField("minecraft:diamond_shovel")
    public static final String DIAMOND_SHOVEL = func("minecraft:diamond_shovel");
    @PythonField("minecraft:diamond_pickaxe")
    public static final String DIAMOND_PICKAXE = func("minecraft:diamond_pickaxe");
    @PythonField("minecraft:diamond_axe")
    public static final String DIAMOND_AXE = func("minecraft:diamond_axe");
    @PythonField("minecraft:stick")
    public static final String STICK = func("minecraft:stick");
    @PythonField("minecraft:bowl")
    public static final String BOWL = func("minecraft:bowl");
    @PythonField("minecraft:mushroom_stew")
    public static final String MUSHROOM_STEW = func("minecraft:mushroom_stew");
    @PythonField("minecraft:golden_sword")
    public static final String GOLDEN_SWORD = func("minecraft:golden_sword");
    @PythonField("minecraft:golden_shovel")
    public static final String GOLDEN_SHOVEL = func("minecraft:golden_shovel");
    @PythonField("minecraft:golden_pickaxe")
    public static final String GOLDEN_PICKAXE = func("minecraft:golden_pickaxe");
    @PythonField("minecraft:golden_axe")
    public static final String GOLDEN_AXE = func("minecraft:golden_axe");
    @PythonField("minecraft:string")
    public static final String STRING = func("minecraft:string");
    @PythonField("minecraft:feather")
    public static final String FEATHER = func("minecraft:feather");
    @PythonField("minecraft:gunpowder")
    public static final String GUNPOWDER = func("minecraft:gunpowder");
    @PythonField("minecraft:wooden_hoe")
    public static final String WOODEN_HOE = func("minecraft:wooden_hoe");
    @PythonField("minecraft:stone_hoe")
    public static final String STONE_HOE = func("minecraft:stone_hoe");
    @PythonField("minecraft:iron_hoe")
    public static final String IRON_HOE = func("minecraft:iron_hoe");
    @PythonField("minecraft:diamond_hoe")
    public static final String DIAMOND_HOE = func("minecraft:diamond_hoe");
    @PythonField("minecraft:golden_hoe")
    public static final String GOLDEN_HOE = func("minecraft:golden_hoe");
    @PythonField("minecraft:wheat_seeds")
    public static final String WHEAT_SEEDS = func("minecraft:wheat_seeds");
    @PythonField("minecraft:wheat")
    public static final String WHEAT = func("minecraft:wheat");
    @PythonField("minecraft:bread")
    public static final String BREAD = func("minecraft:bread");
    @PythonField("minecraft:leather_helmet")
    public static final String LEATHER_HELMET = func("minecraft:leather_helmet");
    @PythonField("minecraft:leather_chestplate")
    public static final String LEATHER_CHESTPLATE = func("minecraft:leather_chestplate");
    @PythonField("minecraft:leather_leggings")
    public static final String LEATHER_LEGGINGS = func("minecraft:leather_leggings");
    @PythonField("minecraft:leather_boots")
    public static final String LEATHER_BOOTS = func("minecraft:leather_boots");
    @PythonField("minecraft:chainmail_helmet")
    public static final String CHAINMAIL_HELMET = func("minecraft:chainmail_helmet");
    @PythonField("minecraft:chainmail_chestplate")
    public static final String CHAINMAIL_CHESTPLATE = func("minecraft:chainmail_chestplate");
    @PythonField("minecraft:chainmail_leggings")
    public static final String CHAINMAIL_LEGGINGS = func("minecraft:chainmail_leggings");
    @PythonField("minecraft:chainmail_boots")
    public static final String CHAINMAIL_BOOTS = func("minecraft:chainmail_boots");
    @PythonField("minecraft:iron_helmet")
    public static final String IRON_HELMET = func("minecraft:iron_helmet");
    @PythonField("minecraft:iron_chestplate")
    public static final String IRON_CHESTPLATE = func("minecraft:iron_chestplate");
    @PythonField("minecraft:iron_leggings")
    public static final String IRON_LEGGINGS = func("minecraft:iron_leggings");
    @PythonField("minecraft:iron_boots")
    public static final String IRON_BOOTS = func("minecraft:iron_boots");
    @PythonField("minecraft:diamond_helmet")
    public static final String DIAMOND_HELMET = func("minecraft:diamond_helmet");
    @PythonField("minecraft:diamond_chestplate")
    public static final String DIAMOND_CHESTPLATE = func("minecraft:diamond_chestplate");
    @PythonField("minecraft:diamond_leggings")
    public static final String DIAMOND_LEGGINGS = func("minecraft:diamond_leggings");
    @PythonField("minecraft:diamond_boots")
    public static final String DIAMOND_BOOTS = func("minecraft:diamond_boots");
    @PythonField("minecraft:golden_helmet")
    public static final String GOLDEN_HELMET = func("minecraft:golden_helmet");
    @PythonField("minecraft:golden_chestplate")
    public static final String GOLDEN_CHESTPLATE = func("minecraft:golden_chestplate");
    @PythonField("minecraft:golden_leggings")
    public static final String GOLDEN_LEGGINGS = func("minecraft:golden_leggings");
    @PythonField("minecraft:golden_boots")
    public static final String GOLDEN_BOOTS = func("minecraft:golden_boots");
    @PythonField("minecraft:flint")
    public static final String FLINT = func("minecraft:flint");
    @PythonField("minecraft:porkchop")
    public static final String PORKCHOP = func("minecraft:porkchop");
    @PythonField("minecraft:cooked_porkchop")
    public static final String COOKED_PORKCHOP = func("minecraft:cooked_porkchop");
    @PythonField("minecraft:painting")
    public static final String PAINTING = func("minecraft:painting");
    @PythonField("minecraft:golden_apple")
    public static final String GOLDEN_APPLE = func("minecraft:golden_apple");
    @PythonField("minecraft:sign")
    public static final String SIGN = func("minecraft:sign");
    @PythonField("minecraft:wooden_door")
    public static final String WOODEN_DOOR = func("minecraft:wooden_door");
    @PythonField("minecraft:bucket")
    public static final String BUCKET = func("minecraft:bucket");
    @PythonField("minecraft:water_bucket")
    public static final String WATER_BUCKET = func("minecraft:water_bucket");
    @PythonField("minecraft:lava_bucket")
    public static final String LAVA_BUCKET = func("minecraft:lava_bucket");
    @PythonField("minecraft:minecart")
    public static final String MINECART = func("minecraft:minecart");
    @PythonField("minecraft:saddle")
    public static final String SADDLE = func("minecraft:saddle");
    @PythonField("minecraft:iron_door")
    public static final String IRON_DOOR = func("minecraft:iron_door");
    @PythonField("minecraft:redstone")
    public static final String REDSTONE = func("minecraft:redstone");
    @PythonField("minecraft:snowball")
    public static final String SNOWBALL = func("minecraft:snowball");
    @PythonField("minecraft:boat")
    public static final String BOAT = func("minecraft:boat");
    @PythonField("minecraft:leather")
    public static final String LEATHER = func("minecraft:leather");
    @PythonField("minecraft:milk_bucket")
    public static final String MILK_BUCKET = func("minecraft:milk_bucket");
    @PythonField("minecraft:brick")
    public static final String BRICK = func("minecraft:brick");
    @PythonField("minecraft:clay_ball")
    public static final String CLAY_BALL = func("minecraft:clay_ball");
    @PythonField("minecraft:reeds")
    public static final String REEDS = func("minecraft:reeds");
    @PythonField("minecraft:paper")
    public static final String PAPER = func("minecraft:paper");
    @PythonField("minecraft:book")
    public static final String BOOK = func("minecraft:book");
    @PythonField("minecraft:slime_ball")
    public static final String SLIME_BALL = func("minecraft:slime_ball");
    @PythonField("minecraft:chest_minecart")
    public static final String CHEST_MINECART = func("minecraft:chest_minecart");
    @PythonField("minecraft:furnace_minecart")
    public static final String FURNACE_MINECART = func("minecraft:furnace_minecart");
    @PythonField("minecraft:egg")
    public static final String EGG = func("minecraft:egg");
    @PythonField("minecraft:compass")
    public static final String COMPASS = func("minecraft:compass");
    @PythonField("minecraft:fishing_rod")
    public static final String FISHING_ROD = func("minecraft:fishing_rod");
    @PythonField("minecraft:clock")
    public static final String CLOCK = func("minecraft:clock");
    @PythonField("minecraft:glowstone_dust")
    public static final String GLOWSTONE_DUST = func("minecraft:glowstone_dust");
    @PythonField("minecraft:fish")
    public static final String FISH = func("minecraft:fish");
    @PythonField("minecraft:cooked_fish")
    public static final String COOKED_FISH = func("minecraft:cooked_fish");
    @PythonField("minecraft:dye")
    public static final String DYE = func("minecraft:dye");
    @PythonField("minecraft:bone")
    public static final String BONE = func("minecraft:bone");
    @PythonField("minecraft:sugar")
    public static final String SUGAR = func("minecraft:sugar");
    @PythonField("minecraft:cake")
    public static final String CAKE = func("minecraft:cake");
    @PythonField("minecraft:bed")
    public static final String BED = func("minecraft:bed");
    @PythonField("minecraft:repeater")
    public static final String REPEATER = func("minecraft:repeater");
    @PythonField("minecraft:cookie")
    public static final String COOKIE = func("minecraft:cookie");
    @PythonField("minecraft:filled_map")
    public static final String FILLED_MAP = func("minecraft:filled_map");
    @PythonField("minecraft:shears")
    public static final String SHEARS = func("minecraft:shears");
    @PythonField("minecraft:melon")
    public static final String MELON = func("minecraft:melon");
    @PythonField("minecraft:pumpkin_seeds")
    public static final String PUMPKIN_SEEDS = func("minecraft:pumpkin_seeds");
    @PythonField("minecraft:melon_seeds")
    public static final String MELON_SEEDS = func("minecraft:melon_seeds");
    @PythonField("minecraft:beef")
    public static final String BEEF = func("minecraft:beef");
    @PythonField("minecraft:cooked_beef")
    public static final String COOKED_BEEF = func("minecraft:cooked_beef");
    @PythonField("minecraft:chicken")
    public static final String CHICKEN = func("minecraft:chicken");
    @PythonField("minecraft:cooked_chicken")
    public static final String COOKED_CHICKEN = func("minecraft:cooked_chicken");
    @PythonField("minecraft:rotten_flesh")
    public static final String ROTTEN_FLESH = func("minecraft:rotten_flesh");
    @PythonField("minecraft:ender_pearl")
    public static final String ENDER_PEARL = func("minecraft:ender_pearl");
    @PythonField("minecraft:blaze_rod")
    public static final String BLAZE_ROD = func("minecraft:blaze_rod");
    @PythonField("minecraft:ghast_tear")
    public static final String GHAST_TEAR = func("minecraft:ghast_tear");
    @PythonField("minecraft:gold_nugget")
    public static final String GOLD_NUGGET = func("minecraft:gold_nugget");
    @PythonField("minecraft:nether_wart")
    public static final String NETHER_WART = func("minecraft:nether_wart");
    @PythonField("minecraft:potion")
    public static final String POTION = func("minecraft:potion");
    @PythonField("minecraft:glass_bottle")
    public static final String GLASS_BOTTLE = func("minecraft:glass_bottle");
    @PythonField("minecraft:spider_eye")
    public static final String SPIDER_EYE = func("minecraft:spider_eye");
    @PythonField("minecraft:fermented_spider_eye")
    public static final String FERMENTED_SPIDER_EYE = func("minecraft:fermented_spider_eye");
    @PythonField("minecraft:blaze_powder")
    public static final String BLAZE_POWDER = func("minecraft:blaze_powder");
    @PythonField("minecraft:magma_cream")
    public static final String MAGMA_CREAM = func("minecraft:magma_cream");
    @PythonField("minecraft:brewing_stand")
    public static final String BREWING_STAND = func("minecraft:brewing_stand");
    @PythonField("minecraft:cauldron")
    public static final String CAULDRON = func("minecraft:cauldron");
    @PythonField("minecraft:ender_eye")
    public static final String ENDER_EYE = func("minecraft:ender_eye");
    @PythonField("minecraft:speckled_melon")
    public static final String SPECKLED_MELON = func("minecraft:speckled_melon");
    @PythonField("minecraft:spawn_egg")
    public static final String SPAWN_EGG = func("minecraft:spawn_egg");
    @PythonField("minecraft:experience_bottle")
    public static final String EXPERIENCE_BOTTLE = func("minecraft:experience_bottle");
    @PythonField("minecraft:fire_charge")
    public static final String FIRE_CHARGE = func("minecraft:fire_charge");
    @PythonField("minecraft:writable_book")
    public static final String WRITABLE_BOOK = func("minecraft:writable_book");
    @PythonField("minecraft:written_book")
    public static final String WRITTEN_BOOK = func("minecraft:written_book");
    @PythonField("minecraft:emerald")
    public static final String EMERALD = func("minecraft:emerald");
    @PythonField("minecraft:item_frame")
    public static final String ITEM_FRAME = func("minecraft:item_frame");
    @PythonField("minecraft:flower_pot")
    public static final String FLOWER_POT = func("minecraft:flower_pot");
    @PythonField("minecraft:carrot")
    public static final String CARROT = func("minecraft:carrot");
    @PythonField("minecraft:potato")
    public static final String POTATO = func("minecraft:potato");
    @PythonField("minecraft:baked_potato")
    public static final String BAKED_POTATO = func("minecraft:baked_potato");
    @PythonField("minecraft:poisonous_potato")
    public static final String POISONOUS_POTATO = func("minecraft:poisonous_potato");
    @PythonField("minecraft:map")
    public static final String MAP = func("minecraft:map");
    @PythonField("minecraft:golden_carrot")
    public static final String GOLDEN_CARROT = func("minecraft:golden_carrot");
    @PythonField("minecraft:skull")
    public static final String SKULL = func("minecraft:skull");
    @PythonField("minecraft:carrot_on_a_stick")
    public static final String CARROT_ON_A_STICK = func("minecraft:carrot_on_a_stick");
    @PythonField("minecraft:nether_star")
    public static final String NETHER_STAR = func("minecraft:nether_star");
    @PythonField("minecraft:pumpkin_pie")
    public static final String PUMPKIN_PIE = func("minecraft:pumpkin_pie");
    @PythonField("minecraft:fireworks")
    public static final String FIREWORKS = func("minecraft:fireworks");
    @PythonField("minecraft:firework_charge")
    public static final String FIREWORK_CHARGE = func("minecraft:firework_charge");
    @PythonField("minecraft:enchanted_book")
    public static final String ENCHANTED_BOOK = func("minecraft:enchanted_book");
    @PythonField("minecraft:comparator")
    public static final String COMPARATOR = func("minecraft:comparator");
    @PythonField("minecraft:netherbrick")
    public static final String NETHERBRICK = func("minecraft:netherbrick");
    @PythonField("minecraft:quartz")
    public static final String QUARTZ = func("minecraft:quartz");
    @PythonField("minecraft:tnt_minecart")
    public static final String TNT_MINECART = func("minecraft:tnt_minecart");
    @PythonField("minecraft:hopper_minecart")
    public static final String HOPPER_MINECART = func("minecraft:hopper_minecart");
    @PythonField("minecraft:prismarine_shard")
    public static final String PRISMARINE_SHARD = func("minecraft:prismarine_shard");
    @PythonField("minecraft:prismarine_crystals")
    public static final String PRISMARINE_CRYSTALS = func("minecraft:prismarine_crystals");
    @PythonField("minecraft:rabbit")
    public static final String RABBIT = func("minecraft:rabbit");
    @PythonField("minecraft:cooked_rabbit")
    public static final String COOKED_RABBIT = func("minecraft:cooked_rabbit");
    @PythonField("minecraft:rabbit_stew")
    public static final String RABBIT_STEW = func("minecraft:rabbit_stew");
    @PythonField("minecraft:rabbit_foot")
    public static final String RABBIT_FOOT = func("minecraft:rabbit_foot");
    @PythonField("minecraft:rabbit_hide")
    public static final String RABBIT_HIDE = func("minecraft:rabbit_hide");
    @PythonField("minecraft:armor_stand")
    public static final String ARMOR_STAND = func("minecraft:armor_stand");
    @PythonField("minecraft:iron_horse_armor")
    public static final String IRON_HORSE_ARMOR = func("minecraft:iron_horse_armor");
    @PythonField("minecraft:golden_horse_armor")
    public static final String GOLDEN_HORSE_ARMOR = func("minecraft:golden_horse_armor");
    @PythonField("minecraft:diamond_horse_armor")
    public static final String DIAMOND_HORSE_ARMOR = func("minecraft:diamond_horse_armor");
    @PythonField("minecraft:lead")
    public static final String LEAD = func("minecraft:lead");
    @PythonField("minecraft:name_tag")
    public static final String NAME_TAG = func("minecraft:name_tag");
    @PythonField("minecraft:command_block_minecart")
    public static final String COMMAND_BLOCK_MINECART = func("minecraft:command_block_minecart");
    @PythonField("minecraft:mutton")
    public static final String MUTTON = func("minecraft:mutton");
    @PythonField("minecraft:cooked_mutton")
    public static final String COOKED_MUTTON = func("minecraft:cooked_mutton");
    @PythonField("minecraft:banner")
    public static final String BANNER = func("minecraft:banner");
    @PythonField("minecraft:end_crystal")
    public static final String END_CRYSTAL = func("minecraft:end_crystal");
    @PythonField("minecraft:spruce_door")
    public static final String SPRUCE_DOOR = func("minecraft:spruce_door");
    @PythonField("minecraft:birch_door")
    public static final String BIRCH_DOOR = func("minecraft:birch_door");
    @PythonField("minecraft:jungle_door")
    public static final String JUNGLE_DOOR = func("minecraft:jungle_door");
    @PythonField("minecraft:acacia_door")
    public static final String ACACIA_DOOR = func("minecraft:acacia_door");
    @PythonField("minecraft:dark_oak_door")
    public static final String DARK_OAK_DOOR = func("minecraft:dark_oak_door");
    @PythonField("minecraft:chorus_fruit")
    public static final String CHORUS_FRUIT = func("minecraft:chorus_fruit");
    @PythonField("minecraft:chorus_fruit_popped")
    public static final String CHORUS_FRUIT_POPPED = func("minecraft:chorus_fruit_popped");
    @PythonField("minecraft:beetroot")
    public static final String BEETROOT = func("minecraft:beetroot");
    @PythonField("minecraft:beetroot_seeds")
    public static final String BEETROOT_SEEDS = func("minecraft:beetroot_seeds");
    @PythonField("minecraft:beetroot_soup")
    public static final String BEETROOT_SOUP = func("minecraft:beetroot_soup");
    @PythonField("minecraft:dragon_breath")
    public static final String DRAGON_BREATH = func("minecraft:dragon_breath");
    @PythonField("minecraft:splash_potion")
    public static final String SPLASH_POTION = func("minecraft:splash_potion");
    @PythonField("minecraft:spectral_arrow")
    public static final String SPECTRAL_ARROW = func("minecraft:spectral_arrow");
    @PythonField("minecraft:tipped_arrow")
    public static final String TIPPED_ARROW = func("minecraft:tipped_arrow");
    @PythonField("minecraft:lingering_potion")
    public static final String LINGERING_POTION = func("minecraft:lingering_potion");
    @PythonField("minecraft:shield")
    public static final String SHIELD = func("minecraft:shield");
    @PythonField("minecraft:elytra")
    public static final String ELYTRA = func("minecraft:elytra");
    @PythonField("minecraft:spruce_boat")
    public static final String SPRUCE_BOAT = func("minecraft:spruce_boat");
    @PythonField("minecraft:birch_boat")
    public static final String BIRCH_BOAT = func("minecraft:birch_boat");
    @PythonField("minecraft:jungle_boat")
    public static final String JUNGLE_BOAT = func("minecraft:jungle_boat");
    @PythonField("minecraft:acacia_boat")
    public static final String ACACIA_BOAT = func("minecraft:acacia_boat");
    @PythonField("minecraft:dark_oak_boat")
    public static final String DARK_OAK_BOAT = func("minecraft:dark_oak_boat");
    @PythonField("minecraft:totem_of_undying")
    public static final String TOTEM_OF_UNDYING = func("minecraft:totem_of_undying");
    @PythonField("minecraft:shulker_shell")
    public static final String SHULKER_SHELL = func("minecraft:shulker_shell");
    @PythonField("minecraft:iron_nugget")
    public static final String IRON_NUGGET = func("minecraft:iron_nugget");
    @PythonField("minecraft:knowledge_book")
    public static final String KNOWLEDGE_BOOK = func("minecraft:knowledge_book");
    @PythonField("minecraft:record_13")
    public static final String RECORD_13 = func("minecraft:record_13");
    @PythonField("minecraft:record_cat")
    public static final String RECORD_CAT = func("minecraft:record_cat");
    @PythonField("minecraft:record_blocks")
    public static final String RECORD_BLOCKS = func("minecraft:record_blocks");
    @PythonField("minecraft:record_chirp")
    public static final String RECORD_CHIRP = func("minecraft:record_chirp");
    @PythonField("minecraft:record_far")
    public static final String RECORD_FAR = func("minecraft:record_far");
    @PythonField("minecraft:record_mall")
    public static final String RECORD_MALL = func("minecraft:record_mall");
    @PythonField("minecraft:record_mellohi")
    public static final String RECORD_MELLOHI = func("minecraft:record_mellohi");
    @PythonField("minecraft:record_stal")
    public static final String RECORD_STAL = func("minecraft:record_stal");
    @PythonField("minecraft:record_strad")
    public static final String RECORD_STRAD = func("minecraft:record_strad");
    @PythonField("minecraft:record_ward")
    public static final String RECORD_WARD = func("minecraft:record_ward");
    @PythonField("minecraft:record_11")
    public static final String RECORD_11 = func("minecraft:record_11");
    @PythonField("minecraft:record_wait")
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