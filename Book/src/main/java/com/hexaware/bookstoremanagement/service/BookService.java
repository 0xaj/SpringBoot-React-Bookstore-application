package com.hexaware.bookstoremanagement.service;

import com.hexaware.bookstoremanagement.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public int getBook(int cust_id);
    public Book createBook(Book book);
    public ResponseEntity<Book> updateBook(int book_id, Book book);
    public void deleteBook(int book_id);

    String getBookName(int id);
}