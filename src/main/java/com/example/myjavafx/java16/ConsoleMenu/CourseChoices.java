package com.example.myjavafx.java16.ConsoleMenu;


import com.example.myjavafx.java16.Course.*;
import com.example.myjavafx.java16.DataBase.DataBaseConnection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseChoices extends DataBaseConnection {

    public static Scanner scanner = new Scanner(System.in);

    protected Course course;
    protected ShowCourses showCourses;
    protected AddCourse addCourse;
    protected SearchCourse searchCourse;
    protected DeleteCourse deleteCourse;
    protected UpdateCourse updateCourse;

    public CourseChoices() {
        this.addCourse = new AddCourse();
        this.deleteCourse = new DeleteCourse();
        this.searchCourse = new SearchCourse();
        this.updateCourse = new UpdateCourse();
        this.showCourses = new ShowCourses();
    }


    public void getCourseByID(int choice) throws SQLException {

        getDatabaseConnection();
        System.out.println("Database Link = " + databaseLink);
        System.out.println("************************************************************************************************\n");
        String sql_query = """
                    SELECT s.*, c.CourseNames, c.CoursesID
                                          FROM sis.student s
                                          JOIN sis.courses c ON s.CoursesID = c.CoursesID
                                          WHERE s.CoursesID = ?;
                """;
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);
        statement.setInt(1, choice);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String studentID = resultSet.getString("StudentID");
            String studentFirstName = resultSet.getString("FirstName");
            String studentLastName = resultSet.getString("LastName");
            String studentEmail = resultSet.getString("Email");
            String CourseName = resultSet.getString("CourseNames");
            String CourseId = resultSet.getString("CoursesID");

            System.out.println("Student ID = " + studentID);
            System.out.println("Student First Name = " + studentFirstName);
            System.out.println("Student Last Name = " + studentLastName);
            System.out.println("Student Email = " + studentEmail);
            System.out.println("Course ID = " + CourseId);
            System.out.println("Course Name = " + CourseName);
            System.out.println("************************************************************************************************\n");

        }

        statement.close();
        resultSet.close();


    }

    public void CourseChoice() throws SQLException {
        getDatabaseConnection();
        //DatabaseCourseCRUDFunction dbcf = new DatabaseCourseCRUDFunction();
        int choice = 0;
        while (choice != -1) {
            System.out.println("databaseLink = " + databaseLink);
            if (databaseLink == null) {
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }

            try {
                if (choice < 0) {
                    System.out.println("Enter the correct choice #!");
                } else if (choice > 6) {
                    System.out.println("Enter the correct choice #!");
                } else if (choice != 2001) {
                    System.out.println("Enter the correct choice #!");
                } else if ((choice != 3001) || (choice != 4001) || (choice != 5001)) {
                    System.out.println("Enter the correct choice #!");
                }
                System.out.println("====================================================================================================================================\n");
                System.out.println("                      SELECT THE COURSE NUMBER TO SEE ITs LIST OF STUDENTS ENROLLED TO THAT COURSE ");
                System.out.println("                                    ENTER--->  1  to Show   Student's ENROLLED TO  Software Engineering COURSE");
                System.out.println("                                    ENTER--->  2  to Show   Student's ENROLLED TO  Computing and AI COURSE");
                System.out.println("                                    ENTER--->  3  to Show   Student's ENROLLED TO  Business and enterprise  COURSE");
                System.out.println("                                    ENTER--->  4  to Show   Student's ENROLLED TO  Allied Health COURSE");
                System.out.println("                                    ENTER---> -1  to exit   program");
                System.out.println("====================================================================================================================================\n");
                System.out.println("input Course Number: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("You have selected COURSE 1 Software Engineering");
                        choice = 2001;
                        getCourseByID(choice);
                        operationList();

                    }
                    case 2 -> {
                        System.out.println("You have selected Course 2 Computing and AI");
                        choice = 3001;
                        getCourseByID(choice);
                        operationList();
                    }
                    case 3 -> {
                        System.out.println("You have selected Course 3 Business and enterprise");
                        choice = 4001;
                        getCourseByID(choice);
                        operationList();
                    }
                    case 4 -> {
                        System.out.println("You have selected Course 4 Allied Health");
                        choice = 5001;
                        getCourseByID(choice);
                        operationList();
                    }

                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Please Enter the number shown on the menu above!");
                break;
            }

            System.out.println("####################################################################################################################################");
            System.out.println("####################################################################################################################################\n");
        }
    }

    public void operationList() throws SQLException {


        getDatabaseConnection();

        int Pick = 0;
        while (Pick != -1) {
            System.out.println("databaseLink = " + databaseLink);
            if (databaseLink == null) {
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }

            try {
                if (Pick < 0 || Pick > 6) {
                    System.out.println("Enter the correct choice #!");
                }
                System.out.println("====================================================================================================================================\n");
                System.out.println("                                           ENTER--->  1  to Show   Course");
                System.out.println("                                           ENTER--->  2  to Add    Course");
                System.out.println("                                           ENTER--->  3  to Delete Course");
                System.out.println("                                           ENTER--->  4  to update Course");
                System.out.println("                                           ENTER--->  5  to Search Course");
                System.out.println("                                           ENTER---> -1  to exit   program");
                System.out.println("====================================================================================================================================\n");
                System.out.println("input your number to perform Task: ");
                Pick = scanner.nextInt();
                switch (Pick) {
                    case 1 -> {
                        System.out.println("You have selected Show Course ");
                        showCourses.getCourseByID();
                        //showCourses.show();

                    }
                    case 2 -> {
                        System.out.println("You have selected Add Course ");
                        addCourse.add();
                    }

                    case 3 -> {
                        System.out.println("You have selected Delete Course ");
                        deleteCourse.delete();
                    }
                    case 4 -> {
                        System.out.println("You have selected Update Course ");
                        updateCourse.update();
                    }
                    case 5 -> {
                        System.out.println("You have selected Search Course ");
                        searchCourse.search();
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Please Enter the number shown on the menu above!");
                break;
            }

            System.out.println("####################################################################################################################################");
            System.out.println("####################################################################################################################################\n");
        }


    }
}
