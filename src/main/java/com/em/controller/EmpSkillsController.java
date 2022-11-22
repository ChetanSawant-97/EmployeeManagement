package com.em.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.em.entities.Employee;
import com.emp.dao.EmployeeDao;


@WebServlet("/EmpSkillsController")
public class EmpSkillsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int count = Integer.parseInt(request.getParameter("count"));
		String action = request.getParameter("action");
		
		
		if (action.equals("next")) {
			count = count + 5;
			System.out.println(count);
		}else if(action.equals("prev")) 
		{
			count = count - 5;
			System.out.println(count);
		}else 
		{
			count = 0;
		}
		
			ArrayList<Employee> employee = EmployeeDao.getEmp(count);
			ArrayList<Employee> empSkills = new ArrayList<Employee>();
			for(Employee emp : employee) 
			{
				int id = emp.getEmp_id();
				String name = emp.getName();
				String address = emp.getAddress();
				ArrayList<String> skills = EmployeeDao.getEmpSkill(id);
				Employee empl = new Employee(id, name, address, skills);
				empSkills.add(empl);
			}
			
			
			request.setAttribute("recordCount", EmployeeDao.recordCount());
			request.setAttribute("employee", empSkills);
			
			request.setAttribute("count", count);
			
			RequestDispatcher rd = request.getRequestDispatcher("skillrecord.jsp");
			rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}		
}
