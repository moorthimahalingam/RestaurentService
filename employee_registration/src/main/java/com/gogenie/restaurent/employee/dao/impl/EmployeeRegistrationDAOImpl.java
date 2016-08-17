package com.gogenie.restaurent.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.gogenie.restaurent.employee.dao.EmployeeRegistrationDAO;
import com.gogenie.restaurent.employee.exception.EmployeeRegistrationException;
import com.gogenie.restaurent.employee.model.EmployeeDetails;
import com.gogenie.restaurent.employee.model.EmployeeRegistrationRequest;
import com.gogenie.restaurent.employee.model.EmployeeServicesResponse;
import com.gogenie.util.service.impl.EncryptionServiceImpl;

@Repository
public class EmployeeRegistrationDAOImpl implements EmployeeRegistrationDAO {

	Logger logger = LoggerFactory.getLogger(EmployeeRegistrationDAOImpl.class);

	@Resource
	private DataSource gogenieDataSource;
	private JdbcTemplate jdbcTemplate;

	private SimpleJdbcCall insertJdbcCall;
	private SimpleJdbcCall updateJdbcCall;
	private SimpleJdbcCall updateCredentialCall;
	

	@PostConstruct
	private void setup() {
		this.jdbcTemplate = new JdbcTemplate(gogenieDataSource);
		this.insertJdbcCall = new SimpleJdbcCall(gogenieDataSource);
		this.updateJdbcCall = new SimpleJdbcCall(gogenieDataSource);
		this.updateCredentialCall = new SimpleJdbcCall(gogenieDataSource);
	}

	public EmployeeDetails employeeRegistration(EmployeeRegistrationRequest request)
			throws EmployeeRegistrationException {
		logger.debug("Entering into employeeRegistration() ");
		EmployeeDetails response = null;
		try {
			String encryptedPassword = new EncryptionServiceImpl().hashedValue(request.getPassword());
			request.setEncryptedPassword(encryptedPassword);
			insertJdbcCall.withProcedureName("post_restaurant_employee").withoutProcedureColumnMetaDataAccess()
					.declareParameters(new SqlParameter("restaurant_id", Types.BIGINT),
							new SqlParameter("employee_name", Types.VARCHAR),
							new SqlParameter("employee_mobilenumber", Types.VARCHAR),
							new SqlParameter("employee_designation", Types.VARCHAR),
							new SqlParameter("username", Types.VARCHAR), new SqlParameter("password", Types.VARCHAR),
							new SqlParameter("emailid", Types.VARCHAR),
							new SqlParameter("is_accountmanager", Types.VARCHAR),
							new SqlParameter("createddate", Types.DATE), new SqlParameter("createdby", Types.VARCHAR),
							new SqlOutParameter("estatus", Types.VARCHAR),
							new SqlOutParameter("sstatus", Types.VARCHAR));

			Map<String, Object> resultSet = insertJdbcCall.execute(employeeRegisterationData(request));
			
			if (resultSet != null) {
				logger.debug("Employee registration result set {} ", resultSet.toString());
				if (resultSet.get("estatus") != null) {
					errorMessageHandler((String)resultSet.get("estatus"));
				}
				response = new EmployeeDetails();
				response.setEmployeeEmailId((String)resultSet.get("sstatus"));
				response.setStatus("Employee has been registered successfully");
			}
		} catch (EmployeeRegistrationException ere) {
			throw ere;
		} catch (Exception e) {
			throw new EmployeeRegistrationException(e, "employeeRegistration");
		}
		logger.debug("Exiting from employeeRegistration() ");
		return response;
	}

	public EmployeeDetails updateEmployeeDetails(EmployeeRegistrationRequest request)
			throws EmployeeRegistrationException {
		logger.debug("Entering into updateEmployeeDetails() ");
		EmployeeDetails response = null;

		try {
			updateJdbcCall.withProcedureName("put_employee_details").withoutProcedureColumnMetaDataAccess()
					.declareParameters();

		} catch (Exception e) {
			throw new EmployeeRegistrationException(e, "234324324");
		}
		logger.debug("Exiting from employeeRegistration() ");

		return response;
	}

