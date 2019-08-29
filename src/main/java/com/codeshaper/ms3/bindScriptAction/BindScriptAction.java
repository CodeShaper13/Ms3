package com.codeshaper.ms3.bindScriptAction;

import javax.annotation.Nullable;

import com.codeshaper.ms3.script.RunnableScript;

/**
 * BindScriptActions are created when the /bindscript command and saved until
 * the player clicks with the Script Binder item.
 */
public class BindScriptAction {

	/**
	 * This will be null if the action is to clear or check the current scripts.
	 */
	@Nullable
	private final RunnableScript runnableScript;
	private final BSAction action;

	public BindScriptAction(BSAction action) {
		this(null, action);
	}

	public BindScriptAction(RunnableScript runnableScript, BSAction action) {
		this.runnableScript = runnableScript;
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
	 * Returns the action that this BindScriptAction should preform.
	 */
	public BSAction getAction() {
		return this.action;
	}
}
