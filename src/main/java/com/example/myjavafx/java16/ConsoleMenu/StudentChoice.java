package com.example.myjavafx.java16.ConsoleMenu;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Student.*;


import java.util.Scanner;


public class StudentChoice extends DataBaseConnection {

    public static Scanner scanner = new Scanner(System.in);
    protected Student student;
    protected ShowStudents showStudents;
    protected AddStudent addStudent;
    protected SearchStudent searchStudent;
    protected DeleteStudent deleteStudent;
    protected UpdateStudent updateStudent;



    public StudentChoice() {
       // Composition
        this.showStudents = new ShowStudents();
        this.searchStudent = new SearchStudent();
        this.updateStudent = new UpdateStudent();
        this.deleteStudent = new DeleteStudent();
        this.addStudent = new AddStudent();


    }
    public void optionList(){
        System.out.println("====================================================================================================================================\n");
        System.out.println("                                           ENTER--->  1  to Show   Student");
        System.out.println("                                           ENTER--->  2  to Add    Student");
        System.out.println("                                           ENTER--->  3  to Delete Student");
        System.out.println("                                           ENTER--->  4  to update Student");
        System.out.println("                                           ENTER--->  5  to Search Student");
        System.out.println("                                           ENTER---> -1  to exit   program");
        System.out.println("====================================================================================================================================\n");

    }
    public  void  studentChoice(){
        int choice = 0;
        while (choice != -1) {
            try {
                if(choice < 0 || choice > 6){
                    System.out.println("Enter the correct choice #!");
                }

                System.out.println("                                                input your number: ");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("You have selected show Student");
                        showStudents.show();
                        optionList();
                    }
                    case 2 -> {
                        System.out.println("You have selected Add Student");
                        addStudent.add();
                        optionList();
                    }
                    case 3 -> {
                        System.out.println("You have selected Delete Student");
                        deleteStudent.delete();
                        optionList();
                    }
                    case 4 -> {
                        System.out.println("You have selected Update Student");
                        updateStudent.update();
                        optionList();
                    }
                    case 5 -> {
                        System.out.println("You have selected Search Student");
                        searchStudent.search();
                        optionList();
                    }
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage() + " Please Enter the number shown on the menu above!");
                break;
            }

            System.out.println("####################################################################################################################################");
            System.out.println("####################################################################################################################################\n");
        }

    }

}
