package com.Test.myWebApp_Test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
 
public class Employees
{
    private List<Employee> employeeList;
     
    public List<Employee> getEmployeeList() {
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
  
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    @JsonBackReference
    @GetMapping(path="/employees", produces = "application/json")
    public Employees getEmployees()
    {
        return new EmployeeDAO().getAllEmployees();
    }
}