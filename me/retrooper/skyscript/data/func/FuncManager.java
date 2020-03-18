package me.retrooper.skyscript.data.func;

import java.util.ArrayList;

public class FuncManager {
	public static ArrayList<Func> funcs = new ArrayList<Func>();
	
	public static boolean addFunc(Func f) {
		if(!funcExists(f.getName())) {
			funcs.add(f);
			return true;
		}
		return false;
	}
	
	public static Func getFunc(String name) {
		for(int i = 0; i < funcs.size(); i++) {
			if(funcs.get(i).getName().equalsIgnoreCase(name)) {
				return funcs.get(i);
			}
		}
		return null;
	}
	
	public static boolean funcExists(String name) {
		return getFunc(name) != null;
	}

}
