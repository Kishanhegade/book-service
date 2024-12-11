package com.bridgelabz.bsa.bookservice.controller;


import com.bridgelabz.bsa.bookservice.requestdto.BookRequest;
import com.bridgelabz.bsa.bookservice.responsedto.BookResponse;
import com.bridgelabz.bsa.bookservice.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<BookResponse> addBook(@ModelAttribute @Valid BookRequest bookRequest) {
        BookResponse bookResponse = bookService.addBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponse);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable long bookId) {
        BookResponse bookResponse = bookService.getBookById(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> bookResponses = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(bookResponses);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<BookResponse> deleteBookById(@PathVariable int bookId) {
        BookResponse bookResponse = bookService.deleteBookById(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
    }

    @PatchMapping("/books/{bookId}/price")
    public ResponseEntity<BookResponse> changeBookPrice(@PathVariable int bookId, @RequestParam double price) {
        BookResponse bookResponse = bookService.changeBookPrice(bookId,price);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookResponse);
    }

    @PutMapping("/books/{bookId}/quantity")
    public ResponseEntity<BookResponse> changeBookQuantity(@PathVariable long bookId, @RequestParam int quantity) {
        BookResponse bookResponse = bookService.changeBookQuantity(bookId,quantity);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookResponse);
    }

}
