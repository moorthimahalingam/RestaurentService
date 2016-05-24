package com.gogenie.restaurent.employee.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeRegistrationRequest implements Serializable {

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
	@JsonProperty("password")
	private String password;
	@JsonProperty("joiningdate")
	private String joiningdate;
	@JsonProperty("relieveddate")
	private String relieveddate;
	@JsonProperty("accountmanagerflag")
	private String accountmanagerflag;
	@JsonProperty("restaurent_id")
	private Integer restaurentId;
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
	 * @return The password
	 */
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 *            The password
	 */
	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return The joiningdate
	 */
	@JsonProperty("joiningdate")
	public String getJoiningdate() {
		return joiningdate;
	}

	/**
	 * 
	 * @param joiningdate
	 *            The joiningdate
	 */
	@JsonProperty("joiningdate")
	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}

	/**
	 * 
	 * @return The relieveddate
	 */
	@JsonProperty("relieveddate")
	public String getRelieveddate() {
		return relieveddate;
	}

	/**
	 * 
	 * @param relieveddate
	 *            The relieveddate
	 */
	@JsonProperty("relieveddate")
	public void setRelieveddate(String relieveddate) {
		this.relieveddate = relieveddate;
	}

	/**
	 * 
	 * @return The accountmanagerflag
	 */
	@JsonProperty("accountmanagerflag")
	public String getAccountmanagerflag() {
		return accountmanagerflag;
	}

	/**
	 * 
	 * @param accountmanagerflag
	 *            The accountmanagerflag
	 */
	@JsonProperty("accountmanagerflag")
	public void setAccountmanagerflag(String accountmanagerflag) {
		this.accountmanagerflag = accountmanagerflag;
	}

	/**
	 * 
	 * @return The restaurentId
	 */
	@JsonProperty("restaurent_id")
	public Integer getRestaurentId() {
		return restaurentId;
	}

	/**
	 * 
	 * @param restaurentId
	 *            The restaurent_id
	 */
	@JsonProperty("restaurent_id")
	public void setRestaurentId(Integer restaurentId) {
		this.restaurentId = restaurentId;
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
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}