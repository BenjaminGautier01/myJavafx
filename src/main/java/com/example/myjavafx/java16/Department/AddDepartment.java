package com.example.myjavafx.java16.Department;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IAdd;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.*;
import java.util.Map;
import java.util.Scanner;

import static com.example.myjavafx.java16.StudentInformationSystem.departmentMap;

public class AddDepartment  extends DataBaseConnection implements IAdd {

    StudentInformationSystem sis = new StudentInformationSystem();



    public <T> void add(T object) {
        Map<Integer, Department> departmentMap = sis.getDepartmentMap();
        if(object instanceof Department department){
            departmentMap.put(department.getDepartmentID(), department);
            System.out.println("Department Added Successfully!");
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
            System.out.println("Enter your DepartmentName: ");
            String DepartmentName = sc.next();
            System.out.println("Enter your DepartmentID: ");
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

