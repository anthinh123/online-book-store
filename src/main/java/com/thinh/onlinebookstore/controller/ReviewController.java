package com.thinh.onlinebookstore.controller;

import com.thinh.onlinebookstore.common.ApiResponse;
import com.thinh.onlinebookstore.requestdto.ReviewAddedDTO;
import com.thinh.onlinebookstore.requestdto.ReviewUpdateDTO;
import com.thinh.onlinebookstore.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addReview(@RequestBody ReviewAddedDTO reviewDto) {
        System.out.println("addReview triggered");
        reviewService.addReview(reviewDto);
        return ApiResponse.create("Review added successfully");
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Void>> updateReview(@RequestBody ReviewUpdateDTO reviewDto) {
        reviewService.updateReview(reviewDto);
        return ApiResponse.success();
    }
}
