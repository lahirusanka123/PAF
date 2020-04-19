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
import com.paf.HospitalManagement.HelthCare.Bean.DoctorAppointmentBean;
import com.paf.HospitalManagement.HelthCare.Model.DoctorAppointmentModel;

@Path("/DoctorAppointment")
public class DoctorAppointmentController {

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	//Convert the input string to an HTML document 
	public String ViewDoctorApoointment() {
		
		DoctorAppointmentModel modelObject = new DoctorAppointmentModel();
		String status = modelObject.ViewDoctorApoointment();
		
		return status;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	//Read the values from the JSON object  
	public String Add_Doctor(String details) {
		
		//Convert the input string to a JSON object 
		JsonObject docObj = new JsonParser().parse(details).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		int patient_no = docObj.get("patient_number").getAsInt();
		String patient_name = docObj.get("patient_name").getAsString();
		String time = docObj.get("time").getAsString();
		String date = docObj.get("date").getAsString(); 
		String status = docObj.get("status").getAsString(); 
		 
 
		DoctorAppointmentBean doctorAppointment = new DoctorAppointmentBean();
		 
		doctorAppointment.setPatient_no(patient_no);
		doctorAppointment.setPatient_name(patient_name);
		doctorAppointment.setTime(time);
		doctorAppointment.setDate(date);
		doctorAppointment.setStatus(status);
		 
		DoctorAppointmentModel model = new DoctorAppointmentModel();
		String output = model.addDoctorApoointment(doctorAppointment);  
		
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String UpdateDoctorAppointment(String details) {
		
		//Convert the input string to an Jason object  
		JsonObject docObj = new JsonParser().parse(details).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		int appoinement_id = docObj.get("appoinement_id").getAsInt();
		int patient_no = docObj.get("patient_number").getAsInt();
		String patient_name = docObj.get("patient_name").getAsString();
		String time = docObj.get("time").getAsString();
		String date = docObj.get("date").getAsString(); 
		String status = docObj.get("status").getAsString(); 
		 
		DoctorAppointmentBean doctorAppointment = new DoctorAppointmentBean();
		 
		doctorAppointment.setAppoinement_id(appoinement_id);
		doctorAppointment.setPatient_no(patient_no);
		doctorAppointment.setPatient_name(patient_name);
		doctorAppointment.setTime(time);
		doctorAppointment.setDate(date);
		doctorAppointment.setStatus(status);
		 
		DoctorAppointmentModel model = new DoctorAppointmentModel();
		String output = model.UpdateDoctorAppointment(doctorAppointment);  
		
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	
	//Convert the input string to an jason object 
	public String DeleteDoctorAppointment(String id) {
		
		JsonObject deleteDetails = new JsonParser().parse(id).getAsJsonObject();
		
		//Read the value from the element <appoinement_id>  
		int docappid = deleteDetails.get("appoinement_id").getAsInt();
		
		DoctorAppointmentModel model = new DoctorAppointmentModel();
		String status = model.DeleteDoctorAppointment(docappid);
		
		return status;
		
	}
}
