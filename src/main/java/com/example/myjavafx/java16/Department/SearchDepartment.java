package com.example.myjavafx.java16.Department;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.ISearch;
import com.example.myjavafx.java16.Student.*;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class SearchDepartment extends DataBaseConnection implements ISearch {

    public <T> void search(T object) {
        if (object instanceof Department department) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Department> departmentMap = sis.getDepartmentMap();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student ID to search: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // consume remaining newline character
            if (departmentMap.containsKey(studentId)) {
                Department foundDepartment = departmentMap.get(studentId);
                System.out.println("Department found: " + foundDepartment);
            } else {
                System.out.println("Department not found!");
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

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the StudentID to search for the Department: ");
            int StudentID = sc.nextInt();

            String sql_query = "SELECT DepartmentName, DepartmentID FROM sis.student " +
                               "WHERE StudentID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            statement.setInt(1, StudentID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String DepartmentName = resultSet.getString("DepartmentName");
                int DepartmentID = resultSet.getInt("DepartmentID");
                System.out.println("Department Name: " + DepartmentName);
                System.out.println("Department ID: " + DepartmentID);
            } else {
                System.out.println("No Department Found for StudentID: " + StudentID);
            }

            resultSet.close();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
