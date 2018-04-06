package com.codeshaper.ms3.proxy;

import com.codeshaper.ms3.Ms3;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Client side proxy.
 */
public class ProxyClient extends ProxyCommon {

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(Ms3.MOD_ID + ":" + id, "inventory"));
	}
}
