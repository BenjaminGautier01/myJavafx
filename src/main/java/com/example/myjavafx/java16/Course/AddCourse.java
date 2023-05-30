package com.example.myjavafx.java16.Course;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Department.Department;
import com.example.myjavafx.java16.Interfaces.IAdd;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import static com.example.myjavafx.java16.StudentInformationSystem.courseMap;
import static com.example.myjavafx.java16.StudentInformationSystem.departmentMap;


public class AddCourse extends DataBaseConnection implements IAdd {

    StudentInformationSystem sis = new StudentInformationSystem();

    public <T> void add(T object) {
        Map<Integer, Course> courseMap = sis.getCourseMap();
        if(object instanceof Course course){
            courseMap.put(course.getCourseID(), course);
            System.out.println("Course Added Successfully!");
        }
    }

    @Override
    public void add() throws SQLException {

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


            String sql_query = "UPDATE sis.student SET  CoursesID = ? , CourseName = ?,CourseDuration = ?   WHERE StudentID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            statement.setInt(1, CourseID);
            statement.setString(2, CourseName);
            statement.setString(3, CourseDuration);
            statement.setInt(4, StudentID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Add COMPLETED!");
            } else {
                System.out.println("Add Unsuccessful");
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


    }

    public void add1() throws SQLException {

        try {
            getDatabaseConnection();
            System.out.println("databaseLink = " + databaseLink);
            if (databaseLink == null) {
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your Course Name: ");
            String DepartmentName = sc.next();
            System.out.println("Enter your Course ID: ");
            int DepartmentID = sc.nextInt();
            System.out.println("Enter your StudentID: ");
            int StudentID = sc.nextInt();


            String sql_query = "UPDATE sis.student " +
                               "SET DepartmentName = ?, DepartmentID = ? " +
                               "WHERE StudentID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            statement.setString(1, DepartmentName);
            statement.setInt(2, DepartmentID);
            statement.setInt(3, StudentID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("INSERTION or Addition COMPLETED!");
            } else {
                System.out.println("Insertion Unsuccessful");
            }

            statement.close();

            // Create a new Student object and add it to the list
            //int ID = getLastInsertedID();
            Department newDepartment= new Department(DepartmentName, DepartmentID);

            if(newDepartment instanceof Department){
                //Student student = (Student)newStudent;
                departmentMap.put(newDepartment.getDepartmentID(),newDepartment);
                //System.out.println("Department Added Successfully!");
                sc.close();
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
