package com.jitendra.nayak.reactiverestapi.service.impl;

import com.jitendra.nayak.reactiverestapi.entities.Book;
import com.jitendra.nayak.reactiverestapi.repository.BookRepository;
import com.jitendra.nayak.reactiverestapi.service.BookService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Mono<Book> create(Book book) {
        Mono<Book> createdBook = bookRepository.save(book);
        return  createdBook;
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> get(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Mono<Book> update(Book book, Integer bookId) {
        Mono<Book> oldBook = bookRepository.findById(bookId);
        return oldBook.flatMap(book1 -> {
            book1.setName(book.getName());
            book1.setPublisher(book.getPublisher());
            book1.setAuthor(book.getAuthor());
            book1.setDescription(book.getDescription());
            return bookRepository.save(book1);
        });
    }

    @Override
    public Mono<Void> delete(Integer bookId) {
        return bookRepository.deleteById(bookId);
    }

    @Override
    public Flux<Book> search(String query) {
        return bookRepository.findByNameContainingIgnoreCase(query);
    }

    @Override
    public Flux<Book> getAllByStream() {
        return bookRepository.findAll().delayElements(Duration.ofSeconds(5));
    }
}
