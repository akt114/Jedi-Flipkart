package com.dropwizard.business;

import com.dropwizard.DAO.AdminDAO;
import com.dropwizard.bean.Course;
import com.dropwizard.bean.Grade;
import com.dropwizard.bean.Professor;
import com.dropwizard.exceptions.DuplicateCourseException;
import com.dropwizard.exceptions.DuplicateProfessorException;
import com.dropwizard.exceptions.InvalidCourseException;
import com.dropwizard.exceptions.InvalidStudentException;
import com.dropwizard.exceptions.NoCoursesException;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;


/*
 *@author JEDI-05
 * Implementation of Admin Operations
 *
 * */
public class AdminOperation implements AdminInterface {

	private static Logger logger = Logger.getLogger(UserOperations.class);

	/*
	 *
	 * Method to generateReportCard
	 * @param studentId
	 *
	 * */
	public  List<Grade> generateReportCard(String studentId) throws SQLException, NoCoursesException {
        // TODO Auto-generated method stub

    	
    		
    		return AdminDAO.getGrades(studentId);
    	
    }


	/*
	 *
	 * Method to addCourse
	 * @param courseId
	 * @param courseName
	 * @param department
	 *
	 * */
    public void addCourse(Course course) throws DuplicateCourseException, SQLException  {
        // TODO Auto-generated method stub
    	
    		AdminDAO.addCourse(course);
    }


	/*
	 *
	 * Method to dropCourse
	 * @param courseId
	 *
	 * */
    
    public void dropCourse(String courseId) throws SQLException, InvalidCourseException {
        // TODO Auto-generated method stub    	
    	
    		AdminDAO.deleteCourse(courseId);
    	
    }

	/*
	 *
	 * Method to approveStudent
	 * @param studentId
	 *
	 * */
    
    public void approveStudent(String studentId) throws SQLException, InvalidStudentException {
        // TODO Auto-generated method stub    	
    	
    		AdminDAO.approveStudent(studentId);
    	
    }


	/*
	 *
	 * Method to addProfessor
	 * @param professor
	 *
	 * */
    
    public void addProfessor(Professor professor) throws SQLException, DuplicateProfessorException {
        // TODO Auto-generated method stub
    	
    		AdminDAO.addProfessor(professor);
    	
    	
    }

}