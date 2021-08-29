package com.flipkart.application;

import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.Professor;
import com.flipkart.business.ProfessorOperations;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEDI-05
 * This class will show the Professor Menu in console
 *
 */
public class ProfessorMenu {
    Scanner scanner = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(ProfessorMenu.class);
    ProfessorOperations professorOperations = new ProfessorOperations();
    /**
     * Method to show the menu
     * @param professor : corresponds to professor to which menu is shown
     * @param courseCatalog 
     */
    public void menu(Professor professor, CourseCatalog courseCatalog){
    	logger.info("menu()");
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
                professorOperations.enrollToCourse(professor, courseId);
            }else if(v == 2){
                System.out.println("Enter course Id : ");
                String courseId = scanner.next();
                System.out.println("Enter Student Id : ");
                String studentId = scanner.next();
                System.out.println("Enter Grade : ");
                int grade = scanner.nextInt();
                professorOperations.addGrades(professor, studentId, courseId, grade);
            }else if(v == 3){
                professorOperations.viewCourses();
            }else if(v == 4){
                System.out.println("Enter course Id : ");
                String courseId = scanner.next();
                professorOperations.viewEnrolledStudents(courseId);
            }else if(v == 5){
                professorOperations.viewEnrolledCourses(professor);
            }else{
                return;
            }
        }

    }




}
