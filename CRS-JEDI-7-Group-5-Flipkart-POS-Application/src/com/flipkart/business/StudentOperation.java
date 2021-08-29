package com.flipkart.business;

import com.flipkart.DAO.StudentDAOOperations;
import com.flipkart.bean.Student;
import com.flipkart.exceptions.*;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Formatter;
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
    public void registerForSemester(Student student) throws StudentAlreadyRegisteredException{
        if(student.isRegistrationStatus()){
    		throw new StudentAlreadyRegisteredException("Already Registered for Semester");
    	}
        logger.info("registerForSemester()");
        logger.debug(student.getId()+" "+student.getName());

    	student.setRegistrationStatus(true);
    	dao.setRegistrationStatus(student);
        System.out.println("Registration Successful.");
        System.out.println();
    }


    /*
     *
     * Method to pay Fee
     * @param student
     * @param paymentId
     * */
    @Override
    public void payFee(Student student, String paymentId) {
//        BillPay billPay = student.getBillPay();
//        billPay.setId(paymentId);
//        billPay.setStatus(true);
//        student.setBillPay(billPay);
    	
    	try {
			dao.setBillStatus(student, paymentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("hi");
            System.out.println(e.getMessage());
        }

        logger.info("payFee()");
        logger.debug(student.getId()+" "+student.getName() + " " + paymentId);

        System.out.println("Bill payment completed.");
        System.out.println();
    }

    /*
     *
     * Method to view courses
     * */
    @Override
    public void viewCourses() {
    	dao.getAllCourses();
        System.out.println();
    }

    /*
     *
     * Method to view GradeCard
     * @param student
     * @throws GradeNotAddedException
     * */
    @Override
    public void viewGradeCard(Student student) throws GradeNotAddedException {
        logger.info("viewGradeCard()");
        logger.debug(student.getId()+" "+student.getName() );

        HashMap<String, Integer> coursesAndGrades = dao.getGrades(student);
        float overallMarks = 0f;
        if(coursesAndGrades.size()!=4) {
        	throw new GradeNotAddedException("Number of courses should be 4!!!\n");
        }
        for(Map.Entry<String, Integer> entry: coursesAndGrades.entrySet()){
        	if(entry.getValue()<=0) 
        		throw new GradeNotAddedException("Grade Card not generated yet!!!\n");
        }

        Formatter fmt = new Formatter();
        System.out.println("*******************************************************************************************");
        fmt.format("%20s %20s\n", "Course name", "Grade");

        for(Map.Entry<String, Integer> entry: coursesAndGrades.entrySet()){
//        	System.out.println("Course name : " + entry.getKey() + ", Grade : " + entry.getValue());
            fmt.format("%15s %23s\n", entry.getKey(), entry.getValue());
            overallMarks+=(float)entry.getValue();
        }

        System.out.println(fmt);
        System.out.println("*******************************************************************************************");
        overallMarks/=4.0f;
        System.out.println("CGPA is :" + overallMarks);
        System.out.println();
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
    public void addCourse(Student student, String courseId) throws CourseAlreadyExistException, ExcessStudentsException{

        logger.info("addCourse()");
        logger.debug(student.getId()+" "+student.getName() + " " + courseId);

        List<String> courseList = student.getRegisteredCourses();

        int numberOfStudents = dao.noOfStudentsEnrolled(courseId);
        if(numberOfStudents >= 10)
            throw new ExcessStudentsException("Already 10 students enrolled. Please choose another course.");


        for(String s: courseList){
        	if(s.equals(courseId))
        		throw new CourseAlreadyExistException("You were already enrolled in this course.");
        }
        if(courseList.size() < 6){
            courseList.add(courseId);
            dao.addCourse(student, courseId);
            student.setRegisteredCourses(courseList);
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
    public void dropCourse(Student student, String courseId) throws CourseDoesNotExistException{

        logger.info("dropCourse()");
        logger.debug(student.getId()+" "+student.getName() + " " + courseId);

        List<String> courseList = student.getRegisteredCourses();
        if(courseList.contains(courseId)){
        	dao.dropCourse(student, courseId);
            courseList.remove(courseId);
            student.setRegisteredCourses(courseList);
            System.out.println("Course has been deleted successfully.");
        }else{
            throw new CourseDoesNotExistException("Course was not present in the list.");
        }
        System.out.println();
    }


    /*
     *
     * Method preConditionCheck
     * @param student
     * */
    @Override
    public boolean preConditionCheck(Student student) {
        logger.info("preConditionCheck()");
        logger.debug(student.getId()+" "+student.getName() );

        List<String > enrolledCourses = dao.getEnrolledCourses(student);
        if(enrolledCourses.size() < 6){
            return false;
        }
        int countOfValidCourses = 0;
        for(String courseId : enrolledCourses){
            if(dao.noOfStudentsEnrolled(courseId) < 3){
                try {
                    dropCourse(student, courseId);
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
        enrolledCourses = dao.getEnrolledCourses(student);
        while(enrolledCourses.size() > 4){
            String courseId = enrolledCourses.get(0);
            enrolledCourses.remove(0);
            try {
                dropCourse(student, courseId);
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
    public void viewEnrolledCourses(Student student){

        logger.info("viewEnrolledCourses()");
        logger.debug(student.getId()+" "+student.getName() );
    	try {
			dao.getAllEnrolledCourses(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
