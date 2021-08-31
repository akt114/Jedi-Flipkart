package com.flipkart.restController;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.AdminOperation;
import com.flipkart.business.ProfessorOperations;
import com.flipkart.exceptions.DuplicateCourseException;
import com.flipkart.exceptions.GenericExceptionMapper;

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

import org.apache.log4j.Logger;


/**
 *@author JEDI-05
 * Implementation of Professor Controller
 *
 * */
//rest service here  http://localhost:8080/REST-jersey/customer/json
@Path("/professor")
public class ProfessorController {
	
	private static Logger logger = Logger.getLogger(ProfessorController.class);

	/**
	 * API to Enroll to teach a course
	 * @param courseId
	 * @param professorId
	 * @throws SQLException,DuplicateCourseException
	 */

    @POST
    @Path("/enroll/{courseId}/{professorId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response enrollCourse(@PathParam("courseId") String courseId,@PathParam("professorId") String professorId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	logger.info("enrollCourse()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    		ProfessorOperations professorOperations=new ProfessorOperations();
        	professorOperations.enrollToCourse(professorId, courseId);
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    	
    	return Response.status(200).entity("Professor " + professorId +
                " successfully enrolled for course "+courseId).build();

    }

	/**
	 * API to view all courses
	 * @throws SQLException, DuplicateCourseException
	 */
    
    @GET
    @Path("/viewCourses")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewCourse() throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	logger.info("viewCourse()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    		ProfessorOperations professorOperations=new ProfessorOperations();
        	return Response.status(200).entity(professorOperations.viewCourses()).build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    	
    }

	/**
	 * API to add grades for a student
	 * @param courseId
	 * @param professor
	 * @param studentId
	 * @throws SQLException, NoCoursesException
	 */
    
    @POST
    @Path("/addGrades")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGrades(@QueryParam("courseId") String courseId,@QueryParam("professorId") String professorId,@QueryParam("studentId") String studentId, @QueryParam("grade") int grade) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	logger.info("addGrades()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	ProfessorOperations professorOperations=new ProfessorOperations();
    	professorOperations.addGrades(professorId, studentId, courseId, grade);
    	return Response.status(200).entity("Grade " + grade +
                " assigned to student "+studentId+" for course "+courseId).build();
    	}
    	catch (Exception e) {
    		return exceptionMapper.toResponse(e);
    	}

    }


	/**
	 * Method to view enrolled students in a course
	 * @param courseId
	 * @throws SQLException , DuplicateCourseException
	 */

    @GET
    @Path("/viewEnrolledStudents/{courseId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response viewEnrolledStudents(@PathParam("courseId") String courseId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	logger.info("viewEnrolledStudents()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	ProfessorOperations professorOperations=new ProfessorOperations();
    	return Response.status(200).entity(professorOperations.viewEnrolledStudents(courseId)).build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    }

	/**
	 * API to view enrolled courses teaching
	 * @param professor
	 * @throws SQLException, DuplicateCourseException
	 */

    @GET
    @Path("/viewEnrolledCourses/{professorId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response viewEnrolledCourses(@PathParam("professorId") String professorId) throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	logger.info("viewEnrolledCourses()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	ProfessorOperations professorOperations=new ProfessorOperations();
    	return Response.status(200).entity(professorOperations.viewEnrolledCourses(professorId)).build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    }
}

