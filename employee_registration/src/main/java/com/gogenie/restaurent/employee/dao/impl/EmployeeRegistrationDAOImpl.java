package com.gogenie.restaurent.employee.dao.impl;

import org.springframework.stereotype.Repository;

import com.gogenie.restaurent.employee.dao.EmployeeRegistrationDAO;
import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;

@Repository
public class EmployeeRegistrationDAOImpl implements EmployeeRegistrationDAO {

	public String employeeRegistration(EmployeeRegistrationRequest request) throws EmployeeRegistrationException {
		return "Registered Successfully";
	}

	public String updateEmployeeDetails(EmployeeRegistrationRequest request) throws EmployeeRegistrationException {
		return "Employee Details updated";
	}

	public String terminateAnEmployee(String email) throws EmployeeRegistrationException {
		return "Employee details have been deactiveted";
	}

}
