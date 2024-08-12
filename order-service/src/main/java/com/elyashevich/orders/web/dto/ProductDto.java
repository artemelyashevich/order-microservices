package com.elyashevich.orders.web.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String id;
    private String name;
    private Integer quantity;
    private Double price;
}
