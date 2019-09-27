package com.codeshaper.ms3.script;

import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyList;

import com.codeshaper.ms3.api.executor;
import com.codeshaper.ms3.api.executor.Executor;

/**
 * A script that can be run after a delay.
 */
public class ScheduledScript extends RunnableScript {

	private executor.Executor sender;
	/** How many ticks until this script will execute. */
	private int ticks;

	public ScheduledScript(String pathToScript, executor.Executor sender, int ticksUntil, PyList args)
			throws PyException {
		super(pathToScript, args);

		this.sender = sender;

		if (ticksUntil < 0) {
			throw Py.ValueError("ticksUntil must be greater or equal to 0!");
		}
		this.ticks = ticksUntil;
	}

	public Executor getExecutor() {
		return sender;
	}

	/**
	 * Reduces the number of ticks until this script runs.
	 * 
	 * @return True if the script should execute this tick.
	 */
	public boolean reduceTime() {
		this.ticks -= 1;
		return ticks <= 0;
	}
}
