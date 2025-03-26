package com.thinh.onlinebookstore.mapper;

import com.thinh.onlinebookstore.dto.ReviewDto;
import com.thinh.onlinebookstore.entity.Book;
import com.thinh.onlinebookstore.entity.Customer;
import com.thinh.onlinebookstore.entity.Review;
import com.thinh.onlinebookstore.requestdto.ReviewAddedDTO;

public class ReviewMapper {
    public static ReviewDto toDto(Review review) {
        if (review == null) {
            return null;
        }

        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setBookId(review.getBook().getId());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());
        reviewDto.setCustomerId(review.getCustomer().getId());
        return reviewDto;
    }

    public static Review toEntity(ReviewDto reviewDto, Book book, Customer customer) {
        if (reviewDto == null) {
            return null;
        }

        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setBook(book);
        review.setCustomer(customer);
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        return review;
    }

    public static Review toEntity(ReviewAddedDTO reviewDto, Book book, Customer customer) {
        if (reviewDto == null) {
            return null;
        }
        Review review = new Review();
        review.setBook(book);
        review.setCustomer(customer);
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        return review;
    }
}
