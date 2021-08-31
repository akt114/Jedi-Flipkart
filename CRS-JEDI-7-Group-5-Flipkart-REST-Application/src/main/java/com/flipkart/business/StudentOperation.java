package com.flipkart.business;

import com.flipkart.DAO.StudentDAO;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exceptions.*;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
*
* @author JEDI-05
* Implementation of Student Operations
*
* */

public class StudentOperation implements StudentInterface{

    private static Logger logger = Logger.getLogger(StudentOperation.class);
	StudentDAO dao = new StudentDAO();


	/*
	*
	* Method register for semester
	* @param student
	* @throws StudentAlreadyRegisteredException
	* */
    @Override
    public void registerForSemester(String studentId) throws StudentAlreadyRegisteredException, InvalidStudentException{
        logger.info("registerForSemester()");
        logger.debug(studentId);

    	dao.setRegistrationStatus(studentId);
        System.out.println("Registration Successful.");
    }


    /*
     *
     * Method to pay Fee
     * @param student
     * @param paymentId
     * */
    @Override
    public Response payFee(String studentId, String paymentId) throws SQLException, InvalidCourseException, PreConditionException {    	
    	logger.info("payFee()");
        logger.debug(studentId+" "+paymentId);
    	
    	if(!preConditionCheck(studentId).equals("true"))
    		throw new PreConditionException(preConditionCheck(studentId));
    	
    	if(dao.getBillStatus(studentId).equals("true")) {
    		return Response.status(500).entity("Fee already paid for student "+studentId).build();
    	}
    	
			dao.setBillStatus(studentId, paymentId);
		    return Response.status(200).entity("Fee payment complete for student "+studentId).build();
    }

    /*
     *
     * Method to view courses
     * */
    @Override
    public List<Course> viewCourses() {
    	return dao.getAllCourses();
    }

    /*
     *
     * Method to view GradeCard
     * @param student
     * @throws GradeNotAddedException
     * */
    @Override
    public HashMap<String, Integer> viewGradeCard(String studentId) throws GradeNotAddedException, SQLException, InvalidStudentException {
        logger.info("viewGradeCard()");
        logger.debug(studentId);

        HashMap<String, Integer> coursesAndGrades = dao.getGrades(studentId);
        float overallMarks = 0f;
        if(coursesAndGrades.size()!=4) {
        	throw new GradeNotAddedException("Number of courses should be 4");
        }
        for(Map.Entry<String, Integer> entry: coursesAndGrades.entrySet()){
        	if(entry.getValue()<=0) 
        		throw new GradeNotAddedException("Grade Card not generated yet");
        }
        for(Map.Entry<String, Integer> entry: coursesAndGrades.entrySet()){
        	System.out.println("Course name : " + entry.getKey() + ", Grade : " + entry.getValue());
        	overallMarks+=(float)entry.getValue();
        }
        overallMarks/=4.0f;
        System.out.println("CGPA is :" + overallMarks);
        
        return coursesAndGrades;
    }

    /*
     *
     * Method to add courses
     * @param student
     * @param courseId
     * @throws CourseAlreadyExistException
     * @throws ExcessStudentsException
     * */
    @Override
    public void addCourse(String studentId, String courseId) throws CourseAlreadyExistException, ExcessStudentsException, SQLException, InvalidCourseException{

        logger.info("addCourse()");
        logger.debug(studentId+" "+ " " + courseId);

        int numberOfStudents = dao.noOfStudentsEnrolled(courseId);
        if(numberOfStudents >= 10)
            throw new ExcessStudentsException("Already 10 students enrolled. Please choose another course.");
        
        List<String> courseList=dao.getEnrolledCourses(studentId);

        for(String s: courseList){
        	if(s.equals(courseId))
        		throw new CourseAlreadyExistException("You were already enrolled in this course.");
        }
        if(courseList.size() < 6){
            courseList.add(courseId);
            dao.addCourse(studentId, courseId);
            System.out.println("Course has been added to your course list.");
        }else{
            System.out.println("You cannot add more than 6 courses.");
        }
    }

    /*
     *
     * Method drop Course
     * @param student
     * @param courseId
     * @throws CourseDoesNotExistException
     * */
    @Override
    public void dropCourse(String studentId, String courseId) throws CourseDoesNotExistException, InvalidCourseException, SQLException{

        logger.info("dropCourse()");
        logger.debug(studentId+ " " + courseId);

        List<String> courseList = dao.getEnrolledCourses(studentId);
        if(courseList.contains(courseId)){
        	dao.dropCourse(studentId, courseId);
            System.out.println("Course has been deleted successfully.");
        }else{
            throw new CourseDoesNotExistException("Course was not present in the list.");
        }
    }

    /*
     *
     * Method preConditionCheck
     * @param student
     * */
    @Override
    public String preConditionCheck(String studentId) throws InvalidCourseException, SQLException {
        logger.info("preConditionCheck()");
        logger.debug(studentId);

        List<String > enrolledCourses = dao.getEnrolledCourses(studentId);
        if(enrolledCourses.size() < 6){
            return "Enrolled courses should be 6";
        }
        int countOfValidCourses = 0;
        for(String courseId : enrolledCourses){
            if(dao.noOfStudentsEnrolled(courseId) < 3){
                try {
                    dropCourse(studentId, courseId);
                }catch (CourseDoesNotExistException e){
                    System.out.println(e.getMessage());
                }
            }else{
                countOfValidCourses++;
            }
        }
        if(countOfValidCourses < 4){
            return "Valid courses cannot be less than 4";
        }
        enrolledCourses = dao.getEnrolledCourses(studentId);
        while(enrolledCourses.size() > 4){
            String courseId = enrolledCourses.get(0);
            enrolledCourses.remove(0);
            try {
                dropCourse(studentId, courseId);
            }catch (CourseDoesNotExistException e){
                System.out.println(e.getMessage());
            }
        }
        return "true";
    }

    /*
     *
     * Method viewEnrolledCourses
     * @param student
     * */
    public HashMap<String,String> viewEnrolledCourses(String studentId) throws SQLException, InvalidStudentException{

        logger.info("viewEnrolledCourses()");
        logger.debug(studentId);
    	return dao.getAllEnrolledCourses(studentId);
		
    }


    /*
     *
     * Method to signUp
     * @param student
     * */
    public void signUp(Student student){
        logger.info("signUp()");
        logger.debug(student.getId()+" "+student.getName() );

    	dao.signUp(student);
    }
}
