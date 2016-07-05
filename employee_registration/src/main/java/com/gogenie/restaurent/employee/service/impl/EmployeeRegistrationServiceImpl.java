package com.gogenie.restaurent.employee.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gogenie.restaurent.employee.dao.EmployeeRegistrationDAO;
import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeDetails;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;
import com.gogenie.restaurent.employee.service.EmployeeRegistrationService;

@Named
@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

	Logger logger = LoggerFactory.getLogger(EmployeeRegistrationServiceImpl.class);
	
	@Inject
	EmployeeRegistrationDAO employeeRegistrationDAO;

	public EmployeeDetails registerAnEmployee(EmployeeRegistrationRequest request) throws EmployeeRegistrationException {
		logger.debug("Entering into registerAnEmployee() ");
		EmployeeDetails response = employeeRegistrationDAO.employeeRegistration(request) ;
		logger.debug("Exiting from registerAnEmployee() ");
		return response;
	}

	public EmployeeDetails updateAnEmployeeDetails(EmployeeRegistrationRequest request) throws EmployeeRegistrationException {
		logger.debug("Entering into updateAnEmployeeDetails() ");
		EmployeeDetails response = employeeRegistrationDAO.updateEmployeeDetails(request);
		logger.debug("Exiting from updateAnEmployeeDetails() ");
		return response;
	}

	public String terminateAnEmployee(String empId) throws EmployeeRegistrationException {
		logger.debug("Entering into terminateAnEmployee() ");
		String response = employeeRegistrationDAO.terminateAnEmployee(empId);
		logger.debug("Exiting from terminateAnEmployee() ");
		return response;
	}
	
}
