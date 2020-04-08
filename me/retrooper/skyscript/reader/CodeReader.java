package me.retrooper.skyscript.reader;

import me.retrooper.skyscript.datatypes.DataTypeHandler;
import me.retrooper.skyscript.readers.funcs.CallingFunctionReader;
import me.retrooper.skyscript.readers.manager.DataReaderHelper;
/**
 * 
 * @author Retrooper
 * Read and handle all the code
 *
 */
public class CodeReader {
	private String code;

	public CodeReader(String code) {
		this.code = code;
	}

	/**
	 * This scripting language reads and instantly executes code.
	 * There is no compilation process.
	 * Reading the code.
	 * Seperate each line with a semicolon ";"
	 * Identify what type of line is found(VAR, FUNCTION, SKIP...)
	 * Then handle that line
	 * @param code
	 */
	public void read(String code) {
		for (String line : code.split(";")) {
			for (int i = 0; i < DataReaderHelper.readers.length; i++) {
				if (DataTypeHandler.getType(line).equals(DataReaderHelper.readers[i].getType())) {
					//PASS IN ARGUMENTS
					if(DataReaderHelper.readers[i] instanceof CallingFunctionReader) {
						String[] arr = new String[] {line};
						DataReaderHelper.readers[i].handle(arr);
						continue;
					}
					DataReaderHelper.readers[i].handle(line.trim().split(" "));
				}
			}
		}
	}

	public void read() {
		read(this.code);
	}
}
