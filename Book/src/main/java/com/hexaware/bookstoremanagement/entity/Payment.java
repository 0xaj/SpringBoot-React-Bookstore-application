package com.hexaware.bookstoremanagement.entity;

import java.util.Date;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "payment")
public class Payment {

	@Id
    @Column(name = "payment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_id;
	private int cust_id;
	private String date;
	private int amount;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Payment() {
	}
	public Payment(int payment_id, int cust_id, String date, int amount) {
		this.payment_id = payment_id;
		this.cust_id = cust_id;
		this.date = date;
		this.amount = amount;
	}
	
	

	
}
