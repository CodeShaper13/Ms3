package com.codeshaper.ms3.stream;

import java.io.IOException;
import java.io.OutputStream;

import com.codeshaper.ms3.util.Util;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Stream used for output messages, replacing the default python sys.out and
 * acting as a parent for @link ChatErrorStream
 */
public class ChatOutputStream extends OutputStream {
	/**
	 * The string that we are building from the output stream. Once it is done, we
	 * print it to the MC chat and clear it.
	 */
	private StringBuilder stringBuilder = new StringBuilder();
	/**
	 * Set to true once we get the carriage return (13) and we know that if a
	 * newline is the next char, end the string.
	 */
	private boolean gottenCarriage = false;

	@Override
	public void write(int b) throws IOException {
		if (b == 13) { // Carriage return
			this.gottenCarriage = true;
		} else if (b == 10 && this.gottenCarriage) { // New line.
			FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList()
					.sendMessage(this.getChat(this.stringBuilder.toString()));

			/*
			 * EntityPlayerSP p = Minecraft.getMinecraft().player; if(p != null) {
			 * Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(this.getChat
			 * (this.stringBuilder.toString())); } else {
			 * this.msg(this.stringBuilder.toString()); }
			 */
			this.stringBuilder.setLength(0);
			this.gottenCarriage = true;
		} else {
			char character = (char) b;
			this.stringBuilder.append(character == '&' ? Util.SECTION_SIGN : character == '\t' ? "    " : character);
		}
	}

	/**
	 * @return The message to add the the player's chat.
	 */
	public TextComponentString getChat(String message) {
		return new TextComponentString(TextFormatting.WHITE + message);
	}
}
