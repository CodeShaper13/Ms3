package com.codeshaper.ms3;

public enum EnumCallbackType {
	ON_CONSTRUCT(0, "onConstruct"),
	ON_TICK(1, "onTick"),
	ON_LOAD(2, "onLoad"),
	ON_SAVE(3, "onSave"),
	ON_CLICK(4, "onClick");
	
	private final int id;
	private final String name;
	
	private EnumCallbackType(int id, String functionName) {
		this.id = id;
		this.name = functionName;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
}
