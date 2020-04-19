package com.paf.HospitalManagement.HelthCare.Contraller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.paf.HospitalManagement.HelthCare.Bean.HospitalBean;
import com.paf.HospitalManagement.HelthCare.Model.HospitalModel;

 
@Path("/Hospital")
public class HospitalService {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	public String View_Hospital() {
		
		HospitalModel model = new HospitalModel();
		String status = model.ViewHospital();
		
		return status;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Add_Hospital(String details) {
		
		JsonObject A_details = new JsonParser().parse(details).getAsJsonObject(); 
		 
		String hospitalName = A_details.get("hospitalName").getAsString();
		String email = A_details.get("email").getAsString();
		int phoneNo = A_details.get("phoneNo").getAsInt();
		String city = A_details.get("city").getAsString(); 
		String address = A_details.get("address").getAsString(); 
		
				
		HospitalBean hospital = new HospitalBean();		 
		hospital.setHospitalName(hospitalName);
		hospital.setEmail(email);
		hospital.setPhoneNo(phoneNo);
		hospital.setCity(city);
		hospital.setAddress(address);
		 
		HospitalModel model = new HospitalModel();
		String status = model.addHospital(hospital); 
		
		return status;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Update_Hospital(String details) {
		
		JsonObject A_details = new JsonParser().parse(details).getAsJsonObject(); 
		 
		int hospital_id = A_details.get("hospital_id").getAsInt();
		String hospitalName = A_details.get("hospitalName").getAsString();
		String email = A_details.get("email").getAsString();
		int phoneNo = A_details.get("phoneNo").getAsInt();
		String city = A_details.get("city").getAsString(); 
		String address = A_details.get("address").getAsString(); 
		
				
		HospitalBean hospital = new HospitalBean();		 
		hospital.setHospital_id(hospital_id);
		hospital.setHospitalName(hospitalName);
		hospital.setEmail(email);
		hospital.setPhoneNo(phoneNo);
		hospital.setCity(city);
		hospital.setAddress(address);
		 
		HospitalModel model = new HospitalModel();
		String status = model.UpdateHospital(hospital);  
		
		return status;
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String Delete_Hospital(@PathParam("id") String id) {
		
		int id1 = Integer.parseInt(id);
		
		HospitalModel model = new HospitalModel();
		String status = model.DeleteHospital(id1); 
		
		return status;
		
	}
}