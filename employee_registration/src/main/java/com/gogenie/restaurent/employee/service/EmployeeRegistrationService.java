package com.gogenie.restaurent.employee.service;

import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeDetails;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;
import com.gogenie.restaurent.employee.model.EmployeeServicesResponse;

public interface EmployeeRegistrationService {

	public EmployeeDetails registerAnEmployee(EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public EmployeeDetails updateAnEmployeeDetails(EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public EmployeeServicesResponse terminateAnEmployee(EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public EmployeeServicesResponse updateEmployeeCredential(EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
}
