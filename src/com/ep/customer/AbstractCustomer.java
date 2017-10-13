package com.ep.customer;

import java.util.ArrayList;
import java.util.List;

import com.ep.product.Product;

public abstract class AbstractCustomer implements Customer {
	// member variable to hold the customer's ID
	protected long id;
	
	// member variable to hold the customer's balance.
	protected double balance = 0d;
	
	// The List of Purchased objects
	protected List<Product> purchasedList = new ArrayList<>();
	
	@Override
	public long getID() {
		return id;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}
	
	@Override
	public List<Product> getPurchased() {
		return purchasedList;
	}

}
