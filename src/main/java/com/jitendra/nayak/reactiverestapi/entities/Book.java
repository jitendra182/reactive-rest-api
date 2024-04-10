package com.jitendra.nayak.reactiverestapi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
public class Book {

    @Id
    private Integer bookId;
    private String name;
    private String description;
    private String publisher;
    private String author;


    public Book() {
    }

    public Book(Integer bookId, String name, String description, String publisher, String author) {
        this.bookId = bookId;
        this.name = name;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
