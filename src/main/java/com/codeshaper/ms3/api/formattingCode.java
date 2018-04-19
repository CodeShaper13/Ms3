package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;

@PythonDocString("Formatting code constants for colored and formatted text.  See minecraft.gamepedia.com/formatting_codes for more.")
public class formattingCode {

	@PythonField
	@PythonDocString("Formatting code prefix character.  It is recomended to use this instead of hard coding it into strings.")
	public static final char __PREFIX = '&';
	
	@PythonField
	public static final String BLACK = formattingCode.__PREFIX + "0";
	@PythonField
	public static final String DARK_BLUE = formattingCode.__PREFIX + "1";
	@PythonField
	public static final String DARK_GREEN = formattingCode.__PREFIX + "2";
	@PythonField
	public static final String DARK_AQUA = formattingCode.__PREFIX + "3";
	@PythonField
	public static final String DARK_RED = formattingCode.__PREFIX + "4";
	@PythonField
	public static final String DARK_PURPLE = formattingCode.__PREFIX + "5";
	@PythonField
	public static final String GOLD = formattingCode.__PREFIX + "6";
	@PythonField
	public static final String GRAY = formattingCode.__PREFIX + "7";
	@PythonField
	public static final String DARK_GRAY = formattingCode.__PREFIX + "8";
	@PythonField
	public static final String BLUE = formattingCode.__PREFIX + "9";
	@PythonField
	public static final String GREEN = formattingCode.__PREFIX + "a";
	@PythonField
	public static final String AQUA = formattingCode.__PREFIX + "b";
	@PythonField
	public static final String RED = formattingCode.__PREFIX + "c";
	@PythonField
	public static final String LIGHT_PURPLE = formattingCode.__PREFIX + "d";
	@PythonField
	public static final String YELLOW = formattingCode.__PREFIX + "e";
	@PythonField
	public static final String WHITE = formattingCode.__PREFIX + "f";
	@PythonField
	public static final String OBFUSCATED = formattingCode.__PREFIX + "k";
	@PythonField
	public static final String BOLD = formattingCode.__PREFIX + "l";
	@PythonField
	public static final String STRIKETHROUGH = formattingCode.__PREFIX + "m";
	@PythonField
	public static final String UNDERLINE = formattingCode.__PREFIX + "n";
	@PythonField
	public static final String ITALIC = formattingCode.__PREFIX + "o";
	@PythonField
	public static final String RESET = formattingCode.__PREFIX + "r";
}
