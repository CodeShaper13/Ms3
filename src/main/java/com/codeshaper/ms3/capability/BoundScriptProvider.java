package com.codeshaper.ms3.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class BoundScriptProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IBoundScript.class)
	public static final Capability<IBoundScript> BOUND_SCRIPT_CAP = null;

	private IBoundScript instance = BOUND_SCRIPT_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == BOUND_SCRIPT_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == BOUND_SCRIPT_CAP ? BOUND_SCRIPT_CAP.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return BOUND_SCRIPT_CAP.getStorage().writeNBT(BOUND_SCRIPT_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		BOUND_SCRIPT_CAP.getStorage().readNBT(BOUND_SCRIPT_CAP, this.instance, null, nbt);
	}
}
