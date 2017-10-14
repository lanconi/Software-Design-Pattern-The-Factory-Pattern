package com.ep.product;

import com.ep.exception.*;

import java.time.ZonedDateTime;

/**
 * An immutable Class that represents a product that can be sold.
 * @author EP
 */
public final class Product {
	
	private String name;
	private double cost;
	private String vendor;
	private ZonedDateTime   zonedDateTime;
	
	/**
	 * The constructor for Product, which requires all valid arguments.
	 * @param name String representing the name of the Product
	 * @param cost double representing the monetary value of the Product, cannot be negative.
	 * @param vendor String representing the Vendor who made the Product.
	 * @param zonedDateTime ZonedDateTime for when the Product was created or entered into the system
	 * @throws ProductCreationException Exception will be thrown if any of the Product arguments are invalid
	 */
	public Product(String name, double cost, String vendor, ZonedDateTime zonedDateTime) 
													throws ProductCreationException 
	{
		// check for null values
		if( name == null || cost < 0d || vendor == null ) {
			throw new ProductCreationException();
		}
		
		// check if cost is negative
		if( cost < 0.0d )
			throw new ProductCreationException("cost of Product cannot be negative");
		
		this.name 	= name;
		this.cost 	= cost;
		this.vendor = vendor;
		this.zonedDateTime 	= zonedDateTime;
	}
	
	/**
	 * Get the name of the Product.
	 * @return String
	 */
	public String 			getName() 	{ return name; }
	
	/**
	 * Get the cost of the product.
	 * @return double
	 */
	public double 			getCost() 	{ return cost; }
	
	/**
	 * Get the name representing the Vendor who made the Product.
	 * @return String
	 */
	public String 			getVendor() { return vendor; }
	
	/**
	 * Get the ZonedDateTime object representing when an instance of this Product
	 * was created or entered into the system.
	 * @return ZonedDateTime
	 */
	public ZonedDateTime	getDate()	{ return zonedDateTime; }


}
