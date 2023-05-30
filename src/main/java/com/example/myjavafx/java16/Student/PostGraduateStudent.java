package com.example.myjavafx.java16.Student;

import com.example.myjavafx.java16.Interfaces.*;

public class PostGraduateStudent extends Student {
    public PostGraduateStudent(int ID, String firstName, String lastName, String email, String password, String confirmPassword, String dateOfBirth, String gender) {
        super(ID, firstName, lastName, email, password, confirmPassword, dateOfBirth, gender);
        add = new AddStudent();
        show = new ShowStudents();
        update = new UpdateStudent();
        search = new SearchStudent();
        delete = new DeleteStudent();
    }

    public PostGraduateStudent(IAdd add) {super(add);}
    public PostGraduateStudent(IShow show) {super(show);}
    public PostGraduateStudent(IDelete delete) {super(delete);}
    public PostGraduateStudent(IUpdate update) {super(update);}
    public PostGraduateStudent(ISearch search) {super(search);}
}
