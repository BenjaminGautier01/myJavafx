package com.example.myjavafx.java16.Admin;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IUpdate;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class UpdateAdmin extends DataBaseConnection implements IUpdate {


    public <T> void update(T object) {

        Admin admin = (Admin) object;
        StudentInformationSystem sis = new StudentInformationSystem();
        Map<Integer, Admin> adminMap = sis.getAdminMap();
        if (object != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Admin ID: ");
            int ID = sc.nextInt();

            // Find the student to update in the students list
            Admin adminToUpdate = null;
            for (Map.Entry<Integer, Admin> entry : adminMap.entrySet()) {
                if (entry.getKey() == ID) {
                    adminToUpdate = entry.getValue();
                    break;
                }
            }
            if (adminToUpdate == null) {
                System.out.println("Admin with ID " + ID + " not found.");
                return;
            }

            System.out.println("Enter  First Name: ");
            String firstName = sc.next();
            System.out.println("Enter  Last Name: ");
            String lastName = sc.next();
            System.out.println("Enter  Email: ");
            String email = sc.next();
            System.out.println("Enter  password: ");
            String password = sc.next();
            System.out.println("Enter  Confirm Password: ");
            String confirmPassword = sc.next();
            System.out.println("Enter  Date Of Birth: ");
            String dateOfBirth = sc.next();
            System.out.println("Enter  Gender: ");
            String gender = sc.next();


            // Update the student in the students list
            adminToUpdate.setFirstName(firstName);
            adminToUpdate.setLastName(lastName);
            adminToUpdate.setGender(gender);
            adminToUpdate.setDateOfBirth(dateOfBirth);
            adminToUpdate.setEmail(email);
            adminToUpdate.setPassword(password);
            adminToUpdate.setConfirmPassword(confirmPassword);

            System.out.println("UPDATE COMPLETED!\n");

        }
    }

    @Override
    public void update() throws SQLException {

        try {
            getDatabaseConnection();
            System.out.println("Database Link = " + databaseLink);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Admin ID: ");
            int id = sc.nextInt();

            // Search the database for the student
            String sql = "SELECT * FROM sis.admin WHERE AdminID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            // Check if the ID is in the database
            if (!resultSet.next()) {
                System.out.println("ID not found in the database.");
                return;
            }

            // Display the student information
            System.out.println("AdminID: " + resultSet.getInt("AdminID"));
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
            String updateSql = "UPDATE sis.admin SET FirstName = ?, LastName = ?, Gender = ?, DateOfBirth = ?, Email = ?, Password = ?, confirmpassword = ? WHERE AdminID = ?";
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

    }
}
