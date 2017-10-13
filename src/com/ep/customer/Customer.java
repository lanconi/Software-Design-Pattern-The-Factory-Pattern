package com.ep.customer;

import com.ep.product.Product;
import com.ep.exception.BadPurchaseException;
import com.ep.exception.PurchaseAmountExceededException;

import java.util.List;

public interface Customer {
	
	public abstract long 	getID();
	
	public abstract String getName();
	
	public abstract double 	getBalance();
	
	public abstract void	addCredit(double credit);
	
	public abstract void 	makePurchase(	Product product )
			throws PurchaseAmountExceededException, BadPurchaseException;
	
	public abstract List<Product> getPurchasedList();
	
	public abstract int	getPurchasedQuantity();
	
	public abstract double getTotalPurchasesAmount();
	
	public abstract double getAveragePurchaseAmount();
	
	public abstract String getMetrics();
	
}
