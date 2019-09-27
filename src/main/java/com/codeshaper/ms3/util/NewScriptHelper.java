package com.codeshaper.ms3.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Static helper methods for writing out the contents of a new script.
 * 
 * @author CodeShaper
 */
public class NewScriptHelper {

	private NewScriptHelper() {
	}
	
	public static void writeImports(File file, boolean addSysImport) throws IOException {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
			br.write("\"\"\"A newly created script.\"\"\"\n\n");
			br.write("import com.codeshaper.ms3.api as ms3\n");
			if(addSysImport) {
				br.write("import sys\n");
			}
			br.write("\n");
		}
	}

	public static void writeExecute(File file) throws IOException {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
			br.write("def execute(world, sender):\n");
			br.write("    assert isinstance(world, ms3.world.World)\n");
			br.write("    assert isinstance(sender, ms3.executor.Executor)\n");
			br.write("\n");
			br.write("    # Begin script below:");
			br.write("\n");
		}
	}
	
	public static void writeGetArgs(File file) throws IOException {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
			br.write("def getArgs(world, sender):\n");
			br.write("    assert isinstance(world, ms3.world.World)\n");
			br.write("    assert isinstance(sender, ms3.executor.Executor)\n");
			br.write("\n");
			br.write("    index = len(sys.argv\n");
			br.write("\n");
		}
	}
}
