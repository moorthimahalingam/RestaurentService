package com.gogenie.restaurent.registration.dao;

import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;

public interface RestaurentRegistraionDAO {

	public String registerNewRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;
	
	public String updateExistingRestaurentDetails(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;
	
	public String acivateOrDeactiveARestaurent(Integer restaurentId, String restaurentName, String isActiveFlag) throws RestaurentRegistrationException;
}
