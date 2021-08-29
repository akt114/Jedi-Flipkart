package com.flipkart.business;

import com.flipkart.DAO.AdminDao;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;

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
    public  List<Grade> generateReportCard(String studentId) {
        // TODO Auto-generated method stub

    	try {
    		
    		return AdminDao.getGrades(studentId);
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return null;
    	
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
    public void addCourse(Course course){
        // TODO Auto-generated method stub
    	try {
    		AdminDao.addCourse(course);
    		System.out.println("Course added succesfully");
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }


	/*
	 *
	 * Method to dropCourse
	 * @param courseId
	 *
	 * */
    @Override
    public void dropCourse(String courseId) {
        // TODO Auto-generated method stub    	
    	try {
    		AdminDao.deleteCourse(courseId);
    		System.out.println("Course deleted successfully");
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

	/*
	 *
	 * Method to approveStudent
	 * @param studentId
	 *
	 * */
    @Override
    public void approveStudent(String studentId) {
        // TODO Auto-generated method stub    	
    	try {
    		AdminDao.approveStudent(studentId);
    		System.out.println("Student approved!");
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }


	/*
	 *
	 * Method to addProfessor
	 * @param professor
	 *
	 * */
    @Override
    public void addProfessor(Professor professor) {
        // TODO Auto-generated method stub
    	try {
    		AdminDao.addProfessor(professor);
    		System.out.println("Professor added succesfully");
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    }

}