package com.flipkart.business;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.exceptions.DuplicateCourseException;
import com.flipkart.exceptions.DuplicateProfessorException;
import com.flipkart.exceptions.InvalidCourseException;
import com.flipkart.exceptions.InvalidStudentException;
import com.flipkart.exceptions.NoCoursesException;



/*
 *@author JEDI-05
 * Interface of Admin Operations
 *
 * */
public interface AdminInterface {

    /*
     *
     * Method to generateReportCard
     * @param studentId
     *
     * */
	 List<Grade> generateReportCard(String studentId) throws SQLException, NoCoursesException;

    /*
     *
     * Method to addCourse
     * @param courseId
     * @param courseName
     * @param department
     *
     * */
    void addCourse(Course course) throws DuplicateCourseException, SQLException;


    /*
     *
     * Method to dropCourse
     * @param courseId
     *
     * */
    void dropCourse(String courseId) throws SQLException, InvalidCourseException;


    /*
     *
     * Method to approveStudent
     * @param studentId
     *
     * */
    void approveStudent(String studentId) throws SQLException, InvalidStudentException;


    /*
     *
     * Method to addProfessor
     * @param professor
     *
     * */
    void addProfessor(Professor professor) throws SQLException, DuplicateProfessorException;
}