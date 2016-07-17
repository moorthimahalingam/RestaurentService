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
import com.gogenie.restaurent.employee.model.EmployeeServicesResponse;
import com.gogenie.restaurent.employee.service.EmployeeRegistrationService;

@RestController
public class EmployeeRegistrationController {

	Logger logger = LoggerFactory.getLogger(EmployeeRegistrationController.class);
	
	@Inject
	EmployeeRegistrationService service;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public EmployeeDetails registerNewEmployee(@RequestBody EmployeeRegistrationRequest request, BindingResult result)
			throws EmployeeRegistrationException {
		logger.debug("Entering into registerNewEmployee()");
		EmployeeDetails employeeDetails = service.registerAnEmployee(request);
		logger.debug("Exiting from registerNewEmployee()");
		return employeeDetails;
	}

	@RequestMapping(value = "/update_detail", method = RequestMethod.PUT)
	public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeRegistrationRequest request, BindingResult result)
			throws EmployeeRegistrationException {
		logger.debug("Entering into updateEmployeeDetails()");
		EmployeeDetails employeeDetails = service.updateAnEmployeeDetails(request);
		logger.debug("Exiting from updateEmployeeDetails()");
		return employeeDetails;
	}

	@RequestMapping(value="/update_credential", method=RequestMethod.PUT)
	public EmployeeServicesResponse updateEmployeeCredential (@RequestBody EmployeeRegistrationRequest request, BindingResult result) throws EmployeeRegistrationException {
		logger.debug("Entering into updateEmployeeCredential()");
		EmployeeServicesResponse response = service.updateEmployeeCredential(request);
		logger.debug("Exiting from updateEmployeeCredential()");
		return response;
	}
	
	
	@RequestMapping(value = "/deactivate_an_employee", method = RequestMethod.PUT)
	public EmployeeServicesResponse deactivateAnEmployee(@RequestBody EmployeeRegistrationRequest request, BindingResult result)
			throws EmployeeRegistrationException {
		logger.debug("Entering into deactivateAnEmployee()");
		EmployeeServicesResponse response = service.terminateAnEmployee(request);
		logger.debug("Exiting from deactivateAnEmployee()");
		return response;
	}

	@ExceptionHandler(EmployeeRegistrationException.class)
	public String exceptionHandler(EmployeeRegistrationException exception) {
		return null;
	}
}
