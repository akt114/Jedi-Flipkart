package com.flipkart.business;

import com.flipkart.DAO.ProfessorDao;
import com.flipkart.bean.Professor;
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
    public void enrollToCourse(Professor professor, String courseId) {

		logger.info("enrollToCourse()");
		logger.debug(professor.getName()+" "+professor.getId()+" "+courseId);


    	try {
    		ProfessorDao.enrollToCourse(professor, courseId);
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
    public void addGrades(Professor professor, String studentId, String courseId, int grade) {
		logger.info("addGrades()");
		logger.debug(professor.getName()+" "+professor.getId()+" "+studentId + " " +courseId);

    	try {
    		ProfessorDao.addGrades(professor, studentId, courseId, grade);
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
    public void viewCourses() {
		logger.info("viewCourses()");

    	try {
    		ProfessorDao.viewCourses();
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }


	/*
	 *
	 * Method to viewEnrolledStudents
	 * @param courseId
	 *
	 * */
    @Override
    public void viewEnrolledStudents(String courseId) {

		logger.info("viewEnrolledStudents()");
		logger.debug(courseId);

    	try {
    		ProfessorDao.viewEnrolledStudents(courseId);
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }


	/*
	 *
	 * Method to viewEnrolledCourses
	 * @param professor
	 *
	 * */
    @Override
    public void viewEnrolledCourses(Professor professor){
		logger.info("viewEnrolledCourses()");
		logger.debug(professor.getName()+" "+professor.getId());

    	try {
    		ProfessorDao.viewEnrolledCourses(professor);
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
}
