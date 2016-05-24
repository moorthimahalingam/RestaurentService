package com.gogenie.restaurent.registration.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.gogenie.restaurent.registration.dao.RestaurentRegistraionDAO;
import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurentAccount;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;

@Repository
public class RestaurentRegistraionDAOImpl implements RestaurentRegistraionDAO {

	@Resource
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void setup() {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public String registerNewRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException {
		try {

			SimpleJdbcCall insertRestaurant = new SimpleJdbcCall(datasource);
			insertRestaurant.withProcedureName("post_restaurant");
			Map<String, Object> resultSet = insertRestaurant.execute(restaurantDataMap(request));
			Integer restaurantId = (Integer)resultSet.get("restaurant_id");
			RestaurentAccount account = request.getRestaurentAccount();
			if (account != null) {
				request.getRestaurentAccount().setRestaurentid(restaurantId);
				insertRestaurant.withProcedureName("");
				insertRestaurant.execute(restaurantAccountDetailsMap(account));
			}
		} catch (Exception e) {
			throw new RestaurentRegistrationException(e, "registerNewRestaurent");
		}
		return "Restaurent has added successfully";
	}

	public String updateExistingRestaurentDetails(RestaurentRegistrationRequest request)
			throws RestaurentRegistrationException {
		return "Restraurent details have been updated successfully";
	}

	public String acivateOrDeactiveARestaurent(Integer restaurentId, String restaurentName, String isActiveFlag)
			throws RestaurentRegistrationException {
		int noOfRowsUpdated = jdbcTemplate.update("update restaurant set RESTAURANT_ISACTIVE=? where RESTAURANT_ID=?",
				new Object[] { isActiveFlag, restaurentId });
		if (noOfRowsUpdated != 1) {
			return "Failed to upadte Restrautent Deactive/Activate flag";
		}
		return "Restrautent Deactive/Activate flag has been updated";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, Object> restaurantDataMap(RestaurentRegistrationRequest request) {
		Map<String, Object> restaurantDataMap = new HashMap<String, Object>();
		restaurantDataMap.put("restaurantname", request.getRestaurentname());
		restaurantDataMap.put("businessphone", request.getBusinessphonenumber());
		restaurantDataMap.put("emailid", request.getEmailaddress());
		restaurantDataMap.put("address1", request.getAddressline1());
		restaurantDataMap.put("address2", request.getAddressline2());
		restaurantDataMap.put("restaurant_isactive", request.getIsactive());
		restaurantDataMap.put("country_id", request.getCountrycode());
		restaurantDataMap.put("state_id", request.getState());
		restaurantDataMap.put("rating", "1.5"); // @Todo - Rating
		restaurantDataMap.put("pricing_category", 2);
		restaurantDataMap.put("zipcode", request.getZipcode());
		restaurantDataMap.put("landmark", request.getLandmark());
		restaurantDataMap.put("delivery_fee", request.getDeliveryFee());
		restaurantDataMap.put("restaurant_website", request.getWebsite());
		restaurantDataMap.put("createddate", new Date());
		restaurantDataMap.put("createdby", 12321321);
		return restaurantDataMap;
	}
	
	private Map<String, Object>  restaurantAccountDetailsMap (RestaurentAccount account) {
		Map<String, Object> restaurantAcctMap = new HashMap<String, Object>();
		restaurantAcctMap.put("restaurant_id", account.getRestaurentid());
		restaurantAcctMap.put("bank_acct_type", account.getAccounttype());
		restaurantAcctMap.put("bank_name", account.getBankname());
		restaurantAcctMap.put("bank_routing_number", account.getRoutingnumber());
		restaurantAcctMap.put("bank_acct_number", account.getAccountNumber());
		restaurantAcctMap.put("bank_acct_holder_nm", account.getAccountholdername());
		restaurantAcctMap.put("settlmnt_date", account.getSettlementdate());
		restaurantAcctMap.put("billing_st_date", account.getBillingstatementdate());
		restaurantAcctMap.put("billing_end_date", account.getBillingenddate());
		restaurantAcctMap.put("createddate", new Date());
		restaurantAcctMap.put("createdby", 12321321);
		return restaurantAcctMap;
	}
} 
