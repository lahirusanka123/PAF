package com.paf.HospitalManagement.HelthCare.Contraller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

 
@Path("/Admin")
public class AdminService {
	
	@GET
	@Path("/ViewAppointment")
	@Produces(MediaType.TEXT_HTML) 
	public String ViewAppointment() {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/AppointmentService/webapi/Appointment/");
		
		Response response;
		
		System.out.println(response = target.request().accept(MediaType.TEXT_HTML).get());
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String ReadResponse = response.readEntity(String.class);
		System.out.println(ReadResponse);
		
		return ReadResponse;
	}
	
	@GET
	@Path("/ViewPayment")
	@Produces(MediaType.TEXT_HTML) 
	public String ViewPayment() {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/PaymentService/webapi/Payment/");
		
		Response response;
		
		System.out.println(response = target.request().accept(MediaType.TEXT_HTML).get());
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String ReadResponse = response.readEntity(String.class);
		System.out.println(ReadResponse);
		
		return ReadResponse;
	}

	@GET
	@Path("/ViewDoctors")
	@Produces(MediaType.TEXT_HTML) 
	public String ViewDoctors() {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/DoctorService/webapi/Doctors/");
		
		Response response;
		
		System.out.println(response = target.request().accept(MediaType.TEXT_HTML).get());
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String ReadResponse = response.readEntity(String.class);
		System.out.println(ReadResponse);
		
		return ReadResponse+" <br>- By Administrator -";
	}
	
	@GET
	@Path("/AddDoctor")
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddDoctor(String data) {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/DoctorService/webapi/Doctor/");
		
		Response response;
		
		JsonObject Doc_details = new JsonParser().parse(data).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		String f_name = Doc_details.get("f_name").getAsString();
		String l_name = Doc_details.get("l_name").getAsString();
		String email = Doc_details.get("email").getAsString();
		int phoneNo = Doc_details.get("phoneNo").getAsInt(); 
		String nic = Doc_details.get("nic").getAsString(); 
		String Specialization = Doc_details.get("Specialization").getAsString(); 
		int age = Doc_details.get("age").getAsInt(); 


		String  Jsonstr = "{"
						+ "\"f_name\":"+f_name+", "
						+ "\"l_name\":"+l_name+","
						+ "\"email\":"+email+", "
						+ "\"phoneNo\":"+phoneNo+","
						+ "\"nic\":"+nic+", "
						+ "\"Specialization\":"+Specialization+","
						+ "\"age\":"+age+""
					+ "}"; 
		 
		
	
		System.out.println(	
				 
				 response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.json(Jsonstr), Response.class)
				);
		
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String Result = response.readEntity(String.class);
		System.out.println(Result);
		
