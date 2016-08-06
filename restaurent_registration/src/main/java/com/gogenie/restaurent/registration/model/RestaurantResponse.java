package com.gogenie.restaurent.registration.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
//@JsonInclude(Include.NON_EMPTY)
public class RestaurantResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6069514094812561085L;

	@JsonProperty("restaurant_id")
	private Long restaurantId;
	@JsonProperty("restaurant_name")
	private String restaurantName;
	@JsonProperty("restaurant_text")
	private String repsonseText;
	
	@JsonProperty("restaurant_id")
	public Long getRestaurantId() {
		return restaurantId;
	}
	
	@JsonProperty("restaurant_id")
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	@JsonProperty("restaurant_name")
	public String getRestaurantName() {
		return restaurantName;
	}
	
	@JsonProperty("restaurant_name")
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	@JsonProperty("restaurant_text")
	public String getRepsonseText() {
		return repsonseText;
	}
	
	@JsonProperty("restaurant_text")
	public void setRepsonseText(String repsonseText) {
		this.repsonseText = repsonseText;
	}
	
	
}
