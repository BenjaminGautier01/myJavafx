package com.example.myjavafx.java16.Student;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Interfaces.IDelete;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class DeleteStudent extends DataBaseConnection implements IDelete {

    @Override
    public void delete() throws SQLException {

        getDatabaseConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the student to delete: ");
        int ID = sc.nextInt();

        String sql_query = "DELETE FROM sis.student WHERE StudentID=?";
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);

        statement.setInt(1, ID);
        int rowsAffected = statement.executeUpdate();
        System.out.println(rowsAffected + " row('s) deleted from the database.");

        // Remove the Student object from the list with matching ID

            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Student> studentMap = sis.getStudentMap();

            System.out.println("Student Deleted Successfully!");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            if (entry.getKey() == ID) {
                System.out.println(entry.getKey() + ": " + entry.getValue().printObject() + "\n");
                studentMap.remove(entry.getKey() + ": " + entry.getValue());
                System.out.println("Student with ID " + ID + " removed from the list.");
                System.out.println("Student Deleted Successfully!");
                System.out.println("************************************************************************************************\n");
                //System.out.println("################################################################################################################################");
            }
        }

        statement.close();

    }
        public  <T> void delete(T object) {
        if (object instanceof Student student) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Student> studentMap = sis.getStudentMap();
            studentMap.remove(student.getID());
            System.out.println("Student Deleted Successfully!");}
    }
}
