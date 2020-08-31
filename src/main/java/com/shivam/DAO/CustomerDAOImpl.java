package com.shivam.DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shivam.Entity.Customer;

//Add @Repository to make it available for Spring during scanning of packagesToScan
//Annotation @Repository is only applicable for DAO implementation classes. This is just like @Component annotation.

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	//need to inject SessionFactory using @Autowire
	@Autowired
	SessionFactory mySessionFactory;
	
	
	public List<Customer> getCustomerList() {
		Session session = mySessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer",Customer.class).getResultList();
		return customerList;
	}

}
