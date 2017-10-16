package com.ep.customer;

import com.ep.exception.BadPurchaseException;
import com.ep.exception.PurchaseAmountExceededException;
import com.ep.exception.MalformedCustomerException;
import com.ep.product.Product;

/**
 * 
 * @author Lance Dooley
 *
 */
public class SmallCustomer extends AbstractCustomer {

	/**
	 * Constructor for instantiating a SmallCustomer
	 * @param id long
	 * @param name String
	 * @param balance double
	 * @throws MalformedCustomerException if any parameters are invalid
	 */
	public SmallCustomer(long id, String name, double balance) 
			throws MalformedCustomerException
	{
		if( id == 0  ) {
			throw new MalformedCustomerException("Invalid id for SmallCustomer");
		} else if( name == null ) {
			throw new MalformedCustomerException("Invalid name for SmallCustomer");
		}
		
		this.id = id;	
		this.name = name;
		this.balance = balance;
	}

	@Override
	public void makePurchase(	Product product )
			throws PurchaseAmountExceededException, BadPurchaseException
	{
		// if any of the parameters are bad, then throw BadPurchaseException
		if( product == null ) {
			throw new BadPurchaseException("No Product Was Assigned to Purchase!");
		}
		
		// restrict single purchases to a hard coded ceiling ... soft code this later
		// Note that the max amount is different for different Customer levels
		if( product.getCost() > 10_000d ) {
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
	
}
