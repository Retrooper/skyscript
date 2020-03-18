package me.retrooper.skyscript.readers.manager;

import me.retrooper.skyscript.readers.DataReader;
import me.retrooper.skyscript.readers.funcs.CallingFunctionReader;
import me.retrooper.skyscript.readers.vars.VariableReader;

public class DataReaderHelper {
	public static DataReader[] readers = new DataReader[] {new VariableReader(), new CallingFunctionReader()};
}
