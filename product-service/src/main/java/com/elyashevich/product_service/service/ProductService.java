package com.elyashevich.product_service.service;

import com.elyashevich.product_service.domain.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(String id);

    Product create(Product product);

    Product update(String id, Product product);

    void delete(String id);
}
