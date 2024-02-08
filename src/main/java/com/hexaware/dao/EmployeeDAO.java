package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Employee;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.util.SqlConnection;
/**
 * The 'EmployeeDAO' class provides the data access operations related to the employees in the database.
 * 
 * It includes the method to show the employee details, insert the employee informations,
 * show the specific employee details and remove the employee.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class EmployeeDAO {
	
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	/**
	 * The 'showEmployee' method is used to view the employee details which are in the database.
	 * 
	 * @param emp
	 */
	
	public List<Employee> showEmployee(Employee emp) {
		List<Employee> list = new ArrayList();
		try {
			con = SqlConnection.getDBConn();
			ps =con.prepareStatement("select * from employee");
			rs = ps.executeQuery();
			
			while(rs.next()) {
			System.out.println("*************");
			int eid = rs.getInt(1);
			System.out.println("EmployeeId: "+rs.getInt(1));
			String fname = rs.getString(2);
			System.out.println("FirstName: "+rs.getString(2));
			String lname = rs.getString(3);
			System.out.println("LastName: "+rs.getString(3));
			Date dob = rs.getDate(4);
			System.out.println("DateOfBirth: "+rs.getDate(4));
			System.out.println("Gender: "+rs.getString(5));
			System.out.println("EmailId: "+rs.getString(6));
			System.out.println("PhoneNumber: "+rs.getLong(7));
			System.out.println("Address: "+rs.getString(8));
			System.out.println("Position: "+rs.getString(9));
			System.out.println("JoiningDate: "+rs.getDate(10));
			System.out.println("TerminationDate: "+rs.getDate(11));
			Employee emp1 = new Employee(eid,fname,lname,dob);
			list.add(emp1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * The 'addEmployee' method is used to insert the employee details into the database.
	 * 
	 * @param emp
	 */
	public void addEmployee(Employee emp) {
		try {
			con =SqlConnection.getDBConn();
			ps = con.prepareStatement("insert into employee"+
			"(FirstName,LastName,DateOfBirth,Gender,Email,PhoneNumber,Address,Positions,JoiningDate,TerminationDate)"
					+"values(?,?,?,?,?,?,?,?,?,?)");
			//ps.setInt(1, emp.getEmpno());
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setObject(3, emp.getDateOfBirth());
			ps.setString(4, emp.getGender());
			ps.setString(5, emp.getEmail());
			ps.setLong(6, emp.getPhoneNumber());
			ps.setString(7, emp.getAddress());
			ps.setString(8, emp.getPosition());
			ps.setObject(9, emp.getJoiningDate());
			ps.setObject(10, emp.getTerminationDate());
			int noOfrows = ps.executeUpdate();
			System.out.println(noOfrows+" row inserted successfully");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * The 'getEmpById' method is used to view the details of the particular employee.
	 * 
	 * @param employeeId
	 * @return 
	 */
	
	public Employee getEmpById(int employeeId) {
		
		try {
			con =SqlConnection.getDBConn();
			ps = con.prepareStatement("select * from Employee where employeeId=?");
			ps.setInt(1, employeeId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("*************");
				System.out.println("EmployeeId: "+rs.getInt(1));
				System.out.println("FirstName: "+rs.getString(2));
				System.out.println("LastName: "+rs.getString(3));
				System.out.println("DateOfBirth: "+rs.getDate(4));
				System.out.println("Gender: "+rs.getString(5));
				System.out.println("EmailId: "+rs.getString(6));
				System.out.println("PhoneNumber: "+rs.getLong(7));
				System.out.println("Address: "+rs.getString(8));
				System.out.println("Position: "+rs.getString(9));
				System.out.println("JoiningDate: "+rs.getDate(10));
				System.out.println("TerminationDate: "+rs.getDate(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * The 'removeEmp' method is used to delete the particular employee details in the database.
	 * 
	 * @param empId
	 */
	
	public void removeEmp(int empId) {
		try {
			con = SqlConnection.getDBConn();
			ps=con.prepareStatement("delete from employee where EmployeeId=?");
			ps.setInt(1, empId);
			
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " deleted Successfully !!!" );
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void updateEmp(Employee emp) throws EmployeeNotFoundException {
		try {
			con =SqlConnection.getDBConn();
			String sql = "update employee set FirstName=?, LastName=?,DateOfBirth=?,Gender=?,Email=?,"+
			"PhoneNumber=?,Address=?,Positions=?,JoiningDate=?,TerminationDate=?"+
					"where employeeId=?";
			ps = con.prepareStatement(sql);
			//ps.setInt(1, emp.getEmpno());
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setObject(3, emp.getDateOfBirth());
			ps.setString(4, emp.getGender());
			ps.setString(5, emp.getEmail());
			ps.setLong(6, emp.getPhoneNumber());
			ps.setString(7, emp.getAddress());
			ps.setString(8, emp.getPosition());
			ps.setObject(9, emp.getJoiningDate());
			ps.setObject(10, emp.getTerminationDate());
			ps.setInt(11, emp.getEmployeeID());
			int noOfrows = ps.executeUpdate();
			if(noOfrows == 0) {
				throw new EmployeeNotFoundException();
			}else {
				System.out.println(noOfrows+" row updated successfully");
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
		}
	}

}
