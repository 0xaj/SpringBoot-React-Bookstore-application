package com.hexaware.bookstoremanagement.repository;

import org.springframework.stereotype.Component;
import com.hexaware.bookstoremanagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



@Component
public interface OrderRepository extends JpaRepository<Order,Integer> {

	@Query(value = "select (quantity * book.cost) from book, order where order.book_id = book.book_id and cart_id = ?2", nativeQuery = true)
	Order getTotalCost(int id, int cid);

}
