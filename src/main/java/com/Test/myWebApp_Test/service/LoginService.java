package com.Test.myWebApp_Test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.myWebApp_Test.Employee;
import com.Test.myWebApp_Test.EmployeeDAO;

@Service
public class LoginService {
	@Autowired
    private EmployeeDAO employeeDao;

	
    public boolean validateUser(String userid, String password) {
        // in28minutes, dummy
    	//System.out.println(employeeDao.getAllEmployees().getEmployeeList());
    	List<Employee> employeeList=employeeDao.getAllEmployees().getEmployeeList();
    	//System.out.println(employeeList.contains("Subha"));
    	System.out.println(employeeList);
    	boolean x=false;
    	for(int i=0; i < employeeList.size(); i++) {
    		//System.out.println("hello");
    	    Employee element = employeeList.get(i);
    	    if((element.getFirstName().equalsIgnoreCase(userid))&&(element.getEmail().equalsIgnoreCase(password)))
    	    {
    	    	x=true;
    	    	break;
    	    }
    	    else
    	    {
    	    	x=false;
    	  
    	    }
    	}
    	//System.out.println(employeeList.contains(o));
        return x;/*userid.equalsIgnoreCase("Subha")
                && password.equalsIgnoreCase("Subha");*/
    }

}
