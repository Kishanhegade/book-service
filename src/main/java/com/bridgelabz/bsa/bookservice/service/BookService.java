package com.bridgelabz.bsa.bookservice.service;

import com.bridgelabz.bsa.bookservice.exception.BookNotFoundByIdException;
import com.bridgelabz.bsa.bookservice.mapper.BookMapper;
import com.bridgelabz.bsa.bookservice.model.Book;
import com.bridgelabz.bsa.bookservice.repository.BookRepository;
import com.bridgelabz.bsa.bookservice.requestdto.BookRequest;
import com.bridgelabz.bsa.bookservice.responsedto.BookResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private BookRepository bookRepo;
    private BookMapper bookMapper;

    public BookResponse addBook(BookRequest bookRequest) {

        Book book = bookMapper.mapToBook(bookRequest, new Book());
        book = bookRepo.save(book);
        return bookMapper.mapToBookResponse(book);
    }

    public BookResponse getBookById(long bookId) {
        return bookRepo.findById(bookId)
                .map(book -> {
                    return bookMapper.mapToBookResponse(book);
                }).orElseThrow(()->new BookNotFoundByIdException("Not able to get book"));
    }
    public BookResponse deleteBookById(long bookId) {
         return bookRepo.findById(bookId)
                 .map(book->{
                     bookRepo.delete(book);
                     return bookMapper.mapToBookResponse(book);
                 }).orElseThrow(()->new BookNotFoundByIdException("Not able to delete book"));
    }

    public List<BookResponse> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map(book-> {
                    return bookMapper.mapToBookResponse(book);
                }).toList();
    }

    public BookResponse changeBookPrice(long bookId, double price) {
        return bookRepo.findById(bookId)
                .map(book->{
                    book.setPrice(price);
                    book = bookRepo.save(book);
                    return bookMapper.mapToBookResponse(book);
                }).orElseThrow(() -> new BookNotFoundByIdException("Unable to change price"));
    }

    public BookResponse changeBookQuantity(long bookId, int quantity) {
        return bookRepo.findById(bookId)
                .map(book->{
                    book.setQuantity(quantity);
                    book = bookRepo.save(book);
                    return bookMapper.mapToBookResponse(book);
                }).orElseThrow(() -> new BookNotFoundByIdException("Unable to change quantity"));
    }

}
