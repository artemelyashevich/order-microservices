package com.elyashevich.product_service.domain.order;

import com.elyashevich.product_service.web.dto.CustomerDto;
import lombok.Data;

@Data
public class OrderRequest {

    private CustomerDto dto;
    private String productId;
}
