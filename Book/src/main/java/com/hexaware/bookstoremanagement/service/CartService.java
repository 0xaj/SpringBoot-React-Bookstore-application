package com.hexaware.bookstoremanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.hexaware.bookstoremanagement.entity.Cart;

public interface CartService {
	public Cart getCart(int cartId);
	public Cart createCart(Cart cart);
	public ResponseEntity<Cart> updateCart(int order_id, Cart cart);
	public void deleteCart(int id, int cid);
	public List<Cart> getAll();
	public List<Cart> getAll(int id);


	public Optional<Cart> getById(int id);

    Integer getTotalCost(int id);

	boolean existsById(int id);
}
