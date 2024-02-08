package com.hexaware.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.FinancialRecordDAO;
import com.hexaware.entity.FinancialRecord;
/**
 * The 'FinancialRecordService' class represents the operations of the financialRecord.
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class FinancialRecordService implements IFinancialRecordService {
	
	FinancialRecordDAO fdao = new FinancialRecordDAO();
	FinancialRecord fr;
	List<FinancialRecord> finRecList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public void addFinancialRecord() {
		fr = new FinancialRecord();
		System.out.println("Enter EmployeeId:");
		int eid = sc.nextInt();
		fr.setEmployeeID(eid);
		System.out.println("Enter RecordDate:");
		String date = sc.next();
		LocalDate recDate = LocalDate.parse(date);
		fr.setRecordDate(recDate);
		System.out.println("Enter the description:");
		String desc = sc.next();
		fr.setDescription(desc);
		System.out.println("Enter Amount:");
		float amount = sc.nextFloat();
		fr.setAmount(amount);
		System.out.println("Enter record type:");
		String recType =sc.next();
		fr.setRecordType(recType);
		
		finRecList.add(fr);
		//System.out.println(finRecList);
		fdao.addRecord(fr);
	}
	public FinancialRecord getFinancialRecordById(int recordId) {
		for(FinancialRecord fr : finRecList) {
			if(fr.getRecordID()==recordId) {
				return fr;
			}
		}
		fdao.getRecordId(recordId);
		return null;
	}
	public FinancialRecord getFinancialRecordsForEmployee(int employeeId) {
		for(FinancialRecord fr : finRecList) {
			if(fr.getEmployeeID()==employeeId) {
				return fr;
			}
		}
		fdao.getRecordForEmp(employeeId);
		return null;
	}
	public List<FinancialRecord> getFinancialRecordsForDate(LocalDate date) {
		List<FinancialRecord> recDate = new ArrayList<>();
		for(FinancialRecord fr : finRecList) {
			if(fr.getRecordDate()==date) {
				recDate.add(fr);
			}
		}
		fdao.getRecordForDate(date);
		return recDate;
		
	}
		
}
