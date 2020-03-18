package me.retrooper.mathapi.exceptions;
/**
 * @author Retrooper
 */
@SuppressWarnings("serial")
public class InvalidOperatorException extends RuntimeException {
	/**
	 * This exception is thrown when an invalid operator is being used!
	 * @param msg 
	 * @param err
	 */
	public InvalidOperatorException(String msg) {
        super(msg);
    }
}
