package com.example.myjavafx.java16.Department;

import com.example.myjavafx.java16.Department.*;
import com.example.myjavafx.java16.Interfaces.*;

public class HarrowDepartment extends Department {
    public HarrowDepartment(String departmentName, int departmentID) {
        super(departmentName, departmentID);
        add =  new AddDepartment();
        show = new ShowDepartments();
        delete = new DeleteDepartment();
        update = new UpdateDepartment();
    }

    public HarrowDepartment(IShow show){super(show);}
    public HarrowDepartment(IAdd add){super(add);}
    public HarrowDepartment(IDelete delete){super(delete);}
    public HarrowDepartment(IUpdate update){super(update);}
    public HarrowDepartment(ISearch search){super(search);}

}
