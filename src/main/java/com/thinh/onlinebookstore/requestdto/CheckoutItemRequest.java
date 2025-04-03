package com.thinh.onlinebookstore.requestdto;

import lombok.Data;

@Data
public class CheckoutItemRequest {
    private long bookId;
    private int quantity;
}

