package com.hexaware.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.PayrollDAO;
import com.hexaware.entity.Payroll;
import com.hexaware.exception.PayrollGenerationException;
/**
 * The 'PayrollService' class represents the operations of the payrolls.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class PayrollService implements IPayrollService {
	
	List<Payroll> payrollList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	PayrollDAO pdao = new PayrollDAO();
	Payroll pr;
	
	public void generatePayroll() throws PayrollGenerationException {
		pr = new Payroll();
		System.out.println("Enter emp id:");
		int eid = sc.nextInt();
		pr.setEmployeeID(eid);
//		System.out.println("Enter pay id");
//		int pid = sc.nextInt();
//		pr.setPayrollID(pid);
		System.out.println("Enter start date:");
		String sdate = sc.next();
		LocalDate psd = LocalDate.parse(sdate);
		pr.setPayPeriodStartDate(psd);
		System.out.println("Enter End date:");
		String edate = sc.next();
		LocalDate ped = LocalDate.parse(edate);
		pr.setPayPeriodEndDate(ped);
		System.out.println("Enter basic Salary");
		float basic =sc.nextFloat();
		pr.setBasicSalary(basic);
		System.out.println("Enter overtimepay");
		float otpay =sc.nextFloat();
		pr.setOvertimePay(otpay);
		System.out.println("Enter Deduction");
		float deduct =sc.nextFloat();
		pr.setDeductions(deduct);
		
//		pr.setNetSalary(pr.getBasicSalary()-pr.getDeductions()+pr.getOvertimePay());
		payrollList.add(pr);
		System.out.println(pr);
		pdao.genPayroll(pr);
	}
	
	public Payroll getPayrollById(int payrollId) {
		for(Payroll pr : payrollList) {
			if(pr.getPayrollID() == payrollId) {
				return pr;
			}
		}
		pdao.getPayForPId(payrollId);
		return null;
		
	}
	public List<Payroll> getPayrollsForEmployee(int employeeId) {
		List<Payroll> empPayroll = new ArrayList<>();
		for(Payroll pr : payrollList) {
			if(pr.getEmployeeID() == employeeId) {
				empPayroll.add(pr);
			}
		}
		pdao.getPayForEmpId(employeeId);
		return empPayroll;
	}
	public List<Payroll> getPayrollsForPeriod(LocalDate startDate,LocalDate endDate) {
		List<Payroll> perPayroll = new ArrayList<>();
		for(Payroll pr : payrollList) {
			if(pr.getPayPeriodStartDate().compareTo(startDate) >= 0 &&
					pr.getPayPeriodEndDate().compareTo(endDate)<=0) {
				perPayroll.add(pr);
			}
		}
		pdao.getPayforPeriod(startDate, endDate);
		return perPayroll;
	}

	
}
