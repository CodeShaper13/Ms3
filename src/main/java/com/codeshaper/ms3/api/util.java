package com.codeshaper.ms3.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.python.core.Py;
import org.python.core.PyList;
import org.python.core.PyString;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.exception.MissingScriptException;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.script.ScheduledScript;

import net.minecraft.entity.Entity;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class util {

	/** Static list of all the scheduled scripts. */
	public static final List<ScheduledScript> scheduledScripts = new ArrayList<>();

	private util() {
	}

	@PythonFunction
	@PythonDocString("Returns the Ms3 version as a string.")
	public static PyString getMs3Version() {
		return new PyString(Ms3.MOD_VERSION);
	}

	@PythonFunction
	@PythonDocString("Returns the Minecraft version as a string.")
	public static PyString getMinecraftVersion() {
		return new PyString(ForgeVersion.mcVersion);
	}

	@PythonFunction
	@PythonDocString("Executes a script after a set number of ticks.")
	public static void executeDelayedScript(String pathToScript, int ticksUntil, @PythonTypeExclude Object sender,
			@Nullable PyList args) throws MissingScriptException {

		executor.Executor e = null;
		if (sender instanceof executor.Executor) {
			e = (executor.Executor) sender;
		} else if (sender instanceof entity.Base) {
			e = new executor.Executor(((entity.Base<Entity>) sender).mcEntity);
		} else {
			throw Py.ValueError("sender must be an instance of executor or entity!");
		}

		ScheduledScript scheduledScript = new ScheduledScript(pathToScript, e, ticksUntil, args);
		util.tryThrowMissingScript(scheduledScript);

		util.scheduledScripts.add(scheduledScript);
	}

	/**
	 * Checks if the RunnableScript refers to an actual file and is of type .py.
	 * 
	 * @throws exception.MissingScriptException If the script can't be found in the
	 *                                          event of the file being
	 *                                          moved/deleted or if the file is not
	 *                                          in a valid format.
	 */
	private static void tryThrowMissingScript(ScheduledScript scheduledScript) throws exception.MissingScriptException {
		if (!scheduledScript.exists()) {
			throw Py.ValueError("Script with name " + scheduledScript.getFile().toString()
					+ " could not be found!  Was it moved, renamed or deleted?");
		}
		String fileName = scheduledScript.getFile().getName();

		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (!(extension.equalsIgnoreCase("py"))) {
			throw exception.instance.new MissingScriptException("Script file is not of type .py",
					scheduledScript.getFile().getPath());
		}
	}

	// Whats the point of this?
//	@PythonFunction
//	@PythonDocString("Checks if a variable is defined in the global scope.")
//	public static boolean isDefined(String variableName) {
//		return Ms3.getDefaultInterpreter().exists(variableName);
//	}

	@PythonFunction
	@PythonDocString("Prints text directly to the console.")
	public static void printToConsole(@PythonTypeExclude Object object) {
		System.out.println(object.toString());
	}

	@PythonFunction
	@PythonDocString("For debugging use only.")
	public static void printObjectType(Object obj) {
		System.out.println("Type: " + obj.getClass().toString());
	}

	@PythonFunction
	@PythonDocString("Executes a Minecraft command.  args is an array of command arguments as strings or None can be passed for no arguments.")
	public static void executeMcCommand(String commandName, executor.Executor executor, @Nullable String[] args) {
		if (StringUtils.isBlank(commandName)) {
			throw Py.ValueError("commandName may not be None or only whitespaces");
		}
		if (executor == null) {
			throw Py.ValueError("executor may not be None");
		}

		StringBuilder sb = new StringBuilder(args.length);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				sb.append(" ");
				sb.append(args[i]);
			}
		}
		FMLCommonHandler.instance().getMinecraftServerInstance().commandManager.executeCommand(executor.getSenderObj(),
				commandName + sb.toString());
	}

	@PythonFunction
	@PythonDocString("Returns the path of the script data folder as a string.")
	public static String getScriptDataFolder() {
		return Ms3.dirManager.getScriptDataFolder().getAbsolutePath();
	}
}