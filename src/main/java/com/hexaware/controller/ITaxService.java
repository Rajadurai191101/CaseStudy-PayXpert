package com.hexaware.controller;

import com.hexaware.entity.Tax;

/**
 * Interface for managing the tax operations.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 *
 */

public interface ITaxService {
	/**
	 * Calulate the tax for the employee.
	 */
	public void calculateTax();
	/**
	 * Retrieve and display the tax for the specific taxId.
	 * @param taxid
	 * @return
	 */
	public Tax getTaxById(int taxid);
	/**
	 * Retrieve and display the tax for the specific employeeId.
	 * @param empid
	 */
	public void getTaxesForEmployee(int empid);
	/**
	 * Retrieve and display the tax for the specific taxYear.
	 * @param year
	 */
	public void getTaxesForYear(int year);
	
}
