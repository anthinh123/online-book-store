package com.thinh.onlinebookstore.controller;

import com.thinh.onlinebookstore.common.ApiResponse;
import com.thinh.onlinebookstore.dto.AuthorDto;
import com.thinh.onlinebookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<AuthorDto>>> getAllAuthors() {
        return ApiResponse.success(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AuthorDto>> getAuthorById(@PathVariable Long id) {
        return ApiResponse.success(authorService.getAuthorById(id));
    }
}
