package com.example.myjavafx.java16.Admin;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IShow;
import com.example.myjavafx.java16.StudentInformationSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static com.example.myjavafx.java16.StudentInformationSystem.adminMap;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;






public class ShowAdmins extends DataBaseConnection implements IShow{

    protected Admin admin;
    StudentInformationSystem sis = new StudentInformationSystem();

    public ShowAdmins() {

    }

    // for ComandLine user interface or Console
    @Override
    public void show() {
        try {
            getDatabaseConnection();

            // Retrieve all student records from the database
            //System.out.println("Database Link = " + databaseLink);
            String sql = "SELECT * FROM sis.admin";
            Statement statement = databaseLink.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Loop through the result set and create a Student object for each record

            while (resultSet.next()) {

                Admin myAdmin = new Admin(
                        resultSet.getInt("AdminID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Gender"),
                        resultSet.getString("DateOfBirth"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getString("confirmpassword"));
                System.out.println("AdminID= " + myAdmin.getID());
                System.out.println("FirstName= " + myAdmin.getFirstName());
                System.out.println("LastName= " + myAdmin.getLastName());
                System.out.println("Gender= " + myAdmin.getGender());
                System.out.println("DateOfBirth= " + myAdmin.getDateOfBirth());
                System.out.println("Email= " + myAdmin.getEmail());
                System.out.println("Password= " + myAdmin.getPassword());
                System.out.println("ConfirmPassword= " + myAdmin.getConfirmPassword());
                System.out.println("************************************************************************************************\n");

                //Student student = (Student)newStudent;

                adminMap.put(myAdmin.getID(),myAdmin);
                //System.out.println("Student Added Successfully!");


            }

            // Close the statement and result set
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    // for GUI and database
    public ObservableList<Admin> getAdmins() throws SQLException {

        ObservableList<Admin> adminList = FXCollections.observableArrayList();
        databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        String query = "SELECT * FROM sis.admin";
        Statement statement;
        ResultSet resultSet;

        try{
            statement = databaseLink.createStatement();
            resultSet = statement.executeQuery(query);
            Admin admin;
            while(resultSet.next()) {
                Admin myAdmin = new Admin(
                        resultSet.getInt("AdminID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Gender"),
                        resultSet.getString("DateOfBirth"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getString("ConfirmPassword"));

                adminList.add(myAdmin);

            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return adminList;
    }

}

