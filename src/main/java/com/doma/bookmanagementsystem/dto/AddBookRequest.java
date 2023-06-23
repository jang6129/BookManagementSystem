package com.doma.bookmanagementsystem.dto;

import com.doma.bookmanagementsystem.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBookRequest {

    private String title;
    private String author;
    private String publisher;
    private LocalDate publicationDate;

    public Book toEntity() {
        return Book.builder()
                .title(title)
                .author(author)
                .publisher(publisher)
                .publicationDate(publicationDate)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDate.now())
                .build();
    }

}
