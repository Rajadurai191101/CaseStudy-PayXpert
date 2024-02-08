package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

import com.hexaware.entity.Employee;
import com.hexaware.entity.Payroll;
import com.hexaware.util.SqlConnection;
/**
 * The 'PayrollDAO' class provides the data access operation related to the payroll in the database.
 * 
 * It includes the method to view payrolls, generate payrolls etc.,
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class PayrollDAO {
	
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Payroll pr;
	
	/**
	 * The 'getPayForEmpId' method is used to retrieve the payrolls for the particular employee
	 * from the database.
	 * 
	 * @param employeeId
	 */
	
	public void getPayForEmpId(int employeeId) {
		try {
			con =SqlConnection.getDBConn();
			ps = con.prepareStatement("select payrollID,p.employeeID,e.firstName,e.lastName,PayPeriodStartDate,PayPeriodEndDate,BasicSalary,OvertimePay,Deductions,GrossSalary,NetSalary from payroll as p"
					+ " join employee as e on p.EmployeeID=e.EmployeeID"
					+ " where p.employeeID=?");
			ps.setInt(1, employeeId);
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("PayrollId: "+rs.getInt(1));
				System.out.println("EmployeeId: "+rs.getInt(2));
				System.out.println("FirstName: "+rs.getString(3));
				System.out.println("LastName: "+rs.getString(4));
				System.out.println("PayperiodStart: "+rs.getDate(5));
				System.out.println("PayperiodEnd: "+rs.getDate(6));
				System.out.println("BasicSalary: "+rs.getFloat(7));
				System.out.println("OvertimePay: "+rs.getFloat(8));
				System.out.println("Deduction: "+rs.getFloat(9));
				System.out.println("GrossSalary: "+rs.getFloat(10));
				System.out.println("NetSalary: "+rs.getFloat(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The 'getPayForPId' method is used to retrieve the payrolls for particular employee
	 * using payrollId from the database.
	 * 
	 * @param payrollId
	 */
	public void getPayForPId(int payrollId) {
		try {
			con =SqlConnection.getDBConn();
			ps = con.prepareStatement("select * from payroll where payrollId =?");
			ps.setInt(1, payrollId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("PayrollId: "+rs.getInt(1));
				System.out.println("EmployeeId: "+rs.getInt(2));
				System.out.println("PayperiodStart: "+rs.getDate(3));
				System.out.println("PayperiodEnd: "+rs.getDate(4));
				System.out.println("BasicSalary: "+rs.getFloat(5));
				System.out.println("OvertimePay: "+rs.getFloat(6));
				System.out.println("Deduction: "+rs.getFloat(7));
				System.out.println("GrossSalary: "+rs.getFloat(8));
				System.out.println("NetSalary: "+rs.getFloat(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The 'genPayroll' method is used to insert the data for the payrolls into the database.
	 * 
	 * @param pr
	 */
	public void genPayroll(Payroll pr) {
		
		try {
			con =SqlConnection.getDBConn();
			ps = con.prepareStatement("insert into payroll(employeeId,payperiodstartdate,payperiodenddate,basicsalary,overtimepay,deductions)"
					+"values(?,?,?,?,?,?)");
			ps.setInt(1,pr.getEmployeeID());
			ps.setObject(2, pr.getPayPeriodStartDate());
			ps.setObject(3, pr.getPayPeriodEndDate());
			ps.setFloat(4, pr.getBasicSalary());
			ps.setFloat(5, pr.getOvertimePay());
			ps.setFloat(6, pr.getDeductions());
			int noOfrows = ps.executeUpdate();
			System.out.println(noOfrows+" row inserted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The 'getPayforPeriod' method is used to retrieve the payroll for the payperiod 
	 * from the database.
	 * 
	 * @param startDate
	 * @param endDate
	 */
	public void getPayforPeriod(LocalDate startDate, LocalDate endDate) {
		try {
			con =SqlConnection.getDBConn();
			ps = con.prepareStatement("select * from payroll where payperiodstartdate >= ?"
					+" and payperiodenddate <=?");
			ps.setObject(1, startDate);
			ps.setObject(2, endDate);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("PayrollId: "+rs.getInt(1));
				System.out.println("EmployeeId: "+rs.getInt(2));
				System.out.println("PayperiodStart: "+rs.getDate(3));
				System.out.println("PayperiodEnd: "+rs.getDate(4));
				System.out.println("BasicSalary: "+rs.getFloat(5));
				System.out.println("OvertimePay: "+rs.getFloat(6));
				System.out.println("Deduction: "+rs.getFloat(7));
				System.out.println("GrossSalary: "+rs.getFloat(8));
				System.out.println("NetSalary: "+rs.getFloat(9));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
