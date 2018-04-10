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

	@PythonFunction
	@PythonDocString("Converts a tuple like (item_name/item_id, [optional]amount, [optional]meta) into a net.minecraft.item.ItemStack")
	public static ItemStack itemStackFromTuple(PyTuple tuple) {
		int i = tuple.size();

		String id;
		Object obj = tuple.get(0);
		if (obj instanceof String) {
			id = (String) obj;
		} else if (obj instanceof Number) {
			id = Integer.toString((int) tuple.get(0));
		} else {
			throw Py.ValueError("Item identifier is of an unknown type, " + obj.getClass().toString());
		}

		int amount = i > 1 ? (int) tuple.get(1) : 1;
		int meta = i > 2 ? (int) tuple.get(2) : 0;
		NBTTagCompound tag = null;
		try {
			tag = i > 3 ? JsonToNBT.getTagFromJson((String) tuple.get(3)) : null;
		} catch (NBTException e) {
			e.printStackTrace();
			throw Py.ValueError("Error parsing JSON.  See stack trace!");
		}
		
		ItemStack stack = new ItemStack(Item.getByNameOrId(id), amount, meta);
		if(tag != null) {
			stack.setTagCompound(tag);
		}

		return stack;
	}

	public static PyTuple tupleFromItemStack(ItemStack stack) {
		if (stack == ItemStack.EMPTY) {
			return null;
		} else {
			return new PyTuple(new PyString(stack.getItem().getRegistryName().toString()),
					new PyInteger(stack.getCount()), new PyInteger(stack.getMetadata()));
		}
	}
}
