package com.codeshaper.ms3.api;

import org.python.core.PyString;
import org.python.core.PyList;

import com.codeshaper.ms3.api.tileEntity.Beacon;
import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

@PythonClass
@PythonDocString("String constants for all of the biome names.")
public class biomes {

	private biomes() {
	}

	@PythonFieldGenerated
	public static final String OCEAN = getRegName(Biomes.OCEAN);
	@PythonFieldGenerated
	public static final String PLAINS = getRegName(Biomes.PLAINS);
	@PythonFieldGenerated
	public static final String DESERT = getRegName(Biomes.DESERT);
	@PythonFieldGenerated
	public static final String EXTREME_HILLS = getRegName(Biomes.EXTREME_HILLS);
	@PythonFieldGenerated
	public static final String FOREST = getRegName(Biomes.FOREST);
	@PythonFieldGenerated
	public static final String TAIGA = getRegName(Biomes.TAIGA);
	@PythonFieldGenerated
	public static final String SWAMPLAND = getRegName(Biomes.SWAMPLAND);
	@PythonFieldGenerated
	public static final String RIVER = getRegName(Biomes.RIVER);
	@PythonFieldGenerated
	public static final String HELL = getRegName(Biomes.HELL);
	@PythonFieldGenerated
	public static final String SKY = getRegName(Biomes.SKY);
	@PythonFieldGenerated
	public static final String FROZEN_OCEAN = getRegName(Biomes.FROZEN_OCEAN);
	@PythonFieldGenerated
	public static final String FROZEN_RIVER = getRegName(Biomes.FROZEN_RIVER);
	@PythonFieldGenerated
	public static final String ICE_FLATS = getRegName(Biomes.MUTATED_ICE_FLATS);
	@PythonFieldGenerated
	public static final String ICE_MOUNTAINS = getRegName(Biomes.ICE_MOUNTAINS);
	@PythonFieldGenerated
	public static final String MUSHROOM_ISLAND = getRegName(Biomes.MUSHROOM_ISLAND);
	@PythonFieldGenerated
	public static final String MUSHROOM_ISLAND_SHORE = getRegName(Biomes.MUSHROOM_ISLAND_SHORE);
	@PythonFieldGenerated
	public static final String BEACHE = getRegName(Biomes.BEACH);
	@PythonFieldGenerated
	public static final String DESERT_HILLS = getRegName(Biomes.DESERT_HILLS);
	@PythonFieldGenerated
	public static final String FOREST_HILLS = getRegName(Biomes.FOREST_HILLS);
	@PythonFieldGenerated
	public static final String TAIGA_HILLS = getRegName(Biomes.TAIGA_HILLS);
	@PythonFieldGenerated
	public static final String SMALLER_EXTREME_HILLS = getRegName(Biomes.EXTREME_HILLS_EDGE);
	@PythonFieldGenerated
	public static final String JUNGLE = getRegName(Biomes.JUNGLE);
	@PythonFieldGenerated
	public static final String JUNGLE_HILLS = getRegName(Biomes.JUNGLE_HILLS);
	@PythonFieldGenerated
	public static final String JUNGLE_EDGE = getRegName(Biomes.JUNGLE_HILLS);
	@PythonFieldGenerated
	public static final String DEEP_OCEAN = getRegName(Biomes.DEEP_OCEAN);
	@PythonFieldGenerated
	public static final String STONE_BEACH = getRegName(Biomes.STONE_BEACH);
	@PythonFieldGenerated
	public static final String COLD_BEACH = getRegName(Biomes.COLD_BEACH);
	@PythonFieldGenerated
	public static final String BIRCH_FOREST = getRegName(Biomes.BIRCH_FOREST);
	@PythonFieldGenerated
	public static final String BIRCH_FOREST_HILLS = getRegName(Biomes.BIRCH_FOREST_HILLS);
	@PythonFieldGenerated
	public static final String ROOFED_FOREST = getRegName(Biomes.ROOFED_FOREST);
	@PythonFieldGenerated
	public static final String TAIGA_COLD = getRegName(Biomes.COLD_TAIGA);
	@PythonFieldGenerated
	public static final String TAIGA_COLD_HILLS = getRegName(Biomes.COLD_TAIGA_HILLS);
	@PythonFieldGenerated
	public static final String REDWOOD_TAIGA = getRegName(Biomes.REDWOOD_TAIGA);
	@PythonFieldGenerated
	public static final String REDWOOD_TAIGA_HILLS = getRegName(Biomes.REDWOOD_TAIGA_HILLS);
	@PythonFieldGenerated
	public static final String EXTREME_HILLS_WITH_TREES = getRegName(Biomes.EXTREME_HILLS_WITH_TREES);
	@PythonFieldGenerated
	public static final String SAVANNA = getRegName(Biomes.SAVANNA);
	@PythonFieldGenerated
	public static final String SAVANNA_PLATEAU = getRegName(Biomes.SAVANNA_PLATEAU);
	@PythonFieldGenerated
	public static final String MESA = getRegName(Biomes.MESA);
	@PythonFieldGenerated
	public static final String MESA_ROCK = getRegName(Biomes.MUTATED_MESA_ROCK);
	@PythonFieldGenerated
	public static final String MESA_CLEAR_ROCK = getRegName(Biomes.MUTATED_MESA_CLEAR_ROCK);
	@PythonFieldGenerated
	public static final String VOID = getRegName(Biomes.VOID);
	@PythonFieldGenerated
	public static final String MUTATED_PLAINS = getRegName(Biomes.MUTATED_PLAINS);
	@PythonFieldGenerated
	public static final String MUTATED_DESERT = getRegName(Biomes.MUTATED_DESERT);
	@PythonFieldGenerated
	public static final String MUTATED_EXTREME_HILLS = getRegName(Biomes.MUTATED_EXTREME_HILLS);
	@PythonFieldGenerated
	public static final String MUTATED_FOREST = getRegName(Biomes.MUTATED_FOREST);
	@PythonFieldGenerated
	public static final String MUTATED_TAIGA = getRegName(Biomes.MUTATED_TAIGA);
	@PythonFieldGenerated
	public static final String MUTATED_SWAMPLAND = getRegName(Biomes.MUTATED_SWAMPLAND);
	@PythonFieldGenerated
	public static final String MUTATED_ICE_FLATS = getRegName(Biomes.MUTATED_ICE_FLATS);
	@PythonFieldGenerated
	public static final String MUTATED_JUNGLE = getRegName(Biomes.MUTATED_JUNGLE);
	@PythonFieldGenerated
	public static final String MUTATED_JUNGLE_EDGE = getRegName(Biomes.MUTATED_JUNGLE_EDGE);
	@PythonFieldGenerated
	public static final String MUTATED_BIRCH_FOREST = getRegName(Biomes.MUTATED_BIRCH_FOREST);
	@PythonFieldGenerated
	public static final String MUTATED_BIRCH_FOREST_HILLS = getRegName(Biomes.MUTATED_BIRCH_FOREST_HILLS);
	@PythonFieldGenerated
	public static final String MUTATED_ROOFED_FOREST = getRegName(Biomes.MUTATED_ROOFED_FOREST);
	@PythonFieldGenerated
	public static final String MUTATED_TAIGA_COLD = getRegName(Biomes.MUTATED_TAIGA_COLD);
	@PythonFieldGenerated
	public static final String MUTATED_REDWOOD_TAIGA = getRegName(Biomes.MUTATED_REDWOOD_TAIGA);
	@PythonFieldGenerated
	public static final String MUTATED_REDWOOD_TAIGA_HILLS = getRegName(Biomes.MUTATED_REDWOOD_TAIGA_HILLS);
	@PythonFieldGenerated
	public static final String MUTATED_EXTREME_HILLS_WITH_TREES = getRegName(Biomes.MUTATED_EXTREME_HILLS_WITH_TREES);
	@PythonFieldGenerated
	public static final String MUTATED_SAVANNA = getRegName(Biomes.MUTATED_SAVANNA);
	@PythonFieldGenerated
	public static final String MUTATED_SAVANNA_ROCK = getRegName(Biomes.MUTATED_SAVANNA_ROCK);
	@PythonFieldGenerated
	public static final String MUTATED_MESA = getRegName(Biomes.MUTATED_MESA);
	@PythonFieldGenerated
	public static final String MUTATED_MESA_ROCK = getRegName(Biomes.MUTATED_MESA_ROCK);
	@PythonFieldGenerated
	public static final String MUTATED_MESA_CLEAR_ROCK = getRegName(Biomes.MUTATED_MESA_CLEAR_ROCK);

	@PythonFunction
	@PythonDocString("Returns a list of all the biome names.  This will include mod biomes that were registered correctly.")
	public static PyList getAllBiomes() {
		return biomes.getAllBiomes(true);
	}

	@PythonFunction
	@PythonDocString("Returns a list of all the vanilla biome names.")
	public static PyList getAllVanillaBiomes() {
		return biomes.getAllBiomes(false);
	}

	private static PyList getAllBiomes(boolean includeModBiomes) {
		PyList list = new PyList();
		for (ResourceLocation rl : Biome.REGISTRY.getKeys()) {
			if (includeModBiomes || rl.getResourceDomain().equals("minecraft")) {
				list.add(rl.toString());
			}
		}
		return list;
	}

	private static String getRegName(Biome biome) {
		return biome.getRegistryName().toString();
	}
}