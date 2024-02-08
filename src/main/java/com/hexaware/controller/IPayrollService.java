package com.hexaware.controller;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.entity.Payroll;
import com.hexaware.exception.PayrollGenerationException;

/**
 * Interface for managing the payroll operation.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */

public interface IPayrollService {
	/**
	 * Generate the payroll for the employee.
	 * 
	 * @throws PayrollGenerationException
	 */
	public void generatePayroll() throws PayrollGenerationException;
	/**
	 * Retrieve and display the payrolls for the specific payrollId.
	 * 
	 * @param searchpid
	 * @return
	 */
	Payroll getPayrollById(int searchpid);
	/**
	 * Retrieve and display the payrolls for the specific employeeId.
	 * 
	 * @param employeeId
	 * @return
	 */
	public List<Payroll> getPayrollsForEmployee(int employeeId);
	/**
	 * Retrieve and display the payrolls for the specific period.
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Payroll> getPayrollsForPeriod(LocalDate startDate,LocalDate endDate);
	
}
