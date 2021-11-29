package com.hexaware.bookstoremanagement.controller;


import com.hexaware.bookstoremanagement.entity.*;
import com.hexaware.bookstoremanagement.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/{customerId}/order/{orderId}/payment")
public class PaymentController  {

    final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping()
    public void addBook(@RequestBody Payment pay) {
    	paymentService.createPayment(pay);
    }

    @GetMapping()
    public List<Payment> getAllPayment() {
        return paymentService.getAllPayment();
    }

    @GetMapping("/{customerId}/order/{orderiId}/payment/{paymentId}")
    public Payment getBook(@PathVariable("paymentId") int id) {
        return paymentService.getPayment(id);
    }

    @PutMapping("/{customerId}/order/{orderiId}/payment/{paymentId}")
    public ResponseEntity<Payment> updateBook(@PathVariable("paymentId") int id,
                                           @RequestBody Payment payment) {
        return  paymentService.updatePayment(id, payment);
    }

    @DeleteMapping("/{customerId}/order/{orderiId}/payment/{paymentId}")
    public void removeUser(@PathVariable("paymentId") int id) {
    	paymentService.deletePayment(id);
    }

}
