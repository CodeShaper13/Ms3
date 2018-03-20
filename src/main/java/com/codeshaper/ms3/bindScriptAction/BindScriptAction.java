package com.codeshaper.ms3.bindScriptAction;

import javax.annotation.Nullable;

import com.codeshaper.ms3.script.RunnableScript;

public class BindScriptAction {

	private final RunnableScript runnableScript;
	private final Action action;

	public BindScriptAction(Action action) {
		this(null, action);
	}
	
	public BindScriptAction(RunnableScript rs, Action action) {
		this.runnableScript = rs;
		this.action = action;
	}

	/**
	 * Returns the script that should be bound to the entity.
	 */
	@Nullable
	public RunnableScript getRunnableScript() {
		return this.runnableScript;
	}

	/**
	 * Returns true if the script should be bound, false if it should be removed.
	 */
	public Action getAction() {
		return this.action;
	}
}
