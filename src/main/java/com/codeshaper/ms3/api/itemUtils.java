package com.codeshaper.ms3.api;

import org.python.core.Py;
import org.python.core.PyInteger;
import org.python.core.PyString;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;

@PythonDocString("Utility features for items.")
public class itemUtils {

	private itemUtils() {
	}
	
	@PythonFunction
	@PythonDocString("Returns an instance of net.minecraft.item.Item corresponding with the passed name.")
	public static Item getMcItemFromName(String name) {
		Item item = Item.getByNameOrId(name);
		if(item == null) {
			throw Py.ValueError("Item with name " + name + " could not be found");
		}
		return item;
	}


	@PythonFunction
	@PythonDocString("Returns an Item's id from it's name.")
	public static int getIdFromName(String name) {
		return Item.getIdFromItem(Item.getByNameOrId(name));
	}
}
