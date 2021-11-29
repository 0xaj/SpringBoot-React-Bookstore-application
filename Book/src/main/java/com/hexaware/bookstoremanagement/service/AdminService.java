package com.hexaware.bookstoremanagement.service;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hexaware.bookstoremanagement.entity.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;




public interface AdminService {
	public List<Admin> getAllAdmins();
	public Admin getAdmin(int Admin_id);
	public Admin createAdmin(Admin newCust);
	public ResponseEntity<Admin> updateAdmin(int cust_id,Admin newAdmin);
	public void deleteAdmin(int Admin_id);
	public Integer checkLogin(String name, String pass);
	
}

