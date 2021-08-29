package com.flipkart.business;

import com.flipkart.DAO.StudentDAOOperations;
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
	StudentDAOOperations dao = new StudentDAOOperations();


	/*
	*
	* Method register for semester
	* @param student
	* @throws StudentAlreadyRegisteredException
	* */
    @Override
    public void registerForSemester(String studentId) throws StudentAlreadyRegisteredException{
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
    public Response payFee(String studentId, String paymentId) throws SQLException {    	
    	logger.info("payFee()");
        logger.debug(studentId+" "+paymentId);
    	
    	if(!preConditionCheck(studentId))
    		return Response.status(500).entity("Registration preconditions not met for student "+studentId).build();
    	
    	if(dao.getBillStatus(studentId).equals("true")) {
    		return Response.status(500).entity("Fee already paid for student "+studentId).build();
    	}
    	try {
			dao.setBillStatus(studentId, paymentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        

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
    public HashMap<String, Integer> viewGradeCard(String studentId) throws GradeNotAddedException {
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
    public void addCourse(String studentId, String courseId) throws CourseAlreadyExistException, ExcessStudentsException{

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
    public void dropCourse(String studentId, String courseId) throws CourseDoesNotExistException{

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
    public boolean preConditionCheck(String studentId) {
        logger.info("preConditionCheck()");
        logger.debug(studentId);

        List<String > enrolledCourses = dao.getEnrolledCourses(studentId);
        if(enrolledCourses.size() < 6){
            return false;
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
            return false;
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
        return true;
    }

    /*
     *
     * Method viewEnrolledCourses
     * @param student
     * */
    public HashMap<String,String> viewEnrolledCourses(String studentId){

        logger.info("viewEnrolledCourses()");
        logger.debug(studentId);
    	try {
			return dao.getAllEnrolledCourses(studentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return null;
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
