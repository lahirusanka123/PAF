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
import com.paf.HospitalManagement.HelthCare.Bean.DoctorPrescriptionBean;
import com.paf.HospitalManagement.HelthCare.Model.DoctorPrescriptionModel;

@Path("/DoctorPrescription")
public class DoctorPrescriptionController{

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	//Convert the input string to an HTML document 
	public String ViewDoctorPrescription() {
		
		DoctorPrescriptionModel modelObject = new DoctorPrescriptionModel();
		String output= modelObject.ViewDoctorPrescription();
		
		return output;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	//Read the values from the JSON object  
	public String addDoctorPrescriprtion(String details) {
		
		//Convert the input string to a JSON object 
		JsonObject prescriptionbackObj = new JsonParser().parse(details).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		String patient_name = prescriptionbackObj.get("patient_name").getAsString();
		String doctor_name = prescriptionbackObj.get("doctor_name").getAsString();
		String medicine = prescriptionbackObj.get("medicine").getAsString();
		String descrip = prescriptionbackObj.get("description").getAsString(); 		

		DoctorPrescriptionBean prescriptionDoctor = new DoctorPrescriptionBean();	
	 
		prescriptionDoctor.setPatient_name(patient_name);
		prescriptionDoctor.setDoctor_name(doctor_name);
		prescriptionDoctor.setMedicine(medicine);
		prescriptionDoctor.setDescription(descrip);
		
		DoctorPrescriptionModel modelObject = new DoctorPrescriptionModel();
		String output= modelObject.addDoctorPrescriprtion(prescriptionDoctor);
		
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String UpdateDoctorPrescription(String details) {
		
		//Convert the input string to an Jason document  
		JsonObject prescriptionbackObjct = new JsonParser().parse(details).getAsJsonObject(); 
		 
		//Read the values from the JSON object
		int  prescription_id =  prescriptionbackObjct.get("prescription_id").getAsInt();
		String patient_name = prescriptionbackObjct.get("patient_name").getAsString();
		String doctor_name = prescriptionbackObjct.get("doctor_name").getAsString();
		String medicine = prescriptionbackObjct.get("medicine").getAsString();
		String descrip = prescriptionbackObjct.get("description").getAsString(); 		

		DoctorPrescriptionBean prescriptionDoctor = new DoctorPrescriptionBean();
	
	 	prescriptionDoctor.setPrescription_id(prescription_id);
		prescriptionDoctor.setPatient_name(patient_name);
		prescriptionDoctor.setDoctor_name(doctor_name);
		prescriptionDoctor.setMedicine(medicine);
		prescriptionDoctor.setDescription(descrip);
		
		DoctorPrescriptionModel modelObject = new DoctorPrescriptionModel();
		String output= modelObject.UpdateDoctorPrescription(prescriptionDoctor);
		
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	
	//Convert the input string to an Jason document 
	public String DeleteDoctorPrescription(String id) {
		
		JsonObject deleteDetails = new JsonParser().parse(id).getAsJsonObject();
		
		//Read the value from the element <feedback_id>
		int prescriptionId = deleteDetails.get("prescription_id").getAsInt();
		
		DoctorPrescriptionModel model = new DoctorPrescriptionModel();
		String output = model.DeleteDoctorPrescription(prescriptionId); 
		
		return output; 
		
	}
}