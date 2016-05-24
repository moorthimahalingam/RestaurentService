package com.gogenie.restaurent.registration.exception;

public class RestaurentRegistrationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4074951255773438898L;

	public RestaurentRegistrationException() {
		super();
	}
	
	public RestaurentRegistrationException(String message) {
		super(message);
	}
	

	public RestaurentRegistrationException(Exception exception) {
		super(exception);
	}

	public RestaurentRegistrationException(Throwable throwable) {
		super(throwable);
	}

	public RestaurentRegistrationException(Exception e , String methodName) {
		super(e);
	}

	public RestaurentRegistrationException(Throwable throwable, String methodName) {
		super(throwable);
	}
}
