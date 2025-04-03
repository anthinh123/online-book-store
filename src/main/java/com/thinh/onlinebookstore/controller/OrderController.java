package com.thinh.onlinebookstore.controller;

import com.thinh.onlinebookstore.common.ApiResponse;
import com.thinh.onlinebookstore.dto.OrderDto;
import com.thinh.onlinebookstore.requestdto.CheckoutRequest;
import com.thinh.onlinebookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.thinh.onlinebookstore.util.JwtUtil.USER_ID_CLAIM;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> order(@Valid @RequestBody CheckoutRequest checkoutRequest, @RequestAttribute(USER_ID_CLAIM) Long userId) {
        orderService.order(checkoutRequest, userId);
        return ApiResponse.success("Ordered successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderDto>> getOrderById(@PathVariable long id, @RequestAttribute(USER_ID_CLAIM) Long userId) {
        OrderDto order = orderService.getOrderById(id, userId);
        return ApiResponse.success(order);
    }
}
