package com.codeshaper.ms3.api;

import org.python.core.PyList;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.util.Util;

@PythonClass
@PythonDocString("Constants for the different colors.  First item is ID and the second is it's dye ID.")
public class colors {

	private colors() {
	}

	@PythonFieldGenerated
	public static final PyTuple WHITE = Util.makeTuple(0, 15);
	@PythonFieldGenerated
	public static final PyTuple ORANGE = Util.makeTuple(1, 14);
	@PythonFieldGenerated
	public static final PyTuple MAGENTA = Util.makeTuple(2, 13);
	@PythonFieldGenerated
	public static final PyTuple LIGHT_BLUE = Util.makeTuple(3, 12);
	@PythonFieldGenerated
	public static final PyTuple YELLOW = Util.makeTuple(4, 11);
	@PythonFieldGenerated
	public static final PyTuple LIME = Util.makeTuple(5, 10);
	@PythonFieldGenerated
	public static final PyTuple PINK = Util.makeTuple(6, 9);
	@PythonFieldGenerated
	public static final PyTuple GRAY = Util.makeTuple(7, 8);
	@PythonFieldGenerated
	public static final PyTuple LIGHT_GRAY = Util.makeTuple(8, 7);
	@PythonFieldGenerated
	public static final PyTuple CYAN = Util.makeTuple(9, 6);
	@PythonFieldGenerated
	public static final PyTuple PURPLE = Util.makeTuple(10, 5);
	@PythonFieldGenerated
	public static final PyTuple BLUE = Util.makeTuple(11, 4);
	@PythonFieldGenerated
	public static final PyTuple BROWN = Util.makeTuple(12, 3);
	@PythonFieldGenerated
	public static final PyTuple GREEN = Util.makeTuple(13, 2);
	@PythonFieldGenerated
	public static final PyTuple RED = Util.makeTuple(14, 1);
	@PythonFieldGenerated
	public static final PyTuple BLACK = Util.makeTuple(15, 0);

	@PythonFunction
	@PythonDocString("Returns a list of all colors, ordered by their ID.")
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
