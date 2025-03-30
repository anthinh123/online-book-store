package com.thinh.onlinebookstore.service;

import com.thinh.onlinebookstore.dto.CustomerDto;
import com.thinh.onlinebookstore.entity.Customer;
import com.thinh.onlinebookstore.mapper.CustomerMapper;
import com.thinh.onlinebookstore.repository.CustomerRepository;
import com.thinh.onlinebookstore.requestdto.UpdateUserProfileRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void updateCustomerProfile(UpdateUserProfileRequest userProfileRequest, long userId) {
        Customer customer = customerRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + userId));

        if (userProfileRequest.getName() != null) {
            customer.setName(userProfileRequest.getName());
        }
        if (userProfileRequest.getPhoneNumber() != null) {
            customer.setPhoneNumber(userProfileRequest.getPhoneNumber());
        }

        if (userProfileRequest.getEmail() != null) {
            customer.setEmail(userProfileRequest.getEmail());
        }

        customerRepository.save(customer);
    }

    public CustomerDto getCustomerProfile(Long userId) {
        Customer customer = customerRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + userId));

        return CustomerMapper.toDto(customer);
    }
}
