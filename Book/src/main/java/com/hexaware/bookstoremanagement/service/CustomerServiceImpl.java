package com.hexaware.bookstoremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import com.hexaware.bookstoremanagement.entity.*;
import com.hexaware.bookstoremanagement.repository.CustomerRepository;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CustomerServiceImpl implements CustomerService {
	final CustomerRepository customerRepository;


	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public  Customer createCustomers(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomer(int cust_id) {
		return customerRepository.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer [customer="+cust_id+"] can't be found"));

	}

	public ResponseEntity<Customer> updateCustomer(int id, Customer customer) {
		return customerRepository.findById(id).map(Customer ->{
			Customer.setName(customer.getName());
			Customer.setEmail(customer.getEmail());
			Customer.setPassword(customer.getPassword());
			customerRepository.save(customer);
			return ResponseEntity.ok(customer);
		}).orElseThrow(() -> new ResourceNotFoundException("Customer [customer="+id+"] can't be found"));
	}


	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
	@Override
	public Integer checkLogin(String name, String pass) {
		return customerRepository.checkLogin(name,pass);
	}
}
