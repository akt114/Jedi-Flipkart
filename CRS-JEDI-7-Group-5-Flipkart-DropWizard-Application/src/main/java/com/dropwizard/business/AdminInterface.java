package com.dropwizard.business;

import java.sql.SQLException;
import java.util.List;

import com.dropwizard.bean.Course;
import com.dropwizard.bean.Grade;
import com.dropwizard.bean.Professor;
import com.dropwizard.exceptions.DuplicateCourseException;
import com.dropwizard.exceptions.DuplicateProfessorException;
import com.dropwizard.exceptions.InvalidCourseException;
import com.dropwizard.exceptions.InvalidStudentException;
import com.dropwizard.exceptions.NoCoursesException;



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