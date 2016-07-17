package com.gogenie.restaurent.employee.dao;

import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeDetails;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;
import com.gogenie.restaurent.employee.model.EmployeeServicesResponse;

public interface EmployeeRegistrationDAO {
	
	public EmployeeDetails employeeRegistration (EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public EmployeeDetails updateEmployeeDetails (EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public EmployeeDetails existingEmployee(String emailId) throws EmployeeRegistrationException;
	
	public EmployeeServicesResponse terminateAnEmployee (EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public EmployeeServicesResponse updateEmployeeCredential(EmployeeRegistrationRequest request) throws EmployeeRegistrationException;

}
