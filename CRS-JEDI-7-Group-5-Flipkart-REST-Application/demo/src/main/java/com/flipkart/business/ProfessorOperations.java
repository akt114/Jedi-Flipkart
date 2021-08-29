package com.flipkart.business;

import com.flipkart.DAO.ProfessorDao;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

/*
 * @author JEDI-05
 * Implementation of Professor Operations
 *
 * */

public class ProfessorOperations implements ProfessorInterface{

	private static Logger logger = Logger.getLogger(UserOperations.class);


	/*
	 *
	 * Method to enrollToCourse
	 * @param professor
	 * @param courseId
	 *
	 * */
    @Override
    public void enrollToCourse(String professorId, String courseId) {

		logger.info("enrollToCourse()");
		logger.debug(professorId+" "+courseId);


    	try {
    		ProfessorDao.enrollToCourse(professorId, courseId);
    		System.out.println("Enrolled in course");
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }


	/*
	 *
	 * Method to addGrades
	 * @param professor
	 * @param studentId
	 * @param courseId
	 * @param grade
	 *
	 * */
    @Override
    public void addGrades(String professorId, String studentId, String courseId, int grade) {
		logger.info("addGrades()");
		logger.debug(professorId+" "+studentId + " " +courseId);

    	try {
    		ProfessorDao.addGrades(professorId, studentId, courseId, grade);
    		System.out.println("Grade added");
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }


	/*
	 *
	 * Method to view courses
	 *
	 * */
    @Override
    public List<Course> viewCourses() {
		logger.info("viewCourses()");

    	try {
    		return ProfessorDao.viewCourses();
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return null;
    }


	/*
	 *
	 * Method to viewEnrolledStudents
	 * @param courseId
	 *
	 * */
    @Override
    public  HashMap<String,String> viewEnrolledStudents(String courseId) {

		logger.info("viewEnrolledStudents()");
		logger.debug(courseId);

    	try {
    		return ProfessorDao.viewEnrolledStudents(courseId);
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return null;
    }


	/*
	 *
	 * Method to viewEnrolledCourses
	 * @param professor
	 *
	 * */
    @Override
    public List<Course> viewEnrolledCourses(String professorId){
		logger.info("viewEnrolledCourses()");
		logger.debug(professorId);

    	try {
    		return ProfessorDao.viewEnrolledCourses(professorId);
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return null;
    }
}
