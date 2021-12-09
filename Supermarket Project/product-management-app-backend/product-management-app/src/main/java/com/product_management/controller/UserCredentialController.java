package com.product_management.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.product_management.bean.UserCredential;

@Path("/users")
public class UserCredentialController {

	//http://localhost:8081/rest-web-service/rest/users/1
	@GET
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserCredential getUserCredential(@PathParam("userid") Integer userId) {
		return new UserCredential(userId,"admin","admin@123","admin@gmail.com",null);
		
	}
	
	
	//http://localhost:8081/rest-web-service/rest/users
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addUserCredential(UserCredential userCredential) {
		String userAsString= userCredential.getUserId().toString()+","+ 
										userCredential.getUserName()+","+
											userCredential.getEmail();
		return userAsString;
	}
	
	
	//http://localhost:8081/rest-web-service/rest/users
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserCredential updateUserCredential(UserCredential userCredential) {
		userCredential.setUserName(userCredential.getUserName()+"sapient");
		userCredential.setPassword("abcd");
		return userCredential;
	}
	
	
	
}
