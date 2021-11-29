package com.hexaware.bookstoremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.bookstoremanagement.entity.*;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}