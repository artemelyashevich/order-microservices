package com.elyashevich.customer_service.service;

import com.elyashevich.customer_service.domain.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(String id);

    List<Customer> getAll();

    Customer create(Customer customer);

    Customer update(String id, Customer customer);

    void delete(String id);
}
