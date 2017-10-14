package com.ep.exception;

/**
 * 
 * @author EP
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
