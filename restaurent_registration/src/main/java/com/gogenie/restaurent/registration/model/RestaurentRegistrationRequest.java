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
public class RestaurentRegistrationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550230138773905889L;

	@JsonProperty("restaurentid")
	private Long restaurentid;
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
	@JsonProperty("landmark")
	private String landmark;
	
	@JsonProperty("delivery_fee")
	private Double deliveryFee;
	
	@JsonProperty("website")
	private String website;
	
	@JsonProperty("rating")
	private Integer rating;
	
	@JsonProperty("price_category")
	private Integer priceCategory;
	
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The restaurentid
	 */
	@JsonProperty("restaurentid")
	public Long getRestaurentid() {
		return restaurentid;
	}

	/**
	 * 
	 * @param restaurentid
	 *            The restaurentid
	 */
	@JsonProperty("restaurentid")
	public void setRestaurentid(Long restaurentid) {
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

	@JsonProperty("restaurentaccount")
	public RestaurentAccount getRestaurentAccount() {
		return restaurentAccount;
	}

	@JsonProperty("restaurentaccount")
	public void setRestaurentAccount(RestaurentAccount restaurentAccount) {
		this.restaurentAccount = restaurentAccount;
	}

	@JsonProperty("landmark")
	public String getLandmark() {
		return landmark;
	}
	
	@JsonProperty("landmark")
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@JsonProperty("delivery_fee")
	public Double getDeliveryFee() {
		return deliveryFee;
	}

	@JsonProperty("delivery_fee")
	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	@JsonProperty("website")
	public String getWebsite() {
		return website;
	}

	@JsonProperty("website")
	public void setWebsite(String website) {
		this.website = website;
	}
	
	@JsonProperty("rating")
	public Integer getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@JsonProperty("price_category")
	public Integer getPriceCategory() {
		return priceCategory;
	}

	@JsonProperty("price_category")
	public void setPriceCategory(Integer priceCategory) {
		this.priceCategory = priceCategory;
	}
	
	@JsonProperty("opening_time")
	private String openingTime;
	
	@JsonProperty("closing_time")
	private String closingTime;
	
	@JsonProperty("opening_time")
	public String getOpeningTime() {
		return openingTime;
	}

	@JsonProperty("opening_time")
	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	@JsonProperty("closing_time")
	public String getClosingTime() {
		return closingTime;
	}

	@JsonProperty("closing_time")
	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
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