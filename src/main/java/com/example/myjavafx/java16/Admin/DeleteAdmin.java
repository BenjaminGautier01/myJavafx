package com.example.myjavafx.java16.Admin;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IDelete;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class DeleteAdmin extends DataBaseConnection implements IDelete {

    public  <T> void delete(T object) {
        if (object instanceof Admin admin) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Admin> adminMap = sis.getAdminMap();
            adminMap.remove(admin.getID());
            System.out.println("Admin Deleted Successfully!");}
    }

    @Override
    public void delete() throws SQLException {

        getDatabaseConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the Admin to delete: ");
        int ID = sc.nextInt();

        String sql_query = "DELETE FROM sis.admin WHERE AdminID=?";
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);

        statement.setInt(1, ID);
        int rowsAffected = statement.executeUpdate();
        System.out.println(rowsAffected + " row('s) deleted from the database.");

        // Remove the Student object from the list with matching ID

        StudentInformationSystem sis = new StudentInformationSystem();
        Map<Integer, Admin> adminMap = sis.getAdminMap();

        System.out.println("Admin Deleted Successfully!");
        for (Map.Entry<Integer, Admin> entry : adminMap.entrySet()) {
            if (entry.getKey() == ID) {
                System.out.println(entry.getKey() + ": " + entry.getValue().printObject() + "\n");
                adminMap.remove(entry.getKey() + ": " + entry.getValue());
                System.out.println("Admin with ID " + ID + " removed from the list.");
                System.out.println("Admin Deleted Successfully!");
                System.out.println("************************************************************************************************\n");
                //System.out.println("################################################################################################################################");
            }
        }

        statement.close();

    }
}
