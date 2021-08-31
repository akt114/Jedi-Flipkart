package com.dropwizard.bean;

public class Grade {
    private String courseId;
    private int courseGrade;

    public Grade(String course, int courseGrade) {
        this.courseId = course;
        this.courseGrade = courseGrade;
    }

    public Grade(){}

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String course) {
        this.courseId = course;
    }

    public int getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(int courseGrade) {
        this.courseGrade = courseGrade;
    }
}
