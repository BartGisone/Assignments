package com.bgisone.studentapp;

import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/courses")
public class CourseController {
	
	private CourseDAO courseDAO = new CourseDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses(){
		return courseDAO.readAll();
	}
	
	@GET
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourse(@PathParam("courseId") int courseid) {
		return courseDAO.read(courseid);
	}
	
	@GET
	@Path("/enrollment/available")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAvailableCourses(){
		return courseDAO.readAvailable();
	}
	
	@GET
	@Path("/enrollment/unavailable")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getUnavailableCourses(){
		return courseDAO.readFull();
	}
	//POST METHODS
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Course createCourse(Course course) {
		return courseDAO.create(course);
	}
	
	@POST
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_XHTML_XML)
	public String duplicateCourse(@PathParam("courseId") int courseid) {
		String x = courseDAO.create(courseid);
		if(x!=null) {
			return "Successfull Duplicate";
		}else {
			return "Unsuccssful Duplicate";
		}	
	}
	//PUT METHODS
	@PUT
	@Path("/{courseId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> updatedCourses(@PathParam("courseId") int courseID, Course course){
		return courseDAO.update(courseID, course);
	}
	
	@PUT
	@Path("enrollment/enroll/{courseId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addStudentToCourse(@PathParam("courseId") int courseID, Student student) {
		return courseDAO.updateEnroll(courseID, student);
	}
	
	@PUT
	@Path("enrollment/enroll/multiple/{courseId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addStudentsToCourse(@PathParam("courseId") int courseID, List<Integer> studentIds) {
		return courseDAO.updateEnrollMultiple(courseID, studentIds);
	}
	
	@PUT
	@Path("enrollment/enroll/drop/{courseId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String dropStudent(@PathParam("courseId") int courseId, Student student) {
		return courseDAO.updateDrop(courseId, student);
	}
	//DELETE METHOD
	
	@DELETE
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void courseDelete(@PathParam("courseId") int courseId) {
		courseDAO.deleteCourse(courseId);
	}
	
	
}
