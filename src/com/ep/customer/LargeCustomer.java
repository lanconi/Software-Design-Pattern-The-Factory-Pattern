package com.ep.customer;

import java.text.DecimalFormat;

import com.ep.exception.BadPurchaseException;
import com.ep.exception.PurchaseAmountExceededException;
import com.ep.exception.MalformedCustomerException;
import com.ep.product.Product;

/**
 * 
 * @author Lance Dooley
 *
 */
public class LargeCustomer extends AbstractCustomer {
	
	/**
	 * Constructor for instantiating a LargeCustomer
	 * @param id long
	 * @param name String
	 * @param balance double
	 * @throws MalformedCustomerException if any parameters are invalid
	 */
	public LargeCustomer(long id, String name, double balance) 
				throws MalformedCustomerException
	{
		if( id == 0  ) {
			throw new MalformedCustomerException("Invalid id for LargeCustomer");
		} else if( name == null ) {
			throw new MalformedCustomerException("Invalid name for LargeCustomer");
		}
		this.id = id;	
		this.name = name;
		this.balance = balance;
	}
	
	/**
	 * Use this method on a Customer to have the Customer purchase a Product that was
	 * created using the Product class.
	 * @param product A reference to a Product object
	 * @throws PurchaseAmountExceededException - This Exception is thrown if the cost of the Product exceeds
	 * the Customer balance.
	 * @throws BadPurchaseException - This Exception is thrown if there was a problem with the Product.
	 */
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
}
