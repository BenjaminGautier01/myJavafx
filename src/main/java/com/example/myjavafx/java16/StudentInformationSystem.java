package com.example.myjavafx.java16;

import com.example.myjavafx.java16.Course.*;
import com.example.myjavafx.java16.Admin.*;
import com.example.myjavafx.java16.ConsoleMenu.Welcome;
import com.example.myjavafx.java16.Department.*;
import com.example.myjavafx.java16.Student.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentInformationSystem {

    public static Map<Integer, Student> studentMap = new HashMap<>();
    public static Map<Integer, Department> departmentMap = new HashMap<Integer, Department>();
    public static Map<Integer, Course> courseMap = new HashMap<Integer, com.example.myjavafx.java16.Course.Course>();
    public static Map<Integer, Admin> adminMap = new HashMap<Integer, Admin>();

    public Map<Integer, Student> getStudentMap() {return studentMap;}
    public Map<Integer, Department> getDepartmentMap() {return departmentMap;}
    public Map<Integer, Course> getCourseMap() {return courseMap;}
    public Map<Integer, Admin> getAdminMap() {return adminMap;}

    public static void main(String[] args) throws Exception {
        Welcome welcome = new Welcome();
        System.out.println("\n=====================================================================================================================================");
        System.out.println("=====================================================================================================================================");

        welcome.welcomeScreen();

        System.out.println("=========================================================================================================================================");
        System.out.println("\n========================================================================================================================================");




    }
}
