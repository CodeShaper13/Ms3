package com.codeshaper.ms3.api;

import org.python.core.Py;
import org.python.core.PyInteger;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

import net.minecraft.inventory.EntityEquipmentSlot;

@PythonClass
@PythonDocString("Constants for the different inventory slot IDs.")
public class equipmentSlot {
	
	private equipmentSlot() { }

	@PythonField("0")
	public static int MAINHAND = 0;
	@PythonField("1")
	public static int OFFHAND = 1;
	@PythonField("2")
	public static int FEET = 2;
	@PythonField("3")
	public static int LEGS = 3;
	@PythonField("4")
	public static int CHEST = 4;
	@PythonField("5")
	public static int HEAD = 5;
	
	@PythonField("(2, 3, 4, 5)")
	@PythonDocString("Indices of all the armor slots, feet, legs, chest and head.")
	public static PyTuple ARMOR_SLOTS = new PyTuple(new PyInteger(FEET), new PyInteger(LEGS), new PyInteger(CHEST), new PyInteger(HEAD));
	
	public static EntityEquipmentSlot indexToEnum(int index) {
		if(index == 0) {
			return EntityEquipmentSlot.MAINHAND;
		} else if(index == 1) {
			return EntityEquipmentSlot.OFFHAND;
		} else if(index == 2) {
			return EntityEquipmentSlot.FEET;
		} else if(index == 3) {
			return EntityEquipmentSlot.LEGS;
		} else if(index == 4) {
			return EntityEquipmentSlot.CHEST;
		} else if(index == 5) {
			return EntityEquipmentSlot.HEAD;
		} else {
			throw Py.ValueError("Invalid slot index of " + index);
		}
	}
}
