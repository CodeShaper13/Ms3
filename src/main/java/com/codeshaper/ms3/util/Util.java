package com.codeshaper.ms3.util;

import java.lang.reflect.AnnotatedElement;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class Util {

	public static final char SECTION_SIGN = '§';

	private Util() {
	}

	public static ITextComponent withColor(String text, TextFormatting format, Object... args) {
		ITextComponent textcomponent = new TextComponentTranslation(text, args);
		textcomponent.getStyle().setColor(format);
		return textcomponent;
	}

	public static @Nullable String getPydValue(AnnotatedElement element) {
		PythonDocString pythonDocString = element.getAnnotation(PythonDocString.class);
		return pythonDocString != null && !StringUtils.isBlank(pythonDocString.value()) ? pythonDocString.value()
				: null;
	}

	/**
	 * Takes in a String with ampersands for color codes and replaces them with
	 * section signs.
	 */
	public static String correctColorCode(String string) {
		return string.replace('&', SECTION_SIGN);
	}
}
