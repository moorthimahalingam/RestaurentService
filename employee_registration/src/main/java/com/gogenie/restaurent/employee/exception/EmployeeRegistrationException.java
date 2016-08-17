package com.gogenie.restaurent.employee.exception;

public class EmployeeRegistrationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4074951255773438898L;

	public EmployeeRegistrationException() {
		super();
	}
	
	public EmployeeRegistrationException(String message) {
		super(message);
	}
	

	public EmployeeRegistrationException(Exception exception) {
		super(exception);
	}

	public EmployeeRegistrationException(Throwable throwable) {
		super(throwable);
	}

	public EmployeeRegistrationException(Exception e , String errorDtl) {
		super(errorDtl,e);
	}

	public EmployeeRegistrationException(Throwable throwable, String errorDtl) {
		super(errorDtl, throwable);
	}

	private String errorCode;
	private String errorDesc;

	public EmployeeRegistrationException(Throwable throwable, String errorDtl, String errCode,
			String errDec) {
		super(errorDtl, throwable);
		this.errorCode = errCode;
		this.errorDesc = errDec;
	}
	
	public EmployeeRegistrationException(Exception exception, String errorDtl, String errCode,
			String errDec) {
		super(errorDtl, exception);
		this.errorCode = errCode;
		this.errorDesc = errDec;
	}
	
	public EmployeeRegistrationException(String errCode, String errDesc) {
		this.errorCode = errCode;
		this.errorDesc = errDesc;
	}
}
