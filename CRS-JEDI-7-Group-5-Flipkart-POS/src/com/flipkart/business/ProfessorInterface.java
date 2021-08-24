package com.flipkart.business;

import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.Professor;

public interface ProfessorInterface {
    void enrollToCourse(Professor professor, String couseId, CourseCatalog courseCatalog);
    void addGrades(Professor professor, String studentId, String courseId, int grade);
    void viewCourses(CourseCatalog courseCatalog);
    void viewEnrolledStudents(Professor professor, String courseId);
    void viewEnrolledCourses(Professor professor);

}
