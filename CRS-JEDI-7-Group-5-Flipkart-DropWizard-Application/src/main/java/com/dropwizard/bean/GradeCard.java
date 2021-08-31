package com.dropwizard.bean;

import java.util.List;

public class GradeCard {

    private float cgpa;
    private List<Grade> grades;

    public GradeCard(){}

    public GradeCard(float cgpa, List<Grade> grades) {
        this.cgpa = cgpa;
        this.grades = grades;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
