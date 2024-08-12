package com.elyashevich.orders.web.dto;

import com.elyashevich.orders.domain.order.OrderStatus;

import java.util.List;

public record OrderDto(
        List<ProductDto> products,
        CustomerDto customerDto,
        OrderStatus orderStatus
) {
}
