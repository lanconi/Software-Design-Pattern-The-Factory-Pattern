package com.ep.exception;

/**
 * 
 * @author Lance Dooley
 *
 */
public class MalformedCustomerException extends Exception {
	private static final long serialVersionUID = 1L;

	public MalformedCustomerException() { 
		super("Customer Not Created!"); 
	}
	
	public MalformedCustomerException(String message) { 
		super(message); 
	}

}
