package com.example.myjavafx.java16.Student;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IUpdate;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class UpdateStudent extends DataBaseConnection implements IUpdate {


    public <T> void update(T object) {

        Student student = (Student) object;
        StudentInformationSystem sis = new StudentInformationSystem();
        Map<Integer, Student> studentMap = sis.getStudentMap();
        if (object != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your ID: ");
            int ID = sc.nextInt();

            // Find the student to update in the students list
            Student studentToUpdate = null;
            for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
                if (entry.getKey() == ID) {
                    studentToUpdate = entry.getValue();
                    break;
                }
            }
            if (studentToUpdate == null) {
                System.out.println("Student with ID " + ID + " not found.");
                return;
            }

            System.out.println("Enter your First Name: ");
            String firstName = sc.next();
            System.out.println("Enter your Last Name: ");
            String lastName = sc.next();
            System.out.println("Enter your Email: ");
            String email = sc.next();
            System.out.println("Enter your password: ");
            String password = sc.next();
            System.out.println("Enter your Confirm Password: ");
            String confirmPassword = sc.next();
            System.out.println("Enter your Date Of Birth: ");
            String dateOfBirth = sc.next();
            System.out.println("Enter your Gender: ");
            String gender = sc.next();


            // Update the student in the students list
            studentToUpdate.setFirstName(firstName);
            studentToUpdate.setLastName(lastName);
            studentToUpdate.setGender(gender);
            studentToUpdate.setDateOfBirth(dateOfBirth);
            studentToUpdate.setEmail(email);
            studentToUpdate.setPassword(password);
            studentToUpdate.setConfirmPassword(confirmPassword);

            System.out.println("UPDATE COMPLETED!\n");

        }
    }

    @Override
    public void update() throws SQLException {

        try {
            getDatabaseConnection();
            System.out.println("Database Link = " + databaseLink);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Student ID: ");
            int id = sc.nextInt();

            // Search the database for the student
            String sql = "SELECT * FROM sis.student WHERE StudentID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            // Check if the ID is in the database
            if (!resultSet.next()) {
                System.out.println("ID not found in the database.");
                return;
            }

            // Display the student information
            System.out.println("StudentID: " + resultSet.getInt("StudentID"));
            System.out.println("First Name: " + resultSet.getString("FirstName"));
            System.out.println("Last Name: " + resultSet.getString("LastName"));
            System.out.println("Gender: " + resultSet.getString("Gender"));
            System.out.println("DateOfBirth: " + resultSet.getString("DateOfBirth"));
            System.out.println("Email: " + resultSet.getString("Email"));
            System.out.println("Password: " + resultSet.getString("Password"));
            System.out.println("ConfirmPassword: " + resultSet.getString("confirmpassword"));
            System.out.println("************************************************************************************************\n");

            // Prompt the user to enter the updated information
            System.out.println("Enter updated information:");

            System.out.println("First Name: ");
            String firstName = sc.next();

            System.out.println("Last Name: ");
            String lastName = sc.next();

            System.out.println("Gender: ");
            String gender = sc.next();

            System.out.println("DateOfBirth: ");
            String dateOfBirth = sc.next();

            System.out.println("Email: ");
            String email = sc.next();

            System.out.println("Password: ");
            String password = sc.next();

            System.out.println("ConfirmPassword: ");
            String confirmPassword = sc.next();

            // Update the student information in the database
            String updateSql = "UPDATE sis.student SET FirstName = ?, LastName = ?, Gender = ?, DateOfBirth = ?, Email = ?, Password = ?, confirmpassword = ? WHERE StudentID = ?";
            PreparedStatement updateStatement = databaseLink.prepareStatement(updateSql);
            updateStatement.setString(1, firstName);
            updateStatement.setString(2, lastName);
            updateStatement.setString(3, gender);
            updateStatement.setString(4, dateOfBirth);
            updateStatement.setString(5, email);
            updateStatement.setString(6, password);
            updateStatement.setString(7, confirmPassword);
            updateStatement.setInt(8, id);

            int rowsUpdated = updateStatement.executeUpdate();
            System.out.println(rowsUpdated + " row(s) updated in the database.");

            updateStatement.close();
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
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
//            System.out.println("Enter Student ID: ");
//            int ID = sc.nextInt();
//
//            StudentInformationSystem sis = new StudentInformationSystem();
//            Map<Integer, Student> studentMap = sis.getStudentMap();
//
//                // Find the student to update in the students list
//                Student studentToUpdate = null;
//                for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
//                    if (entry.getKey() == ID) {
//                        System.out.println("Student with ID " + ID + " found.");
//                        studentToUpdate = entry.getValue();
//                        break;
//                    }
//                }
//                if (studentToUpdate == null) {
//                    System.out.println("Student with ID " + ID + " not found.");
//                    return;
//                }
//
//            System.out.println("Enter your First Name: ");
//            String firstName = sc.next();
//            System.out.println("Enter your Last Name: ");
//            String lastName = sc.next();
//            System.out.println("Enter your Email: ");
//            String email = sc.next();
//            System.out.println("Enter your password: ");
//            String password = sc.next();
//            System.out.println("Enter your Confirm Password: ");
//            String confirmPassword = sc.next();
//            System.out.println("Enter your Date Of Birth: ");
//            String dateOfBirth = sc.next();
//            System.out.println("Enter your Gender: ");
//            String gender = sc.next();
//
//            String sql_query = "UPDATE sis.student SET FirstName=?, LastName=?, Gender=?, DateOfBirth=?, Email=?, Password=?, ConfirmPassword=?, DateRegistered=NOW() WHERE StudentID=?";
//            PreparedStatement statement = databaseLink.prepareStatement(sql_query);
//
//            statement.setString(1, firstName);
//            statement.setString(2, lastName);
//            statement.setString(3, gender);
//            statement.setString(4, dateOfBirth);
//            statement.setString(5, email);
//            statement.setString(6, password);
//            statement.setString(7, confirmPassword);
//            statement.setInt(8, ID);
//            statement.executeUpdate();
//            System.out.println("UPDATE COMPLETED!");
//            statement.close();
//
//            // Update the student in the students list
//            studentToUpdate.setFirstName(firstName);
//            studentToUpdate.setLastName(lastName);
//            studentToUpdate.setGender(gender);
//            studentToUpdate.setDateOfBirth(dateOfBirth);
//            studentToUpdate.setEmail(email);
//            studentToUpdate.setPassword(password);
//            studentToUpdate.setConfirmPassword(confirmPassword);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
