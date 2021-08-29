package com.flipkart.bean;

import java.util.List;


/**
 * 
 * @author JEDI-05
 * RegisteredCourses Bean Class
 * 
 */
public class RegisteredCourses {

    private List<Course> primaryCourses;
    private List<Course> secondaryCourses;
    private List<Course> registeredCourses;

    /**
	 * 
	 * Method : RegisteredCourses's Parameterized Constructor
	 * @param primaryCourses
	 * @param secondaryCourses
	 * @param registeredCourses
	 * 
	 */
    public RegisteredCourses(List<Course> primaryCourses, List<Course> secondaryCourses, List<Course> registeredCourses) {
        this.primaryCourses = primaryCourses;
        this.secondaryCourses = secondaryCourses;
        this.registeredCourses = registeredCourses;
    }

    /**
	 * 
	 * Method : RegisteredCourses's Default Constructor
	 * 
	 */
    public RegisteredCourses(){}

    /**
	 * 
	 * Method to get Primary Courses
	 * 
	 */
    public List<Course> getPrimaryCourses() {
        return primaryCourses;
    }

    /**
	 * 
	 * Method to set Primary Courses
	 * @param primaryCourses
	 * 
	 */
    public void setPrimaryCourses(List<Course> primaryCourses) {
        this.primaryCourses = primaryCourses;
    }

    /**
	 * 
	 * Method to get Secondary Courses
	 * 
	 */
    public List<Course> getSecondaryCourses() {
        return secondaryCourses;
    }

    /**
	 * 
	 * Method to set Secondary Courses
	 * @param secondaryCourses
	 * 
	 */
    public void setSecondaryCourses(List<Course> secondaryCourses) {
        this.secondaryCourses = secondaryCourses;
    }

    /**
	 * 
	 * Method to get Registered Courses
	 * 
	 */
    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    /**
	 * 
	 * Method to set Registered Courses
	 * @param registeredCourses
	 * 
	 */
    public void setRegisteredCourses(List<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }
}
