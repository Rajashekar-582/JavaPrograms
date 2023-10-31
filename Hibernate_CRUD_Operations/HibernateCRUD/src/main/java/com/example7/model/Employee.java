package com.example7.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Emp_Name;
	private float salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_Name() {
		return Emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Employee(int id, String emp_Name, float salary) {
		super();
		this.id = id;
		Emp_Name = emp_Name;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	

}
