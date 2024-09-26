package com.bgisone.studentapp;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/students")
public class StudentController {
	
	private StudentDAOold studentDAO = new StudentDAOold();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents(){
		return studentDAO.readAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student createStudent(Student student) {
		return studentDAO.create(student);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("id") int id) {
		return studentDAO.read(id);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateStudent(@PathParam("id") int id, Student student) {
		return studentDAO.update(id, student);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStudent(@PathParam("id") int id) {
		studentDAO.delete(id);
	}
	
	//@GET
	//@Path("/totalApiCalls")
	//public Response getTotalApiCalls(ServletRequest request) {
	//	Integer counter = (Integer)request.getAttribute("apiCallCounter");
	//	if(counter == null) {
	//		counter = 0;
	//	}
	//	return Response.ok(counter.toString()).build();
	//}

}

