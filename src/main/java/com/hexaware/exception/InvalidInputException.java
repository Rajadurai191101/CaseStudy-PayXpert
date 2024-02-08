package com.hexaware.exception;

/**
 * This class is for handling the invalid input related issues.
 * @author Rajadurai M
 *
 */
public class InvalidInputException extends Exception {
	/**
	 * Default constructor for InvalidInputException class
	 */
	public InvalidInputException() {
		super();
		System.out.println("Enter valid input");
	}
	/**
	 * Constructor for InvalidInputException class with message
	 * @param message
	 */
	public InvalidInputException(String message) {
		super(message);
		System.out.println("Enter valid input: "+message);
	}

	@Override
	public String toString() {
		return "InvalidInputException []";
	}

	

}
