package com.gogenie.restaurent.registration.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurentAccount implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = -4794278710386448639L;
	
	@JsonProperty("accountid")
	private Integer accountid;
	@JsonProperty("restaurentid")
	private Integer restaurentid;
	@JsonProperty("accounttype")
	private String accounttype;
	@JsonProperty("bankname")
	private String bankname;
	@JsonProperty("routingnumber")
	private Integer routingnumber;
	@JsonProperty("account_number")
	private Integer accountNumber;
	@JsonProperty("accountholdername")
	private String accountholdername;
	@JsonProperty("settlementdate")
	private String settlementdate;
	@JsonProperty("billingstatementdate")
	private String billingstatementdate;
	@JsonProperty("billingenddate")
	private String billingenddate;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The accountid
	 */
	@JsonProperty("accountid")
	public Integer getAccountid() {
		return accountid;
	}

	/**
	 * 
	 * @param accountid
	 *            The accountid
	 */
	@JsonProperty("accountid")
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	/**
	 * 
	 * @return The restaurentid
	 */
	@JsonProperty("restaurentid")
	public Integer getRestaurentid() {
		return restaurentid;
	}

	/**
	 * 
	 * @param restaurentid
	 *            The restaurentid
	 */
	@JsonProperty("restaurentid")
	public void setRestaurentid(Integer restaurentid) {
		this.restaurentid = restaurentid;
	}

	/**
	 * 
	 * @return The accounttype
	 */
	@JsonProperty("accounttype")
	public String getAccounttype() {
		return accounttype;
	}

	/**
	 * 
	 * @param accounttype
	 *            The accounttype
	 */
	@JsonProperty("accounttype")
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	/**
	 * 
	 * @return The bankname
	 */
	@JsonProperty("bankname")
	public String getBankname() {
		return bankname;
	}

	/**
	 * 
	 * @param bankname
	 *            The bankname
	 */
	@JsonProperty("bankname")
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	/**
	 * 
	 * @return The routingnumber
	 */
	@JsonProperty("routingnumber")
	public Integer getRoutingnumber() {
		return routingnumber;
	}

	/**
	 * 
	 * @param routingnumber
	 *            The routingnumber
	 */
	@JsonProperty("routingnumber")
	public void setRoutingnumber(Integer routingnumber) {
		this.routingnumber = routingnumber;
	}

	/**
	 * 
	 * @return The accountholdername
	 */
	@JsonProperty("accountholdername")
	public String getAccountholdername() {
		return accountholdername;
	}

	/**
	 * 
	 * @param accountholdername
	 *            The accountholdername
	 */
	@JsonProperty("accountholdername")
	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}

	/**
	 * 
	 * @return The settlementdate
	 */
	@JsonProperty("settlementdate")
	public String getSettlementdate() {
		return settlementdate;
	}

	/**
	 * 
	 * @param settlementdate
	 *            The settlementdate
	 */
	@JsonProperty("settlementdate")
	public void setSettlementdate(String settlementdate) {
		this.settlementdate = settlementdate;
	}

	/**
	 * 
	 * @return The billingstatementdate
	 */
	@JsonProperty("billingstatementdate")
	public String getBillingstatementdate() {
		return billingstatementdate;
	}

	/**
	 * 
	 * @param billingstatementdate
	 *            The billingstatementdate
	 */
	@JsonProperty("billingstatementdate")
	public void setBillingstatementdate(String billingstatementdate) {
		this.billingstatementdate = billingstatementdate;
	}

	/**
	 * 
	 * @return The billingenddate
	 */
	@JsonProperty("billingenddate")
	public String getBillingenddate() {
		return billingenddate;
	}

	/**
	 * 
	 * @param billingenddate
	 *            The billingenddate
	 */
	@JsonProperty("billingenddate")
	public void setBillingenddate(String billingenddate) {
		this.billingenddate = billingenddate;
	}

	@JsonProperty("account_number")
	public Integer getAccountNumber() {
		return accountNumber;
	}
	@JsonProperty("account_number")
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
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