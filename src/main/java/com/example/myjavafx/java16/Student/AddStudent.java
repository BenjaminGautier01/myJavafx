package com.example.myjavafx.java16.Student;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IAdd;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.*;
import java.util.Map;
import java.util.Scanner;

import static com.example.myjavafx.java16.StudentInformationSystem.studentMap;

public class AddStudent  extends DataBaseConnection implements IAdd  {

    StudentInformationSystem sis = new StudentInformationSystem();



    @Override
    public <T> void add(T object) {
        Map<Integer, Student> studentMap = sis.getStudentMap();
        if(object instanceof Student){
            Student student = (Student)object;
            studentMap.put(student.getID(), student);
            System.out.println("Student Added Successfully!");
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
            System.out.println("Enter your First Name: ");
            String firstName = sc.next();
            System.out.println("Enter your Last Name: ");
            String lastName = sc.next();
            System.out.println("Enter your Email: ");
            String email = sc.next();
            System.out.println("Enter your Date Of Birth: ");
            String dateOfBirth = sc.next();
            System.out.println("Enter your Gender: ");
            String gender = sc.next();
            System.out.println("Enter your password: ");
            String password = sc.next();
            System.out.println("Enter your Confirm Password: ");
            String ConfirmPassword = sc.next();

            String sql_query = "INSERT INTO sis.student (FirstName, LastName, Gender, DateOfBirth, Email, Password,ConfirmPassword, DateRegistered) VALUES (?, ?, ?, ?, ?, ?, ?,  NOW())";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setString(4, dateOfBirth);
            statement.setString(5, email);
            statement.setString(6, password);
            statement.setString(7, ConfirmPassword);
            statement.executeUpdate();
            System.out.println("INSERTION COMPLETED!");
            statement.close();

            // Create a new Student object and add it to the list
            int ID = getLastInsertedID();
            Student newStudent = new Student(ID, firstName, lastName, gender, dateOfBirth, email, password, ConfirmPassword);

            //Student student = (Student)newStudent;
            studentMap.put(newStudent.getID(),newStudent);
            System.out.println("Student Added Successfully!");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public int getLastInsertedID() throws SQLException {
        getDatabaseConnection();
        //The getLastInsertedID() method is used to retrieve the ID of the last record that was inserted into the database.
        // This method can be useful when you need to insert a new record into a table that has an auto-incrementing ID column.
        // You can use this method to retrieve the ID of the last inserted record, and then use that ID to perform other
        // operations such as updating or deleting the record.

        int lastInsertedID = 0;
        try {
            String sql = "SELECT LAST_INSERT_ID()";
            Statement statement = databaseLink.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                lastInsertedID = resultSet.getInt(1);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastInsertedID;
    }

}
