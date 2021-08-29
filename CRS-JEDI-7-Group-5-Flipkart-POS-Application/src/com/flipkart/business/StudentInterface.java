package com.flipkart.business;

import com.flipkart.bean.Student;
import com.flipkart.exceptions.*;



/*
 *
 * @author JEDI-05
 * Interface of Student Operations
 *
 * */

public interface StudentInterface {

    /*
     *
     * Method register for semester
     * @param student
     * @throws StudentAlreadyRegisteredException
     * */
    void registerForSemester(Student student) throws StudentAlreadyRegisteredException;

    /*
     *
     * Method to pay Fee
     * @param student
     * @param paymentId
     * */
    void payFee(Student student, String  paymentId) ;

    /*
     *
     * Method to view courses
     * */
    void viewCourses();

    /*
     *
     * Method to view GradeCard
     * @param student
     * @throws GradeNotAddedException
     * */
    void viewGradeCard(Student student) throws GradeNotAddedException;

    /*
     *
     * Method to add courses
     * @param student
     * @param courseId
     * @throws CourseAlreadyExistException
     * @throws ExcessStudentsException
     * */
    void addCourse(Student student, String courseId) throws CourseAlreadyExistException, ExcessStudentsException;

    /*
     *
     * Method drop Course
     * @param student
     * @param courseId
     * @throws CourseDoesNotExistException
     * */
    void dropCourse(Student student, String courseId) throws CourseDoesNotExistException;

    /*
     *
     * Method preConditionCheck
     * @param student
     * */
    boolean preConditionCheck(Student student);
}
