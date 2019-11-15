package com.Test.myWebApp_Test;

import org.springframework.stereotype.Repository;


 
@Repository
public class EmployeeDAO
{
     static Employees list = new Employees();
     
    static
    {
        list.getEmployeeList().add(new Employee(1, "Dharani", "Kris", "dharanidharkrish@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Sai", "Tej", "saitej123@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "Mani", "kanta", "manikanta123@gmail.com"));
        list.getEmployeeList().add(new Employee(4, "Aman", "Roy", "aman123@gmail.com"));
    }
     
    public Employees getAllEmployees()
    {
        return list;
    }
     
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
