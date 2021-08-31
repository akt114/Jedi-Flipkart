package com.dropwizard.business;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.dropwizard.bean.Course;
import com.dropwizard.bean.Professor;
import com.dropwizard.exceptions.InvalidCourseException;
import com.dropwizard.exceptions.NoCoursesException;


/*
 * @author JEDI-05
 * Interface for Professor Operations
 *
 * */

public interface ProfessorInterface {

    /*
     *
     * Method to enrollToCourse
     * @param professor
     * @param courseId
     *
     * */
    void enrollToCourse(String professorId, String courseId) throws SQLException, InvalidCourseException;

    /*
     *
     * Method to addGrades
     * @param professor
     * @param studentId
     * @param courseId
     * @param grade
     *
     * */
    void addGrades(String professorId, String studentId, String courseId, int grade) throws SQLException, NoCoursesException;

    /*
     *
     * Method to view courses
     *
     * */
    List<Course> viewCourses() throws SQLException;

    /*
     *
     * Method to viewEnrolledStudents
     * @param courseId
     *
     * */
    HashMap<String,String> viewEnrolledStudents(String courseId) throws SQLException, InvalidCourseException;

    /*
     *
     * Method to viewEnrolledCourses
     * @param professor
     *
     * */
    List<Course> viewEnrolledCourses(String professorId) throws SQLException;

}
