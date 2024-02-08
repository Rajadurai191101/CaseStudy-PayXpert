package com.hexaware.exception;

/**
 * The 'DatabaseConnectionException' class handles the database related exceptions.
 * @author Rajadurai M
 */
public class DatabaseConnectionException extends Exception{
	/**
	 * Default constructor for DatabaseConnectionException class.
	 */
	public DatabaseConnectionException() {
		super();
		System.out.println("DatabaseConnectionException");
	}

	/**
	 * Constructor for DatabaseConnectionException with message.
	 * @param message
	 */
	public DatabaseConnectionException(String message) {
		super(message);
		System.out.println("DatabaseConnectionException"+message);
	}

	@Override
	public String toString() {
		return "DatabaseConnectionException []";
	}
	

}
