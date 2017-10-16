package com.ep.exception;

/**
 * 
 * @author Lance Dooley
 *
 */
public class PurchaseAmountExceededException extends BadPurchaseException {

	private static final long serialVersionUID = 1L;

	public PurchaseAmountExceededException() {
		super("Customer Purchasing Limit Has Been Exceeded!");
	}
	
	public PurchaseAmountExceededException(String message) {
		super(message);
	}
}

