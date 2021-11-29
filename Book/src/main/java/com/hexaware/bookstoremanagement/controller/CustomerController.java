package com.hexaware.bookstoremanagement.controller;

import com.hexaware.bookstoremanagement.entity.*;
import com.hexaware.bookstoremanagement.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customers") 
class CustomerController  {

     CustomerService customerService;
     @Autowired
     public CustomerController(CustomerService customerService) {
         this.customerService = customerService;

     }
   


    @PostMapping()
    public Customer addUser(@RequestBody Customer customer) {

    	customerService.createCustomers(customer);
        return customer;
    }

    @GetMapping()
    public List<Customer> getAllUsers() {
        System.out.println("bye");
        return customerService.getAllCustomers();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{userName}/{password}", produces = "application/json")
    public Integer checkLogin(@PathVariable("userName") String name , @PathVariable("password") String pass) {


        return  customerService.checkLogin(name,pass);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int id,
                                           @RequestBody Customer customer) {
        return  customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{customerId}")
    public void removeUser(@PathVariable("customerId") int id) {
    	customerService.deleteCustomer(id);
    }

}