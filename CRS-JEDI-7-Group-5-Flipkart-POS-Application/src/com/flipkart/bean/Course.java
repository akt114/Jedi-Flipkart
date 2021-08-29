package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author JEDI-05
 * Course Bean Class
 * 
 */
public class Course {
    private String id;
    private String name;
    private String department;
    private boolean isAvailable;
    private Professor instructor;
    private List<Student> studentsEnrolled;

    /**
	 * 
	 * Method : Course's Parameterized Constructor with super class parameters
	 * @param id
	 * @param name
	 * @param department
	 * @param isAvailable
	 * @param instructor
	 * @param studentsEnrolled : List of students enrolled
	 * 
	 */
    public Course(String id, String name, String department, boolean isAvailable, Professor instructor, List<Student> studentsEnrolled) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.isAvailable = isAvailable;
        this.instructor = instructor;
        this.studentsEnrolled = studentsEnrolled;
    }

    /**
	 * 
	 * Method : Course's Parameterized Constructor with super class parameters
	 * @param id
	 * @param name
	 * @param department
	 * @param isAvailable
	 * @param instructor
	 * 
	 */
    public Course(String id, String name, String department, boolean isAvailable, Professor instructor) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.isAvailable = isAvailable;
        this.instructor = instructor;
        this.studentsEnrolled = new ArrayList<>();
    }

    /**
	 * 
	 * Method : Course's Parameterized Constructor
	 * @param id
	 * @param name
	 * @param department
	 * 
	 */
    public Course(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.isAvailable = true;
        this.instructor = null;
        this.studentsEnrolled = new ArrayList<>();
    }

    /**
	 * 
	 * Method : Course's Default Constructor
	 * 
	 */
    public Course() {
    }

    /**
	 * 
	 * Method to get Id
	 * 
	 */
    public String getId() {
        return id;
    }

    /**
	 * 
	 * Method to set Id
	 * @param Id
	 * 
	 */
    public void setId(String id) {
        this.id = id;
    }

    /**
	 * 
	 * Method to get Name
	 * 
	 */
    public String getName() {
        return name;
    }

    /**
	 * 
	 * Method to set Name
	 * @param name
	 * 
	 */
    public void setName(String name) {
        this.name = name;
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
	 * Method to check if course is Available
	 * 
	 */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
	 * 
	 * Method to set availability status
	 * @param available
	 * 
	 */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
	 * 
	 * Method to get Instructor
	 * 
	 */
    public Professor getInstructor() {
        return instructor;
    }

    /**
	 * 
	 * Method to set Instructor
	 * @param instructor
	 * 
	 */
    public void setInstructor(Professor instructor) {
        this.instructor = instructor;
    }

    /**
	 * 
	 * Method to get list of get Students Enrolled
	 * 
	 */
    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    /**
	 * 
	 * Method to set Students Enrolled
	 * @param studentsEnrolled
	 * 
	 */
    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }
}
