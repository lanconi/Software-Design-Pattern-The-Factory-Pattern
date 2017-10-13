package com.ep.exception;

public class ProductCreationException extends Exception {
	
	public ProductCreationException() {
		super("Product Not Created");
	}
	
	public ProductCreationException(String message) {
		super(message);
	}

}
