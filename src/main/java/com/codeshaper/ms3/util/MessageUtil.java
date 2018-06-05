package com.codeshaper.ms3.util;

import javax.annotation.Nullable;

import com.codeshaper.ms3.util.textBuilder.TextBuilder;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Static methods for sending messages, including errors, to users.
 */
public class MessageUtil {

	private MessageUtil() {
	}

	/**
	 * Sends an error message to the passed {@link ICommandSender}, coloring the
	 * text red and making it bold.
	 * 
	 * @param sender
	 * @param text
	 */
	public static void sendErrorMessage(@Nullable ICommandSender sender, String text) {
		MessageUtil.sendMessage(sender, new TextBuilder(text).color(TextFormatting.RED).bold());
	}

	public static void sendErrorMessage(@Nullable ICommandSender sender, String text, Exception e) {
		MessageUtil.sendErrorMessage(sender, text);
		if (sender != null) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends an error message to every player on the current game. Call whenever you
	 * need to warn the players that there is a problem/error with a script but it
	 * is not obvious what player triggered this, in the event of bound scripts and
	 * objects.
	 * 
	 * @param text
	 * @param exception
	 */
	public static void sendErrorMessageToAll(String text, Exception exception) {
		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		for (EntityPlayerMP player : server.getPlayerList().getPlayers()) {
			MessageUtil.sendErrorMessage(player, text);
		}

		// TODO print to each player.
		exception.printStackTrace();
	}

	/**
	 * Sends a message to the sender, as long as sender is not null.
	 * 
	 * @param sender
	 * @param text
	 */
	public static void sendMessage(@Nullable ICommandSender sender, TextBuilder text) {
		MessageUtil.sendMessage(sender, text.get());
	}

	public static void sendMessage(@Nullable ICommandSender sender, ITextComponent text) {
		if (sender != null) {
			sender.sendMessage(text);
		}
	}
}
