package com.gogenie.restaurent.employee.service;

import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;

public interface EmployeeRegistrationService {

	public String registerAnEmployee(EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public String updateAnEmployeeDetails(EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public String terminateAnEmployee(String empId) throws EmployeeRegistrationException;
	
}
