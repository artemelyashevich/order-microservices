package com.elyashevich.product_service.kafka;

import com.elyashevich.product_service.domain.entity.Product;
import com.elyashevich.product_service.domain.order.OrderResponse;
import com.elyashevich.product_service.web.dto.CustomerDto;
import com.elyashevich.product_service.web.dto.ProductDto;

public interface KafkaProducerService {

    void sendMessage(OrderResponse orderResponse);
}
