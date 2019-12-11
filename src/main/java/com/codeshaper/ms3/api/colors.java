package com.codeshaper.ms3.api;

import org.python.core.PyList;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.util.Util;

@PythonClass
@PythonDocString("Constants for the different colors in Minecraft.  The 16 colors in Minecraft are mapped to numeric ids in two different ways, depending on the situation.  Colored blocks, nbt tags dealing with color and most situations have the first color, white, mapped to 0, and the last color black, as 15.  Dye items meta dat is reversed, with black having a meta of 0, and white having a meta of 15.")
public class colors {

	private colors() {
	}

	@PythonField
	public static final int WHITE = 0;
	@PythonField
	public static final int ORANGE = 1;
	@PythonField
	public static final int MAGENTA = 2;
	@PythonField
	public static final int LIGHT_BLUE = 3;
	@PythonField
	public static final int YELLOW = 4;
	@PythonField
	public static final int LIME = 5;
	@PythonField
	public static final int PINK = 6;
	@PythonField
	public static final int GRAY = 7;
	@PythonField
	public static final int LIGHT_GRAY = 8;
	@PythonField
	public static final int CYAN = 9;
	@PythonField
	public static final int PURPLE = 10;
	@PythonField
	public static final int BLUE = 11;
	@PythonField
	public static final int BROWN = 12;
	@PythonField
	public static final int GREEN = 13;
	@PythonField
	public static final int RED = 14;
	@PythonField
	public static final int BLACK = 15;
	
	@PythonField
	public static final int DYE_WHITE = 15;
	@PythonField
	public static final int DYE_ORANGE = 14;
	@PythonField
	public static final int DYE_MAGENTA = 13;
	@PythonField
	public static final int DYE_LIGHT_BLUE = 12;
	@PythonField
	public static final int DYE_YELLOW = 11;
	@PythonField
	public static final int DYE_LIME = 10;
	@PythonField
	public static final int DYE_PINK = 9;
	@PythonField
	public static final int DYE_GRAY = 8;
	@PythonField
	public static final int DYE_LIGHT_GRAY = 7;
	@PythonField
	public static final int DYE_CYAN = 6;
	@PythonField
	public static final int DYE_PURPLE = 5;
	@PythonField
	public static final int DYE_BLUE = 4;
	@PythonField
	public static final int DYE_BROWN = 3;
	@PythonField
	public static final int DYE_GREEN = 2;
	@PythonField
	public static final int DYE_RED = 1;
	@PythonField
	public static final int DYE_BLACK = 0;

	@PythonFunction
	@PythonDocString("Returns a list of all the color, ordered by their ID.")
	public static PyList getAllColors() {
		PyList list = new PyList();
		list.add(WHITE);
		list.add(ORANGE);
		list.add(MAGENTA);
		list.add(LIGHT_BLUE);
		list.add(YELLOW);
		list.add(LIME);
		list.add(PINK);
		list.add(GRAY);
		list.add(LIGHT_GRAY);
		list.add(CYAN);
		list.add(PURPLE);
		list.add(BLUE);
		list.add(BROWN);
		list.add(GREEN);
		list.add(RED);
		list.add(BLACK);
		return list;
	}
}
