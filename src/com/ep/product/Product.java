package com.ep.product;

import com.ep.exception.*;

import java.time.ZonedDateTime;

/**
 * An immutable Class that represents a product that can be sold.
 * @author EP
 *
 */
public final class Product {
	
	private String name;
	private double cost;
	private String vendor;
	private ZonedDateTime   zonedDateTime;
	
	public Product(String name, double cost, String vendor, ZonedDateTime zonedDateTime) 
													throws ProductCreationException {
		if( name == null || cost < 0d || vendor == null ) {
			throw new ProductCreationException();
		}
		
		this.name 	= name;
		this.cost 	= cost;
		this.vendor = vendor;
		this.zonedDateTime 	= zonedDateTime;
	}
	
	// Getters
	public String 			getName() 	{ return name; }
	public double 			getCost() 	{ return cost; }
	public String 			getVendor() { return vendor; }
	public ZonedDateTime	getDate()	{ return zonedDateTime; }


}
