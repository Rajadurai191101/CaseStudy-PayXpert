package com.hexaware.entity;

import java.time.LocalDate;
/**
 * The 'Payroll' class represents the payroll information of the employee.
 * It has various attributes such as payrollId, employeeId, payPeriodStartDate, payPeriodEndDate,
 * basicSalary, overtimePay, deductions and netsalary.
 * 
 * This class is used to create, access and retrieve the payroll details.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class Payroll {
	
	private int payrollID;
	private int employeeID;
	private LocalDate payPeriodStartDate;
	private LocalDate payPeriodEndDate;
	private float basicSalary;
	private float overtimePay;
	private float deductions;
	private float netSalary;
	
	public int getPayrollID() {
		return payrollID;
	}
	public void setPayrollID(int payrollID) {
		this.payrollID = payrollID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public LocalDate getPayPeriodStartDate() {
		return payPeriodStartDate;
	}
	public void setPayPeriodStartDate(LocalDate payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}
	public LocalDate getPayPeriodEndDate() {
		return payPeriodEndDate;
	}
	public void setPayPeriodEndDate(LocalDate payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	public float getOvertimePay() {
		return overtimePay;
	}
	public void setOvertimePay(float overtimePay) {
		this.overtimePay = overtimePay;
	}
	public float getDeductions() {
		return deductions;
	}
	public void setDeductions(float deductions) {
		this.deductions = deductions;
	}
	public float getNetSalary() {
		return (this.getBasicSalary()+this.getOvertimePay()-this.getDeductions());
	}
	public void setNetSalary(float f) {
		this.netSalary = this.getBasicSalary()+this.getOvertimePay()-this.getDeductions();
	}
	@Override
	public String toString() {
		return "Payroll [payrollID=" + payrollID + ", employeeID=" + employeeID + ", payPeriodStartDate="
				+ payPeriodStartDate + ", payPeriodEndDate=" + payPeriodEndDate + ", basicSalary=" + basicSalary
				+ ", overtimePay=" + overtimePay + ", deductions=" + deductions + ", netSalary=" + netSalary + "]";
	}
	
	
}
