package me.retrooper.mathapi.utils;

import me.retrooper.mathapi.MathHelper;
/**
 * @author Retrooper
 */
public class MathUtils {
	/**
	 * Does it need to be calculated? Or is it just a number by itself
	 * @return
	 */
	public static boolean isExecution(String text) {
		for (int i = 0; i < MathHelper.operators.length; i++) {
			if (text.contains(MathHelper.operators[i])) {
				return true;
			}
		}
		return false;
	}
}
