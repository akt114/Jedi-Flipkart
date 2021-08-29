package com.flipkart.business;

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
    void enrollToCourse(Professor professor, String couseId);

    /*
     *
     * Method to addGrades
     * @param professor
     * @param studentId
     * @param courseId
     * @param grade
     *
     * */
    void addGrades(Professor professor, String studentId, String courseId, int grade);

    /*
     *
     * Method to view courses
     *
     * */
    void viewCourses();

    /*
     *
     * Method to viewEnrolledStudents
     * @param courseId
     *
     * */
    void viewEnrolledStudents(String courseId);

    /*
     *
     * Method to viewEnrolledCourses
     * @param professor
     *
     * */
    void viewEnrolledCourses(Professor professor);

}
