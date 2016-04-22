package com.gogenie.restaurent.registration.controller;

import javax.inject.Inject;

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

	@Inject
	RestaurentRegistraionService service;
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerNewRestaurent (@RequestBody RestaurentRegistrationRequest request,
			BindingResult result) throws RestaurentRegistrationException {
		String response = service.registerRestaurent(request);
		return response;
	}
	
	@RequestMapping(value="/updateRestaurentDtl", method=RequestMethod.PUT)
	public String updateRestaurentDetails (@RequestBody RestaurentRegistrationRequest request,
			BindingResult result) throws RestaurentRegistrationException {
		String response = service.updateRestaurentDetails(request);
		return response;
	}

	@RequestMapping(value="/activate", method=RequestMethod.GET)
	public String activateOrDeactivate (@RequestParam (value="restaurentName") String name, 
			@RequestParam (value="active") String isActive) throws RestaurentRegistrationException {
		String response = service.activateAndDeactivateARestaurent(null, name, isActive);
		return response;
	}

	@ExceptionHandler(RestaurentRegistrationException.class)
	public String exceptionHandler(RestaurentRegistrationException exception) {
		return null;
	}
}
