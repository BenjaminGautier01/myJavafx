package com.example.myjavafx.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    public Connection databaseLink;
    public static String url = "jdbc:mysql://127.0.0.1:3306/sis";
    public static String databaseName = "sis" ;
    public static String databaseUser = "root" ;
    public static String databasePassword = "root" ;

    public Connection getDatabaseConnection() throws SQLException {

        databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        System.out.println("databaseLink = " + databaseLink);
        System.out.println("DatabaseLink Established Database Connection Successful!");

        return databaseLink;

    }
    public void disconnect() throws SQLException {
        if (databaseLink != null && !databaseLink.isClosed()) {
            databaseLink.close();
        }
    }
}
