package com.gogenie.restaurent.registration.service;

import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurantResponse;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;

public interface RestaurentRegistraionService {

	public RestaurantResponse registerRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;

	public RestaurantResponse updateRestaurentDetails(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;

	public RestaurantResponse activateAndDeactivateARestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException;

}
