package com.hexaware.bookstoremanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.bookstoremanagement.entity.Cart;
import com.hexaware.bookstoremanagement.entity.Order;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

public interface CartRepository  extends JpaRepository<Cart,Integer> {

	

	@Query(value = "select c.* from cart c where c.cust_id=?1", nativeQuery = true)
	List<Cart> getAllByID(int custId);


	@Query(value = "select sum(b.cost) as total from book b inner join  cart c on  b.book_id=c.book_id where c.cust_id=?1", nativeQuery = true)
	Integer totalCost(int id);

	@Transactional
	@Modifying
	@Query(value = "Delete FROM cart where cart_id = ?1 and cust_id = ?2", nativeQuery = true)//""select sum(b.cost) as total from book b inner join  cart c on  b.book_id=c.book_id where c.cust_id=?1", nativeQuery = true)
	void deleteByIdCid(int id, int cid);
}

