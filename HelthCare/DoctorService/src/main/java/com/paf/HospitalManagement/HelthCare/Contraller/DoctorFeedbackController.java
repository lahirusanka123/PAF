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
import com.paf.HospitalManagement.HelthCare.Bean.DoctorFeedbackBean;
import com.paf.HospitalManagement.HelthCare.Model.DoctorFeedbackModel;

@Path("/DoctorFeedbackController")
public class DoctorFeedbackController{

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	//Convert the input string to an HTML document 
	public String ReadDoctorFeedback() {
		
		DoctorFeedbackModel modelObject = new DoctorFeedbackModel();
		String output= modelObject.ReadDoctorFeedback();
		
		return output;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	//Read the values from the JSON object  
	public String InsertDoctorFeedback(String details) {
		
		//Convert the input string to a JSON object 
		JsonObject feedbackObj = new JsonParser().parse(details).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		String userName = feedbackObj.get("userName").getAsString();
		String date = feedbackObj.get("date").getAsString();
		String msg = feedbackObj.get("message").getAsString();
 
		DoctorFeedbackBean feedbackDoctor = new DoctorFeedbackBean();	
	 
		feedbackDoctor.setUserName(userName);
		feedbackDoctor.setDate(date);
		feedbackDoctor.setMsg(msg);
		
		DoctorFeedbackModel modelObject = new DoctorFeedbackModel();
		String output= modelObject.insertDoctorFeedback(feedbackDoctor);
		
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String UpdateDoctorFeedback(String details) {
		
		//Convert the input string to an Jason object  
		JsonObject feedbackObj = new JsonParser().parse(details).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		int feedbackId = feedbackObj.get("feedback_id").getAsInt();
		String userName = feedbackObj.get("userName").getAsString();
		String date = feedbackObj.get("date").getAsString();
		String msg = feedbackObj.get("message").getAsString();
 
		DoctorFeedbackBean feedbackDoctor = new DoctorFeedbackBean();	
	 	
		feedbackDoctor.setFeedbackId(feedbackId);
		feedbackDoctor.setUserName(userName);
		feedbackDoctor.setDate(date);
		feedbackDoctor.setMsg(msg);
		
		DoctorFeedbackModel modelObject = new DoctorFeedbackModel();
		String output= modelObject.UpdateDoctorFeedback(feedbackDoctor);
		
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	
	//Convert the input string to an jason object 
	public String DeleteDoctorFeedback(String id) {
		
		JsonObject deleteDetails = new JsonParser().parse(id).getAsJsonObject();
		
		//Read the value from the element <feedback_id>
		int feedbackId = deleteDetails.get("feedback_id").getAsInt();
		
		DoctorFeedbackModel model = new DoctorFeedbackModel();
		String output = model.DeleteDoctorFeedback(feedbackId); 
		
		return output; 
		
	}
}