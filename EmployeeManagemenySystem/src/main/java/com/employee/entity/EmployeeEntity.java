package com.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String empName;
	private String empDestination;
	private Integer empAge;
	private String empEmail;

	private String empGender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDestination() {
		return empDestination;
	}

	public void setEmpDestination(String empDestination) {
		this.empDestination = empDestination;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public EmployeeEntity(Integer id, String empName, String empDestination, Integer empAge, String empEmail,
			String empGender) {
		super();
		this.id = id;
		this.empName = empName;
		this.empDestination = empDestination;
		this.empAge = empAge;
		this.empEmail = empEmail;
		this.empGender = empGender;
	}

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}

	