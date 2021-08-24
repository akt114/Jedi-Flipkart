package com.flipkart.business;

import com.flipkart.bean.*;

import java.util.List;

/*
* @author JEDI-05
*  Business class
* */

public class ProfessorOperations implements ProfessorInterface{

    /*
    *
    *
    * */
    @Override
    public void enrollToCourse(Professor professor, String courseId, CourseCatalog courseCatalog) {
        for(Course course : courseCatalog.getAvailableCourses()){
            if(course.getId().equals(courseId) && course.isAvailable()){
                List<Course> list = professor.getCoursesTeaching();
                course.setInstructor(professor);
                list.add(course);
                professor.setCoursesTeaching(list);
                System.out.println("Enrolled to course");
                return;
            }
        }
    }

    @Override
    public void addGrades(Professor professor, String studentId, String courseId, int grade) {
        Grade grade1 = new Grade(courseId, grade);
        for(Course course : professor.getCoursesTeaching()){
            if(course.getId().equals(courseId)){
                for(Student student : course.getStudentsEnrolled()){
                    if(student.getId().equals(studentId)){
                        GradeCard gradeCard = student.getGradeCard();
                        List<Grade> list = gradeCard.getGrades();
                        list.add(grade1);
                        gradeCard.setGrades(list);
                        student.setGradeCard(gradeCard);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void viewCourses(CourseCatalog courseCatalog) {
        for(Course course : courseCatalog.getAvailableCourses()){
            System.out.println("Course name : " + course.getName() + ", course Id : " + course.getId());
        }
    }

    @Override
    public void viewEnrolledStudents(Professor professor, String courseId) {
        for(Course course : professor.getCoursesTeaching()){
            if(course.getId().equals(courseId)){
                for(Student student : course.getStudentsEnrolled()){
                    System.out.println("Student Name : " + student.getName() + ", student Id : " + student.getId());
                }
                return;
            }
        }
    }

    @Override
    public void viewEnrolledCourses(Professor professor){
        for(Course course : professor.getCoursesTeaching()){
            System.out.println("Course Name : " + course.getName() + ", CourseId : " + course.getId());
        }
    }
}
