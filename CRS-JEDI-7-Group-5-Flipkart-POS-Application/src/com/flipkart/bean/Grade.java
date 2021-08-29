package com.flipkart.bean;


/**
 * 
 * @author JEDI-05
 * Grade Bean Class
 * 
 */
public class Grade {
    private String courseId;
    private int courseGrade;

    /**
	 * 
	 * Method : Grade's Parameterized Constructor
	 * @param course
	 * @param courseGrade 
	 * 
	 */
    public Grade(String course, int courseGrade) {
        this.courseId = course;
        this.courseGrade = courseGrade;
    }

    /**
	 * 
	 * Method : Grade's default Constructor
	 * 
	 */
    public Grade(){}

    /**
	 * 
	 * Method to get CourseId
	 * 
	 */
    public String getCourseId() {
        return courseId;
    }

    /**
	 * 
	 * Method to set CourseId
	 * @param course
	 * 
	 */
    public void setCourseId(String course) {
        this.courseId = course;
    }

    /**
	 * 
	 * Method to get Course Grade
	 * 
	 */
    public int getCourseGrade() {
        return courseGrade;
    }

    /**
	 * 
	 * Method to set Course Grade
	 * @param courseGrade
	 * 
	 */
    public void setCourseGrade(int courseGrade) {
        this.courseGrade = courseGrade;
    }
}
