package com.codeshaper.ms3.proxy;

import com.codeshaper.ms3.capability.EntityMs3Data;
import com.codeshaper.ms3.capability.EntityMs3DataStorage;
import com.codeshaper.ms3.capability.IEntityMs3Data;

import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;

/**
 * Server side proxy.
 * 
 * @author CodeShaper
 */
public class ProxyCommon {

	public void init() {
		CapabilityManager.INSTANCE.register(IEntityMs3Data.class, new EntityMs3DataStorage(), EntityMs3Data::new);
	}

	public void registerItemRenderer(Item item, int meta, String id) {
		throw new Error("Can't be called on server side!");
	}
}