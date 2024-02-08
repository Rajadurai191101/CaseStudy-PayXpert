package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.hexaware.entity.FinancialRecord;
import com.hexaware.entity.Payroll;
import com.hexaware.util.SqlConnection;
/**
 * The 'FinancialRecordDAO' class provides the data access operation related to the
 * financialRecord in the database.
 * 
 * It includes the method to add the record and view the record.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class FinancialRecordDAO {
	
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Payroll pr;
	
	/**
	 * The 'addRecord' method is used to insert the financialRecord 
	 * into the database.
	 * 
	 * @param fr
	 */
	public void addRecord(FinancialRecord fr) {
		
		try {
			con = SqlConnection.getDBConn();
			ps = con.prepareStatement("insert into financialrecord"+
			"(EmployeeId,RecordDate,Descriptions,Amount,RecordType)"
					+"values(?,?,?,?,?)");
			ps.setInt(1, fr.getEmployeeID());
			ps.setObject(2, fr.getRecordDate());
			ps.setString(3, fr.getDescription());
			ps.setFloat(4, fr.getAmount());
			ps.setString(5, fr.getRecordType());
			int noOfrows = ps.executeUpdate();
			System.out.println(noOfrows +" row inserted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The 'getRecordId' method is used to retrieve the records
	 * for the particular recordId from the database.
	 * @param recordId
	 */
	public void getRecordId(int recordId) {
		con = SqlConnection.getDBConn();
		try {
			ps=con.prepareStatement("select * from financialrecord where recordId=?");
			ps.setInt(1, recordId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("RecordId: "+rs.getInt(1));
				System.out.println("EmployeeId: "+rs.getInt(2));
				System.out.println("RecordDate: "+rs.getDate(3));
				System.out.println("Description: "+rs.getString(4));
				System.out.println("Amount: "+rs.getFloat(5));
				System.out.println("RecordType: "+rs.getString(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The 'getRecordForEmp' method  is used to retrieve the records
	 * for the particular employeeId from the database.
	 * 
	 * @param employeeId
	 */
	public void getRecordForEmp(int employeeId) {
		con = SqlConnection.getDBConn();
		try {
			ps=con.prepareStatement("select RecordID,f.EmployeeID,e.FirstName,e.LastName,RecordDate,Descriptions,Amount,RecordType from financialrecord as f\r\n"
					+ "join employee as e on f.EmployeeID=e.EmployeeID\r\n"
					+ "where f.EmployeeID=?");
			ps.setInt(1, employeeId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("RecordId: "+rs.getInt(1));
				System.out.println("EmployeeId: "+rs.getInt(2));
				System.out.println("Description: "+rs.getString(3));
				System.out.println("Description: "+rs.getString(4));
				System.out.println("RecordDate: "+rs.getDate(5));
				System.out.println("Description: "+rs.getString(6));
				System.out.println("Amount: "+rs.getFloat(7));
				System.out.println("RecordType: "+rs.getString(8));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The 'getRecordForDate' method is used to retrieve the records
	 * for the particular date from the database.
	 * 
	 * @param date
	 */
	public void getRecordForDate(LocalDate date) {
		con = SqlConnection.getDBConn();
		try {
			ps=con.prepareStatement("select * from financialrecord where recordDate=?");
			ps.setObject(1, date);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("RecordId: "+rs.getInt(1));
				System.out.println("EmployeeId: "+rs.getInt(2));
				System.out.println("RecordDate: "+rs.getDate(3));
				System.out.println("Description: "+rs.getString(4));
				System.out.println("Amount: "+rs.getFloat(5));
				System.out.println("RecordType: "+rs.getString(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
