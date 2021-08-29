package com.flipkart.application;

import com.flipkart.DAO.ProfessorDao;
import com.flipkart.DAO.StudentDAOOperations;
import com.flipkart.bean.*;
import com.flipkart.business.StudentOperation;
import com.flipkart.business.UserOperations;
import org.apache.log4j.Logger;

import java.util.Scanner;
/**
 * 
 * @author JEDI-05
 * This class is used as the main entry point of the application
 * In main menu to login, register are displayed
 * 
 */
public class CRSAdministrationClient {
    static Scanner scanner = new Scanner(System.in);
    Database dummyData = new Database();
	private static Logger logger = Logger.getLogger(CRSAdministrationClient.class);

    /**
     * Main driver method
   	 * Method for connecting to Database
   	 * 
   	 * 
   	 */
    public static void main(String[] args) {

        // TODO Auto-generated method stub
    	logger.info("menu()");
    	Database.createDatabase();
        System.out.println("Welcome to Course Regestration System");
        System.out.println();
        System.out.println("*************************************");
        System.out.println();


        CRSAdministrationClient client = new CRSAdministrationClient();
        while(true){
            System.out.println("   Press 1 --- LOGIN");
            System.out.println("   Press 2 --- SignUp as a Student");
            System.out.println("   Press 3 --- EXIT");

            int choice = scanner.nextInt();

            if(choice == 1) {
                client.loginUser();
            }else if(choice == 2) {
                client.registerStudent();
            }else {
                return;
        	}
        }
//        Database.createDatabase();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter login creds");
//        System.out.println("Username : ");
//        String userName = scanner.next();
//        System.out.println("Password : ");
//        String password = scanner.next();
//
//        AdminMenu adminMenu=new AdminMenu();
//        adminMenu.menu();


//        System.out.println("Enter login creds");
//        System.out.println("Username : ");
//        String userName = scanner.next();
//        System.out.println("Password : ");
//        String password = scanner.next();
//
//        // String id, String name, String department, String noOfStudents, boolean isAvailable, Professor instructor, List<Student> studentsEnrolled
//        Course course1 = new Course("Course1", "Name1", "dep", 0, true, null, new ArrayList< Student>());
//        Course course2 = new Course("Course2", "Name2", "dep", 0, true, null, new ArrayList< Student>());
//        Course course3 = new Course("Course2", "Name3", "dep", 0, true, null, new ArrayList< Student>());
//
//
//        // String name, String email, String id, String password, int branch, int semester, String department, GradeCard gradeCard
//        Student student1 = new Student("stud1", "stud1@h.com", "id1", "pass", "br1", 6, "dep", new GradeCard(0, new ArrayList<>()));
//        Student student2 = new Student("stud2", "stud1@h.com", "id2", "pass", "br1", 6, "dep", new GradeCard(0, new ArrayList<>()));
//        Student student3 = new Student("stud3", "stud1@h.com", "id3", "pass", "br1", 6, "dep", new GradeCard(0, new ArrayList<>()));
//
//        List<Student> studentList = course1.getStudentsEnrolled();
//        studentList.add(student1);
//        studentList.add(student2);
//        course1.setStudentsEnrolled(studentList);
//
//        Set list = new HashSet();
//        list.aProfessor professor = new Professor("Tom","tom@gmail.com","p1","password","electronics","asst",null);dd(course1);
//        list.add(course2);
//        list.add(course3);
//        CourseCatalog courseCatalog = new CourseCatalog(list);
//
//        Professor professor = new Professor("Prof1", "prof1@fl.com", "id1", "passwd", "dep", "des", new ArrayList<>());
//        ProfessorMenu professorMenu = new ProfessorMenu();
//        professorMenu.menu(professor, courseCatalog);
    }
    /**
	 * Method for Login functionality
	 */
    public void loginUser() {
    	logger.info("loginUser()");
        System.out.print("Enter UserID : ");
        String userId = scanner.next();
        System.out.print("Enter Password : ");
        String password = scanner.next();
        System.out.print("Enter Role : ");
        String role = scanner.next();

        boolean isValidUser = new UserOperations().login(userId,password, role);
        if(isValidUser){
            if(role.equals("Student")){
                if(new UserOperations().approvalCheck(userId)){
                    StudentMenu studentMenu = new StudentMenu();
                    Student student = new StudentDAOOperations().getStudent(userId);
                    studentMenu.menu(student, new CourseCatalog());
                }else{
                    System.out.println("Student is not approved by Admin");
                }
            }
            else if(role.equals("Admin")) {
                AdminMenu adminMenu = new AdminMenu();
                Admin admin = new Admin();
                adminMenu.menu();
            }
            else {
                ProfessorMenu professorMenu = new ProfessorMenu();
                Professor professor = ProfessorDao.getProfessor(userId);
                professorMenu.menu(professor, new CourseCatalog());
            }
        }
        else {
            System.out.println("Incorrect Details");
            System.out.println("Please Try again");
            System.out.println();
            logger.debug("Incorrect details");
        }

        //System.out.println("Press 2 for Student Registration");
    }
    /**
	 * Method to help Student register themselves, pending admin approval
	 */
    public void registerStudent() {
    	logger.info("registerStudent()");
    	
        System.out.print("Enter Name : ");
        String name = scanner.next();
        System.out.print("Enter email : ");
        String email = scanner.next();
        System.out.print("Enter UserName : ");
        String id = scanner.next();
        System.out.print("Enter password : ");
        String password = scanner.next();
        System.out.print("Enter branch : ");
        String branch = scanner.next();
        System.out.print("Enter semester : ");
        int semester = scanner.nextInt();
        System.out.print("Enter department : ");
        String department = scanner.next();
        Student student = new Student(name,email,id,password,branch,semester,department,new GradeCard());
        StudentOperation operation = new StudentOperation();
        operation.signUp(student);
//        System.out.println("SignUp Successful");
        System.out.println();
    }
}
