package com.gogenie.restaurent.registration.model;

import java.io.Serializable;
import java.util.Date;
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
//@JsonInclude(Include.NON_EMPTY)
public class RestaurentAccount implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = -4794278710386448639L;
	
	@JsonProperty("accountid")
	private Integer accountid;
	@JsonProperty("restaurant_id")
	private Long restaurentid;
	@JsonProperty("account_type")
	private String accounttype;
	@JsonProperty("bank_name")
	private String bankname;
	@JsonProperty("routing_number")
	private String routingnumber;
	@JsonProperty("account_number")
	private String accountNumber;
	@JsonProperty("account_holder_name")
	private String accountholdername;
	@JsonProperty("settlement_date")
	private Date settlementdate;
	@JsonProperty("billing_statement_date")
	private Date billingstatementdate;
	@JsonProperty("billing_end_date")
	private Date billingenddate;
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
	@JsonProperty("restaurant_id")
	public Long getRestaurentid() {
		return restaurentid;
	}

	/**
	 * 
	 * @param restaurentid
	 *            The restaurentid
	 */
	@JsonProperty("restaurant_id")
	public void setRestaurentid(Long restaurentid) {
		this.restaurentid = restaurentid;
	}

	/**
	 * 
	 * @return The accounttype
	 */
	@JsonProperty("account_type")
	public String getAccounttype() {
		return accounttype;
	}

	/**
	 * 
	 * @param accounttype
	 *            The accounttype
	 */
	@JsonProperty("account_type")
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	/**
	 * 
	 * @return The bankname
	 */
	@JsonProperty("bank_name")
	public String getBankname() {
		return bankname;
	}

	/**
	 * 
	 * @param bankname
	 *            The bankname
	 */
	@JsonProperty("bank_name")
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	/**
	 * 
	 * @return The routingnumber
	 */
	@JsonProperty("routing_number")
	public String getRoutingnumber() {
		return routingnumber;
	}

	/**
	 * 
	 * @param routingnumber
	 *            The routingnumber
	 */
	@JsonProperty("routing_number")
	public void setRoutingnumber(String routingnumber) {
		this.routingnumber = routingnumber;
	}

	/**
	 * 
	 * @return The accountholdername
	 */
	@JsonProperty("account_holder_name")
	public String getAccountholdername() {
		return accountholdername;
	}

	/**
	 * 
	 * @param accountholdername
	 *            The accountholdername
	 */
	@JsonProperty("account_holder_name")
	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}

	/**
	 * 
	 * @return The settlementdate
	 */
	@JsonProperty("settlement_date")
	public Date getSettlementdate() {
		return settlementdate;
	}

	/**
	 * 
	 * @param settlementdate
	 *            The settlementdate
	 */
	@JsonProperty("settlement_date")
	public void setSettlementdate(Date settlementdate) {
		this.settlementdate = settlementdate;
	}

	/**
	 * 
	 * @return The billingstatementdate
	 */
	@JsonProperty("billing_statement_date")
	public Date getBillingstatementdate() {
		return billingstatementdate;
	}

	/**
	 * 
	 * @param billingstatementdate
	 *            The billingstatementdate
	 */
	@JsonProperty("billing_statement_date")
	public void setBillingstatementdate(Date billingstatementdate) {
		this.billingstatementdate = billingstatementdate;
	}

	/**
	 * 
	 * @return The billingenddate
	 */
	@JsonProperty("billing_end_date")
	public Date getBillingenddate() {
		return billingenddate;
	}

	/**
	 * 
	 * @param billingenddate
	 *            The billingenddate
	 */
	@JsonProperty("billing_end_date")
	public void setBillingenddate(Date billingenddate) {
		this.billingenddate = billingenddate;
	}

	@JsonProperty("account_number")
	public String getAccountNumber() {
		return accountNumber;
	}
	@JsonProperty("account_number")
	public void setAccountNumber(String accountNumber) {
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