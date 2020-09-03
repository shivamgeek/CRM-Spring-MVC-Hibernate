package com.shivam.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//POST to add a new Customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer c) {
		//Set the id explicitly to 0, because in hibernate we're using saveOrUpdate() which checks this ID
		// if it's empty or 0, then it creates a new customer, else updates existing
		c.setId(0);
		custService.saveCustomer(c);
		return c;
	}
	
	//PUT to udpate a existing customer
	@PutMapping("/customers")
	public Customer udpateCustomer(@RequestBody Customer c) {
		//We have saveOrUpdate in hibernate so it'll automatically update the customer
		custService.saveCustomer(c);
		return c;
	}
	
	//DELETE to delete a customer
	@DeleteMapping("/customers/{customerID}")
	public String deleteCustomer(@PathVariable("customerID") int id) {
		Customer c = custService.getCustomerUsingID(id);
		if(c == null) {
			throw new CustomerException("No customer found with ID "+id);
		}
		custService.deleteCustomer(id);
		return "Customer deleted with ID "+id;
	}
	
	
}
