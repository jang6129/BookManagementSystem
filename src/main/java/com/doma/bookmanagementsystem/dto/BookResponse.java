package com.doma.bookmanagementsystem.dto;

import com.doma.bookmanagementsystem.domain.Book;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class BookResponse {

    private final String title;
    private final String author;
    private final String publisher;
    private final LocalDate publicationDate;

    public BookResponse(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.publicationDate = book.getPublicationDate();
    }

}
