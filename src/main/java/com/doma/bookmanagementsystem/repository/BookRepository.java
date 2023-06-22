package com.doma.bookmanagementsystem.repository;

import com.doma.bookmanagementsystem.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
