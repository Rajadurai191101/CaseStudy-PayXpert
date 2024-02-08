package com.hexaware.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.EmployeeDAO;
import com.hexaware.entity.Employee;
import com.hexaware.exception.EmployeeNotFoundException;
/**
 * The 'EmployeeService' class represents the operations of the employee.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class EmployeeService implements IEmployeeService {
	
	List<Employee> employeeList = new ArrayList<>();
	Employee emp;
	EmployeeDAO edao = new EmployeeDAO();
	Scanner sc = new Scanner(System.in);
	
//	public Employee getEmployeeById(int employeeId) {
//		for(Employee emp : employeeList) {
//			if(emp.getEmployeeID() == employeeId) {
//				return emp;
//			}
//		}
//		return null;
//	}
	public Employee getEmployeeById(int employeeId) {
		edao.getEmpById(employeeId);
		return null;
	}
	
	public List<Employee> getAllEmployees() {
		edao.showEmployee(emp);
		return employeeList;
	}
	
	public void addEmployee() {
		emp = new Employee();
//		System.out.println("id");
//		int eid = sc.nextInt();
//		emp.setEmployeeID(eid);
		System.out.println("fname");
		String fname = sc.next();
		emp.setFirstName(fname);
		System.out.println("lname");
		String lname = sc.next();
		emp.setLastName(lname);
		System.out.println("dob");
		String dobString = sc.next();
		LocalDate dob = LocalDate.parse(dobString);
		emp.setDateOfBirth(dob);
		System.out.println("gender");
		String gender = sc.next();
		emp.setGender(gender);
		System.out.println("email");
		String email = sc.next();
		emp.setEmail(email);
		System.out.println("pno");
		long pno = sc.nextLong();
		emp.setPhoneNumber(pno);
		System.out.println("address");
		String address = sc.next();
		emp.setAddress(address);
		System.out.println("position");
		String position = sc.next();
		emp.setPosition(position);
		System.out.println("joindate");
		String jdString = sc.next();
		LocalDate jd = LocalDate.parse(jdString);
		emp.setJoiningDate(jd);
		System.out.println("termdate");
		String tdString = sc.next();
		LocalDate td = LocalDate.parse(tdString);
		emp.setTerminationDate(td);
		
		employeeList.add(emp);
		edao.addEmployee(emp);
		
//		System.out.println(employeeList);
		
	}
	public void updateEmployee() throws EmployeeNotFoundException {
//		int index = -1;
//		for(int i =0;i<employeeList.size();i++) {
//			if(employeeList.get(i).getEmployeeID()==updateEmployee.getEmployeeID()) {
//				index = i;
//				break;
//			}
//		}
//		
//		if(index != -1) {
//			employeeList.set(index, updateEmployee);
//			System.out.println("Employee Updated Successfully");
//		}
//		else {
//			System.out.println("Employee not found!");
//		}
		emp = new Employee();
		System.out.println("fname");
		String fname = sc.next();
		emp.setFirstName(fname);
		System.out.println("lname");
		String lname = sc.next();
		emp.setLastName(lname);
		System.out.println("dob");
		String dobString = sc.next();
		LocalDate dob = LocalDate.parse(dobString);
		emp.setDateOfBirth(dob);
		System.out.println("gender");
		String gender = sc.next();
		emp.setGender(gender);
		System.out.println("email");
		String email = sc.next();
		emp.setEmail(email);
		System.out.println("pno");
		long pno = sc.nextLong();
		emp.setPhoneNumber(pno);
		System.out.println("address");
		String address = sc.next();
		emp.setAddress(address);
		System.out.println("position");
		String position = sc.next();
		emp.setPosition(position);
		System.out.println("joindate");
		String jdString = sc.next();
		LocalDate jd = LocalDate.parse(jdString);
		emp.setJoiningDate(jd);
		System.out.println("termdate");
		String tdString = sc.next();
		LocalDate td = LocalDate.parse(tdString);
		emp.setTerminationDate(td);
		System.out.println("id");
		int eid = sc.nextInt();
		emp.setEmployeeID(eid);
		edao.updateEmp(emp);
		
	}
	public void removeEmployee(int id) {
		Iterator<Employee> it = employeeList.iterator();
		while(it.hasNext()) {
			Employee emp = (Employee) it.next();
			if(emp.getEmployeeID() == id) {
				it.remove();
			}
		}
		edao.removeEmp(id);
	}	
}
