package com.paf.HospitalManagement.HelthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.paf.HospitalManagement.HelthCare.Bean.PaymentBean;
import com.paf.HospitalManagement.HelthCare.Util.HelthCareDB;

public class PaymentModel {
	
	HelthCareDB db = new HelthCareDB();
	Connection con = db.getCon();

	public String ViewPayment() {
		
		String a = null;
		
		try {
			String sql = "SELECT * FROM payment";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
	         
					a = "<table>"
	     				+ "<tr>"
	     				+ "<th>payment_id<td>"	     				
	     				+ "<th>hospital_id<td>"
	     				+ "<th>patient_id<td>"
	     				+ "<th>appointment_id<td>"
	     				+ "<th>type<td>"
	     				+ "<th>amount<td>"
	     				+ "<th>date<td>"	     				 
	     				+ "</tr>";
					
					
			
	         while (rs.next()) {
             
	        	   a +=  "<tr>"
	     				+ "<td>"+rs.getInt("payment_id")+"<td>"
	     				+ "<td>"+rs.getString("hospital_id")+"<td>"
	     				+ "<td>"+rs.getString("patient_id")+"<td>"
	     				+ "<td>"+rs.getString("appointment_id")+"<td>"
	     				+ "<td>"+rs.getString("type")+"<td>"
	     				+ "<td>"+rs.getString("amount")+"<td>"
	     				+ "<td>"+rs.getString("date")+"<td>"	     							 
	     				+ "</tr>";
	     		
	         }
	         
	         a += "</table>";
	         
	         
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
              
		
		return a;

	}

	public String addPayment(PaymentBean pbean) {

		String e1 = null;

		try { 

			String sql = "INSERT INTO payment(hospital_id, patient_id, appointment_id,type,amount,date) "
					+ "VALUE(?,?,?,?,?,?)";
			

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, pbean.getHospital_id());
			ps.setInt(2, pbean.getPatient_id());
			ps.setInt(3, pbean.getAppointment_id());
			ps.setString(4, pbean.getType());
			ps.setFloat(5, pbean.getAmount());
			ps.setString(6, pbean.getDate());
			 
	     	   

			ps.executeUpdate();

			e1 = "payment details inserted";

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return e1;

	}

	public String UpdatePayment(PaymentBean pbean) {

		String e = null;
		
		
		try {
			
			String sql = "UPDATE  payment SET " 
						+ "hospital_id = ?," 
						+ "patient_id = ?,"
						+ "appointment_id = ?," 
						+ "type = ?,"
						+ "amount = ?," 
						+ "date = ?" 						
						+ "WHERE payment_id = ?";
		 

			PreparedStatement ps;
			ps = con.prepareStatement(sql);

			ps.setInt(1, pbean.getHospital_id());
			ps.setInt(2, pbean.getPatient_id());
			ps.setInt(3, pbean.getAppointment_id());
			ps.setString(4, pbean.getType());
			ps.setFloat(5, pbean.getAmount());
			ps.setString(6, pbean.getDate());
			ps.setInt(7, pbean.getPayment_id());

			ps.executeUpdate();
			
			e = "payment details Updated";
			
			
		} catch (SQLException e1) {


			e1.printStackTrace();
		}

		

		return e;

	}

	public String DeletePayment(int id) {
		
		String status = null; 	
		
		try {
			String sql = "DELETE  FROM payment "
						+ "WHERE payment_id = ? ";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();			
			status = "payment "+id+" deleted ";
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		 
		
		return status;

	}

}
