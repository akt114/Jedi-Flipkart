package com.flipkart.restController;

import com.flipkart.DAO.AdminDao;
import com.flipkart.bean.Course;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.business.AdminOperation;
import com.flipkart.exceptions.DuplicateCourseException;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;


/*
 *@author JEDI-05
 * Implementation of Admin Controller
 *
 * */
//rest service here  http://localhost:8080/REST-jersey/customer/json
@Path("/admin")
public class AdminController {
    @POST
    @Path("/addCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Course addCourse(Course course) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	AdminOperation adminOperation=new AdminOperation();
    	adminOperation.addCourse(course);
        return course;

    }
    
    @DELETE
    @Path("/deleteCourse/{courseId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourse(@PathParam("courseId") String courseId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	AdminOperation adminOperation=new AdminOperation();
    	adminOperation.dropCourse(courseId);
    	return Response.status(200).entity("Course id " + courseId +
                " successfully deleted").build();

    }
    
    @PUT
    @Path("/approveStudent/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveStudent(@PathParam("studentId") String studentId) {

        // rest of impl write here in code

    	AdminOperation adminOperation=new AdminOperation();
    	adminOperation.approveStudent(studentId);
    	return Response.status(200).entity("Student id " + studentId +
                " successfully approved").build();

    }
    
    @POST
    @Path("/addProfessor")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfessor(Professor professor) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	AdminOperation adminOperation=new AdminOperation();
    	adminOperation.addProfessor(professor);
    	return Response.status(200).entity("Professor id " + professor.getId() +
                " successfully added").build();

    }
    
    
    @GET
    @Path("/generateReportCard/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  List<Grade> generateReportCard(@PathParam("studentId") String studentId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	AdminOperation adminOperation=new AdminOperation();
    	return adminOperation.generateReportCard(studentId);
    }
    
    
    
    
}