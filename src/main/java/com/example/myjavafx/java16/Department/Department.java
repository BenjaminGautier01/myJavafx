package com.example.myjavafx.java16.Department;

import com.example.myjavafx.java16.Interfaces.*;
//import com.example.myjavafx.java16.Student.Course;
import com.example.myjavafx.java16.Student.Student;
import com.example.myjavafx.java16.StudentInformationSystem;

public  class Department {
    private String departmentName;
    private int departmentID;
    protected IShow show;
    protected IAdd add;
    protected IDelete delete;
    protected IUpdate update;
    protected ISearch search;
    protected Student student;
    int StudentID;

    StudentInformationSystem sis = new StudentInformationSystem();

    public Department(String departmentName, int departmentID){
        this.departmentName = departmentName;
        this.departmentID = departmentID;

    }

    public Department(IShow show){
        this.show = show;
    }
    public Department(IAdd add){
        this.add = add;
    }
    public Department(IDelete delete){this.delete = delete;}
    public Department(IUpdate update){this.update = update;}
    public Department(ISearch search){this.search = search;}




    public String printObject() {
        return "Department Name: " + getDepartmentName() + "\nDepartment ID: " + getDepartmentID() + "\n";
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getStudentID() {
        return StudentID;
    }
    public void setStudentID(int studentID) {this.StudentID = studentID;}
}
