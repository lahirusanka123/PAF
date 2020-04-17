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
import com.paf.HospitalManagement.HelthCare.Bean.PaymentBean;
import com.paf.HospitalManagement.HelthCare.Model.PaymentModel;

@Path("/Payment")
public class PaymentService {

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	public String View_Payment() {
		
		PaymentModel model = new PaymentModel();
		String status = model.ViewPayment();
		
		
		
		return status;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Add_Payment(String details) {
		
		JsonObject P_details = new JsonParser().parse(details).getAsJsonObject();
		
		
		int hospital_id = P_details.get("hospital_id").getAsInt();
		int patient_id = P_details.get("patient_id").getAsInt();
		int appointment_id = P_details.get("appointment_id").getAsInt();
		String type = P_details.get("type").getAsString();
		float amount = P_details.get("amount").getAsFloat();
		String date = P_details.get("date").getAsString();
		 
		 
		PaymentBean payment = new PaymentBean();
		payment.setHospital_id(hospital_id);
		payment.setPatient_id(patient_id);
		payment.setAppointment_id(appointment_id);
		payment.setType(type);
		payment.setAmount(amount);
		payment.setDate(date);
		 
		PaymentModel model = new PaymentModel();
		String status = model.addPayment(payment);
		
		
		
		return status;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Update_Payment(String details) {
		
		JsonObject P_details = new JsonParser().parse(details).getAsJsonObject();
		
		int payment_id = P_details.get("payment_id").getAsInt();
		int hospital_id = P_details.get("hospital_id").getAsInt();
		int patient_id = P_details.get("patient_id").getAsInt();
		int appointment_id = P_details.get("appointment_id").getAsInt();
		String type = P_details.get("type").getAsString();
		float amount = P_details.get("amount").getAsFloat();
		String date = P_details.get("date").getAsString();
		 
		 
		PaymentBean payment = new PaymentBean();
		payment.setPayment_id(payment_id);
		payment.setHospital_id(hospital_id);
		payment.setPatient_id(patient_id);
		payment.setAppointment_id(appointment_id);
		payment.setType(type);
		payment.setAmount(amount);
		payment.setDate(date);
		 
		PaymentModel model = new PaymentModel();
		String status = model.UpdatePayment(payment);
		
		
		
		
		return status;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String Delete_Payment(String id) {
		
		JsonObject P_details = new JsonParser().parse(id).getAsJsonObject();
		
		int id1 = P_details.get("payment_id").getAsInt();
		
		PaymentModel model = new PaymentModel();
		String status = model.DeletePayment(id1);
		
		
		
		return status;
	}
	
}
