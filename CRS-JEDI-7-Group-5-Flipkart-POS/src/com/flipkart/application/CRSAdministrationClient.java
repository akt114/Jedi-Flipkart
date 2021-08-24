package com.flipkart.application;

import com.flipkart.bean.*;

import java.util.*;

public class CRSAdministrationClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login creds");
        System.out.println("Username : ");
        String userName = scanner.next();
        System.out.println("Password : ");
        String password = scanner.next();

        // String id, String name, String department, String noOfStudents, boolean isAvailable, Professor instructor, List<Student> studentsEnrolled
        Course course1 = new Course("Course1", "Name1", "dep", 0, true, null, new ArrayList< Student>());
        Course course2 = new Course("Course2", "Name2", "dep", 0, true, null, new ArrayList< Student>());
        Course course3 = new Course("Course2", "Name3", "dep", 0, true, null, new ArrayList< Student>());


        // String name, String email, String id, String password, int branch, int semester, String department, GradeCard gradeCard
        Student student1 = new Student("stud1", "stud1@h.com", "id1", "pass", "br1", 6, "dep", new GradeCard(0, new ArrayList<>()));
        Student student2 = new Student("stud2", "stud1@h.com", "id2", "pass", "br1", 6, "dep", new GradeCard(0, new ArrayList<>()));
        Student student3 = new Student("stud3", "stud1@h.com", "id3", "pass", "br1", 6, "dep", new GradeCard(0, new ArrayList<>()));

        List<Student> studentList = course1.getStudentsEnrolled();
        studentList.add(student1);
        studentList.add(student2);
        course1.setStudentsEnrolled(studentList);

        Set list = new HashSet();
        list.add(course1);
        list.add(course2);
        list.add(course3);
        CourseCatalog courseCatalog = new CourseCatalog(list);

        Professor professor = new Professor("Prof1", "prof1@fl.com", "id1", "passwd", "dep", "des", new ArrayList<>());
        ProfessorMenu professorMenu = new ProfessorMenu();
        professorMenu.menu(professor, courseCatalog);
    }
}
