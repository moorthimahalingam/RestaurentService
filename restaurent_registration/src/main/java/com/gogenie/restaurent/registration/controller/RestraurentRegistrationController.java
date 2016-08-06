package com.gogenie.restaurent.registration.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurantResponse;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;
import com.gogenie.restaurent.registration.service.RestaurentRegistraionService;

@RestController
public class RestraurentRegistrationController {

	Logger logger = LoggerFactory.getLogger(RestraurentRegistrationController.class);
	@Inject
	RestaurentRegistraionService service;
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public RestaurantResponse registerNewRestaurant (@RequestBody RestaurentRegistrationRequest request,
			BindingResult result) throws RestaurentRegistrationException {
		logger.debug("Entering into registerNewRestaurant()");
		RestaurantResponse response = service.registerRestaurent(request);
		logger.debug("Exiting from registerNewRestaurant()");
		return response;
	}
	
	@RequestMapping(value="/updateRestaurantDtl", method=RequestMethod.PUT)
	public RestaurantResponse updateRestaurentDetails (@RequestBody RestaurentRegistrationRequest request,
			BindingResult result) throws RestaurentRegistrationException {
		logger.debug("Entering into updateRestaurentDetails()");
		RestaurantResponse response = service.updateRestaurentDetails(request);
		logger.debug("Exiting from updateRestaurentDetails()");
		return response;
	}

	@RequestMapping(value="/activate", method=RequestMethod.PUT)
	public RestaurantResponse activateOrDeactivate (@RequestBody RestaurentRegistrationRequest request, 
			BindingResult result) throws RestaurentRegistrationException {
		logger.debug("Entering into activateOrDeactivate()");
		RestaurantResponse response = service.activateAndDeactivateARestaurent(request);
		logger.debug("Exiting from activateOrDeactivate()");
		return response;
	}

	
	@ExceptionHandler(RestaurentRegistrationException.class)
	public String exceptionHandler(RestaurentRegistrationException exception) {
		logger.error("Error has occured");
		return null;
	}
}
