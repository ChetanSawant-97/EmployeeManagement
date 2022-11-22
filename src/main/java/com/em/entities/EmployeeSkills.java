package com.em.entities;

public class EmployeeSkills 
{
	private Employee emp;
	private Skill skill;
	
	
	public EmployeeSkills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeSkills(Employee emp, Skill skill) {
		super();
		this.emp = emp;
		this.skill = skill;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	
}
