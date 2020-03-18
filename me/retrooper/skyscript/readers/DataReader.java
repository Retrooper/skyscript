package me.retrooper.skyscript.readers;

import me.retrooper.skyscript.datatypes.DataType;
/**
 * 
 * @author Retrooper
 */
public class DataReader {
	private DataType type;
	public DataReader(DataType type) {
		this.type = type;
	}
	
	/**
	 * Line arguments, split for each spacing
	 * @param args
	 */
	public void handle(String[] args) {
		
	}
	
	/**
	 * Get the type of data that is being handled
	 * @return
	 */
	public DataType getType() {
		return type;
	}
}