	public EmployeeServicesResponse terminateAnEmployee(EmployeeRegistrationRequest request)
			throws EmployeeRegistrationException {
		logger.debug("Entering into terminateAnEmployee() ");
		EmployeeServicesResponse response = null;
		try {
			jdbcTemplate.update("update restaurant_employee set employee_active='N' where emp_id=?",
					new Object[] { request.getEmployeeId() });
			response = new EmployeeServicesResponse();
			response.setEmployeeId(request.getEmployeeId());
			response.setReponseText("Employee details have been deactiveted");
		} catch (Exception e) {
			throw new EmployeeRegistrationException(e, "243940324");
		}
		logger.debug("Exiting from terminateAnEmployee() ");
		return response;
	}

	private Map<String, Object> employeeRegisterationData(EmployeeRegistrationRequest request) {
		logger.debug("Entering into employeeRegisterationData() ");
		Map<String, Object> registerationMap = new HashMap<String, Object>();
		registerationMap.put("restaurant_id", request.getRestaurentId());
		registerationMap.put("employee_name", request.getName());
		registerationMap.put("employee_mobilenumber", request.getMobilenumber());
		registerationMap.put("employee_designation", request.getDesignation());
		registerationMap.put("username", request.getUsername());
		registerationMap.put("password", request.getEncryptedPassword());
		registerationMap.put("emailid", request.getPersonalEmailId());
		registerationMap.put("is_accountmanager", request.getAccountmanagerflag());
		registerationMap.put("createddate", new java.sql.Date(new Date().getTime()));
		registerationMap.put("createdby", "gogenie");
		logger.debug("Exiting from employeeRegisterationData()");
		return registerationMap;
	}

	public EmployeeDetails existingEmployee(String emailId) throws EmployeeRegistrationException {

		logger.debug("Entering into existingCustomer()");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		String employeeName = null;

		try {
			employeeName = jdbcTemplate.query("select EMPLOYEE_NAME from restaurant_employee where emailid=?",
					new Object[] { emailId }, new ResultSetExtractor<String>() {

						public String extractData(ResultSet rs) throws SQLException, DataAccessException {
							String employeeName = null;
							while (rs.next()) {
								employeeName = rs.getString("EMPLOYEE_NAME");
							}
							logger.debug("Employee name {} ", employeeName);
							return employeeName;
						}
					});
			if (employeeName != null) {
				employeeDetails = new EmployeeDetails();
				employeeDetails.setStatus("User is already exist");
				employeeDetails.setEmployeeExist(true);
				employeeDetails.setName(employeeName);
			} else {
				employeeDetails = new EmployeeDetails();
				employeeDetails.setStatus("User doesn't exist");
				employeeDetails.setEmployeeExist(false);
				employeeDetails.setName(null);

			}
		} catch (Exception e) {
			throw new EmployeeRegistrationException(e, "111112");
		}

		logger.debug("Exiting from existingCustomer()");
		return employeeDetails;

	}

	public EmployeeServicesResponse updateEmployeeCredential(EmployeeRegistrationRequest request)
			throws EmployeeRegistrationException {
		logger.debug("Entering into updateEmployeeCredential()");
		EmployeeServicesResponse response = null;
		try {
			updateCredentialCall.withProcedureName("put_restaurant_user_password").withoutProcedureColumnMetaDataAccess()
					.declareParameters(new SqlParameter("restaurant_employee_id", Types.BIGINT),
							new SqlParameter("updateddate", Types.DATE), new SqlParameter("updatedby", Types.BIGINT));
			Map<String, Object> inputData = new HashMap<String, Object>();
			inputData.put("restaurant_employee_id", request.getEmployeeId());
			inputData.put("updateddate", new java.sql.Date(new Date().getTime()));
			inputData.put("updatedby", 123123213);

			response = new EmployeeServicesResponse();
			response.setEmployeeId(request.getEmployeeId());
			response.setReponseText("Employee details updated successfully");

		} catch (Exception e) {
			throw new EmployeeRegistrationException(e, "dskfjasklj");
		}
		logger.debug("Exiting from updateEmployeeCredential()");

		return response;
	}
	
	/**
	 * 
	 * @param errorMessage
	 * @return
	 */
	private void errorMessageHandler(String errorMessage) throws EmployeeRegistrationException {
		String errorMsg[] = errorMessage.split(":");
		EmployeeRegistrationException re = new EmployeeRegistrationException(errorMsg[0], errorMsg[1]);
		throw re;
	}

}
