package com.example.myjavafx.java16.Department;

import com.example.myjavafx.java16.Department.*;
import com.example.myjavafx.java16.Interfaces.*;

public class WembleyDepartment extends Department {
    public WembleyDepartment(String departmentName, int departmentID) {
        super(departmentName, departmentID);
        add =  new AddDepartment();
        show = new ShowDepartments();
        delete = new DeleteDepartment();
        update = new UpdateDepartment();
    }

    public WembleyDepartment(IShow show){super(show);}
    public WembleyDepartment(IAdd add){super(add);}
    public WembleyDepartment(IDelete delete){super(delete);}
    public WembleyDepartment(IUpdate update){super(update);}
    public WembleyDepartment(ISearch search){super(search);}

}