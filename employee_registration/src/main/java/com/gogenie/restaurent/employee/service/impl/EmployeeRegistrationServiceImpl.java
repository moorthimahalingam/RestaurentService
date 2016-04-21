package com.gogenie.restaurent.employee.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.gogenie.restaurent.employee.dao.EmployeeRegistrationDAO;
import com.gogenie.restaurent.employee.service.EmployeeRegistrationService;

@Named
@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

	@Inject
	EmployeeRegistrationDAO employeeRegistrationDAO;
	
}
