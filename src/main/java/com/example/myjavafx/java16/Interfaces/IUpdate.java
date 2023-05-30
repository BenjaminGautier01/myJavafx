package com.example.myjavafx.java16.Interfaces;

import com.example.myjavafx.java16.Department.Department;
import com.example.myjavafx.java16.Student.Student;
import com.example.myjavafx.java16.Course.Course;
import com.example.myjavafx.java16.StudentInformationSystem;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public interface IUpdate {
    void update() throws SQLException;

    static <T> void updateAnyObject(T object) {
        if (object instanceof Department department) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Department> departmentMap = sis.getDepartmentMap();
            if (departmentMap.containsKey(department.getDepartmentID())) {
                try (// Prompt user for new department name and ID
				Scanner scanner = new Scanner(System.in)) {
					System.out.print("Enter new department ID: ");
					int newId = scanner.nextInt();
					System.out.print("Enter new department name: ");
					String newName = scanner.nextLine();

					scanner.nextLine(); // consume remaining newline character
					// Update department properties
					department.setDepartmentName(newName);
					department.setDepartmentID(newId);
				}
                departmentMap.put(department.getDepartmentID(), department);
                System.out.println("Department updated successfully!");


            }
        }
        else  if (object instanceof com.example.myjavafx.java16.Course.Course course) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, com.example.myjavafx.java16.Course.Course> courseMap = sis.getCourseMap();
            if (courseMap.containsKey(course.getCourseID())) {
                try (// Prompt user for new department name and ID
				Scanner scanner = new Scanner(System.in)) {
					System.out.print("Enter new Course name: ");
					String newName = scanner.nextLine();
					System.out.print("Enter new Course ID: ");
					int newId = scanner.nextInt();
					scanner.nextLine(); // consume remaining newline character
					// Update department properties
					course.setCourseName(newName);
					course.setCourseID(newId);
				}
                courseMap.put(course.getCourseID(), course);
                System.out.println("Course updated successfully!");


            }
        }
        else if (object instanceof Student student) {
            StudentInformationSystem sis = new StudentInformationSystem();
            Map<Integer, Student> studentMap = sis.getStudentMap();
            if (studentMap.containsKey(student.getID())) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your Student ID: ");
                int ID = sc.nextInt();

                // Find the student to update in the students list
                Student studentToUpdate = null;
                for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
                    if (entry.getKey() == ID) {
                        studentToUpdate = entry.getValue();
                        break;
                    }
                }
                if (studentToUpdate == null) {
                    System.out.println("Student with ID " + ID + " not found.");
                    return;
                }

                System.out.println("Enter your First Name: ");
                String firstName = sc.next();
                System.out.println("Enter your Last Name: ");
                String lastName = sc.next();
                System.out.println("Enter your Email: ");
                String email = sc.next();
                System.out.println("Enter your password: ");
                String password = sc.next();
                System.out.println("Enter your Confirm Password: ");
                String confirmPassword = sc.next();
                System.out.println("Enter your Date Of Birth: ");
                String dateOfBirth = sc.next();
                System.out.println("Enter your Gender: ");
                String gender = sc.next();


                // Update the student in the students list
                studentToUpdate.setFirstName(firstName);
                studentToUpdate.setLastName(lastName);
                studentToUpdate.setGender(gender);
                studentToUpdate.setDateOfBirth(dateOfBirth);
                studentToUpdate.setEmail(email);
                studentToUpdate.setPassword(password);
                studentToUpdate.setConfirmPassword(confirmPassword);
                System.out.println(" Student UPDATE COMPLETED!");
            }
            else {
                System.out.println("Student not found!");
            }
        }else{
            System.out.println("Updated Unsuccessfully!");
        }

    }
}
