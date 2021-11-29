package com.hexaware.bookstoremanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_id;
    @Column(name = "cart_id")
    private int cart_id;
    @Column(name = "total_cost")
    private int total_cost;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}
	public Order(int order_id, int cart_id, int total_cost) {
		this.order_id = order_id;
		this.cart_id = cart_id;
		this.total_cost = total_cost;
	}
	public Order() {
		
	}

   
    


   
}