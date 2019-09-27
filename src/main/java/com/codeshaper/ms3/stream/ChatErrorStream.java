package com.codeshaper.ms3.stream;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

/**
 * Stream used for error messages, replacing the default python sys.err.
 * 
 * @author CodeShaper
 */
public class ChatErrorStream extends ChatOutputStream {

	@Override
	public TextComponentString getChat(String message) {
		return new TextComponentString(TextFormatting.RED + message);
	}
}
