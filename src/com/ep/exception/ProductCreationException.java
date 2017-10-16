package com.ep.exception;

/**
 * 
 * @author Lance Dooley
 *
 */
public class ProductCreationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProductCreationException() {
		super("Product Not Created");
	}
	
	public ProductCreationException(String message) {
		super(message);
	}

}
