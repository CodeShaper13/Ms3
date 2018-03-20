package com.codeshaper.ms3.proxy;

import com.codeshaper.ms3.capability.BoundScript;
import com.codeshaper.ms3.capability.BoundScriptStorage;
import com.codeshaper.ms3.capability.IBoundScript;

import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;

/**
 * Server side proxy.
 */
public class ProxyCommon {

	public void init() {
		CapabilityManager.INSTANCE.register(IBoundScript.class, new BoundScriptStorage(), BoundScript.class);
	}

	public void registerItemRenderer(Item item, int meta, String id) {
		throw new Error("Can't be called on server side!");
	}
}