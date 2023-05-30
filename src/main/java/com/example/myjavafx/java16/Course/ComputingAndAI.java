package com.example.myjavafx.java16.Course;

import com.example.myjavafx.java16.Interfaces.*;

public class ComputingAndAI extends Course {
    public ComputingAndAI(String courseName, int CourseID, String CourseDuration) {
        super(courseName, CourseID, CourseDuration);
    }

    public ComputingAndAI(IShow show) {super(show);}
    public ComputingAndAI(IAdd add) {super(add);}
    public ComputingAndAI(IDelete delete) {super(delete);}
    public ComputingAndAI(IUpdate update) {super(update);}
    public ComputingAndAI(ISearch search) {super(search);}
}
