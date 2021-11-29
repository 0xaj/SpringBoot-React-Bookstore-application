package com.hexaware.bookstoremanagement.controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.hexaware.bookstoremanagement.entity.*;
import com.hexaware.bookstoremanagement.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Books")
public class BookController  {

    final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping()
    public void addBook(@RequestBody Book book) {
        bookService.createBook(book);
    }

    @GetMapping()
    public List<Book> getAllBook() {
        Date dNow = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

       
        
        bookService.createBook(new Book(1,"DBMS","Abraham","2020/05/14",200));
        bookService.createBook(new Book(2,"C#","Andres","2017/07/18",400));
        bookService.createBook(new Book(3,"NETWORKS","William","2014/02/10",200));
        bookService.createBook(new Book(4,"OS","Robert","1997/06/29",300));
        bookService.createBook(new Book(5,"PYTHON","Reema","2002/08/09",300));
        bookService.createBook(new Book(6,"HTML","Misti","2005/02/18",500));
        bookService.createBook(new Book(7,"BOOTSTRAP","Deeksha","2017/04/04",250));
        bookService.createBook(new Book(8,"AGILE","Kalpesh","2013/06/13",150));
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public int getBook(@PathVariable("id") int id) {
        return bookService.getBook(id);
    }


    @GetMapping("/{id}/name")
    public String getBookName(@PathVariable("id") int id) {
        return bookService.getBookName(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id,
                                           @RequestBody Book book) {
        return  bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable("id") int id) {
        bookService.deleteBook(id);
    }

}
