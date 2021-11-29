package com.hexaware.bookstoremanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.hexaware.bookstoremanagement.entity.Order;


public interface OrderService {
	    public List<Order> getAllOrder();
	    public Order getOrder(int order_id);
	    public Order createOrder(Order order);
	    public ResponseEntity<Order> updateOrder(int order_id, Order order);
	    public void deleteOrder(int id);
		public Order getTotalCost(int id, int cid);
}
