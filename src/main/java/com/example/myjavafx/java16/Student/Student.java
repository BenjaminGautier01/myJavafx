package com.example.myjavafx.java16.Student;

import com.example.myjavafx.java16.ConsoleMenu.StudentChoice;
import com.example.myjavafx.java16.Interfaces.*;

public class Student {


    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String dateOfBirth;
    private String gender;
    private int CourseID;
    private String CourseName;
    private int DepartmentID;
    private String DepartmentName;
    private String CourseDuration;

    private String StudentName;

    protected IAdd add;
    protected IShow show;
    protected IDelete delete;
    protected IUpdate update;
    protected ISearch search;
    protected StudentChoice studentChoice;

    public Student(int ID, String firstName, String lastName, int CourseID, String CourseName,String CourseDuration, String email) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.CourseDuration = CourseDuration;
        this.email = email;
    }

    public Student(int ID, String firstName, String lastName,String dateOfBirth, String gender,  String email, String password, String confirmPassword  ) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;

    }
    public Student(int ID, String firstName, String lastName, int DepartmentID, String DepartmentName, String email) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DepartmentID = DepartmentID;
        this.DepartmentName = DepartmentName;
        this.email = email;
    }



    public Student(IAdd add){this.add = add;}
    public Student(IShow show){this.show = show;}
    public Student(IDelete delete){this.delete = delete;}
    public Student(IUpdate update){this.update = update;}
    public Student(ISearch search){this.search = search;}


    public String printObject() {
        return "Student ID: " + getID() + "\n" +
                "Name: " + getFirstName() + " " + getLastName() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Date of Birth: " + getDateOfBirth() + "\n" +
                "Gender: " + getGender() + "\n" +
                "Password: " + getPassword() + "\n" +
                "Confirm Password: " + getConfirmPassword();
    }

    public double getGrade() {
        return 0;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getStudentID() {
        return ID;
    }
    public String getStudentName() {
        return StudentName;
    }
    public void setStudentName(String StudentName) {
        StudentName = StudentName;
    }
    public String getDepartmentName() {
        return DepartmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.DepartmentName = departmentName;
    }
    public int getDepartmentID() {
        return DepartmentID;
    }
    public void setDepartmentID(int departmentID) {
        this.DepartmentID = departmentID;
    }
    public String getCourseName() {
        return CourseName;
    }
    public void setCourseName(String courseName) {
        this.CourseName = courseName;
    }
    public int getCourseID() {
        return CourseID;
    }
    public void setCourseID(int courseID) {
        CourseID = courseID;
    }
    public String getCourseDuration(){return CourseDuration;}
    public void setCourseDuration(String CourseDuration) {this.CourseDuration = CourseDuration;}

}
