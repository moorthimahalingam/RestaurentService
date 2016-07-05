package com.gogenie.restaurent.registration.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;
import com.gogenie.restaurent.registration.service.RestaurentRegistraionService;

@RestController
public class RestraurentRegistrationController {

	Logger logger = LoggerFactory.getLogger(RestraurentRegistrationController.class);
	@Inject
	RestaurentRegistraionService service;
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerNewRestaurant (@RequestBody RestaurentRegistrationRequest request,
			BindingResult result) throws RestaurentRegistrationException {
		logger.debug("Entering into registerNewRestaurant()");
		String response = service.registerRestaurent(request);
		logger.debug("Exiting from registerNewRestaurant()");
		return response;
	}
	
	@RequestMapping(value="/updateRestaurentDtl", method=RequestMethod.PUT)
	public String updateRestaurentDetails (@RequestBody RestaurentRegistrationRequest request,
			BindingResult result) throws RestaurentRegistrationException {
		logger.debug("Entering into updateRestaurentDetails()");
		String response = service.updateRestaurentDetails(request);
		logger.debug("Exiting from updateRestaurentDetails()");
		return response;
	}

	@RequestMapping(value="/activate", method=RequestMethod.GET)
	public String activateOrDeactivate (@RequestParam (value="restaurant_name") String name, 
			@RequestParam (value="restaurant_id") Long restaurantId,
			@RequestParam (value="active") String isActive) throws RestaurentRegistrationException {
		logger.debug("Entering into activateOrDeactivate()");
		String response = service.activateAndDeactivateARestaurent(restaurantId, name, isActive);
		logger.debug("Exiting from activateOrDeactivate()");
		return response;
	}

	@ExceptionHandler(RestaurentRegistrationException.class)
	public String exceptionHandler(RestaurentRegistrationException exception) {
		return null;
	}
}
