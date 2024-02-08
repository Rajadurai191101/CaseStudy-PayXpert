package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.EmployeeController;
//import com.hexaware.controller.EmployeeService;
//import com.hexaware.controller.IEmployeeService;
//import com.hexaware.controller.IPayrollService;
//import com.hexaware.controller.PayrollService;
import com.hexaware.exception.PayrollGenerationException;
/**
 * The 'PayXpert' class is the main class. 
 * This is the main entry point of the Payroll Management System.
 * It has the menu driven program makes the user to work through differnt modules,
 * It includes the Employee Operation, Payroll Operation, Tax Operation, Financial Record Operation.
 * The system runs in the loop until the user choose exit.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 * 
 */
public class PayXpert {

	public static void main(String[] args) throws PayrollGenerationException {
		Scanner sc = new Scanner(System.in);
//		IEmployeeService es = new EmployeeService();
//		IPayrollService ps = new PayrollService();
		EmployeeController ec = new EmployeeController();
		System.out.println("************* WELCOME TO PAYXPERT ***************");
		System.out.println();
//		do while loop for menu-driven operation
		String ch = null;
		do {
		System.out.println("1.EmployeeOperation\n2.PayrollOperation\n3.TaxOperation\n4.FinancialOpeartion");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			ec.employeeOperation(); 
			break;
		case 2:
			ec.payrollOperation();
			break;
		case 3:
			ec.taxOperation();
			break;
		case 4:
			ec.financialRecordOperation();
			break;
		default:
			System.out.println("Choose Correct choice");
		}
		System.out.println("To continue press Y or y");
		ch = sc.next();
		}while(ch.equals("Y") || ch.equals("y"));
		System.out.println("Thank you");
		System.exit(0);
	}
}
	
	
