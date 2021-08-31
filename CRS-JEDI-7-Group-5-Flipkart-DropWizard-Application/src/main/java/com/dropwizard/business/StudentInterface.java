package com.dropwizard.business;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Response;

import com.dropwizard.bean.Course;
import com.dropwizard.bean.Student;
import com.dropwizard.exceptions.*;




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
    void registerForSemester(String studentId) throws StudentAlreadyRegisteredException, InvalidStudentException;

    /*
     *
     * Method to pay Fee
     * @param student
     * @param paymentId
     * */
    Response payFee(String studentId, String paymentId) throws SQLException, InvalidCourseException, PreConditionException ;

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
    HashMap<String, Integer> viewGradeCard(String studentId) throws GradeNotAddedException, SQLException, InvalidStudentException;

    /*
     *
     * Method to add courses
     * @param student
     * @param courseId
     * @throws CourseAlreadyExistException
     * @throws ExcessStudentsException
     * */
    void addCourse(String studentId, String courseId) throws CourseAlreadyExistException, ExcessStudentsException, SQLException, InvalidCourseException;

    /*
     *
     * Method drop Course
     * @param student
     * @param courseId
     * @throws CourseDoesNotExistException
     * */
    void dropCourse(String studentId, String courseId) throws CourseDoesNotExistException, InvalidCourseException, SQLException;

    /*
     *
     * Method preConditionCheck
     * @param student
     * */
    String preConditionCheck(String studentId) throws InvalidCourseException, SQLException;
}
