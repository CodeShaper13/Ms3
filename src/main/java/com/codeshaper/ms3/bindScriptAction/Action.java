package com.codeshaper.ms3.bindScriptAction;

public enum Action {
	ADD(0), REMOVE(1), CHECK(2);

	int id;

	private Action(int id) {
		this.id = id;
	}
}