package com.thinh.onlinebookstore.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Long id;

    private String title;

    private String author;

    private String description;

    private long price;
}