package com.codeshaper.ms3.api;

import org.python.core.Py;

import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.interpreter.PyInterpreterManager;

@PythonDocString("A collection of static methods for working with the interpreters.")
@Deprecated
public class interpreter {

	private interpreter() {
	}

	@PythonFunction
	@PythonDocString("Creates an interpreter, returning true if it was created successfully.  False if it already existed.")
	public static void create(String interpreterName) {
		interpreter.create(interpreterName, true, true, true);
	}

	@PythonFunction
	@PythonDocString("Creates an interpreter, returning true if it was created successfully.  False if it already existed.")
	public static boolean create(String interpreterName, boolean useMcForIn, boolean useMcForOut, boolean useMcForErr) {
		if (!interpreterName.matches("[a-zA-Z0-9]*")) {
			throw Py.NameError("Interpreter names may only contain numbers and letters!");
		}

		return PyInterpreterManager.instance.newInterpreter(interpreterName, useMcForIn, useMcForOut, useMcForErr);
	}

	@PythonFunction
	@PythonDocString("Deletes an interpreter, returning true if it was deleted.  False if it could not be found.")
	public static boolean delete(String interpreterName) {
		if (interpreterName.equals(PyInterpreter.DEFAULT_NAME)) {
			throw Py.ValueError("You can not delete the default interpreter \"" + PyInterpreter.DEFAULT_NAME);
		}
		return PyInterpreterManager.instance.deleteInterpreter(interpreterName);
	}

	@PythonFunction
	@PythonDocString("Checks is a interpreter exists, returning true if it does.")
	public static boolean exists(String interpreterName) {
		return PyInterpreterManager.instance.exists(interpreterName);
	}

	@PythonFunction
	public static void setStream(String interpreterName, int stream, boolean useMcChat) {
		PyInterpreter interpreter = PyInterpreterManager.instance.getInterpreter(interpreterName);
		if (stream == 0) {
			//interpreter.setStdIn(useMcChat);
		} else if (stream == 1) {
			interpreter.setStdOut(useMcChat);
		} else if (stream == 2) {
			interpreter.setStdErr(useMcChat);
		}
	}
}
