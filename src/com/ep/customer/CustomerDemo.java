package com.ep.customer;

import com.ep.exception.BadPurchaseException;
import com.ep.exception.ProductCreationException;
import com.ep.exception.PurchaseAmountExceededException;
import com.ep.exception.MalformedCustomerException;
import com.ep.product.*;

import java.util.List;
import java.util.ArrayList;
import java.time.ZonedDateTime;

/**
 * 
 * @author Lance Dooley
 *
 */
public class CustomerDemo {
	
	// Entry point for the CustomerDemo that will create some
	// Customers and have them purchase Products
	public static void main(String[] args ) throws MalformedCustomerException
	{
		
		// Get an instance of CustomerFactory
		CustomerFactory customerFactory = CustomerFactory.getInstance();
		
		// Define references to 3 customers
		Customer customerA=  customerFactory.getCustomer(CustomerType.SMALL, 1459292, 
							"CustomerA", 25_000.00d);
		Customer customerB  = customerFactory.getCustomer(CustomerType.MEDIUM, 2245945, 
							"CustomerB", 60_000.00d);
		Customer customerC = customerFactory.getCustomer(CustomerType.LARGE, 324772,
							"CustomerC", 210_000.00d);
				
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
		
		// Print out the metrics for each customer; ID, remaining balance, etc ...s
		// customerA
		// Print the initial metrics:
		System.out.println(customerA.getMetrics() );
		System.out.println(customerB.getMetrics() );
		System.out.println(customerC.getMetrics() );
		
		
		// now we will use Behavior Parameterization and call the 
		// filterCustomers method that takes a lambda argument that
		// will act as a Predicate test condition.
		// For example, we want to find out how many customers have a balance
		// that is less than 1,000
		List<Customer> lowBalanceCustomers = 
				customerFactory.filterCustomers( p -> p.getBalance() < 1_000.00d );
		
		if( lowBalanceCustomers.size() > 0 ) {
			System.out.println("Low Balance Customers ...");
			for( Customer customer: lowBalanceCustomers ) {
				System.out.println( customer.getName());
			}
		}

		
		// or, we could find out how many customers have purchased more than 10 Poducts
		List<Customer> goodCustomers = 
				customerFactory.filterCustomers( p -> p.getPurchasedQuantity() > 10 );

		if( goodCustomers.size() > 0 ) {
			System.out.println("Good Customers (who purchased more than 10 Products ...");
			for( Customer customer: goodCustomers ) {
				System.out.println( customer.getName());
			}
		}

	}

}
