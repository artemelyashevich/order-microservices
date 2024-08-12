package com.elyashevich.product_service.service.impl;

import com.elyashevich.product_service.domain.entity.Product;
import com.elyashevich.product_service.repository.ProductRepository;
import com.elyashevich.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getById(final String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product with such id = %s was not found".formatted(id)));
    }

    @Override
    public Product create(final Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product update(String id, final Product product) {
        final var oldProduct = this.getById(id);
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setQuantity(product.getQuantity());
        return this.productRepository.save(oldProduct);
    }

    @Override
    public void delete(String id) {
        final var product = this.getById(id);
        this.productRepository.delete(product);
    }
}
