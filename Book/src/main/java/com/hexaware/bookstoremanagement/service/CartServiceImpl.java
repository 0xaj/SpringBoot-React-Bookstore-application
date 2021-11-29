package com.hexaware.bookstoremanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hexaware.bookstoremanagement.repository.*;
import com.hexaware.bookstoremanagement.entity.*;

@Service
public class CartServiceImpl implements CartService {
	final CartRepository cartRepository;


	@Autowired
	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	public  Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public Cart getCart(int cartId) {
		return cartRepository.findById(cartId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart [cartId="+cartId+"] can't be found"));

	}

	/**
	 * @param id
	 * @param
	 * @return
	 */
	public ResponseEntity<Cart> updateCart(int id, Cart cart) {
		return cartRepository.findById(id).map(Cart ->{
			Cart.setCart_id(cart.getCart_id());
			Cart.setBook_id(cart.getBook_id());
			Cart.setCart_id(cart.getCart_id());
			Cart.setCust_id(cart.getCust_id());
			cartRepository.save(cart);
			return ResponseEntity.ok(cart);
		}).orElseThrow(() -> new ResourceNotFoundException("Cart [cartId="+id+"] can't be found"));
	}


	public void deleteCart(int id,int cid) {
		cartRepository.deleteByIdCid(id,cid);
	}



	public List<Cart> getAll(){
		// TODO Auto-generated method stub
		return  cartRepository.findAll();
	}

	@Override
	public List<Cart> getAll(int id) {
		return cartRepository.getAllByID(id);
	}

	@Override
	public Optional<Cart> getById(int id) {
		return cartRepository.findById(id);
	}

	@Override
	public Integer getTotalCost(int id) {
		return cartRepository.totalCost(id);
	}

	@Override
	public boolean existsById(int id) {
		return cartRepository.existsById(id);
	}


}
