package com.jitendra.nayak.reactiverestapi.service;

import com.jitendra.nayak.reactiverestapi.entities.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Mono<Book> create(Book book);
    Flux<Book> getAll();
    Mono<Book> get(Integer bookId);
    Mono<Book> update(Book book, Integer bookId);
    Mono<Void> delete(Integer bookId);
    Flux<Book> search(String query);

    Flux<Book> getAllByStream();
}
