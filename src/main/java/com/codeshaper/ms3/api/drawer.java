package com.codeshaper.ms3.api;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector3f;
import org.python.core.PySequence;
import org.python.core.PySequenceList;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.drawing.DrawInstructions;
import com.codeshaper.ms3.drawing.EventHandlerDrawing;
import com.codeshaper.ms3.util.Assert;
import com.codeshaper.ms3.util.Util;

@PythonClass
@PythonDocString("Module for drawing shaped and geometry into the world.  When passing vertices, three element tuples should be used contains numbers.  All of the functions accept a color argument as well, these should be tuples of three or four elements with floats for the rgb and rgba values respectively.  These values should be between 0 and 1.")
public class drawer {

	@PythonFieldGenerated
	@PythonDocString("The color red (1, 0, 0)")
	public static PyTuple red = Util.makeTuple(1f, 0f, 0f);
	@PythonFieldGenerated
	@PythonDocString("The color green (0, 1, 0)")
	public static PyTuple green = Util.makeTuple(0f, 1f, 0f);
	@PythonFieldGenerated
	@PythonDocString("The color blue (0, 0, 1)")
	public static PyTuple blue = Util.makeTuple(0f, 0f, 1f);
	@PythonField
	@PythonDocString("When false, depth testing is turned off and all draw shapes will show up on top of all world geometry.  Default is true.")
	public static boolean depthTest = true;
	
	@PythonFunction
	@PythonDocString("Draws a single pixel in the world.")
	public static void drawPixel(PyTuple point, PyTuple color) {
		DrawInstructions instructions = new DrawInstructions(GL11.GL_POINTS);
		instructions.addVert(point);
		instructions.setColor(color);
		instructions.setDepthTest(drawer.depthTest);

		EventHandlerDrawing.addInstruction(instructions);
	}
	
	@PythonFunction
	@PythonDocString("Draws a colored line from start to end")
	public static void drawLine(PyTuple startVertex, PyTuple endVertex, PyTuple color) {
		Assert.isCoords(startVertex);
		Assert.isCoords(endVertex);
		Assert.isColor(color);

		drawer.func(color, GL11.GL_LINES, startVertex, endVertex);
	}

	@PythonFunction
	@PythonDocString("Draws a solid, one sided quadrilateral.")
	public static void drawQuad(PyTuple vertex1, PyTuple vertex2, PyTuple vertex3, PyTuple vertex4, PyTuple color) {
		Assert.isCoords(vertex1);
		Assert.isCoords(vertex2);
		Assert.isCoords(vertex3);
		Assert.isCoords(vertex4);
		Assert.isColor(color);

		drawer.func(color, GL11.GL_QUADS, vertex1, vertex2, vertex3, vertex4);
	}

	@PythonFunction
	@PythonDocString("Draws the outline of a quadrilateral.")
	public static void drawWireQuad(PyTuple vertex1, PyTuple vertex2, PyTuple vertex3, PyTuple vertex4, PyTuple color) {
		Assert.isCoords(vertex1);
		Assert.isCoords(vertex2);
		Assert.isCoords(vertex3);
		Assert.isCoords(vertex4);
		Assert.isColor(color);

		drawer.func(color, GL11.GL_LINE_LOOP, vertex1, vertex2, vertex3, vertex4);
	}

	@PythonFunction
	@PythonDocString("Draws a wire cube.  center is a 3 element tuple for the center of the cube, and scale is a 3 element tuple of the cube's radius.")
	public static void drawWireCube(PyTuple center, PyTuple scale, PyTuple color) {
		Assert.isCoords(center);
		Assert.isCoords(scale);
		Assert.isColor(color);

		Vector3f v = Util.tupleToVertex(center);
		Vector3f s = (Vector3f) Util.tupleToVertex(scale).scale(0.5f);
		float x = v.x;
		float y = v.y;
		float z = v.z;
		float i = s.x;
		float j = s.y;
		float k = s.z;

		// Bottom
		Vector3f v1 = new Vector3f(x - i, y - j, z + k);
		Vector3f v2 = new Vector3f(x + i, y - j, z + k);
		Vector3f v3 = new Vector3f(x + i, y - j, z - k);
		Vector3f v4 = new Vector3f(x - i, y - j, z - k);

		// Top
		Vector3f v5 = new Vector3f(x - i, y + j, z + k);
		Vector3f v6 = new Vector3f(x + i, y + j, z + k);
		Vector3f v7 = new Vector3f(x + i, y + j, z - k);
		Vector3f v8 = new Vector3f(x - i, y + j, z - k);

		DrawInstructions instructions = new DrawInstructions(GL11.GL_LINES)
				// Bottom
				.addVert(v1).addVert(v2).addVert(v2).addVert(v3).addVert(v3).addVert(v4).addVert(v4).addVert(v1)

				// Top
				.addVert(v5).addVert(v6).addVert(v6).addVert(v7).addVert(v7).addVert(v8).addVert(v8).addVert(v5)

				// Sides
				.addVert(v1).addVert(v5).addVert(v2).addVert(v6).addVert(v3).addVert(v7).addVert(v4).addVert(v8);

		instructions.setColor(color);
		instructions.setDepthTest(drawer.depthTest);

		EventHandlerDrawing.addInstruction(instructions);
	}

	@PythonFunction
	@PythonDocString("Draws a solid, one sided triangle.")
	public static void drawTri(PyTuple vertex1, PyTuple vertex2, PyTuple vertex3, PyTuple color) {
		Assert.isCoords(vertex1);
		Assert.isCoords(vertex2);
		Assert.isCoords(vertex3);
		Assert.isColor(color);

		drawer.func(color, GL11.GL_TRIANGLES, vertex1, vertex2, vertex3);
	}

	@PythonFunction
	@PythonDocString("Draws the outline of a triangle.")
	public static void drawWireTri(PyTuple vertex1, PyTuple vertex2, PyTuple vertex3, PyTuple color) {
		Assert.isCoords(vertex1);
		Assert.isCoords(vertex2);
		Assert.isCoords(vertex3);
		Assert.isColor(color);

		drawer.func(color, GL11.GL_LINE_LOOP, vertex1, vertex2, vertex3);
	}

	private static void func(PyTuple color, int cap, PyTuple... vertices) {
		DrawInstructions instructions = new DrawInstructions(cap);
		for (int i = 0; i < vertices.length; i++) {
			instructions.addVert(vertices[i]);
		}
		instructions.setColor(color);
		instructions.setDepthTest(drawer.depthTest);

		EventHandlerDrawing.addInstruction(instructions);
	}
}
