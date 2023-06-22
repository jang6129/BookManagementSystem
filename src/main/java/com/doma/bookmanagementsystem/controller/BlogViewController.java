package com.doma.bookmanagementsystem.controller;

import com.doma.bookmanagementsystem.domain.Book;
import com.doma.bookmanagementsystem.dto.BookListViewResponse;
import com.doma.bookmanagementsystem.dto.BookViewResponse;
import com.doma.bookmanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BookService bookService;

    @GetMapping("/books")
    public String getArticles(Model model) {
        List<BookListViewResponse> books = bookService.findAll().stream()
                .map(BookListViewResponse::new)
                .toList();
        model.addAttribute("books", books);

        return "bookList";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", new BookViewResponse(book));

        return "book";
    }

}
