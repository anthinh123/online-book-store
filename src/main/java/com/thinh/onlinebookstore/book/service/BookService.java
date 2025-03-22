package com.thinh.onlinebookstore.book.service;

import com.thinh.onlinebookstore.book.dto.BookDto;
import com.thinh.onlinebookstore.book.entity.Book;
import com.thinh.onlinebookstore.book.mapper.BookMapper;
import com.thinh.onlinebookstore.book.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    public Page<BookDto> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> bookPage = bookRepository.findAll(pageable);
        return bookPage.map(BookMapper::mapToDto);
    }

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        return BookMapper.mapToDto(book);
    }

    public Page<BookDto> searchBooks(String query, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> bookPage = bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(query, query, pageable);
        return bookPage.map(BookMapper::mapToDto);
    }

}
