package com.flipkart.application;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.business.AdminOperation;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author JEDI-05
 * Implementation of admin menu
 *
 */
public class AdminMenu {
	
	private static Logger logger = Logger.getLogger(AdminMenu.class);
    static Scanner scanner = new Scanner(System.in);
    AdminOperation adminOperation = new AdminOperation();
    /**
     * Menu method to show the menu to console
     */
    public void menu(){
    	logger.info("menu()");
        while(true){
            System.out.println("press 1 : Add Course");
            System.out.println("press 2 : Delete Course");
            System.out.println("press 3 : Approve Student");
            System.out.println("press 4 : Add Professor");
            System.out.println("press 5 : Generate Report Card");
            System.out.println("press 6 : Logout");
            int v = scanner.nextInt();
            if(v == 1){
                System.out.println("Enter course Id : ");
                String courseId = scanner.next();
                System.out.println("Enter course name : ");
                String courseName = scanner.next();
                System.out.println("Enter department : ");
                String department = scanner.next();
                adminOperation.addCourse(courseId, courseName, department);
            }else if(v == 2){
                System.out.println("Enter course Id : ");
                String courseId = scanner.next();
                adminOperation.dropCourse(courseId);
            }else if(v == 3){
                System.out.println("Enter student Id : ");
                String studentId = scanner.next();
                adminOperation.approveStudent(studentId);;
            }else if(v == 4){
            	
                System.out.println("Enter professor Id : ");
                String professorId = scanner.next();
                System.out.println("Enter professor first name : ");
                String firstName = scanner.next();
                System.out.println("Enter professor last name : ");
                String lastName = scanner.next();
                System.out.println("Enter professor department : ");
                String department = scanner.next();
                System.out.println("Enter professor designation : ");
                String designation = scanner.next();
                adminOperation.addProfessor(new Professor(firstName+" "+lastName,firstName+"."+lastName+"@gmail.com",professorId,firstName+"123",department,designation,new ArrayList<Course>()));
            }else if(v == 5){
                System.out.println("Enter student Id : ");
                String studentId = scanner.next();
                adminOperation.generateReportCard(studentId);
            }else{
                return;
            }
        }

    }
}