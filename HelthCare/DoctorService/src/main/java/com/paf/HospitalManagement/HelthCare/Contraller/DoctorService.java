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
import com.paf.HospitalManagement.HelthCare.Bean.DoctorBean;
import com.paf.HospitalManagement.HelthCare.Model.DoctorModel;

@Path("/Doctor")
public class DoctorService {

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	public String View_Doctor() {
		
		DoctorModel modelObject = new DoctorModel();
		String status = modelObject.ViewDoctor();
		
		return status;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Add_Doctor(String details) {
		
		JsonObject A_details = new JsonParser().parse(details).getAsJsonObject(); 
		 
		String f_name = A_details.get("f_name").getAsString();
		String l_name = A_details.get("l_name").getAsString();
		String email = A_details.get("email").getAsString();
		int phoneNo = A_details.get("phoneNo").getAsInt(); 
		String nic = A_details.get("nic").getAsString(); 
		String Specialization = A_details.get("Specialization").getAsString(); 
		int age = A_details.get("age").getAsInt(); 

		 
		DoctorBean doctor = new DoctorBean();		 
		doctor.setF_name(f_name);
		doctor.setL_name(l_name);
		doctor.setEmail(email);
		doctor.setPhoneNo(phoneNo);
		doctor.setNic(nic);
		doctor.setSpecialization(Specialization);
		doctor.setAge(age);
		 
		DoctorModel model = new DoctorModel();
		String status = model.addDoctor(doctor); 
		
		return status;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Update_Doctor(String details) {
		
		JsonObject A_details = new JsonParser().parse(details).getAsJsonObject(); 
		 
		int id = A_details.get("id").getAsInt();
		String f_name = A_details.get("f_name").getAsString();
		String l_name = A_details.get("l_name").getAsString();
		String email = A_details.get("email").getAsString();
		int phoneNo = A_details.get("phoneNo").getAsInt(); 
		String nic = A_details.get("nic").getAsString(); 
		String Specialization = A_details.get("Specialization").getAsString(); 
		int age = A_details.get("age").getAsInt(); 

		 
		DoctorBean doctor = new DoctorBean();		 
		doctor.setId(id);
		doctor.setF_name(f_name);
		doctor.setL_name(l_name);
		doctor.setEmail(email);
		doctor.setPhoneNo(phoneNo);
		doctor.setNic(nic);
		doctor.setSpecialization(Specialization);
		doctor.setAge(age);
		 
		DoctorModel model = new DoctorModel();
		String status = model.UpdateDoctor(doctor); 
		
		return status;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String Delete_Doctor(String id) {
		
		JsonObject P_details = new JsonParser().parse(id).getAsJsonObject();
		
		int id1 = P_details.get("id").getAsInt();
		
		DoctorModel model = new DoctorModel();
		String status = model.DeleteDoctor(id1); 
		
		return status;
		
	}
}
