package com.example.myjavafx.java16.Department;


import com.example.myjavafx.java16.Department.*;
import com.example.myjavafx.java16.Interfaces.*;

public class SouthallDepartment extends Department {
    public SouthallDepartment(String departmentName, int departmentID) {
        super(departmentName, departmentID);
        add =  new AddDepartment();
        show = new ShowDepartments();
        delete = new DeleteDepartment();
        update = new UpdateDepartment();
    }

    public SouthallDepartment(IShow show){super(show);}
    public SouthallDepartment(IAdd add){super(add);}
    public SouthallDepartment(IDelete delete){super(delete);}
    public SouthallDepartment(IUpdate update){super(update);}
    public SouthallDepartment(ISearch search){super(search);}

}