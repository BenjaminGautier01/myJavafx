package com.example.myjavafx.java16.ConsoleMenu;


import com.example.myjavafx.java16.DataBase.DataBaseConnection;

import java.sql.*;
import java.util.Scanner;

public class Login extends DataBaseConnection {
    public int num = 3;
    public Welcome wc;
    public Scanner scanner = new Scanner(System.in);

    public Login() {
        this.wc = new Welcome();
    }


    public Connection getDatabaseConnection() throws SQLException {
        if (databaseLink == null) {
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }
        return databaseLink;
    }

    @SuppressWarnings("resource")
	public void login() throws SQLException {
        wc = new Welcome();
        @SuppressWarnings("unused")
		Scanner scanner = new Scanner(System.in);
        Connection connection = getDatabaseConnection();
        System.out.println("DatabaseLink =  " + databaseLink +"\n");

        while (num > 0) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter your Email: ");
            String email = s.next();
            System.out.println("Enter your Password: ");
            String password = s.next();

            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM sis.admin WHERE Email = ? AND Password = ?")) {
                statement.setString(1, email);
                statement.setString(2, password);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Login successful!");
                        options();
                    } else {
                        num -= 1;
                        System.out.println("Login unsuccessful!");
                        System.out.println("Number of Attempts: " + (num));
                        login();

                    }
                    //System.out.println("Number of Attempts Exceeded:");
                    System.exit(0);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }



    public void options() throws Exception {
        try {
            System.out.println("====================================================================================================================================\n");
            System.out.println("  ENTER THE NUMBER WHICH CORRESPOND TO THE SECTION YOU WANT TO ACCESS.");
            System.out.println("            <---ENTER---> 1 for  [    Admin    ]");
            System.out.println("            <---ENTER---> 2 for  [   Student   ]");
            System.out.println("            <---ENTER---> 3 for  [ Departments ]");
            System.out.println("            <---ENTER---> 4 for  [   Courses   ]");
            int prompt = scanner.nextInt();
            switch (prompt) {
                case 1 -> {
                    System.out.println("You have selected Admin");
                    wc.displayWelcomeAdmin();
                }
                case 2 -> {
                    System.out.println("You have selected Student");
                    wc.displayWelcomeStudent();
                }
                case 3 -> {
                    System.out.println("You have selected Departments");
                    wc.displayWelcomeDepartments();
                }
                case 4 -> {
                    System.out.println("You have selected Courses");
                    wc.displayWelcomeCourses();
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Please Enter the number shown on the menu above!");
        }
    }
}