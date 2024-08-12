package com.elyashevich.product_service.web.controller;

import com.elyashevich.product_service.domain.entity.Product;
import com.elyashevich.product_service.kafka.KafkaProducerService;
import com.elyashevich.product_service.service.ProductService;
import com.elyashevich.product_service.web.dto.ProductDto;
import com.elyashevich.product_service.web.dto.validation.OnCreate;
import com.elyashevich.product_service.web.dto.validation.OnUpdate;
import com.elyashevich.product_service.web.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@Validated
public class MainController {

    private final ProductService productService;
    private final KafkaProducerService kafkaProducerService;

    private final ProductMapper productMapper;

    @GetMapping
    public List<Product> getAll() {
        final var products =  this.productService.getAll();
        this.kafkaProducerService.sendMessage(products.get(0));
         return products;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto create(final @Validated(OnCreate.class) @RequestBody ProductDto dto) {
        final var product = this.productService.create(this.productMapper.toEntity(dto));
        return this.productMapper.toDto(product);
    }

    @GetMapping("{id}")
    public ProductDto getById(final @PathVariable("id") String id) {
        final var product = this.productService.getById(id);
        return this.productMapper.toDto(product);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto update(
            final @PathVariable("id") String id,
            final @Validated(OnUpdate.class) @RequestBody ProductDto dto
    ) {
        final var product = this.productService.update(id, this.productMapper.toEntity(dto));
        return this.productMapper.toDto(product);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable("id") String id) {
        this.productService.delete(id);
    }
}
