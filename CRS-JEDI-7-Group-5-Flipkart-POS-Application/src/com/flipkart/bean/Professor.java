package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author JEDI-05
 * Professor Bean Class
 * 
 */
public class Professor extends User{
    private String department;
    private String designation;
    private List<Course> coursesTeaching;

    /**
	 * 
	 * Method : Professor's Parameterized Constructor with super class parameters
	 * @param name
	 * @param email
	 * @param id
	 * @param password
	 * @param department
	 * @param designation
	 * @param coursesTeaching : list of courses teaching
	 * 
	 */
    public Professor(String name, String email, String id, String password, String department, String designation, List<Course> coursesTeaching) {
        super(name, email, id, password);
        this.department = department;
        this.designation = designation;
        this.coursesTeaching = coursesTeaching;
    }

    /**
	 * 
	 * Method : Professor's Parameterized Constructor
	 * @param department
	 * @param designation
	 * @param coursesTeaching : list of courses teaching
	 * 
	 */
    public Professor(String department, String designation, List<Course> coursesTeaching) {
        this.department = department;
        this.designation = designation;
        this.coursesTeaching = coursesTeaching;
    }

    /**
	 * 
	 * Method : Professor's Default Constructor
	 * 
	 */
    public Professor() {
    }

    /**
	 * 
	 * Method to get Department
	 * 
	 */
    public String getDepartment() {
        return department;
    }

    /**
	 * 
	 * Method to set Department
	 * @param department
	 * 
	 */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
	 * 
	 * Method to get Designation
	 * 
	 */
    public String getDesignation() {
        return designation;
    }

    /**
	 * 
	 * Method to set Designation
	 * @param designation
	 * 
	 */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
	 * 
	 * Method to get Courses Teaching
	 * 
	 */
    public List<Course> getCoursesTeaching() {
        return coursesTeaching;
    }

    /**
	 * 
	 * Method to set Courses Teaching
	 * @param coursesTeaching
	 * 
	 */
    public void setCoursesTeaching(List<Course> coursesTeaching) {
        this.coursesTeaching = coursesTeaching;
    }
}
