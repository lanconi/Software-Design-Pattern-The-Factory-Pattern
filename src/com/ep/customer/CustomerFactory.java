package com.ep.customer;

import java.util.Map;
import java.util.Hashtable;

/*
 * This SingletonClass is a Factory that generates Customer Objects
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
								double balance) 
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

}
