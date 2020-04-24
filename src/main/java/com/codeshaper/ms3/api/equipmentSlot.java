package com.codeshaper.ms3.api;

import org.python.core.Py;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.util.Util;

import net.minecraft.inventory.EntityEquipmentSlot;

@PythonClass
@PythonDocString("Numeric constants for the different inventory slot Ids.")
public class equipmentSlot {

	private equipmentSlot() {
	}

	@PythonFieldGenerated
	public static final int MAIN_HAND = 0;
	@PythonFieldGenerated
	public static final int OFF_HAND = 1;
	@PythonFieldGenerated
	public static final int FEET = 2;
	@PythonFieldGenerated
	public static final int LEGS = 3;
	@PythonFieldGenerated
	public static final int CHEST = 4;
	@PythonFieldGenerated
	public static final int HEAD = 5;

	@PythonFieldGenerated
	@PythonDocString("Indices of all the slots, MAIN_HAND, OFF_HAND, FEET, LEGS, CHEST and HEAD.")
	public static PyTuple ALL_SLOTS = Util.makeTuple(MAIN_HAND, OFF_HAND, FEET, LEGS, CHEST, HEAD);
	@PythonFieldGenerated
	@PythonDocString("Indices of both the hand slots, MAIN_HAND and OFF_HAND.")
	public static PyTuple HAND_SLOTS = Util.makeTuple(MAIN_HAND, OFF_HAND);
	@PythonFieldGenerated
	@PythonDocString("Indices of all the armor slots, FEET, LEGS, CHEST and HEAD.")
	public static PyTuple ARMOR_SLOTS = Util.makeTuple(FEET, LEGS, CHEST, HEAD);

	public static EntityEquipmentSlot indexToEnum(int index) {
		switch (index) {
		case 0:
			return EntityEquipmentSlot.MAINHAND;
		case 1:
			return EntityEquipmentSlot.OFFHAND;
		case 2:
			return EntityEquipmentSlot.FEET;
		case 3:
			return EntityEquipmentSlot.LEGS;
		case 4:
			return EntityEquipmentSlot.CHEST;
		case 5:
			return EntityEquipmentSlot.HEAD;
		}
		throw Py.ValueError("Invalid slot index of " + index);
	}
}
