package com.codeshaper.ms3.util;

import java.util.Arrays;

import javax.annotation.Nullable;

import org.python.core.PyList;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.nbt.NBTTagString;

/**
 * Helper class for working with NBT objects.
 */
public class NbtHelper {

	public static NBTBase objToNbt(Object obj) {
		if (obj instanceof Byte || obj == null) {
			return new NBTTagByte(obj == null ? 2 : ((Byte) obj));
		} else if (obj instanceof Short) {
			return new NBTTagShort((Short) obj);
		} else if (obj instanceof Integer) {
			return new NBTTagInt((Integer) obj);
		} else if (obj instanceof Long) {
			return new NBTTagLong((Long) obj);
		} else if (obj instanceof Float) {
			return new NBTTagFloat((Float) obj);
		} else if (obj instanceof Double) {
			return new NBTTagDouble((Double) obj);
		}
		//else if(obj instanceof byte[]) {
		//	return new NBTTagByteArray((byte[]) obj);
		//}
		else if (obj instanceof String) {
			return new NBTTagString((String) obj);
		} else if (obj instanceof PyList) {
			return new NBTTagIntArray(((PyList) obj));
		}
		// Long array doesn't seem to be used by Minecraft?
		else if (obj instanceof Boolean) {
			return new NBTTagByte(((Boolean) obj) == true ? (byte) 1 : 0);
		}

		else { // This must me an NBTTagCompound?
			throw new Error("Invalid object type: " + obj.getClass());
		}
	}

	/**
	 * Takes a {@link NBTBase} object and converts it into a java object of the
	 * respective data.
	 */
	@Nullable
	public static Object nbtToObject(@Nullable NBTBase tag) {
		if (tag == null) {
			return null;
		} else {
			if (tag instanceof NBTTagByte) {
				byte b = ((NBTTagByte) tag).getByte();
				switch (b) {
				case 0:
					return false;
				case 1:
					return true;
				case 2:
					return null;
				default:
					return 0; // Should never happen.
				}
			} else if (tag instanceof NBTTagShort) {
				return ((NBTTagShort) tag).getShort();
			} else if (tag instanceof NBTTagInt) {
				return ((NBTTagInt) tag).getInt();
			} else if (tag instanceof NBTTagLong) {
				return ((NBTTagLong) tag).getLong();
			} else if (tag instanceof NBTTagFloat) {
				return ((NBTTagFloat) tag).getFloat();
			} else if (tag instanceof NBTTagDouble) {
				return ((NBTTagDouble) tag).getDouble();
			} else if (tag instanceof NBTTagByteArray) {
				return new PyList(Arrays.asList(((NBTTagByteArray) tag).getByteArray()));
			} else if (tag instanceof NBTTagString) {
				return ((NBTTagString) tag).getString();
			} else if (tag instanceof NBTTagIntArray) {
				return new PyList(Arrays.asList(((NBTTagIntArray) tag).getIntArray()));
			}
			// Long array doesn't seem to be used by Minecraft?
			else { // This must me an NBTTagCompound.
				throw new Error("Invalid object type: " + tag.getClass());
			}
		}
	}
}
