package com.codeshaper.ms3.util;

import java.lang.reflect.AnnotatedElement;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.util.textBuilder.TextBuilder;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Util {

	public static final char SECTION_SIGN = '§';

	private Util() {
	}

    /**
     * @deprecated use {@link TextBuilder}
     */
	@Deprecated
	public static ITextComponent withColor(String text, TextFormatting format, Object... args) {
		ITextComponent textcomponent = new TextComponentTranslation(text, args);
		textcomponent.getStyle().setColor(format);
		GameRegistry.getFuelValue(null);
		return textcomponent;
	}

	/**
	 * Returns the {@link PythonDocString} doc string from an
	 * {@link AnnotatedElement} if it has one, or null if the annotation isn't
	 * found.
	 */
	public static @Nullable String getPydValue(AnnotatedElement element) {
		PythonDocString pythonDocString = element.getAnnotation(PythonDocString.class);
		return pythonDocString != null && !StringUtils.isBlank(pythonDocString.value()) ? pythonDocString.value()
				: null;
	}

	/**
	 * Takes in a String with ampersands for color codes and replaces them with
	 * {@link SECTION_SIGN}.
	 */
	public static String correctColorCode(String string) {
		return string.replace('&', SECTION_SIGN);
	}
}
