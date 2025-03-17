package com.thinh.onlinebookstore.book.repository;

import com.thinh.onlinebookstore.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
