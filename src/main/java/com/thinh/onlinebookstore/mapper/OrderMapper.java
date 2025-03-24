package com.thinh.onlinebookstore.mapper;

import com.thinh.onlinebookstore.dto.OrderDto;
import com.thinh.onlinebookstore.dto.OrderItemDto;
import com.thinh.onlinebookstore.entity.Order;
import com.thinh.onlinebookstore.entity.OrderItem;
import com.thinh.onlinebookstore.entity.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    // Order to OrderDto
    public OrderDto toDto(Order order) {
        if (order == null) {
            return null;
        }

        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setCustomerId(order.getCustomer().getId()); // Assuming you only need the ID
        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setTotalPrice(order.getTotalPrice());
        if (order.getStatus() != null) {
            orderDto.setStatus(order.getStatus().name());
        }

        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        if(order.getOrderItems() != null) {
            for (OrderItem orderItem : order.getOrderItems()) {
                orderItemDtos.add(toOrderItemDto(orderItem));
            }
        }
        orderDto.setOrderItems(orderItemDtos);
        return orderDto;
    }

    // OrderItem to OrderItemDto
    private OrderItemDto toOrderItemDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setBookId(orderItem.getBook().getId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setPrice(orderItem.getPrice());
        return orderItemDto;
    }

    // Order to Entity
    public Order toEntity(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Order order = new Order();
        order.setId(orderDto.getId());
        //  need to fetch the Customer entity using the customerId.
        //  This requires a service or repository.  For now, I'll leave this commented out.
        // order.setCustomer(customer);
        order.setOrderDate(orderDto.getOrderDate());
        order.setTotalPrice(orderDto.getTotalPrice());
        // You would need to convert the String back to the Enum.  You might need a null check
        if (orderDto.getStatus() != null) {
            order.setStatus(Enum.valueOf(OrderStatus.class, orderDto.getStatus()));
        }

        List<OrderItem> orderItems = new ArrayList<>();
        if (orderDto.getOrderItems() != null) {
            for (OrderItemDto orderItemDto : orderDto.getOrderItems()) {
                orderItems.add(toOrderItemEntity(orderItemDto));
            }
        }
        order.setOrderItems(orderItems);
        return order;
    }

    private OrderItem toOrderItemEntity(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
        //  need to fetch the Book entity using the bookId.
        //  This requires a service or repository.  For now, I'll leave this commented out.
        //orderItem.setBook(book);
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice(orderItemDto.getPrice());
        return orderItem;
    }

    // List of Order to List of OrderDto
    public List<OrderDto> toDtoList(List<Order> orderList) {
        if (orderList == null) {
            return null;
        }

        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            orderDtoList.add(toDto(order));
        }
        return orderDtoList;
    }

    // List of OrderDto to List of Order
    public List<Order> toEntityList(List<OrderDto> orderDtoList) {
        if (orderDtoList == null) {
            return null;
        }
        List<Order> orderList = new ArrayList<>();
        for (OrderDto orderDto : orderDtoList) {
            orderList.add(toEntity(orderDto));
        }
        return orderList;
    }
}
