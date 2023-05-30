package com.example.myjavafx.java16.Student;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.ISearch;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class SearchStudent extends DataBaseConnection implements ISearch {

    @Override
    public void search() throws SQLException {

        try {
            getDatabaseConnection();
            System.out.println("Database Link = " + databaseLink);

            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Student> studentMap = sis.getStudentMap();
            System.out.println("************************************************************************************************\n");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Student ID: ");
            int id = sc.nextInt();

            // Search the database for the student
            String sql = "SELECT * FROM sis.student WHERE StudentID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("StudentID: " + resultSet.getInt("StudentID"));
                System.out.println("First Name: " + resultSet.getString("FirstName"));
                System.out.println("Last Name: " + resultSet.getString("LastName"));
                System.out.println("Gender: " + resultSet.getString("Gender"));
                System.out.println("DateOfBirth: " + resultSet.getString("DateOfBirth"));
                System.out.println("Email: " + resultSet.getString("Email"));
                System.out.println("Password: " + resultSet.getString("Password"));
                System.out.println("ConfirmPassword: " + resultSet.getString("confirmpassword"));
                System.out.println("************************************************************************************************\n");
            }
            System.out.println("DISPLAY COMPLETED!");
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


        public <T> void search(T object) {
        if (object instanceof Student student) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Student> studentMap = sis.getStudentMap();
            try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter student ID to search: ");
				int studentId = scanner.nextInt();
				scanner.nextLine(); // consume remaining newline character
				if (studentMap.containsKey(studentId)) {
				    Student foundStudent = studentMap.get(studentId);
				    System.out.println("Student found: " + foundStudent.printObject());
				} else {
				    System.out.println("Student not found!");
				}
			}
        } else {
            System.out.println("Object type not supported for search!");
        }
    }
}
