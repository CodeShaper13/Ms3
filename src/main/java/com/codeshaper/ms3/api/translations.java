package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

@PythonDocString("Provides text translations.")
public class translations {

	private translations() {
	}

	@SuppressWarnings("deprecation")
	@PythonFunction
	@PythonDocString("Translates the passed unlocalized key to a localized string.")
	public static String translate(String key) {
		return I18n.translateToLocal(key);
	}

	@SuppressWarnings("deprecation")
	@PythonFunction
	@PythonDocString("Translates the passed unlocalized key to a localized string using the passed arguments.")
	public static String translate(String key, Object... args) {
		return I18n.translateToLocalFormatted(key, args);
	}

	@SuppressWarnings("deprecation")
	@PythonFunction
	@PythonDocString("Returns a Block or Items localized name.")
	public static String getLocalizedName(String name, int meta) {
		Item item = itemUtils.getMcItemFromName(name);
		return I18n.translateToLocal(item.getItemStackDisplayName(new ItemStack(item, 0, meta)));
	}
}
