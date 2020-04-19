package com.paf.HospitalManagement.HelthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.paf.HospitalManagement.HelthCare.Bean.DoctorAppointmentBean;
import com.paf.HospitalManagement.HelthCare.Util.HelthCareDB;


public class DoctorAppointmentModel {
	
	HelthCareDB db = new HelthCareDB();
	Connection connection = db.getCon();

	public String ViewDoctorApoointment() {
			
			String output = null;
			
			try {
				String sql = "SELECT * FROM doctorAppointment";
				PreparedStatement preparedStmt = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStmt.executeQuery(); 
		         
					// Prepare the html table to be displayed 
					output = "<table>"
		     				+ "<tr>"
		     				+ "<th>Appointment ID</th>"	     				
		     				+ "<th>patient ID</th>"
		     				+ "<th>patient_name<td>"
		     				+ "<th>time</th>"
		     				+ "<th>date</th>"	     				 
		     				+ "<th>status<th>"	     				 		      				 
		     				+ "</tr>";		
												
				// iterate through the rows in the result set   
		         while (resultSet.next()) {
	             
		        	output += "<tr>"
		     				+ "<td>"+resultSet.getInt("appoinement_id")+"/<td>"
		     				+ "<td>"+resultSet.getInt("patient_number")+"</td>"
		     				+ "<td>"+resultSet.getString("patient_name")+"</td>"
		     				+ "<td>"+resultSet.getString("time")+"</td>"
		     				+ "<td>"+resultSet.getString("date")+"</td>"
		     				+ "<td>"+resultSet.getString("status")+"</td>"	     				 			 	     				 			 
		     				+ "</tr>";		     				 
		        	   
		         }
		         // Complete the html table   
		         output += "</table>";
		         
		         
				} catch (SQLException e) {
					 
					 output = "Error while reading the DoctorAppointment.";
					 System.err.println(e.getMessage());
					 
				}      			
			return output;
	
		}
		
	//Create method for addDoctorApoointment
	public String addDoctorApoointment(DoctorAppointmentBean Dbean) {

		String output = null;

		try {
			
			// create a prepared statement  
				String sql = "INSERT INTO doctorAppointment (`appoinement_id`,`patient_number`,`patient_name`,`time`,`date`,`status`) "
							+ "VALUE(?,?,?,?,?,?)";
	
				PreparedStatement preparedStmt = connection.prepareStatement(sql);
				
				//binding values  
				preparedStmt.setInt(1, 0); 
				preparedStmt.setInt(2, Dbean.getPatient_no());
				preparedStmt.setString(3, Dbean.getPatient_name());
				preparedStmt.setString(4, Dbean.getTime());
				preparedStmt.setString(5, Dbean.getDate());
				preparedStmt.setString(6, Dbean.getStatus());
			
				// execute the statement  
				preparedStmt.execute();
	
				output = "DoctorAppointment details inserted"; //display inserted successfully
	
		} catch (SQLException e) {
	
				output = "Error while reading the DoctorAppointment.";
				System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	//Create method for UpdateDoctorAppointment
	public String UpdateDoctorAppointment(DoctorAppointmentBean Dbean) {

		String output = null;
		
		
		try {
			// create a prepared statement    
				String sql = "UPDATE  doctorAppointment SET " 
							+ "patient_number = ?," 
							+ "patient_name = ?,"
							+ "time = ?," 
							+ "phoneNo = ?,"
							+ "date = ?," 	
							+ "status = ?," 										 
							+ "WHERE appoinement_id = ?";
	
				PreparedStatement preparedStmt = connection.prepareStatement(sql);
						
				//binding values  
				preparedStmt.setInt(1,Dbean.getPatient_no());
				preparedStmt.setString(2, Dbean.getPatient_name());
				preparedStmt.setString(3, Dbean.getTime());
				preparedStmt.setString(4, Dbean.getTime());
				preparedStmt.setString(5, Dbean.getStatus());			
				preparedStmt.setInt(6, Dbean.getAppoinement_id());
				
				// execute the statement   
				preparedStmt.execute();
				
				//display update successfully
				output = "Doctor Appointment details Updated successfully";
				
				
			}catch (SQLException e) {
	
				output = "Error while reading the DoctorAppointment.";
				System.err.println(e.getMessage());
			}

			return output;

	}
	
	//Create delete method for DeleteDoctorAppointment
	public String DeleteDoctorAppointment(int id) {
			
			String output = null; 	
			
			try {
					// create a prepared statement  
					String sql = "DELETE  FROM doctorAppointment "
								+ "WHERE appoinement_id = ? ";
					
					PreparedStatement preparedStmt = connection.prepareStatement(sql); 
					preparedStmt.setInt(1, id);
					
					// execute the statement  
					preparedStmt.execute();			
					output = "doctorAppointment "+id+" Deleted successfully ";//display delete successfully
					
			}catch (SQLException e) {
					 
					output = "Error while deleting the DoctorAppointment.";    
					System.err.println(e.getMessage()); 
			}	
			
			return output;
	}


}