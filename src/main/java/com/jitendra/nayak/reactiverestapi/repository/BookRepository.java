package com.jitendra.nayak.reactiverestapi.repository;

import com.jitendra.nayak.reactiverestapi.entities.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {

    Mono<Book> findByName(String name);
    Mono<Book> findByDescription(String description);
    Flux<Book> findByPublisher(String publisher);
    Flux<Book> findByAuthor(String author);

    Flux<Book> findByNameContainingIgnoreCase(String name);
}
