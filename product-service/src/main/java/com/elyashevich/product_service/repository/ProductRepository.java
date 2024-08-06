package com.elyashevich.product_service.repository;

import com.elyashevich.product_service.domain.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
