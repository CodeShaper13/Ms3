package com.codeshaper.ms3.capability;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.python.core.Py;
import org.python.core.PyClass;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyType;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.BoundObject;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.util.MessageUtil;
import com.codeshaper.ms3.util.textBuilder.TextBuilder;
import com.codeshaper.ms3.util.textBuilder.TextBuilderTrans;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.TextFormatting;

/**
 * A wrapper class that holds a {@link BoundObject} that has been attached to an
 * Entity. This class also keeps a reference to what class file created the
 * BoundObject.
 * 
 * @author CodeShaper
 */
public class AttachedScript {

	private RunnableScript script;
	private BoundObject boundObject;

	public AttachedScript(entity.Base<? extends Entity> entity, RunnableScript script) throws PyException {
		this.script = script;

		PyObject type = this.func();
		if (type == null) {
			throw Py.TypeError(
					"A type could not be found with the name of " + this.getExpectedTypeName() + " in the passed file");
		}

		PyObject object = type.__call__(entity, new PyString(script.getScriptName()));
		Object tempObj = object.__tojava__(BoundObject.class);
		if (tempObj == Py.NoConversion) {
			// Assume type name, kind of dirty...
			throw Py.TypeError("Type " + this.getExpectedTypeName() + " must inherit from BoundObject");
		}
		this.boundObject = (BoundObject) tempObj;
	}

	/**
	 * Gets the instance of the {@link BoundObject} object bound to the Entity.
	 */
	public BoundObject getInstance() {
		return this.boundObject;
	}

	/**
	 * Gets the file location of the script that created the BoundObject in the form
	 * of a {@link RunnableScript} object.
	 */
	public RunnableScript getLocation() {
		return this.script;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((script == null) ? 0 : script.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttachedScript other = (AttachedScript) obj;
		if (script == null) {
			if (other.script != null)
				return false;
		} else if (!script.equals(other.script))
			return false;
		return true;
	}

	/**
	 * Returns the name of the class that is expected to be both defined in the
	 * script and extend {@link BoundObject}. This is the script file name,
	 * capitalized.
	 */
	private String getExpectedTypeName() {
		return StringUtils.capitalize(this.script.getScriptName());
	}

	/**
	 * Returns the type of a class with the same name, in uppercase, as the file.
	 * 
	 * @return null if the class does not contain a type with the same name as the
	 *         file.
	 * @throws PyException If there was an error running the script to populate the
	 *                     namespace.
	 */
	@Nullable
	private PyObject func() throws PyException {
		PyInterpreter interpreter = Ms3.getDefaultInterpreter();
		interpreter.primeScript(this.script);
		String targetTypeName = this.getExpectedTypeName();
		PyObject type = interpreter.getVariable(targetTypeName);

		if (type != null && (type instanceof PyType || type instanceof PyClass)) {
			return type;
		} else {
			return null;
		}
	}
}
