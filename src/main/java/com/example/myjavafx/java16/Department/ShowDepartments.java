package com.example.myjavafx.java16.Department;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IShow;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;

public class ShowDepartments extends DataBaseConnection implements IShow {

    StudentInformationSystem sis = new StudentInformationSystem();
    Map<Integer, Department> departmentMap = sis.getDepartmentMap();

    public void show1() {
        Map<Integer, Department> departmentMap = sis.getDepartmentMap();
        for (Map.Entry<Integer, Department> entry : departmentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().printObject() );
        }

    }

    public void getDepartmentByID() throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
			getDatabaseConnection();
			System.out.println("Database Link = " + databaseLink);
			System.out.println("************************************************************************************************\n");
			System.out.println("Enter the Department ID you want to Show : ");
			int prompt = scanner.nextInt();
			String sql_query = """
			           SELECT s.*, d.DepartmentName
			    FROM sis.student s
			    JOIN sis.departments d ON s.DepartmentID = d.DepartmentID
			    WHERE s.DepartmentID = ?;
			    """;
			PreparedStatement statement = databaseLink.prepareStatement(sql_query);
			statement.setInt(1,prompt);
			//statement.setInt(1, choice);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
			    String studentID = resultSet.getString("StudentID");
			    String studentFirstName = resultSet.getString("FirstName");
			    String studentLastName = resultSet.getString("LastName");
			    String studentEmail = resultSet.getString("Email");
			    String departmentName = resultSet.getString("DepartmentName");
			    String departmentId = resultSet.getString("DepartmentID");

			    System.out.println("Student ID = " + studentID);
			    System.out.println("Student First Name = " + studentFirstName);
			    System.out.println("Student Last Name = " + studentLastName);
			    System.out.println("Student Email = " + studentEmail);
			    System.out.println("Department ID = " + departmentId);
			    System.out.println("Department Name = " + departmentName);
			    System.out.println("************************************************************************************************\n");

			}

			statement.close();
			resultSet.close();
		}


    }
    public void getDepartmentByID(int choice ) throws SQLException {

        getDatabaseConnection();
        System.out.println("Database Link = " + databaseLink);
        System.out.println("************************************************************************************************\n");
        String sql_query = """
            SELECT s.*, d.DepartmentName
            FROM sis.student s
            JOIN sis.department d ON s.DepartmentID = d.DepartmentID
            WHERE s.DepartmentID = ?;
            """;
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);
        statement.setInt(1, choice);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String studentID = resultSet.getString("StudentID");
            String studentFirstName = resultSet.getString("FirstName");
            String studentLastName = resultSet.getString("LastName");
            String studentEmail = resultSet.getString("Email");
            String departmentName = resultSet.getString("DepartmentName");
            String departmentId = resultSet.getString("DepartmentID");

            System.out.println("Student ID = " + studentID);
            System.out.println("Student First Name = " + studentFirstName);
            System.out.println("Student Last Name = " + studentLastName);
            System.out.println("Student Email = " + studentEmail);
            System.out.println("Department ID = " + departmentId);
            System.out.println("Department Name = " + departmentName);
            System.out.println("************************************************************************************************\n");

        }

        statement.close();
        resultSet.close();


    }

    @Override
    public void show() throws SQLException {
        try {
            getDatabaseConnection();

            // Retrieve all student records from the database
            System.out.println("Database Link = " + databaseLink);
            String sql = "SELECT * FROM sis.department ";
            Statement statement = databaseLink.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Loop through the result set and create a Student object for each record

            while (resultSet.next()) {

                Department myDepartment = new Department(
                        resultSet.getString("DepartmentName"),
                        resultSet.getInt("DepartmentID")
                         );

                System.out.println("DepartmentName= " + myDepartment.getDepartmentName());
                System.out.println("DepartmentID= " + myDepartment.getDepartmentID());


                System.out.println("************************************************************************************************\n");


                departmentMap.put(myDepartment.getDepartmentID(),myDepartment);
                //System.out.println("Department Added Successfully!");


            }

            // Close the statement and result set
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
