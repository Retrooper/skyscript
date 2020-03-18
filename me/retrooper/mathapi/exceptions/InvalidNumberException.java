package me.retrooper.mathapi.exceptions;

/**
 * @author Retrooper
 */
@SuppressWarnings("serial")
public class InvalidNumberException extends RuntimeException {

	/**
	 * This exception is thrown when an invalid character is trying to be evaluated
	 * @param msg 
	 * @param err
	 */
	public InvalidNumberException(String msg, Throwable err) {
        super(msg, err);
    }
	
	
}