		return Result +" Sucess  - By Administrator -";
	}
	
	
	@GET
	@Path("/UpdateDoctor")
	@Consumes(MediaType.APPLICATION_JSON)
	public String UpdateDoctor(String data) {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/DoctorService/webapi/Doctor/");
		
		Response response;
		
		JsonObject A_details = new JsonParser().parse(data).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		int id = A_details.get("id").getAsInt();
		String f_name = A_details.get("f_name").getAsString();
		String l_name = A_details.get("l_name").getAsString();
		String email = A_details.get("email").getAsString();
		int phoneNo = A_details.get("phoneNo").getAsInt(); 
		String nic = A_details.get("nic").getAsString(); 
		String Specialization = A_details.get("Specialization").getAsString(); 
		int age = A_details.get("age").getAsInt(); 
		
		


		String  Jsonstr = "{"
						+ "\"id\":"+id+", "
						+ "\"f_name\":"+f_name+", "
						+ "\"l_name\":"+l_name+","
						+ "\"email\":"+email+", "
						+ "\"phoneNo\":"+phoneNo+","
						+ "\"nic\":"+nic+", "
						+ "\"Specialization\":"+Specialization+","
						+ "\"age\":"+age+""
					+ "}"; 
		 
		
	
		System.out.println(	
				 
				 response = target.request().accept(MediaType.APPLICATION_JSON).put(Entity.json(Jsonstr), Response.class)
				);
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String Result = response.readEntity(String.class);
		System.out.println(Result);
		
		return Result +" Sucess  - By Administrator -";
	}
	
	@GET
	@Path("/DeleteDoctor")
	@Consumes(MediaType.APPLICATION_JSON)
	public String DeleteDoctor(String data) {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/DoctorService/webapi/Doctor/");
		
		Response response;
		
		JsonObject A_details = new JsonParser().parse(data).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		String id1 = A_details.get("id").getAsString();
		
		 
		System.out.println(	
				 
				 response = target.path(id1).request().accept(MediaType.APPLICATION_JSON).delete(Response.class)
				);
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String Result = response.readEntity(String.class);
		System.out.println(Result);
		
		return Result +" Sucess  - By Administrator -";
	}
	
	@GET
	@Path("/ViewHospitals")
	@Produces(MediaType.TEXT_HTML) 
	public String ViewHospitals() {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/HospitalService/webapi/Hospital/");
		
		Response response;
		
		System.out.println(response = target.request().accept(MediaType.TEXT_HTML).get());
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String ReadResponse = response.readEntity(String.class);
		System.out.println(ReadResponse);
		
		return ReadResponse +" <br>- By Administrator -" ;
	}
	
	@GET
	@Path("/AddHospital")
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddHospital(String data) {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/HospitalService/webapi/Hospital/");
		
		Response response;
		
		JsonObject H_details = new JsonParser().parse(data).getAsJsonObject(); 
		 
		String hospitalName = H_details.get("hospitalName").getAsString();
		String email = H_details.get("email").getAsString();
		int phoneNo = H_details.get("phoneNo").getAsInt();
		String city = H_details.get("city").getAsString(); 
		String address = H_details.get("address").getAsString(); 
		
		


		String  Jsonstr = "{"
							+ "\"hospitalName\":"+hospitalName+", "
							+ "\"email\":"+email+","						
							+ "\"phoneNo\":"+phoneNo+","
							+ "\"city\":"+city+", "
							+ "\"address\":"+address+""						 
						+ "}"; 
		 
		System.out.println(Jsonstr+"......thi.....this");
	
		System.out.println(	
				 
				 response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.json(Jsonstr), Response.class)
				);
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String Result = response.readEntity(String.class);
		System.out.println(Result);
		
		return Result +" Sucess  - By Administrator -";
	}
	
	@GET
	@Path("/UpdateHospital")
	@Consumes(MediaType.APPLICATION_JSON)
	public String UpdateHospital(String data) {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/HospitalService/webapi/Hospital/");
		
		Response response;
		
		JsonObject A_details = new JsonParser().parse(data).getAsJsonObject(); 
		 
		int hospital_id = A_details.get("hospital_id").getAsInt();
		String hospitalName = A_details.get("hospitalName").getAsString();
		String email = A_details.get("email").getAsString();
		int phoneNo = A_details.get("phoneNo").getAsInt();
		String city = A_details.get("city").getAsString(); 
		String address = A_details.get("address").getAsString(); 
		
		


		String  Jsonstr = "{"
						+ "\"hospital_id\":"+hospital_id+", "
						+ "\"hospitalName\":"+hospitalName+", "
						+ "\"email\":"+email+","						
						+ "\"phoneNo\":"+phoneNo+","
						+ "\"city\":"+city+", "
						+ "\"address\":"+address+""						 
					+ "}"; 
		
	
		System.out.println(	
				 
				 response = target.request().accept(MediaType.APPLICATION_JSON).put(Entity.json(Jsonstr), Response.class)
				);
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String Result = response.readEntity(String.class);
		System.out.println(Result);
		
		return Result +" Sucess  - By Administrator -";
	}
	
	@GET
	@Path("/DeleteHospital")
	@Consumes(MediaType.APPLICATION_JSON)
	public String DeleteHospital(String data) {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/HospitalService/webapi/Hospital/");
		
		Response response;
		
		JsonObject A_details = new JsonParser().parse(data).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		String id1 = A_details.get("hospital_id").getAsString(); 
	
		System.out.println(	
				 
				 response = target.path(id1).request().accept(MediaType.APPLICATION_JSON).delete(Response.class)
				);
		System.out.println(target+"   <.......target");
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String Result = response.readEntity(String.class);
		System.out.println(Result);
		
		return Result +" Sucess  - By Administrator -";
	}
}
