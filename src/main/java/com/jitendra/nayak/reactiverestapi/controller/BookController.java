package com.jitendra.nayak.reactiverestapi.controller;

import com.jitendra.nayak.reactiverestapi.entities.Book;
import com.jitendra.nayak.reactiverestapi.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    // Create a new Book
    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        return bookService.create(book);
    }

    // Get ALl books
    @GetMapping
    public Flux<Book> getAllBooks(){
        return bookService.getAll();
    }

    // Get Book by id
    @GetMapping("/{bookId}")
    public Mono<Book> get(@PathVariable Integer bookId) {
        return bookService.get(bookId);
    }

    // Update a book by id
    @PutMapping("/{bookId}")
    public Mono<Book> update(@RequestBody Book book, @PathVariable Integer bookId){
        return bookService.update(book, bookId);
    }


    @DeleteMapping("/{bookId}")
    public Mono<Void> delete(@PathVariable Integer bookId) {
        return bookService.delete(bookId);
    }

    @GetMapping("/search")
    public Flux<Book> SeachByName(@RequestParam("query") String query) {
        return bookService.search(query);
    }


    // Get ALl books
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> getAllBooksByStream(){
        return bookService.getAllByStream();
    }

}
