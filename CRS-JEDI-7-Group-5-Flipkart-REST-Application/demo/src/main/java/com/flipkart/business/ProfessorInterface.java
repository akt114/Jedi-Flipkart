package com.flipkart.business;

import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;


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
    void enrollToCourse(String professorId, String courseId);

    /*
     *
     * Method to addGrades
     * @param professor
     * @param studentId
     * @param courseId
     * @param grade
     *
     * */
    void addGrades(String professorId, String studentId, String courseId, int grade);

    /*
     *
     * Method to view courses
     *
     * */
    List<Course> viewCourses();

    /*
     *
     * Method to viewEnrolledStudents
     * @param courseId
     *
     * */
    HashMap<String,String> viewEnrolledStudents(String courseId);

    /*
     *
     * Method to viewEnrolledCourses
     * @param professor
     *
     * */
    List<Course> viewEnrolledCourses(String professorId);

}
