package com.gogenie.restaurent.registration.dao.impl;

import org.springframework.stereotype.Repository;

import com.gogenie.restaurent.registration.dao.RestaurentRegistraionDAO;
import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;

@Repository
public class RestaurentRegistraionDAOImpl implements RestaurentRegistraionDAO {

	public String registerNewRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateExistingRestaurentDetails(RestaurentRegistrationRequest request)
			throws RestaurentRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}

	public String acivateOrDeactiveARestaurent(Integer restaurentId, String restaurentName, String isActiveFlag)
			throws RestaurentRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}

}
