package com.bridgelabz.bsa.bookservice.repository;

import com.bridgelabz.bsa.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
