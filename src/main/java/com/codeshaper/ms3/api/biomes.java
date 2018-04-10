package com.codeshaper.ms3.api;

import org.python.core.PyString;
import org.python.core.PyList;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonClass
@PythonDocString("A list of all the vanilla Biome names.")
public class biomes {

    private static PyList names = new PyList();

    private biomes() { }

    @PythonField
    public static final String OCEAN = func("minecraft:ocean");
    @PythonField
    public static final String PLAINS = func("minecraft:plains");
    @PythonField
    public static final String DESERT = func("minecraft:desert");
    @PythonField
    public static final String EXTREME_HILLS = func("minecraft:extreme_hills");
    @PythonField
    public static final String FOREST = func("minecraft:forest");
    @PythonField
    public static final String TAIGA = func("minecraft:taiga");
    @PythonField
    public static final String SWAMPLAND = func("minecraft:swampland");
    @PythonField
    public static final String RIVER = func("minecraft:river");
    @PythonField
    public static final String HELL = func("minecraft:hell");
    @PythonField
    public static final String SKY = func("minecraft:sky");
    @PythonField
    public static final String FROZEN_OCEAN = func("minecraft:frozen_ocean");
    @PythonField
    public static final String FROZEN_RIVER = func("minecraft:frozen_river");
    @PythonField
    public static final String ICE_FLATS = func("minecraft:ice_flats");
    @PythonField
    public static final String ICE_MOUNTAINS = func("minecraft:ice_mountains");
    @PythonField
    public static final String MUSHROOM_ISLAND = func("minecraft:mushroom_island");
    @PythonField
    public static final String MUSHROOM_ISLAND_SHORE = func("minecraft:mushroom_island_shore");
    @PythonField
    public static final String BEACHES = func("minecraft:beaches");
    @PythonField
    public static final String DESERT_HILLS = func("minecraft:desert_hills");
    @PythonField
    public static final String FOREST_HILLS = func("minecraft:forest_hills");
    @PythonField
    public static final String TAIGA_HILLS = func("minecraft:taiga_hills");
    @PythonField
    public static final String SMALLER_EXTREME_HILLS = func("minecraft:smaller_extreme_hills");
    @PythonField
    public static final String JUNGLE = func("minecraft:jungle");
    @PythonField
    public static final String JUNGLE_HILLS = func("minecraft:jungle_hills");
    @PythonField
    public static final String JUNGLE_EDGE = func("minecraft:jungle_edge");
    @PythonField
    public static final String DEEP_OCEAN = func("minecraft:deep_ocean");
    @PythonField
    public static final String STONE_BEACH = func("minecraft:stone_beach");
    @PythonField
    public static final String COLD_BEACH = func("minecraft:cold_beach");
    @PythonField
    public static final String BIRCH_FOREST = func("minecraft:birch_forest");
    @PythonField
    public static final String BIRCH_FOREST_HILLS = func("minecraft:birch_forest_hills");
    @PythonField
    public static final String ROOFED_FOREST = func("minecraft:roofed_forest");
    @PythonField
    public static final String TAIGA_COLD = func("minecraft:taiga_cold");
    @PythonField
    public static final String TAIGA_COLD_HILLS = func("minecraft:taiga_cold_hills");
    @PythonField
    public static final String REDWOOD_TAIGA = func("minecraft:redwood_taiga");
    @PythonField
    public static final String REDWOOD_TAIGA_HILLS = func("minecraft:redwood_taiga_hills");
    @PythonField
    public static final String EXTREME_HILLS_WITH_TREES = func("minecraft:extreme_hills_with_trees");
    @PythonField
    public static final String SAVANNA = func("minecraft:savanna");
    @PythonField
    public static final String SAVANNA_ROCK = func("minecraft:savanna_rock");
    @PythonField
    public static final String MESA = func("minecraft:mesa");
    @PythonField
    public static final String MESA_ROCK = func("minecraft:mesa_rock");
    @PythonField
    public static final String MESA_CLEAR_ROCK = func("minecraft:mesa_clear_rock");
    @PythonField
    public static final String VOID = func("minecraft:void");
    @PythonField
    public static final String MUTATED_PLAINS = func("minecraft:mutated_plains");
    @PythonField
    public static final String MUTATED_DESERT = func("minecraft:mutated_desert");
    @PythonField
    public static final String MUTATED_EXTREME_HILLS = func("minecraft:mutated_extreme_hills");
    @PythonField
    public static final String MUTATED_FOREST = func("minecraft:mutated_forest");
    @PythonField
    public static final String MUTATED_TAIGA = func("minecraft:mutated_taiga");
    @PythonField
    public static final String MUTATED_SWAMPLAND = func("minecraft:mutated_swampland");
    @PythonField
    public static final String MUTATED_ICE_FLATS = func("minecraft:mutated_ice_flats");
    @PythonField
    public static final String MUTATED_JUNGLE = func("minecraft:mutated_jungle");
    @PythonField
    public static final String MUTATED_JUNGLE_EDGE = func("minecraft:mutated_jungle_edge");
    @PythonField
    public static final String MUTATED_BIRCH_FOREST = func("minecraft:mutated_birch_forest");
    @PythonField
    public static final String MUTATED_BIRCH_FOREST_HILLS = func("minecraft:mutated_birch_forest_hills");
    @PythonField
    public static final String MUTATED_ROOFED_FOREST = func("minecraft:mutated_roofed_forest");
    @PythonField
    public static final String MUTATED_TAIGA_COLD = func("minecraft:mutated_taiga_cold");
    @PythonField
    public static final String MUTATED_REDWOOD_TAIGA = func("minecraft:mutated_redwood_taiga");
    @PythonField
    public static final String MUTATED_REDWOOD_TAIGA_HILLS = func("minecraft:mutated_redwood_taiga_hills");
    @PythonField
    public static final String MUTATED_EXTREME_HILLS_WITH_TREES = func("minecraft:mutated_extreme_hills_with_trees");
    @PythonField
    public static final String MUTATED_SAVANNA = func("minecraft:mutated_savanna");
    @PythonField
    public static final String MUTATED_SAVANNA_ROCK = func("minecraft:mutated_savanna_rock");
    @PythonField
    public static final String MUTATED_MESA = func("minecraft:mutated_mesa");
    @PythonField
    public static final String MUTATED_MESA_ROCK = func("minecraft:mutated_mesa_rock");
    @PythonField
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