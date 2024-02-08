package com.hexaware.exception;
/**
 * This class is for EmployeeNotFoundException.
 * 
 * @author Rajadurai M
 *
 */
public class EmployeeNotFoundException extends Exception {
	
	/**
	 * Default constructor for the EmployeeNotFoundException class.
	 */
	public EmployeeNotFoundException() {
		super();
		System.out.println("Enter valid employee.Try again");
	}
	/**
	 * Constructor  for EmployeeNotFoundException class with message.
	 * @param message
	 */
	public EmployeeNotFoundException(String message) {
		super(message);
		System.err.println("EmployeeNotFound"+message);
	}

	@Override
	public String toString() {
		return "EmployeeNotFoundException";
	}

}
