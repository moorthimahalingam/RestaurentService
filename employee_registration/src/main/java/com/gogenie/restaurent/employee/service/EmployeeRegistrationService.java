package com.gogenie.restaurent.employee.service;

import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeDetails;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;

public interface EmployeeRegistrationService {

	public EmployeeDetails registerAnEmployee(EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public EmployeeDetails updateAnEmployeeDetails(EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public String terminateAnEmployee(String empId) throws EmployeeRegistrationException;
	
	public String updateEmployeeCredential(Long emailId, String password) throws EmployeeRegistrationException;
	
}
