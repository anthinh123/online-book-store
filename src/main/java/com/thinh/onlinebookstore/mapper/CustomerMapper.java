package com.thinh.onlinebookstore.mapper;

import com.thinh.onlinebookstore.dto.CustomerDto;
import com.thinh.onlinebookstore.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public static CustomerDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPassword(customer.getPassword());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        return customerDto;
    }

    public Customer toEntity(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setPhoneNumber(customerDto.getPhoneNumber());

        return customer;
    }

}
