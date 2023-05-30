package com.example.myjavafx.java16.Course;


import com.example.myjavafx.java16.Interfaces.*;
import com.example.myjavafx.java16.StudentInformationSystem;

public  class Course {

    private String CourseName;
    private int CourseID;
    private String CourseDuration;

    protected IShow show;
    protected IAdd add;
    protected IDelete delete;
    protected IUpdate update;
    protected ISearch search;

    StudentInformationSystem sis = new StudentInformationSystem();

    public Course(String courseName, int CourseID, String CourseDuration){
        this.CourseName = courseName;
        this.CourseID = CourseID;
        this.CourseDuration = CourseDuration;
    }

    public Course(IShow show){this.show = show;}
    public Course(IAdd add){this.add = add;}
    public Course(IDelete delete){this.delete = delete;}
    public Course(IUpdate update){this.update = update;}
    public Course(ISearch search){this.search = search;}


    public String printObject() {
        return "Course Name: " + getCourseName() + "\nCourse ID: " + getCourseID()  +"\nCourse Duration: " + getCourseDuration() + "\n";
    }
    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }


    public String getCourseDuration() {
        return CourseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.CourseDuration = courseDuration;
    }
}
