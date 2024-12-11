package com.bridgelabz.bsa.bookservice.responsedto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {

    private Long bookId;
    private String bookName;
    private String authorName;
    private String description;
    private Double price;
    private int quantity;
}
