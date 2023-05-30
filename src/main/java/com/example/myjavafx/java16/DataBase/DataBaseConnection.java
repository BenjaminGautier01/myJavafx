package com.example.myjavafx.java16.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileReader;


public class DataBaseConnection {
    // implementing the Solid principle
    // Single Responsible Principle " A class should have one and only one Responsibility and reason to change".
        public Connection databaseLink;
        public  String url = "jdbc:mysql://127.0.0.1:3306/sis";
        public  String databaseName = "sis";

        public  String databaseUser;
        public  String databasePassword;

        public  Connection getDatabaseConnection() throws SQLException {
            // Here I am implementing the Singleton design pattern where the program will use the method to establish a single connection
            // to the database throughout the program limit SQL exceptions and increase the speed of the program.

            try
            {
                databaseUser = new FileReader(System.getProperty("user.dir") + "\\src\\sql_credentials\\sql_usr.txt").toString();
                databasePassword = new FileReader(System.getProperty("user.dir") + "\\src\\sql_credentials\\sql_pass.txt").toString();

                databaseLink = DriverManager.getConnection("jdbc:mysql://localhost/?useTimeZone=true&serverTimezone=UTC&user=root&password=password");

                //System.out.println("databaseLink = " + databaseLink);
                System.out.println("DatabaseLink Established Database Connection Successful!");
                System.out.println("DatabaseLink = " + databaseLink);
            }
            catch (Exception E)
            {
                System.out.println(E.getMessage());
                E.getMessage();
                System.exit(0);
            }

            return databaseLink;
        }

        public void disconnect() throws SQLException {
            if (databaseLink != null && !databaseLink.isClosed()) {
                databaseLink.close();
            }
        }

}
