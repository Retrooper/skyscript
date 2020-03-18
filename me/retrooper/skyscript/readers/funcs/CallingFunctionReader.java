package me.retrooper.skyscript.readers.funcs;

import me.retrooper.mathapi.MathHelper;
import me.retrooper.skyscript.Runner;
import me.retrooper.skyscript.datatypes.DataType;
import me.retrooper.skyscript.datatypes.var.VariableType;
import me.retrooper.skyscript.readers.DataReader;

public class CallingFunctionReader extends DataReader {

	public CallingFunctionReader() {
		super(DataType.CALL_FUNCTION);
	}

	@Override
	public void handle(String[] args) {
		String name = args[0].substring(0, args[0].indexOf("("));
		String params = args[0].substring(args[0].indexOf("(") + 1, args[0].lastIndexOf(")"));

		// SYSTEM BUILT FUNCTION CHECK!!!
		if (name.equals("print")) {
			String result = params;
			if (params.contains(">")) {
				String tempStr = "";
				boolean areAllNumeric = true;
				for (String parts : params.split("\\>")) {

					try {
						Double.parseDouble(parts);
					} catch (NumberFormatException ex) {
						areAllNumeric = false;
					}
					if (areAllNumeric) {
						break;
					}

					// print("Hello" > (6 + 2) > "Bye");
					for (String part : params.split(">")) {
						if (part.trim().startsWith("'") && part.trim().endsWith("'")) {
							part = part.substring(part.indexOf("'") + 1, part.lastIndexOf("'"));
						} else if (part.trim().startsWith("(") && part.trim().endsWith(")")) {
							String spaceA = part.substring(0, part.indexOf("("));
							String spaceB = part.substring(part.indexOf(")") + 1, part.length());
							//ADD THE EXTRA SPACES!
							tempStr += spaceA + MathHelper.eval(part) + spaceB;
							continue;
						}
						tempStr += part;
					}
					Runner.log(tempStr);
					return;
				}

				result = MathHelper.eval(params);
			} else {
				// SIMILAR AS VARIABLE READER..
				VariableType type = VariableType.getType(params);
				if (type.equals(VariableType.STR)) {
					if (params.startsWith("\"") && params.endsWith("\"")) {
						params = params.substring(1, params.length() - 1);
					}
				} else if (type.equals(VariableType.NUM)) {
					params = MathHelper.eval(params); // math operations supported

				}
				result = params;

			}
			Runner.log(result);
		}
	}

}
