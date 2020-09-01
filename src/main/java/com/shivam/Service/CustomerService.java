package com.shivam.Service;

import java.util.List;

import com.shivam.Entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomerList();

	public void saveCustomer(Customer c);

	public Customer getCustomerUsingID(int id);

	public void deleteCustomer(int id);
	
}
