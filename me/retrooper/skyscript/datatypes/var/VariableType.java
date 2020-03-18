package me.retrooper.skyscript.datatypes.var;

import me.retrooper.mathapi.utils.MathUtils;

public enum VariableType {
	STR, NUM;

	public static VariableType getType(String text) {
		try {
			return VariableType.valueOf(text.toUpperCase());
		} catch (IllegalArgumentException ex) {
			if (text.startsWith("\"") || text.endsWith("\"")) {
				return STR;
			}
			else if (MathUtils.isExecution(text)) {
				return NUM;
			} else if ((text.contains("+") || text.contains("-") || text.contains("*") || text.contains("/"))) {
				return NUM;
			}
		}
		return STR;
	}
}
