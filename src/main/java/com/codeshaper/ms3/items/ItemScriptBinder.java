package com.codeshaper.ms3.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemScriptBinder extends Item {

	public String registryName;

	public ItemScriptBinder(String name) {
		super();

		this.registryName = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setMaxStackSize(1);
	}

	/**
	 * Returns true if this item has an enchantment glint. By default, this returns
	 * <code>stack.isItemEnchanted()</code>, but other items can override it (for
	 * instance, written books always return true).
	 * 
	 * Note that if you override this method, you generally want to also call the
	 * super version (on {@link Item}) to get the glint for enchanted items. Of
	 * course, that is unnecessary if the overwritten version always returns true.
	 */
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Run the /bindscript command to use this item.");
	}
}