package com.gogenie.restaurent.registration.service.util;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;

public class UpdateRestaurantDetailsCall extends StoredProcedure {
	Logger logger = LoggerFactory.getLogger(UpdateRestaurantDetailsCall.class);

	private static final String UPDATE_PROC_NAME = "put_restaurant_details";

	public UpdateRestaurantDetailsCall(DataSource datasource) {
		super(datasource, UPDATE_PROC_NAME);
		declareParameter(new SqlParameter("res_id", Types.BIGINT));
		declareParameter(new SqlParameter("res_name", Types.VARCHAR));
		declareParameter(new SqlParameter("bui_phone", Types.VARCHAR));
		declareParameter(new SqlParameter("e_mailid", Types.VARCHAR));
		declareParameter(new SqlParameter("add1", Types.VARCHAR));
		declareParameter(new SqlParameter("add2", Types.VARCHAR));
		declareParameter(new SqlParameter("res_isactive", Types.VARCHAR));
		declareParameter(new SqlParameter("cou_id", Types.INTEGER));
		declareParameter(new SqlParameter("st_id", Types.INTEGER));
		declareParameter(new SqlParameter("ci_id", Types.BIGINT));
		declareParameter(new SqlParameter("lat", Types.DECIMAL));
		declareParameter(new SqlParameter("lon", Types.DECIMAL));
		declareParameter(new SqlParameter("cui_id", Types.BIGINT));
		declareParameter(new SqlParameter("rat", Types.INTEGER));
		declareParameter(new SqlParameter("pricing_categ", Types.INTEGER));
		declareParameter(new SqlParameter("zip", Types.VARCHAR));
		declareParameter(new SqlParameter("land_mark", Types.VARCHAR));
		declareParameter(new SqlParameter("del_fee", Types.FLOAT));
		declareParameter(new SqlParameter("res_website", Types.VARCHAR));
		declareParameter(new SqlParameter("up_date", Types.DATE));
		declareParameter(new SqlParameter("up_by", Types.VARCHAR));
		declareParameter(new SqlParameter("res_openingtime", Types.TIME));
		declareParameter(new SqlParameter("res_closingtime", Types.VARCHAR));
		compile();
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public Map<String, Object> restaurantUpdatedDataMap(RestaurentRegistrationRequest request) {
		logger.debug("Entering into restaurantUpdatedDataMap () ");
		Map<String, Object> restaurantDataMap = new HashMap<String, Object>();
		restaurantDataMap.put("res_id", request.getRestaurentid());
		restaurantDataMap.put("res_name", request.getRestaurentname());
		restaurantDataMap.put("bui_phone", request.getBusinessphonenumber());
		restaurantDataMap.put("e_mailid", request.getEmailaddress());
		restaurantDataMap.put("add1", request.getAddressline1());
		restaurantDataMap.put("add2", request.getAddressline2());
		restaurantDataMap.put("res_isactive", request.getIsactive());
		restaurantDataMap.put("cou_id", request.getCountrycode());
		restaurantDataMap.put("st_id", request.getState());
		restaurantDataMap.put("ci_id", request.getCity());
		restaurantDataMap.put("lat", request.getLatitude());
		restaurantDataMap.put("lon", request.getLongitude());
		restaurantDataMap.put("cui_id", request.getCusineid());
		restaurantDataMap.put("rat", request.getRating());
		restaurantDataMap.put("pricing_categ", request.getPriceCategory());
		restaurantDataMap.put("zip", request.getZipcode());
		restaurantDataMap.put("land_mark", request.getLandmark());
		restaurantDataMap.put("del_fee", request.getDeliveryFee());
		restaurantDataMap.put("res_website", request.getWebsite());
		restaurantDataMap.put("up_date", new java.sql.Date(new Date().getTime()));
		restaurantDataMap.put("up_by", "customer");
//		restaurantDataMap.put("res_openingtime", request.getOpeningTime());
//		restaurantDataMap.put("res_closingtime", request.getClosingTime());
		restaurantDataMap.put("res_openingtime", new java.sql.Time(new Date().getTime()));
		restaurantDataMap.put("res_closingtime", new java.sql.Time(new Date().getTime()));
		logger.debug("Updated restaurant data map {} is ", restaurantDataMap.toString());
		logger.debug("Execute the updated procedure ");
		Map<String, Object> result = super.execute(restaurantDataMap);
		logger.debug("Exiting from restaurantUpdatedDataMap () ");
		return result;
	}
}
