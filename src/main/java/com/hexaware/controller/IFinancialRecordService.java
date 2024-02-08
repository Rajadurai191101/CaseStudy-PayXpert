package com.hexaware.controller;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.entity.FinancialRecord;

/**
 * Interface for managing the financial record operations
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */

public interface IFinancialRecordService {
	
	/**
	 * Adds the financial record to the database.
	 */
	public void addFinancialRecord();
	/**
	 * Retrieve and display the financial record for the specific recordId.
	 * @param recordId
	 */
	public FinancialRecord getFinancialRecordById(int recordId);
	/**
	 * Retrieve and  display the financial record for the specific employeeId.
	 * @param employeeId
	 */
	public FinancialRecord getFinancialRecordsForEmployee(int employeeId);
	/**
	 * Retrieve and display the financial record for the specific date.
	 * @param date
	 */
	public List<FinancialRecord> getFinancialRecordsForDate(LocalDate date);
	
}
