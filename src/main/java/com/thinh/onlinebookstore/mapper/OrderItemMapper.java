package com.thinh.onlinebookstore.mapper;

import com.thinh.onlinebookstore.dto.OrderItemDto;
import com.thinh.onlinebookstore.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemMapper {
    public OrderItemDto toDto(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setBookId(orderItem.getBook().getId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setPrice(orderItem.getPrice());
        return orderItemDto;
    }

    public OrderItem toEntity(OrderItemDto orderItemDto) {
        if (orderItemDto == null) {
            return null;
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
        //  You need to fetch the Book entity.
        // orderItem.setBook(book);
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice(orderItemDto.getPrice());
        return orderItem;
    }

    public List<OrderItemDto> toDtoList(List<OrderItem> orderItemList) {
        if (orderItemList == null) {
            return null;
        }
        List<OrderItemDto> orderItemDtoList = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            orderItemDtoList.add(toDto(orderItem));
        }
        return orderItemDtoList;
    }

    public List<OrderItem> toEntityList(List<OrderItemDto> orderItemDtoList) {
        if (orderItemDtoList == null) {
            return null;
        }
        List<OrderItem> orderItemList = new ArrayList<>();
        for (OrderItemDto orderItemDto : orderItemDtoList) {
            orderItemList.add(toEntity(orderItemDto));
        }
        return orderItemList;
    }
}
