package com.hexaware.bookstoremanagement.repository;

import org.springframework.stereotype.Component;
import com.hexaware.bookstoremanagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



@Component
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    @Query(value = "select admin_id from admin where name = ?1 and password = ?2", nativeQuery = true)
	Integer checkLogin(String name, String pass);


}
