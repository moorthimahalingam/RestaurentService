package com.gogenie.restaurent.registration.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gogenie.restaurent.registration.dao.RestaurentRegistraionDAO;
import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurantResponse;
import com.gogenie.restaurent.registration.model.RestaurentAccount;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;
import com.gogenie.restaurent.registration.service.util.RegisterRestaurantAcctCall;
import com.gogenie.restaurent.registration.service.util.RegisterRestaurantCall;
import com.gogenie.restaurent.registration.service.util.UpdateRestaurantDetailsCall;

@Repository
public class RestaurentRegistraionDAOImpl implements RestaurentRegistraionDAO {

	@Resource
	private DataSource gogenieDataSource;
	private JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(RestaurentRegistraionDAOImpl.class);

	@PostConstruct
	private void setup() {
		this.jdbcTemplate = new JdbcTemplate(gogenieDataSource);
	}

	public RestaurantResponse registerNewRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException {
		logger.debug("Entering into registerNewRestaurent () ");
		RestaurantResponse  response = null;
//		SimpleJdbcCall simpleJdbcCall = null;
		try {

			/*simpleJdbcCall = new SimpleJdbcCall(gogenieDataSource);
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
							new SqlOutParameter("error_status", Types.VARCHAR));*/
			logger.debug("Begin to register new restaurant {}", request.getRestaurentname());
//			Map<String, Object> resultSet = simpleJdbcCall.execute(restaurantDataMap(request));
			RegisterRestaurantCall insertCall = new RegisterRestaurantCall(gogenieDataSource);
			Map<String, Object> resultSet =  insertCall.restaurantDataMap(request);
			logger.debug("After successfully register the restaurant ");
			logger.debug("Resultset details after register the database {}", resultSet.toString());
			List<Map> restaurantResult = (List) resultSet.get("#result-set-1");
			logger.debug("Returned Restaurant insert result is {} ", restaurantResult.toString());
			Long restaurantId = (Long) restaurantResult.get(0).get("returnRestaurantId");
			logger.debug("Restaurant Id is {} ", restaurantId);
			
			RestaurentAccount account = request.getRestaurentAccount();
			logger.debug("Restaurant account details {} ", account);
			if (account != null) {
				logger.debug("Begin to register restaurant account details ");

				account.setRestaurentid(restaurantId);
				/*simpleJdbcCall.withProcedureName("post_restaurant_acct").withoutProcedureColumnMetaDataAccess()
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
								new SqlOutParameter("error_status", Types.VARCHAR));*/
//				Map<String, Object> acctResultSet = simpleJdbcCall.execute(restaurantAccountDetailsMap(account));
				RegisterRestaurantAcctCall insertAcct = new RegisterRestaurantAcctCall(gogenieDataSource);
				Map<String, Object> acctResultSet = insertAcct.restaurantAccountDetailsMap(account);
				logger.debug("Account inserted result set is {} ", acctResultSet.toString());
			}
			response = new RestaurantResponse();
			response.setRestaurantId(restaurantId);
			response.setRestaurantName(request.getRestaurentname());
			response.setRepsonseText("Restaurent has added successfully");
		} catch (Exception e) {
			throw new RestaurentRegistrationException(e, "registerNewRestaurent");
		}
		
		logger.debug("Exiting from registerNewRestaurent () ");
		return response;
	}

	public RestaurantResponse updateExistingRestaurentDetails(RestaurentRegistrationRequest request)
			throws RestaurentRegistrationException {
		logger.debug("Entering into updateExistingRestaurentDetails () ");
		RestaurantResponse response = null;
//		SimpleJdbcCall simpleJdbcCall = null;
		try {
			/*simpleJdbcCall = new SimpleJdbcCall(gogenieDataSource);
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
							new SqlParameter("restaurant_closingtime", Types.VARCHAR));*/

			logger.debug("Begin to update the restaurant {} details ", request.getRestaurentname());

//			Map<String, Object> resultSet = simpleJdbcCall.execute(restaurantUpdatedDataMap(request));
			UpdateRestaurantDetailsCall updateRestaurantDetails = new UpdateRestaurantDetailsCall(gogenieDataSource);
			Map<String, Object> resultSet =  updateRestaurantDetails.restaurantUpdatedDataMap(request);
			logger.debug("After successfully updated the restaurant details ");

			logger.debug("Resultset details after register the database {}", resultSet.toString());
			response = new RestaurantResponse();
			response.setRestaurantId(request.getRestaurentid());
			response.setRepsonseText("Restraurent details have been updated successfully");
		} catch (Exception e) {
			throw new RestaurentRegistrationException(e, "updateExistingRestaurentDetails");
		} 
		logger.debug("Exiting from updateExistingRestaurentDetails () ");
		return response;
	}

	public RestaurantResponse acivateOrDeactiveARestaurent(RestaurentRegistrationRequest request)
			throws RestaurentRegistrationException {
		logger.debug("Entering into registerNewRestaurent () ");
		try {
			Long restaurentId = request.getRestaurentid();
			String isActiveFlag = request.getIsactive();
			jdbcTemplate.update(
					"update restaurant set RESTAURANT_ISACTIVE=? where RESTAURANT_ID=?",
					new Object[] { isActiveFlag, restaurentId });
		} catch (Exception e) {
			throw new RestaurentRegistrationException(e, "acivateOrDeactiveARestaurent");
		}
		RestaurantResponse response = new RestaurantResponse();
		response.setRestaurantId(request.getRestaurentid());
		response.setRepsonseText("Restrautent Deactive/Activate flag has been updated");
		logger.debug("Exiting from acivateOrDeactiveARestaurent () ");
		return response;
	}

	
}
