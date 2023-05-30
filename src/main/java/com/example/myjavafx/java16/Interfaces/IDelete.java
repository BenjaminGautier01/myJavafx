package com.example.myjavafx.java16.Interfaces;
import com.example.myjavafx.java16.Department.Department;
import com.example.myjavafx.java16.Course.Course;
import com.example.myjavafx.java16.Student.Student;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.SQLException;
import java.util.Map;

public interface IDelete {
    void delete() throws SQLException;

    static  <T> void deleteAnyObject(T object){
        if (object instanceof Department department) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Department> departmentMap = sis.getDepartmentMap();
            departmentMap.remove(department.getDepartmentID());
            System.out.println("Department Deleted Successfully!");
        }
        else if (object instanceof Student student) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Student> studentMap = sis.getStudentMap();
            studentMap.remove(student.getID());
            System.out.println("Student Deleted Successfully!");
        }else if (object instanceof Course course) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Course> courseMap = sis.getCourseMap();
            courseMap.remove(course.getCourseID());
            System.out.println("Course Deleted Successfully!");
        }else{
            System.out.println("Delete UNSuccessfully!");
        }
    }
}
