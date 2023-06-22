package com.doma.bookmanagementsystem.dto;

import com.doma.bookmanagementsystem.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BookViewResponse {

    private Long id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publicationDate;
    private LocalDateTime createdAt;

    public BookViewResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.publicationDate = book.getPublicationDate();
        this.createdAt = book.getCreatedAt();
    }
}
