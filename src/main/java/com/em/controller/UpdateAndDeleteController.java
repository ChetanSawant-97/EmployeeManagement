package com.em.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.SimpleAttributeSet;

import com.em.entities.Employee;
import com.emp.dao.EmployeeDao;

@WebServlet("/UpdateAndDeleteController")
public class UpdateAndDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");

		if (method.equals("update")) {

			Employee emp = EmployeeDao.getEmployee(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("emp", emp);
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);

		} else if (method.equals("delete")) {
			EmployeeDao.deleteEmp(Integer.parseInt(request.getParameter("id")));

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
	
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			String name = request.getParameter("name");
			String address = request.getParameter("address");

			String bdate = request.getParameter("birthdate");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date udate = sdf.parse(bdate);

			long l = udate.getTime();
			java.sql.Date sdate = new java.sql.Date(l);

			String gender = request.getParameter("gender");
			double salary = Double.parseDouble(request.getParameter("salary"));

			boolean gen;

			if (gender.equals("male")) {
				gen = true;
			} else {
				gen = false;
			}
			System.out.println("Getting to Employee Dao");
			EmployeeDao.updateEmp(id, name, address, gen, salary, sdate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
