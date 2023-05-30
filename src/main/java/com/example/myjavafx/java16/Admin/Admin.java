package com.example.myjavafx.java16.Admin;
import com.example.myjavafx.java16.Interfaces.*;

public class Admin {

    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String dateOfBirth;
    private String gender;
    protected IAdd add;
    protected IShow show;
    protected IDelete delete;
    protected IUpdate update;
    protected ISearch search;

    public Admin(int ID,String firstName, String lastName,String dateOfBirth,String gender,  String email, String password, String confirmPassword ) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;

    }
    public Admin(){}

    public Admin(IAdd add){
        this.add = add;
    }
    public Admin(IShow show){
        this.show = show;
    }
    public Admin(IDelete delete){this.delete = delete;}
    public Admin(IUpdate update){this.update = update;}
    public Admin(ISearch search){this.search = search;}

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

}
