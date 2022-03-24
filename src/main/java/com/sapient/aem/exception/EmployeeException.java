package com.sapient.aem.exception;
//custom checked exception
/*
 * SQL Exceptions thrown by the methods of DAO layer will be trapped
 * in Service layer. In the service layer, we convert SQLException to
 * custom exception and throw custom exception to the presentation layer.
 */
public class EmployeeException extends Exception{	
	private static final long serialVersionUID = 1L;


		public EmployeeException() {
			super("Employee Exception");
		}
		
		public EmployeeException(String message) {
			super(message);
		}
		
		
		public EmployeeException(String message, Throwable t) {
			super(message,t);
		}
		
}
