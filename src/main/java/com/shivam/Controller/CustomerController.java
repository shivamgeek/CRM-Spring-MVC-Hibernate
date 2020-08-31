package com.shivam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shivam.Entity.Customer;
import com.shivam.Service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/* This works because in CustomerServiceImpl we gave annotation @Service, so spring will register it as a bean,
	 * just like @Controller. @Autowired will do dependency injection of CustomerServiceImpl here.
	 */
	@Autowired
	CustomerService customerService;
	
	
	//@RequestMapping(path="/list" , method=RequestMethod.GET)
	@GetMapping("/list")
	public String listCustomers(Model model) {
		//Get customer list from Dao
		List<Customer> customerList = customerService.getCustomerList();
		
		//Add that list to model
		model.addAttribute("customerList",customerList);
		
		return "list-customers"; 
	}
	
	@GetMapping("/addCustomerForm")
	public String showAddCustomerForm(Model model) {
		Customer c = new Customer();
		model.addAttribute("customerData", c);
		return "add-customer-form";
	}
	
	
}
