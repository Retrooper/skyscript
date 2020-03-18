package me.retrooper.skyscript.data.vars;

import java.util.ArrayList;

public class VarManager {
	public static ArrayList<Var> vars = new ArrayList<Var>();
	
	public static boolean addVar(Var v) {
		if(!varExists(v.getName())) {
			vars.add(v);
			return true;
		}
		return false;
	}
	
	public static Var getVar(String name) {
		for(int i = 0; i < vars.size(); i++) {
			if(vars.get(i).getName().equalsIgnoreCase(name)) {
				return vars.get(i);
			}
		}
		return null;
	}
	
	public static boolean varExists(String name) {
		return getVar(name) != null;
	}
}
