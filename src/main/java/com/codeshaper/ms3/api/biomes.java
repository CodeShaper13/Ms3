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

    @PythonField("minecraft:ocean")
    public static final String OCEAN = func("minecraft:ocean");
    @PythonField("minecraft:plains")
    public static final String PLAINS = func("minecraft:plains");
    @PythonField("minecraft:desert")
    public static final String DESERT = func("minecraft:desert");
    @PythonField("minecraft:extreme_hills")
    public static final String EXTREME_HILLS = func("minecraft:extreme_hills");
    @PythonField("minecraft:forest")
    public static final String FOREST = func("minecraft:forest");
    @PythonField("minecraft:taiga")
    public static final String TAIGA = func("minecraft:taiga");
    @PythonField("minecraft:swampland")
    public static final String SWAMPLAND = func("minecraft:swampland");
    @PythonField("minecraft:river")
    public static final String RIVER = func("minecraft:river");
    @PythonField("minecraft:hell")
    public static final String HELL = func("minecraft:hell");
    @PythonField("minecraft:sky")
    public static final String SKY = func("minecraft:sky");
    @PythonField("minecraft:frozen_ocean")
    public static final String FROZEN_OCEAN = func("minecraft:frozen_ocean");
    @PythonField("minecraft:frozen_river")
    public static final String FROZEN_RIVER = func("minecraft:frozen_river");
    @PythonField("minecraft:ice_flats")
    public static final String ICE_FLATS = func("minecraft:ice_flats");
    @PythonField("minecraft:ice_mountains")
    public static final String ICE_MOUNTAINS = func("minecraft:ice_mountains");
    @PythonField("minecraft:mushroom_island")
    public static final String MUSHROOM_ISLAND = func("minecraft:mushroom_island");
    @PythonField("minecraft:mushroom_island_shore")
    public static final String MUSHROOM_ISLAND_SHORE = func("minecraft:mushroom_island_shore");
    @PythonField("minecraft:beaches")
    public static final String BEACHES = func("minecraft:beaches");
    @PythonField("minecraft:desert_hills")
    public static final String DESERT_HILLS = func("minecraft:desert_hills");
    @PythonField("minecraft:forest_hills")
    public static final String FOREST_HILLS = func("minecraft:forest_hills");
    @PythonField("minecraft:taiga_hills")
    public static final String TAIGA_HILLS = func("minecraft:taiga_hills");
    @PythonField("minecraft:smaller_extreme_hills")
    public static final String SMALLER_EXTREME_HILLS = func("minecraft:smaller_extreme_hills");
    @PythonField("minecraft:jungle")
    public static final String JUNGLE = func("minecraft:jungle");
    @PythonField("minecraft:jungle_hills")
    public static final String JUNGLE_HILLS = func("minecraft:jungle_hills");
    @PythonField("minecraft:jungle_edge")
    public static final String JUNGLE_EDGE = func("minecraft:jungle_edge");
    @PythonField("minecraft:deep_ocean")
    public static final String DEEP_OCEAN = func("minecraft:deep_ocean");
    @PythonField("minecraft:stone_beach")
    public static final String STONE_BEACH = func("minecraft:stone_beach");
    @PythonField("minecraft:cold_beach")
    public static final String COLD_BEACH = func("minecraft:cold_beach");
    @PythonField("minecraft:birch_forest")
    public static final String BIRCH_FOREST = func("minecraft:birch_forest");
    @PythonField("minecraft:birch_forest_hills")
    public static final String BIRCH_FOREST_HILLS = func("minecraft:birch_forest_hills");
    @PythonField("minecraft:roofed_forest")
    public static final String ROOFED_FOREST = func("minecraft:roofed_forest");
    @PythonField("minecraft:taiga_cold")
    public static final String TAIGA_COLD = func("minecraft:taiga_cold");
    @PythonField("minecraft:taiga_cold_hills")
    public static final String TAIGA_COLD_HILLS = func("minecraft:taiga_cold_hills");
    @PythonField("minecraft:redwood_taiga")
    public static final String REDWOOD_TAIGA = func("minecraft:redwood_taiga");
    @PythonField("minecraft:redwood_taiga_hills")
    public static final String REDWOOD_TAIGA_HILLS = func("minecraft:redwood_taiga_hills");
    @PythonField("minecraft:extreme_hills_with_trees")
    public static final String EXTREME_HILLS_WITH_TREES = func("minecraft:extreme_hills_with_trees");
    @PythonField("minecraft:savanna")
    public static final String SAVANNA = func("minecraft:savanna");
    @PythonField("minecraft:savanna_rock")
    public static final String SAVANNA_ROCK = func("minecraft:savanna_rock");
    @PythonField("minecraft:mesa")
    public static final String MESA = func("minecraft:mesa");
    @PythonField("minecraft:mesa_rock")
    public static final String MESA_ROCK = func("minecraft:mesa_rock");
    @PythonField("minecraft:mesa_clear_rock")
    public static final String MESA_CLEAR_ROCK = func("minecraft:mesa_clear_rock");
    @PythonField("minecraft:void")
    public static final String VOID = func("minecraft:void");
    @PythonField("minecraft:mutated_plains")
    public static final String MUTATED_PLAINS = func("minecraft:mutated_plains");
    @PythonField("minecraft:mutated_desert")
    public static final String MUTATED_DESERT = func("minecraft:mutated_desert");
    @PythonField("minecraft:mutated_extreme_hills")
    public static final String MUTATED_EXTREME_HILLS = func("minecraft:mutated_extreme_hills");
    @PythonField("minecraft:mutated_forest")
    public static final String MUTATED_FOREST = func("minecraft:mutated_forest");
    @PythonField("minecraft:mutated_taiga")
    public static final String MUTATED_TAIGA = func("minecraft:mutated_taiga");
    @PythonField("minecraft:mutated_swampland")
    public static final String MUTATED_SWAMPLAND = func("minecraft:mutated_swampland");
    @PythonField("minecraft:mutated_ice_flats")
    public static final String MUTATED_ICE_FLATS = func("minecraft:mutated_ice_flats");
    @PythonField("minecraft:mutated_jungle")
    public static final String MUTATED_JUNGLE = func("minecraft:mutated_jungle");
    @PythonField("minecraft:mutated_jungle_edge")
    public static final String MUTATED_JUNGLE_EDGE = func("minecraft:mutated_jungle_edge");
    @PythonField("minecraft:mutated_birch_forest")
    public static final String MUTATED_BIRCH_FOREST = func("minecraft:mutated_birch_forest");
    @PythonField("minecraft:mutated_birch_forest_hills")
    public static final String MUTATED_BIRCH_FOREST_HILLS = func("minecraft:mutated_birch_forest_hills");
    @PythonField("minecraft:mutated_roofed_forest")
    public static final String MUTATED_ROOFED_FOREST = func("minecraft:mutated_roofed_forest");
    @PythonField("minecraft:mutated_taiga_cold")
    public static final String MUTATED_TAIGA_COLD = func("minecraft:mutated_taiga_cold");
    @PythonField("minecraft:mutated_redwood_taiga")
    public static final String MUTATED_REDWOOD_TAIGA = func("minecraft:mutated_redwood_taiga");
    @PythonField("minecraft:mutated_redwood_taiga_hills")
    public static final String MUTATED_REDWOOD_TAIGA_HILLS = func("minecraft:mutated_redwood_taiga_hills");
    @PythonField("minecraft:mutated_extreme_hills_with_trees")
    public static final String MUTATED_EXTREME_HILLS_WITH_TREES = func("minecraft:mutated_extreme_hills_with_trees");
    @PythonField("minecraft:mutated_savanna")
    public static final String MUTATED_SAVANNA = func("minecraft:mutated_savanna");
    @PythonField("minecraft:mutated_savanna_rock")
    public static final String MUTATED_SAVANNA_ROCK = func("minecraft:mutated_savanna_rock");
    @PythonField("minecraft:mutated_mesa")
    public static final String MUTATED_MESA = func("minecraft:mutated_mesa");
    @PythonField("minecraft:mutated_mesa_rock")
    public static final String MUTATED_MESA_ROCK = func("minecraft:mutated_mesa_rock");
    @PythonField("minecraft:mutated_mesa_clear_rock")
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