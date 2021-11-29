package com.hexaware.bookstoremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hexaware.bookstoremanagement.repository.*;
import com.hexaware.bookstoremanagement.entity.*;

@Service
public class BookServiceImpl implements BookService {
	final BookRepository bookRepository;


	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public  Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public int getBook(int book_id) {
		return bookRepository.findByIdCost(book_id);

	
	}
	  
	/**
	 * @param id
	 * @param book
	 * @return
	 */
	public ResponseEntity<Book> updateBook(int id, Book book) {
	        return bookRepository.findById(id).map(Book ->{
	        	Book.setBook_id(book.getBook_id());
	        	Book.setName(book.getName());
	        	Book.setAuthor_name(book.getAuthor_name());
	        	Book.setDate(book.getDate());
	        	bookRepository.save(book);
	            return ResponseEntity.ok(book);
	        }).orElseThrow(() -> new ResourceNotFoundException("Book [book="+id+"] can't be found"));
	    }
	
	
	    public void deleteBook(int id) {
	    	bookRepository.deleteById(id);
	    }

	@Override
	public String getBookName(int id) {
		return bookRepository.getBookName(id);
	}

}
