package com.codeshaper.ms3.apiBuilder.module;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Indicates that this class's data can be written to a Python file. Used by the
 * classes in {@link com.codeshaper.ms3.module } package.
 * 
 * @author CodeShaper
 */
public interface IWritable {

	/**
	 * Writes the contents of the class to a Python File.
	 * 
	 * @param indent
	 *            A string containing the spaces to apply an indent to the contents.
	 * @param br
	 *            The {@link BufferedWriter} to write to.
	 * @throws IOException
	 *             If there was a problem writing to the file.
	 */
	public void write(String indent, BufferedWriter br) throws IOException;
}
