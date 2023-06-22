package com.doma.bookmanagementsystem.controller;

import com.doma.bookmanagementsystem.domain.Book;
import com.doma.bookmanagementsystem.dto.AddBookRequest;
import com.doma.bookmanagementsystem.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        bookRepository.deleteAll();
    }

    @Test
    @DisplayName("addBook: 책 추가 성공")
    public void addBook() throws Exception {
        // given
        final String url = "/bookmanagementsystem/books";
        final String title = "title";
        final String author = "author";
        final String pulbisher = "publisher";
        final Date pulicationDate = new Date(122, 1, 2);
        final AddBookRequest request = new AddBookRequest(title, author, pulbisher, pulicationDate);
        final String requestBody = objectMapper.writeValueAsString(request);
        // when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));
        // then
        result.andExpect(status().isCreated());

        List<Book> books = bookRepository.findAll();

        assertThat(books.size()).isEqualTo(1);
        assertThat(books.get(0).getTitle()).isEqualTo(title);
        assertThat(books.get(0).getPublicationDate()).isEqualTo(pulicationDate);

    }
}