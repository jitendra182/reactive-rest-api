package com.jitendra.nayak.reactiverestapi.service.impl;

import com.jitendra.nayak.reactiverestapi.entities.Book;
import com.jitendra.nayak.reactiverestapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void findByNameInTest(){
        bookService.search("Javascript")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();

    }
}