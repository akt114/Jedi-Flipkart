package com.flipkart.application;

import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.Professor;
import com.flipkart.business.ProfessorOperations;

import java.util.Scanner;

public class ProfessorMenu {
    Scanner scanner = new Scanner(System.in);
    ProfessorOperations professorOperations = new ProfessorOperations();
    public void menu(Professor professor, CourseCatalog courseCatalog){
        while(true){
            System.out.println("press 1 : enrollToCourse");
            System.out.println("press 2 : addGrades");
            System.out.println("press 3 : viewCourses");
            System.out.println("press 4 : viewEnrolledStudents");
            System.out.println("press 5 : viewEnrolledCourses");
            System.out.println("press 6 : Logout");
            int v = scanner.nextInt();
            if(v == 1){
                System.out.println("Enter course Id : ");
                String courseId = scanner.next();
                professorOperations.enrollToCourse(professor, courseId, courseCatalog);
            }else if(v == 2){
                System.out.println("Enter course Id : ");
                String courseId = scanner.next();
                System.out.println("Enter Student Id : ");
                String studentId = scanner.next();
                System.out.println("Enter Grade : ");
                int grade = scanner.nextInt();
                professorOperations.addGrades(professor, studentId, courseId, grade);
            }else if(v == 3){
                professorOperations.viewCourses(courseCatalog);
            }else if(v == 4){
                System.out.println("Enter course Id : ");
                String courseId = scanner.next();
                professorOperations.viewEnrolledStudents(professor, courseId);
            }else if(v == 5){
                professorOperations.viewEnrolledCourses(professor);
            }else{
                return;
            }
        }

    }




}
