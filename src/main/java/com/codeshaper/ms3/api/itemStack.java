package com.codeshaper.ms3.api;

import java.util.Random;

import javax.annotation.Nullable;

import org.python.core.Py;
import org.python.core.PyBoolean;
import org.python.core.PyObject;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonConstructor;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.apiBuilder.annotation.PythonInit;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.util.Util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;

@PythonClass
@PythonInit
//TODO ctor doc strings
public class itemStack extends PyObject {

	private static final long serialVersionUID = -1784931985189272310L;

	private final ItemStack stack;

	@PythonConstructor
	public itemStack(Item item, int count) {
		this(item, count, 1);
	}

	@PythonConstructor
	public itemStack(String item, int count) {
		this(item, count, 1);
	}

	@PythonConstructor
	public itemStack(Item item, int count, int meta) {
		this(item, count, meta, null);
	}

	@PythonConstructor
	public itemStack(String item, int count, int meta) {
		this(item, count, meta, null);
	}

	@PythonConstructor
	public itemStack(Item item, int count, int meta, @Nullable String nbt) {
		this(new ItemStack(item, count, meta));

		try {
			NBTTagCompound tag = nbt != null ? JsonToNBT.getTagFromJson(nbt) : null;
			this.stack.setTagCompound(tag);
		} catch (NBTException e) {
			e.printStackTrace();
			throw Py.ValueError("Error parsing JSON.  See stack trace");
		}
	}

	@PythonConstructor
	public itemStack(String item, int count, int meta, @Nullable String nbt) {
		this(itemUtils.getMcItemFromName(item), count, meta, nbt);
	}

	@PythonConstructor
	public itemStack(ItemStack stack) {
		this.stack = stack;
		this.setCount(stack.getCount()); // Throws exception if count is invalid.
	}
	
	/**
	 * Instantiates a new itemStack and returns it, or null if the passed stack is empty.
	 */
	public static itemStack make(ItemStack stack) {
		if(stack == ItemStack.EMPTY) {
			return null;
		} else {
			return new itemStack(stack);
		}
	}

	@PythonFunction
	@PythonDocString("Returns the Item's string identifier.")
	public String getItem() {
		return this.stack.getItem().getRegistryName().toString();
	}

	@PythonFunction
	@PythonDocString("Returns the number of Items in the Stack as an integer")
	public int getCount() {
		return this.stack.getCount();
	}

	@PythonFunction
	@PythonDocString("Sets the size of the Item Stack.  count must be an number greater than 0.")
	public void setCount(int count) {
		if (count <= 0) {
			throw Py.ValueError("Stack size must be greater than 0, it was " + count);
		}
		this.stack.setCount(count);
	}

	@PythonFunction
	@PythonDocString("Returns the meta of the Item Stack as an integer.")
	public int getMeta() {
		return this.stack.getMetadata();
	}

	@PythonFunction
	@PythonDocString("Splits this stack in two, pulling off the passed amount of Items into a new Stack before returning it.")
	public void spilt(int amount) {
		this.stack.splitStack(amount);
	}

	@PythonFunction
	@PythonDocString("Creates a deep copy of the Item Stack and returns it.")
	public itemStack copy() {
		return new itemStack(this.stack.copy());
	}

	@PythonFunction
	@PythonDocString("Returns the display name of the Item Stack as a string.  If no custom name was set, the default name is returned.")
	public String getDisplayName() {
		return this.stack.getDisplayName();
	}

	@PythonFunction
	@PythonDocString("Sets the Item Stack's dispaly name.  Pass None to reset it.")
	public void setDisplayName(String name) {
		if (name == null) {
			this.stack.clearCustomName();
		} else {
			this.stack.setStackDisplayName(name);
		}
	}

	@PythonFunction
	@PythonDocString("Adds an enchantment to the Item Stack.  enchantmentIdentifier can be a numerical id or string.")
	public void addEnchantment(@PythonTypeExclude Object enchantmentIdentifier, int level) {
		this.stack.addEnchantment(enchantments.getMcEnchantmentObj(enchantmentIdentifier), level);
	}

	@PythonFunction
	@PythonDocString("Damaged the Item and returns the Item Stack, or None if the Item's curability was consumed.  If applyEnchantmentEffects is True and the item has unbreaking, damage may be neglected.")
	public itemStack damageItem(int amount, boolean applyEnchantmentEffects) {
		if (this.stack.isItemStackDamageable()) {
			if (applyEnchantmentEffects) {
				this.stack.attemptDamageItem(amount, new Random(), null);
			} else {
				this.stack.setItemDamage(this.stack.getItemDamage() + amount);
			}
		}

		if (this.stack.getItemDamage() <= 0) {
			return null;
		} else {
			return this;
		}
	}

	public ItemStack getMcStack() {
		return this.stack;
	}

	@Override
	public PyObject __eq__(PyObject other) {
		if (other instanceof itemStack) {
			return new PyBoolean(((itemStack) other).stack.equals(this.stack));
		} else {
			return Py.False;
		}
	}

	@Override
	public PyObject __ne__(PyObject other) {
		return Util.pyNotHelper(this.__eq__(other));
	}
}
