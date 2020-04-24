package com.codeshaper.ms3.util;

import java.util.Arrays;

import javax.annotation.Nullable;

import org.python.core.Py;
import org.python.core.PyList;
import org.python.core.PySequence;
import org.python.core.PySequenceList;

import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.nbt.NbtCompound;
import com.codeshaper.ms3.exception.IllegalNBTFormattException;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.nbt.NBTTagLongArray;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.nbt.NBTTagString;

/**
 * Helper class for working with NBT objects.
 * 
 * @author CodeShaper
 */
public class NbtHelper {
	
	//public static boolean isValidType(Object obj) {
	//	return obj instanceof Boolean || obj instanceof Byte || obj instanceof Short || obj instanceof Integer || obj instanceof ;
	//}

	/**
	 * Converts the passed object to an NBT Tag and returns it. The following object
	 * types are accepted:
	 * 
	 * <li>boolean</li>
	 * <li>byte</li>
	 * <li>short</li>
	 * <li>integer</li>
	 * <li>long</li>
	 * <li>float</li>
	 * <li>double</li>
	 * <li>byte[]</li>
	 * <li>String</li>
	 * <li>byte[]</li>
	 * <li>int[]</li>
	 * <li>long[]</li>
	 * <li>entity.Base</li>
	 * <li>PySequenceList (This includes Tuples and Lists)</li>
	 * 
	 * @param obj
	 * @throws Exception If the object is a type that can't be converted into an NBT tag.
	 */
	public static void writeObjToNbt(NBTTagCompound parent, String key, Object obj) throws IllegalNBTFormattException {		
		if (obj instanceof Boolean) {
			parent.setTag(key, new NBTTagByte(((Boolean) obj) == true ? (byte) 1 : 0));
		}
		else if (obj instanceof Byte || obj == null) {
			parent.setTag(key, new NBTTagByte(obj == null ? 2 : ((Byte) obj)));
		}
		else if (obj instanceof Short) {
			parent.setTag(key, new NBTTagShort((Short) obj));
		}
		else if (obj instanceof Integer) {
			parent.setTag(key, new NBTTagInt((Integer) obj));
		}
		else if (obj instanceof Long) {
			parent.setTag(key, new NBTTagLong((Long) obj));
		}
		else if (obj instanceof Float) {
			parent.setTag(key, new NBTTagFloat((Float) obj));
		}
		else if (obj instanceof Double) {
			parent.setTag(key, new NBTTagDouble((Double) obj));
		}
		else if (obj instanceof String) {
			parent.setTag(key, new NBTTagString((String) obj));
		}
		else if (obj instanceof byte[]) {
			parent.setTag(key, new NBTTagByteArray((byte[]) obj));
		}
		else if (obj instanceof int[]) {
			parent.setTag(key, new NBTTagIntArray((int[]) obj));
		}
		// No way to read, so not implemented.
		//else if (obj instanceof long[]) {
		//	parent.setTag(key, new NBTTagLongArray((long[]) obj));
		//}
		else if(obj instanceof entity.Base) {
			parent.setUniqueId(key, ((entity.Base<?>) obj).mcEntity.getUniqueID());
		}
		else if(obj instanceof PySequenceList) { // Lists and Tuples
			PySequenceList sequence = ((PySequenceList)obj);			
			NBTTagCompound listTag = new NBTTagCompound();
			
			for(Object childObj : sequence.asIterable()) {
				// Don't allow nested tags.
				if(childObj instanceof PySequenceList) {
					throw new IllegalNBTFormattException("PySequenceLists can not contain PySequenceLists!");
				}
				NbtHelper.writeObjToNbt(listTag, key, childObj);
			}
			parent.setTag(key, listTag);
		}
		else { // This must me an NBTTagCompound?
			throw new IllegalNBTFormattException("Object of type (" + obj.getClass() + ") can not be saved to NBT!");
		}
	}

	/**
	 * Takes a {@link NBTBase} object and converts it into a java object of the
	 * respective data.
	 */
	@Nullable
	public static Object readObjFromNbt(@Nullable NBTBase tag) {
		if (tag == null) {
			return null;
		} else {
			if (tag instanceof NBTTagByte) {
				byte b = (((NBTTagByte) tag).getByte());
				return b == 0 ? false : b == 1 ? true : null;
			}
			else if (tag instanceof NBTTagShort) {
				return ((NBTTagShort) tag).getShort();
			}
			else if (tag instanceof NBTTagInt) {
				return ((NBTTagInt) tag).getInt();
			}
			else if (tag instanceof NBTTagLong) {
				return ((NBTTagLong) tag).getLong();
			}
			else if (tag instanceof NBTTagFloat) {
				return ((NBTTagFloat) tag).getFloat();
			}
			else if (tag instanceof NBTTagDouble) {
				return ((NBTTagDouble) tag).getDouble();
			}
			else if (tag instanceof NBTTagString) {
				return ((NBTTagString) tag).getString();
			}
			else if (tag instanceof NBTTagByteArray) {
				return new PyList(Arrays.asList(((NBTTagByteArray) tag).getByteArray()));
			}
			else if (tag instanceof NBTTagIntArray) {
				return new PyList(Arrays.asList(((NBTTagIntArray) tag).getIntArray()));
			}
			
			//TODO reading entity UUIDs to make an entity wrapper.
			else if(tag instanceof NBTTagCompound) {
				PyList list = new PyList();
				NBTTagCompound nbtList = ((NBTTagCompound)tag);
				for(String key : nbtList.getKeySet()) {
					NBTBase childTag = nbtList.getTag(key);
					list.add(NbtHelper.readObjFromNbt(childTag));
				}
				return list;
			}
			else { // This must be an NBTTagCompound.
				throw new Error("Invalid object type: " + tag.getClass());
			}
		}
	}
}
