package com.codeshaper.ms3.debug;

import java.io.File;

import org.python.core.Py;
import org.python.core.PyObject;
import org.python.core.PyStringMap;
import org.python.core.PySystemState;
import org.python.core.PyType;
import org.python.util.PythonInterpreter;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.interpreter.PyInterpreter;

public class DebugCode {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		PythonInterpreter i = new PythonInterpreter();
		PySystemState pss = Py.getSystemState();
		String scriptFolderPath = "C:\\Users\\parke\\OneDrive\\Desktop\\Ms3\\run\\ms3\\scripts";
		pss.path.add(new File(scriptFolderPath).getAbsolutePath());
		
		i.execfile(scriptFolderPath + "\\examples\\test\\b.py");
		
		
		PyStringMap map = (PyStringMap)pss.modules;
		for (Object o : map.keys()) {
			//System.out.println(o);
		}
		System.out.println(i.get("__file__"));
	}
	
	public void func(PyObject obj) {
		System.out.println(obj.toString());
		System.out.println(obj.getClass());
		System.out.println(obj.getDict().toString());
		
		PyType type = (PyType) obj.getType();
		System.out.println(type.getName());
		System.out.println(type.getModule());
		System.out.println(type.fastGetName());
		System.out.println(type.toString());
	}
	
	public void getClassType(PyObject obj) {
		PyType type = ((PyType)obj);
		PyObject module = ((PyType)obj).getModule();
		System.out.println("Location:   " + module.toString());
		System.out.println("Class Name: " + type.getName());

		
		
		System.out.println("");
	}
}
