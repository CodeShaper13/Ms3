package com.codeshaper.ms3.drawing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.lwjgl.opengl.GL11;
import org.python.antlr.PythonParser.funcdef_return;
import org.python.modules.synchronize;

import net.minecraft.advancements.FrameType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class EventHandlerDrawing {

	private static EventHandlerDrawing instance;

	private CopyOnWriteArrayList<DrawInstructions> instructions;

	public EventHandlerDrawing() {
		EventHandlerDrawing.instance = this;

		this.instructions = new CopyOnWriteArrayList<DrawInstructions>();
	}

	/**
	 * Adds a {@link DrawInstructions} to the list of instructions to draw every
	 * frame.
	 * 
	 * @param instructions
	 */
	public static void addInstruction(DrawInstructions instructions) {
		EventHandlerDrawing.instance.instructions.add(instructions);
	}

	@SubscribeEvent
	public void serverTickEvent(TickEvent.ServerTickEvent event) {
		if (event.phase == Phase.START) {
			this.instructions.clear();
		}
	}

	@SubscribeEvent
	public void drawBlockHighlightEvent(DrawBlockHighlightEvent event) {
		EntityPlayer player = event.getPlayer();

		double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double) event.getPartialTicks();
		double d1 = player.prevPosY + (player.posY - player.prevPosY) * (double) event.getPartialTicks();
		double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) event.getPartialTicks();
		Vec3d pos = new Vec3d(d0, d1, d2);

		synchronized (instructions) {
			Iterator<DrawInstructions> iterator = this.instructions.iterator();
			while (iterator.hasNext()) {
				DrawInstructions instructions = iterator.next();
			
				GL11.glPushMatrix();
				GL11.glPushAttrib(GL11.GL_ENABLE_BIT);

				GL11.glTranslated(-pos.x, -pos.y, -pos.z);

				instructions.draw();

				GL11.glPopAttrib();
				GL11.glPopMatrix();
			}
		}
	}
}
