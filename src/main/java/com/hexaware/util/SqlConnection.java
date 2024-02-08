package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * The 'SqlConnection' class provides the utility for establishing the connection to the database based
 * on the information provided int the database file.
 * 
 * Note: Ensure that the Referenced Libraries has the 'mysql-connector.jar' file.
 * 
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class SqlConnection {
	static Connection con;
	
	/**
	 * Created a method getDBConn() to make connection with the database
	 * 
	 * @return con object is returned.
	 */
	
	public static Connection getDBConn() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PAYXPERTDB","root", "Anburaja45");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
	public static void main(String[] args) {
		System.out.println(getDBConn());

	}

}
