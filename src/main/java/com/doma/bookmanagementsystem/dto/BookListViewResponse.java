package com.doma.bookmanagementsystem.dto;

import com.doma.bookmanagementsystem.domain.Book;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BookListViewResponse {

    private final Long id;
    private final String title;
    private final String author;
    private final String publisher;
    private final LocalDate publicationDate;

    public BookListViewResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.publicationDate = book.getPublicationDate();
    }
}
