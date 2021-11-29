package com.hexaware.bookstoremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hexaware.bookstoremanagement.entity.Payment;
import com.hexaware.bookstoremanagement.repository.*;

@Service
public class PaymentServiceImpl implements PaymentService {

	final PaymentRepository paymentRepository;

	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPayment(int Payment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment createPayment(Payment newPayment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(newPayment);
	}

	@Override
	public ResponseEntity<Payment> updatePayment(int cust_id, Payment newAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePayment(int Admin_id) {
		// TODO Auto-generated method stub
		
	}

}
