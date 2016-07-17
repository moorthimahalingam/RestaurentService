package com.gogenie.restaurent.registration.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class RestaurentRegistrationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550230138773905889L;

	@JsonProperty("restaurant_id")
	private Long restaurentid;
	@JsonProperty("restaurant_name")
	private String restaurentname;
	@JsonProperty("business_phone_number")
	private String businessphonenumber;
	@JsonProperty("email_id")
	private String emailaddress;
	@JsonProperty("address_line_1")
	private String addressline1;
	@JsonProperty("address_line_2")
	private String addressline2;
	@JsonProperty("city")
	private Integer city;
	@JsonProperty("state")
	private Integer state;
	@JsonProperty("zipcode")
	private String zipcode;
	@JsonProperty("countrycode")
	private Integer countrycode;
	@JsonProperty("is_active")
	private String isactive;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("cuisine_id")
	private Integer cusineid;
	@JsonProperty("restaurant_account")
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
	@JsonProperty("min_order_for_delivery")
	private Double minOrderForDelivery;
	@JsonProperty("base_delivery_time")
	private String baseDeliveryTime;

	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
	 * @return The restaurentname
	 */
	@JsonProperty("restaurant_name")
	public String getRestaurentname() {
		return restaurentname;
	}

	/**
	 * 
	 * @param restaurentname
	 *            The restaurentname
	 */
	@JsonProperty("restaurant_name")
	public void setRestaurentname(String restaurentname) {
		this.restaurentname = restaurentname;
	}

	/**
	 * 
	 * @return The businessphonenumber
	 */
	@JsonProperty("business_phone_number")
	public String getBusinessphonenumber() {
		return businessphonenumber;
	}

	/**
	 * 
	 * @param businessphonenumber
	 *            The businessphonenumber
	 */
	@JsonProperty("business_phone_number")
	public void setBusinessphonenumber(String businessphonenumber) {
		this.businessphonenumber = businessphonenumber;
	}

	/**
	 * 
	 * @return The emailaddress
	 */
	@JsonProperty("email_id")
	public String getEmailaddress() {
		return emailaddress;
	}

	/**
	 * 
	 * @param emailaddress
	 *            The emailaddress
	 */
	@JsonProperty("email_id")
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	/**
	 * 
	 * @return The addressline1
	 */
	@JsonProperty("address_line_1")
	public String getAddressline1() {
		return addressline1;
	}

	/**
	 * 
	 * @param addressline1
	 *            The addressline1
	 */
	@JsonProperty("address_line_1")
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	/**
	 * 
	 * @return The addressline2
	 */
	@JsonProperty("address_line_2")
	public String getAddressline2() {
		return addressline2;
	}

	/**
	 * 
	 * @param addressline2
	 *            The addressline2
	 */
	@JsonProperty("address_line_2")
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	/**
	 * 
	 * @return The city
	 */
	@JsonProperty("city")
	public Integer getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 *            The city
	 */
	@JsonProperty("city")
	public void setCity(Integer city) {
		this.city = city;
	}

	/**
	 * 
	 * @return The state
	 */
	@JsonProperty("state")
	public Integer getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 *            The state
	 */
	@JsonProperty("state")
	public void setState(Integer state) {
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
	public Integer getCountrycode() {
		return countrycode;
	}

	/**
	 * 
	 * @param countrycode
	 *            The countrycode
	 */
	@JsonProperty("countrycode")
	public void setCountrycode(Integer countrycode) {
		this.countrycode = countrycode;
	}

	/**
	 * 
	 * @return The isactive
	 */
	@JsonProperty("is_active")
	public String getIsactive() {
		return isactive;
	}

	/**
	 * 
	 * @param isactive
	 *            The isactive
	 */
	@JsonProperty("is_active")
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
	@JsonProperty("cuisine_id")
	public Integer getCusineid() {
		return cusineid;
	}

	/**
	 * 
	 * @param cusineid
	 *            The cusineid
	 */
	@JsonProperty("cuisine_id")
	public void setCusineid(Integer cusineid) {
		this.cusineid = cusineid;
	}

	@JsonProperty("restaurant_account")
	public RestaurentAccount getRestaurentAccount() {
		return restaurentAccount;
	}

	@JsonProperty("restaurant_account")
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

	@JsonProperty("min_order_for_delivery")
	public Double getMinOrderForDelivery() {
		return minOrderForDelivery;
	}

	@JsonProperty("min_order_for_delivery")
	public void setMinOrderForDelivery(Double minOrderForDelivery) {
		this.minOrderForDelivery = minOrderForDelivery;
	}

	@JsonProperty("base_delivery_time")
	public String getBaseDeliveryTime() {
		return baseDeliveryTime;
	}

	@JsonProperty("base_delivery_time")
	public void setBaseDeliveryTime(String baseDeliveryTime) {
		this.baseDeliveryTime = baseDeliveryTime;
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