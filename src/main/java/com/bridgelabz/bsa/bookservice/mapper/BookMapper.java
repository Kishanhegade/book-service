package com.bridgelabz.bsa.bookservice.mapper;

import com.bridgelabz.bsa.bookservice.model.Book;
import com.bridgelabz.bsa.bookservice.requestdto.BookRequest;
import com.bridgelabz.bsa.bookservice.responsedto.BookResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BookMapper {

    public Book mapToBook(BookRequest bookRequest, Book book) {
        book.setBookName(bookRequest.getBookName());
        book.setAuthorName(bookRequest.getAuthorName());
        book.setDescription(bookRequest.getDescription());
        book.setQuantity(bookRequest.getQuantity());
        try {
            book.setLogo(bookRequest.getLogo().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        book.setPrice(bookRequest.getPrice());
        return book;
    }

    public BookResponse mapToBookResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setBookId(book.getBookId());
        bookResponse.setBookName(book.getBookName());
        bookResponse.setAuthorName(book.getAuthorName());
        bookResponse.setDescription(book.getDescription());
        bookResponse.setPrice(book.getPrice());
        bookResponse.setQuantity(book.getQuantity());
        return bookResponse;
    }
}
