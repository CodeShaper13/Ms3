package com.codeshaper.ms3.api;

import org.python.core.PyString;
import org.python.core.PyList;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonClass
@PythonDocString("A list of all the vanilla Block names.")
public class blocks {

    private static PyList names = new PyList();

    private blocks() { }

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
    @PythonField("minecraft:flowing_water")
    public static final String FLOWING_WATER = func("minecraft:flowing_water");
    @PythonField("minecraft:water")
    public static final String WATER = func("minecraft:water");
    @PythonField("minecraft:flowing_lava")
    public static final String FLOWING_LAVA = func("minecraft:flowing_lava");
    @PythonField("minecraft:lava")
    public static final String LAVA = func("minecraft:lava");
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
    @PythonField("minecraft:leaves")
    public static final String LEAVES = func("minecraft:leaves");
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
    @PythonField("minecraft:bed")
    public static final String BED = func("minecraft:bed");
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
    @PythonField("minecraft:piston_head")
    public static final String PISTON_HEAD = func("minecraft:piston_head");
    @PythonField("minecraft:wool")
    public static final String WOOL = func("minecraft:wool");
    @PythonField("minecraft:piston_extension")
    public static final String PISTON_EXTENSION = func("minecraft:piston_extension");
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
    @PythonField("minecraft:double_stone_slab")
    public static final String DOUBLE_STONE_SLAB = func("minecraft:double_stone_slab");
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
    @PythonField("minecraft:fire")
    public static final String FIRE = func("minecraft:fire");
    @PythonField("minecraft:mob_spawner")
    public static final String MOB_SPAWNER = func("minecraft:mob_spawner");
    @PythonField("minecraft:oak_stairs")
    public static final String OAK_STAIRS = func("minecraft:oak_stairs");
    @PythonField("minecraft:chest")
    public static final String CHEST = func("minecraft:chest");
    @PythonField("minecraft:redstone_wire")
    public static final String REDSTONE_WIRE = func("minecraft:redstone_wire");
    @PythonField("minecraft:diamond_ore")
    public static final String DIAMOND_ORE = func("minecraft:diamond_ore");
    @PythonField("minecraft:diamond_block")
    public static final String DIAMOND_BLOCK = func("minecraft:diamond_block");
    @PythonField("minecraft:crafting_table")
    public static final String CRAFTING_TABLE = func("minecraft:crafting_table");
    @PythonField("minecraft:wheat")
    public static final String WHEAT = func("minecraft:wheat");
    @PythonField("minecraft:farmland")
    public static final String FARMLAND = func("minecraft:farmland");
    @PythonField("minecraft:furnace")
    public static final String FURNACE = func("minecraft:furnace");
    @PythonField("minecraft:lit_furnace")
    public static final String LIT_FURNACE = func("minecraft:lit_furnace");
    @PythonField("minecraft:standing_sign")
    public static final String STANDING_SIGN = func("minecraft:standing_sign");
    @PythonField("minecraft:wooden_door")
    public static final String WOODEN_DOOR = func("minecraft:wooden_door");
    @PythonField("minecraft:ladder")
    public static final String LADDER = func("minecraft:ladder");
    @PythonField("minecraft:rail")
    public static final String RAIL = func("minecraft:rail");
    @PythonField("minecraft:stone_stairs")
    public static final String STONE_STAIRS = func("minecraft:stone_stairs");
    @PythonField("minecraft:wall_sign")
    public static final String WALL_SIGN = func("minecraft:wall_sign");
    @PythonField("minecraft:lever")
    public static final String LEVER = func("minecraft:lever");
    @PythonField("minecraft:stone_pressure_plate")
    public static final String STONE_PRESSURE_PLATE = func("minecraft:stone_pressure_plate");
    @PythonField("minecraft:iron_door")
    public static final String IRON_DOOR = func("minecraft:iron_door");
    @PythonField("minecraft:wooden_pressure_plate")
    public static final String WOODEN_PRESSURE_PLATE = func("minecraft:wooden_pressure_plate");
    @PythonField("minecraft:redstone_ore")
    public static final String REDSTONE_ORE = func("minecraft:redstone_ore");
    @PythonField("minecraft:lit_redstone_ore")
    public static final String LIT_REDSTONE_ORE = func("minecraft:lit_redstone_ore");
    @PythonField("minecraft:unlit_redstone_torch")
    public static final String UNLIT_REDSTONE_TORCH = func("minecraft:unlit_redstone_torch");
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
    @PythonField("minecraft:reeds")
    public static final String REEDS = func("minecraft:reeds");
    @PythonField("minecraft:jukebox")
    public static final String JUKEBOX = func("minecraft:jukebox");
    @PythonField("minecraft:fence")
    public static final String FENCE = func("minecraft:fence");
    @PythonField("minecraft:pumpkin")
    public static final String PUMPKIN = func("minecraft:pumpkin");
    @PythonField("minecraft:netherrack")
    public static final String NETHERRACK = func("minecraft:netherrack");
    @PythonField("minecraft:soul_sand")
    public static final String SOUL_SAND = func("minecraft:soul_sand");
    @PythonField("minecraft:glowstone")
    public static final String GLOWSTONE = func("minecraft:glowstone");
    @PythonField("minecraft:portal")
    public static final String PORTAL = func("minecraft:portal");
    @PythonField("minecraft:lit_pumpkin")
    public static final String LIT_PUMPKIN = func("minecraft:lit_pumpkin");
    @PythonField("minecraft:cake")
    public static final String CAKE = func("minecraft:cake");
    @PythonField("minecraft:unpowered_repeater")
    public static final String UNPOWERED_REPEATER = func("minecraft:unpowered_repeater");
    @PythonField("minecraft:powered_repeater")
    public static final String POWERED_REPEATER = func("minecraft:powered_repeater");
    @PythonField("minecraft:stained_glass")
    public static final String STAINED_GLASS = func("minecraft:stained_glass");
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
    @PythonField("minecraft:pumpkin_stem")
    public static final String PUMPKIN_STEM = func("minecraft:pumpkin_stem");
    @PythonField("minecraft:melon_stem")
    public static final String MELON_STEM = func("minecraft:melon_stem");
    @PythonField("minecraft:vine")
    public static final String VINE = func("minecraft:vine");
    @PythonField("minecraft:fence_gate")
    public static final String FENCE_GATE = func("minecraft:fence_gate");
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
    @PythonField("minecraft:nether_wart")
    public static final String NETHER_WART = func("minecraft:nether_wart");
    @PythonField("minecraft:enchanting_table")
    public static final String ENCHANTING_TABLE = func("minecraft:enchanting_table");
    @PythonField("minecraft:brewing_stand")
    public static final String BREWING_STAND = func("minecraft:brewing_stand");
    @PythonField("minecraft:cauldron")
    public static final String CAULDRON = func("minecraft:cauldron");
    @PythonField("minecraft:end_portal")
    public static final String END_PORTAL = func("minecraft:end_portal");
    @PythonField("minecraft:end_portal_frame")
    public static final String END_PORTAL_FRAME = func("minecraft:end_portal_frame");
    @PythonField("minecraft:end_stone")
    public static final String END_STONE = func("minecraft:end_stone");
    @PythonField("minecraft:dragon_egg")
    public static final String DRAGON_EGG = func("minecraft:dragon_egg");
    @PythonField("minecraft:redstone_lamp")
    public static final String REDSTONE_LAMP = func("minecraft:redstone_lamp");
    @PythonField("minecraft:lit_redstone_lamp")
    public static final String LIT_REDSTONE_LAMP = func("minecraft:lit_redstone_lamp");
    @PythonField("minecraft:double_wooden_slab")
    public static final String DOUBLE_WOODEN_SLAB = func("minecraft:double_wooden_slab");
    @PythonField("minecraft:wooden_slab")
    public static final String WOODEN_SLAB = func("minecraft:wooden_slab");
    @PythonField("minecraft:cocoa")
    public static final String COCOA = func("minecraft:cocoa");
    @PythonField("minecraft:sandstone_stairs")
    public static final String SANDSTONE_STAIRS = func("minecraft:sandstone_stairs");
    @PythonField("minecraft:emerald_ore")
    public static final String EMERALD_ORE = func("minecraft:emerald_ore");
    @PythonField("minecraft:ender_chest")
    public static final String ENDER_CHEST = func("minecraft:ender_chest");
    @PythonField("minecraft:tripwire_hook")
    public static final String TRIPWIRE_HOOK = func("minecraft:tripwire_hook");
    @PythonField("minecraft:tripwire")
    public static final String TRIPWIRE = func("minecraft:tripwire");
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
    @PythonField("minecraft:flower_pot")
    public static final String FLOWER_POT = func("minecraft:flower_pot");
    @PythonField("minecraft:carrots")
    public static final String CARROTS = func("minecraft:carrots");
    @PythonField("minecraft:potatoes")
    public static final String POTATOES = func("minecraft:potatoes");
    @PythonField("minecraft:wooden_button")
    public static final String WOODEN_BUTTON = func("minecraft:wooden_button");
    @PythonField("minecraft:skull")
    public static final String SKULL = func("minecraft:skull");
    @PythonField("minecraft:anvil")
    public static final String ANVIL = func("minecraft:anvil");
    @PythonField("minecraft:trapped_chest")
    public static final String TRAPPED_CHEST = func("minecraft:trapped_chest");
    @PythonField("minecraft:light_weighted_pressure_plate")
    public static final String LIGHT_WEIGHTED_PRESSURE_PLATE = func("minecraft:light_weighted_pressure_plate");
    @PythonField("minecraft:heavy_weighted_pressure_plate")
    public static final String HEAVY_WEIGHTED_PRESSURE_PLATE = func("minecraft:heavy_weighted_pressure_plate");
    @PythonField("minecraft:unpowered_comparator")
    public static final String UNPOWERED_COMPARATOR = func("minecraft:unpowered_comparator");
    @PythonField("minecraft:powered_comparator")
    public static final String POWERED_COMPARATOR = func("minecraft:powered_comparator");
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
    @PythonField("minecraft:stained_glass_pane")
    public static final String STAINED_GLASS_PANE = func("minecraft:stained_glass_pane");
    @PythonField("minecraft:leaves2")
    public static final String LEAVES2 = func("minecraft:leaves2");
    @PythonField("minecraft:log2")
    public static final String LOG2 = func("minecraft:log2");
    @PythonField("minecraft:acacia_stairs")
    public static final String ACACIA_STAIRS = func("minecraft:acacia_stairs");
    @PythonField("minecraft:dark_oak_stairs")
    public static final String DARK_OAK_STAIRS = func("minecraft:dark_oak_stairs");
    @PythonField("minecraft:slime")
    public static final String SLIME = func("minecraft:slime");
    @PythonField("minecraft:barrier")
    public static final String BARRIER = func("minecraft:barrier");
    @PythonField("minecraft:iron_trapdoor")
    public static final String IRON_TRAPDOOR = func("minecraft:iron_trapdoor");
    @PythonField("minecraft:prismarine")
    public static final String PRISMARINE = func("minecraft:prismarine");
    @PythonField("minecraft:sea_lantern")
    public static final String SEA_LANTERN = func("minecraft:sea_lantern");
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
    @PythonField("minecraft:double_plant")
    public static final String DOUBLE_PLANT = func("minecraft:double_plant");
    @PythonField("minecraft:standing_banner")
    public static final String STANDING_BANNER = func("minecraft:standing_banner");
    @PythonField("minecraft:wall_banner")
    public static final String WALL_BANNER = func("minecraft:wall_banner");
    @PythonField("minecraft:daylight_detector_inverted")
    public static final String DAYLIGHT_DETECTOR_INVERTED = func("minecraft:daylight_detector_inverted");
    @PythonField("minecraft:red_sandstone")
    public static final String RED_SANDSTONE = func("minecraft:red_sandstone");
    @PythonField("minecraft:red_sandstone_stairs")
    public static final String RED_SANDSTONE_STAIRS = func("minecraft:red_sandstone_stairs");
    @PythonField("minecraft:double_stone_slab2")
    public static final String DOUBLE_STONE_SLAB2 = func("minecraft:double_stone_slab2");
    @PythonField("minecraft:stone_slab2")
    public static final String STONE_SLAB2 = func("minecraft:stone_slab2");
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
    @PythonField("minecraft:purpur_double_slab")
    public static final String PURPUR_DOUBLE_SLAB = func("minecraft:purpur_double_slab");
    @PythonField("minecraft:purpur_slab")
    public static final String PURPUR_SLAB = func("minecraft:purpur_slab");
    @PythonField("minecraft:end_bricks")
    public static final String END_BRICKS = func("minecraft:end_bricks");
    @PythonField("minecraft:beetroots")
    public static final String BEETROOTS = func("minecraft:beetroots");
    @PythonField("minecraft:grass_path")
    public static final String GRASS_PATH = func("minecraft:grass_path");
    @PythonField("minecraft:end_gateway")
    public static final String END_GATEWAY = func("minecraft:end_gateway");
    @PythonField("minecraft:repeating_command_block")
    public static final String REPEATING_COMMAND_BLOCK = func("minecraft:repeating_command_block");
    @PythonField("minecraft:chain_command_block")
    public static final String CHAIN_COMMAND_BLOCK = func("minecraft:chain_command_block");
    @PythonField("minecraft:frosted_ice")
    public static final String FROSTED_ICE = func("minecraft:frosted_ice");
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

    @PythonFunction
    @PythonDocString("Returns a list of all the vanilla Blockss.")
    public static PyList getAllBlocks() {
        return names;
    }

    private static String func(String s) {
        names.add(new PyString(s));
        return s;
    }
}