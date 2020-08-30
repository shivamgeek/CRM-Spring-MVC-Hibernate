package com.shivam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shivam.DAO.CustomerDAO;
import com.shivam.Entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/* This works because in CustomerDaoImpl we gave annotation @Repository, so spring will register it as a bean,
	 * just like @Controller. @Autowired will do dependency injection of CustomerDaoImpl here.
	 */
	@Autowired
	CustomerDAO customerDao;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		//Get customer list from Dao
		List<Customer> customerList = customerDao.getCustomerList();
		
		//Add that list to model
		model.addAttribute("customerList",customerList);
		
		return "list-customers"; 
	}
}
