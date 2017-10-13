package com.ep.customer;

import com.ep.exception.BadPurchaseException;
import com.ep.exception.PurchaseAmountExceededException;
import com.ep.product.Product;

public class LargeCustomer extends AbstractCustomer {
	
	public LargeCustomer(long id, double balance) {
		this.id = id;		
		this.balance = balance;
	}
	
	public void makePurchase(	Product product )
			throws PurchaseAmountExceededException, BadPurchaseException
	{
		// if any of the parameters are bad, then throw BadPurchaseException
		if( product == null ) {
			throw new BadPurchaseException("No Product Was Assigned to Purchase!");
		}
		
		// if single purchase amount is greater tan 10,000, then disallow the purchase
		// and throw a PurchaseAmountExceededException.
		// Note that the max amount is different for different Customer levels
		if( product.getCost() > 75_000d ) {
			throw new PurchaseAmountExceededException();
		}
		
		// if purchase amount exceeds the current balance, then abort
		if( product.getCost() > balance ) {
			throw new PurchaseAmountExceededException("Purchase Denied, Balance Is Too Low!");
		}
		
		// subtract the purchase amount from the current balance
		balance -= product.getCost();
		
		// Add the product to the List<Product>purchasedList
		purchasedList.add(product);
	}
	
	@Override
	public String getGreeting() {
		return "Welcome First Class Customer " + id + " !";
	}


}
