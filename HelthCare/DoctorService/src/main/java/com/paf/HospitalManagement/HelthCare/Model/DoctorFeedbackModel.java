package com.paf.HospitalManagement.HelthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.paf.HospitalManagement.HelthCare.Bean.DoctorFeedbackBean;
import com.paf.HospitalManagement.HelthCare.Util.HelthCareDB;

public class DoctorFeedbackModel {
	
	HelthCareDB db = new HelthCareDB();
	Connection connection = db.getCon();

//Create method for ViewDoctorFeedback
	public String ReadDoctorFeedback() {
			
			String output = null;
			
			try {
				String sql = "SELECT * FROM doctorfeedback";
				PreparedStatement preparedStmt = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStmt.executeQuery(); 
		         
					// Prepare the html table to be displayed 
					output = "<table>"
		     				+ "<tr>"
		     				+ "<th>Feedback ID</th>"	     				
		     				+ "<th>User Name</th>"
		     				+ "<th>date<td>"
		     				+ "<th>message</th>"     				 		      				 
		     				+ "</tr>";		
												
				// iterate through the rows in the result set   
		         while (resultSet.next()) {
	             
		        	output += "<tr>"
		     				+ "<td>"+resultSet.getInt("feedback_id")+"/<td>"
		     				+ "<td>"+resultSet.getString("userName")+"</td>"
		     				+ "<td>"+resultSet.getString("date")+"</td>"
		     				+ "<td>"+resultSet.getString("message")+"</td>"  				 			 	     				 			 
		     				+ "</tr>";		     				 
		        	   
		         }
		         // Complete the html table   
		         output += "</table>";
		         
		         
				} catch (SQLException e) {
					 
					 output = "Error while reading the DoctorFeedback.";
					 System.err.println(e.getMessage());
					 
				}      			
			return output;
	
		}
		
	//Create method for addDoctorFeedback
	public String insertDoctorFeedback(DoctorFeedbackBean Dbean) {

		String output = null;

		try {
			
				// create a prepared statement  
				String sql = "INSERT INTO doctorfeedback (`feedback_id`,`userName`,`date`,`message`) "
							+ "VALUE(?,?,?,?)";
	
				PreparedStatement preparedStmt = connection.prepareStatement(sql);
				
				//binding values  
				preparedStmt.setInt(1, 0); 
				preparedStmt.setString(2, Dbean.getUserName());
				preparedStmt.setString(3, Dbean.getDate());
				preparedStmt.setString(4, Dbean.getMsg());

				// execute the statement  
				preparedStmt.execute();
	
				output = "DoctorFeedback details inserted"; //display inserted successfully
	
		} catch (SQLException e) {
	
				output = "Error while reading the DoctorFeedback.";
				System.err.println(e.getMessage());
		}
		return output;
	}
	
	//create method for UpdateDoctorFeedback
	public String UpdateDoctorFeedback(DoctorFeedbackBean Dbean) {

		String output = null;	
		
		try {
			// create a prepared statement    
				String sql = "UPDATE  doctorfeedback SET " 
							+ "userName = ?," 
							+ "date = ?,"
							+ "message = ?," 									 
							+ "WHERE feedback_id = ?";
	
				PreparedStatement preparedStmt = connection.prepareStatement(sql);
						
				//binding values  				
				preparedStmt.setString(1, Dbean.getUserName());
				preparedStmt.setString(2, Dbean.getDate());	
				preparedStmt.setString(3, Dbean.getMsg());		
				preparedStmt.setInt(4, Dbean.getFeedbackId());
				
				// execute the statement   
				preparedStmt.execute();
				
				//display update successfully
				output = "Doctor Feedback details Updated successfully";
				
				
			}catch (SQLException e) {
	
				output = "Error while reading the DoctorFeedback.";
				System.err.println(e.getMessage());
			}
		
			return output;
	}
	
	//Create delete method for DeleteDoctorFeedback
	public String DeleteDoctorFeedback(int id) {
			
			String output = null; 	
			
			try {
					// create a prepared statement  
					String sql = "DELETE  FROM doctorfeedback "
								+ "WHERE feedback_id = ? ";
					
					PreparedStatement preparedStmt = connection.prepareStatement(sql); 
					preparedStmt.setInt(1, id);
					
					// execute the statement  
					preparedStmt.execute();			
					output = "doctorfeedback "+id+" Deleted successfully ";//display delete successfully
					
			}catch (SQLException e) {
					 
					output = "Error while deleting the DoctorFeedback.";    
					System.err.println(e.getMessage()); 
			}	
			
			return output;
	}
	

}
