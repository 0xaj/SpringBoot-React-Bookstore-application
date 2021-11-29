package com.hexaware.bookstoremanagement.controller;

import com.hexaware.bookstoremanagement.entity.*;
import com.hexaware.bookstoremanagement.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/{customerId}/order")
public class OrderController  {

    final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/{customerId}/order")
    public void addBook(@RequestBody Order order) {
    	orderService.createOrder(order);
    }

    @GetMapping("/{customerId}/order")
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{customerId}/order/{orderiId}")
    public Order getBook(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/{customerId}/order/{orderiId}/totalcost")
    public Order getTotalCost(@PathVariable("orderId") int id,@PathVariable("cartId") int cid ) {
        return orderService.getTotalCost(id,cid);
    }

    
    @PutMapping("/{customerId}/order/{orderiId}")
    public ResponseEntity<Order> updateOrder(@PathVariable("orderId") int id,
                                           @RequestBody Order order) {
        return  orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{customerId}/order/{orderiId}")
    public void removeOrder(@PathVariable("id") int id) {
    	orderService.deleteOrder(id);
    }

}