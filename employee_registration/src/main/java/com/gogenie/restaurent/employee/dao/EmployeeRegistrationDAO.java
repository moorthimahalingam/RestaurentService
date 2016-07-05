package com.gogenie.restaurent.employee.dao;

import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeDetails;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;

public interface EmployeeRegistrationDAO {
	
	public EmployeeDetails employeeRegistration (EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public EmployeeDetails updateEmployeeDetails (EmployeeRegistrationRequest request) throws EmployeeRegistrationException;
	
	public EmployeeDetails existingEmployee(String emailId) throws EmployeeRegistrationException;
	
	public String terminateAnEmployee (String email) throws EmployeeRegistrationException;

}
