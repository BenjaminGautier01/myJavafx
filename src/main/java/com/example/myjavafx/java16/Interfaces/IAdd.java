package com.example.myjavafx.java16.Interfaces;

import com.example.myjavafx.java16.Department.Department;
import com.example.myjavafx.java16.Course.Course;
import com.example.myjavafx.java16.Student.Student;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.SQLException;
import java.util.Map;

public interface IAdd  {

    <T> void add(T object);

    void add() throws SQLException;


    static <T>void addAnyObject(T object ){
        StudentInformationSystem sis = new StudentInformationSystem();
        Map<Integer, Student> studentMap = sis.getStudentMap();
        Map<Integer, Department> departmentMap = sis.getDepartmentMap();
        Map<Integer, Course> courseMap = sis.getCourseMap();
        if(object instanceof Student student){
            studentMap.put(student.getID(), student);
            System.out.println("Student ADDED SUCCESSFULLY! ");
        }
        else if (object instanceof Department department) {
            departmentMap.put(department.getDepartmentID(), department);
            System.out.println("Department ADDED SUCCESSFULLY! ");
        }
        else if (object instanceof Course course) {
            courseMap.put(course.getCourseID(), course);
            System.out.println("Course ADDED SUCCESSFULLY! ");

        }else{
            System.out.println(" ADDED UNSUCCESSFUL! ");

        }

    }


}
