package com.shivam.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.Entity.Customer;
import com.shivam.Service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	CustomerService custService;
	
	//GET list of customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return custService.getCustomerList();
	}
	
	//GET single customer data using id
	@GetMapping("/customers/{customerID}")
	public Customer getCustomer(@PathVariable("customerID") int id) {
		Customer c = custService.getCustomerUsingID(id);
		if(c == null) {
			throw new CustomerException("Invalid customer ID passed, no record found !");
		}
		return c;
	}
	
}
