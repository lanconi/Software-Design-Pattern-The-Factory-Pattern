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
	
	public void addCredit(double credit) {
		balance += credit;
	}

	
	@Override
	public List<Product> getPurchasedList() {
		return purchasedList;
	}
	
	@Override
	public  int	getPurchasedQuantity() {
		return purchasedList.size();
	}
	
	@Override
	public double getTotalPurchasesAmount() {
		double total = 0.0d;
		for( Product product: purchasedList ) {
			double cost = product.getCost();
			total += cost;
		}
		return total;
	}

	@Override
	public double getAveragePurchaseAmount() {
		if( purchasedList.size() == 0 )
			return 0.0d;
		
		return getTotalPurchasesAmount()/getPurchasedQuantity();
	}


}
