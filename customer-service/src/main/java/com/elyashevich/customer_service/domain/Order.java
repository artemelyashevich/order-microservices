package com.elyashevich.customer_service.domain;

import com.elyashevich.customer_service.web.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String customerId;

    private String productId;

    private CustomerDto customer;

    private Event event;
}
