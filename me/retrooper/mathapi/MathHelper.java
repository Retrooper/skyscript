package me.retrooper.mathapi;

import me.retrooper.mathapi.executor.MathAPIExecutor;
import me.retrooper.mathapi.number.MathNumber;
import me.retrooper.mathapi.number.enums.NumberType;

/**
 * MathHelper class
 * @author Retrooper
 *
 */
public class MathHelper {

	/**
	 * Hide or display MathAPI debugs
	 */
	public static boolean silentMode = false;
	/**
	 * All supported operators
	 */
	public static String[] operators = new String[] { "+", "-", "*", "/" };

	/**
	 * Debug a message with the MathAPI only if silenceMode is set to false
	 * 
	 * The default value of silenceMode is false
	 * 
	 * @param msg
	 */
	public static void debug(String message) {
		if (!silentMode) {
			System.out.println("[MathAPI]: " + message);
		}
	}

	/**
	 * Debug a message with the MathAPI only if silenceMode is set to false
	 * 
	 * The default value of silenceMode is false
	 * 
	 * @param msg
	 */
	public static void debug(Object obj) {
		if (!silentMode) {
			debug(obj + "");
		}
	}
	
	/**
	 * Log a custom message with the MathAPI (bypass silence mode)
	 * @param msg
	 */
	public static void log(String message) {
		System.out.println(message);
	}

	/**
	 * Evaluate synchronously
	 * 
	 * @param calc
	 * @return result
	 */
	public static String eval(String calculation) {
		return execute(calculation);
	}
	/**
	 * Private execution method
	 * 
	 * @param text
	 * @return result
	 */
	private static String execute(String text) {
		MathAPIExecutor mb = new MathAPIExecutor(text);
		double val = mb.execute();
		// CAN THE RESULT BE REPLACED WITH AN INTEGER?
		MathNumber number = null;
		if (!mb.containsDecimals(val)) {
			number = new MathNumber(val, NumberType.INTEGER);
		} else {
			number = new MathNumber(val, NumberType.FLOATING);
		}
		return convertCorrectType(number);
	}

	/**
	 * Return the value as integer or as a floating number.
	 * 
	 * @param number
	 * @return handled number
	 */
	public static String convertCorrectType(MathNumber number) {
		if (number.getType().equals(NumberType.INTEGER)) {
			return number.getIntValue() + "";
		}
		return number.getValue() + "";
	}

}
