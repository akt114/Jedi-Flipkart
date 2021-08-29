package com.flipkart.restController;

import com.flipkart.DAO.AdminDao;
import com.flipkart.bean.Course;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.AdminOperation;
import com.flipkart.business.ProfessorOperations;
import com.flipkart.business.StudentOperation;
import com.flipkart.exceptions.CourseAlreadyExistException;
import com.flipkart.exceptions.CourseDoesNotExistException;
import com.flipkart.exceptions.DuplicateCourseException;
import com.flipkart.exceptions.ExcessStudentsException;
import com.flipkart.exceptions.GradeNotAddedException;
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


/*
 *@author JEDI-05
 * Implementation of Professor Controller
 *
 * */
//rest service here  http://localhost:8080/REST-jersey/customer/json
@Path("/student")
public class StudentController {
    @POST
    @Path("/registerForSemester/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response enrollCourse(@PathParam("studentId") String studentId) throws SQLException, DuplicateCourseException, StudentAlreadyRegisteredException {

        // rest of impl write here in code
    	StudentOperation studentOperation=new StudentOperation();
    	studentOperation.registerForSemester(studentId);
    	return Response.status(200).entity("Student " + studentId +
                " successfully registered for semester").build();

    }
    
    @GET
    @Path("/viewCourses")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCourse() throws SQLException, DuplicateCourseException {

        // rest of impl write here in code
    	StudentOperation studentOperation=new StudentOperation();
    	return studentOperation.viewCourses();
    }
    
    @POST
    @Path("/addCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGrades(@QueryParam("courseId") String courseId,@QueryParam("studentId") String studentId) throws SQLException, DuplicateCourseException, CourseAlreadyExistException, ExcessStudentsException {

        // rest of impl write here in code
    	StudentOperation studentOperation=new StudentOperation();
    	studentOperation.addCourse(studentId, courseId);
    	return Response.status(200).entity("Course "+courseId+" added succefully for student "+studentId).build();

    }
    
    @POST
    @Path("/dropCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dropCourse(@QueryParam("courseId") String courseId,@QueryParam("studentId") String studentId) throws SQLException, DuplicateCourseException, CourseAlreadyExistException, ExcessStudentsException, CourseDoesNotExistException {

        // rest of impl write here in code
    	StudentOperation studentOperation=new StudentOperation();
    	studentOperation.dropCourse(studentId, courseId);
    	return Response.status(200).entity("Course "+courseId+" dropped succefully for student "+studentId).build();

    }
    
    @GET
    @Path("/viewEnrolledCourses/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  HashMap<String,String> viewEnrolledCourses(@PathParam("studentId") String studentId) throws SQLException {

        // rest of impl write here in code
    	StudentOperation studentOperation=new StudentOperation();
    	return studentOperation.viewEnrolledCourses(studentId);
    }
    
    @GET
    @Path("/viewGradeCard/{studentId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public  HashMap<String, Integer> viewGradeCard(@PathParam("studentId") String studentId) throws SQLException, GradeNotAddedException {

        // rest of impl write here in code
    	StudentOperation studentOperation=new StudentOperation();
    	return studentOperation.viewGradeCard(studentId);
    }
    
    @POST
    @Path("/payFee")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response payFee(@QueryParam("paymentId") String paymentId,@QueryParam("studentId") String studentId) throws SQLException, DuplicateCourseException, CourseAlreadyExistException, ExcessStudentsException, CourseDoesNotExistException {

        // rest of impl write here in code
    	StudentOperation studentOperation=new StudentOperation();
    	return studentOperation.payFee(studentId, paymentId);
    }
}


