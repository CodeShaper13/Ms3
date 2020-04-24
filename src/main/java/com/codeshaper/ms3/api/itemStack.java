package com.codeshaper.ms3.api;

import java.util.Random;

import javax.annotation.Nullable;

import org.python.core.Py;
import org.python.core.PyBoolean;
import org.python.core.PyException;
import org.python.core.PyObject;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonConstructor;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.apiBuilder.annotation.PythonMoveToInit;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.util.Parser;
import com.codeshaper.ms3.util.Util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Wrapper class for {@link ItemStack}. The constructors should be used by the
 * api, so to create instances from Java, the
 * {@link itemStack#makeWrapper(ItemStack)} method should be used.
 * 
 * @author CodeShaper
 */
@PythonClass
@PythonMoveToInit
public class itemStack extends PyObject {

	private final ItemStack stack;

	// This confirms that python doesn't know the difference between an array and
	// varargs
	// https://bugs.jython.org/issue1393

	private itemStack(ItemStack stack) {
		this.stack = stack;
	}
	
	public itemStack(String identifier) {
		this(identifier, 1, 0);
	}

	public itemStack(String identifier, int count) {
		this(identifier, count, 0);
	}

	public itemStack(String identifier, int count, int meta) {
		this(identifier, count, meta, null);
	}

	// Only publicly reveal this one constructor
	@PythonConstructor
	@PythonDocString("Creates a new item stack.  The count, meta, and tag params are optional and default to 1, 0 and None respectively.")
	public itemStack(String identifier, int count, int meta, String tag) {
		Item item;

		// Item
		item = Item.getByNameOrId(identifier);
		if (item == null) {
			throw Py.ValueError("Unknown item identifier " + identifier);
		}

		// NBT
		NBTTagCompound nbt = null;
		if(tag != null) {
			try {
				System.out.println(tag);
				nbt = JsonToNBT.getTagFromJson(tag);
			} catch (NBTException e) {
				throw Py.ValueError("Error parsing JSON\n" + e.getMessage());
			}
		}	

		this.stack = new ItemStack(item, count, meta);
		if(nbt != null) {
			this.stack.setTagCompound(nbt);
		}
	}

	/**
	 * Creates a wrapper class for the passed item stack. If an empty item stack is
	 * passed, {@link ItemStack#EMPTY}, None is returned, the API version of an
	 * empty slot/no item.
	 * 
	 * @param stack The item stack to make a wrapper of.
	 * @return The new wrapper class.
	 */
	@Nullable
	public static itemStack makeWrapper(@Nullable ItemStack stack) {
		if (stack == null || stack == ItemStack.EMPTY) {
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
	public void setCount(int count) throws PyException {
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
	@PythonDocString("Splits this stack in two, pulling off the passed amount of Items into a new Stack.  The new stack is then returned.")
	public itemStack split(int amount) {
		return itemStack.makeWrapper(this.stack.splitStack(amount));
	}

	@PythonFunction
	@PythonDocString("Creates a copy of the Item Stack and returns it.")
	public itemStack copy() {
		return itemStack.makeWrapper(this.stack.copy());
	}

	@PythonFunction
	@PythonDocString("Returns the display name of the Item Stack as a string.  If no custom name was set, the default name is returned.")
	public String getDisplayName() {
		return this.stack.getDisplayName();
	}

	@PythonFunction
	@PythonDocString("Sets the Item Stack's display name.  Pass None to reset it.")
	public void setDisplayName(String name) {
		if (name == null) {
			this.stack.clearCustomName();
		} else {
			this.stack.setStackDisplayName(name);
		}
	}

	@PythonFunction
	@PythonDocString("Adds an enchantment to the Item Stack.  See enchantments.py for enchantment identifier constants.")
	public void addEnchantment(String enchantmentIdentifier, int level) {
		this.stack.addEnchantment(Enchantment.getEnchantmentByLocation(enchantmentIdentifier), level);
	}

	@PythonFunction
	@PythonDocString("Damages the Item and returns the Item Stack, or None if the Item's curability was consumed.  If applyEnchantmentEffects is True and the item has unbreaking, damage may be neglected.")
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

	/**
	 * Returns the item stack as an instance of
	 * {@link net.minecraft.item.ItemStack}.
	 * 
	 * @return
	 */
	public ItemStack getMcStack() {
		return this.stack;
	}

	@Override
	public PyObject __eq__(PyObject other) {
		if (other instanceof itemStack) {
			itemStack otherStack = (itemStack) other;
			return new PyBoolean(otherStack.stack.equals(this.stack));
		} else {
			return Py.False;
		}
	}

	@Override
	public PyObject __ne__(PyObject other) {
		return Util.pyNotHelper(this.__eq__(other));
	}
}
