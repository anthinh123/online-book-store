package com.thinh.onlinebookstore.controller;

import com.thinh.onlinebookstore.dto.BookDto;
import com.thinh.onlinebookstore.service.BookService;
import com.thinh.onlinebookstore.common.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<BookDto>>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ApiResponse.success(bookService.getAllBooks(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookDto>> getBookById(@PathVariable Long id) {
        return ApiResponse.success(bookService.getBookById(id));
    }

    @GetMapping("category/{id}")
    public ResponseEntity<ApiResponse<Page<BookDto>>> getBookByCategory(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ApiResponse.success(bookService.getBookByCategory(id, page, size));
    }

    @GetMapping("author/{id}")
    public ResponseEntity<ApiResponse<Page<BookDto>>> getBookByAuthor(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ApiResponse.success(bookService.getBookByAuthor(id, page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<BookDto>>> searchBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String query) {
        return ApiResponse.success(bookService.searchBooks(query, page, size));
    }

}
