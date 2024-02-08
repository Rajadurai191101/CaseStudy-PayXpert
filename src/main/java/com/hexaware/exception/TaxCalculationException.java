package com.hexaware.exception;

/**
 * This class is for TaxCalculationException.
 * 
 * @author Rajadurai M
 *
 */
public class TaxCalculationException extends Exception  {
	
	/**
	 * Default constructor for TaxCalculationException class.
	 */
	public TaxCalculationException() {
		super();
		System.out.println("TaxCalculationException");
	}
	/**
	 * Constructor for TaxCalculationException class with message.
	 * 
	 * @param message
	 */
	public TaxCalculationException(String message) {
		super(message);
		System.out.println("TaxCalculationException"+message);
	}

	@Override
	public String toString() {
		return "TaxCalculationException []";
	}

}
