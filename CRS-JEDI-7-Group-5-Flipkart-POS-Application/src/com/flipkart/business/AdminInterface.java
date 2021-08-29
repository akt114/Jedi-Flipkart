package com.flipkart.business;

import com.flipkart.bean.Professor;



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
    void generateReportCard(String studentId);

    /*
     *
     * Method to addCourse
     * @param courseId
     * @param courseName
     * @param department
     *
     * */
    void addCourse(String courseId,String courseName,String department);


    /*
     *
     * Method to dropCourse
     * @param courseId
     *
     * */
    void dropCourse(String courseId);


    /*
     *
     * Method to approveStudent
     * @param studentId
     *
     * */
    void approveStudent(String studentId);


    /*
     *
     * Method to addProfessor
     * @param professor
     *
     * */
    void addProfessor(Professor professor);
}