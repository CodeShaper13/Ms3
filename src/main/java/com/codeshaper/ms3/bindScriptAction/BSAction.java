package com.codeshaper.ms3.bindScriptAction;

/**
 * 
 * 
 * @author CodeShaper
 */
public enum BSAction {
	ADD(0),
	REMOVE(1),
	CHECK(2),
	CLEAR(3);

	private int id;

	private BSAction(int id) {
		this.id = id;
	}
}