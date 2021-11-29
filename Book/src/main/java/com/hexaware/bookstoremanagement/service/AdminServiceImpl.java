package com.hexaware.bookstoremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import com.hexaware.bookstoremanagement.entity.*;
import com.hexaware.bookstoremanagement.repository.AdminRepository;
import com.hexaware.bookstoremanagement.repository.CustomerRepository;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AdminServiceImpl implements AdminService {
	final AdminRepository adminRepository;


	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}
	
	public  Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin getAdmin(int cust_id) {
		return adminRepository.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin [Admin id="+cust_id+"] can't be found"));
	
	}
	  
	public ResponseEntity<Admin> updateAdmin(int id, Admin customer) {
	        return adminRepository.findById(id).map(Customer ->{
	            Customer.setName(customer.getName());
	            Customer.setEmail(customer.getEmail());
	            Customer.setPassword(customer.getPassword());
	            adminRepository.save(customer);
	            return ResponseEntity.ok(customer);
	        }).orElseThrow(() -> new ResourceNotFoundException("Customer [customer="+id+"] can't be found"));
	    }
	
	
	    public void deleteAdmin(int id) {
	    	adminRepository.deleteById(id);
	    }

		@Override
		public Integer checkLogin(String name, String pass) {
			// TODO Auto-generated method stub
			return adminRepository.checkLogin(name,pass);
		}
}
