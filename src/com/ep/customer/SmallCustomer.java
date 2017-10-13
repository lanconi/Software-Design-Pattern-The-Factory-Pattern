package com.ep.customer;

import com.ep.exception.BadPurchaseException;
import com.ep.exception.PurchaseAmountExceededException;
import com.ep.product.Product;

import java.text.DecimalFormat;

public class SmallCustomer extends AbstractCustomer {

	public SmallCustomer(long id, String name, double balance) {
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
