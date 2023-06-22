package com.doma.bookmanagementsystem.controller;

import com.doma.bookmanagementsystem.domain.Book;
import com.doma.bookmanagementsystem.dto.AddBookRequest;
import com.doma.bookmanagementsystem.dto.BookResponse;
import com.doma.bookmanagementsystem.dto.UpdateBookRequest;
import com.doma.bookmanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/bms/books")
    public ResponseEntity<Book> addBook(@RequestBody AddBookRequest request) {
        Book savedBook = bookService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBook);
    }

    @GetMapping("/bms/books")
    public ResponseEntity<List<BookResponse>> findAllBooks() {
        List<BookResponse> books = bookService.findAll()
                .stream()
                .map(BookResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(books);
    }

    @GetMapping("/bms/books/{id}")
    public ResponseEntity<BookResponse> findBook(@PathVariable long id) {
        Book book = bookService.findById(id);

        return ResponseEntity.ok()
                .body(new BookResponse(book));
    }

    @DeleteMapping("/bms/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        bookService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/bms/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id,
                                           @RequestBody UpdateBookRequest request) {
        Book updateBook = bookService.update(id, request);

        return ResponseEntity.ok()
                .body(updateBook);
    }


}
