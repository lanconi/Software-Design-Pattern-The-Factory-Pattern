package com.ep.customer;

import com.ep.exception.MalformedCustomerException;
import java.util.Map;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.Set;
import java.util.Iterator;

/**
 * The CustomerFactory is an integral component in the Creational Design Pattern
 * for the Factory Pattern. This class is also a Singleton, which means that only
 * one instance of CustomerFactory can be created in a single application.<br>
 * Use CustomerFactory to create concrete implementations of Customer.<br>
 * An example of how to use the CustomerFactory is show here ...<br>
 * <pre>
 * try {
 * 	CustomerFactory customerFactory = CustomerFactory.getInstance();
 * 	Customer customerA = customerFactory.getCustomer(CustomerType.SMALL, 1459292, 25_000.00d);
 * 	Customer customerB = customerFactory.getCustomer(CustomerType.MEDIUM, 2245945, 60_000.00d);
 * 	Customer customerC = customerFactory.getCustomer(CustomerType.LARGE, 324772, 210_000.00d);
 * } catch( MalformedCustomerException mce ) {
 *   // take appropriate course of action
 * }
 *</pre>
 * @author Lance Dooley
 *
 */
public class CustomerFactory {
	
	private static CustomerFactory cfInstance;
	
	// A map that keeps track of all Customers for this session
	private Map<Long, Customer> customerMap = new Hashtable<>();
	
	/**
	 * Get the Singleton instance of a CustomerFactory for this 
	 * application. There will be only one instance of CustomerFactory.
	 * @return CustomerFactory instance
	 */
	public static CustomerFactory getInstance() {
		if( cfInstance == null ) {
			cfInstance = new CustomerFactory();
		}
		
		return cfInstance;
	}
	
	// A private constructor will prevent users or clients from created 
	// multiple instances of CustomerFactory
	private CustomerFactory() {
		
	}
	
	public Customer getCustomer(CustomerType customerType, 
								long id, 
								String name,
								double balance)  throws MalformedCustomerException
	{
		
		// If Customer has already been created with this id, then do not
		// create another one to avoid duplication or hacking
		if( customerMap.containsKey(id)) {
			System.out.println("customerMap: " + id + " already created!");

			return null;
		}
		
		switch( customerType ) {
			case SMALL:
				SmallCustomer customerSmall = new SmallCustomer(id, name, balance);
				customerMap.put(id, customerSmall);
				return customerSmall;
			case MEDIUM:
				MediumCustomer customerMedium = new MediumCustomer(id, name, balance);
				customerMap.put(id, customerMedium);
				return customerMedium;
			case LARGE:
				LargeCustomer customerMediumLarge = new LargeCustomer(id, name, balance);
				customerMap.put(id, customerMediumLarge);
				return customerMediumLarge;
			default:
				return null;
		}
	}
	
	/**
	 * A generic filtering method that will return a List of Customers that
	 * satisfy the lambda condition that is passed as an argument during
	 * runtime.
	 * @param p
	 * @return List of Customers
	 */
	public List<Customer> filterCustomers(Predicate<Customer> p) {
		List<Customer> list = new ArrayList<>();
		
		// go through the Map in this CustomerFactory and test
		// each Customer to see if it satisfies the condition.
		//private Map<Long, Customer> customerMap = new Hashtable<>();
		Set<Long> set = customerMap.keySet();
		Iterator<Long> iterator = set.iterator();
		while( iterator.hasNext() ) {
			Long longRef = iterator.next(); // get the key
			Customer customer = customerMap.get(longRef); // get the value, the Customer
			
			// now test the condition
			if( p.test( customer )) {
				list.add(customer);
			}
		}
		return list;
	}

}
