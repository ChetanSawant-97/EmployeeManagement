package com.emp.dao;

import java.util.Comparator;

import com.em.entities.Employee;

public class SortingLogic implements Comparator<Employee> 
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.emp_id - o2.emp_id;
	}
}
