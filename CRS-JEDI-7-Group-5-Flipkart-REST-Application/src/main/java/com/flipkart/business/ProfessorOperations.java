package com.flipkart.business;

import com.flipkart.DAO.ProfessorDAO;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.exceptions.InvalidCourseException;
import com.flipkart.exceptions.NoCoursesException;

import java.sql.SQLException;
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
    public void enrollToCourse(String professorId, String courseId) throws SQLException, InvalidCourseException {

		logger.info("enrollToCourse()");
		logger.debug(professorId+" "+courseId);
		ProfessorDAO.enrollToCourse(professorId, courseId);
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
    public void addGrades(String professorId, String studentId, String courseId, int grade) throws SQLException, NoCoursesException {
		logger.info("addGrades()");
		logger.debug(professorId+" "+studentId + " " +courseId);
		ProfessorDAO.addGrades(professorId, studentId, courseId, grade);
    }


	/*
	 *
	 * Method to view courses
	 *
	 * */
    @Override
    public List<Course> viewCourses() throws SQLException {
		logger.info("viewCourses()");
    	return ProfessorDAO.viewCourses();
    }


	/*
	 *
	 * Method to viewEnrolledStudents
	 * @param courseId
	 *
	 * */
    @Override
    public  HashMap<String,String> viewEnrolledStudents(String courseId) throws SQLException, InvalidCourseException {

		logger.info("viewEnrolledStudents()");
		logger.debug(courseId);
		return ProfessorDAO.viewEnrolledStudents(courseId);
    	
    }


	/*
	 *
	 * Method to viewEnrolledCourses
	 * @param professor
	 *
	 * */
    @Override
    public List<Course> viewEnrolledCourses(String professorId) throws SQLException{
		logger.info("viewEnrolledCourses()");
		logger.debug(professorId);
		return ProfessorDAO.viewEnrolledCourses(professorId);
    	
    }
}
