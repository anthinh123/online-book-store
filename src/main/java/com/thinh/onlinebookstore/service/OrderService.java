package com.thinh.onlinebookstore.service;

import com.thinh.onlinebookstore.dto.OrderDto;
import com.thinh.onlinebookstore.entity.*;
import com.thinh.onlinebookstore.mapper.OrderMapper;
import com.thinh.onlinebookstore.repository.BookRepository;
import com.thinh.onlinebookstore.repository.CustomerRepository;
import com.thinh.onlinebookstore.repository.OrderItemRepository;
import com.thinh.onlinebookstore.repository.OrderRepository;
import com.thinh.onlinebookstore.requestdto.CheckoutItemRequest;
import com.thinh.onlinebookstore.requestdto.CheckoutRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional
    public void order(@NotNull CheckoutRequest checkoutRequest, long userId) {
        // 1. Retrieve Customer
        Customer customer = customerRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + userId));

        // 2. Create Order
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING); // Set initial status
        order.setOrderItems(new ArrayList<>());
        order = orderRepository.save(order);

        // 3. Process Order Items
        double totalPrice = 0;
        List<OrderItem> orderItems = new ArrayList<>();
        for (CheckoutItemRequest item : checkoutRequest.getCheckoutItemRequests()) {
            // 3.1 Retrieve Book
            Book book = bookRepository.findById(item.getBookId())
                    .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + item.getBookId()));

            // 3.2 Check Stock
            // Assume that the books is unlimited to simplify flow

            // 3.3 Create Order Item
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setBook(book);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(book.getPrice());
            orderItems.add(orderItem);

            // 3.4 Update Total Price
            totalPrice += book.getPrice() * item.getQuantity();
        }

        // 4. Set Order Details
        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);

        // 5. Save Order
        orderRepository.save(order);

    }

    public OrderDto getOrderById(long orderId, long userId) {
        //1. Check if order exist
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));
        //2. Check if the order belong to the user
        if (order.getCustomer().getId() != userId) {
            throw new RuntimeException("You are not authorized to view this order");
        }

        return OrderMapper.toDto(order);
    }

}
