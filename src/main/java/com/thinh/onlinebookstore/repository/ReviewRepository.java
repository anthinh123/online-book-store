package com.thinh.onlinebookstore.repository;

import com.thinh.onlinebookstore.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByIdAndCustomer_Id(Long id, Long userId);
}
