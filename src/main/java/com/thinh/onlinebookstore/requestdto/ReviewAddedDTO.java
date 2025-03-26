package com.thinh.onlinebookstore.requestdto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewAddedDTO {
    @NotNull(message = "Book ID is required")
    private long bookId;

    @NotBlank
    @Size(max = 1000, message = "Comment must be less than or equal to 1000 characters")
    private String comment;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private int rating;
}
