package com.elyashevich.customer_service.service.impl;

import com.elyashevich.customer_service.domain.entity.Customer;
import com.elyashevich.customer_service.repository.CustomerRepository;
import com.elyashevich.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer getById(String id) {
        return this.customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer with such id = %s was not found".formatted(id)));
    }

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer update(String id, Customer customer) {
        final var oldCustomer = this.getById(id);
        oldCustomer.setName(customer.getName());
        oldCustomer.setPhone(customer.getPhone());
        oldCustomer.setEmail(customer.getEmail());
        return this.customerRepository.save(oldCustomer);
    }

    @Override
    public void delete(String id) {
        final var customer = this.getById(id);
        this.customerRepository.delete(customer);
    }
}
