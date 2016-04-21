package com.gogenie.restaurent.registration.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"restaurentid",
"restaurentname",
"businessphonenumber",
"emailaddress",
"addressline1",
"addressline2",
"city",
"state",
"zipcode",
"countrycode",
"isactive",
"latitude",
"longitude",
"cusineid",
"restaurentaccount"
})
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurentRegistrationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550230138773905889L;

	@JsonProperty("restaurentid")
	private Integer restaurentid;
	@JsonProperty("restaurentname")
	private String restaurentname;
	@JsonProperty("businessphonenumber")
	private String businessphonenumber;
	@JsonProperty("emailaddress")
	private String emailaddress;
	@JsonProperty("addressline1")
	private String addressline1;
	@JsonProperty("addressline2")
	private String addressline2;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("zipcode")
	private String zipcode;
	@JsonProperty("countrycode")
	private String countrycode;
	@JsonProperty("isactive")
	private String isactive;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("cusineid")
	private Integer cusineid;
	@JsonProperty("restaurentaccount")
	private RestaurentAccount restaurentAccount;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
	 * @return The restaurentname
	 */
	@JsonProperty("restaurentname")
	public String getRestaurentname() {
		return restaurentname;
	}

	/**
	 * 
	 * @param restaurentname
	 *            The restaurentname
	 */
	@JsonProperty("restaurentname")
	public void setRestaurentname(String restaurentname) {
		this.restaurentname = restaurentname;
	}

	/**
	 * 
	 * @return The businessphonenumber
	 */
	@JsonProperty("businessphonenumber")
	public String getBusinessphonenumber() {
		return businessphonenumber;
	}

	/**
	 * 
	 * @param businessphonenumber
	 *            The businessphonenumber
	 */
	@JsonProperty("businessphonenumber")
	public void setBusinessphonenumber(String businessphonenumber) {
		this.businessphonenumber = businessphonenumber;
	}

	/**
	 * 
	 * @return The emailaddress
	 */
	@JsonProperty("emailaddress")
	public String getEmailaddress() {
		return emailaddress;
	}

	/**
	 * 
	 * @param emailaddress
	 *            The emailaddress
	 */
	@JsonProperty("emailaddress")
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	/**
	 * 
	 * @return The addressline1
	 */
	@JsonProperty("addressline1")
	public String getAddressline1() {
		return addressline1;
	}

	/**
	 * 
	 * @param addressline1
	 *            The addressline1
	 */
	@JsonProperty("addressline1")
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	/**
	 * 
	 * @return The addressline2
	 */
	@JsonProperty("addressline2")
	public String getAddressline2() {
		return addressline2;
	}

	/**
	 * 
	 * @param addressline2
	 *            The addressline2
	 */
	@JsonProperty("addressline2")
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	/**
	 * 
	 * @return The city
	 */
	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 *            The city
	 */
	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return The state
	 */
	@JsonProperty("state")
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 *            The state
	 */
	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 * @return The zipcode
	 */
	@JsonProperty("zipcode")
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * 
	 * @param zipcode
	 *            The zipcode
	 */
	@JsonProperty("zipcode")
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * 
	 * @return The countrycode
	 */
	@JsonProperty("countrycode")
	public String getCountrycode() {
		return countrycode;
	}

	/**
	 * 
	 * @param countrycode
	 *            The countrycode
	 */
	@JsonProperty("countrycode")
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	/**
	 * 
	 * @return The isactive
	 */
	@JsonProperty("isactive")
	public String getIsactive() {
		return isactive;
	}

	/**
	 * 
	 * @param isactive
	 *            The isactive
	 */
	@JsonProperty("isactive")
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	/**
	 * 
	 * @return The latitude
	 */
	@JsonProperty("latitude")
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 * @param latitude
	 *            The latitude
	 */
	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 
	 * @return The longitude
	 */
	@JsonProperty("longitude")
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * 
	 * @param longitude
	 *            The longitude
	 */
	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * 
	 * @return The cusineid
	 */
	@JsonProperty("cusineid")
	public Integer getCusineid() {
		return cusineid;
	}

	/**
	 * 
	 * @param cusineid
	 *            The cusineid
	 */
	@JsonProperty("cusineid")
	public void setCusineid(Integer cusineid) {
		this.cusineid = cusineid;
	}

	/**
	 * 
	 * @return The restaurentaccount
	 */
	@JsonProperty("restaurentaccount")
	public RestaurentAccount getRestaurentaccount() {
		return restaurentAccount;
	}

	/**
	 * 
	 * @param restaurentaccount
	 *            The restaurentaccount
	 */
	@JsonProperty("restaurentaccount")
	public void setRestaurentaccount(RestaurentAccount restaurentaccount) {
		this.restaurentAccount = restaurentaccount;
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