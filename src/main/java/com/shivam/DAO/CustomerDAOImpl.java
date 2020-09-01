package com.shivam.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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


	public void saveCustomer(Customer c) {
		Session session = mySessionFactory.getCurrentSession();
		session.saveOrUpdate(c);
	}


	public Customer getCustomerUsingID(int id) {
		Session session = mySessionFactory.getCurrentSession();
		Customer c = session.get(Customer.class, id);
		return c;
	}


	public void deleteCustomer(int id) {
		Session session = mySessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:custID");
		query.setParameter("custID", id);
		query.executeUpdate();
	}

}
