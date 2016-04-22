package com.gogenie.restaurent.employee.dao;

import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;

public interface EmployeeRegistrationDAO {
	
	public String employeeRegistration (EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public String updateEmployeeDetails (EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public String terminateAnEmployee (String email) throws EmployeeRegistrationException;

}
