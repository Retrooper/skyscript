package me.retrooper.skyscript.datatypes;

public interface DataTypeHandler {
	public static DataType getType(String line) {
		if(line.endsWith(")") && !line.contains("{") && !line.contains("}")) {
			//CALLING A FUNCTION
			return DataType.CALL_FUNCTION;
		}
		int size = line.trim().split(" ").length;
		if(size == 4) {
			//A VARIABLE HAS 4 PARTS
			return DataType.VARIABLE;
		}
		if(line.startsWith("//")) {
			//SKIP SINCE IT IS A COMMENT
			return DataType.SKIP;
		}
		return DataType.SKIP;
	}
}
