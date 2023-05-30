package com.example.myjavafx.java16.Department;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IUpdate;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import static com.example.myjavafx.java16.StudentInformationSystem.departmentMap;

public class UpdateDepartment extends DataBaseConnection implements IUpdate {
    public <T> void update(T object) {

        Department department = (Department) object;
        StudentInformationSystem sis = new StudentInformationSystem();
        Map<Integer, Department> departmentMap = sis.getDepartmentMap();
        if (object != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your Department ID: ");
            int ID = sc.nextInt();

            // Find the Course to update in the Courses list
            Department departmentToUpdate = null;
            for (Map.Entry<Integer, Department> entry : departmentMap.entrySet()) {
                if (entry.getKey() == ID) {
                    departmentToUpdate = entry.getValue();
                    break;
                }
            }
            if (departmentToUpdate == null) {
                System.out.println("Department ID " + ID + " not found.");
                return;
            }

            System.out.println("Enter Department Name: ");
            String departmentName = sc.next();



            // Update the Course in the Courses list
            departmentToUpdate.setDepartmentName(departmentName);


            System.out.println("UPDATE COMPLETED!");

        }
    }

    @Override
    public void update() throws SQLException {
        try {
            getDatabaseConnection();
            System.out.println("databaseLink = " + databaseLink);
            if (databaseLink == null) {
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your DepartmentName: ");
            String DepartmentName = sc.next();
            System.out.println("Enter your DepartmentID: ");
            int DepartmentID = sc.nextInt();
            System.out.println("Enter your StudentID: ");
            int StudentID = sc.nextInt();


            String sql_query = "UPDATE sis.student " +
                               "SET DepartmentName = ?, DepartmentID = ? " +
                               "WHERE StudentID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            statement.setString(1, DepartmentName);
            statement.setInt(2, DepartmentID);
            statement.setInt(3, StudentID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("INSERTION or Addition COMPLETED!");
            } else {
                System.out.println("Insertion Unsuccessful");
            }

            statement.close();

            // Create a new Student object and add it to the list
            //int ID = getLastInsertedID();
            Department newDepartment= new Department(DepartmentName, DepartmentID);

            if(newDepartment instanceof Department){
                //Student student = (Student)newStudent;
                departmentMap.put(newDepartment.getDepartmentID(),newDepartment);
                //System.out.println("Department Added Successfully!");
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
