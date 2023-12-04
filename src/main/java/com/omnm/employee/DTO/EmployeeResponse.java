package com.omnm.employee.DTO;

import com.omnm.employee.Entity.Employee;
import com.omnm.employee.enumeration.employee.Department;
import com.omnm.employee.enumeration.employee.Rank;

import java.io.Serializable;

public class EmployeeResponse implements Serializable {

	private int id;
	private String employeeId;
	private String password;
	private Department department;
	private String name;
	private String email;
	private long phoneNumber;
	private Rank rank;

	public EmployeeResponse(Employee employee) {
		this.employeeId = employee.getEmployeeId();
		this.password = employee.getPassword();
		this.department = employee.getDepartment();
		this.name = employee.getName();
		this.email = employee.getEmail();
		this.phoneNumber = employee.getPhoneNumber();
		this.rank = employee.getRank();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

}