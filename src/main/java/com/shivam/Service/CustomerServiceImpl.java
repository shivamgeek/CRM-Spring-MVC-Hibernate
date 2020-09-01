package com.shivam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivam.DAO.CustomerDAO;
import com.shivam.Entity.Customer;


// @Service annotation is type of @Component annotation, and tells spring to scan it also in basePackageScanning

@Service
public class CustomerServiceImpl implements CustomerService{

	/* This works because in CustomerDaoImpl we gave annotation @Repository, so spring will register it as a bean,
	 * just like @Controller. @Autowired will do dependency injection of CustomerDaoImpl here.
	 */
	@Autowired
	CustomerDAO customerDao;
	
	@Transactional
	public List<Customer> getCustomerList() {
		return customerDao.getCustomerList();
	}

	@Transactional 
	public void saveCustomer(Customer c) {
		customerDao.saveCustomer(c);
		
	}
	
	@Transactional
	public Customer getCustomerUsingID(int id) {
		return customerDao.getCustomerUsingID(id);
	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}

}
