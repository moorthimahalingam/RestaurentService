package com.gogenie.restaurent.registration.service.util;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;

public class RegisterRestaurantCall extends StoredProcedure {

	Logger logger = LoggerFactory.getLogger(RegisterRestaurantCall.class);

	public static final String INSERT_PROC_NAME = "post_restaurant";

	public RegisterRestaurantCall(DataSource dataSource) {

		super(dataSource, INSERT_PROC_NAME);
		declareParameter(new SqlParameter("restaurantname", Types.VARCHAR));
		declareParameter(new SqlParameter("businessphone", Types.VARCHAR));
		declareParameter(new SqlParameter("emailid", Types.VARCHAR));
		declareParameter(new SqlParameter("address1", Types.VARCHAR));
		declareParameter(new SqlParameter("address2", Types.VARCHAR));
		declareParameter(new SqlParameter("restaurant_isactive", Types.VARCHAR));
		declareParameter(new SqlParameter("country_id", Types.INTEGER));
		declareParameter(new SqlParameter("state_id", Types.INTEGER));
		declareParameter(new SqlParameter("city_id", Types.INTEGER));
		declareParameter(new SqlParameter("latitude", Types.DECIMAL));
		declareParameter(new SqlParameter("longitude", Types.DECIMAL));
		declareParameter(new SqlParameter("cusine_id", Types.BIGINT));
		declareParameter(new SqlParameter("rating", Types.INTEGER));
		declareParameter(new SqlParameter("pricing_category", Types.INTEGER));
		declareParameter(new SqlParameter("zipcode", Types.VARCHAR));
		declareParameter(new SqlParameter("landmark", Types.VARCHAR));
		declareParameter(new SqlParameter("delivery_fee", Types.FLOAT));
		declareParameter(new SqlParameter("restaurant_website", Types.VARCHAR));
		declareParameter(new SqlParameter("createddate", Types.DATE));
		declareParameter(new SqlParameter("createdby", Types.VARCHAR));
		declareParameter(new SqlParameter("restaurant_openingtime", Types.TIME));
		declareParameter(new SqlParameter("restaurant_closingtime", Types.TIME));
		declareParameter(new SqlParameter("minimum_order_val_delivery", Types.FLOAT));
		declareParameter(new SqlParameter("base_delivery_time", Types.TIME));
		declareParameter(new SqlOutParameter("returnRestaurantId", Types.BIGINT));
		declareParameter(new SqlOutParameter("error_status", Types.VARCHAR));
		compile();
		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public Map<String, Object> restaurantDataMap(RestaurentRegistrationRequest request) {
		logger.debug("Entering into restaurantDataMap () ");
		Map<String, Object> restaurantDataMap = new HashMap<String, Object>();
		restaurantDataMap.put("restaurantname", request.getRestaurentname());
		restaurantDataMap.put("businessphone", request.getBusinessphonenumber());
		restaurantDataMap.put("emailid", request.getEmailaddress());
		restaurantDataMap.put("address1", request.getAddressline1());
		restaurantDataMap.put("address2", request.getAddressline2());
		 restaurantDataMap.put("restaurant_isactive", request.getIsactive());
		restaurantDataMap.put("country_id", request.getCountrycode());
		restaurantDataMap.put("state_id", request.getState());
		restaurantDataMap.put("city_id", request.getCity());
		restaurantDataMap.put("latitude", request.getLatitude());
		restaurantDataMap.put("longitude", request.getLongitude());
		restaurantDataMap.put("cusine_id", request.getCusineid());
		restaurantDataMap.put("rating", request.getRating());
		restaurantDataMap.put("pricing_category", request.getPriceCategory());
		restaurantDataMap.put("zipcode", request.getZipcode());
		restaurantDataMap.put("landmark", request.getLandmark());
		restaurantDataMap.put("delivery_fee", request.getDeliveryFee());
		restaurantDataMap.put("restaurant_website", request.getWebsite());
		restaurantDataMap.put("createddate", new java.sql.Date(new Date().getTime()));
		restaurantDataMap.put("createdby", "gogenie");
//		restaurantDataMap.put("restaurant_openingtime", request.getOpeningTime());
		restaurantDataMap.put("restaurant_openingtime", new java.sql.Time(new Date().getTime()));
//		restaurantDataMap.put("restaurant_closingtime", request.getClosingTime());
		restaurantDataMap.put("restaurant_closingtime", new java.sql.Time(new Date().getTime()));
		restaurantDataMap.put("minimum_order_val_delivery", request.getMinOrderForDelivery());
//		restaurantDataMap.put("base_delivery_time", request.getBaseDeliveryTime());
		restaurantDataMap.put("base_delivery_time", new java.sql.Time(new Date().getTime()));
		logger.debug("New restaurant data map {} ", restaurantDataMap.toString());
		Map<String, Object> results = super.execute(restaurantDataMap);
		logger.debug("Exiting from restaurantDataMap () ");
		return results;
	}

}
