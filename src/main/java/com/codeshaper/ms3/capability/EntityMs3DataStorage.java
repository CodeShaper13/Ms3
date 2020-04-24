package com.codeshaper.ms3.capability;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.python.core.PyDictionary;
import org.python.core.PyList;
import org.python.core.PySequence;
import org.python.core.PySequenceList;

import com.codeshaper.ms3.EnumCallbackType;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.exception.IllegalNBTFormattException;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.util.NbtHelper;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class EntityMs3DataStorage implements IStorage<IEntityMs3Data> {

	@Override
	public NBTBase writeNBT(Capability<IEntityMs3Data> capability, IEntityMs3Data instance, EnumFacing side) {		
		NBTTagCompound tag = new NBTTagCompound();

		// Execute the onSave() callback so scripts can save their state to properties.
		instance.runCallback(EnumCallbackType.ON_SAVE);
		
		// Write the attached scripts to NBT.
		NBTTagList nbtList = new NBTTagList();
		for(AttachedScript as : instance.getScriptList()) {
			try { //TODO handle better.
				nbtList.appendTag(as.getLocation().writeToNbt());
			} catch (IllegalNBTFormattException e) {
				e.printStackTrace();
			}
		}
		tag.setTag("scriptList", nbtList);

		// Write the properties to NBT.
		NBTTagCompound nbtCompound = new NBTTagCompound();
		for (Map.Entry<String, Object> entry : instance.getPropertyMap().entrySet()) {			
			try {
				NbtHelper.writeObjToNbt(nbtCompound, entry.getKey(), entry.getValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		tag.setTag("properties", nbtCompound);

		return tag;
	}

	@Override
	public void readNBT(Capability<IEntityMs3Data> capability, IEntityMs3Data instance, EnumFacing side, NBTBase nbt) {		
		NBTTagCompound tag = (NBTTagCompound) nbt;

		// Read the attached scripts.
		NBTTagList nbtList = tag.getTagList("scriptList", 10);
		AttachedScriptList list = instance.getScriptList();
		for (int i = 0; i < nbtList.tagCount(); i++) {
			list.add(entity.createWrapperClassForEntity(((EntityMs3Data)instance).e), new RunnableScript(nbtList.getCompoundTagAt(i)));
		}

		// Read the properties.
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
				value = entity.createWrapperClassForEntity(e);
			} else if(obj instanceof NBTTagDouble) {
				value = ((NBTTagDouble) obj).getDouble();
			} else {
				throw new Error("Unknown type: " + obj.getClass());
			}

			map.put(key, value);
		}

		instance.runCallback(EnumCallbackType.ON_LOAD);
	}
}
