package com.codeshaper.ms3.stream;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

/**
 * Stream used for error messages, replacing the default python sys.err
 */
public class ChatErrorStream extends ChatOutputStream {

	@Override
	public TextComponentString getChat(String message) {
		return new TextComponentString(TextFormatting.RED + message);
	}
}
