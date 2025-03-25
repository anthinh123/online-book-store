package com.thinh.onlinebookstore.mapper;

import com.thinh.onlinebookstore.dto.AuthorDto;
import com.thinh.onlinebookstore.entity.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorMapper {

    public static AuthorDto toDto(Author author) {
        if (author == null) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setBiography(author.getBiography());
        return authorDto;
    }

    public Author toEntity(AuthorDto authorDto) {
        if (authorDto == null) {
            return null;
        }

        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setBiography(authorDto.getBiography());
        return author;
    }

    public List<AuthorDto> toDtoList(List<Author> authorList) {
        if (authorList == null) {
            return null;
        }
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for (Author author : authorList) {
            authorDtoList.add(toDto(author));
        }
        return authorDtoList;
    }

    public List<Author> toEntityList(List<AuthorDto> authorDtoList) {
        if (authorDtoList == null) {
            return null;
        }
        List<Author> authorList = new ArrayList<>();
        for (AuthorDto authorDto : authorDtoList) {
            authorList.add(toEntity(authorDto));
        }
        return authorList;
    }
}
