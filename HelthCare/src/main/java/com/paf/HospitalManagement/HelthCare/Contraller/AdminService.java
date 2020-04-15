package com.paf.HospitalManagement.HelthCare.Contraller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/Admin")
public class AdminService {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	
	@GET
	@Path("/getit")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getIt() {
		
		Client client =  ClientBuilder.newClient(); 
		WebTarget target = client.target("http://localhost:8080/HelthCare/webapi/Admin/Doctor");
		
		Response response;


		String  str = "{\"itemID\":\"111\",  \"itemCode\":\"0002\",  \"itemName\":\"lahiru\",  \"itemPrice\":\"45rs\",  \"itemDesc\":\"50%\" }"; 
		 
		
	
		System.out.println(	
				 
				 response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.json(str), Response.class)
				);
		response.bufferEntity();  //need to buffer entity, in order to read the entity multiple times from the Response's InputStream
		String s = response.readEntity(String.class);
		System.out.println(s);
		
		return "Got it!"+s;
	}

	@POST
	@Path("/Doctor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	public String User(String uData) {

		JsonObject itemObject = new JsonParser().parse(uData).getAsJsonObject();

		String itemID = itemObject.get("itemID").getAsString();
		String itemCode = itemObject.get("itemCode").getAsString();
		String itemName = itemObject.get("itemName").getAsString();
		String itemPrice = itemObject.get("itemPrice").getAsString();
		String itemDesc = itemObject.get("itemDesc").getAsString();

		ArrayList<String> user = new ArrayList<String>();
		
		user.add(itemID);
		user.add(itemCode);
		user.add(itemName);
		user.add(itemPrice);
		user.add(itemDesc);
		
		String a = "<table>"
				+ "<tr>"
				+ "<th>item ID<td>"
				+ "<th>item Code<td>"
				+ "<th>item Name<td>"
				+ "<th>item Price<td>"
				+ "<th><a href=\"http://localhost:8080/HelthCare/webapi/Admin/getit\">localhost:8080/HelthCare/webapi/Admin/getit</a><td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>"+itemID+"<td>"
				+ "<td>"+itemCode+"<td>"
				+ "<td>"+itemName+"<td>"
				+ "<td>"+itemPrice+"<td>"
				+ "<td>"+itemDesc+"<td>"
				+ "</tr>"
				+ "</table>";
		System.out.println(itemObject);
		
		return a;
	}
}
