module com.example.myjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.myjavafx to javafx.fxml;
    exports com.example.myjavafx;
    exports com.example.myjavafx.java16.Controllers;
    exports com.example.myjavafx.java16;
    exports com.example.myjavafx.java16.Department;
    exports com.example.myjavafx.java16.Interfaces;
    opens com.example.myjavafx.java16.Controllers to javafx.fxml;
    exports com.example.myjavafx.database;
    opens com.example.myjavafx.database to javafx.fxml;
    opens com.example.myjavafx.java16.Admin to javafx.base;
    exports com.example.myjavafx.java16.Admin;
    opens com.example.myjavafx.java16 to javafx.fxml;
    opens com.example.myjavafx.java16.Student to javafx.base;
    exports com.example.myjavafx.java16.Course;
    exports com.example.myjavafx.java16.Student;





    // other module directives...




}