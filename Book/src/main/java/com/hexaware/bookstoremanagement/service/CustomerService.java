package com.hexaware.bookstoremanagement.service;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hexaware.bookstoremanagement.entity.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;




public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int cust_id);
	public Customer createCustomers(Customer newCust);
	public ResponseEntity<Customer> updateCustomer(int cust_id,Customer newEmployee);
	public void deleteCustomer(int cust_id);
	Integer checkLogin(String name, String pass);


}

