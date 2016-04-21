package com.gogenie.restaurent.registration.controller;

import javax.inject.Inject;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gogenie.customer.fullregistration.exception.CustomerRegistrationException;
import com.gogenie.customer.fullregistration.model.RegistrationRequest;
import com.gogenie.customer.fullregistration.model.RegistrationResponse;
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
		return null;
	}
	
	@RequestMapping(value="/updateRestaurentDtl", method=RequestMethod.PUT)
	public String updateRestaurentDetails (@RequestBody RestaurentRegistrationRequest request,
			BindingResult result) throws RestaurentRegistrationException {
		return null;
	}

	@RequestMapping(value="/activate", method=RequestMethod.GET)
	public String registerNewRestaurent (@RequestParam (value="restaurentName") String name, 
			@RequestParam (value="active") String isActive) throws RestaurentRegistrationException {
		return null;
	}

	@ExceptionHandler(RestaurentRegistrationException.class)
	public String exceptionHandler(RestaurentRegistrationException exception) {
		return null;
	}
}
