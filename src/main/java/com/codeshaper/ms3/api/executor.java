package com.codeshaper.ms3.api;

import javax.annotation.Nullable;

import org.python.core.PyObject;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.util.Util;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.WorldServer;

public class executor {

	private executor() {
	}

	@PythonClass
	@PythonDocString("Represents whoever or whatever is executing a script.")
	public static class Executor extends PyObject {

		private Vec3d senderPosition;
		private ICommandSender sender;

		public Executor(ICommandSender sender) {
			this.senderPosition = sender.getPositionVector();
			this.sender = sender;
		}

		@PythonFunction
		@PythonDocString("Returns the executor's X position as a float.")
		public double getX() {
			return this.senderPosition.x;
		}

		@PythonFunction
		@PythonDocString("Returns the executor's Y position as a float.")
		public double getY() {
			return this.senderPosition.y;
		}

		@PythonFunction
		@PythonDocString("Returns the executor's Z position as a float.")
		public double getZ() {
			return this.senderPosition.z;
		}

		@PythonFunction
		@PythonDocString("Returns True if this script was ran by a player, False for Command Blocks and the server console.")
		public boolean isPlayer() {
			return this.sender.getCommandSenderEntity() != null;
		}

		@PythonFunction
		@PythonDocString("Returns the executors name, the username if it is a player or \"@\" if it is a Command Block")
		public String getSenderName() {
			return this.sender.getName();
		}

		@PythonFunction
		@PythonDocString("Sends a message that only the executor will see.")
		public void sendMessage(String message) {
			this.sender.sendMessage(new TextComponentString(Util.correctColorCode(message)));
		}
		
		public void sendMessage(ITextComponent component) {
			this.sender.sendMessage(component);
		}
		
		@PythonFunction
		@PythonDocString("Returns the world that this sender resides in.")
		public world.World getSenderWorld() {
			return new world.World((WorldServer) sender.getEntityWorld());
		}
		
		@PythonFunction
		@PythonDocString("Returns the sender as an entity, or None if it can't be converted, in the case of a Command Block.")
		public @Nullable entity.EntityBase asEntity() {
			Entity e = this.sender.getCommandSenderEntity();
			
			if(e != null) {
				return entity.getWrapperClassForEntity(e);
			} else {
				return null;
			}
		}

		//@PythonFunction
		//@PythonDocString("Returns the internal instance of net.minecraft.command.ICommandSender.  For advenced users only!")
		public ICommandSender getSenderObj() {
			return this.sender;
		}
	}
}
