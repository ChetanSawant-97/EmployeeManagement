package com.em.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.em.entities.Skill;
import com.emp.dao.EmployeeDao;
import com.emp.dao.SkillDao;
import com.emp.helper.OracleConnection;



public class RegisterEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		
		
		ArrayList<Skill> allSkills = SkillDao.getSkills();
		
		request.setAttribute("skills", allSkills);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		
		
		
		try {
			
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String bdate = request.getParameter("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date udate = sdf.parse(bdate);
			
			long l = udate.getTime();
			java.sql.Date sdate = new java.sql.Date(l);
			
			String gender = request.getParameter("gender");
			String[] skills =  request.getParameterValues("skill");
			int[] skillId = new int[skills.length];
			for (int i = 0; i<skillId.length; i++) 
			{
				skillId[i] = Integer.parseInt(skills[i]);
			}
			
			double salary = Double.parseDouble(request.getParameter("salary"));
			
			boolean gen;
			
			if (gender.equals("male")) {
				gen = true;
			}else {
				gen = false;
			}	
			
			EmployeeDao.saveEmployee(name, address, gen, sdate, salary);
			int id = EmployeeDao.getEmployeeId(name);
			EmployeeDao.addEmpSkill(id, skillId);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
