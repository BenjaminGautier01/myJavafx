package com.example.myjavafx.java16.Course;

import com.example.myjavafx.java16.Interfaces.*;

public class AlliedHealth extends Course {
    public AlliedHealth(String courseName, int CourseID, String CourseDuration) {
        super(courseName, CourseID, CourseDuration);
    }

    public AlliedHealth(IShow show) {super(show);}
    public AlliedHealth(IAdd add) {super(add);}
    public AlliedHealth(IDelete delete) {super(delete);}
    public AlliedHealth(IUpdate update) {super(update);}
    public AlliedHealth(ISearch search) {super(search);}
}
