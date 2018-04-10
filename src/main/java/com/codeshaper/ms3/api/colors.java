package com.codeshaper.ms3.api;

import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.util.Util;

@PythonClass
@PythonDocString("Constants for the different colors.  First item is ID and the second is it's dye ID.")
public class colors {

	private colors() {
	}

	@PythonField
	public static final PyTuple WHITE = Util.makeTuple(0, 15);
	@PythonField
	public static final PyTuple ORANGE = Util.makeTuple(1, 14);
	@PythonField
	public static final PyTuple MAGENTA = Util.makeTuple(2, 13);
	@PythonField
	public static final PyTuple LIGHT_BLUE = Util.makeTuple(3, 12);
	@PythonField
	public static final PyTuple YELLOW = Util.makeTuple(4, 11);
	@PythonField
	public static final PyTuple LIME = Util.makeTuple(5, 10);
	@PythonField
	public static final PyTuple PINK = Util.makeTuple(6, 9);
	@PythonField
	public static final PyTuple GRAY = Util.makeTuple(7, 8);
	@PythonField
	public static final PyTuple LIGHT_GRAY = Util.makeTuple(8, 7);
	@PythonField
	public static final PyTuple CYAN = Util.makeTuple(9, 6);
	@PythonField
	public static final PyTuple PURPLE = Util.makeTuple(10, 5);
	@PythonField
	public static final PyTuple BLUE = Util.makeTuple(11, 4);
	@PythonField
	public static final PyTuple BROWN = Util.makeTuple(12, 3);
	@PythonField
	public static final PyTuple GREEN = Util.makeTuple(13, 2);
	@PythonField
	public static final PyTuple RED = Util.makeTuple(14, 1);
	@PythonField
	public static final PyTuple BLACK = Util.makeTuple(15, 0);

	@PythonFunction
	@PythonDocString("Returns a tuple of all colors, ordered by their id.")
	public static PyTuple getAllColors() {
		return new PyTuple(WHITE, ORANGE, MAGENTA, LIGHT_BLUE, YELLOW, LIME, PINK, GRAY, LIGHT_GRAY, CYAN, PURPLE, BLUE,
				BROWN, GREEN, RED, BLACK);
	}
}
