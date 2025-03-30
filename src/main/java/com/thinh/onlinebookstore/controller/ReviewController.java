package com.thinh.onlinebookstore.controller;

import com.thinh.onlinebookstore.common.ApiResponse;
import com.thinh.onlinebookstore.requestdto.ReviewAddedDTO;
import com.thinh.onlinebookstore.requestdto.ReviewUpdateDTO;
import com.thinh.onlinebookstore.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.thinh.onlinebookstore.util.JwtUtil.USER_ID_CLAIM;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
//    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<ApiResponse<String>> addReview(HttpServletRequest request, @RequestBody ReviewAddedDTO reviewDto) {
        long userId = (Long) request.getAttribute(USER_ID_CLAIM);
        reviewService.addReview(reviewDto, userId);
        return ApiResponse.create("Review added successfully");
    }

    @PutMapping
//    @PreAuthorize("hasRole('ADMIN') or #username == authentication.name")
    public ResponseEntity<ApiResponse<Void>> updateReview(HttpServletRequest request, @RequestBody ReviewUpdateDTO reviewDto) {
        long userId = (Long) request.getAttribute(USER_ID_CLAIM);
        reviewService.updateReview(reviewDto, userId);
        return ApiResponse.success();
    }
}
