package com.codeshaper.ms3.util.textBuilder;

import net.minecraft.util.text.TextComponentTranslation;

/**
 * @author CodeShaper
 */
public class TextBuilderTrans extends TextBuilder {

	public TextBuilderTrans(String key, Object... args) {
		super(new TextComponentTranslation(key, args));
	}
}
