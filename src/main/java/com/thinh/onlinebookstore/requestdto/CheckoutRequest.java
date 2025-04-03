package com.thinh.onlinebookstore.requestdto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CheckoutRequest {
    @NotNull
    @NotEmpty
    private List<CheckoutItemRequest> checkoutItemRequests;
}