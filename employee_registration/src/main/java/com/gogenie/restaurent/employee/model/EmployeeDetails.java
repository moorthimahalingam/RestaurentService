package com.gogenie.restaurent.employee.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class EmployeeDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2640313570840388479L;

	@JsonProperty("name")
	private String name;
	@JsonProperty("mobilenumber")
	private String mobilenumber;
	@JsonProperty("designation")
	private String designation;
	@JsonProperty("employeeEmailId")
	private String employeeEmailId;
	@JsonProperty("personalEmailId")
	private String personalEmailId;
	@JsonProperty("username")
	private String username;
	@JsonProperty("accountmanagerflag")
	private String accountmanagerflag;
	@JsonProperty("restaurant_id")
	private Integer restaurantId;
	@JsonProperty("employee_id")
	private Integer employeeId;

	private String encryptedPassword;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The mobilenumber
	 */
	@JsonProperty("mobilenumber")
	public String getMobilenumber() {
		return mobilenumber;
	}

	/**
	 * 
	 * @param mobilenumber
	 *            The mobilenumber
	 */
	@JsonProperty("mobilenumber")
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	/**
	 * 
	 * @return The designation
	 */
	@JsonProperty("designation")
	public String getDesignation() {
		return designation;
	}

	/**
	 * 
	 * @param designation
	 *            The designation
	 */
	@JsonProperty("designation")
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * 
	 * @return The employeeEmailId
	 */
	@JsonProperty("employeeEmailId")
	public String getEmployeeEmailId() {
		return employeeEmailId;
	}

	/**
	 * 
	 * @param employeeEmailId
	 *            The employeeEmailId
	 */
	@JsonProperty("employeeEmailId")
	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}

	/**
	 * 
	 * @return The personalEmailId
	 */
	@JsonProperty("personalEmailId")
	public String getPersonalEmailId() {
		return personalEmailId;
	}

	/**
	 * 
	 * @param personalEmailId
	 *            The personalEmailId
	 */
	@JsonProperty("personalEmailId")
	public void setPersonalEmailId(String personalEmailId) {
		this.personalEmailId = personalEmailId;
	}

	/**
	 * 
	 * @return The username
	 */
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 *            The username
	 */
	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * 
	 * @return The restaurentId
	 */
	@JsonProperty("restaurant_id")
	public Integer getRestaurantId() {
		return restaurantId;
	}

	/**
	 * 
	 * @param restaurentId
	 *            The restaurent_id
	 */
	@JsonProperty("restaurant_id")
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	/**
	 * 
	 * @return The employeeId
	 */
	@JsonProperty("employee_id")
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * 
	 * @param employeeId
	 *            The employee_id
	 */
	@JsonProperty("employee_id")
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonProperty("employee_exist")
	private boolean employeeExist;
	
	@JsonProperty("accountmanagerflag")
	public String getAccountmanagerflag() {
		return accountmanagerflag;
	}

	@JsonProperty("accountmanagerflag")
	public void setAccountmanagerflag(String accountmanagerflag) {
		this.accountmanagerflag = accountmanagerflag;
	}

	@JsonProperty("employee_exist")
	public boolean getEmployeeExist() {
		return employeeExist;
	}

	@JsonProperty("employee_exist")
	public void setEmployeeExist(boolean employeeExist) {
		this.employeeExist = employeeExist;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}