package com.hexaware.controller;

import java.util.List;

import com.hexaware.entity.Employee;
import com.hexaware.exception.EmployeeNotFoundException;
/**
 * Interface for managing the employee operations
 *  
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */

public interface IEmployeeService {
	/**
	 * Retrieve and display the employee information for the specific employeeId
	 * @param searchId
	 * @throws EmployeeNotFoundException
	 */
	Employee getEmployeeById(int searchId) throws EmployeeNotFoundException;
	/**
	 * Adds the new employee to the database.
	 */
	public void addEmployee();
	/**
	 * Retrieve and display all the employees.
	 * @return 
	 */
	public List<Employee> getAllEmployees();
	/**
	 * Update the existing employee details
	 * @throws EmployeeNotFoundException 
	 */
	public void updateEmployee() throws EmployeeNotFoundException;
	/**
	 * Delete the employee information for the particular employeeId
	 * @param removeId
	 */
	public void removeEmployee(int removeId);

	
	
	
	
}
