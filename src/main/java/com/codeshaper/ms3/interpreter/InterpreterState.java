package com.codeshaper.ms3.interpreter;

import org.python.core.PyStringMap;

public class InterpreterState {
	
	public boolean useStandardIn;
	public boolean useStandardOut;
	public boolean useStandardError;
	
	private PyStringMap globals;
	
	public InterpreterState() {
		
	}

	public void setStdOut(boolean useMcChat) {

	}

	public void setStdErr(boolean useMcChat) {

	}
	
	public void clearGlobals() {
		this.globals = new PyStringMap();
	}
}
