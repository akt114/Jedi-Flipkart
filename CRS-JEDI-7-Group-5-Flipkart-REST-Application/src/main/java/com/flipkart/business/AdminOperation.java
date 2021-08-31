package com.flipkart.business;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.exceptions.DuplicateCourseException;
import com.flipkart.exceptions.DuplicateProfessorException;
import com.flipkart.exceptions.InvalidCourseException;
import com.flipkart.exceptions.InvalidStudentException;
import com.flipkart.exceptions.NoCoursesException;

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
	@Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public void addProfessor(Professor professor) throws SQLException, DuplicateProfessorException {
        // TODO Auto-generated method stub
    	
    		AdminDAO.addProfessor(professor);
    	
    	
    }

}