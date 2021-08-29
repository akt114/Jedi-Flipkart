package com.flipkart.restController;

import com.flipkart.DAO.AdminDao;
import com.flipkart.bean.Course;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.AdminOperation;
import com.flipkart.business.ProfessorOperations;
import com.flipkart.exceptions.DuplicateCourseException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;


/*
 *@author JEDI-05
 * Implementation of Professor Controller
 *
 * */
//rest service here  http://localhost:8080/REST-jersey/customer/json
@Path("/professor")
public class ProfessorController {
    @POST
    @Path("/enroll/{courseId}/{professorId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response enrollCourse(@PathParam("courseId") String courseId,@PathParam("professorId") String professorId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	ProfessorOperations professorOperations=new ProfessorOperations();
    	professorOperations.enrollToCourse(professorId, courseId);
    	return Response.status(200).entity("Professor " + professorId +
                " successfully enrolled for course "+courseId).build();

    }
    
    @GET
    @Path("/viewCourses")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCourse() throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	ProfessorOperations professorOperations=new ProfessorOperations();
    	return professorOperations.viewCourses();
    }
    
    @POST
    @Path("/addGrades")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGrades(@QueryParam("courseId") String courseId,@QueryParam("professorId") String professorId,@QueryParam("studentId") String studentId, @QueryParam("grade") int grade) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	ProfessorOperations professorOperations=new ProfessorOperations();
    	professorOperations.addGrades(professorId, studentId, courseId, grade);
    	return Response.status(200).entity("Grade " + grade +
                " assigned to student "+studentId+" for course "+courseId).build();

    }
    
    @GET
    @Path("/viewEnrolledStudents/{courseId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  HashMap<String,String> viewEnrolledStudents(@PathParam("courseId") String courseId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	ProfessorOperations professorOperations=new ProfessorOperations();
    	return professorOperations.viewEnrolledStudents(courseId);
    }
    
    @GET
    @Path("/viewEnrolledCourses/{professorId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  List<Course> viewEnrolledCourses(@PathParam("professorId") String professorId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	ProfessorOperations professorOperations=new ProfessorOperations();
    	return professorOperations.viewEnrolledCourses(professorId);
    }
}


