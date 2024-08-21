package com.elyashevich.product_service.domain.order;

import com.elyashevich.product_service.web.dto.CustomerDto;
import com.elyashevich.product_service.web.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    private ProductDto productDto;

    private CustomerDto customerDto;
}
