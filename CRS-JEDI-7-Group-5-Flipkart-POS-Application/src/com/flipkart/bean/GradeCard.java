package com.flipkart.bean;

import java.util.List;


/**
 * 
 * @author JEDI-05
 * GradeCard Bean Class
 * 
 */
public class GradeCard {

    private float cgpa;
    private List<Grade> grades;

    /**
	 * 
	 * Method : GradeCard's default Constructor
	 * 
	 */
    public GradeCard(){}

    /**
	 * 
	 * Method : GradeCard's Parameterized Constructor
	 * @param cgpa
	 * @param grades : list of grades
	 * 
	 */
    public GradeCard(float cgpa, List<Grade> grades) {
        this.cgpa = cgpa;
        this.grades = grades;
    }

    /**
	 * 
	 * Method to get Cgpa
	 * 
	 */
    public float getCgpa() {
        return cgpa;
    }

    /**
	 * 
	 * Method to set Cgpa
	 * @param cgpa
	 * 
	 */
    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    /**
	 * 
	 * Method to get Grades
	 * 
	 */
    public List<Grade> getGrades() {
        return grades;
    }

    /**
	 * 
	 * Method to set Grades
	 * @param grades : list of grades
	 * 
	 */
    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
