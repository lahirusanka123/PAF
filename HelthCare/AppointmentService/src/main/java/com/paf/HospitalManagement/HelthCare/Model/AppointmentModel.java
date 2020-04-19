package com.paf.HospitalManagement.HelthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.paf.HospitalManagement.HelthCare.Bean.AppointmentBean;
import com.paf.HospitalManagement.HelthCare.Util.HelthCareDB;

public class AppointmentModel {

	HelthCareDB db = new HelthCareDB();
	Connection con = db.getCon();

	public String ViewAppointment() {

		String a = null;

		try {
			String sql = "SELECT * FROM appointment";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			a = "<table>" + "<tr>" + "<th>appointment_id<td>" + "<th>patient_id<td>" + "<th>hospital_id<td>"
					+ "<th>doctor_id<td>" + "<th>date<td>" + "<th>time<td>" + "</tr>";

			while (rs.next()) {

				a += "<tr>" + "<td>" + rs.getInt("appointment_id") + "<td>" + "<td>" + rs.getInt("patient_id") + "<td>"
						+ "<td>" + rs.getInt("hospital_id") + "<td>" + "<td>" + rs.getInt("doctor_id") + "<td>" + "<td>"
						+ rs.getString("date") + "<td>" + "<td>" + rs.getString("time") + "<td>" + "</tr>";

			}

			a += "</table>";

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a;

	}

	public String addAppointment(AppointmentBean app) {

		String Result = null;

		try {

			String date = app.getDate();
			String time = app.getTime();
			String date1 = null;
			String time1 = null;
			
			String sql1 = "SELECT date, time FROM appointment";
			PreparedStatement pst = con.prepareStatement(sql1);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				 
				date1 = rs.getString("date");
				time1 = rs.getString("time");
			}

			if (!(date.equalsIgnoreCase(date1) && time.equalsIgnoreCase(time1))) {				

				System.out.println(app.getAppointment_id());

				String sql = "INSERT INTO appointment(patient_id, hospital_id, doctor_id, date, time) "
						+ "VALUE(?,?,?,?,?)";

				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, app.getPatient_id());
				ps.setInt(2, app.getHospital_id());
				ps.setInt(3, app.getDoctor_id());
				ps.setString(4, app.getDate());
				ps.setString(5, app.getTime());

				ps.executeUpdate();
				
				

				Result = "Appointment details inserted";
			}else {
				Result = "This time is already taken! please enter different time";
			}
			 

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return Result;

	}

	public String UpdateAppointment(AppointmentBean app) {

		String e = null;

		try {

			String sql = "UPDATE  appointment SET " + "patient_id = ?," + "hospital_id = ?," + "doctor_id = ?,"
					+ "date = ?," + "time = ?" + "WHERE appointment_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, app.getPatient_id());
			ps.setInt(2, app.getHospital_id());
			ps.setInt(3, app.getDoctor_id());
			ps.setString(4, app.getDate());
			ps.setString(5, app.getTime());
			ps.setInt(6, app.getAppointment_id());

			ps.executeUpdate();

			e = "Appointment details Updated";

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		return e;

	}

	public String DeleteAppointment(int id) {

		String status = null;

		try {
			String sql = "DELETE  FROM appointment  " + "WHERE appointment_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeLargeUpdate();

			status = "Appointment " + id + " deleted ";

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;

	}

}
