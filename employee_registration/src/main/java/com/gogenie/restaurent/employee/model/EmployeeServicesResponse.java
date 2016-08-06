package com.gogenie.restaurent.employee.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
//@JsonInclude(Include.NON_EMPTY)
public class EmployeeServicesResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1812188582506756831L;

	@JsonProperty("employee_id")
	private Integer employeeId;
	
	@JsonProperty("employee_first_name")
	private String employeeFirstName;
	
	@JsonProperty("employee_last_name")
	private String employeeLastName;
	
	@JsonProperty("response_text")
	private String reponseText;

	@JsonProperty("employee_id")
	public Integer getEmployeeId() {
		return employeeId;
	}

	@JsonProperty("employee_id")
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@JsonProperty("employee_first_name")
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	@JsonProperty("employee_first_name")
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	@JsonProperty("employee_last_name")
	public String getEmployeeLastName() {
		return employeeLastName;
	}

	@JsonProperty("employee_last_name")
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	@JsonProperty("response_text")
	public String getReponseText() {
		return reponseText;
	}

	@JsonProperty("response_text")
	public void setReponseText(String reponseText) {
		this.reponseText = reponseText;
	}
	
	
}
