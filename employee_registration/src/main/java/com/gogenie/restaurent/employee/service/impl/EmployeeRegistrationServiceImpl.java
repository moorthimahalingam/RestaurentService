package com.gogenie.restaurent.employee.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.gogenie.restaurent.employee.dao.EmployeeRegistrationDAO;
import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;
import com.gogenie.restaurent.employee.service.EmployeeRegistrationService;

@Named
@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

	@Inject
	EmployeeRegistrationDAO employeeRegistrationDAO;

	public String registerAnEmployee(EmployeeRegistrationRequest request) throws EmployeeRegistrationException {
		String response = employeeRegistrationDAO.employeeRegistration(request) ;
		return response;
	}

	public String updateAnEmployeeDetails(EmployeeRegistrationRequest request) throws EmployeeRegistrationException {
		String response = employeeRegistrationDAO.updateEmployeeDetails(request);
		return response;
	}

	public String terminateAnEmployee(String empId) throws EmployeeRegistrationException {
		String response = employeeRegistrationDAO.terminateAnEmployee(empId);
		return response;
	}
	
}
