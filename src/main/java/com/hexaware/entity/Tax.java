package com.hexaware.entity;

/**
 * The 'Tax' class represents the tax information of the employee.
 * It has various attributes such as taxId, employeeId, taxYear, taxableIncome and taxAmount.
 * 
 * This class is used to create, access and retrieve the tax information.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */

public class Tax {
	
	private int taxID;
	private int employeeID;
	private int taxYear;
	private float taxableIncome;
	private float taxAmount;
	public int getTaxID() {
		return taxID;
	}
	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}
	public float getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(float taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	public float getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}
	@Override
	public String toString() {
		return "Tax [taxID=" + taxID + ", employeeID=" + employeeID + ", taxYear=" + taxYear + ", taxableIncome="
				+ taxableIncome + ", taxAmount=" + taxAmount + "]";
	}
	
}
