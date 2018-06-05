package com.codeshaper.ms3.api;

import org.python.core.Py;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.util.Util;

import net.minecraft.inventory.EntityEquipmentSlot;

@PythonClass
@PythonDocString("Constants for the different inventory slot IDs.")
public class equipmentSlot {

	private equipmentSlot() {
	}

	@PythonFieldGenerated
	public static final int MAINHAND = 0;
	@PythonFieldGenerated
	public static final int OFFHAND = 1;
	@PythonFieldGenerated
	public static final int FEET = 2;
	@PythonFieldGenerated
	public static final int LEGS = 3;
	@PythonFieldGenerated
	public static final int CHEST = 4;
	@PythonFieldGenerated
	public static final int HEAD = 5;

	@PythonFieldGenerated
	@PythonDocString("Indices of all the armor slots, feet, legs, chest and head.")
	public static PyTuple ARMOR_SLOTS = Util.makeTuple(FEET, LEGS, CHEST, HEAD);

	public static EntityEquipmentSlot indexToEnum(int index) {
		if (index == 0) {
			return EntityEquipmentSlot.MAINHAND;
		} else if (index == 1) {
			return EntityEquipmentSlot.OFFHAND;
		} else if (index == 2) {
			return EntityEquipmentSlot.FEET;
		} else if (index == 3) {
			return EntityEquipmentSlot.LEGS;
		} else if (index == 4) {
			return EntityEquipmentSlot.CHEST;
		} else if (index == 5) {
			return EntityEquipmentSlot.HEAD;
		} else {
			throw Py.ValueError("Invalid slot index of " + index);
		}
	}
}
