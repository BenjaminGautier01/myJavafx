package com.example.myjavafx.java16.ConsoleMenu;



import com.example.myjavafx.java16.Admin.*;
import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Student.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminChoices extends DataBaseConnection {

    //public DatabaseAdminCRUDfunctions databaseAdminCRUDfunctions;// Composition instead of inheritance
    protected Admin admin;
    protected ShowAdmins showAdmins;
    protected AddAdmin addAdmin;
    protected SearchAdmin searchAdmin;
    protected DeleteAdmin deleteAdmin;
    protected UpdateAdmin updateAdmin;

    public static Scanner scanner = new Scanner(System.in);

    public AdminChoices() {
       // this.databaseAdminCRUDfunctions = new DatabaseAdminCRUDfunctions(); // Composition instead of inheritance
        this.admin = new Admin();
        // Composition
        this.showAdmins = new ShowAdmins();
        this.searchAdmin = new SearchAdmin();
        this.updateAdmin = new UpdateAdmin();
        this.deleteAdmin = new DeleteAdmin();
        this.addAdmin = new AddAdmin();
    }

    public void optionList(){
        System.out.println("====================================================================================================================================\n");
        System.out.println("                                           ENTER--->  1  to Show   Admin");
        System.out.println("                                           ENTER--->  2  to Add    Admin");
        System.out.println("                                           ENTER--->  3  to Delete Admin");
        System.out.println("                                           ENTER--->  4  to update Admin");
        System.out.println("                                           ENTER--->  5  to Search Admin");
        System.out.println("                                           ENTER---> -1  to exit   program");
        System.out.println("====================================================================================================================================\n");

    }

    public  void  AdminChoice() throws SQLException {
        getDatabaseConnection();
        int choice = 0;
        while (choice != -1) {
            //System.out.println("databaseLink = " + databaseLink);
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
                        System.out.println("You have selected show Admin");
                        showAdmins.show();
                        optionList();
                    }
                    case 2 -> {
                        System.out.println("You have selected Add Admin");
                        addAdmin.add();
                        optionList();
                    }
                    case 3 -> {
                        System.out.println("You have selected Delete Admin");
                       deleteAdmin.delete();
                       optionList();
                    }
                    case 4 -> {
                        System.out.println("You have selected Update Admin");
                        updateAdmin.update();
                        optionList();
                    }
                    case 5 -> {
                        System.out.println("You have selected Search Admin");
                        searchAdmin.search();
                        optionList();
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


