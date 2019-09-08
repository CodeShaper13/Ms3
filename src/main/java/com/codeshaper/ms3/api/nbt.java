package com.codeshaper.ms3.api;

import org.python.core.PyObject;
import org.python.core.PyString;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.nbt.NBTTagCompound;

public class nbt {
	
	@PythonClass
	public class NbtCompound extends PyObject {
		
		private NBTTagCompound compound;
		
		public NbtCompound(NBTTagCompound compound) {
			this.compound = compound;
		}
		
		@PythonFunction
		public int getSize() {
			return this.compound.getSize();
		}
		
		@PythonFunction
		public void removeTag(String key) {
			this.compound.removeTag(key);
		}
		
		
		@PythonFunction
		public void setByte(String key, byte value) {
			this.compound.setByte(key, value);
		}
		
		@PythonFunction
		public void setInt(String key, int value) {
			this.compound.setInteger(key, value);
		}
		
		@PythonFunction
		public void setFloat(String key, float value) {
			this.compound.setFloat(key, value);
		}
		
		@PythonFunction
		public void setString(String key, String value) {
			this.compound.setString(key, value);
		}
		
		@PythonFunction
		public void setCompound(String key, NbtCompound value) {
			this.compound.setTag(key, value.compound);
		}
		
		
		@PythonFunction
		public byte getByte(String key) {
			return this.compound.getByte(key);
		}
		
		@PythonFunction
		public int getInt(String key) {
			return this.compound.getInteger(key);
		}
		
		@PythonFunction
		public float getFloat(String key) {
			return this.compound.getFloat(key);
		}
		
		@PythonFunction
		public String getString(String key) {
			return this.compound.getString(key);
		}
		
		@PythonFunction
		public NbtCompound getCompound(String key) {
			return new NbtCompound(this.compound.getCompoundTag(key));
		}
		
		@Override
		public PyString __str__() {
			return new PyString(this.compound.toString());			
		}
	}
}
