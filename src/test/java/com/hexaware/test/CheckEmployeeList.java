package com.hexaware.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.controller.PayrollService;
import com.hexaware.dao.EmployeeDAO;
import com.hexaware.dao.PayrollDAO;
import com.hexaware.entity.Employee;
import com.hexaware.entity.Payroll;

public class CheckEmployeeList {
	PayrollService ps;
	PayrollDAO pdao;
	Payroll payroll;
	EmployeeDAO edao;
	Employee emp;
	
	@Before
	public void setUp() {
		System.out.println("Called before test case");
		ps = new PayrollService();
		pdao = new PayrollDAO();
		//payroll = new Payroll();
		edao = new EmployeeDAO();
	}
	
	@Test
	public void testEmployees() {
		int expectedCount = 15;
		int acctualCount =edao.showEmployee(emp).size();
		
		assertEquals(expectedCount,acctualCount);
	}
	
	@After
	public void tearDown() {
		System.out.println("Called After");	
	}

}
