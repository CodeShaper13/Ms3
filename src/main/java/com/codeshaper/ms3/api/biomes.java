package com.codeshaper.ms3.api;

import org.python.core.PyString;
import org.python.core.PyList;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonClass
@PythonDocString("A list of all the vanilla Biome names.")
public class biomes {

    private static PyList names = new PyList();

    private biomes() { }

    @PythonFieldGenerated
    public static final String OCEAN = func("minecraft:ocean");
    @PythonFieldGenerated
    public static final String PLAINS = func("minecraft:plains");
    @PythonFieldGenerated
    public static final String DESERT = func("minecraft:desert");
    @PythonFieldGenerated
    public static final String EXTREME_HILLS = func("minecraft:extreme_hills");
    @PythonFieldGenerated
    public static final String FOREST = func("minecraft:forest");
    @PythonFieldGenerated
    public static final String TAIGA = func("minecraft:taiga");
    @PythonFieldGenerated
    public static final String SWAMPLAND = func("minecraft:swampland");
    @PythonFieldGenerated
    public static final String RIVER = func("minecraft:river");
    @PythonFieldGenerated
    public static final String HELL = func("minecraft:hell");
    @PythonFieldGenerated
    public static final String SKY = func("minecraft:sky");
    @PythonFieldGenerated
    public static final String FROZEN_OCEAN = func("minecraft:frozen_ocean");
    @PythonFieldGenerated
    public static final String FROZEN_RIVER = func("minecraft:frozen_river");
    @PythonFieldGenerated
    public static final String ICE_FLATS = func("minecraft:ice_flats");
    @PythonFieldGenerated
    public static final String ICE_MOUNTAINS = func("minecraft:ice_mountains");
    @PythonFieldGenerated
    public static final String MUSHROOM_ISLAND = func("minecraft:mushroom_island");
    @PythonFieldGenerated
    public static final String MUSHROOM_ISLAND_SHORE = func("minecraft:mushroom_island_shore");
    @PythonFieldGenerated
    public static final String BEACHES = func("minecraft:beaches");
    @PythonFieldGenerated
    public static final String DESERT_HILLS = func("minecraft:desert_hills");
    @PythonFieldGenerated
    public static final String FOREST_HILLS = func("minecraft:forest_hills");
    @PythonFieldGenerated
    public static final String TAIGA_HILLS = func("minecraft:taiga_hills");
    @PythonFieldGenerated
    public static final String SMALLER_EXTREME_HILLS = func("minecraft:smaller_extreme_hills");
    @PythonFieldGenerated
    public static final String JUNGLE = func("minecraft:jungle");
    @PythonFieldGenerated
    public static final String JUNGLE_HILLS = func("minecraft:jungle_hills");
    @PythonFieldGenerated
    public static final String JUNGLE_EDGE = func("minecraft:jungle_edge");
    @PythonFieldGenerated
    public static final String DEEP_OCEAN = func("minecraft:deep_ocean");
    @PythonFieldGenerated
    public static final String STONE_BEACH = func("minecraft:stone_beach");
    @PythonFieldGenerated
    public static final String COLD_BEACH = func("minecraft:cold_beach");
    @PythonFieldGenerated
    public static final String BIRCH_FOREST = func("minecraft:birch_forest");
    @PythonFieldGenerated
    public static final String BIRCH_FOREST_HILLS = func("minecraft:birch_forest_hills");
    @PythonFieldGenerated
    public static final String ROOFED_FOREST = func("minecraft:roofed_forest");
    @PythonFieldGenerated
    public static final String TAIGA_COLD = func("minecraft:taiga_cold");
    @PythonFieldGenerated
    public static final String TAIGA_COLD_HILLS = func("minecraft:taiga_cold_hills");
    @PythonFieldGenerated
    public static final String REDWOOD_TAIGA = func("minecraft:redwood_taiga");
    @PythonFieldGenerated
    public static final String REDWOOD_TAIGA_HILLS = func("minecraft:redwood_taiga_hills");
    @PythonFieldGenerated
    public static final String EXTREME_HILLS_WITH_TREES = func("minecraft:extreme_hills_with_trees");
    @PythonFieldGenerated
    public static final String SAVANNA = func("minecraft:savanna");
    @PythonFieldGenerated
    public static final String SAVANNA_ROCK = func("minecraft:savanna_rock");
    @PythonFieldGenerated
    public static final String MESA = func("minecraft:mesa");
    @PythonFieldGenerated
    public static final String MESA_ROCK = func("minecraft:mesa_rock");
    @PythonFieldGenerated
    public static final String MESA_CLEAR_ROCK = func("minecraft:mesa_clear_rock");
    @PythonFieldGenerated
    public static final String VOID = func("minecraft:void");
    @PythonFieldGenerated
    public static final String MUTATED_PLAINS = func("minecraft:mutated_plains");
    @PythonFieldGenerated
    public static final String MUTATED_DESERT = func("minecraft:mutated_desert");
    @PythonFieldGenerated
    public static final String MUTATED_EXTREME_HILLS = func("minecraft:mutated_extreme_hills");
    @PythonFieldGenerated
    public static final String MUTATED_FOREST = func("minecraft:mutated_forest");
    @PythonFieldGenerated
    public static final String MUTATED_TAIGA = func("minecraft:mutated_taiga");
    @PythonFieldGenerated
    public static final String MUTATED_SWAMPLAND = func("minecraft:mutated_swampland");
    @PythonFieldGenerated
    public static final String MUTATED_ICE_FLATS = func("minecraft:mutated_ice_flats");
    @PythonFieldGenerated
    public static final String MUTATED_JUNGLE = func("minecraft:mutated_jungle");
    @PythonFieldGenerated
    public static final String MUTATED_JUNGLE_EDGE = func("minecraft:mutated_jungle_edge");
    @PythonFieldGenerated
    public static final String MUTATED_BIRCH_FOREST = func("minecraft:mutated_birch_forest");
    @PythonFieldGenerated
    public static final String MUTATED_BIRCH_FOREST_HILLS = func("minecraft:mutated_birch_forest_hills");
    @PythonFieldGenerated
    public static final String MUTATED_ROOFED_FOREST = func("minecraft:mutated_roofed_forest");
    @PythonFieldGenerated
    public static final String MUTATED_TAIGA_COLD = func("minecraft:mutated_taiga_cold");
    @PythonFieldGenerated
    public static final String MUTATED_REDWOOD_TAIGA = func("minecraft:mutated_redwood_taiga");
    @PythonFieldGenerated
    public static final String MUTATED_REDWOOD_TAIGA_HILLS = func("minecraft:mutated_redwood_taiga_hills");
    @PythonFieldGenerated
    public static final String MUTATED_EXTREME_HILLS_WITH_TREES = func("minecraft:mutated_extreme_hills_with_trees");
    @PythonFieldGenerated
    public static final String MUTATED_SAVANNA = func("minecraft:mutated_savanna");
    @PythonFieldGenerated
    public static final String MUTATED_SAVANNA_ROCK = func("minecraft:mutated_savanna_rock");
    @PythonFieldGenerated
    public static final String MUTATED_MESA = func("minecraft:mutated_mesa");
    @PythonFieldGenerated
    public static final String MUTATED_MESA_ROCK = func("minecraft:mutated_mesa_rock");
    @PythonFieldGenerated
    public static final String MUTATED_MESA_CLEAR_ROCK = func("minecraft:mutated_mesa_clear_rock");

    @PythonFunction
    @PythonDocString("Returns a list of all the vanilla Biomess.")
    public static PyList getAllBiomes() {
        return names;
    }

    private static String func(String s) {
        names.add(new PyString(s));
        return s;
    }
}