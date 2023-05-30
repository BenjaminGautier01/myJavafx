package com.example.myjavafx.java16.Student;

public class UnderGraduateStudent extends Student {
    public UnderGraduateStudent(int ID, String firstName, String lastName, String email, String password, String confirmPassword, String dateOfBirth, String gender) {
        super(ID, firstName, lastName, email, password, confirmPassword, dateOfBirth, gender);
        add = new AddStudent();
        show = new ShowStudents();
        update = new UpdateStudent();
        search = new SearchStudent();
        delete = new DeleteStudent();
    }


}
