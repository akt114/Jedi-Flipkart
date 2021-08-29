package com.flipkart.bean;

import java.util.HashMap;

/**
 * 
 * @author JEDI-05
 * CourseCatalog Bean Class
 * 
 */
public class CourseCatalog {

    private HashMap<String,Course> availableCourses;

    /**
	 * 
	 * Method : CourseCatalog's Parameterized Constructor
	 * @param courses : HashMap of course and courseID
	 * 
	 */
    public CourseCatalog( HashMap<String,Course> courses) {
        this.availableCourses = courses;
    }

    /**
	 * 
	 * Method : CourseCatalog's default Constructor
	 * 
	 */
    public CourseCatalog() {

    }


    /**
	 * 
	 * Method to get Available Courses
	 * 
	 */
    public HashMap<String,Course> getAvailableCourses() {
        return availableCourses;
    }

    /**
	 * 
	 * Method to set Available Courses
	 * @param availableCourses : HashMap of course and courseID
	 * 
	 */
    public void setAvailableCourses( HashMap<String,Course> availableCourses) {
        this.availableCourses = availableCourses;
    }
}