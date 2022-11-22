package com.emp.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnection {
	private static Connection con;
	
	public static Connection getConnection() 
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/emp";
			String user = "root";
			String pass = "chetan";
			
			con = DriverManager.getConnection(url,user,pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	} 
	
	public static void main(String[] args) 
	{
		Connection con = OracleConnection.getConnection();
		System.out.println(con);
		
	}
	

}
