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
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.drawing.DrawInstructions;
import com.codeshaper.ms3.drawing.EventHandlerDrawing;
import com.codeshaper.ms3.util.Assert;
import com.codeshaper.ms3.util.Util;

@PythonClass
public class drawer {

	@PythonField
	@PythonDocString("When false, depth testing is turned off and all draw shapes will show up on top of all world geometry.  Default is true.")
	public static boolean depthTest = true;

	@PythonFunction
	public static void drawLine(PyTuple start, PyTuple end, PyTuple color) {
		Assert.isCoords(start);
		Assert.isCoords(end);
		Assert.isColor(color);

		drawer.func(color, GL11.GL_LINES, start, end);
	}

	@PythonFunction
	public static void drawQuad(PyTuple vertex1, PyTuple vertex2, PyTuple vertex3, PyTuple vertex4, PyTuple color) {
		Assert.isCoords(vertex1);
		Assert.isCoords(vertex2);
		Assert.isCoords(vertex3);
		Assert.isCoords(vertex4);
		Assert.isColor(color);

		drawer.func(color, GL11.GL_QUADS, vertex1, vertex2, vertex3, vertex4);
	}

	@PythonFunction
	public static void drawWireQuad(PyTuple vertex1, PyTuple vertex2, PyTuple vertex3, PyTuple vertex4, PyTuple color) {
		Assert.isCoords(vertex1);
		Assert.isCoords(vertex2);
		Assert.isCoords(vertex3);
		Assert.isCoords(vertex4);
		Assert.isColor(color);

		drawer.func(color, GL11.GL_LINE_LOOP, vertex1, vertex2, vertex3, vertex4);
	}

	@PythonFunction
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
	public static void drawTri(PyTuple vertex1, PyTuple vertex2, PyTuple vertex3, PyTuple color) {
		Assert.isCoords(vertex1);
		Assert.isCoords(vertex2);
		Assert.isCoords(vertex3);
		Assert.isColor(color);

		drawer.func(color, GL11.GL_TRIANGLES, vertex1, vertex2, vertex3);
	}

	@PythonFunction
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
