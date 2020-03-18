package me.retrooper.skyscript.reader;

import me.retrooper.skyscript.datatypes.DataTypeHandler;
import me.retrooper.skyscript.readers.funcs.CallingFunctionReader;
import me.retrooper.skyscript.readers.manager.DataReaderManager;
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
	 * Reading the code.
	 * Seperate each line with a semicolon ";"
	 * Identify what type of line is found(VAR, FUNCTION, SKIP...)
	 * Then handle that line
	 * @param code
	 */
	public void read(String code) {
		// var name = "Retrooper";
		// var age = 14;
		for (String line : code.split(";")) {
			for (int i = 0; i < DataReaderManager.readers.length; i++) {
				if (DataTypeHandler.getType(line).equals(DataReaderManager.readers[i].getType())) {
					//PASS IN ARGUMENTS
					if(DataReaderManager.readers[i] instanceof CallingFunctionReader) {
						String[] arr = new String[] {line};
						DataReaderManager.readers[i].handle(arr);
						continue;
					}
					DataReaderManager.readers[i].handle(line.trim().split(" "));
				}
			}
		}
	}

	public void read() {
		read(this.code);
	}
}