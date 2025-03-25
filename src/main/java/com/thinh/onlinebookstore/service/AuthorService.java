package com.thinh.onlinebookstore.service;

import com.thinh.onlinebookstore.dto.AuthorDto;
import com.thinh.onlinebookstore.entity.Author;
import com.thinh.onlinebookstore.mapper.AuthorMapper;
import com.thinh.onlinebookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDto> getAllAuthors() {
        List<Author> categories = authorRepository.findAll();
        return categories.stream().map(AuthorMapper::toDto).toList();
    }

    public AuthorDto getAuthorById(Long id) {
        Author category = authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
        return AuthorMapper.toDto(category);
    }
}
