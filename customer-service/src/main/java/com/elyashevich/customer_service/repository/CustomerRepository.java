package com.elyashevich.customer_service.repository;

import com.elyashevich.customer_service.domain.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
