package com.example.myjavafx.java16.ConsoleMenu;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;

import java.util.Scanner;

// The Line of code below shows the implementation of object-oriented programming where the Welcome class is
// inheriting from the Database connection class.
// Here it is acceptable to do this because it is not breaking the SOLID principle , to be more precise the LisKov Principles hence the parent class has only one method and that
// the method we need .
public class Welcome extends DataBaseConnection {
    // Below is an implementation of the Liskov Principle "States that Subtypes should replaceable by their base types"
    // by the use of Refactoring through the use of composition guided by the Liskov principle,
    // it allows the program to only select the methods needed and not forcefully inheriting the methods from the parent class even if they are not needed.

    public static Scanner scanner = new Scanner(System.in);
    public Welcome(){


    }
    public  void welcomeScreen() throws Exception {
        Login log = new Login();
        System.out.println("==================================    WELCOME TO THE STUDENT INFOMATION SYSTEM (SIS).  =============================================");
        System.out.println("========================================= APPLICATION OF THE CRUD FUNCTIONS ========================================================");
        System.out.println("====================================================================================================================================\n");
        System.out.println("==========================================            LOGIN          ===============================================================");
        log.login();

    }

    public void displayWelcomeAdmin() throws Exception {
        //Welcome welcome = new Welcome();
        getDatabaseConnection();
        System.out.println("==================================    WELCOME TO THE STUDENT INFOMATION SYSTEM (SIS).  =============================================");
        System.out.println("========================================= APPLICATION OF THE CRUD FUNCTIONS ========================================================");
        System.out.println("====================================================================================================================================\n");
        System.out.println("                                           ENTER--->  1 to Show   Admin                      ");
        System.out.println("                                           ENTER--->  2 to Add    Admin                      ");
        System.out.println("                                           ENTER--->  3 to Delete Admin                      ");
        System.out.println("                                           ENTER--->  4 to update Admin                      ");
        System.out.println("                                           ENTER--->  5 to Search Admin                      ");
        System.out.println("                                           ENTER---> -1 to exit   program                    ");
        System.out.println("====================================================================================================================================\n");
        AdminChoices adminChoices = new AdminChoices();
        adminChoices.AdminChoice();
    }


    public void displayWelcomeStudent() throws Exception {
        getDatabaseConnection();

        System.out.println("==================================    WELCOME TO THE STUDENT INFOMATION SYSTEM (SIS).  =============================================");
        System.out.println("========================================= APPLICATION OF THE CRUD FUNCTIONS ========================================================");
        System.out.println("====================================================================================================================================\n");
        System.out.println("                                           ENTER--->  1  to Show   Student");
        System.out.println("                                           ENTER--->  2  to Add    Student");
        System.out.println("                                           ENTER--->  3  to Delete Student");
        System.out.println("                                           ENTER--->  4  to update Student");
        System.out.println("                                           ENTER--->  5  to Search Student");
        System.out.println("                                           ENTER---> -1  to exit   program");
        System.out.println("====================================================================================================================================\n");

        StudentChoice studentChoice = new StudentChoice();
        studentChoice.studentChoice();
    }

    public void displayWelcomeDepartments() throws Exception {
        getDatabaseConnection();

        System.out.println("==================================    WELCOME TO THE STUDENT INFOMATION SYSTEM (SIS).  =============================================");
        System.out.println("========================================= APPLICATION OF THE CRUD FUNCTIONS ========================================================");
        System.out.println("====================================================================================================================================\n");
        System.out.println("                      SELECT THE DEPARTMENT NUMBER TO SEE ITs LIST OF STUDENTS BELONGING TO THAT DEPARTMENT ");
        System.out.println("                                    ENTER--->  1  to Show   Student's IN LONDON    DEPARTMENT");
        System.out.println("                                    ENTER--->  2  to Show   Student's IN Harrow    DEPARTMENT");
        System.out.println("                                    ENTER--->  3  to Show   Student's IN Wembley   DEPARTMENT");
        System.out.println("                                    ENTER--->  4  to Show   Student's IN Kingsbury DEPARTMENT");
        System.out.println("                                    ENTER--->  5  to Show   Student's IN Southall  DEPARTMENT");
        System.out.println("                                    ENTER---> -1  to exit   program");
        System.out.println("====================================================================================================================================\n");

        DepartmentChoices departmentChoices = new DepartmentChoices();
        departmentChoices.DepartmentChoice();
    }

    public void displayWelcomeCourses() throws Exception {
        getDatabaseConnection();

        System.out.println("==================================    WELCOME TO THE STUDENT INFOMATION SYSTEM (SIS).  =============================================");
        System.out.println("========================================= APPLICATION OF THE CRUD FUNCTIONS ========================================================");
        System.out.println("====================================================================================================================================\n");
        System.out.println("                      SELECT THE COURSE NUMBER TO SEE ITs LIST OF STUDENTS ENROLLED TO THAT COURSE ");
        System.out.println("                                    ENTER--->  1  to Show   Student's ENROLLED TO  Software Engineering COURSE");
        System.out.println("                                    ENTER--->  2  to Show   Student's ENROLLED TO  Computing and AI COURSE");
        System.out.println("                                    ENTER--->  3  to Show   Student's ENROLLED TO  Business and enterprise  COURSE");
        System.out.println("                                    ENTER--->  4  to Show   Student's ENROLLED TO  Allied Health COURSE");
        System.out.println("                                    ENTER---> -1  to exit   program");
        System.out.println("====================================================================================================================================\n");

        CourseChoices courseChoices = new CourseChoices();
        courseChoices.CourseChoice();
    }


}
