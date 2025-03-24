package com.thinh.onlinebookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private Long customerId;
    private List<OrderItemDto> orderItems;
    private LocalDateTime orderDate;
    private double totalPrice;
    private String status;

}
