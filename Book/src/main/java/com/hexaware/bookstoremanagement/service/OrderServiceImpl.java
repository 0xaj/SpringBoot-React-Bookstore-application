package com.hexaware.bookstoremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hexaware.bookstoremanagement.entity.Order;
import com.hexaware.bookstoremanagement.repository.CustomerRepository;
import com.hexaware.bookstoremanagement.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	final OrderRepository orderRepository;


	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	
	
	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return  orderRepository.findAll();
	}

	@Override
	public Order getOrder(int order_id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(order_id)
				.orElseThrow(() -> new ResourceNotFoundException("Order [order id="+order_id+"] can't be found"));
		}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public ResponseEntity<Order> updateOrder(int order_id, Order order) {
		  return orderRepository.findById(order_id).map(Order ->{
			  Order.setOrder_id(order.getOrder_id());
			  Order.setCart_id(order.getCart_id());
			  Order.setTotal_cost(order.getTotal_cost());
			  orderRepository.save(order);
	            return ResponseEntity.ok(order);
	        }).orElseThrow(() -> new ResourceNotFoundException("Order [Order Id="+order_id+"] can't be found"));
	    }
	
	

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(id);
	}



	@Override
	public Order getTotalCost(int id, int cid) {
		// TODO Auto-generated method stub
		return orderRepository.getTotalCost(id,cid);
	}

}
