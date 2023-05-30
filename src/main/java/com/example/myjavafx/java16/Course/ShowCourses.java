package com.example.myjavafx.java16.Course;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IShow;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class ShowCourses extends DataBaseConnection implements IShow {

    StudentInformationSystem sis = new StudentInformationSystem();

    @Override
    public void show() {
        Map<Integer, Course> courseMap = sis.getCourseMap();
        for (Map.Entry<Integer, Course> entry : courseMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().printObject() + "\n");

        }

    }
    public void getCourseByID() throws SQLException {

        getDatabaseConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Database Link = " + databaseLink);
        System.out.println("************************************************************************************************\n");
        System.out.println("Enter the Course ID you want to Show : ");
        int prompt = scanner.nextInt();
        String sql_query = """
                    SELECT s.*, c.CourseNames, c.CoursesID
                                          FROM sis.student s
                                          JOIN sis.courses c ON s.CoursesID = c.CoursesID
                                          WHERE s.CoursesID = ?;
                """;
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);
        statement.setInt(1, prompt);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String studentID = resultSet.getString("StudentID");
            String studentFirstName = resultSet.getString("FirstName");
            String studentLastName = resultSet.getString("LastName");
            String studentEmail = resultSet.getString("Email");
            String CourseName = resultSet.getString("CourseNames");
            String CourseId = resultSet.getString("CoursesID");
            String courseDuration = resultSet.getString("CourseDuration");

            System.out.println("Student ID = " + studentID);
            System.out.println("Student First Name = " + studentFirstName);
            System.out.println("Student Last Name = " + studentLastName);
            System.out.println("Student Email = " + studentEmail);
            System.out.println("Course ID = " + CourseId);
            System.out.println("Course Name = " + CourseName);
            System.out.println("Course Duration = " + courseDuration);
            System.out.println("************************************************************************************************\n");

        }

        statement.close();
        resultSet.close();


    }
//    public void getCourseByID() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        getDatabaseConnection();
//        System.out.println("Database Link = " + databaseLink);
//        System.out.println("************************************************************************************************\n");
//        System.out.println("Enter the Course ID you want to Show : ");
//        int prompt = scanner.nextInt();
//        String sql_query = """
//                    SELECT s.*, c.CourseNames, c.CoursesID
//                                          FROM sis.student s
//                                          JOIN sis.courses c ON s.CoursesID = c.CoursesID
//                                          WHERE s.CoursesID = ?;
//                """;
//        PreparedStatement statement = databaseLink.prepareStatement(sql_query);
//        statement.setInt(1, prompt);
//        //statement.setInt(1, choice);
//        ResultSet resultSet = statement.executeQuery();
//
//        while (resultSet.next()) {
//            int studentID = resultSet.getInt("StudentID");
//            String studentFirstName = resultSet.getString("FirstName");
//            String studentLastName = resultSet.getString("LastName");
//            String studentEmail = resultSet.getString("Email");
//            String courseName = resultSet.getString("CourseName");
//            int courseId = resultSet.getInt("CourseID");
//            //String courseDuration = resultSet.getString("CourseDuration");
//
//            System.out.println("Student ID = " + studentID);
//            System.out.println("Student First Name = " + studentFirstName);
//            System.out.println("Student Last Name = " + studentLastName);
//            System.out.println("Student Email = " + studentEmail);
//            System.out.println("Course ID = " + courseId);
//            System.out.println("Course Name = " + courseName);
//            //System.out.println("Course Duration = " + courseDuration);
//            System.out.println("************************************************************************************************\n");
//
//        }
//
//    }
}
