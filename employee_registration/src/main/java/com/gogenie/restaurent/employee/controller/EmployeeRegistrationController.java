package com.gogenie.restaurent.employee.controller;

import javax.inject.Inject;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;
import com.gogenie.restaurent.employee.service.EmployeeRegistrationService;

@RestController
public class EmployeeRegistrationController {

	@Inject
	EmployeeRegistrationService service;
	
	@RequestMapping(value="/employee_register", method=RequestMethod.POST)
	public String registerNewEmployee(@RequestBody EmployeeRegistrationRequest request, 
			BindingResult result) throws EmployeeRegistrationException {
			String response = service.registerAnEmployee(request);
		return response;
	}
	
	@RequestMapping(value="/update_employeeDtl", method=RequestMethod.PUT)
	public String updateEmployeeDetails(@RequestBody EmployeeRegistrationRequest request, BindingResult result) throws EmployeeRegistrationException {
		String response = service.updateAnEmployeeDetails(request);
		return response;
	}
	
	@RequestMapping(value="DeactivateAnEmployee", method=RequestMethod.PUT)
	public String deactivateAnEmployee(@RequestParam(value="employee_id") String empId) throws EmployeeRegistrationException {
		String response = service.terminateAnEmployee(empId);
		return response;
	}
	
	@ExceptionHandler(EmployeeRegistrationException.class)
	public String exceptionHandler(EmployeeRegistrationException exception) {
		return null;
	}
}
