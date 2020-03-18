package me.retrooper.skyscript.data.func;

import me.retrooper.skyscript.data.vars.Var;

public class Func {
	private String name;
	private String code;
	private Var[] tempVars;
	public Func(String name, String code, Var[] tempVars) {
		this.name = name;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	
	public Var[] getTempVars() {
		return tempVars;
	}
	
	public boolean isRunning = false;
}
