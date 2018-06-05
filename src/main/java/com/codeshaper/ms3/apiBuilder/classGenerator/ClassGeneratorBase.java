package com.codeshaper.ms3.apiBuilder.classGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.text.WordUtils;

/**
 * Used to generate java source files.
 * 
 * @author CodeShaper
 */
public abstract class ClassGeneratorBase {

	private List<CGField> fields = new ArrayList<CGField>();
	private List<String> moreImports = new ArrayList<String>();
	private String docString;

	public final void generateClass(String name, File outputFolder) {
		String upperName = WordUtils.capitalize(name);
		String className = name + "s";

		File f = new File(outputFolder, className + ".java");

		try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (BufferedWriter br = new BufferedWriter(new FileWriter(f))) {
			br.write("package com.codeshaper.ms3.api;\n");
			br.write("\n");
			br.write("import org.python.core.PyString;\n");
			br.write("import org.python.core.PyList;\n");
			br.write("\n");
			br.write("import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;\n");
			br.write("import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;\n");
			br.write("import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;\n");
			br.write("import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;\n");
			br.write("\n");

			if (this.moreImports.size() > 0) {
				for (String s : this.moreImports) {
					br.write("import " + s + ";\n");
				}
				br.write("\n");
			}

			br.write("@PythonClass\n");
			br.write("@PythonDocString(\"A list of all the vanilla " + upperName + " names.\")\n");
			br.write("public class " + className + " {\n");
			br.write("\n");
			br.write("    private static PyList names = new PyList();\n");
			br.write("\n");
			br.write("    private " + className + "() { }\n");
			br.write("\n");

			this.addFields(className);

			for (CGField field : this.fields) {
				String value = field.value.toString();

				br.write("    @PythonFieldGenerated\n");
				br.write("    public static final String " + field.name + " = func(\"" + value + "\");\n");
			}

			String pluralName = upperName + "s";

			br.write("\n");
			br.write("    @PythonFunction\n");
			if (this.docString != null) {
				br.write("    @PythonDocString(\"" + this.docString + "\")\n");
			}
			br.write("    public static PyList getAll" + pluralName + "() {\n");
			br.write("        return names;\n");
			br.write("    }\n");
			br.write("\n");
			br.write("    private static String func(String s) {\n");
			br.write("        names.add(new PyString(s));\n");
			br.write("        return s;\n");
			br.write("    }\n");
			br.write("}");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract void addFields(String nameName);

	public void addExtraImport(String s) {
		this.moreImports.add(s);
	}

	public void setGetAllDocString(String doc) {
		this.docString = doc;
	}

	public void addField(String name, Object value, @Nullable String docString) {
		this.fields.add(new CGField(name, value, docString));
	}

	public class CGField {

		private String name;
		private Object value;
		private String docString;

		public CGField(String name, Object value, String docString) {
			this.name = name.replace('.', '_');
			this.value = value;
			this.docString = docString;
		}

		public String getName() {
			return name;
		}

		public Object getValue() {
			return value;
		}
		
		public String getDocString() {
			return this.docString;
		}
	}
}
