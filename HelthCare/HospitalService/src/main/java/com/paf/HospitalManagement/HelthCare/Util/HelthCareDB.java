package com.paf.HospitalManagement.HelthCare.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelthCareDB {
	
	Connection con = null; 
	public Connection getCon() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helthcare","root","12345");
			
		} catch (ClassNotFoundException e) {
			
			 e.printStackTrace();
			 
		}catch (SQLException e) {	
			
			 e.printStackTrace();
		}
		
	return con;
		
	}

}
