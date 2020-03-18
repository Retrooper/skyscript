package me.retrooper.skyscript.readers.vars;

import me.retrooper.mathapi.MathHelper;
import me.retrooper.skyscript.data.vars.Var;
import me.retrooper.skyscript.data.vars.VarManager;
import me.retrooper.skyscript.datatypes.DataType;
import me.retrooper.skyscript.datatypes.var.VariableType;
import me.retrooper.skyscript.exceptions.DuplicateDataException;
import me.retrooper.skyscript.readers.DataReader;

public class VariableReader extends DataReader {

	public VariableReader() {
		super(DataType.VARIABLE);
	}

	@Override
	public void handle(String[] args) {
		VariableType type = VariableType.getType(args[0]);
		String name = args[1];
		String value = args[3];

		if (type.equals(VariableType.STR)) {
			if (value.startsWith("'") && value.endsWith("'")) {
				value = value.substring(1, value.length() - 1);
			}
		} else if (type.equals(VariableType.NUM)) {
			value = MathHelper.eval(value); // math operations supported
		}

		// ADD VARIABLE TO LIST
		Var v = new Var(name, type, value);
		//ADD VARIABLE
		if(!VarManager.addVar(v)) {
			//IF NOT SUCCESSFUL
			throw new DuplicateDataException("You are trying to create a duplicate variable, the variable " + name + " already exists!");
		}
	}

}
