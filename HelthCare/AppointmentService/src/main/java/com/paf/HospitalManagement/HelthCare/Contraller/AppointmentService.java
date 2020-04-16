package com.paf.HospitalManagement.HelthCare.Contraller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.paf.HospitalManagement.HelthCare.Bean.AppointmentBean;
import com.paf.HospitalManagement.HelthCare.Model.AppointmentModel;

@Path("/Appointment")
public class AppointmentService {
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	public String View_Appointment() {
		
		AppointmentModel model = new AppointmentModel();
		String status = model.ViewAppointment(); 
		
		return status;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Add_Appointment(String details) {
		
		JsonObject A_details = new JsonParser().parse(details).getAsJsonObject(); 
		 
		int patient_id = A_details.get("patient_id").getAsInt();
		int hospital_id = A_details.get("hospital_id").getAsInt();
		int doctor_id = A_details.get("doctor_id").getAsInt();
		String date = A_details.get("date").getAsString(); 
		String time = A_details.get("time").getAsString(); 
		
		AppointmentBean appointment = new AppointmentBean();		 
		appointment.setPatient_id(patient_id);
		appointment.setHospital_id(hospital_id);
		appointment.setDoctor_id(doctor_id);
		appointment.setDate(date);  
		appointment.setTime(time);
		 
		AppointmentModel model = new AppointmentModel();
		String status = model.addAppointment(appointment); 
		
		return status;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Update_Appointment(String details) {
		
		JsonObject A_details = new JsonParser().parse(details).getAsJsonObject(); 
		 
		int appointment_id = A_details.get("appointment_id").getAsInt();
		int patient_id = A_details.get("patient_id").getAsInt();
		int hospital_id = A_details.get("hospital_id").getAsInt();
		int doctor_id = A_details.get("doctor_id").getAsInt();
		String date = A_details.get("date").getAsString(); 
		String time = A_details.get("time").getAsString(); 
		
		AppointmentBean appointment = new AppointmentBean();		 
		appointment.setAppointment_id(appointment_id);
		appointment.setPatient_id(patient_id);
		appointment.setHospital_id(hospital_id);
		appointment.setDoctor_id(doctor_id);
		appointment.setDate(date);  
		appointment.setTime(time);
		 
		AppointmentModel model = new AppointmentModel();
		String status = model.UpdateAppointment(appointment);  
		
		return status;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String Delete_Appointment(String id) {
		
		JsonObject P_details = new JsonParser().parse(id).getAsJsonObject();
		
		int id1 = P_details.get("appointment_id").getAsInt();
		
		AppointmentModel model = new AppointmentModel();
		String status = model.DeleteAppointment(id1); 
		
		return status;
		
	}

}
