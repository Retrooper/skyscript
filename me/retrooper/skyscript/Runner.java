package me.retrooper.skyscript;

import me.retrooper.skyscript.reader.CodeReader;

/**
 * 
 * @author Retrooper Basic scripting language, using MathAPI
 * 
 *         MathAPI Github Link
 * 
 *         {@link https://github.com/Retrooper/mathapi}
 *
 */
public class Runner {
	public static boolean silentMode = false;

	public static void execute(String code) {
		CodeReader reader = new CodeReader(code);
		reader.read();
	}

	public static void debug(String msg) {
		if (!silentMode) {
			System.out.println("[SKYSCRIPT]: " + msg);
		}
	}

	public static void debug(Object obj) {
		debug(obj.toString());
	}

	public static void log(String msg) {
		debug(msg);
	}
}
