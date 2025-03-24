package com.thinh.onlinebookstore.mapper;

import com.thinh.onlinebookstore.dto.ReviewDto;
import com.thinh.onlinebookstore.entity.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewMapper {
    public ReviewDto toDto(Review review) {
        if (review == null) {
            return null;
        }

        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setBookId(review.getBook().getId());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());
        return reviewDto;
    }

    public Review toEntity(ReviewDto reviewDto) {
        if (reviewDto == null) {
            return null;
        }

        Review review = new Review();
        review.setId(reviewDto.getId());
        // need to fetch the Book entity using the bookId.
        // This requires a service or repository. For now, I'll leave this commented out.
        // review.setBook(book);
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        return review;
    }

    public List<ReviewDto> toDtoList(List<Review> reviewList) {
        if (reviewList == null) {
            return null;
        }
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review review : reviewList) {
            reviewDtoList.add(toDto(review));
        }
        return reviewDtoList;
    }

    public List<Review> toEntityList(List<ReviewDto> reviewDtoList) {
        if (reviewDtoList == null) {
            return null;
        }
        List<Review> reviewList = new ArrayList<>();
        for (ReviewDto reviewDto : reviewDtoList) {
            reviewList.add(toEntity(reviewDto));
        }
        return reviewList;
    }
}
