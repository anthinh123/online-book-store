package com.thinh.onlinebookstore.book.service;

import com.thinh.onlinebookstore.book.dto.BookDto;
import com.thinh.onlinebookstore.book.mapper.BookMapper;
import com.thinh.onlinebookstore.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
