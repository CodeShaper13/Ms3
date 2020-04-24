package com.codeshaper.ms3.script;

import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyList;

import com.codeshaper.ms3.api.executor;
import com.codeshaper.ms3.api.executor.Executor;

/**
 * A script that can be run after a delay.
 *
 * @author CodeShaper
 */
public class ScheduledScript extends RunnableScript {

	/** The executor that scheduled this script to run. */
	private executor.Executor executor;
	/** How many ticks until this script will execute. */
	private int ticks;

	/**
	 * @param pathToScript
	 * @param sender
	 * @param ticksUntil
	 * @param args
	 * @throws PyException In the form of a ValueError if ticksUntil is less than 0.
	 */
	public ScheduledScript(String pathToScript, executor.Executor sender, int ticksUntil, PyList args)
			throws PyException {
		super(pathToScript, args);

		this.executor = sender;

		if (ticksUntil < 0) {
			throw Py.ValueError("ticksUntil must be greater or equal to 0!");
		}
		this.ticks = ticksUntil;
	}

	public Executor getExecutor() {
		return executor;
	}

	/**
	 * Reduces the number of ticks until this script runs.
	 * 
	 * @return True is returned if the script should execute this tick.
	 */
	public boolean reduceTime() {
		this.ticks -= 1;
		return ticks <= 0;
	}
}
