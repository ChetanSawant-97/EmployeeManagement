package com.emp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import com.em.entities.Employee;
import com.em.entities.EmployeeSkills;
import com.emp.helper.OracleConnection;

public class EmployeeDao {
	public static void saveEmployee(String n, String add, boolean gen, Date bdate, double salary) {
		Connection con = OracleConnection.getConnection();

		if (con != null) {
			String query = "Insert into emp.employee values(?,?,?,?,?,?)";

			try {

				PreparedStatement st = con.prepareStatement(query);
				st.setInt(1, 0);
				st.setString(2, n);
				st.setString(3, add);
				st.setBoolean(4, gen);
				st.setDouble(5, salary);
				st.setDate(6, bdate);

				st.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static TreeSet<Employee> getEmployeeDet() {
		Connection con = OracleConnection.getConnection();
		String query = "Select * from employee";
		TreeSet<Employee> coll = new TreeSet<Employee>(new SortingLogic());

		if (con != null) {
			try {
				Statement st = con.prepareStatement(query);
				ResultSet set = st.executeQuery(query);

				while (set.next()) {
					int id = set.getInt(1);
					String name = set.getString(2);
					String address = set.getString(3);
					String gender = null;
					if (set.getBoolean(4)) {
						gender = "Male";
					} else {
						gender = "Female";
					}
					double salary = set.getDouble(5);
					Date bdate = set.getDate(6);
					Employee emp = new Employee(id, name, address, gender, salary, bdate);

					coll.add(emp);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		System.out.println(coll.size());
		return coll;

	}

	public static void updateEmp(int id, String name, String address, boolean gender, double salary, Date bdate) {
		Connection con = OracleConnection.getConnection();
		String query = "Update employee set emp_name=?, address=?, gender=?, salary=?, birthdate=? where id=?";
		if (con != null) {
			try {
				PreparedStatement stmt = con.prepareStatement(query);

				stmt.setString(1, name);
				stmt.setString(2, address);
				stmt.setBoolean(3, gender);
				stmt.setDouble(4, salary);
				stmt.setDate(5, bdate);
				stmt.setInt(6, id);

				System.out.println(query);
				stmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteEmp(int id) {
		Connection con = OracleConnection.getConnection();
		String query = "Delete from employee where id=?";
		if (con != null) {
			try {
				PreparedStatement st = con.prepareStatement(query);
				st.setInt(1, id);
				st.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static Employee getEmployee(int id) {
		Connection con = OracleConnection.getConnection();
		String query = "Select * from employee where id =?";
		Employee emp = new Employee();
		if (con != null) {
			try {
				PreparedStatement st = con.prepareStatement(query);
				st.setInt(1, id);
				ResultSet set = st.executeQuery();

				while (set.next()) {
					String name = set.getString(2);
					String address = set.getString(3);
					String gender = null;
					if (set.getBoolean(4)) {
						gender = "Male";
					} else {
						gender = "Female";
					}
					double salary = set.getDouble(5);
					Date bdate = set.getDate(6);

					emp.setEmp_id(id);
					emp.setName(name);
					emp.setAddress(address);
					emp.setGender(gender);
					emp.setSalary(salary);
					emp.setBirthdate(bdate);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emp;

	}

	public static int getEmployeeId(String name) 
	{
		Connection con = OracleConnection.getConnection();
		String query = "Select id from employee where emp_name =?";
		int id = 0;
		if (con != null) {
			try {
				PreparedStatement st = con.prepareStatement(query);
				st.setString(1, name);
				ResultSet set = st.executeQuery();
				while (set.next()) {
					id = set.getInt(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return id;

	}

	public static void addEmpSkill(int empId, int[] skillId) {
		Connection con = OracleConnection.getConnection();
		if (con != null) {
			String query = "insert into emp_skill values (?,?)";

			try {
				for (int i = 0; i < skillId.length; i++) {
					PreparedStatement stmt = con.prepareStatement(query);
					stmt.setInt(1, empId);
					stmt.setInt(2, skillId[i]);
					stmt.executeUpdate();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static ArrayList<Employee> getEmp(int count) {
		ArrayList<Employee> emCol = new ArrayList<Employee>();
		Connection con = OracleConnection.getConnection();
		String query = "Select id, emp_name, address from employee order by id limit ?,5";
		if (con != null) {
			try {
				PreparedStatement st = con.prepareStatement(query);
				st.setInt(1, count);
				ResultSet set = st.executeQuery();
				while (set.next()) {
					int id = set.getInt(1);
					String name = set.getString(2);
					String address= set.getString(3);
					Employee emp = new Employee(id, name, address);
					emCol.add(emp);
				}
				
			} catch (Exception e) {
				e.printStackTrace();	
			}
		}
		return emCol;

	}
	
	public static ArrayList<String> getEmpSkill(int id)
	{
		Connection con = OracleConnection.getConnection();
		ArrayList<String> skills = new ArrayList<String>();
		
		if (con!=null) {
			String query = "SELECT skill_master.name FROM  emp_skill "
					+ "INNER JOIN employee ON id = emp_skill.emp_id "
					+ "INNER JOIN skill_master ON skill_master_id =  emp_skill.skill_id "
					+ "WHERE employee.id = ?;";
			try {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, id);
				ResultSet set = stmt.executeQuery();
				while (set.next()) {
					String skill = set.getString(1);
					skills.add(skill);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return skills;
	}
	
	
	public static int recordCount () 
	{
		Connection con = OracleConnection.getConnection();
		int recordCount = 0;
		if(con!=null) 
		{
			
			String query = "Select count(*) from employee";
			int id = 0;
			if (con != null) {
				try {
					Statement st = con.createStatement();
					ResultSet set = st.executeQuery(query);
					while (set.next()) {
						recordCount = set.getInt(1);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(recordCount);
		}
		return recordCount;
	}
	
	
	
	
}