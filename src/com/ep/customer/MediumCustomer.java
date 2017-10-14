package com.ep.customer;

import java.text.DecimalFormat;

import com.ep.exception.BadPurchaseException;
import com.ep.exception.PurchaseAmountExceededException;
import com.ep.exception.MalformedCustomerException;
import com.ep.product.Product;

public class MediumCustomer extends AbstractCustomer {
	
	/**
	 * Constructor for instantiating a MediumCustomer
	 * @param id long
	 * @param name String
	 * @param balance double
	 * @throws MalformedCustomerException if any parameters are invalid
	 */
	public MediumCustomer(long id, String name, double balance) 
				throws MalformedCustomerException
	{
		if( id == 0  ) {
			throw new MalformedCustomerException("Invalid id for MediumCustomer");
		} else if( name == null ) {
			throw new MalformedCustomerException("Invalid name for MediumCustomer");
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
		if( product.getCost() > 25_000d ) {
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
	
	public String getMetrics() {
		StringBuffer sb = new StringBuffer();
		sb.append("ID: " + id + "\n");
		sb.append("Name: " + name + "\n");
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		sb.append("Balance: " + decimalFormat.format(balance) + "\n");
		sb.append("Products Purchased: " + purchasedList.size() + "\n");
		sb.append("Total Purchases: " + decimalFormat.format(getTotalPurchasesAmount())  + "\n");
		sb.append("Average Purchase Amount: " + decimalFormat.format(getAveragePurchaseAmount())  + "\n");
		return sb.toString();
	}

}
