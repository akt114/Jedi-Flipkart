package com.flipkart.business;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
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
    void registerForSemester(String studentId) throws StudentAlreadyRegisteredException;

    /*
     *
     * Method to pay Fee
     * @param student
     * @param paymentId
     * */
    Response payFee(String studentId, String paymentId) throws SQLException ;

    /*
     *
     * Method to view courses
     * */
    List<Course> viewCourses();

    /*
     *
     * Method to view GradeCard
     * @param student
     * @throws GradeNotAddedException
     * */
    HashMap<String, Integer> viewGradeCard(String studentId) throws GradeNotAddedException;

    /*
     *
     * Method to add courses
     * @param student
     * @param courseId
     * @throws CourseAlreadyExistException
     * @throws ExcessStudentsException
     * */
    void addCourse(String studentId, String courseId) throws CourseAlreadyExistException, ExcessStudentsException;

    /*
     *
     * Method drop Course
     * @param student
     * @param courseId
     * @throws CourseDoesNotExistException
     * */
    void dropCourse(String studentId, String courseId) throws CourseDoesNotExistException;

    /*
     *
     * Method preConditionCheck
     * @param student
     * */
    boolean preConditionCheck(String studentId);
}
