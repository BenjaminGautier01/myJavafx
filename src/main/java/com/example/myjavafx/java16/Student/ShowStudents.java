package com.example.myjavafx.java16.Student;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IShow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.myjavafx.java16.StudentInformationSystem.studentMap;

public class ShowStudents  extends DataBaseConnection implements IShow {


    @Override
    public void show() throws SQLException {
        try {
            getDatabaseConnection();

            // Retrieve all student records from the database
            System.out.println("Database Link = " + databaseLink);
            String sql = "SELECT * FROM sis.student";
            Statement statement = databaseLink.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Loop through the result set and create a Student object for each record

            while (resultSet.next()) {

                Student myStudent = new Student(
                        resultSet.getInt("StudentID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Gender"),
                        resultSet.getString("DateOfBirth"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getString("confirmpassword"));
                System.out.println("StudentID= " + myStudent.getID());
                System.out.println("FirstName= " + myStudent.getFirstName());
                System.out.println("LastName= " + myStudent.getLastName());
                System.out.println("Gender= " + myStudent.getGender());
                System.out.println("DateOfBirth= " + myStudent.getDateOfBirth());
                System.out.println("Email= " + myStudent.getEmail());
                System.out.println("Password= " + myStudent.getPassword());
                System.out.println("ConfirmPassword= " + myStudent.getConfirmPassword());
                System.out.println("************************************************************************************************\n");

                //Student student = (Student)newStudent;
                studentMap.put(myStudent.getID(),myStudent);
                //System.out.println("Student Added Successfully!");


            }

            // Close the statement and result set
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




/*
    @Override
    public void show() {
        StudentInformationSystem sis = new StudentInformationSystem();
        Map<Integer, Student> studentMap = sis.getStudentMap();
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().printObject() + "\n");}
    }
*/
}

