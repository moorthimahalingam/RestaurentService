package com.gogenie.restaurent.registration.dao.impl;

import org.springframework.stereotype.Repository;

import com.gogenie.restaurent.registration.dao.RestaurentRegistraionDAO;
import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;

@Repository
public class RestaurentRegistraionDAOImpl implements RestaurentRegistraionDAO {

	public String registerNewRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException {
		return "Restaurent has added successfully";
	}

	public String updateExistingRestaurentDetails(RestaurentRegistrationRequest request)
			throws RestaurentRegistrationException {
		return "Restraurent details have been updated successfully";
	}

	public String acivateOrDeactiveARestaurent(Integer restaurentId, String restaurentName, String isActiveFlag)
			throws RestaurentRegistrationException {
		return "Restrautent Deactive/Activate flag has been updated";
	}

}
