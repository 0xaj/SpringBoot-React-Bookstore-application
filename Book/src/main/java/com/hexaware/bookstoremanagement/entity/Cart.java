package com.hexaware.bookstoremanagement.entity;

import javax.persistence.*;


@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cart_id;
	private int cust_id;
	private int book_id;
	private int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	private int quantity;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Cart( int cust_id, int book_id, int quantity,int cost) {
		this.cust_id = cust_id;
		this.book_id = book_id;
		this.quantity = quantity;
		this.cost = cost;
	}
	public Cart() {
	}

	
	
}