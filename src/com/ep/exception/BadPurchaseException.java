package com.ep.exception;

public class BadPurchaseException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BadPurchaseException() { 
		super("Purchase Not Allowed!"); 
	}
	
	public BadPurchaseException(String message) { 
		super(message); 
	}

}
