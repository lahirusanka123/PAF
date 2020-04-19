package com.paf.HospitalManagement.HelthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.paf.HospitalManagement.HelthCare.Bean.DoctorPrescriptionBean;
import com.paf.HospitalManagement.HelthCare.Util.HelthCareDB;


public class DoctorPrescriptionModel {
	
	HelthCareDB db = new HelthCareDB();
	Connection connection = db.getCon();

	//Create method for ViewDoctorPrescription
	public String ViewDoctorPrescription() {
			
			String output = null;
			
			try {
					String sql = "SELECT * FROM doctorprescription";
					PreparedStatement ps = connection.prepareStatement(sql);
					ResultSet rs = ps.executeQuery(); 
			         
						// Prepare the html table to be displayed 
						output = "<table>"
			     				+ "<tr>"
			     				+ "<th>prescription ID</th>"
			     				+ "<th>Patient Name</th>"
			     				+ "<th>Doctor Name</th>"
			     				+ "<th>Medicine<td>"
			     				+ "<th>Description</th>"     				 		      				 
			     				+ "</tr>";		
													
					// iterate through the rows in the result set   
			         while (rs.next()) {
		             
			        	output += "<tr>"
			     				+ "<td>"+rs.getInt("prescription_id")+"/<td>"
			     				+ "<td>"+rs.getString("patient_name")+"</td>"
			     				+ "<td>"+rs.getString("doctor_name")+"</td>"
			     				+ "<td>"+rs.getString("medicine")+"</td>"
			     				+ "<td>"+rs.getString("description")+"</td>"  				 			 	     				 			 
			     				+ "</tr>";		     				 
			        	   
			         }
			         // Complete the html table   
			         output += "</table>";
			         
			         
					} catch (SQLException e) {
						 
						 output = "Error while reading the DoctorPrescription.";
						 System.err.println(e.getMessage());
						 
					}      			
				return output;
		
			}
		
	//Create method for addDoctorPrescription
	public String addDoctorPrescriprtion(DoctorPrescriptionBean Dbean) {

		String output = null;

		try {	
				// create a prepared statement  
				String sql = "INSERT INTO doctorprescription (`prescription_id`,`patient_name`,`doctor_name`, `medicine`,`description`) "
							+ "VALUE(?,?,?,?)";
	
				PreparedStatement preparedStmt = connection.prepareStatement(sql);
				
				//binding values  
				preparedStmt.setInt(1, 0); 
				preparedStmt.setString(2, Dbean.getPatient_name());
				preparedStmt.setString(3, Dbean.getDoctor_name());
				preparedStmt.setString(4, Dbean.getMedicine());
				preparedStmt.setString(5, Dbean.getDescription());

				// execute the statement
				preparedStmt.execute();
	
				output = "DoctorPrescription details inserted"; //display DoctorPrescription inserted successfully
	
		} catch (SQLException e) {
	
				output = "Error while reading the DoctorPrescription.";
				System.err.println(e.getMessage());
		}
		return output;
	}
	
	//	//Create method for UpdateDoctorPrescription
	public String UpdateDoctorPrescription(DoctorPrescriptionBean Dbean) {

		String output = null;	
		
		try {
			// create a prepared statement    
				String sql = "UPDATE  doctorprescription SET " 
						    + "patient_name = ?," 
							+ "doctor_name = ?," 
							+ "medicine = ?,"
							+ "description = ?," 									 
							+ "WHERE prescription_id = ?";
	
				PreparedStatement preparedStmt = connection.prepareStatement(sql);
						
				//binding values  	
				preparedStmt.setString(1, Dbean.getPatient_name());
				preparedStmt.setString(2, Dbean.getDoctor_name());
				preparedStmt.setString(3, Dbean.getMedicine());	
				preparedStmt.setString(4, Dbean.getDescription());		
				preparedStmt.setInt(5, Dbean.getPrescription_id());
				
				// execute the statement   
				preparedStmt.execute();
				
				//display update successfully
				output = "Doctor Prescription details Updated successfully";
				
				
			}catch (SQLException e) {
	
				output = "Error while reading the DoctorPrescription.";
				System.err.println(e.getMessage());
			}
		
			return output;
	}
	
	//Create method for DeleteDoctorPrescription
	public String DeleteDoctorPrescription(int id) {
			
			String output = null; 	
			
			try {
					// create a prepared statement  
					String sql = "DELETE  FROM doctorprescription "
								+ "WHERE prescription_id = ? ";
					
					PreparedStatement preparedStmt = connection.prepareStatement(sql); 
					preparedStmt.setInt(1, id);
					
					// execute the statement  
					preparedStmt.execute();			
					output = "doctorprescription "+id+" Deleted successfully ";//display delete successfully
					
			}catch (SQLException e) {
					 
					output = "Error while deleting the DoctorPrescription.";    
					System.err.println(e.getMessage()); 
			}	
			
			return output;
	}	

}
