package com.ep.customer;

import com.ep.product.Product;
import com.ep.exception.BadPurchaseException;
import com.ep.exception.PurchaseAmountExceededException;

import java.util.List;

/**
 * The Customer interface provides a set of methods for accessing or modifying
 * Customer data. A Customer can be created by using the CustomerFactory class.
 * @author Lance Dooley
 */
public interface Customer {
	
	/**
	 * Get the Customer unique ID.
	 * @return long value indicating the Customer unique ID.
	 */
	public abstract long 	getID();
	
	/**
	 * Get the Customer Name, which may or may not be unique to every Customer.
	 * @return String representing the Customer Name.
	 */
	public abstract String getName();
	
	/**
	 * Get the Customer balance.
	 * @return double value representing the Customer balance
	 */
	public abstract double 	getBalance();
	
	/**
	 * Add credit to the Customer, which is not defined as being any particular currency in this
	 * interface.
	 * @param credit A double value.
	 */
	public abstract void	addCredit(double credit);
	
	/**
	 * Use this method on a Customer to have the Customer purchase a Product that was
	 * created using the Product class.
	 * @param product A reference to a Product object
	 * @throws PurchaseAmountExceededException - This Exception is thrown if the cost of the Product exceeds
	 * the Customer balance.
	 * @throws BadPurchaseException - This Exception is thrown if there was a problem with the Product.
	 */
	public abstract void 	makePurchase(	Product product )
			throws PurchaseAmountExceededException, BadPurchaseException;
	
	/**
	 * Get a reference to the List of Products that were purchased by this Customer.
	 * @return {@code List<Product>}
	 */
	public abstract List<Product> getPurchasedList();
	
	/**
	 * Get the number of Products that were purchased by a Customer.
	 * @return int Number of Products purchased by a Customer
	 */
	public abstract int	getPurchasedQuantity();
	
	/**
	 * Get the accumulative amount for all the Products purchased by a Customer.
	 * @return double representing the monetary amount 
	 */
	public abstract double getTotalPurchasesAmount();
	
	/**
	 * Get the statistical average monetary amount for all Product purchases made by this customer.
	 * @return double
	 */
	public abstract double getAveragePurchaseAmount();
	
	/**
	 * Get a newline separated String that shows all the primary values for the fields associated
	 * for a Customer.
	 * @return String
	 */
	public abstract String getMetrics();
	
	// Exand this interface by adding more methods ...
	// public abstract XXXX methodXXX();
	
}
