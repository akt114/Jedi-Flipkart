package com.dropwizard.restController;

import com.dropwizard.DAO.AdminDAO;
import com.dropwizard.bean.Course;
import com.dropwizard.bean.Grade;
import com.dropwizard.bean.Professor;
import com.dropwizard.business.AdminOperation;
import com.dropwizard.exceptions.DuplicateCourseException;
import com.dropwizard.exceptions.ErrorProps;
import com.dropwizard.exceptions.GenericExceptionMapper;

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
import javax.ws.rs.core.Response.Status;
import javax.xml.crypto.URIReferenceException;

import org.apache.log4j.Logger;


/**
 *@author JEDI-05
 * Implementation of Admin Controller
 *
 * */

@Path("/admin")
public class AdminController {
	
	private static Logger logger = Logger.getLogger(AdminController.class);
	/**
	 * API to Add Course to Course Catalog
	 * @param course
	 * @throws SQLException, DuplicateCourseException
	 */

    @POST
    @Path("/addCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(Course course) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	logger.info("addCourse()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	AdminOperation adminOperation=new AdminOperation();
    	adminOperation.addCourse(course);
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
   
    	return Response.status(200).entity("Course " + course.getId() +" "+course.getName()+
                " successfully added").build();

    }

	/**
	 * API to Delete Course from Course Catalog
	 * @param courseId
	 * @throws SQLException, InvalidCourseException, DuplicateCourseException
	 */
    
    @DELETE
    @Path("/deleteCourse/{courseId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourse(@PathParam("courseId") String courseId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	logger.info("deleteCourse()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    		AdminOperation adminOperation=new AdminOperation();
        	adminOperation.dropCourse(courseId);
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    	return Response.status(201).entity("Course id " + courseId +
                " successfully deleted").build();

    }

	/**
	 * API to Approve student registration
	 * @param studentId
	 * @throws SQLException, InvalidStudentException
	 */

    @PUT
    @Path("/approveStudent/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveStudent(@PathParam("studentId") String studentId) {

        // rest of impl write here in code
    	logger.info("approveStudent()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	AdminOperation adminOperation=new AdminOperation();
    	adminOperation.approveStudent(studentId);
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    	return Response.status(200).entity("Student id " + studentId +
                " successfully approved").build();

    }

	/**
	 * API to Add professor
	 * @param professor
	 * @throws SQLException, DuplicateProfessorException
	 */

    @POST
    @Path("/addProfessor")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfessor(Professor professor) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	logger.info("addProfessor()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    		AdminOperation adminOperation=new AdminOperation();
        	adminOperation.addProfessor(professor);
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    	
    	return Response.status(200).entity("Professor id " + professor.getId() +
                " successfully added").build();

    }

	/**
	 * API to generate Grade Card
	 * @param studentId
	 * @throws SQLException,DuplicateCourseException
	 */

    @GET
    @Path("/generateReportCard/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response generateReportCard(@PathParam("studentId") String studentId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	logger.info("generateReportCard()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    		AdminOperation adminOperation=new AdminOperation();
    		return Response.status(200).entity(adminOperation.generateReportCard(studentId)).build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    }
}