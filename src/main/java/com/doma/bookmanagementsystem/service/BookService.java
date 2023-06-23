package com.doma.bookmanagementsystem.service;

import com.doma.bookmanagementsystem.domain.Book;
import com.doma.bookmanagementsystem.dto.AddBookRequest;
import com.doma.bookmanagementsystem.dto.UpdateBookRequest;
import com.doma.bookmanagementsystem.repository.BookRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(AddBookRequest request) {
        return bookRepository.save(request.toEntity());
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(long id) {
        return  bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book update(long id, UpdateBookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        book.update(request.getTitle(), request.getAuthor(), request.getPublisher(), request.getPublicationDate());

        return book;
    }

}
