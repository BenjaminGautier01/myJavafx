package com.example.myjavafx.java16.Department;

import com.example.myjavafx.java16.Department.*;
import com.example.myjavafx.java16.Interfaces.*;

public class LondonDepartment extends Department {
    public LondonDepartment(String departmentName, int departmentID) {
        super(departmentName, departmentID);
        add =  new AddDepartment();
        show = new ShowDepartments();
        delete = new DeleteDepartment();
        update = new UpdateDepartment();
    }

    public LondonDepartment(IShow show){super(show);}
    public LondonDepartment(IAdd add){super(add);}
    public LondonDepartment(IDelete delete){super(delete);}
    public LondonDepartment(IUpdate update){super(update);}
    public LondonDepartment(ISearch search){super(search);}

}
