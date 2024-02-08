package com.hexaware.exception;
/**
 * This class is for PayrollGenerationException.
 * 
 * @author Rajadurai M
 *
 */
public class PayrollGenerationException extends Exception  {
	/**
	 * Default constructor for PayrollGenerationException class.
	 */
	public PayrollGenerationException() {
		super();
		System.out.println("PayrollGenerationException");
	}
	/**
	 * Constructor for PayrollGenerationException class with message.
	 * @param message
	 */
	public PayrollGenerationException(String message) {
		super(message);
		System.out.println("PayrollGenerationException"+message);
	}

	@Override
	public String toString() {
		return "PayrollGenerationException []";
	}

}
