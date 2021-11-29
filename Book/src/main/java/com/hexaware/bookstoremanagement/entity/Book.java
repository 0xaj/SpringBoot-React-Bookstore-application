package com.hexaware.bookstoremanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    private int book_id;
    @Column(name = "name")
    private String name;
    @Column(name = "author_name")
    private String author_name;
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "date")
    private String date;
    @Column(name = "cost")
    private int cost;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Book() {
    }

    public Book(int book_id, String name, String author_name, String date, int cost) {
        this.book_id = book_id;
        this.name = name;
        this.author_name = author_name;
        this.date = date;
        this.cost = cost;
    }
}
