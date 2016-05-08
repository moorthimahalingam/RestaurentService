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

	public EmployeeRegistrationException(Exception e , String methodName) {
		super(e);
	}

	public EmployeeRegistrationException(Throwable throwable, String methodName) {
		super(throwable);
	}

}
