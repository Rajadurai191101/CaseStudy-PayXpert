package com.hexaware.exception;
/**
 * This class is for FinancialRecordException.
 * 
 * @author Rajadurai M
 *
 */
public class FinancialRecordException extends Exception  {
	/**
	 * Default constructor for FinancialRecordException class.
	 */
	public FinancialRecordException() {
		super();
		System.out.println("FinancialRecordException");
	}
	/**
	 * Constructor for FinancialRecordException class with message.
	 * 
	 * @param message
	 */
	public FinancialRecordException(String message) {
		super(message);
		System.out.println("FinancialRecordException"+message);
	}

	@Override
	public String toString() {
		return "FinancialRecordException []";
	}

}
