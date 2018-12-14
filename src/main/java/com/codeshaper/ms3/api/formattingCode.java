package com.codeshaper.ms3.api;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;

@PythonDocString("Formatting code constants for colored and formatted text.  See minecraft.gamepedia.com/formatting_codes for more.")
public class formattingCode {

	@PythonFieldGenerated
	@PythonDocString("Formatting code prefix character.  It is recomended to use this instead of hard coding it into strings.")
	public static final char PREFIX = '&';	
	@PythonFieldGenerated
	public static final String BLACK = formattingCode.PREFIX + "0";
	@PythonFieldGenerated
	public static final String DARK_BLUE = formattingCode.PREFIX + "1";
	@PythonFieldGenerated
	public static final String DARK_GREEN = formattingCode.PREFIX + "2";
	@PythonFieldGenerated
	public static final String DARK_AQUA = formattingCode.PREFIX + "3";
	@PythonFieldGenerated
	public static final String DARK_RED = formattingCode.PREFIX + "4";
	@PythonFieldGenerated
	public static final String DARK_PURPLE = formattingCode.PREFIX + "5";
	@PythonFieldGenerated
	public static final String GOLD = formattingCode.PREFIX + "6";
	@PythonFieldGenerated
	public static final String GRAY = formattingCode.PREFIX + "7";
	@PythonFieldGenerated
	public static final String DARK_GRAY = formattingCode.PREFIX + "8";
	@PythonFieldGenerated
	public static final String BLUE = formattingCode.PREFIX + "9";
	@PythonFieldGenerated
	public static final String GREEN = formattingCode.PREFIX + "a";
	@PythonFieldGenerated
	public static final String AQUA = formattingCode.PREFIX + "b";
	@PythonFieldGenerated
	public static final String RED = formattingCode.PREFIX + "c";
	@PythonFieldGenerated
	public static final String LIGHT_PURPLE = formattingCode.PREFIX + "d";
	@PythonFieldGenerated
	public static final String YELLOW = formattingCode.PREFIX + "e";
	@PythonFieldGenerated
	public static final String WHITE = formattingCode.PREFIX + "f";
	@PythonFieldGenerated
	public static final String OBFUSCATED = formattingCode.PREFIX + "k";
	@PythonFieldGenerated
	public static final String BOLD = formattingCode.PREFIX + "l";
	@PythonFieldGenerated
	public static final String STRIKETHROUGH = formattingCode.PREFIX + "m";
	@PythonFieldGenerated
	public static final String UNDERLINE = formattingCode.PREFIX + "n";
	@PythonFieldGenerated
	public static final String ITALIC = formattingCode.PREFIX + "o";
	@PythonFieldGenerated
	public static final String RESET = formattingCode.PREFIX + "r";
}
