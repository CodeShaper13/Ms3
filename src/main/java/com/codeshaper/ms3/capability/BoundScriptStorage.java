package com.codeshaper.ms3.capability;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.script.RunnableScript;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class BoundScriptStorage implements IStorage<IBoundScript> {

	@Override
	public NBTBase writeNBT(Capability<IBoundScript> capability, IBoundScript instance, EnumFacing side) {
		NBTTagCompound tag = new NBTTagCompound();

		NBTTagList nbtList = new NBTTagList();
		List<RunnableScript> list = instance.getScriptList();
		RunnableScript rs;
		for (int i = 0; i < list.size(); i++) {
			rs = list.get(i);
			nbtList.appendTag(rs.writeToNbt());
		}

		tag.setTag("scriptList", nbtList);

		NBTTagCompound nbtCompound = new NBTTagCompound();
		HashMap<String, Object> map = instance.getPropertyMap();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof String) {
				nbtCompound.setString(key, (String) value);
			} else if (value instanceof Integer) {
				nbtCompound.setInteger(key, (int) value);
			} else if (value instanceof Long) {
				nbtCompound.setLong(key, (long) value);
			} else if (value instanceof Double) {
				nbtCompound.setDouble(key, (double) value);
			} else if (value instanceof entity.EntityBase) {
				nbtCompound.setUniqueId(key, ((entity.EntityBase) value).mcEntity.getUniqueID());
			} else {
				throw new Error("Unknown type: " + value.getClass());
			}
		}

		tag.setTag("properties", nbtCompound);

		return tag;
	}

	@Override
	public void readNBT(Capability<IBoundScript> capability, IBoundScript instance, EnumFacing side, NBTBase nbt) {
		NBTTagCompound tag = (NBTTagCompound) nbt;

		NBTTagList nbtList = tag.getTagList("scriptList", 10);

		List<RunnableScript> list = instance.getScriptList();
		for (int i = 0; i < nbtList.tagCount(); i++) {
			list.add(new RunnableScript(nbtList.getCompoundTagAt(i)));
		}

		NBTTagCompound nbtCompound = tag.getCompoundTag("properties");
		HashMap<String, Object> map = instance.getPropertyMap();

		Set<String> set = nbtCompound.getKeySet();
		for (String key : set) {
			NBTBase obj = nbtCompound.getTag(key);
			Object value;
			if (obj instanceof NBTTagInt) {
				value = ((NBTTagInt) obj).getInt();
			} else if (obj instanceof NBTTagLong) {
				value = ((NBTTagLong) obj).getLong();
			} else if (obj instanceof NBTTagFloat) {
				value = ((NBTTagFloat) obj).getFloat();
			} else if (obj instanceof NBTTagString) {
				value = ((NBTTagString) obj).getString();
			} else if (nbtCompound.hasUniqueId(key)) {
				Entity e = FMLCommonHandler.instance().getMinecraftServerInstance().getEntityFromUuid(nbtCompound.getUniqueId(key));
				value = entity.getWrapperClassForEntity(e);
			} else {
				throw new Error("Unknown type: " + obj.getClass());
			}

			map.put(key, value);
		}
	}
}
