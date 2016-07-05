package com.gogenie.restaurent.registration.dao.impl;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
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

	Logger logger = LoggerFactory.getLogger(RestaurentRegistraionDAOImpl.class);

	@PostConstruct
	private void setup() {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public String registerNewRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException {
		logger.debug("Entering into registerNewRestaurent () ");
		SimpleJdbcCall simpleJdbcCall = null;
		try {

			simpleJdbcCall = new SimpleJdbcCall(datasource);
			simpleJdbcCall.withProcedureName("post_restaurant").withoutProcedureColumnMetaDataAccess()
					.declareParameters(new SqlParameter("restaurantname", Types.VARCHAR),
							new SqlParameter("businessphone", Types.VARCHAR),
							new SqlParameter("emailid", Types.VARCHAR), new SqlParameter("address1", Types.VARCHAR),
							new SqlParameter("address2", Types.VARCHAR), new SqlParameter("country_id", Types.BIGINT),
							new SqlParameter("state_id", Types.BIGINT), new SqlParameter("city_id", Types.BIGINT),
							new SqlParameter("latitude", Types.DECIMAL), new SqlParameter("longitude", Types.DECIMAL),
							new SqlParameter("cusine_id", Types.BIGINT), new SqlParameter("createddate", Types.DATE),
							new SqlParameter("createdby", Types.BIGINT), new SqlParameter("rating", Types.INTEGER),
							new SqlParameter("pricing_category", Types.INTEGER),
							new SqlParameter("zipcode", Types.VARCHAR), new SqlParameter("landmark", Types.VARCHAR),
							new SqlParameter("delivery_fee", Types.FLOAT),
							new SqlParameter("restaurant_website", Types.VARCHAR),
							new SqlParameter("restaurant_openingtime", Types.VARCHAR),
							new SqlParameter("restaurant_closingtime", Types.VARCHAR),
							new SqlOutParameter("returnRestaurantId", Types.BIGINT),
							new SqlOutParameter("error_status", Types.VARCHAR));
			logger.debug("Begin to register new restaurant {}", request.getRestaurentname());
			Map<String, Object> resultSet = simpleJdbcCall.execute(restaurantDataMap(request));
			logger.debug("After successfully register the restaurant ");
			logger.debug("Resultset details after register the database {}", resultSet.toString());
			Integer restaurantId = (Integer) resultSet.get("restaurant_id");
			RestaurentAccount account = request.getRestaurentAccount();
			logger.debug("Restaurant account details {} ", account);
			if (account != null) {
				logger.debug("Begin to register restaurant account details ");

				request.getRestaurentAccount().setRestaurentid(restaurantId);
				simpleJdbcCall.withProcedureName("post_restaurant_acct").withoutProcedureColumnMetaDataAccess()
						.declareParameters(new SqlParameter("restaurant_id", Types.BIGINT),
								new SqlParameter("bank_acct_type", Types.CHAR),
								new SqlParameter("bank_name", Types.CHAR),
								new SqlParameter("bank_routing_number", Types.VARCHAR),
								new SqlParameter("bank_acct_number", Types.VARCHAR),
								new SqlParameter("bank_acct_holder_nm", Types.VARCHAR),
								new SqlParameter("settlmnt_date", Types.DATE),
								new SqlParameter("billing_st_date", Types.DATE),
								new SqlParameter("billing_end_date", Types.DATE),
								new SqlParameter("createddate", Types.DATE),
								new SqlParameter("createdby", Types.BIGINT),
								new SqlOutParameter("error_status", Types.VARCHAR));
				Map<String, Object> acctResultSet = simpleJdbcCall.execute(restaurantAccountDetailsMap(account));
				logger.debug("Account inserted result set is {} ", acctResultSet.toString());
			}
		} catch (Exception e) {
			throw new RestaurentRegistrationException(e, "registerNewRestaurent");
		} finally {
			simpleJdbcCall = null;
		}

		logger.debug("Exiting from registerNewRestaurent () ");
		return "Restaurent has added successfully";
	}

	public String updateExistingRestaurentDetails(RestaurentRegistrationRequest request)
			throws RestaurentRegistrationException {
		logger.debug("Entering into updateExistingRestaurentDetails () ");
		SimpleJdbcCall simpleJdbcCall = null;
		try {
			simpleJdbcCall = new SimpleJdbcCall(datasource);
			simpleJdbcCall.withProcedureName("put_restaurant_details").withoutProcedureColumnMetaDataAccess()
					.declareParameters(new SqlParameter("restaurant_id", Types.BIGINT),
							new SqlParameter("restaurant_name", Types.VARCHAR),
							new SqlParameter("business_phone", Types.VARCHAR),
							new SqlParameter("emailid", Types.VARCHAR), new SqlParameter("address1", Types.VARCHAR),
							new SqlParameter("address2", Types.VARCHAR),
							new SqlParameter("restaurant_isactive", Types.BIT),
							new SqlParameter("country_id", Types.BIGINT), new SqlParameter("state_id", Types.BIGINT),
							new SqlParameter("city_id", Types.BIGINT), new SqlParameter("latitude", Types.DECIMAL),
							new SqlParameter("longitude", Types.DECIMAL), new SqlParameter("cuisine_id", Types.BIGINT),
							new SqlParameter("rating", Types.INTEGER),
							new SqlParameter("pricing_category", Types.INTEGER),
							new SqlParameter("zipcode", Types.VARCHAR), new SqlParameter("landmark", Types.VARCHAR),
							new SqlParameter("delivery_fee", Types.FLOAT),
							new SqlParameter("restaurant_website", Types.VARCHAR),
							new SqlParameter("updateddate", Types.DATE), new SqlParameter("updatedby", Types.BIGINT),
							new SqlParameter("restaurant_openingtime", Types.VARCHAR),
							new SqlParameter("restaurant_closingtime", Types.VARCHAR));

			logger.debug("Begin to update the restaurant {} details ", request.getRestaurentname());

			Map<String, Object> resultSet = simpleJdbcCall.execute(restaurantUpdatedDataMap(request));

			logger.debug("After successfully updated the restaurant details ");

			logger.debug("Resultset details after register the database {}", resultSet.toString());

		} catch (Exception e) {
			throw new RestaurentRegistrationException(e, "updateExistingRestaurentDetails");
		} finally {
			simpleJdbcCall = null;
		}
		logger.debug("Exiting from updateExistingRestaurentDetails () ");
		return "Restraurent details have been updated successfully";
	}

	public String acivateOrDeactiveARestaurent(Long restaurentId, String restaurentName, String isActiveFlag)
			throws RestaurentRegistrationException {
		logger.debug("Entering into registerNewRestaurent () ");
		try {
			int noOfRowsUpdated = jdbcTemplate.update(
					"update restaurant set RESTAURANT_ISACTIVE=? where RESTAURANT_ID=?",
					new Object[] { isActiveFlag, restaurentId });
			if (noOfRowsUpdated != 1) {
				return "Failed to upadte Restrautent Deactive/Activate flag";
			}
		} catch (Exception e) {
			throw new RestaurentRegistrationException(e, "acivateOrDeactiveARestaurent");
		}

		logger.debug("Exiting from acivateOrDeactiveARestaurent () ");
		return "Restrautent Deactive/Activate flag has been updated";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, Object> restaurantDataMap(RestaurentRegistrationRequest request) {
		logger.debug("Entering into restaurantDataMap () ");
		Map<String, Object> restaurantDataMap = new HashMap<String, Object>();
		restaurantDataMap.put("restaurantname", request.getRestaurentname());
		restaurantDataMap.put("businessphone", request.getBusinessphonenumber());
		restaurantDataMap.put("emailid", request.getEmailaddress());
		restaurantDataMap.put("address1", request.getAddressline1());
		restaurantDataMap.put("address2", request.getAddressline2());
		// restaurantDataMap.put("restaurant_isactive", request.getIsactive());
		restaurantDataMap.put("country_id", request.getCountrycode());
		restaurantDataMap.put("state_id", request.getState());
		restaurantDataMap.put("city_id", request.getCity());
		restaurantDataMap.put("latitude", request.getLatitude());
		restaurantDataMap.put("longitude", request.getLongitude());
		restaurantDataMap.put("cusine_id", request.getCusineid());
		restaurantDataMap.put("rating", request.getRating());
		restaurantDataMap.put("createddate", new java.sql.Date(new Date().getTime()));
		restaurantDataMap.put("createdby", 12321321);
		restaurantDataMap.put("pricing_category", request.getPriceCategory());
		restaurantDataMap.put("zipcode", request.getZipcode());
		restaurantDataMap.put("landmark", request.getLandmark());
		restaurantDataMap.put("delivery_fee", request.getDeliveryFee());
		restaurantDataMap.put("restaurant_website", request.getWebsite());
		restaurantDataMap.put("restaurant_openingtime", request.getOpeningTime());
		restaurantDataMap.put("restaurant_closingtime", request.getClosingTime());
		logger.debug("New restaurant data map {} ", restaurantDataMap.toString());
		logger.debug("Exiting from restaurantDataMap () ");
		return restaurantDataMap;
	}

	private Map<String, Object> restaurantAccountDetailsMap(RestaurentAccount account) {
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
		restaurantAcctMap.put("createdby", 12321321);
		logger.debug("New restaurant Account data map {} ", restaurantAcctMap.toString());
		logger.debug("Exiting from restaurantAccountDetailsMap ()");
		return restaurantAcctMap;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, Object> restaurantUpdatedDataMap(RestaurentRegistrationRequest request) {
		logger.debug("Entering into restaurantUpdatedDataMap () ");
		Map<String, Object> restaurantDataMap = new HashMap<String, Object>();
		restaurantDataMap.put("restaurant_id", request.getRestaurentid());
		restaurantDataMap.put("restaurant_name", request.getRestaurentname());
		restaurantDataMap.put("business_phone", request.getBusinessphonenumber());
		restaurantDataMap.put("emailid", request.getEmailaddress());
		restaurantDataMap.put("address1", request.getAddressline1());
		restaurantDataMap.put("address2", request.getAddressline2());
		restaurantDataMap.put("restaurant_isactive", request.getIsactive());
		restaurantDataMap.put("country_id", request.getCountrycode());
		restaurantDataMap.put("state_id", request.getState());
		restaurantDataMap.put("city_id", request.getCity());
		restaurantDataMap.put("latitude", request.getLatitude());
		restaurantDataMap.put("longitude", request.getLongitude());
		restaurantDataMap.put("cuisine_id", request.getCusineid());
		restaurantDataMap.put("rating", request.getRating());
		restaurantDataMap.put("pricing_category", request.getPriceCategory());
		restaurantDataMap.put("zipcode", request.getZipcode());
		restaurantDataMap.put("landmark", request.getLandmark());
		restaurantDataMap.put("delivery_fee", request.getDeliveryFee());
		restaurantDataMap.put("restaurant_website", request.getWebsite());
		restaurantDataMap.put("updateddate", new java.sql.Date(new Date().getTime()));
		restaurantDataMap.put("updatedby", 12321321);
		restaurantDataMap.put("restaurant_openingtime", request.getOpeningTime());
		restaurantDataMap.put("restaurant_closingtime", request.getClosingTime());
		logger.debug("Updated restaurant data map {} is ", restaurantDataMap.toString());
		logger.debug("Exiting from restaurantUpdatedDataMap () ");
		return restaurantDataMap;
	}
}
