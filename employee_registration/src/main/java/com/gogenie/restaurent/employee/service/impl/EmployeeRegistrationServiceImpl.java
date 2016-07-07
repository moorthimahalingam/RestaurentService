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
import com.gogenie.util.exceptiom.GoGenieUtilityServiceException;
import com.gogenie.util.service.EncryptionService;
import com.gogenie.util.service.impl.EncryptionServiceImpl;

@Named
@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

	Logger logger = LoggerFactory.getLogger(EmployeeRegistrationServiceImpl.class);
	
	@Inject
	EmployeeRegistrationDAO employeeRegistrationDAO;

	public EmployeeDetails registerAnEmployee(EmployeeRegistrationRequest request) throws EmployeeRegistrationException {
		logger.debug("Entering into registerAnEmployee() ");
		EmployeeDetails employeeDetails = employeeRegistrationDAO.existingEmployee(request.getEmployeeEmailId());
		if (!(employeeDetails != null && employeeDetails.getName() != null)){
			logger.debug("Employee doesn't exist . register as a new user" );
			employeeDetails = employeeRegistrationDAO.employeeRegistration(request) ;
		}
		logger.debug("Exiting from registerAnEmployee() ");
		return employeeDetails;
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

	public String updateEmployeeCredential(Long emailId, String password) throws EmployeeRegistrationException {
		logger.debug("Entering into updateEmployeeCredential()");
		EncryptionService service = new EncryptionServiceImpl();
		String encyptedPassword;
		String repsonse = null;
		try {
			encyptedPassword = service.hashedValue(password);
			repsonse = employeeRegistrationDAO.updateEmployeeCredential(emailId, encyptedPassword);
			logger.debug("Exiting from updateEmployeeCredential()");
		} catch (GoGenieUtilityServiceException e) {
			e.printStackTrace();
			throw new EmployeeRegistrationException(e, "updateEmployeeCredential");
		}
		return repsonse;
	}
	
}
