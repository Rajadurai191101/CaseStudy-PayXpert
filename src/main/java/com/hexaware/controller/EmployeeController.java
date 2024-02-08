package com.hexaware.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.hexaware.entity.Employee;
import com.hexaware.entity.FinancialRecord;
import com.hexaware.entity.Payroll;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.PayrollGenerationException;
/**
 * The 'EmployeeController' class has the whole operations for the system.
 *
 * It includes the methods such as emloyeeOperation, payrollOperation,
 * taxOperation and financialRecordOperation.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class EmployeeController {
	/**
	 * The 'employeeOperation' method has the operations of the employee.
	 */
	public void employeeOperation() {
	Scanner sc = new Scanner(System.in);
	//Employee emp = new Employee();
	IEmployeeService es = new EmployeeService();
	
	String ch = null;
	try {
		do {
		System.out.println("1.GetEmployeeByid,\n2.addEmployee,\n3.getAllEmployees,\n4.updateEmployee,\n5.removeEmployee");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("searchid:");
			int searchId = sc.nextInt();
			Employee foundEmp;
			try {
				foundEmp = es.getEmployeeById(searchId);
				if(foundEmp != null) {
					System.out.println("ID: " +foundEmp.getEmployeeID() +",Name:" +foundEmp.getFirstName()+" "+foundEmp.getLastName()  );
				} else {
					//System.out.println("SearchnotFound");
				}
			} catch (EmployeeNotFoundException enfe) {
				// TODO Auto-generated catch block
				//System.out.println("Not found");
				enfe.printStackTrace();
			}
			break;
		case 2:
			es.addEmployee();
			break;
		case 3:
			es.getAllEmployees();
			break;
		case 4:
			es.updateEmployee();
			break;
		case 5:
			System.out.println("RemoveId");
			int removeId = sc.nextInt();
			es.removeEmployee(removeId);
			break;
		default:
			System.out.println("Enter the correct choice");
			break;
			}
		System.out.println("To continue press Y or y for EmployeeOperation");
		ch = sc.next();
		}while(ch.equals("Y") || ch.equals("y"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	/**
	 * The 'payrollOperation' method has the operations of the payroll.
	 * 
	 * @throws PayrollGenerationException
	 */
	public void payrollOperation() throws PayrollGenerationException {
		Scanner sc = new Scanner(System.in);
		IPayrollService ps = new PayrollService();
		String ch = null;
		
		do {
			System.out.println("1.generatePayroll\n2.getPayrollById\n3.getPayrollsForEmployee\n4.getPayrollsForPeriod");
			int choice =sc.nextInt();
			switch(choice) {
			case 1:
				ps.generatePayroll();
				break;
			case 2:
				System.out.println("Enter pid:");
				int psearchId = sc.nextInt();
				Payroll foundpr = ps.getPayrollById(psearchId);
				
				if(foundpr != null) {
					System.out.println("ID: " +foundpr.getPayrollID() +",NetSalary:" +foundpr.getNetSalary());
				} else {
					//System.out.println("SearchnotFound");
				}
				
				break;
			case 3:
				System.out.println("Enter empid:");
				int esearchId = sc.nextInt();
				ps.getPayrollsForEmployee(esearchId);
				break;
			case 4:
				System.out.println("Enter Satrtdate:");
				String sd = sc.next();
				LocalDate sDate = LocalDate.parse(sd);
				System.out.println("Enter EndDate:");
				String ed = sc.next();
				LocalDate eDate = LocalDate.parse(ed);
				ps.getPayrollsForPeriod(sDate,eDate);
				break;
				
			default:
				System.out.println("Choose Correct choice");
			}
			System.out.println("Enter Y or y to continue Payroll Operation");
			ch = sc.next();
		}while(ch.equals("y") || ch.equals("Y"));
	}
	
	/**
	 * The 'taxOperation' method has the operations of the tax.
	 */
	public void taxOperation() {
		Scanner sc = new Scanner(System.in);
		ITaxService ts = new TaxService();
		String ch = null;
		do {
			System.out.println("1.CalculateTax\n2.getTaxbyId\n3.getTaxesForEmployee\n4.getTaxesForYear");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				ts.calculateTax();
				break;
			case 2:
				System.out.println("Enter TaxId:");
				int taxid = sc.nextInt();
				ts.getTaxById(taxid);
				break;
			case 3:
				System.out.println("Enter EmployeeId:");
				int empid = sc.nextInt();
				ts.getTaxesForEmployee(empid);
				break;
			case 4:
				System.out.println("Enter TaxYear:");
				int year = sc.nextInt();
				ts.getTaxesForYear(year);
				break;
			default:
				System.out.println("Choose the correct choice");
			}
			System.out.println("Enter y or Y to continue TaxOperation");
			ch = sc.next();
		}while(ch.equals("Y") || ch.equals("y"));
	}
	
	/**
	 * The 'financialRecordOperation' method has the operations of the financialRecord.
	 */
	public void financialRecordOperation() {
		Scanner sc = new Scanner(System.in);
		IFinancialRecordService frs = new FinancialRecordService();
		String ch = null;
		do {
			System.out.println("1.addFinancialRecord\n2.getFinancialRecordById\n3.getFinancialRecordsForEmployee\n4.getFinancialRecordsForDate");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				frs.addFinancialRecord();
				break;
			case 2:
				System.out.println("Enter recordId:");
				int recordId= sc.nextInt();
				FinancialRecord foundRid = frs.getFinancialRecordById(recordId);
				
				if(foundRid != null) {
					System.out.println("RecordId: "+foundRid.getRecordID()+"\nEmployeeid:"+foundRid.getEmployeeID()+"\nDesciption:"+foundRid.getDescription()+"\nAmount:"+foundRid.getAmount());
				}else {
					//System.out.println("Search not found");
				}
				break;
			case 3:
				System.out.println("Enter employeeId:");
				int employeeId = sc.nextInt();
				//frs.getFinancialRecordsForEmployee(employeeId);
				
				FinancialRecord foundeid = frs.getFinancialRecordsForEmployee(employeeId);
				
				if(foundeid != null) {
					System.out.println("Employeeid:"+foundeid.getEmployeeID()+"\nDesciption:"+foundeid.getDescription()+"\nAmount:"+foundeid.getAmount());
				} else {
					//System.out.println("Seachnotfound");
				}
				
				break;
			case 4:
				System.out.println("Enter Date:");
				String sd = sc.next();
				LocalDate Date = LocalDate.parse(sd);
				frs.getFinancialRecordsForDate(Date);
				break;
			default:
				System.out.println("Choose the correct choice");
			}
			System.out.println("Enter y or Y to continue FinancialOperation");
			ch = sc.next();
		}while(ch.equals("Y") || ch.equals("y"));
	}
}