package com.gogenie.restaurent.registration.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gogenie.restaurent.registration.dao.RestaurentRegistraionDAO;
import com.gogenie.restaurent.registration.exception.RestaurentRegistrationException;
import com.gogenie.restaurent.registration.model.RestaurentRegistrationRequest;
import com.gogenie.restaurent.registration.service.RestaurentRegistraionService;

@Named
@Service
public class RestaurentRegistraionServiceImpl implements RestaurentRegistraionService {

	Logger logger = LoggerFactory.getLogger(RestaurentRegistraionServiceImpl.class);
	
	@Inject
	RestaurentRegistraionDAO restaurentRegistraionDAO;

	public String registerRestaurent(RestaurentRegistrationRequest request) throws RestaurentRegistrationException {
		logger.debug("Entering into registerRestaurent ()");
		String response = restaurentRegistraionDAO.registerNewRestaurent(request);
		logger.debug("Exiting from registerRestaurent ()");
		return response;
	}

	public String updateRestaurentDetails(RestaurentRegistrationRequest request)
			throws RestaurentRegistrationException {
		logger.debug("Entering into updateRestaurentDetails ()");
		String response = restaurentRegistraionDAO.updateExistingRestaurentDetails(request);
		logger.debug("Exiting from updateRestaurentDetails ()");
		return response;
	}

	public String activateAndDeactivateARestaurent(Long restaurentId, String restaurentName, String isActiveFlag)
			throws RestaurentRegistrationException {
		logger.debug("Entering into activateAndDeactivateARestaurent ()");
		String response = restaurentRegistraionDAO.acivateOrDeactiveARestaurent(restaurentId, restaurentName,
				isActiveFlag);
		logger.debug("Exiting from activateAndDeactivateARestaurent ()");
		return response;
	}

}
