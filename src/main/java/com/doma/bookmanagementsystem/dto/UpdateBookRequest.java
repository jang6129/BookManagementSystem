package com.doma.bookmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateBookRequest {
    private String title;
    private String author;
    private String publisher;
    private LocalDate pulbicationDate;
}
