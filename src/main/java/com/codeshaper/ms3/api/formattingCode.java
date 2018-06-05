package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;

@PythonDocString("Formatting code constants for colored and formatted text.  See minecraft.gamepedia.com/formatting_codes for more.")
public class formattingCode {

	@PythonFieldGenerated
	@PythonDocString("Formatting code prefix character.  It is recomended to use this instead of hard coding it into strings.")
	public static final char __PREFIX = '&';
	
	@PythonFieldGenerated
	public static final String BLACK = formattingCode.__PREFIX + "0";
	@PythonFieldGenerated
	public static final String DARK_BLUE = formattingCode.__PREFIX + "1";
	@PythonFieldGenerated
	public static final String DARK_GREEN = formattingCode.__PREFIX + "2";
	@PythonFieldGenerated
	public static final String DARK_AQUA = formattingCode.__PREFIX + "3";
	@PythonFieldGenerated
	public static final String DARK_RED = formattingCode.__PREFIX + "4";
	@PythonFieldGenerated
	public static final String DARK_PURPLE = formattingCode.__PREFIX + "5";
	@PythonFieldGenerated
	public static final String GOLD = formattingCode.__PREFIX + "6";
	@PythonFieldGenerated
	public static final String GRAY = formattingCode.__PREFIX + "7";
	@PythonFieldGenerated
	public static final String DARK_GRAY = formattingCode.__PREFIX + "8";
	@PythonFieldGenerated
	public static final String BLUE = formattingCode.__PREFIX + "9";
	@PythonFieldGenerated
	public static final String GREEN = formattingCode.__PREFIX + "a";
	@PythonFieldGenerated
	public static final String AQUA = formattingCode.__PREFIX + "b";
	@PythonFieldGenerated
	public static final String RED = formattingCode.__PREFIX + "c";
	@PythonFieldGenerated
	public static final String LIGHT_PURPLE = formattingCode.__PREFIX + "d";
	@PythonFieldGenerated
	public static final String YELLOW = formattingCode.__PREFIX + "e";
	@PythonFieldGenerated
	public static final String WHITE = formattingCode.__PREFIX + "f";
	@PythonFieldGenerated
	public static final String OBFUSCATED = formattingCode.__PREFIX + "k";
	@PythonFieldGenerated
	public static final String BOLD = formattingCode.__PREFIX + "l";
	@PythonFieldGenerated
	public static final String STRIKETHROUGH = formattingCode.__PREFIX + "m";
	@PythonFieldGenerated
	public static final String UNDERLINE = formattingCode.__PREFIX + "n";
	@PythonFieldGenerated
	public static final String ITALIC = formattingCode.__PREFIX + "o";
	@PythonFieldGenerated
	public static final String RESET = formattingCode.__PREFIX + "r";
}
