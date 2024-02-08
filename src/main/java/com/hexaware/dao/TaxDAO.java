package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.hexaware.entity.Payroll;
import com.hexaware.util.SqlConnection;
/**
 * The 'TaxDAO' class provides the data access operation related to the tax in the database.
 * 
 * It includes the method to view tax and calulate tax.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class TaxDAO {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	/**
	 * The 'getTaxbyId' method is used retrieve the tax details
	 * for the particular TaxId from the database.
	 * 
	 * @param taxId
	 */
	public void getTaxbyId(int taxId) {
		try {
			con =SqlConnection.getDBConn();
			ps = con.prepareStatement("select * from tax where taxId =?");
			ps.setInt(1, taxId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("TaxId: "+rs.getInt(1));
				System.out.println("EmployeeId: "+rs.getInt(2));
				System.out.println("TaxYear: "+rs.getInt(3));
				System.out.println("TaxableIncome: "+rs.getFloat(4));
				System.out.println("TaxAmount: "+rs.getFloat(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The 'getTaxesForEmployee' method is used to retrieve the tax 
	 * for particular employeeId from the database.
	 * 
	 * @param employeeId
	 */
	public void getTaxesForEmployee(int employeeId) {
		try {
			con =SqlConnection.getDBConn();
			ps = con.prepareStatement("select TaxID, e.EmployeeID,e.FirstName,e.LastName,TaxYear, TaxableIncome, TaxAmount from tax as t"
					+ " join employee as e on t.EmployeeID = e.EmployeeID"
					+ " where t.EmployeeID=?");
			ps.setInt(1, employeeId);
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("TaxId: "+rs.getInt(1));
				System.out.println("EmployeeId: "+rs.getInt(2));
				System.out.println("FirstName: "+rs.getString(3));
				System.out.println("LastName: "+rs.getString(4));
				System.out.println("TaxYear: "+rs.getInt(5));
				System.out.println("TaxableIncome: "+rs.getFloat(6));
				System.out.println("TaxAmount: "+rs.getFloat(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The 'getTaxesForYear' method is used to retrieve the tax
	 * for the particular taxyear from the database.
	 * 
	 * @param year
	 */
	public void getTaxesForYear(int year) {
		try {
			con =SqlConnection.getDBConn();
			ps = con.prepareStatement("select * from tax where taxyear = ?");
			ps.setInt(1, year);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("TaxId: "+rs.getInt(1));
				System.out.println("EmployeeId: "+rs.getInt(2));
				System.out.println("TaxYear: "+rs.getInt(3));
				System.out.println("TaxableIncome: "+rs.getFloat(4));
				System.out.println("TaxAmount: "+rs.getFloat(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
