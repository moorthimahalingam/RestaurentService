package com.gogenie.restaurent.employee.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.gogenie.restaurent.employee.dao.EmployeeRegistrationDAO;
import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;
import com.gogenie.util.service.impl.EncryptionServiceImpl;

@Repository
public class EmployeeRegistrationDAOImpl implements EmployeeRegistrationDAO {

	@Resource
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void setup() {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public String employeeRegistration(EmployeeRegistrationRequest request) throws EmployeeRegistrationException {

		try {
			String encryptedPassword = new EncryptionServiceImpl().hashedValue(request.getPassword());
			request.setEncryptedPassword(encryptedPassword);
			SimpleJdbcCall employeeRegisterCall = new SimpleJdbcCall(datasource);
			employeeRegisterCall.withProcedureName("post_restaurant_employee");
			employeeRegisterCall.execute(employeeRegisterationData(request));
		} catch (Exception e) {
			throw new EmployeeRegistrationException(e, "employeeRegistration");
		}
		return "Registered Successfully";
	}

	public String updateEmployeeDetails(EmployeeRegistrationRequest request) throws EmployeeRegistrationException {
		return "Employee Details updated";
	}

	public String terminateAnEmployee(String email) throws EmployeeRegistrationException {
		jdbcTemplate.update("update restaurant_employee set employee_active='Y' where emailid=?", new Object[]{email});
		return "Employee details have been deactiveted";
	}

	private Map<String, Object> employeeRegisterationData(EmployeeRegistrationRequest request) {
		Map<String, Object> registerationMap = new HashMap<String, Object>();
		registerationMap.put("restaurant_id", request.getRestaurentId());
		registerationMap.put("employee_name", request.getName());
		registerationMap.put("employee_mobilenumber", request.getMobilenumber());
		registerationMap.put("employee_designation", request.getDesignation());
		registerationMap.put("username", request.getUsername());
		registerationMap.put("password", request.getEncryptedPassword());
		registerationMap.put("emailid", request.getPersonalEmailId());
		registerationMap.put("is_accountmanager", request.getAccountmanagerflag());
		registerationMap.put("createddate", new Date());
		registerationMap.put("createdby", 12321312);
		return registerationMap;
	}

}
