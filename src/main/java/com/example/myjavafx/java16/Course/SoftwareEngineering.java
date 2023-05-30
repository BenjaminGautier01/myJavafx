package com.example.myjavafx.java16.Course;

import com.example.myjavafx.java16.Interfaces.*;

import java.sql.SQLException;

public class SoftwareEngineering extends Course {
    public SoftwareEngineering(String courseName, int CourseID, String CourseDuration) {
        super(courseName, CourseID, CourseDuration);
    }

    public SoftwareEngineering(IShow show) {super(show);}
    public SoftwareEngineering(IAdd add) {super(add);}
    public SoftwareEngineering(IDelete delete) {super(delete);}
    public SoftwareEngineering(IUpdate update) {super(update);}
    public SoftwareEngineering(ISearch search) {super(search);}


}

