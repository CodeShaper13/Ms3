package com.codeshaper.ms3.util;

import org.python.core.Py;
import org.python.core.PyDictionary;
import org.python.core.PyList;
import org.python.core.PySequenceList;
import org.python.core.PyTuple;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/**
 * Static helper function for parsing data that is used by the interaction
 * classes.
 */
@Deprecated
public class ParserUtils {

	public static BlockPos getBlockPos(Object... objs) {
		return ParserUtils.getBlockPos(true, objs);
	}

	/**
	 * Gets a BlockPos, with the Y value as 0 (For chunk pos).
	 */
	public static BlockPos getBlockPos2Dim(Object... objs) {
		return ParserUtils.getBlockPos(false, objs);
	}

	public static BlockPos getBlockPos(boolean parseY, Object... objs) {
		int requiredLength = parseY ? 3 : 2;
		if (objs[0] instanceof BlockPos) {
			return (BlockPos) objs[0];
		} else if (objs[0] instanceof PyTuple && objs.length >= requiredLength) {
			PyTuple t = (PyTuple) objs[0];
			return new BlockPos(ParserUtils.getInt(t.get(0)), parseY ? ParserUtils.getInt(t.get(1)) : 0,
					ParserUtils.getInt(t.get(parseY ? 2 : 1)));
		} else if (objs[0] instanceof PyList && objs.length >= requiredLength) {
			PyList t = (PyList) objs[0];
			return new BlockPos(ParserUtils.getInt(t.get(0)), parseY ? ParserUtils.getInt(t.get(1)) : 0,
					ParserUtils.getInt(t.get(parseY ? 2 : 1)));
		} else if (objs[0] instanceof PyDictionary) {
			PyDictionary d = (PyDictionary) objs[0];
			return new BlockPos(getObjFromPyDict(d, "x"), parseY ? getObjFromPyDict(d, "y") : 0,
					getObjFromPyDict(d, "z"));
		} else if (parseY == false && objs.length >= 2) {
			return new BlockPos(ParserUtils.getInt(objs[0]), 0, ParserUtils.getInt(objs[1]));
		} else if (parseY && objs.length >= 3) {
			return new BlockPos(ParserUtils.getInt(objs[0]), ParserUtils.getInt(objs[1]), ParserUtils.getInt(objs[2]));
		}
		throw Py.ValueError("Could not parse " + objs.toString() + " to an instance of net.minecraft.util.BlockPos");
	}

	public static Vec3d getEntityPos(Object... objs) {
		if (objs[0] instanceof Vec3d) {
			return (Vec3d) objs[0];
		} else if (objs[0] instanceof PySequenceList && objs.length >= 3) {
			PySequenceList pysl = (PySequenceList) objs[0];
			return new Vec3d(ParserUtils.asNumber(pysl.get(0)), ParserUtils.asNumber(pysl.get(1)),
					ParserUtils.asNumber(pysl.get(2)));
		} else if (objs[0] instanceof PyDictionary) {
			PyDictionary d = (PyDictionary) objs[0];
			return new Vec3d(getObjFromPyDict(d, "x"), getObjFromPyDict(d, "y"), getObjFromPyDict(d, "z"));
		} else if (objs.length >= 3) {
			return new Vec3d(ParserUtils.asNumber(objs[0]), ParserUtils.asNumber(objs[1]),
					ParserUtils.asNumber(objs[2]));
		}
		throw Py.ValueError("Could not parse " + objs.toString() + " to an instance of net.minecraft.util.BlockPos");
	}

	/**
	 * Converts an Object to a Block.
	 */
	public static Block getBlock(Object obj) {
		if (obj instanceof Block) {
			return (Block) obj;
		} else if (obj instanceof Number) {
			return Block.getBlockById(((Number) obj).intValue());
		} else if (obj instanceof String) {
			Block b = Block.getBlockFromName((String) obj);
			if (b != null) {
				return b;
			}
		}
		throw Py.ValueError("Could not parse " + obj.toString() + " to a child of net.minecraft.block.Block");
	}

	/**
	 * Converts an Object to an Item.
	 */
	public static Item getItem(Object obj) {
		if (obj instanceof Item) {
			return (Item) obj;
		} else if (obj instanceof Block) {
			return Item.getItemFromBlock((Block) obj);
		} else if (obj instanceof Number) {
			return Item.getItemById(((Number) obj).intValue());
		} else if (obj instanceof String) {
			Item i = Item.getByNameOrId((String) obj);
			if (i != null) {
				return i;
			}
		}
		throw Py.ValueError("Could not parse " + obj.toString() + " to a child of net.minecraft.item.Item!");
	}

	/**
	 * Converts an Object to a primitive int.
	 */
	public static int getInt(Object obj) {
		if (obj instanceof Number) {
			return ((Number) obj).intValue();
		} else if (obj instanceof String) {
			try {
				return Integer.parseInt((String) obj);
			} catch (NumberFormatException e) {
			}
		}
		throw Py.ValueError("Could not parse " + obj.toString() + " to an int!");
	}

	/**
	 * Tries to cast the passes object to a number of type T.
	 */
	public static <T extends Number> T asNumber(Object obj) {
		if (obj instanceof Number) {
			return ((T) obj);
		} else {
			throw Py.ValueError("Could not convert " + obj.toString() + " to a number!");
		}
	}

	private static int getObjFromPyDict(PyDictionary dict, String key) {
		Object obj = dict.get(key);
		if (obj != null) {
			return ParserUtils.getInt(obj);
		}
		throw Py.ValueError("Dictionary must have a key of \"" + key + "\" to be parsable!");
	}
}
