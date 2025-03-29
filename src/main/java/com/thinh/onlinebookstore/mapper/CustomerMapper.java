package com.thinh.onlinebookstore.mapper;

import com.thinh.onlinebookstore.dto.CustomerDto;
import com.thinh.onlinebookstore.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public CustomerDto toDto(Customer customer) {
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

    public List<CustomerDto> toDtoList(List<Customer> customerList) {
        if (customerList == null) {
            return null;
        }
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : customerList) {
            customerDtoList.add(toDto(customer));
        }
        return customerDtoList;
    }

    public List<Customer> toEntityList(List<CustomerDto> customerDtoList) {
        if (customerDtoList == null) {
            return null;
        }
        List<Customer> customerList = new ArrayList<>();
        for (CustomerDto customerDto : customerDtoList) {
            customerList.add(toEntity(customerDto));
        }
        return customerList;
    }
}
