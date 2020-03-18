package me.retrooper.skyscript.data.vars;

import me.retrooper.skyscript.datatypes.var.VariableType;

public class Var {
	private String name;
	private VariableType type;
	private Object value;
	public Var(String name, VariableType type, Object value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public VariableType getType() {
		return type;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	

}
