package com.thinh.onlinebookstore.mapper;

import com.thinh.onlinebookstore.dto.BookDto;
import com.thinh.onlinebookstore.dto.ReviewDto;
import com.thinh.onlinebookstore.entity.Author;
import com.thinh.onlinebookstore.entity.Book;
import com.thinh.onlinebookstore.entity.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookDto toDto(Book book) {
        if (book == null) {
            return null;
        }

        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setDescription(book.getDescription());
        bookDto.setPrice(book.getPrice());
        bookDto.setPublicationDate(book.getPublicationDate());

        if (book.getAuthors() != null) {
            List<String> authorNames = book.getAuthors().stream()
                    .map(Author::getName)
                    .collect(Collectors.toList());
            bookDto.setAuthorNames(authorNames);
        }

        if (book.getCategories() != null) {
            List<String> categoryNames = book.getCategories().stream()
                    .map(Category::getName)
                    .collect(Collectors.toList());
            bookDto.setCategoryNames(categoryNames);
        }

        if (book.getReviews() != null) {
            List<ReviewDto> reviewDtos = book.getReviews().stream()
                    .map(ReviewMapper::toDto)
                    .collect(Collectors.toList());
            bookDto.setReviews(reviewDtos);
        }
        return bookDto;
    }

    public Book toEntity(BookDto bookDto) {
        if (bookDto == null) {
            return null;
        }

        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setPrice(bookDto.getPrice());
        book.setPublicationDate(bookDto.getPublicationDate());

        //  need to fetch the Author and Category entities and set them.
        //  This requires a service or repository. For now, I'll leave this out.
        //  The IDs are in bookDto, but the entities need to be loaded from the database.
        // book.setAuthors(authors);
        // book.setCategories(categories);

        return book;
    }

    public List<BookDto> toDtoList(List<Book> bookList) {
        if (bookList == null) {
            return null;
        }

        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : bookList) {
            bookDtoList.add(toDto(book));
        }
        return bookDtoList;
    }

    public List<Book> toEntityList(List<BookDto> bookDtoList) {
        if (bookDtoList == null) {
            return null;
        }

        List<Book> bookList = new ArrayList<>();
        for (BookDto bookDto : bookDtoList) {
            bookList.add(toEntity(bookDto));
        }
        return bookList;
    }
}

