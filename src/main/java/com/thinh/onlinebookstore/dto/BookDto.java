package com.thinh.onlinebookstore.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private List<String> authorNames;
    private List<String> categoryNames;
    private List<ReviewDto> reviews;
    private java.time.LocalDate publicationDate;
}