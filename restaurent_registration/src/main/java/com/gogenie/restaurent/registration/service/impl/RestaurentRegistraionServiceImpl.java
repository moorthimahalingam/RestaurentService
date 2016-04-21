package com.gogenie.restaurent.registration.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.gogenie.restaurent.registration.dao.RestaurentRegistraionDAO;
import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;
import com.gogenie.restaurent.registration.service.RestaurentRegistraionService;

@Named
@Service
public class RestaurentRegistraionServiceImpl implements RestaurentRegistraionService {
	
	@Inject
	RestaurentRegistraionDAO restaurentRegistraionDAO;

	public String registerRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateRestaurentDetails(RestaurentRegistrationRequest request)
			throws RestaurentRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}


	public String activateAndDeactivateARestaurent(Integer restaurentId, String restaurentName, String isActiveFlag)
			throws RestaurentRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}
}
