package com.shivam.DAO;

import java.util.List;
import com.shivam.Entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomerList();

	public void saveCustomer(Customer c);

	public Customer getCustomerUsingID(int id);
	
}
