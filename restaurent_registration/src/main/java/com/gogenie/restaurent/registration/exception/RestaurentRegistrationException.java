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

	public RestaurentRegistrationException(Exception e , String errorDtl) {
		super(errorDtl,e);
	}

	public RestaurentRegistrationException(Throwable throwable, String errorDtl) {
		super(errorDtl, throwable);
	}
	
	private String errorCode;
	private String errorDesc;
	public RestaurentRegistrationException(Throwable throwable, String errorDtl, String errCode,
			String errDec) {
		super(errorDtl, throwable);
		this.errorCode = errCode;
		this.errorDesc = errDec;
	}
	
	public RestaurentRegistrationException(Exception exception, String errorDtl, String errCode,
			String errDec) {
		super(errorDtl, exception);
		this.errorCode = errCode;
		this.errorDesc = errDec;
	}
	
	public RestaurentRegistrationException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorDesc = errorMessage;
	}

	
}
