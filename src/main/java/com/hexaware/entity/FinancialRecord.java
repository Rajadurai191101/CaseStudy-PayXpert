package com.hexaware.entity;

import java.time.LocalDate;
/**
 * The 'FinancialRecord' class represents the financialRecord entity with various attributes
 * such as recordId, employeeId, recordDate, descriptions, amount and recordType
 * 
 * It helps to retrieve and set the attributes.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class FinancialRecord {

	private int recordID;
	private int employeeID;
	private LocalDate recordDate;
	private String description;
	private float amount;
	private String recordType;
	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public LocalDate getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(LocalDate recordDate) {
		this.recordDate = recordDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	@Override
	public String toString() {
		return "FinancialRecord [recordID=" + recordID + ", employeeID=" + employeeID + ", recordDate=" + recordDate
				+ ", description=" + description + ", amount=" + amount + ", recordType=" + recordType + "]";
	}
	
	
}
