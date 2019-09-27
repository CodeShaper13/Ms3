package com.codeshaper.ms3.drawing;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import org.python.core.PyTuple;

import com.codeshaper.ms3.util.Util;

public class DrawInstructions {
	
	private int mode;
	private Vector4f color;
	private List<Vector3f> verticies;
	private boolean depthTest;
	
	public DrawInstructions(int drawType) {
		this.mode = drawType;
		this.color = new Vector4f(1f, 1f, 1f, 1f);
		this.verticies = new ArrayList<Vector3f>();
		this.depthTest = true;
	}
	
	public DrawInstructions addVert(PyTuple vertex) {
		this.verticies.add(Util.tupleToVertex(vertex));
		return this;
	}
	
	public DrawInstructions addVert(float x, float y, float z) {
		this.verticies.add(new Vector3f(x, y, z));
		return this;
	}
	
	public DrawInstructions addVert(Vector3f v) {
		this.verticies.add(v);
		return this;
	}
	
	public DrawInstructions setColor(PyTuple color) {
		this.color = Util.tupleToColor(color);
		return this;
	}
	
	public DrawInstructions setDepthTest(boolean flag) {
		this.depthTest = flag;
		return this;
	}
	
	public void draw() {
			GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		if(this.depthTest) {
			GL11.glEnable(GL11.GL_DEPTH_TEST);
		} else {
			GL11.glDisable(GL11.GL_DEPTH_TEST);
		}
		
		GL11.glColor4f(this.color.x, this.color.y, this.color.z, this.color.w);

		GL11.glBegin(this.mode);
		
		for(Vector3f v : this.verticies) {
			GL11.glVertex3f(v.x, v.y, v.z);
		}

		GL11.glEnd();
	}
}
