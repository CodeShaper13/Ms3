package com.codeshaper.ms3.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class EntityMs3DataProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IEntityMs3Data.class)
	public static final Capability<IEntityMs3Data> ENTITY_MS3_DATA_CAP = null;

	private IEntityMs3Data instance = ENTITY_MS3_DATA_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == ENTITY_MS3_DATA_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == ENTITY_MS3_DATA_CAP ? ENTITY_MS3_DATA_CAP.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return ENTITY_MS3_DATA_CAP.getStorage().writeNBT(ENTITY_MS3_DATA_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		ENTITY_MS3_DATA_CAP.getStorage().readNBT(ENTITY_MS3_DATA_CAP, this.instance, null, nbt);
	}
}