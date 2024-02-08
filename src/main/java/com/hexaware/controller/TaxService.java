package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.TaxDAO;
import com.hexaware.entity.Tax;
/**
 * The 'TaxService' class represents the operations of the taxes.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class TaxService implements ITaxService {
	TaxDAO tdao = new TaxDAO();
	
	List<Tax> taxList = new ArrayList<>();
	Tax tax ;
	Scanner sc = new Scanner(System.in);
	public void calculateTax() {
		
		
	}
	public Tax getTaxById(int taxId) {
		for(Tax tax : taxList) {
			if(tax.getTaxID()==taxId) {
				return tax;
			}
		}
		tdao.getTaxbyId(taxId);
		return null;
	}
	public void getTaxesForEmployee(int employeeId) {
		List<Tax> employeeTax = new ArrayList<>();
		for(Tax tax : taxList) {
			if(tax.getEmployeeID()==employeeId) {
				employeeTax.add(tax);
			}
		}
		tdao.getTaxesForEmployee(employeeId);
	}
	public void getTaxesForYear(int taxYear) {
		List<Tax> yearTax = new ArrayList<>();
		for(Tax tax : taxList) {
			if(tax.getTaxYear()==taxYear) {
				yearTax.add(tax);
			}
		}
		tdao.getTaxesForYear(taxYear);
	}
	
	
	
	
	
}
