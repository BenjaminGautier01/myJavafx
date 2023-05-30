package com.example.myjavafx.java16.Interfaces;
import com.example.myjavafx.java16.Department.Department;
import com.example.myjavafx.java16.Student.Student;
import com.example.myjavafx.java16.StudentInformationSystem;
import com.example.myjavafx.java16.Course.Course;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public interface ISearch {

    void search() throws SQLException;

    static <T> void searchAnyObject(T object) {
        if (object instanceof Department department) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Department> departmentMap = sis.getDepartmentMap();
            try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter Department ID to search: ");
				int departmentId = scanner.nextInt();
				scanner.nextLine(); // consume remaining newline character
				if (departmentMap.containsKey(departmentId)) {
				    Department foundDepartment = departmentMap.get(departmentId);
				    System.out.println("Department found: " + foundDepartment);
				} else {
				    System.out.println("Department not found!");
				}
			}

        }
        else if (object instanceof Course course) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Course> courseMap = sis.getCourseMap();
            try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter Course ID to search: ");
				int courseId = scanner.nextInt();
				scanner.nextLine(); // consume remaining newline character
				if (courseMap.containsKey(courseId)) {
				    com.example.myjavafx.java16.Course.Course foundCourse = courseMap.get(courseId);
				    System.out.println("Department found: " + foundCourse);
				} else {
				    System.out.println("Department not found!");
				}
			}

        }
        else if (object instanceof Student student) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Student> studentMap = sis.getStudentMap();
            try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter student ID to search: ");
				int studentId = scanner.nextInt();
				scanner.nextLine(); // consume remaining newline character
				if (studentMap.containsKey(studentId)) {
				    Student foundStudent = studentMap.get(studentId);
				    System.out.println("Student found: " + foundStudent);
				} else {
				    System.out.println("Student not found!");
				}
			}
        } else {
            System.out.println("Object type not supported for search!");
        }

    }
}
