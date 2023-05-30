package com.example.myjavafx.java16.Course;


import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IUpdate;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import static com.example.myjavafx.java16.StudentInformationSystem.courseMap;



public class UpdateCourse extends DataBaseConnection implements IUpdate {

    public <T> void update(T object) {

        Course course = (Course) object;
        StudentInformationSystem sis = new StudentInformationSystem();
        Map<Integer, Course> courseMap = sis.getCourseMap();
        if (object != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your ID: ");
            int ID = sc.nextInt();

            // Find the Course to update in the Courses list
            Course CourseToUpdate = null;
            for (Map.Entry<Integer, Course> entry : courseMap.entrySet()) {
                if (entry.getKey() == ID) {
                    CourseToUpdate = entry.getValue();
                    break;
                }
            }
            if (CourseToUpdate == null) {
                System.out.println("Course with ID " + ID + " not found.");
                return;
            }

            System.out.println("Enter Course Name: ");
            String courseName = sc.next();
            System.out.println("Enter Course Duration: ");
            String duration = sc.next();


            // Update the Course in the Courses list
            CourseToUpdate.setCourseName(courseName);
            CourseToUpdate.setCourseDuration(duration);

            System.out.println("UPDATE COMPLETED!");

        }
    }

    @Override
    public void update() throws SQLException {

        try {
            getDatabaseConnection();
            System.out.println("databaseLink = " + databaseLink);
            if (databaseLink == null) {
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your StudentID: ");
            int StudentID = sc.nextInt();
            sc.nextLine(); // consume newline character left in buffer
            System.out.println("Enter your CourseName: ");
            String CourseName = sc.nextLine();
            System.out.println("Enter your CourseID: ");
            int CourseID = sc.nextInt();
            sc.nextLine(); // consume newline character left in buffer
            System.out.println("Enter your CourseDuration: ");
            String CourseDuration = sc.nextLine();


            String sql_query = "UPDATE sis.student SET  CourseID = ? , CourseName = ?,CourseDuration = ?   WHERE StudentID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            statement.setInt(1, CourseID);
            statement.setString(2, CourseName);
            statement.setString(3, CourseDuration);
            statement.setInt(4, StudentID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("UPDATE COMPLETED!");
            } else {
                System.out.println("Update Unsuccessful");
            }

            statement.close();

            // Create a new Course object and add it to the map
            Course newCourse = new Course(CourseName, CourseID, CourseDuration);

            if(newCourse instanceof Course){
                courseMap.put(newCourse.getCourseID(),newCourse);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }



//        try {
//            getDatabaseConnection();
//            System.out.println("databaseLink = " + databaseLink);
//            if (databaseLink == null) {
//                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
//            }
//
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter your StudentID: ");
//            int StudentID = sc.nextInt();
//            sc.nextLine(); // consume newline character left in buffer
//            System.out.println("Enter your CourseName: ");
//            String CourseName = sc.nextLine();
//            System.out.println("Enter your CourseID: ");
//            int CourseID = sc.nextInt();
//            sc.nextLine(); // consume newline character left in buffer
//            System.out.println("Enter your CourseDuration: ");
//            String CourseDuration = sc.nextLine();
//
//
//            String sql_query = "UPDATE sis.student SET  CoursesID = ? , CourseName = ?,CourseDuration = ?   WHERE StudentID = ?";
//            PreparedStatement statement = databaseLink.prepareStatement(sql_query);
//
//            statement.setInt(1, StudentID);
//            statement.setInt(2, CourseID);
//            statement.setString(3, CourseName);
//            statement.setString(4, CourseDuration);
//
//
//            int rowsAffected = statement.executeUpdate();
//            if (rowsAffected > 0) {
//                System.out.println("INSERTION or Addition COMPLETED!");
//            } else {
//                System.out.println("Insertion Unsuccessful");
//            }
//
//            statement.close();
//
//            // Create a new Student object and add it to the list
//            //int ID = getLastInsertedID();
//            Course newCourse= new Course(CourseName, CourseID,CourseDuration);
//
//            if(newCourse instanceof Course){
//                //Student student = (Student)newStudent;
//                courseMap.put(newCourse.getCourseID(),newCourse);
//                //System.out.println("Course Added Successfully!");
//            }
//
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}