package com.emp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.em.entities.Skill;
import com.emp.helper.OracleConnection;

public class SkillDao 
{	
	
	
	public static ArrayList<Skill> getSkills() 
	{
		Connection con = OracleConnection.getConnection();
		
		String query = "Select * From skill_master;";
		ArrayList<Skill> allSkills = new ArrayList<>();
		
		if (con != null) {

			try {
				Statement st = con.prepareStatement(query);
				ResultSet set = st.executeQuery(query);
				while (set.next()) {
					int id = set.getInt(1);
					String skill = set.getString(2);
					allSkills.add(new Skill(id, skill));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return allSkills;
	}

	
	
	
}
