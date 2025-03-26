package com.thinh.onlinebookstore.service;

import com.thinh.onlinebookstore.dto.ReviewDto;
import com.thinh.onlinebookstore.entity.Book;
import com.thinh.onlinebookstore.entity.Customer;
import com.thinh.onlinebookstore.entity.Review;
import com.thinh.onlinebookstore.mapper.ReviewMapper;
import com.thinh.onlinebookstore.repository.BookRepository;
import com.thinh.onlinebookstore.repository.CustomerRepository;
import com.thinh.onlinebookstore.repository.ReviewRepository;
import com.thinh.onlinebookstore.requestdto.ReviewAddedDTO;
import com.thinh.onlinebookstore.requestdto.ReviewUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void addReview(ReviewAddedDTO reviewDto) {
        Book book = bookRepository.findById(reviewDto.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + reviewDto.getBookId()));

        // TODO hard code for now. Need to get from the token
        long userId = 1;
        Customer customer = customerRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + userId));

        reviewRepository.save(ReviewMapper.toEntity(reviewDto, book, customer));
    }

    @Transactional
    public void updateReview(ReviewUpdateDTO reviewUpdateDTO) {
        // TODO hard code for now. Need to get from the token
        long userId = 1;

        Review existingReview = reviewRepository.findByIdAndCustomer_Id(reviewUpdateDTO.getId(), userId)
                .orElseThrow(() -> new EntityNotFoundException("Review not found or you do not have permission to update it."));

        existingReview.setComment(reviewUpdateDTO.getComment());
        existingReview.setRating(reviewUpdateDTO.getRating());

        reviewRepository.save(existingReview);
    }


}
