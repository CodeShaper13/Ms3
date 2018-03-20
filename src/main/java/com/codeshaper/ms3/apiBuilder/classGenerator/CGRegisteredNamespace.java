package com.codeshaper.ms3.apiBuilder.classGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.text.WordUtils;
import org.python.core.PyTuple;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class CGRegisteredNamespace extends CGBase {

	private RegistryNamespaced<ResourceLocation, IForgeRegistryEntry.Impl> registryNamespace;

	public CGRegisteredNamespace(RegistryNamespaced rn) {
		this.registryNamespace = rn;
	}

	@Override
	public void addFields(String name) {
		this.setGetAllDocString("Returns a list of all the vanilla " + WordUtils.capitalize(name) + "s.");
		
		String path, s1, upperPath;
		for (ResourceLocation location : this.registryNamespace.getKeys()) {
			path = location.getResourcePath();
			s1 = location.getResourceDomain() + ":" + path;
			upperPath = path.toUpperCase();
			this.addField(upperPath, s1, null);
		}
	}
}
