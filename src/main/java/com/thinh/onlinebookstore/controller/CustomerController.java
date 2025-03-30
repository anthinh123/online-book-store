package com.thinh.onlinebookstore.controller;

import com.thinh.onlinebookstore.common.ApiResponse;
import com.thinh.onlinebookstore.dto.CustomerDto;
import com.thinh.onlinebookstore.requestdto.UpdateUserProfileRequest;
import com.thinh.onlinebookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.thinh.onlinebookstore.util.JwtUtil.USER_ID_CLAIM;

@RestController
@RequestMapping("api/v1/customer_profile")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiResponse<CustomerDto>> getUserProfile(@RequestAttribute(USER_ID_CLAIM) Long userId) {
        CustomerDto customer = customerService.getCustomerProfile(userId);
        return ApiResponse.success(customer);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<String>> updateUser(@RequestAttribute(USER_ID_CLAIM) Long userId, @RequestBody UpdateUserProfileRequest updateUserProfileRequest) {
        customerService.updateCustomerProfile(updateUserProfileRequest, userId);
        return ApiResponse.success("User updated successfully!");
    }
}
