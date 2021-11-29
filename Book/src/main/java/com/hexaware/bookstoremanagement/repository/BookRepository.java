package com.hexaware.bookstoremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.hexaware.bookstoremanagement.entity.Book;

@Component
public interface BookRepository extends JpaRepository<Book,Integer> {


    @Query(value = "select cost from book where book_id = ?1", nativeQuery = true)
    Integer findByIdCost(int book_id);


    @Query(value = "select name from book where book_id = ?1", nativeQuery = true)
    String getBookName(int id);
}
