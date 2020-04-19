package com.paf.HospitalManagement.HelthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.paf.HospitalManagement.HelthCare.Bean.DoctorBean;
import com.paf.HospitalManagement.HelthCare.Util.HelthCareDB;

public class DoctorModel {
	
	HelthCareDB db = new HelthCareDB();
	Connection con = db.getCon();

	//Create method for ViewDoctorFeedback
	public String ViewDoctor() {
		
		String output = null;
		
		try {
			String sql = "SELECT * FROM doctor";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			ResultSet resultSetrs = preparedStmt.executeQuery(); 
	         
			// Prepare the html table to be displayed 
			output = "<table>"
	     				+ "<tr>"
	     				+ "<th>doctor_id</th>"	     				
	     				+ "<th>f_name</th>"
	     				+ "<th>l_name</th>"
	     				+ "<th>email</th>"
	     				+ "<th>phoneNo</th>"
	     				+ "<th>nic</th>"	     				 
	     				+ "<th>Specialization</th>"	     				 
	     				+ "<th>age</th>"	     				 
	     				+ "</tr>";		
					
			// iterate through the rows in the result set  
	         while (resultSetrs.next()) {
             
	        	 output +=  "<tr>"
	     				+ "<td>"+resultSetrs.getInt("id")+"</td>"
	     				+ "<td>"+resultSetrs.getString("f_name")+"</td>"
	     				+ "<td>"+resultSetrs.getString("l_name")+"</td>"
	     				+ "<td>"+resultSetrs.getString("email")+"</td>"
	     				+ "<td>"+resultSetrs.getInt("phoneNo")+"</td>"
	     				+ "<td>"+resultSetrs.getString("nic")+"</td>"	     				 			 
	     				+ "<td>"+resultSetrs.getString("Specialization")+"</td>"	     				 			 
	     				+ "<td>"+resultSetrs.getInt("age")+"</td>"	     				 			 
	     				+ "</tr>";			 
	        	   
	         }
	         
	         // Complete the html table  
	         output += "</table>";
	         
	         
			} catch (SQLException e) {
				 
				output = "Error while reading the DoctorDetails.";
				System.err.println(e.getMessage());
			}
              		
		return output;

	}
	
	//Create method for addDoctor
	public String addDoctor(DoctorBean Dbean) {

		String output = null;

		try {
			
			// create a prepared statement  
			String sql = "INSERT INTO doctor (f_name, l_name, email,phoneNo,nic,Specialization,age) "
						+ "VALUE(?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			
			//binding values 
			ps.setString(1, Dbean.getF_name());
			ps.setString(2, Dbean.getL_name());
			ps.setString(3, Dbean.getEmail());
			ps.setInt(4, Dbean.getPhoneNo());
			ps.setString(5, Dbean.getNic());
			ps.setString(6, Dbean.getSpecialization());
			ps.setInt(7, Dbean.getAge());
			
			// execute the statement  
			ps.executeUpdate();

			output = "Doctor details inserted";

		} catch (SQLException e) {

			output = "Error while reading the DoctorDetails.";
			System.err.println(e.getMessage());
		}
		return output;

	}
	//create method for UpdateDoctor
	public String UpdateDoctor(DoctorBean Dbean) {

		String output = null;
		
		
		try {
			
			// create a prepared statement    
			String sql = "UPDATE  doctor SET " 
						+ "f_name = ?," 
						+ "l_name = ?,"
						+ "email = ?," 
						+ "phoneNo = ?,"
						+ "nic = ?," 	
						+ "age = ?," 
						+ "Specialization = ?"											 
						+ "WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			//binding values  
			ps.setString(1, Dbean.getF_name());
			ps.setString(2, Dbean.getL_name());
			ps.setString(3, Dbean.getEmail());
			ps.setInt(4, Dbean.getPhoneNo());
			ps.setString(5, Dbean.getNic());
			ps.setInt(6, Dbean.getAge());
			ps.setString(7, Dbean.getSpecialization());			
			ps.setInt(8, Dbean.getId());
			
			System.out.println(ps);
			
			// execute the statement   
			ps.executeUpdate();
			
			output = "Doctor "+Dbean.getId()+" details Updated"; //display update successfully
			
			
		} catch (SQLException e) {

			output = "Error while reading the DoctorDetails.";
			System.err.println(e.getMessage());
		}

		return output;

	}
	//create method for deleteDoctor
	public String DeleteDoctor(int id) {
		
		String output = null; 	
		
		try {
				// create a prepared statement  
				String sql = "DELETE  FROM doctor  "
							+ "WHERE id = ?";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				// execute the statement  
				ps.executeLargeUpdate();
				output = "Doctor "+id+" deleted ";
				
		} catch (SQLException e) {
				 
				output = "Error while reading the DoctorDetails.";
				System.err.println(e.getMessage());
		  } 
		return output;
	}

}
