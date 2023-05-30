package com.example.myjavafx.java16.Course;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.ISearch;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class SearchCourse extends DataBaseConnection implements ISearch {

    public <T> void search(T object) {
        if (object instanceof Course course) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Course> courseMap = sis.getCourseMap();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Course ID to search: ");
            int courseID = scanner.nextInt();
            scanner.nextLine(); // consume remaining newline character
            if (courseMap.containsKey(courseID)) {
                Course foundCourse = courseMap.get(courseID);
                System.out.println("Course found: " + foundCourse.printObject());
            } else {
                System.out.println("Course not found!");
            }
        } else {
            System.out.println("Object type not supported for search!");
        }
    }

    @Override
    public void search() throws SQLException {

        try {
            getDatabaseConnection();
            System.out.println("databaseLink = " + databaseLink);
            if (databaseLink == null) {
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }

            try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter the StudentID to search for the Course: ");
				int StudentID = sc.nextInt();

				String sql_query = "SELECT CourseName, CoursesID, CourseDuration FROM sis.student " +
				                   "WHERE StudentID = ?";
				PreparedStatement statement = databaseLink.prepareStatement(sql_query);

				statement.setInt(1, StudentID);

				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
				    String CourseName = resultSet.getString("CourseName");
				    int CourseID = resultSet.getInt("CoursesID");
				    String CourseDuration = resultSet.getString("CourseDuration");
				    System.out.println("Course Name: " + CourseName);
				    System.out.println("Course ID: " + CourseID);
				    System.out.println("Course Duration: " + CourseDuration);
				} else {
				    System.out.println("No Course Found for StudentID: " + StudentID);
				}

				resultSet.close();
				statement.close();
			}
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
