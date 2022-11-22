package com.em.controller;

import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.em.entities.Employee;
import com.emp.dao.EmployeeDao;


@WebServlet("/EmpRecordController")
public class EmpRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmpRecordController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		TreeSet<Employee> coll = EmployeeDao.getEmployeeDet();
		
		request.setAttribute("empDetails", coll);
		
		RequestDispatcher rd = request.getRequestDispatcher("empRecord.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}


}
