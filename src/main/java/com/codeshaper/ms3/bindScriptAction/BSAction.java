package com.codeshaper.ms3.bindScriptAction;

public enum BSAction {
	ADD(0), REMOVE(1), CHECK(2);

	int id;

	private BSAction(int id) {
		this.id = id;
	}
}