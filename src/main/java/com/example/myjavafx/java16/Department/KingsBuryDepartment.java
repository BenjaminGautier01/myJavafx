package com.example.myjavafx.java16.Department;


import com.example.myjavafx.java16.Department.*;
import com.example.myjavafx.java16.Interfaces.*;

public class KingsBuryDepartment extends Department {
    public KingsBuryDepartment(String departmentName, int departmentID) {
        super(departmentName, departmentID);
        add =  new AddDepartment();
        show = new ShowDepartments();
        delete = new DeleteDepartment();
        update = new UpdateDepartment();
    }

    public KingsBuryDepartment(IShow show){super(show);}
    public KingsBuryDepartment(IAdd add){super(add);}
    public KingsBuryDepartment(IDelete delete){super(delete);}
    public KingsBuryDepartment(IUpdate update){super(update);}
    public KingsBuryDepartment(ISearch search){super(search);}

}
