package com.gogenie.restaurent.employee.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeDetails;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;
import com.gogenie.restaurent.employee.service.EmployeeRegistrationService;

@RestController
public class EmployeeRegistrationController {

	Logger logger = LoggerFactory.getLogger(EmployeeRegistrationController.class);
	
	@Inject
	EmployeeRegistrationService service;

	@RequestMapping(value = "/employee_register", method = RequestMethod.POST)
	public EmployeeDetails registerNewEmployee(@RequestBody EmployeeRegistrationRequest request, BindingResult result)
			throws EmployeeRegistrationException {
		logger.debug("Entering into registerNewEmployee()");
		EmployeeDetails employeeDetails = service.registerAnEmployee(request);
		logger.debug("Exiting from registerNewEmployee()");
		return employeeDetails;
	}

	@RequestMapping(value = "/update_employeeDtl", method = RequestMethod.PUT)
	public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeRegistrationRequest request, BindingResult result)
			throws EmployeeRegistrationException {
		logger.debug("Entering into updateEmployeeDetails()");
		EmployeeDetails employeeDetails = service.updateAnEmployeeDetails(request);
		logger.debug("Exiting from updateEmployeeDetails()");
		return employeeDetails;
	}

	@RequestMapping(value="/updatePassword", method=RequestMethod.PUT)
	public String updateEmployeeCredential (@RequestParam (value="employee_id") Long employeeId, 
			@RequestParam (value="password") String password) throws EmployeeRegistrationException {
		logger.debug("Entering into updateEmployeeCredential()");
		String response = service.updateEmployeeCredential(employeeId, password);
		logger.debug("Exiting from updateEmployeeCredential()");
		return response;
	}
	
	
	@RequestMapping(value = "DeactivateAnEmployee", method = RequestMethod.PUT)
	public String deactivateAnEmployee(@RequestParam(value = "employee_id") String empId)
			throws EmployeeRegistrationException {
		logger.debug("Entering into deactivateAnEmployee()");
		String response = service.terminateAnEmployee(empId);
		logger.debug("Exiting from deactivateAnEmployee()");
		return response;
	}

	@ExceptionHandler(EmployeeRegistrationException.class)
	public String exceptionHandler(EmployeeRegistrationException exception) {
		return null;
	}
}
