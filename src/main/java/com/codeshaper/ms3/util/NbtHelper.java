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

	@Nullable
	public static Object getValueFromNbt(@Nullable NBTBase tag) {
		if(tag == null) {
			return null;
		} else {
			if(tag instanceof NBTTagByte) {
				return ((NBTTagByte) tag).getByte();
			}
			else if(tag instanceof NBTTagShort) {
				return ((NBTTagShort) tag).getShort();
			}
			else if(tag instanceof NBTTagInt) {
				return ((NBTTagInt) tag).getInt();
			}
			else if(tag instanceof NBTTagLong) {
				return ((NBTTagLong) tag).getLong();
			}
			else if(tag instanceof NBTTagFloat || tag instanceof NBTTagDouble) {
				return ((NBTTagFloat)tag).getFloat();
			}
			else if(tag instanceof NBTTagByteArray) {
				return new PyList(Arrays.asList(((NBTTagByteArray) tag).getByteArray()));
			}
			else if(tag instanceof NBTTagString) {
				return ((NBTTagString) tag).getString();
			}			
			else if(tag instanceof NBTTagIntArray) {
				return new PyList(Arrays.asList(((NBTTagIntArray) tag).getIntArray()));
			}
			// Long array doesn't seem to be used by Minecraft?
			else { // This must me an NBTTagCompound.
				return tag.toString();
			}
		}
	}
}
