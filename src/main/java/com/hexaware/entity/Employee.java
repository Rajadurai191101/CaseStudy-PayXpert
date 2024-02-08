package com.hexaware.entity;

import java.sql.Date;
import java.time.LocalDate;
/**
 * The 'Employee' class represents the employee entity with various attributes
 * such as employeeId, firstName, lastName, dateOfBirth, gender, email, phoneNumber, address,positions,
 * joiningDate and terminationDate
 * 
 * 
 * @author Rajadurai M
 * @version 1.0
 * @since 2024-02-04
 */
public class Employee {
	
	private int employeeID;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String email;
	private long phoneNumber;
	private String address;
	private String position;
	private LocalDate joiningDate;
	private LocalDate terminationDate;
	
	public Employee(int eid, String fname, String lname, Date dob) {
		// TODO Auto-generated constructor stub
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public LocalDate getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
	}

	

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", position=" + position + ", joiningDate=" + joiningDate
				+ ", terminationDate=" + terminationDate + "]";
	}
	
	
	
	
}
