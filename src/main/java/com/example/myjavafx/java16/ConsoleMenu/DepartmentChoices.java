package com.example.myjavafx.java16.ConsoleMenu;


import com.example.myjavafx.java16.Admin.*;
import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Department.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DepartmentChoices extends DataBaseConnection {

    public static Scanner scanner = new Scanner(System.in);
    protected Department department;
    protected ShowDepartments showDepartments;
    protected AddDepartment addDepartment;
    protected SearchDepartment searchDepartment;
    protected DeleteDepartment deleteDepartment;
    protected UpdateDepartment updateDepartment;

    public DepartmentChoices() {
        this.showDepartments = new ShowDepartments();
        this.addDepartment = new AddDepartment();
        this.deleteDepartment = new DeleteDepartment();
        this.searchDepartment = new SearchDepartment();
        this.updateDepartment = new UpdateDepartment();

    }


    public void getDepartmentByID ( int choice ) throws SQLException {

        getDatabaseConnection();
        System.out.println("Database Link = " + databaseLink);
        System.out.println("************************************************************************************************\n");
        String sql_query = """
                    SELECT s.*, d.DepartmentName
                    FROM sis.student s
                    JOIN sis.departments d ON s.DepartmentID = d.DepartmentID
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

    public void DepartmentChoice() throws SQLException {
        getDatabaseConnection();

        int choice = 0;
        while (choice != -1) {
            System.out.println("databaseLink = " + databaseLink);
            if (databaseLink == null) {
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }

            try {
                if (choice < 0 || choice > 6) {
                    System.out.println("Enter the correct choice #!");
                }
                System.out.println("input your number: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("You have selected Department 1 LONDON");
                        getDepartmentByID(choice);
                        operationList();

                    }
                    case 2 -> {
                        System.out.println("You have selected Department 2 HARROW");
                        getDepartmentByID(choice);
                        operationList();
                    }
                    case 3 -> {
                        System.out.println("You have selected Department 3 WEMBLEY");
                        getDepartmentByID(choice);
                        operationList();
                    }
                    case 4 -> {
                        System.out.println("You have selected Department 4 KINGSBURY");
                        getDepartmentByID(choice);
                        operationList();
                    }
                    case 5 -> {
                        System.out.println("You have selected Department 5 SOUTHALL");
                        getDepartmentByID(choice);
                        operationList();
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Please Enter the number shown on the menu above!");
                break;
            }

            System.out.println("####################################################################################################################################");
            System.out.println("####################################################################################################################################\n");
        }
    }

    public void operationList() throws SQLException {


        getDatabaseConnection();

        int Pick = 0;
        while (Pick != -1) {
            System.out.println("databaseLink = " + databaseLink);
            if (databaseLink == null) {
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }

            try {
                if (Pick < 0 || Pick > 6) {
                    System.out.println("Enter the correct choice #!");
                }
                System.out.println("====================================================================================================================================\n");
                System.out.println("                                           ENTER--->  1  to Show   Department");
                System.out.println("                                           ENTER--->  2  to Add    Department");
                System.out.println("                                           ENTER--->  3  to Delete Department");
                System.out.println("                                           ENTER--->  4  to update Department");
                System.out.println("                                           ENTER--->  5  to Search Department");
                System.out.println("                                           ENTER---> -1  to exit   program");
                System.out.println("====================================================================================================================================\n");
                System.out.println("input your number: ");
                Pick = scanner.nextInt();
                switch (Pick) {
                    case 1 -> {
                        System.out.println("You have selected Show Department ");
                        showDepartments.getDepartmentByID();
                        //showDepartments.show();

                    }
                    case 2 -> {
                        System.out.println("You have selected Add Department ");
                        addDepartment.add();
                    }

                    case 3 -> {
                        System.out.println("You have selected Delete Department ");
                        deleteDepartment.delete();
                    }
                    case 4 -> {
                        System.out.println("You have selected Update Department ");
                        updateDepartment.update();
                    }
                    case 5 -> {
                        System.out.println("You have selected Search Department ");
                        searchDepartment.search();
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Please Enter the number shown on the menu above!");
                break;
            }

            System.out.println("####################################################################################################################################");
            System.out.println("####################################################################################################################################\n");
        }



    }
}




