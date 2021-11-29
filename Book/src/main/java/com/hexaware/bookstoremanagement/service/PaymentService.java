package com.hexaware.bookstoremanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hexaware.bookstoremanagement.entity.Payment;

public interface PaymentService {
	public List<Payment> getAllPayment();
	public Payment getPayment(int Payment_id);
	public Payment createPayment(Payment newPayment);
	public ResponseEntity<Payment> updatePayment(int cust_id,Payment newAdmin);
	public void deletePayment(int Admin_id);
	

}
