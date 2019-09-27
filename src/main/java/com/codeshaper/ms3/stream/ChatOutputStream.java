package com.codeshaper.ms3.stream;

import java.io.IOException;
import java.io.OutputStream;

import com.codeshaper.ms3.util.Util;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Stream used for output messages, replacing the default python sys.out and
 * acting as a parent for {@link ChatErrorStream}.
 * 
 * @author CodeShaper
 */
public class ChatOutputStream extends OutputStream {
	/**
	 * The string that is being built from the output stream. Once the string is
	 * done, it is printed to the MC chat and the field is cleared.
	 */
	private StringBuilder stringBuilder = new StringBuilder();
	/**
	 * Set to true once the carriage return character (13), is gotten.
	 */
	private boolean gottenCarriage = false;

	@Override
	public void write(int b) throws IOException {
		if (b == 13) { // Carriage return
			this.gottenCarriage = true;
		} else if (b == 10 && this.gottenCarriage) { // New line.
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
			server.getPlayerList().sendMessage(this.getChat(this.stringBuilder.toString()));

			this.stringBuilder.setLength(0);
			this.gottenCarriage = true;
		} else {
			char character = (char) b;
			String s;

			if (character == '&') {
				s = Character.toString(Util.SECTION_SIGN);
			} else if (character == '\t') {
				// Add 4 spaces for \t
				s = "    ";
			} else {
				s = Character.toString(character);
			}

			this.stringBuilder.append(s);
		}
	}

	/**
	 * @return The message to add the the player's chat.
	 */
	public TextComponentString getChat(String message) {
		return new TextComponentString(TextFormatting.WHITE + message);
	}
}
