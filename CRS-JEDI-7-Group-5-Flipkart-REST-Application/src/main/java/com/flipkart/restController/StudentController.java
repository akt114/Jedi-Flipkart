package com.flipkart.restController;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.AdminOperation;
import com.flipkart.business.ProfessorOperations;
import com.flipkart.business.StudentOperation;
import com.flipkart.business.UserOperations;
import com.flipkart.exceptions.CourseAlreadyExistException;
import com.flipkart.exceptions.CourseDoesNotExistException;
import com.flipkart.exceptions.DuplicateCourseException;
import com.flipkart.exceptions.ExcessStudentsException;
import com.flipkart.exceptions.GenericExceptionMapper;
import com.flipkart.exceptions.GradeNotAddedException;
import com.flipkart.exceptions.InvalidCourseException;
import com.flipkart.exceptions.PreConditionException;
import com.flipkart.exceptions.StudentAlreadyRegisteredException;

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
@Path("/student")
public class StudentController {
	
	private static Logger logger = Logger.getLogger(StudentController.class);

	/**
	 * API to  register student for semester
	 * @param studentId
	 * @throws StudentAlreadyRegisteredException
	 * @throws SQLException
	 */
    @POST
    @Path("/registerForSemester/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerForSemester(@PathParam("studentId") String studentId) throws SQLException, StudentAlreadyRegisteredException {

        // rest of impl write here in code
    	logger.info("enrollCourse()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    		StudentOperation studentOperation=new StudentOperation();
        	studentOperation.registerForSemester(studentId);
        	return Response.status(200).entity("Student " + studentId +
                    " successfully registered for semester").build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}

    }

	/**
	 * API to  view courses for semester
	 * @throws StudentAlreadyRegisteredException
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
    	StudentOperation studentOperation=new StudentOperation();
    	return Response.status(200).entity(studentOperation.viewCourses()).build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    }

	/**
	 * API to add course
	 * @param studentId
	 * @param courseId
	 * @throws SQLException
	 * @throws InvalidCourseException
	 */

    @POST
    @Path("/addCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(@QueryParam("courseId") String courseId,@QueryParam("studentId") String studentId) throws SQLException, DuplicateCourseException, CourseAlreadyExistException, ExcessStudentsException {

        // rest of impl write here in code
    	logger.info("addCourse()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	StudentOperation studentOperation=new StudentOperation();
    	studentOperation.addCourse(studentId, courseId);
    	return Response.status(200).entity("Course "+courseId+" added succefully for student "+studentId).build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}

    }

	/**
	 * API to drop course
	 * @param studentId
	 * @param courseId
	 * @throws InvalidCourseException
	 * @throws SQLException
	 */
    @POST
    @Path("/dropCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dropCourse(@QueryParam("courseId") String courseId,@QueryParam("studentId") String studentId) throws SQLException, DuplicateCourseException, CourseAlreadyExistException, ExcessStudentsException, CourseDoesNotExistException, InvalidCourseException {

        // rest of impl write here in code
    	logger.info("dropCourse()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	StudentOperation studentOperation=new StudentOperation();
    	studentOperation.dropCourse(studentId, courseId);
    	return Response.status(200).entity("Course "+courseId+" dropped succefully for student "+studentId).build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}

    }

	/**
	 * API to view enrolled courses
	 * @param studentId
	 * @throws SQLException
	 */

    @GET
    @Path("/viewEnrolledCourses/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response viewEnrolledCourses(@PathParam("studentId") String studentId) throws SQLException {

        // rest of impl write here in code
    	logger.info("viewEnrolledCourses()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	StudentOperation studentOperation=new StudentOperation();
    	return Response.status(200).entity(studentOperation.viewEnrolledCourses(studentId)).build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    }

	/**
	 * API to view grades
	 * @param studentId
	 * @throws SQLException
	 * @throws InvalidStudentException,GradeNotAddedException
	 */
    
    @GET
    @Path("/viewGradeCard/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response viewGradeCard(@PathParam("studentId") String studentId) throws SQLException, GradeNotAddedException {

        // rest of impl write here in code
    	logger.info("viewGradeCard()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	StudentOperation studentOperation=new StudentOperation();
    	return Response.status(200).entity(studentOperation.viewGradeCard(studentId)).build();
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    }

	/**
	 * API to pay fee for semester
	 * @param studentId
	 * @param paymentId
	 * @throws DuplicateCourseException, CourseAlreadyExistException, ExcessStudentsException, CourseDoesNotExistException, InvalidCourseException, PreConditionException
	 */

    @POST
    @Path("/payFee")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response payFee(@QueryParam("paymentId") String paymentId,@QueryParam("studentId") String studentId) throws SQLException, DuplicateCourseException, CourseAlreadyExistException, ExcessStudentsException, CourseDoesNotExistException, InvalidCourseException, PreConditionException {

        // rest of impl write here in code
    	logger.info("payFee()");
    	GenericExceptionMapper exceptionMapper=new GenericExceptionMapper();
    	try {
    	StudentOperation studentOperation=new StudentOperation();
    	return studentOperation.payFee(studentId, paymentId);
    	}
    	catch(Exception e) {
    		return exceptionMapper.toResponse(e);
    	}
    }
}

