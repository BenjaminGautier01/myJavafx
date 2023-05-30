package com.example.myjavafx.java16.Course;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IDelete;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class DeleteCourse extends DataBaseConnection implements IDelete {

    public   <T> void delete(T object){
        if (object instanceof Course course) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Course> courseMap = sis.getCourseMap();
            courseMap.remove(course.getCourseID());
            System.out.println("Course Deleted Successfully!");
        }
    }

    @Override
    public void delete() throws SQLException {

        try {
            getDatabaseConnection();
            System.out.println("databaseLink = " + databaseLink);
            if (databaseLink == null) {
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the StudentID to delete the Course: ");
            int StudentID = sc.nextInt();

            String sql_query = "UPDATE sis.student " +
                               "SET CourseName = NULL, CourseID = NULL, CourseDuration = NULL " +
                               "WHERE StudentID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            statement.setInt(1, StudentID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deletion COMPLETED!");
            } else {
                System.out.println("Deletion Unsuccessful");
            }

            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
