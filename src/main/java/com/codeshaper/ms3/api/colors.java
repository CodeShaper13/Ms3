package com.codeshaper.ms3.api;

import org.python.core.PyInteger;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonClass
@PythonDocString("Constants for the different colors.  First item is ID and the second is it's dye ID.")
public class colors {
	
	private colors() { }

	@PythonField("(0, 15)")
	public static PyTuple WHITE = func(0, 15);
	@PythonField("(1, 14)")
	public static PyTuple ORANGE = func(1, 14);
	@PythonField("(2, 13)")
	public static PyTuple MAGENTA = func(2, 13);
	@PythonField("(3, 12)")
	public static PyTuple LIGHT_BLUE = func(3, 12);
	@PythonField("(4, 11)")
	public static PyTuple YELLOW = func(4, 11);
	@PythonField("(5, 10)")
	public static PyTuple LIME = func(5, 10);
	@PythonField("(6, 9)")
	public static PyTuple PINK = func(6, 9);
	@PythonField("(7, 8)")
	public static PyTuple GRAY = func(7, 8);
	@PythonField("(8, 7)")
	public static PyTuple LIGHT_GRAY = func(8, 7);
	@PythonField("(9, 6)")
	public static PyTuple CYAN = func(9, 6);
	@PythonField("(10, 5)")
	public static PyTuple PURPLE = func(10, 5);
	@PythonField("(11, 4)")
	public static PyTuple BLUE = func(11, 4);
	@PythonField("(12, 3)")
	public static PyTuple BROWN = func(12, 3);
	@PythonField("(13, 2)")
	public static PyTuple GREEN = func(13, 2);
	@PythonField("(14, 1)")
	public static PyTuple RED = func(14, 1);
	@PythonField("(15, 0)")
	public static PyTuple BLACK = func(15, 0);
	
	@PythonFunction
	@PythonDocString("Returns a tuple of all colors, ordered by their id.")
	public static PyTuple getAllColors() {
		return new PyTuple(
				WHITE,
				ORANGE,
				MAGENTA,
				LIGHT_BLUE,
				YELLOW,
				LIME,
				PINK,
				GRAY,
				LIGHT_GRAY,
				CYAN,
				PURPLE,
				BLUE,
				BROWN,
				GREEN,
				RED,
				BLACK);
	}
	
	private static PyTuple func(int colorId, int dyeId) {
		return new PyTuple(new PyInteger(colorId), new PyInteger(dyeId));
	}
}
