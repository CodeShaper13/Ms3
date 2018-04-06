package com.codeshaper.ms3.util.textBuilder;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

/**
 * Helper class for building formatted text strings.
 */
public class TextBuilder {

	private ITextComponent text;
	private Style style;
	
	protected TextBuilder(ITextComponent text) {
		this.text = text;
		this.style = this.text.getStyle();
	}
	
	public TextBuilder(String msg) {
		this(new TextComponentString(msg));
	}
	
	public TextBuilder bold() {
		this.style.setBold(true);
		return this;
	}
	
	public TextBuilder underline() {
		this.style.setUnderlined(true);
		return this;
	}
	
	public TextBuilder obfuscated() {
		this.style.setObfuscated(true);
		return this;
	}
	
	public TextBuilder italic() {
		this.style.setItalic(true);
		return this;
	}
	
	public TextBuilder strike() {
		this.style.setStrikethrough(true);
		return this;
	}
	
	/**
	 * Sets the color of the text.
	 */
	public TextBuilder color(TextFormatting color) {
		this.style.setColor(color);
		return this;
	}
	
	/**
	 * Returns an {@link ITextComponent} representing the text.
	 */
	public ITextComponent get() {
		return this.text;
	}
}
