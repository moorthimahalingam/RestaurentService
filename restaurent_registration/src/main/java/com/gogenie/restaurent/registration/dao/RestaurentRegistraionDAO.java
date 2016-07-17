package com.gogenie.restaurent.registration.dao;

import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurantResponse;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;

public interface RestaurentRegistraionDAO {

	public RestaurantResponse registerNewRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;
	
	public RestaurantResponse updateExistingRestaurentDetails(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;
	
	public RestaurantResponse acivateOrDeactiveARestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;
}
