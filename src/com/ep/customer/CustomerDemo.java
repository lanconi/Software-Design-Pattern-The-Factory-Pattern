package com.ep.customer;

import com.ep.exception.BadPurchaseException;
import com.ep.exception.ProductCreationException;
import com.ep.exception.PurchaseAmountExceededException;
import com.ep.product.*;

import java.util.List;
import java.util.ArrayList;
import java.time.ZonedDateTime;

public class CustomerDemo {
	
	// Entry point for the CustomerDemo that will create some
	// Customers and have them purchase Products
	public static void main(String[] args ) {
		
		// Get an instance of CustomerFactory
		CustomerFactory customerFactory = CustomerFactory.getInstance();
		
		// Create 3 customers, each with a unique ID and  initial balances
		Customer customerA = 
					customerFactory.getCustomer(CustomerType.SMALL, 1459292, 25_000.00d);
		Customer customerB = 
					customerFactory.getCustomer(CustomerType.MEDIUM, 2245945, 60_000.00d);
		Customer customerC = 
					customerFactory.getCustomer(CustomerType.LARGE, 324772, 210_000.00d);
		
		// Print the initial metrics:
		System.out.println(customerA.getMetrics() );
		System.out.println(customerB.getMetrics() );
		System.out.println(customerC.getMetrics() );

		
		// create some dummy Product Objects and put them in a List<Product>
		List<Product> productList = new ArrayList<>();
		for( int i = 1; i <= 21; i++ ) {
			try {
				Product p = new Product("Product" + i,  		// id
										i*1_000d,				// cost
										"CompanyABC",			// vendor
										ZonedDateTime.now() );  // zonedDateTime	
				productList.add(p);
			} catch( ProductCreationException ex ) {
				System.out.println( ex.getMessage() );
			}			
		}
		
		// Loop through all the Product objects in the List and have each
		// Customer attempt buying them
		for( Product product: productList) {
			
			// customerA
			try { 
				customerA.makePurchase(product);
			} catch( PurchaseAmountExceededException paec) {
				
			} catch( BadPurchaseException bpe ) {
				
			}
			
			// customerB
			try { 
				customerB.makePurchase(product);
			} catch( PurchaseAmountExceededException paec) {
				
			} catch( BadPurchaseException bpe ) {
				
			}
			
			// customerC
			try { 
				customerC.makePurchase(product);
			} catch( PurchaseAmountExceededException paec) {
				
			} catch( BadPurchaseException bpe ) {
				
			}
		}
		
		// Print out the metrics for each customer, ID, remaining balance, etc ...s
		
		// customerA
		// Print the initial metrics:
		System.out.println(customerA.getMetrics() );
		System.out.println(customerB.getMetrics() );
		System.out.println(customerC.getMetrics() );

	}

}
