package com.gogenie.restaurent.registration.service;

import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;

public interface RestaurentRegistraionService {

	public String registerRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;

	public String updateRestaurentDetails(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;

	public String activateAndDeactivateARestaurent(Long restaurentId, String restaurentName, String isActiveFlag)
			throws RestaurentRegistrationException;

}
