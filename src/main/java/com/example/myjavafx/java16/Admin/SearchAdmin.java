package com.example.myjavafx.java16.Admin;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.ISearch;
import com.example.myjavafx.java16.Student.*;
import com.example.myjavafx.java16.StudentInformationSystem;
import com.example.myjavafx.java16.Admin.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class SearchAdmin extends DataBaseConnection implements ISearch {

    public <T> void search(T object) {
        if (object instanceof Admin admin) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Admin> adminMap = sis.getAdminMap();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Admin ID to search: ");
            int adminId = scanner.nextInt();
            scanner.nextLine(); // consume remaining newline character
            if (adminMap.containsKey(adminId)) {
                Admin foundAdmin = adminMap.get(adminId);
                System.out.println("Admin found: " + foundAdmin.printObject());
            } else {
                System.out.println("Admin not found!");
            }
        } else {
            System.out.println("Object type not supported for search!");
        }
    }

    @Override
    public void search() throws SQLException {

        try {
            getDatabaseConnection();
            System.out.println("Database Link = " + databaseLink);

            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Admin> adminMap = sis.getAdminMap();
            System.out.println("************************************************************************************************\n");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Admin ID: ");
            int id = sc.nextInt();

            // Search the database for the student
            String sql = "SELECT * FROM sis.admin WHERE AdminID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("AdminID: " + resultSet.getInt("AdminID"));
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
}
