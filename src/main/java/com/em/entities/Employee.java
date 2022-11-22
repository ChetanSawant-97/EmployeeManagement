package com.em.entities;

import java.sql.Date;
import java.util.ArrayList;

public class Employee 
{
	public int emp_id;
	private String name;
	private String address;
	private String gender;
	private double salary;
	private Date birthdate;
	private ArrayList<String> skills;
	
	
	public Employee(int emp_id, String name, String address, String gender, double salary, Date bdate) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.salary = salary;
		this.birthdate = bdate;
	}
	
	
	
	
	public ArrayList<String> getSkills() {
		return skills;
	}




	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}




	public Employee(int emp_id, String name, String address) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.address = address;
	}




	public Employee(int id, String name, String address, ArrayList<String> skills) {
		super();
		this.emp_id = id;
		this.name = name;
		this.address = address;
		this.skills = skills;
	}




	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}




	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", address=" + address + ", gender=" + gender
				+ ", salary=" + salary + ", birthdate=" + birthdate + ", skills=" + skills + "]";
	}
	
	
	
	
	
	
	
	
}
