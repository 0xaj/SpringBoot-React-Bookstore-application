package com.hexaware.bookstoremanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import com.hexaware.bookstoremanagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;



@Component
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select cust_id from customer where name = ?1 and password = ?2", nativeQuery = true)
    Integer checkLogin(String name, String pass);
}
