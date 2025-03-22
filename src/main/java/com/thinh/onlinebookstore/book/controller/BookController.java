package com.thinh.onlinebookstore.book.controller;

import com.thinh.onlinebookstore.book.dto.BookDto;
import com.thinh.onlinebookstore.book.service.BookService;
import com.thinh.onlinebookstore.common.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<BookDto>>> getAllBooks() {
        return ApiResponse.success(bookService.getAllBooks());
    }
}
