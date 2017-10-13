package com.ep.product;

import com.ep.exception.*;

/**
 * An immutable Class that represents a product that can be sold.
 * @author EP
 *
 */
public final class Product {
	
	private String name;
	private double cost;
	
	public Product(String name, double cost) throws ProductCreationException {
		if( name == null || cost < 0d ) {
			throw new ProductCreationException();
		}
		
		this.name = name;
		this.cost = cost;
	}
	
	// Getters
	public String getName() { return name; }
	public double getCost() { return cost; }

}
