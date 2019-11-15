package com.Test.myWebApp_Test;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 

@CrossOrigin(origins="http://18.188.202.13:7000")
@RestController
@RequestMapping(path="/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeDAO employeeDao;
     
    @GetMapping(path="/", produces = "application/json")
    public Employees getEmployees()
    {
        return employeeDao.getAllEmployees();
    }
     
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
    {
        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);
         
        employeeDao.addEmployee(employee);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
    
    @PostMapping(path= "/employees",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Object> addEmployee
    (
@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
@RequestHeader(name = "X-COM-LOCATION", defaultValue = "ASIA") String headerLocation,
@RequestBody Employee employee
)   throws Exception
{      
//Generate resource id
Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
employee.setId(id);
 
//add resource
employeeDao.addEmployee(employee);
 
//Create resource location
URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(employee.getId())
                            .toUri();
 
//Send location in response
return ResponseEntity.created(location).build();
}
}
