package me.retrooper.mathapi.exceptions;
/**
 * @author Retrooper
 */
@SuppressWarnings("serial")
public class InvalidParenthesesException extends RuntimeException {
	/**
	 * This exception is thrown when a parenthesis is missing
	 * @param msg 
	 * @param err
	 */
	public InvalidParenthesesException(String msg) {
        super(msg);
    }
}
