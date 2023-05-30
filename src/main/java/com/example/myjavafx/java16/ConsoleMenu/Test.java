package com.example.myjavafx.java16.ConsoleMenu;

import com.example.myjavafx.java16.Student.ShowStudents;

public class Test {
    protected ShowStudents ss;

    public Test(ShowStudents ss) throws Exception {
        this.ss = ss;
    }

    public void runShow() throws Exception {
        ss.show();
    }
}
