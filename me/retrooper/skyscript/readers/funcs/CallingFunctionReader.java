package me.retrooper.skyscript.readers.funcs;

import me.retrooper.mathapi.MathHelper;
import me.retrooper.skyscript.Runner;
import me.retrooper.skyscript.data.vars.VarManager;
import me.retrooper.skyscript.datatypes.DataType;
import me.retrooper.skyscript.datatypes.var.VariableType;
import me.retrooper.skyscript.readers.DataReader;

public class CallingFunctionReader extends DataReader {

    public CallingFunctionReader() {
        super(DataType.CALL_FUNCTION);
    }

    @Override
    public void handle(String[] args) {
        String name = args[0].substring(0, args[0].indexOf("(")).trim();
        String params = args[0].substring(args[0].indexOf("(") + 1, args[0].lastIndexOf(")"));

        // SYSTEM BUILT FUNCTION CHECK!!!
        if ("print".equals(name)) {
            String result = "";
            if (params.contains(">")) {
                String tempStr = "";
                for (String part : params.split(">")) {
                    if (part.trim().startsWith("'") && part.trim().endsWith("'")) {
                        part = part.substring(part.indexOf("'") + 1, part.lastIndexOf("'"));
                    } else if (VariableType.getType(part) == VariableType.NUM) {
                        part = MathHelper.eval(part);
                    } else {
                        //ITS A VARIABLE
                        part = part.trim();
                        part = VarManager.getVar(part).getValue() + "";
                        if (VariableType.getType(part) == VariableType.NUM) {
                            part = MathHelper.eval(part);
                        }
                    }
                    tempStr += part;
                }
                result = tempStr;
            } else {
                // SIMILAR AS VARIABLE READER..
                VariableType type = VariableType.getType(params);
                if (type.equals(VariableType.STR)) {
                    if (params.startsWith("'") && params.endsWith("'")) {
                        params = params.substring(1, params.length() - 1);
                    } else {
                        //VARIABLE
                        params = VarManager.getVar(params).getValue() + "";
                        if (VariableType.getType(params) == VariableType.NUM) {
                            params = MathHelper.eval(params);
                        }
                    }
                } else if (type.equals(VariableType.NUM)) {
                    params = MathHelper.eval(params); // math operations supported
                } else {

                }
                result = params;

            }
            Runner.log(result);
        }
    }

}
