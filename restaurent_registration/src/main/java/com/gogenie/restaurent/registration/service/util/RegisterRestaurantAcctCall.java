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

import com.gogenie.restaurent.registration.model.RestaurentAccount;

public class RegisterRestaurantAcctCall extends StoredProcedure {

	Logger logger = LoggerFactory.getLogger(RegisterRestaurantAcctCall.class);
	private static final String ACCT_PROC_NAME = "post_restaurant_acct";
	public RegisterRestaurantAcctCall(DataSource dataSource) {
		super(dataSource,ACCT_PROC_NAME);
		declareParameter(new SqlParameter("restaurant_id", Types.BIGINT));
		declareParameter(new SqlParameter("bank_acct_type", Types.CHAR));
		declareParameter(new SqlParameter("bank_name", Types.CHAR));
		declareParameter(new SqlParameter("bank_routing_number", Types.VARCHAR));
		declareParameter(new SqlParameter("bank_acct_number", Types.VARCHAR));
		declareParameter(new SqlParameter("bank_acct_holder_nm", Types.VARCHAR));
		declareParameter(new SqlParameter("settlmnt_date", Types.DATE));
		declareParameter(new SqlParameter("billing_st_date", Types.DATE));
		declareParameter(new SqlParameter("billing_end_date", Types.DATE));
		declareParameter(new SqlParameter("createddate", Types.DATE));
		declareParameter(new SqlParameter("createdby", Types.VARCHAR));
		declareParameter(new SqlOutParameter("error_status", Types.VARCHAR));
		compile();
	}
	
	
	/**
	 * 
	 * @param account
	 * @return
	 */
	public Map<String, Object> restaurantAccountDetailsMap(RestaurentAccount account) {
		logger.debug("Entering into restaurantAccountDetailsMap () ");
		Map<String, Object> restaurantAcctMap = new HashMap<String, Object>();
		restaurantAcctMap.put("restaurant_id", account.getRestaurentid());
		restaurantAcctMap.put("bank_acct_type", account.getAccounttype());
		restaurantAcctMap.put("bank_name", account.getBankname());
		restaurantAcctMap.put("bank_routing_number", account.getRoutingnumber());
		restaurantAcctMap.put("bank_acct_number", account.getAccountNumber());
		restaurantAcctMap.put("bank_acct_holder_nm", account.getAccountholdername());
		restaurantAcctMap.put("settlmnt_date", new java.sql.Date(account.getSettlementdate().getTime()));
		restaurantAcctMap.put("billing_st_date", new java.sql.Date(account.getBillingstatementdate().getTime()));
		restaurantAcctMap.put("billing_end_date", new java.sql.Date(account.getBillingenddate().getTime()));
		restaurantAcctMap.put("createddate", new java.sql.Date(new Date().getTime()));
		restaurantAcctMap.put("createdby", "gogenie");
		logger.debug("New restaurant Account data map {} ", restaurantAcctMap.toString());
		logger.debug("Executing the account register proc ");
		Map<String, Object> result = super.execute(restaurantAcctMap);
		logger.debug("Exiting from restaurantAccountDetailsMap ()");
		return result;
	}
	
}
